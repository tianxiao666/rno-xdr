import { Component, ViewChild, ElementRef } from '@angular/core';
import { ExceptionStatService } from './exception-stats.service';
import { SearchValue } from './exception/search-value';
import { FinalSearchCond } from './final-search-cond';
import { Parameter } from './data-table/get-parameter-value';
import { ExcelService } from '../common/export.service';
import { HEADDATA, Head } from './data-table/head-data';

@Component({
  selector: 'xdr-exception-stats',
  templateUrl: 'exception-stats.component.html',
  styleUrls: ['exception-stats.component.scss'],
})
export class ExceptionStatsComponent {
  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
  public isShowExceptionTable: boolean = false;
  private rowsOnPage: any;
  private activePage: any;
  private date1: any;
  private cellType: any;
  private cellInput: any;
  private logicalOperationone: any;
  private indicatorSelectitemone: any;
  private operatorone: any;
  private selone: number;
  private logicalOperationtwo: any;
  private indicatorSelectitemtwo: any;
  private operatortwo: any;
  private seltwo: number;
  private logicalOperationthree: any;
  private indicatorSelectitemthree: any;
  private operatorthree: any;
  private selthree: number;
  private datas: any;

  private dataId = [];
  private dataName = [];

  private _exceptionHeadItems: Head[] = HEADDATA;

  constructor(private _analysisService: ExceptionStatService, private excelService: ExcelService/*,private parseLinks: JhiParseLinks*/) {
    this.excelService = excelService;
  }

  public searchParameterData (e: Parameter) {
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

  public searchExceptionData(e: SearchValue) {
      if (this.date1) {
        if (this.date1 !== e.date1 || this.cellType !== e.cellType) {
          this.activePage = 0;
        }
      }
      this.date1 = e.date1;
      this.cellInput = e.cellInput;
      this.cellType = e.cellType;
      this.logicalOperationone = e.logicalOperationone;
      this.indicatorSelectitemone = e.indicatorSelectitemone;
      this.operatorone = e.operatorone;
      this.selone = e.selone;
      this.logicalOperationtwo = e.logicalOperationtwo;
      this.indicatorSelectitemtwo = e.indicatorSelectitemtwo;
      this.operatortwo = e.operatortwo;
      this.seltwo = e.seltwo;
      this.logicalOperationthree = e.logicalOperationthree;
      this.indicatorSelectitemthree = e.indicatorSelectitemthree;
      this.operatorthree = e.operatorthree;
      this.selthree = e.selthree;
      const finalCond = new FinalSearchCond(
        this.date1,
        this.cellType,
        this.cellInput,
        this.logicalOperationone,
        this.indicatorSelectitemone,
        this.operatorone,
        this.selone,
        this.logicalOperationtwo,
        this.indicatorSelectitemtwo,
        this.operatortwo,
        this.seltwo,
        this.logicalOperationthree,
        this.indicatorSelectitemthree,
        this.operatorthree,
        this.selthree,
        this.rowsOnPage,
        this.activePage,
        'query',
      );
      this.isShowLoading = true;
      this.getData(finalCond);
  }

  public exportExceptionData(e: SearchValue) {
      const exp = new FinalSearchCond(
        e.date1,
        e.cellType,
        e.cellInput,
        e.logicalOperationone,
        e.indicatorSelectitemone,
        e.operatorone,
        e.selone,
        e.logicalOperationtwo,
        e.indicatorSelectitemtwo,
        e.operatortwo,
        e.seltwo,
        e.logicalOperationthree,
        e.indicatorSelectitemthree,
        e.operatorthree,
        e.selthree,
        -1,
        -1,
        'download',
      );
      this.isShowLoading = true;
      this._analysisService.getData(exp)
        .then(data => {
          this.isShowLoading = false;
          if (data.json.length === 0) {
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'block';
            }, 0);
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'none';
            }, 3000);
            return;
          }else {
            // console.log(data.json)
            let key = 0;
            for (const i of this._exceptionHeadItems) {
              this.dataId.push(key);
              key++;
              this.dataName.push(i['header']);
            }
            let dataJ = '[';
            let num = 1;
            for (const i of data.json) {
              dataJ += '{';
              for (let j = 0; j < (this.dataId).length; j++) {
                dataJ += `"${this.dataName[j]}": "${i[this.dataId[j]]}"`;
                if (j < (this.dataId).length - 1) {
                  dataJ += ',';
                }
              }
              dataJ += '}';
              if (num < data.json.length) {
                dataJ += ',';
                num++;
              }
            }
            dataJ += ']';
            this.excelService.exportAsExcelFile(JSON.parse(dataJ), 'exception-stats');
          }
        }).catch(ex => {
        // console.log(e);
        this.isShowLoading = false;
        this.isShowExceptionTable = false;
        setTimeout(() => {
          this.programError.nativeElement.style.display = 'block';
        }, 0);
        setTimeout(() => {
          this.programError.nativeElement.style.display = 'none';
        }, 3000);
        return;
      });
  }

  public pageParameterData() {
    const final = new FinalSearchCond(
      this.date1,
      this.cellType,
      this.cellInput,
      this.logicalOperationone,
      this.indicatorSelectitemone,
      this.operatorone,
      this.selone,
      this.logicalOperationtwo,
      this.indicatorSelectitemtwo,
      this.operatortwo,
      this.seltwo,
      this.logicalOperationthree,
      this.indicatorSelectitemthree,
      this.operatorthree,
      this.selthree,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  private getData(e: FinalSearchCond) {
    this._analysisService.getData(e)
      .then(data => {
        this.isShowLoading = false;
        if (data.json.length === 0) {
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'block';
          }, 0);
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'none';
          }, 3000);
          this.isShowExceptionTable = false;
          return;
        }else {
          const totalItems = data.headers.get('X-Total-Count');
          const dataFinal = [];
          dataFinal.push(data.json);
          dataFinal.push(totalItems);
          dataFinal.push(this.activePage);
          this.datas = dataFinal;
          this.isShowExceptionTable = true;
        }
      }).catch(ex => {
      // console.log(e);
      this.isShowLoading = false;
      this.isShowExceptionTable = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);
      return;
    });
  }

}
