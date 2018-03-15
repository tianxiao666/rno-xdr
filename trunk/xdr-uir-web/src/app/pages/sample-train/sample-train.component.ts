import { Component, ElementRef, ViewChild } from '@angular/core';
import { Parameter } from './data-table/get-parameter-value';
import { SampleTrainService } from './sample-train.service';
import { FinalSearchValue } from './final-search-value';
import { SearchValue } from './train/search-value';
@Component({
    selector: 'sample-train',
    templateUrl: './sample-train.component.html',
    styleUrls: ['./sample-train.component.scss'],
    providers: [],
})
export class SampleTrainComponent {

  @ViewChild('notFoundData') public notFoundDataDiv: ElementRef;
  @ViewChild('programError') public programError: ElementRef;

  public isShownLoading: boolean = false;
  public isShownTrainTable: boolean = false;

  private data: any;
  private dateFromCurr: any;
  private dateToCurr: any;
  private cityCurr: any;
  private trainNameCurr: any;
  private trainStatusCurr: any;
  private rowsOnPage: any;
  private activePage: any;

  constructor(private trainService: SampleTrainService ) {}

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
      this.trainNameCurr,
      this.trainStatusCurr,
      this.dateFromCurr,
      this.dateToCurr,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  searchTrainData(e: SearchValue) {
    this.cityCurr = e.city;
    this.trainNameCurr = e.trainName;
    this.trainStatusCurr = e.trainStatus;
    this.dateFromCurr = e.dateFrom;
    this.dateToCurr = e.dateTo;
    const final = new FinalSearchValue(
      this.cityCurr,
      this.trainNameCurr,
      this.trainStatusCurr,
      this.dateFromCurr,
      this.dateToCurr,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.getData(final);
  }

  getData(final: FinalSearchValue) {
    this.trainService.getData(final).then( data => {
      const dataFinal = [];
      if (data === null || data.json().length === 0) {
        this.activePage = 0;
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'block';
        }, 0);
        setTimeout(() => {
          this.notFoundDataDiv.nativeElement.style.display = 'none';
        }, 3000);
        this.isShownTrainTable = false;
        return;
      } else {
        // console.log(data);
        dataFinal.push(data.json());
        dataFinal.push(11);
        dataFinal.push(this.activePage);
        this.data = dataFinal;
        this.isShownTrainTable = true;
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
