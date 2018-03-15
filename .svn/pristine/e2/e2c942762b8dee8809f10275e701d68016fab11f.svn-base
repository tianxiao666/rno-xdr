import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';

@Injectable()
export class AuthenticationService {

  private env = environment;

  constructor(private http: Http) {}

  login(credentials): Observable<any> {
    return this.http.post(`${this.env.host}/api/authenticate`, credentials).map(authenticateSuccess.bind(this));

    function authenticateSuccess(resp) {
      const bearerToken = resp.headers.get('Authorization');
      if (bearerToken && bearerToken.slice(0, 7) === 'Bearer ') {
        const jwt = bearerToken.slice(7, bearerToken.length);
        this.storeAuthenticationToken(jwt, credentials.rememberMe);
        return jwt;
      }
    }
  }

  loginWithToken(jwt, rememberMe) {
    if (jwt) {
      this.storeAuthenticationToken(jwt, rememberMe);
      return Promise.resolve(jwt);
    } else {
      return Promise.reject('auth-jwt-service Promise reject'); // Put appropriate error message here
    }
  }

  storeAuthenticationToken(jwt, rememberMe) {
    if (rememberMe) {
      localStorage.setItem('authenticationToken', jwt);
    } else {
      sessionStorage.setItem('authenticationToken', jwt);
    }
  }

  logout(): Observable<any> {
    return new Observable((observer) => {
      this.clearAuthenticationToken();
      observer.complete();
    });
  }

  clearAuthenticationToken() {
    localStorage.removeItem('authenticationToken');
    sessionStorage.removeItem('authenticationToken');
  }
}
