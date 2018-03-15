import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { Task } from './task.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class TaskService {

    private resourceUrl = 'api/tasks';
    private resourceSearchUrl = 'api/_search/tasks';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(task: Task): Observable<Task> {
        const copy = this.convert(task);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(task: Task): Observable<Task> {
        const copy = this.convert(task);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<Task> {
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
        entity.startTime = this.dateUtils
            .convertDateTimeFromServer(entity.startTime);
        entity.endTime = this.dateUtils
            .convertDateTimeFromServer(entity.endTime);
    }

    private convert(task: Task): Task {
        const copy: Task = Object.assign({}, task);

        copy.startTime = this.dateUtils.toDate(task.startTime);

        copy.endTime = this.dateUtils.toDate(task.endTime);
        return copy;
    }
}
