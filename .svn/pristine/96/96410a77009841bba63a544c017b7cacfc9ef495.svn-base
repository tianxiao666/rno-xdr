import { Component, ViewChild, ElementRef } from '@angular/core';
import { DataStatisticsService } from './data-statistics.service';
import { SearchValue } from './condition/search-value';
import { CommonSearchValue } from './common-search-value';
import { TableSearchValue } from './table-search-value';
import { Parameter } from './data-table/get-parameter-value';

@Component({
  selector: 'xdr-data-stats',
  templateUrl: './data-statistics.component.html',
  styleUrls: ['./data-statistics.component.scss'],
})

export class DataStatisticsComponent {
  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
  public isShowDetailTable: boolean = false;
  private isShowEcharts: boolean = false;
  private isShowAnalysisEcharts: boolean = false;
  private rowsOnPage: any;
  private activePage: any;
  private date: any;
  private area: any;
  private device: any;
  private inputValue: any;
  private data: any;
  private chartOption2: any;
  private chartOption3: any;

  constructor(private _analysisService: DataStatisticsService) {
  }

  public searchParameterData(e: Parameter) {
    if (this.rowsOnPage) {
      if (this.rowsOnPage !== e.rowsOnPage) {
        this.activePage = 0;
        this.rowsOnPage = e.rowsOnPage;
      }else {
        this.activePage = e.activePage;
      }
    }else {
      this.activePage = e.activePage;
      this.rowsOnPage = e.rowsOnPage;
    }
  }

  public statisticsSearch(e: SearchValue) {
    const chartSearch = new CommonSearchValue(
      e.date,
      e.area,
      e.device,
      e.inputValue,
    );
    if (e.selectValue === 'analysis') {
      this.isShowLoading = true;
      // console.info(e.inputValue);
      this.getAnalysisChart(chartSearch);
    }else {
        if (e.showType === 'table') {
          if (this.area) {
            if (this.area !== e.area || this.date !== e.date || this.device !== e.device || this.inputValue !== e.inputValue) {
              this.activePage = 0;
            }
          }
          this.date = e.date;
          this.area = e.area;
          this.inputValue = e.inputValue;
          this.device = e.device;
          const tableSearch = new TableSearchValue(
            this.date,
            this.area,
            this.device,
            this.inputValue,
            this.rowsOnPage,
            this.activePage,
          );
          // console.log(final);
          this.isShowLoading = true;
          this.getTableData(tableSearch);
        }else {
          this.isShowLoading = true;
          this.getChartData(chartSearch);
        }
    }
  }

  public pageParameterData() {
    const tableSearch = new TableSearchValue(
      this.date,
      this.area,
      this.device,
      this.inputValue,
      this.rowsOnPage,
      this.activePage,
    );
    this.getTableData(tableSearch);
  }

  private getTableData(e: TableSearchValue) {
    /*this._analysisService.getData(e)
      .then(data => {
        this.isShowLoading = false;
        if (data['content'].length === 0) {
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'block';
          }, 0);
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'none';
          }, 3000);
          this.isShowDetailTable = false;
          return;
        }else {
          const dataFinal = [];
          dataFinal.push(data['content']);
          dataFinal.push(data['totalElements']);
          dataFinal.push(this.activePage);
          this.data = dataFinal;
          // console.log(this.data);
          this.isShowDetailTable = true;
        }
      }).catch(ex => {
      // console.log(ex);
      this.isShowLoading = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);
      return;
    });*/

    let contentJson = '[{';
    contentJson += `"type": "阻塞干扰",
                   "count": "233"
                   `;
    contentJson += '}]';

    const dataFinal = [];
    dataFinal.push(JSON.parse(contentJson));
    dataFinal.push(11);
    dataFinal.push(0);
    this.isShowEcharts = false;
    this.isShowAnalysisEcharts = false;
    this.isShowLoading = false;
    this.data = dataFinal;
    // console.log(this.data);
    this.isShowDetailTable = true;
  }

  private getChartData(e: CommonSearchValue) {
    this.isShowLoading = false;
    this.isShowAnalysisEcharts = false;
    this.isShowDetailTable = false;
    this.chartOption2 = {
      'color': ['#3398DB'],
      'tooltip': {
        'trigger': 'axis',
        'axisPointer': {      // 坐标轴指示器，坐标轴触发有效
          'type': 'shadow',    // 默认为直线，可选为：'line' | 'shadow'
        },
      },
      'grid': {
        'left': '3%',
        'right': '4%',
        'bottom': '3%',
        'containLabel': true,
      },
      'xAxis': [
        {
          'type': 'category',
          'data': ['阻塞干扰', '外部干扰', '谐波干扰', '互调干扰', '其他干扰'],
          'axisTick': {
            'alignWithLabel': true,
          },
        },
      ],
      'yAxis': [
        {
          'type': 'value',
        },
      ],
      'series': [
        {
          'name': '小区数',
          'type': 'bar',
          'barWidth': '60%',
          'data': [
            3,
            5,
            2,
            4,
            9,
          ],
        },
      ],
    };
    this.isShowEcharts = true;
  }

  private getAnalysisChart(e: CommonSearchValue) {
    this.isShowLoading = false;
    this.isShowEcharts = false;
    this.isShowDetailTable = false;
    const prb = [];
    const textTitleValue = e.inputValue;
    for (let i = 0; i < 10; i++) {
      prb.push(i);
    }
    let textTitle = 'PRB值曲线';
    // console.info(e.inputValue);
    textTitle += textTitleValue;
    this.chartOption3 = {
      'title': {
        'text': textTitle,
        'textStyle': {
          'fontSize': 20,
          'fontWeight': 'bold',
        },
        'top': 10,
        'left': '18%',
      },
      'tooltip': {
        'trigger': 'axis',
      },
      'legend': {
        'data': [
          '最大值',
          '平均值',
        ],
        'top': 10,
        'right': '30%',
      },
      'xAxis': [
        {
          'type': 'category',
          'data': prb,
        },
      ],
      'yAxis': [
        {
          'type': 'value',
        },
      ],
      'series': [
        {
          'name': '最大值',
          'type': 'bar',
          'data': [
            49,
            76,
            23.2,
            25.6,
            76.7,
            135.6,
            162.2,
            32.6,
            20,
          ],
          'itemStyle': {
            'normal': {
              'color': ['#3398DB'],
            },
          },
        },
        {
          'name': '平均值',
          'type': 'line',
          'data': [
            2.6,
            5.9,
            9,
            6.4,
            8.7,
            6,
            2.3,
            3,
            4,
            5,
          ],
        },
      ],
    };
    this.isShowAnalysisEcharts = true;
  }

}
