import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { ExceptionStats } from './exception-stats.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ExceptionStatsService {

    private resourceUrl = 'api/exception-stats';
    private resourceSearchUrl = 'api/_search/exception-stats';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(exceptionStats: ExceptionStats): Observable<ExceptionStats> {
        const copy = this.convert(exceptionStats);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(exceptionStats: ExceptionStats): Observable<ExceptionStats> {
        const copy = this.convert(exceptionStats);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<ExceptionStats> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    search(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceSearchUrl, options)
            .map((res: any) => this.convertResponse(res));
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        for (let i = 0; i < jsonResponse.length; i++) {
            this.convertItemFromServer(jsonResponse[i]);
        }
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convertItemFromServer(entity: any) {
        entity.pdate = this.dateUtils
            .convertLocalDateFromServer(entity.pdate);
    }

    private convert(exceptionStats: ExceptionStats): ExceptionStats {
        const copy: ExceptionStats = Object.assign({}, exceptionStats);
        copy.pdate = this.dateUtils
            .convertLocalDateToServer(exceptionStats.pdate);
        return copy;
    }
}
