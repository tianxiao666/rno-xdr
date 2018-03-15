import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { Uhttp } from './uhttp.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class UhttpService {

    private resourceUrl = 'api/uhttps';
    private resourceSearchUrl = 'api/_search/uhttps';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(uhttp: Uhttp): Observable<Uhttp> {
        const copy = this.convert(uhttp);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(uhttp: Uhttp): Observable<Uhttp> {
        const copy = this.convert(uhttp);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<Uhttp> {
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

    private convert(uhttp: Uhttp): Uhttp {
        const copy: Uhttp = Object.assign({}, uhttp);
        copy.pdate = this.dateUtils
            .convertLocalDateToServer(uhttp.pdate);
        return copy;
    }
}
