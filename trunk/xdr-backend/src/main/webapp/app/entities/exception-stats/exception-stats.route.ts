import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ExceptionStatsComponent } from './exception-stats.component';
import { ExceptionStatsDetailComponent } from './exception-stats-detail.component';
import { ExceptionStatsPopupComponent } from './exception-stats-dialog.component';
import { ExceptionStatsDeletePopupComponent } from './exception-stats-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class ExceptionStatsResolvePagingParams implements Resolve<any> {

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

export const exceptionStatsRoute: Routes = [
    {
        path: 'exception-stats',
        component: ExceptionStatsComponent,
        resolve: {
            'pagingParams': ExceptionStatsResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionStats.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'exception-stats/:id',
        component: ExceptionStatsDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionStats.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const exceptionStatsPopupRoute: Routes = [
    {
        path: 'exception-stats-new',
        component: ExceptionStatsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionStats.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'exception-stats/:id/edit',
        component: ExceptionStatsPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionStats.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'exception-stats/:id/delete',
        component: ExceptionStatsDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.exceptionStats.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
