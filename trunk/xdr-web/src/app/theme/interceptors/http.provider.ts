import { Injector } from '@angular/core';
import { Http, XHRBackend, RequestOptions } from '@angular/http';
import { JhiEventManager, JhiInterceptableHttp } from 'ng-jhipster';

import { AuthInterceptor, AuthExpiredInterceptor, ErrorHandlerInterceptor, NotificationInterceptor } from './';

export function interceptableFactory(
    backend: XHRBackend,
    defaultOptions: RequestOptions,
    injector: Injector,
    eventManager: JhiEventManager,
) {
    return new JhiInterceptableHttp(
        backend,
        defaultOptions,
        [
            new AuthInterceptor(),
            new AuthExpiredInterceptor(injector),
            // Other interceptors can be added here
            new ErrorHandlerInterceptor(eventManager),
            new NotificationInterceptor(injector),
        ],
    );
}

export function customHttpProvider() {
    return {
        provide: Http,
        useFactory: interceptableFactory,
        deps: [
            XHRBackend,
            RequestOptions,
            Injector,
            JhiEventManager,
        ],
    };
}
