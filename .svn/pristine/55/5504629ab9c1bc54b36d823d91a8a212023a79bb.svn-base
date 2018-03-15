import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ExceptionCauseComponent } from './exception-cause.component';
import { ExceptionCauseDetailComponent } from './exception-cause-detail.component';
import { ExceptionCausePopupComponent } from './exception-cause-dialog.component';
import { ExceptionCauseDeletePopupComponent } from './exception-cause-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class ExceptionCauseResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const exceptionCauseRoute: Routes = [
    {
        path: 'exception-cause',
        component: ExceptionCauseComponent,
        resolve: {
            'pagingParams': ExceptionCauseResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionCause.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'exception-cause/:id',
        component: ExceptionCauseDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionCause.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const exceptionCausePopupRoute: Routes = [
    {
        path: 'exception-cause-new',
        component: ExceptionCausePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionCause.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'exception-cause/:id/edit',
        component: ExceptionCausePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionCause.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'exception-cause/:id/delete',
        component: ExceptionCauseDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionCause.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
