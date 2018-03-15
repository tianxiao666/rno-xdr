import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment } from '../../../environments/environment';

@Injectable()
export class AccountService {
  private env = environment;

  constructor(private http: Http) { }

  get(): Observable<any> {
    return this.http.get(`${this.env.host}/api/account`).map((res: Response) => res.json());
  }

  save(account: any): Observable<Response> {
    return this.http.post(`${this.env.host}/api/account`, account);
  }
}
