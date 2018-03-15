import { RestResponse } from './rest-response';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class GetJsonHttpService {

  private static handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  private env = environment;
  constructor(private http: Http) {
  }

  public getJsonPromise(str: string): Promise<any> {
    return this.http.get(this.env.host + str)
      .toPromise()
      .then(response => response.json())
      .catch(GetJsonHttpService.handleError);
  }

  public getLocalJson(path: string) {
    return this.http.get(path)
      .toPromise()
      .then(response => response.json())
      .catch(GetJsonHttpService.handleError);
  }

  public getRestData(str: string): Promise<RestResponse> {
    return this.getJsonPromise(str);
  }

}
