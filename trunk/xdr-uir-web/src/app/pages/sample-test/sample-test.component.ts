import { Component, ElementRef, ViewChild } from '@angular/core';
import { Parameter } from './data-table/get-parameter-value';
import { FinalSearchValue } from './final-search-value';
import { SearchValue } from './test/search-value';
import { SampleTestService } from './sample-test.service';
@Component({
  selector: 'sample-test',
  templateUrl: './sample-test.component.html',
  styleUrls: ['./sample-test.component.scss'],
  providers: [],
})
export class SampleTestComponent {

  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;

  public isShownLoading: boolean = false;
  public isShownTestTable: boolean = false;

  private data: any;
  private dateFromCurr: any;
  private dateToCurr: any;
  private cityCurr: any;
  private testNameCurr: any;
  private testStatusCurr: any;
  private rowsOnPage: any;
  private activePage: any;

  constructor(private testService: SampleTestService ) {}

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
      this.testNameCurr,
      this.testStatusCurr,
      this.dateFromCurr,
      this.dateToCurr,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  searchTestData(e: SearchValue) {
    this.cityCurr = e.city;
    this.testNameCurr = e.testName;
    this.testStatusCurr = e.testStatus;
    this.dateFromCurr = e.dateFrom;
    this.dateToCurr = e.dateTo;
    const final = new FinalSearchValue(
      this.cityCurr,
      this.testNameCurr,
      this.testStatusCurr,
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
    this.testService.getData(final).then( data => {
      const dataFinal = [];
      if (data === null || data.json().length === 0) {
        this.activePage = 0;
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'block';
        }, 0);
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'none';
        }, 3000);
        this.isShownTestTable = false;
        return;
      } else {
        // console.log(data);
        dataFinal.push(data.json());
        dataFinal.push(11);
        dataFinal.push(this.activePage);
        this.data = dataFinal;
        this.isShownTestTable = true;
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

