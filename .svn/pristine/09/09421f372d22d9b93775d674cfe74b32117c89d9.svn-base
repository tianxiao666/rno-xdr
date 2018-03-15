import { Component, ViewChild, ElementRef } from '@angular/core';
import { DataImportService } from './data-import.service';
import { SearchValue } from './condition/search-value';
import { FinalSearchValue } from './final-search-value';
import { Parameter } from './data-table/get-parameter-value';

@Component({
  selector: 'xdr-data-import',
  templateUrl: './data-import.component.html',
  styleUrls: ['./data-import.component.scss'],
})

export class DataImportComponent {
  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  @ViewChild('fileUpSuccess') public fileUpSuccess: ElementRef;
  @ViewChild('typeError') public typeError: ElementRef;
  public isShowLoading: boolean = false;
  public isShowDetailTable: boolean = false;
  private rowsOnPage: any;
  private activePage: any;
  private date1: any;
  private date2: any;
  private area: any;
  private interfereType: any;
  private data: any;

  constructor(private _dataSearchService: DataImportService ) {

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

  public searchImportRecord(e: SearchValue) {
    if (this.area) {
      if (this.area !== e.area || this.date1 !== e.date1 || this.interfereType !== e.interfereType || this.date2 !== e.date2) {
        this.activePage = 0;
      }
    }
    this.date1 = e.date1;
    this.date2 = e.date2;
    this.area = e.area;
    this.interfereType = e.interfereType;
    const final = new FinalSearchValue(
      this.date1,
      this.date2,
      this.area,
      this.interfereType,
      this.rowsOnPage,
      this.activePage,
    );
    // console.log(final);
    this.isShowLoading = true;
    this.getData(final);
  }


  public pageParameterData() {
    const final = new FinalSearchValue(
      this.date1,
      this.date2,
      this.area,
      this.interfereType,
      this.rowsOnPage,
      this.activePage,
    );
    this.getData(final);
  }

  private getData(e: FinalSearchValue) {
    this._dataSearchService.getData(e)
      .then(data => {
        this.isShowLoading = false;
        if (data.json.length === 0) {
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'block';
          }, 0);
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'none';
          }, 3000);
          this.isShowDetailTable = false;
          return;
        }else {
          const totalItems = data.headers.get('X-Total-Count');
          const dataFinal = [];
          dataFinal.push(data.json);
          dataFinal.push(totalItems);
          dataFinal.push(this.activePage);
          this.data = dataFinal;
          this.isShowDetailTable = true;
        }
      }).catch(ex => {
      // console.log(e);
      this.isShowLoading = false;
      this.isShowDetailTable = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);
      return;
    });
  }

  private showTypeError() {
    setTimeout(() => {
      this.typeError.nativeElement.style.display = 'block';
    }, 0);
    setTimeout(() => {
      this.typeError.nativeElement.style.display = 'none';
    }, 3000);
    return;
  }

  private showSuccess() {
    setTimeout(() => {
      this.fileUpSuccess.nativeElement.style.display = 'block';
    }, 0);
    setTimeout(() => {
      this.fileUpSuccess.nativeElement.style.display = 'none';
    }, 3000);
    return;
  }

}
