import { Injectable } from '@angular/core';

import { SearchValue } from './signaling/search-value';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { Object } from '../common/Object';
import { FinalSearchValue } from "./final-search-value";
import { DateParseService } from "../common/date-parse.service";
import {ResponseWrapper} from "./response-wrapper.model";
import {Observable} from "rxjs";
import {Http} from "@angular/http";
import {environment} from "../../../environments/environment";
@Injectable()
export class SignalingEventTrackService {
  env = environment;
  public result: any;
  constructor(private _getJsonService: GetJsonHttpService, private http: Http) {
  }

  getData(inputs: FinalSearchValue): Promise<number[]> {
    return this._getJsonService.getJsonPromise(SignalingEventTrackService.getUrl(inputs)).then(j => {
      if (j.length === 0) {
        return [];
      }
      return j;
    });
  }

  getData1(inputs: FinalSearchValue): Promise<any> {
    // this._getJsonService.testJson(SignalingEventTrackService.getUrl(inputs));
   return this.http.get(this.env.host + SignalingEventTrackService.getUrl(inputs))
      .map(res =>res ).toPromise().then(data=>{
      if (data.json().length === 0) {
        return null;
      }
      return data;
      });
  }

  private static getUrl(inputs: FinalSearchValue): string {
    ///api/signallings/findByTimeAndImsi?beginTime={}&endTime={}&imsi={}&page={}&size={}
    const dateMillis = DateParseService.getTimestamp1(DateParseService.getDate1(inputs.date1));
    const page: number = inputs.activePage;
    const size: number = inputs.rowsOnPage;
    const beginTime = dateMillis + parseInt(inputs.startTime) * 60 * 60 * 1000;
    const endTime = dateMillis + parseInt(inputs.endTime) * 60 * 60 * 1000;
    let url = `/api/signallings/findByTimeAndImsi?beginTime=${beginTime}&endTime=${endTime}&imsi=${parseInt(inputs.imsi)}&page=${page}&size=${size}`;
    const query: string = inputs.operateType;
    if ( query === 'download' ) {
      url = `/api/signallings/downloadByTimeAndImsi?beginTime=${beginTime}&endTime=${endTime}&imsi=${parseInt(inputs.imsi)}`;
    }
    //console.log(url);
    return url;
  }
}
