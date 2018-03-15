import { TableSearchValue } from './table-search-value';
import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { DateParseService } from '../common/date-parse.service';

@Injectable()
export class DataStatisticsService {

  constructor(private _getJsonService: GetJsonHttpService) {}

  public getData(inputs: TableSearchValue): Promise<number[]> {
    return this._getJsonService.getJsonPromise(this.getUrl(inputs)).then(j => {
      if (j.length === 0) {
        return [];
      }
      // console.log(j);
      return j;
    });
  }

  private getUrl(inputs: TableSearchValue): string {
    // console.log(inputs.cellType+':'+inputs.cellInput);
    // console.log(inputs.date1);
    const dateMillis = DateParseService.getTimestamp(DateParseService.getDate1(inputs.date));
    const page: number = inputs.activePage;
    const size: number = inputs.rowsOnPage;
    const url = `/api/data-import/record/${inputs.device}/${inputs.area}?date=${dateMillis}&page=${page}&size=${size}`;
    // console.log(url);
    return url;
  }

}
