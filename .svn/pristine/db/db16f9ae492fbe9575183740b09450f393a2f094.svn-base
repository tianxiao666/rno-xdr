import {Component, ElementRef, ViewChild} from "@angular/core";

import {SearchValue} from "./signaling/search-value";
import {SignalingEventTrackService} from "./signaling-event-track.service";
import {ExcelService} from "./signaling/export-to-excel";
import {Parameter} from "./data-table/get-parameter-value";
import {FinalSearchValue} from "./final-search-value";
@Component({
  selector: 'signaling-event-track',
  templateUrl: './signaling-event-track.component.html',
  styleUrls: ['./signaling-event-track.component.scss'],
})
export class SignalingEventTrackComponent {

  @ViewChild('notFoundData') notFoundDataDiv: ElementRef;
  @ViewChild('programError') programError: ElementRef;
  isShowLoading: boolean = false;
  isShowDetailTable: boolean = false;
  rowsOnPage: any;
  activePage: any;
  date1: any;
  startTime: any;
  endTime: any;
  imsi: any;
  interfaceType: any;

  constructor(private _signalingService: SignalingEventTrackService, private excelService: ExcelService) {
    this.excelService = excelService;
  }

  searchParameterData(e: Parameter) {
    if (this.rowsOnPage) {
      if (this.rowsOnPage != e.rowsOnPage) {
        this.activePage = 0;
        this.rowsOnPage = e.rowsOnPage;
      } else {
        this.activePage = e.activePage;
      }
    }else {
      this.activePage = e.activePage;
      this.rowsOnPage = e.rowsOnPage;
    }
  }

  searchData(e: SearchValue) {
    //noinspection TypeScriptUnresolvedFunction
    if (e.imsi === '') {
      alert('imsi is requeried');
    } else {
      if (this.date1) {
        if (this.date1 != e.date1 || this.imsi != e.imsi ) {
          this.activePage = 0;
        }
      }
      this.date1 = e.date1;
      this.interfaceType = "signaling";
      this.startTime = e.startTime;
      this.endTime = e.endTime;
      this.imsi = e.imsi;
      const final = new FinalSearchValue(
        this.date1,
        this.startTime,
        this.endTime,
        this.imsi,
        this.interfaceType,
        this.rowsOnPage,
        this.activePage,
        'query'
      );
      //console.log(final);
      this.isShowLoading = true;
      this.getData(final);
    }
  }

  getData(e: FinalSearchValue) {
    this._signalingService.getData1(e)
      .then(data => {
        this.isShowLoading = false;
        if (data ==null || data.json().length === 0) {
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'block';
          }, 0);
          setTimeout(() => {
            this.notFoundDataDiv.nativeElement.style.display = 'none';
          }, 3000);
          this.isShowDetailTable = false;
          return;
        } else {
          let dataFinal = [];
          dataFinal.push(data.json());
          dataFinal.push(data.headers.get("X-Total-Count"));//接收总量
          dataFinal.push(this.activePage);
          dataFinal.push(this.interfaceType);
          this.data = dataFinal;
          //console.log(this.data);
          this.isShowDetailTable = true;
        }
      }).catch(e => {
      console.log(e);
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

  data: any;

  exportData(e: SearchValue) {
    if (e.imsi === '') {
      alert('imsi is requeried');
    } else {
      this.date1 = e.date1;
      this.interfaceType = "signaling";
      this.startTime = e.startTime;
      this.endTime = e.endTime;
      this.imsi = e.imsi;
      const exp = new FinalSearchValue(
        this.date1,
        this.startTime,
        this.endTime,
        this.imsi,
        this.interfaceType,
        this.rowsOnPage,
        this.activePage,
        'download',
      );
      this.isShowLoading = true;
      this._signalingService.getData(exp)
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
          } else {
            this.excelService.exportAsExcelFile(data, this.interfaceType);
          }
        }).catch(e => {
        console.log(e);
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

  pageParameterData() {
    const final = new FinalSearchValue(
      this.date1,
      this.startTime,
      this.endTime,
      this.imsi,
      this.interfaceType,
      this.rowsOnPage,
      this.activePage,
      'query'
    );
    this.getData(final);
  }

}
