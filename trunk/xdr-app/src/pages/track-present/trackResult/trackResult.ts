import {Component, ElementRef, ViewChild} from '@angular/core';
import { NavController, NavParams} from 'ionic-angular';
import 'rxjs/add/operator/map';
import {HomePage} from "../../home/home";
import {NetworkService} from "../../common/networkService";
import * as ol from 'openlayers';
import {LayersControl} from "./layers-control";
import {UuLonLat} from "./track-present";

@Component({
  selector: 'page-track-result',
  templateUrl: 'trackResult.html'
})
export class TrackResultPage {

  @ViewChild('map') mapDiv: ElementRef;
  private map: ol.Map;
  private layer: ol.layer.Vector;

  constructor(public navCtrl: NavController
  , public navParams: NavParams
  , public networkService: NetworkService) {
  }

  ionViewDidEnter(){
    this.mapInit();
    let params = this.navParams.get("params");
    let datee = new Date(params.date);
    const beginTime = TrackResultPage.getTimestamp2(
      new Date(datee.getFullYear(),datee.getMonth(),datee.getDate(),params.beginTime));
    const endTime = TrackResultPage.getTimestamp2(
      new Date(datee.getFullYear(),datee.getMonth(),datee.getDate(),params.endTime));
    const uri = `/api/tracks/findByTimeAndImsiAndIndicatorType?beginTime=${beginTime}&endTime=${endTime}&imsi=${params.imsi}&indicatorType=${params.indicatorId}`;
    this.networkService.loadWithTokenByGET(uri)
      .then(data => {
        if ( data.length > 1 ){
          let da = this.combind(data);
          // this.layer.getSource().clear();
          this.setLine(da);
          this.setPoints(da);
          this.map.getView().fit(this.layer.getSource().getExtent(), { size: this.map.getSize() });
        }
        else if ( data.length === 1 ) {
          let da = this.combind(data);
          this.setLine(da);
          this.setPoints(da);
          this.map.getView().fit(this.layer.getSource().getExtent(), { size: this.map.getSize() });
          this.map.getView().setZoom(15);
          return;
        }
      })
      .catch(error => {
        console.log(error);
      })
  }
  private combind(data: UuLonLat[]): Map<number, UuLonLat[]> {
    // console.log(data);
    const result = new Map<number, UuLonLat[]>();
    data.map(v => {
      if (result.get(v.cell)) {
        result.get(v.cell).push(v);
      } else {
        result.set(v.cell, [v]);
      }
    });
    return result;
  }

  mapInit(){
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
    this.map.getView().setZoom(12);
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

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

  public static getTimestamp2(date: Date): number {
    date.setHours(date.getHours() +8, 0, 0, 0);
    return date.setMonth(date.getMonth()+1);
  }
}

