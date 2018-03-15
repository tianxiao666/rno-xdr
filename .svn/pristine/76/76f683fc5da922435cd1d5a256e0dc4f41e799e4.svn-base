import { Observable } from 'rxjs/Observable';
import { RequestOptionsArgs, Response } from '@angular/http';
import { JhiHttpInterceptor } from 'ng-jhipster';

export class AuthInterceptor extends JhiHttpInterceptor {

    constructor() {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        const token = localStorage.getItem('authenticationToken') || sessionStorage.getItem('authenticationToken');
        if (token) {
            options.headers.append('Authorization', `Bearer ${token}`);
        }
        return options;
    }

    responseIntercept(observable: Observable<Response>): Observable<Response> {
        return observable; // by pass
    }

}
