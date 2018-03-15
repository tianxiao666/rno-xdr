import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { X2 } from './x-2.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class X2Service {

    private resourceUrl = 'api/x-2-s';
    private resourceSearchUrl = 'api/_search/x-2-s';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(x2: X2): Observable<X2> {
        const copy = this.convert(x2);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(x2: X2): Observable<X2> {
        const copy = this.convert(x2);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<X2> {
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

    private convert(x2: X2): X2 {
        const copy: X2 = Object.assign({}, x2);
        copy.pdate = this.dateUtils
            .convertLocalDateToServer(x2.pdate);
        return copy;
    }
}
