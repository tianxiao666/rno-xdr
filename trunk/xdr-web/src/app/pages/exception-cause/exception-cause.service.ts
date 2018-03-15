import { Injectable } from '@angular/core';
import { URLSearchParams, BaseRequestOptions, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { SearchValue } from './cause/search-value.model';
import { ResponseWrapper } from '../common/response-wrapper';
import { environment } from '../../../environments/environment';

@Injectable()
export class ExceptionCauseService {

  private env = environment;
  private resourceUrl = 'api/exception-causes/findByTimeAndImsiAndIndicatorType';
  private causePath = '/assets/json/exception-cause/cause-number.json';
  private causeNumber: any;

  private causeMap = {
    attachFault: 'EMM',
    serviceFault: 'EMM',
    csfbFault: 'EMM',
    tauFault: 'EMM',
    contextActivateFault: 'ESM',
    pdnRequestFault: 'ESM',
    xhoFault: 'S1AP',
    shoFault: 'S1AP',
  };

  constructor(private http: Http) {
    this.http.get(this.causePath).subscribe(
      (data) => this.causeNumber = data.json(),
      (error: any) => console.error('An error occurred', error));
  }

  public getData(inputs: SearchValue): Observable<any[]> {
    return this.query(inputs)
      .map((result: ResponseWrapper) => this.buildChartData(this.causeNumber[this.causeMap[inputs.indicatorType]], result));
  }

  private query(req?: any): Observable<ResponseWrapper> {
    const url = `${this.env.host}/${this.resourceUrl}`;
    const options = this.createRequestOption(req);
    return this.http.get(url, options)
      .map((res: Response) => new ResponseWrapper(res.headers, res.json(), res.status));
  }

  private createRequestOption(req?: any): BaseRequestOptions {
    const options: BaseRequestOptions = new BaseRequestOptions();
    if (req) {
      const params: URLSearchParams = new URLSearchParams();
      if (req.date1) {
        const dateModel = req.date1;
        const date1: Date = new Date(dateModel.date.year, dateModel.date.month - 1, dateModel.date.day);
        const dateMilli: number = date1.setHours(8);
        params.set('date', dateMilli.toString());
      }
      switch (req.cellType) {
        case 'imsi':
          params.append('imsi', req.cellInput);
          break;
        case 'eci':
          params.append('eci', req.cellInput);
          break;
        default:
          break;
      }
      if (req.indicatorType) {
        params.append('indicatorType', req.indicatorType);
      }
      options.params = params;
    }
    return options;
  }

  private buildChartData(causeNumber: any[], res: ResponseWrapper): any[] {
    const result: { value: string, name: any }[] = [];
    for (const d of res.json) {
      result.push({
        name: `(${d.cause})${causeNumber[d.cause.toString()]}`,
        value: d.causeCount,
      });
    }
    return result;
  }
}
