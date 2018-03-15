import { Component, ViewChild, ElementRef } from '@angular/core';
import { SearchValue } from './trend/search-value';
import { PerceptionTrendService } from './perception-trend.service';

@Component({
  selector: 'xdr-perception-trend',
  styleUrls: ['./perception-trend.component.scss'],
  templateUrl: './perception-trend.component.html',
})
export class PerceptionTrendComponent {

  @ViewChild('notFoundData')notFoundDataDiv: ElementRef;
  @ViewChild('programError')programError: ElementRef;

  echartsOption = {};
  isShowLoading: boolean = false;
  isShowEcharts: boolean = false;
  isShowChart: boolean = false;
  private echartsInstance: any;

  private _chartData: any[] = [
    { name: '1', value: '1', label: 'type' },
  ];

  constructor(private _trendService: PerceptionTrendService) {
  }
  onChartInit(ec) {
    this.echartsInstance = ec;
  }

  searchForData(e: SearchValue) {
    if (this.echartsInstance) {
      this.echartsInstance.clear();
    }
    this.isShowEcharts = true;
    this.isShowChart = true;
    this.isShowLoading = true;

    this._trendService.getData(e)
      .then(data => {
        if (data.length === 0) {
          this.isShowLoading = false;
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'block';
          }, 0);
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'none';
          }, 3000);
          // console.log(this.isShowLoading);
          return;
        }
        this._chartData = data;
        // console.log("data== "+ this._chartData);

        this.createEchartsOption(e);
        this.isShowLoading = false;
      }).catch(e => {
      console.log(e);
      this.isShowLoading = false;
      this.isShowEcharts = false;
      this.isShowChart = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);
      return;
    });
  }
  private createEchartsOption(e) {

    const legend = [];
    const xAxis = [];
    const newSeries: any = [];
    // console.log('ts:' + e.indicatorSelectItems.length);
    for (const i of e.indicatorSelectItems) {
      legend.push(i.name);
    }
    /*                    */
    const tempXs = [];
    let item1 = {};
    for (const n of this._chartData) {
      const tempX = [];
      const tempData = [];
      let flag = false;
      // console.log("n.name===" + n.name)
      for (const d of n.data) {
        tempX.push(d.name);
        if (String(d.value).indexOf('.') > -1) {
          flag = true;
          tempData.push(d.value * 100);
          // console.log("d.value==="+ d.value +"----"+ d.value * 100);
        }else {
          tempData.push(d.value);
          // console.log("d.value==="+ d.value );
        }
      }
      if (flag) {
        item1 = {
          name: n.name,
          type: n.chartType === 1 ? 'line' : 'line',
          yAxisIndex: 1,
          smooth: true,
          data: tempData,
        };
      }else {
        item1 = {
          name: n.name,
          type: n.chartType === 1 ? 'line' : 'line',
          yAxisIndex: 0,
          smooth: true,
          data: tempData,
        };
      }

      tempXs.push(tempX);
      newSeries.push(item1);
      item1 = {};
    }

    for (const x of tempXs[0]) {
      xAxis.push([x.getFullYear(), x.getMonth() + 1, x.getDate()].join('-'));
    }

    const tempData = [];
    // this.dataset = data;
    // console.log(`newSeries=${newSeries}`);
    // console.log(`dataset=${this.dataset}`);
    this.echartsOption = {
      title: {
        text: '',
      },
      tooltip: {
        trigger: 'axis',
        formatter: (a) => {
          const tip = a[0].name;
          let tooltipText: string = tip;
          let n = 0;
          let i = 0;
          for (const aObj of a) {
          // for (const o of this._chartData) {
            const o = this._chartData[i];
            let val1: any;
            for (const d of o.data) {
              if( String(d.value).indexOf('.') > -1) {
                tempData.push(d.value * 100);
                // console.log("d.value==="+ d.value +"----"+ d.value * 100);
                val1 = (d.value * 100).toFixed(2) + '%';
              }else {
                // console.log("d.value==="+ d.value );
                val1 = d.value;
              }
              const date = new Date(d.name);
              const mon = date.getMonth() + 1;
              const day = date.getDate();
              const nowDay = date.getFullYear() + "-" + (mon < 10 ? mon : mon) + "-" + (day < 10 ?  day : day);
              // console.log( tip + ',' + nowDay);
              if (nowDay.toString() === tip.toString()) {
                if (legend.length > 10) {
                  if (n % 2 === 0) {
                    tooltipText += `<br/>${aObj.marker}${o.name}&nbsp;:&nbsp;${val1}`;
                    n++;
                  } else {
                    tooltipText += `&nbsp;&nbsp;&nbsp;${aObj.marker}${o.name}&nbsp;:&nbsp;${val1}`;
                    n++;
                  }
                } else {
                  tooltipText += `<br/>${aObj.marker}${o.name}&nbsp;:&nbsp;${val1}`;
                  n++;
                }
              }
            }
            i++;
          }
          return tooltipText;
        },
      },
      legend: {
        x: 'center',
        y: 'top',
        data: legend,
      },
      toolbox: {
        y: 'bottom',
        feature: {
          saveAsImage: {},
        },
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        y: 150,
        containLabel: true,
      },
      xAxis: [
        {
          type: 'category',
          boundaryGap: false,
          data: xAxis,
          splitLine: {
            show: false,
          },
        },
      ],
      yAxis: [
        {
          type: 'value',
          name: '数量',
          splitLine: {
            show: false,
          },
        },
        {
          type: 'value',
          max: 100,
          min: 0,
          name: '比率(%)',
          splitLine: {
            show: false,
          },
        },
      ],
      series: newSeries,
    };
  }
}


