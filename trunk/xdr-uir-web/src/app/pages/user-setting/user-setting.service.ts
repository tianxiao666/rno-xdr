import { Injectable } from '@angular/core';
import { Http, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { UserInfo } from './user.model';
import { environment } from '../../../environments/environment';

@Injectable()
export class UserSettingService {

  private env = environment;
  private uri: string;
  constructor(private _httpService: GetJsonHttpService, private _http: Http) { }

  public getAccount(): Promise<UserInfo> {
    this.uri = `/api/account`;
    return this._httpService.getJsonPromise(this.uri).then(data => {
      return data;
    });
  }

  public editInfo(firstName: string, email: string): Observable<any> {
    console.debug(firstName, email);
    this.uri = `/api/account/edit_info?firstName=${firstName}&email=${email}`;
    return this._http.get(this.env.host + this.uri);
  }

  public changePass(pass: string): Observable<any> {
    this.uri = `/api/account/change_password`;
    return this._http.post(this.env.host + this.uri, pass);
  }
}
