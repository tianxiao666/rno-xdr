import { Injectable } from '@angular/core';
import { URLSearchParams, BaseRequestOptions, Http, Response } from '@angular/http';
import { FinalSearchCond } from './final-search-cond';
import { Observable } from 'rxjs/Observable';
import { ResponseWrapper } from '../common/response-wrapper';
import { environment } from '../../../environments/environment';

@Injectable()
export class ExceptionStatService {

  private env = environment;
  private resourceUrl;

  constructor(private http: Http) {
  }

  public getData(inputs: FinalSearchCond): Promise<any> {
    if (inputs.operateType === 'query') {
      this.resourceUrl  = '/api/exception-stats/findByCond';
    }else if (inputs.operateType === 'download') {
      this.resourceUrl  = '/api/exception-stats/downloadByCond';
    }
    // console.log(inputs);
    const res: Observable<ResponseWrapper> = this.query(inputs);
    return res.toPromise();
  }

  private query(req?: any): Observable<ResponseWrapper> {
    const url = `${this.env.host}/${this.resourceUrl}`;
    const options = this.createRequestOption(req);
    return this.http.get(url, options)
      .map((res: Response) => this.convertResponse(res));
  }

  private createRequestOption(req?: any): BaseRequestOptions {
    // console.log(req);
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
      params.append('expressionConnector1', req.expressionConnector1);
      params.append('expressionCondition1', req.expressionCondition1);
      params.append('expressionOperator1', req.expressionOperator1);
      if (req.expressionValue1) {
        params.append('expressionValue1', req.expressionValue1);
      }
      params.append('expressionConnector2', req.expressionConnector2);
      params.append('expressionCondition2', req.expressionCondition2);
      params.append('expressionOperator2', req.expressionOperator2);
      if (req.expressionValue2) {
        params.append('expressionValue2', req.expressionValue2);
      }
      params.append('expressionConnector3', req.expressionConnector3);
      params.append('expressionCondition3', req.expressionCondition3);
      params.append('expressionOperator3', req.expressionOperator3);
      if (req.expressionValue3) {
        params.append('expressionValue3', req.expressionValue3);
      }
      if (req.rowsOnPage) {
        if (req.rowsOnPage !== -1) {
          params.append('size', req.rowsOnPage);
        }
      }
      if (req.activePage) {
        if (req.activePage !== -1) {
          params.append('page', req.activePage);
        }
      }
      options.params = params;
    }
    return options;
  }

  private convertResponse(res: Response): ResponseWrapper {
    return new ResponseWrapper(res.headers, res.json(), res.status);
  }
}
