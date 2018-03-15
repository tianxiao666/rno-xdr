import { Component, ViewChild, ElementRef } from '@angular/core';
import { PerceptualDetailsService } from './perception-details.service';
import { SearchValue } from './details/search-value';
import { FinalSearchValue } from './final-search-value';
import { Parameter } from './data-table/get-parameter-value';
import { ExcelService } from '../common/export.service';
import { IndicatorsService } from '../common/indicators.service';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';

@Component({
  selector: 'xdr-perception-details',
  templateUrl: './perception-details.component.html',
  styleUrls: ['./perception-details.component.scss'],
  providers: [IndicatorsService],
})
export class PerceptionDetailsComponent {
  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
  public isShowDetailTable: boolean = false;
  private rowsOnPage: any;
  private activePage: any;
  private date1: any;
  private cellType: any;
  private cellInput: any;
  private interfaceType: any;
  private dataId: any;
  private dataName: any;
  private data: any;

  constructor(private _analysisService: PerceptualDetailsService, private excelService: ExcelService, private _allIndicators: IndicatorsService) {
    this.excelService = excelService;
  }

  private get getIndicatorSelectItems(): IMultiSelectOption[] {
    return this._allIndicators.getIndicatorsSelects(this.interfaceType);
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

  public searchDetailData(e: SearchValue) {
    //noinspection TypeScriptUnresolvedFunction
    if (e.cellType === 'imsi' && e.cellInput === '') {
      alert('imsi is requeried');
    }else {
      if (this.date1) {
        if (this.date1 !== e.date1 || this.cellType !== e.cellType || this.interfaceType !== e.interfaceType) {
          this.activePage = 0;
        }
      }
      this.date1 = e.date1;
      this.cellInput = e.cellInput;
      this.cellType = e.cellType;
      this.interfaceType = e.interfaceType;
      const final = new FinalSearchValue(
        this.date1,
        this.cellType,
        this.cellInput,
        this.interfaceType,
        this.rowsOnPage,
        this.activePage,
        'query',
      );
      // console.log(final);
      this.isShowLoading = true;
      this.getData(final);
    }
  }

  public exportDetailData(e: SearchValue) {
    if (e.cellType === 'imsi' && e.cellInput === '') {
      alert('imsi is requeried');
    }else {
      this.date1 = e.date1;
      this.cellInput = e.cellInput;
      this.cellType = e.cellType;
      this.interfaceType = e.interfaceType;
      const exp = new FinalSearchValue(
        this.date1,
        this.cellType,
        this.cellInput,
        this.interfaceType,
        this.rowsOnPage,
        this.activePage,
        'download',
      );
      this.isShowLoading = true;
      this._analysisService.getData(exp)
        .then(data => {
          this.isShowLoading = false;
          if (data.length === 0) {
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'block';
            }, 0);
            setTimeout(() => {
              this.notFoundDataDiv.nativeElement.style.display = 'none';
            }, 3000);
            return;
          }else {
            const ids = this.getIndicatorSelectItems;
            this.dataId = ['pdate', 'phour', 'cell', 'imei', 'imsi'];
            this.dataName = ['日期', '小时', 'cellid', 'imei', 'imsi'];
            for (const i of ids) {
              this.dataId.push(i['id']);
              this.dataName.push(i['name']);
            }
            let dataJ = '[';
            let num = 1;
            for (const i of data) {
              dataJ += '{';
              for (let j = 0; j < (this.dataId).length; j++) {
                dataJ += `"${this.dataName[j]}": "${i[this.dataId[j]]}"`;
                if (j < (this.dataId).length - 1) {
                  dataJ += ',';
                }
              }
              dataJ += '}';
              if (num < data.length) {
                dataJ += ',';
                num++;
              }
            }
            dataJ += ']';
            this.excelService.exportAsExcelFile(JSON.parse(dataJ), this.interfaceType);
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
      });
    }
  }

  public pageParameterData() {
    const final = new FinalSearchValue(
      this.date1,
      this.cellType,
      this.cellInput,
      this.interfaceType,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  private getData(e: FinalSearchValue) {
    this._analysisService.getData(e)
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
          dataFinal.push(this.interfaceType);
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
    });
  }

}
