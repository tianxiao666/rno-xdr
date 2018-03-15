import { FinalSearchValue } from './final-search-value';
import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { DateParseService } from '../common/date-parse.service';

@Injectable()
export class PerceptualDetailsService {

  constructor(private _getJsonService: GetJsonHttpService) {}

  public getData(inputs: FinalSearchValue): Promise<number[]> {
    return this._getJsonService.getJsonPromise(this.getUrl(inputs)).then(j => {
      if (j.length === 0) {
        return [];
      }
      // console.log(j);
      return j;
    });
  }

  private getUrl(inputs: FinalSearchValue): string {
    // console.log(inputs.cellType+':'+inputs.cellInput);
    // console.log(inputs.date1);
    const dateMillis = DateParseService.getTimestamp(DateParseService.getDate1(inputs.date1));
    const page: number = inputs.activePage;
    const size: number = inputs.rowsOnPage;
    let url = `/api/indicator/${inputs.interfaceType}/detail/${inputs.cellType}?date=${dateMillis}&page=${page}&size=${size}`;
    const query: string = inputs.operateType;
    if ( query === 'download' ) {
      url = `/api/indicator/detail/download/${inputs.interfaceType}/${inputs.cellType}?date=${dateMillis}`;
    }
    switch (inputs.cellType) {
      case 'imsi':
        url += `&imsi=${inputs.cellInput}`;
        break;
      case 'eci':
        url += `&eci=${inputs.cellInput}`;
        break;
      default:
        break;
    }
    // console.log(url);
    return url;
  }

}
