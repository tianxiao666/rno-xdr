import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { FinalSearchValue } from './final-search-value';
import { DateParseService } from '../common/date-parse.service';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';

@Injectable()
export class SampleTrainService {
  private env = environment;
  constructor(private _getJsonService: GetJsonHttpService,
  private http: Http) {}
  public getData(inputs: FinalSearchValue): Promise<any> {
    const beginMillis = DateParseService.getTimestamp(DateParseService.getDate1(inputs.dateFrom));
    const endMillis = DateParseService.getTimestamp(DateParseService.getDate1(inputs.dateTo));
    const url = `${this.env.host}/api/searchTrain?beginTime=${beginMillis}` +
    `&endTime=${endMillis}&name=${inputs.trainName}&status=${inputs.trainStatus}&city=${inputs.city}` +
    `&page=${inputs.activePage}&size=${inputs.rowsOnPage}`;
    return this.http.get(url).map(res => res).toPromise().then(j => {
      if (j.json().length === 0) {
        return null;
      }
      return j;
    });
  }

}
