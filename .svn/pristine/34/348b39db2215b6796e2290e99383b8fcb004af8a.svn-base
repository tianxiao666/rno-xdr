import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { ExceptionCause } from './exception-cause.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ExceptionCauseService {

    private resourceUrl = 'api/exception-causes';
    private resourceSearchUrl = 'api/_search/exception-causes';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(exceptionCause: ExceptionCause): Observable<ExceptionCause> {
        const copy = this.convert(exceptionCause);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(exceptionCause: ExceptionCause): Observable<ExceptionCause> {
        const copy = this.convert(exceptionCause);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<ExceptionCause> {
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

    private convert(exceptionCause: ExceptionCause): ExceptionCause {
        const copy: ExceptionCause = Object.assign({}, exceptionCause);
        copy.pdate = this.dateUtils
            .convertLocalDateToServer(exceptionCause.pdate);
        return copy;
    }
}
