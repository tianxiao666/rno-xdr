import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { DataImport } from './data-import.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class DataImportService {

    private resourceUrl = 'api/data-imports';
    private resourceSearchUrl = 'api/_search/data-imports';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(dataImport: DataImport): Observable<DataImport> {
        const copy = this.convert(dataImport);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(dataImport: DataImport): Observable<DataImport> {
        const copy = this.convert(dataImport);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<DataImport> {
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
        entity.dataDate = this.dateUtils
            .convertLocalDateFromServer(entity.dataDate);
    }

    private convert(dataImport: DataImport): DataImport {
        const copy: DataImport = Object.assign({}, dataImport);
        copy.dataDate = this.dateUtils
            .convertLocalDateToServer(dataImport.dataDate);
        return copy;
    }
}
