import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ExceptionCauseService } from './exception-cause.service';
import { SearchValue } from './cause/search-value.model';
import { INDICATOR_TYPES } from './exception-cause.constants';
import { SelectItem } from '../common/select-item';

@Component({
  selector: 'xdr-exception-cause',
  templateUrl: './exception-cause.component.html',
  styleUrls: ['./exception-cause.component.scss'],
})
export class ExceptionCauseComponent implements OnInit {

  @ViewChild('notFoundData') private notFoundDataDiv: ElementRef;
  @ViewChild('programError') private programError: ElementRef;

  private isShowLoading: boolean = false;
  private isShowEcharts: boolean = false;

  private echartsInstance: any;

  private indicatorTypes: SelectItem[] = INDICATOR_TYPES;

  private echartsOption: any;

  constructor(private exceptionCauseService: ExceptionCauseService) {}

  public ngOnInit() {}

  private onChartInit(ec) {
    this.echartsInstance = ec;
  }

  private searchForData(searchValue: SearchValue) {
    if (this.echartsInstance && this.isShowEcharts) {
      this.echartsInstance.clear();
    }
    this.isShowEcharts = true;
    this.isShowLoading = true;

    this.exceptionCauseService.getData(searchValue)
      .subscribe(
        (data: any[]) => {
          if (data.length === 0) {
            this.isShowLoading = false;
            if (this.echartsInstance && this.isShowEcharts) {
              this.echartsInstance.clear();
            }
            this.isShowEcharts = false;
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'block';
              }, 0);
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'none';
              }, 3000);
            return;
          }
          this.createEchartsOption(searchValue, data);
          this.isShowLoading = false;
          },
        (error: any) => {
          console.error(error);
          this.isShowLoading = false;
          if (this.echartsInstance && this.isShowEcharts) {
            this.echartsInstance.clear();
          }
          this.isShowEcharts = false;
          setTimeout(() => {
            this.programError.nativeElement.style.display = 'block';
            }, 0);
          setTimeout(() => {
            this.programError.nativeElement.style.display = 'none';
            }, 3000);
          return;
        },
        );
  }

  private createEchartsOption(searchValue: SearchValue, chartData: any[]) {
    const legend = [];
    for (const d of chartData) {
      legend.push(d.name);
    }
    const title = `${this.getTitle(searchValue.indicatorType)}异常原因`;

    this.echartsOption = {
      title : {
        text: title,
        x: 'center',
      },
      tooltip : {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)',
      },
      toolbox: {
        feature: {
          saveAsImage: {},
          restore: {},
        },
      },
      legend: {
        orient: 'vertical',
        left: 'left',
        data: legend,
      },
      series : [
        {
          name: title,
          type: 'pie',
          radius : '55%',
          center: ['50%', '60%'],
          data: chartData,
          itemStyle: {
            emphasis: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)',
            },
          },
        },
      ],
    };
  }

  private getTitle(indicatorType: string) {
    let indicatorTypeName = '';
    for (const i of this.indicatorTypes) {
      if (i.value === indicatorType) {
        indicatorTypeName = i.label;
      }
    }
    return indicatorTypeName;
  }
}
