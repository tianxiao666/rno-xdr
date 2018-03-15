import { SearchValue } from './analysis/search-value';
import { Injectable } from '@angular/core';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { DateParseService } from '../common/date-parse.service';

@Injectable()
export class PerceptionAnalysisService {

  private static getUrl(inputs: SearchValue): string {
    const date = DateParseService.getTimestamp(DateParseService.getDate1(inputs.date1));
    let url = `/api/indicator/${inputs.interfaceType}/hour/${inputs.cellType}?date=${date}`;
    switch (inputs.cellType) {
      case 'imsi':
        url = `${url}&imsi=${inputs.cellInput}`;
        break;
      case 'eci':
        url = `${url}&eci=${inputs.cellInput}`;
        break;
      default:
        break;
    }
    return url;
  }

  private static createResult(type: string): any[] {
    const result: any[] = [];
    for (let i = 0; i < 24; i++) {
      result[i] = { name: i, value: 0, label: type, chartType: 0 };
    }
    return result;
  }

  constructor(private _getJsonService: GetJsonHttpService) {
  }

  public getData(inputs: SearchValue): Promise<any[]> {
    return this._getJsonService.getJsonPromise(PerceptionAnalysisService.getUrl(inputs)).then(j => {
      if (j.length === 0) {
        return [];
      }
      let result = [];
      // console.log(j);
      for (const i of inputs.indicatorSelectItems) {
        result = [...result, ...this.getIndicatorArray(j, i)];
      }
      return result;
    });
  }

  private getIndicatorArray(array: any[], indicatorSelect: IMultiSelectOption): number[] {
    const result: any[] = PerceptionAnalysisService.createResult(indicatorSelect.name);
    array.forEach(indicator => {
      const flag = indicatorSelect.params === 'bar';
      const val = indicator[indicatorSelect.id] || 0;
      result[indicator.phour].value = flag ? val * 100 : val;
      result[indicator.phour].chartType = flag ? 1 : 0;
    });
    return result;
  }

}
