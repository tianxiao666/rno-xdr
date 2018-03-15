import { Component, ViewChild, ElementRef } from '@angular/core';
import { DataSearchService } from './data-search.service';
import { SearchValue } from './condition/search-value';
import { CommonSearchValue } from './common-search-value';
import { TableSearchValue } from './table-search-value';
import { Parameter } from './data-table/get-parameter-value';
import { ExcelService } from '../common/export.service';

@Component({
  selector: 'xdr-data-search',
  templateUrl: './data-search.component.html',
  styleUrls: ['./data-search.component.scss'],
})

export class DataSearchComponent {
  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
  public isShowDetailTable: boolean = false;
  private isShowEcharts: boolean = false;
  private rowsOnPage: any;
  private activePage: any;
  private date: any;
  private area: any;
  private device: any;
  private assortment: any;
  private cellAreaInput: any;
  private cellNameInput: any;
  private showPRB: any;
  private data: any;
  private dataId: any;
  private dataName: any;
  private chartOption2: any;

  constructor(private _analysisService: DataSearchService, private excelService: ExcelService) {
    this.excelService = excelService;
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

  public search(e: SearchValue) {
    if (this.area) {
      if (this.area !== e.area || this.date !== e.date || this.assortment !== e.assortment || this.cellAreaInput !== e.cellAreaInput || this.cellNameInput !== e.cellNameInput) {
        this.activePage = 0;
      }
    }
    this.date = e.date;
    this.area = e.area;
    this.device = e.device;
    this.assortment = e.assortment;
    this.cellAreaInput = e.cellAreaInput;
    this.cellNameInput = e.cellNameInput;
    this.showPRB = e.showPRB;
    const final = new TableSearchValue(
      this.date,
      this.area,
      this.device,
      this.assortment,
      this.cellAreaInput,
      this.cellNameInput,
      this.showPRB,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    // console.log(final);
    this.isShowLoading = true;
    this.getTableData(final);
  }

  public export(e: SearchValue) {
    const final = new TableSearchValue(
      this.date,
      this.area,
      this.device,
      this.assortment,
      this.cellAreaInput,
      this.cellNameInput,
      this.showPRB,
      this.rowsOnPage,
      this.activePage,
      'download',
    );
    // console.log(final);
    this.isShowLoading = true;
    let contentJson = '[{';
    contentJson += `"date": "2016-08-22",
                   "area": "广州",
                    "device": "HUAWEI",
                    "assortment": "超强干扰",
                    "selector_id": "2333",
                    "selector_name": "财富世纪广场",
                    "enob": "118",
                    "other": "......",
                    "ICM1": "188",
                    "ICMOTHER": "省略省略"
                   `;
    contentJson += '}]';
    const dataFinal = JSON.parse(contentJson);
    if (e.showPRB === 'checked') {
      this.dataId = ['date', 'area', 'device', 'assortment', 'selector_id', 'selector_name', 'enob', 'other', 'ICM1', 'ICMOTHER'];
      this.dataName = ['干扰日期', '地市', '设备', '干扰分类', '小区', '小区名称', '所属频段', '省略的列', 'ICM1', '省略省略'];
    }else {
      this.dataId = ['area', 'date', 'device', 'assortment', 'selector_id', 'selector_name', 'enob', 'other'];
      this.dataName = ['地市', '干扰日期', '设备', '干扰分类', '小区', '小区名称', '所属频段', '省略的列'];
    }
    let dataJ = '[';
    let num = 1;
    for (const i of dataFinal) {
      dataJ += '{';
      for (let j = 0; j < (this.dataId).length; j++) {
        dataJ += `"${this.dataName[j]}": "${i[this.dataId[j]]}"`;
        if (j < (this.dataId).length - 1) {
          dataJ += ',';
        }
      }
      dataJ += '}';
      if (num < dataFinal.length) {
        dataJ += ',';
        num++;
      }
    }
    dataJ += ']';
    this.isShowLoading = false;
    this.excelService.exportAsExcelFile(JSON.parse(dataJ), '上行干扰数据');
  }

  public pageParameterData(e: SearchValue) {
    const tableSearch = new TableSearchValue(
      this.date,
      this.area,
      this.device,
      this.assortment,
      this.cellAreaInput,
      this.cellNameInput,
      this.showPRB,
      this.rowsOnPage,
      this.activePage,
      'query',
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
    contentJson += `"date": "2016-08-22",
                   "area": "广州",
                    "device": "HUAWEI",
                    "assortment": "超强干扰",
                    "selector_id": "2333",
                    "selector_name": "财富世纪广场",
                    "enob": "118",
                    "other": "......",
                    "ICM1": "188",
                    "ICMOTHER": "省略省略"
                   `;
    contentJson += '}]';
    const dataFinal = [];
    dataFinal.push(JSON.parse(contentJson));
    dataFinal.push(11);
    dataFinal.push(0);
    dataFinal.push(e.showPRB);
    this.isShowEcharts = false;
    this.isShowLoading = false;
    this.data = dataFinal;
    // console.log(this.data);
    this.isShowDetailTable = true;
  }

  private getChartData(e: string) {
    for (const icm of this.data[0]) {
      if (e === icm['area']) {
        alert('匹配成功');
      }
    }
    this.isShowLoading = false;
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
          'type': 'line',
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

}
