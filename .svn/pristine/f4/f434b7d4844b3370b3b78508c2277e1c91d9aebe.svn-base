import { Component, ElementRef, ViewChild } from '@angular/core';
import { Parameter } from './data-table/get-parameter-value';
import { SampleClassifyService } from './sample-classify.service';
import { FinalSearchValue } from './final-search-value';
import { SearchValue } from './classify/search-value';
@Component({
  selector: 'sample-classify',
  templateUrl: './sample-classify.component.html',
  styleUrls: ['./sample-classify.component.scss'],
  providers: [],
})
export class SampleClassifyComponent {

  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;

  public isShownLoading: boolean = false;
  public isShownClassifyTable: boolean = false;

  private data: any;
  private dateFromCurr: any;
  private dateToCurr: any;
  private provinceCurr: any;
  private cityCurr: any;
  private classifyNameCurr: any;
  private classifyStatusCurr: any;
  private rowsOnPage: any;
  private activePage: any;

  constructor(private classifyService: SampleClassifyService ) {}

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

  public pageParameterData() {
    const final = new FinalSearchValue(
      this.cityCurr,
      this.classifyNameCurr,
      this.classifyStatusCurr,
      this.dateFromCurr,
      this.dateToCurr,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  searchClassifyData(e: SearchValue) {
    this.cityCurr = e.city;
    this.classifyNameCurr = e.classifyName;
    this.classifyStatusCurr = e.classifyStatus;
    this.dateFromCurr = e.dateFrom;
    this.dateToCurr = e.dateTo;
    const final = new FinalSearchValue(
      this.cityCurr,
      this.classifyNameCurr,
      this.classifyStatusCurr,
      this.dateFromCurr,
      this.dateToCurr,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.isShownLoading = true;
    this.getData(final);
  }

  getData(final: FinalSearchValue) {
    this.classifyService.getData(final).then( data => {
      const dataFinal = [];
      if (data === null || data.json().length === 0) {
        this.activePage = 0;
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'block';
        }, 0);
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'none';
        }, 3000);
        this.isShownClassifyTable = false;
        return;
      } else {
        // console.log(data);
        dataFinal.push(data.json());
        dataFinal.push(11);
        dataFinal.push(this.activePage);
        this.data = dataFinal;
        this.isShownClassifyTable = true;
      }
    }).catch(e => {
      // console.log(e);
      this.isShownLoading = false;
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

