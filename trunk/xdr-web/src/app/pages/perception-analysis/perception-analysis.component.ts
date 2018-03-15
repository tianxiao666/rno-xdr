import { Component, ViewChild, ElementRef } from '@angular/core';
import { SearchValue } from './analysis/search-value';
import { PerceptionAnalysisService } from './perception-analysis.service';

@Component({
  selector: 'xdr-perception-analysis',
  styleUrls: ['./perception-analysis.component.scss'],
  templateUrl: './perception-analysis.component.html',
})
export class PerceptionAnalysisComponent {

  @ViewChild('notFoundData') private notFoundDataDiv: ElementRef;
  @ViewChild('programError') private programError: ElementRef;

  private isShowLoading: boolean = false;
  private isShowEcharts: boolean = false;
  private isShowChart: boolean = false;
  private echartsInstance: any;

  private _chartData: any[] = [
    { name: '1', value: '1', label: 'type' },
  ];
  private echartsOption: any;
  // dataset: any;

  constructor(private _analysisService: PerceptionAnalysisService) {
  }

  public onChartInit(ec) {
    this.echartsInstance = ec;
  }

  public searchForData(e: SearchValue) {
    if (this.echartsInstance) {
      this.echartsInstance.clear();
    }
    this.isShowEcharts = true;
    this.isShowChart = true;
    this.isShowLoading = true;

    this._analysisService.getData(e)
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

        this.createEchartsOption(e);
        this.isShowLoading = false;
      }).catch(ex => {
      console.error(ex);
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

    for (let j = 0; j < 24; j++) {
      xAxis.push(j);
    }

    let num = 0;
    let item = {};
    let tempData = [];
    for (const n of this._chartData) {
      num++;
      tempData.push(n.value);
      // console.log(num + ',' + n.value);

      if (num % 24 === 0) {
        item = {
          name: n.label,
          type: n.chartType === 1 ? 'line' : 'line',
          yAxisIndex: n.chartType === 1 ? 1 : 0,
          smooth: true,
          data: tempData,
        };
        newSeries.push(item);
        item = {};
        tempData = [];
      }
    }

    this.echartsOption = {
      title: {
        text: '',
      },
      tooltip: {
        trigger: 'axis',
        formatter: (a) => {
          // console.log(a);
          const tooltipLength = a.length;
          let tooltipText = '';
          let n = 0;
          for (const o of a) {
            let val;
            for (const d of this._chartData) {
              if (o.seriesName === d.label) {
                val = d.chartType === 1 ? o.value.toFixed(2) : o.value;
              }
            }
            n++;
            if (n === 1) {
              tooltipText += `${o.axisValue}`;
            }
            if (tooltipLength > 10) {
              if (n % 2 === 0) {
                tooltipText += `${o.marker}${o.seriesName}&nbsp;:&nbsp;${val}`;
              } else {
                tooltipText += `<br/>&nbsp;&nbsp;&nbsp;${o.marker}${o.seriesName}&nbsp;:&nbsp;${val}`;
              }
            }else {
              tooltipText += `<br/>${o.marker}${o.seriesName}&nbsp;:&nbsp;${val}`;
            }
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
