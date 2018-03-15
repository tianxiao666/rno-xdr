import { SearchValue } from './trend/search-value';
import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { DateParseService } from '../common/date-parse.service';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';

const oneDay = 24 * 3600 * 1000;

@Injectable()
export class PerceptionTrendService {

  constructor(private _getJsonService: GetJsonHttpService) {}

  getData(inputs: SearchValue): Promise<number[]> {
    return this._getJsonService.getJsonPromise(this.getUrl(inputs)).then(j => {
      if (j.length === 0) {
        return [];
      }
      let result = [];
      // inputs.startTime
      let days = DateParseService.getDays1(inputs.startTime, inputs.endTime) + 1;
      let startDate = DateParseService.getDate1(inputs.startTime);
      for (const i of inputs.indicatorSelectItems) {
        result.push({ name: i.name, data: this.getIndicatorArray(j, i, days, startDate) });
      }
      return result;
    });
  }

  private getUrl(inputs: SearchValue): string {
    let url = '/api/indicator/' + inputs.interfaceType + '/day/' + inputs.cellType
      + '?beginDate=' + DateParseService.getTimestamp(DateParseService.getDate1(inputs.startTime))
      + '&endDate=' + DateParseService.getTimestamp(DateParseService.getDate1(inputs.endTime));
    switch (inputs.cellType) {
      case 'imsi':
        url = url + '&imsi=' + inputs.cellInput;
        break;
      case 'eci':
        url = url + '&eci=' + inputs.cellInput;
        break;
      default:
        break;
    }
    return url;
  }

  private getIndicatorArray(array: any[], indicatorSelect: IMultiSelectOption, days: number, startDate: Date): number[] {
    const result: any[] = PerceptionTrendService.createResult(days, startDate, indicatorSelect.name);
    array.forEach(indicator => {
      const date = new Date(indicator.pdate);
      result.forEach(r => {
        if (date.getTime() === r.name.getTime()) {
          r.value = indicator[indicatorSelect.id] || 0;
          // console.log("value===="+ indicator[indicatorSelect.id]);
        }
      });
    });
    return result;
  }

  private static createResult(days: number, startDate: Date, type: string): any[] {
    const result: any[] = [];
    const base = DateParseService.getTimestamp(startDate);
    let date: any;
    for (let i = 0; i < days; i++) {
     date  = new Date(base + i * oneDay);
      result[i] = { name: date , value: 0 , label: type, chartType: 0 };
    }
    return result;
  }

}
