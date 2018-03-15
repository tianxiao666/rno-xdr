import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import * as ol from 'openlayers';
import { LayersControl } from './layers-control';

import { Condition, UuLonLat } from './track-present';
import { TrackPresentService } from './track-present.service';

@Component({
  selector: 'xdr-track-present',
  templateUrl: './track-present.component.html',
  styleUrls: ['./track-present.component.scss'],
})
export class TrackPresentComponent implements OnInit {

  @ViewChild('notFoundDataDiv') private notFoundDataDiv: ElementRef;
  @ViewChild('programError') private programError: ElementRef;
  @ViewChild('map') private mapDiv: ElementRef;
  private isShowLoading: boolean = false;
  private map: ol.Map;
  private layer: ol.layer.Vector;

  constructor(private _service: TrackPresentService) {
  }

  public ngOnInit() {
    this.layer = new ol.layer.Vector(<olx.layer.VectorOptions>{
      title: '指标轨迹层',
      source: new ol.source.Vector(),
    });

    const project = new ol.proj.Projection({
      code: 'EPSG:4326',
      units: 'degrees',
      axisOrientation: 'neu',
      global: true,
    });

    this.map = new ol.Map({
      layers: [
        new ol.layer.Group(<olx.layer.LayerOptions>{
          title: '基础图层',
          layers: [
            new ol.layer.Tile({ source: new ol.source.OSM() }),
          ],
        }),
        new ol.layer.Group(<olx.layer.LayerOptions>{
          title: '数据图层',
          layers: [
            this.layer,
          ],
        }),
      ],
      view: new ol.View({
        projection: project,
      }),
    });

    this.map.addControl(new LayersControl({
      tipLabel: 'label',
    }));
    this.map.setTarget(this.mapDiv.nativeElement);
    this.map.getView().setCenter([113.7607, 23.0361]); // [114, 24]
    this.map.getView().setZoom(14);
  }

  public searchForData(e: Condition) {
    this.isShowLoading = true;
    this._service.getData(e).then(data => {
      // console.log('数据长度：'+data.size);
      this.layer.getSource().clear();
      if (data.size === 0) {
        this.isShowLoading = false;
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'block';
        }, 0);
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'none';
        }, 3000);
        return;
      }else if ( data.size === 1 ) {
        this.setLine(data);
        this.setPoints(data);
        this.map.getView().fit(this.layer.getSource().getExtent(), { size: this.map.getSize() });
        this.map.getView().setZoom(16);
        this.isShowLoading = false;
        return;
      }

      this.setLine(data);
      this.setPoints(data);
      this.map.getView().fit(this.layer.getSource().getExtent(), { size: this.map.getSize() });
      this.isShowLoading = false;
    }).catch(ex => {
      console.error(ex);
      this.isShowLoading = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);
      return;
    });
  }

  private setLine(data: Map<number, UuLonLat[]>): any {
    const coors = [];
    data.forEach(v => {
      coors.push([v[0].lon, v[0].lat]);
    });
    // console.log(coors);
    const line = new ol.geom.LineString(coors);
    const feature = new ol.Feature({
      geometry: line,
    });
    feature.setStyle(new ol.style.Style({
      stroke: new ol.style.Stroke({
        color: 'green',
        width: 2,
      }),
    }));
    this.layer.getSource().addFeature(feature);
  }

  private setPoints(data: Map<number, UuLonLat[]>) {

    data.forEach(v => {
      let success: number = 0;
      v.map(o => {
        if (o.status === 0) {
          success++;
        }
      });

      const anchor = new ol.Feature({
        geometry: new ol.geom.Point([v[0].lon, v[0].lat]),
      });
      // 设置文字style
      anchor.setStyle(new ol.style.Style({
        image: new ol.style.Circle({
          radius: 4,
          fill: new ol.style.Fill({ color: 'rgba(255, 0, 0, 0.1)' }),
          stroke: new ol.style.Stroke({ color: 'red', width: 1 }),
        }),
        text: new ol.style.Text({
          // font: '10px sans-serif',
          stroke: new ol.style.Stroke({ color: '#fff', width: 2 }),
          text: `成功次数:${success} 总次数:${v.length}`,
          offsetY: -10,
          fill: new ol.style.Fill({ color: 'black' }),
        }),
      }));

      this.layer.getSource().addFeature(anchor);
    });
  }

}
