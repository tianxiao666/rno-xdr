import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UhttpComponent } from './uhttp.component';
import { UhttpDetailComponent } from './uhttp-detail.component';
import { UhttpPopupComponent } from './uhttp-dialog.component';
import { UhttpDeletePopupComponent } from './uhttp-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class UhttpResolvePagingParams implements Resolve<any> {

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

export const uhttpRoute: Routes = [
    {
        path: 'uhttp',
        component: UhttpComponent,
        resolve: {
            'pagingParams': UhttpResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uhttp.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'uhttp/:id',
        component: UhttpDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uhttp.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const uhttpPopupRoute: Routes = [
    {
        path: 'uhttp-new',
        component: UhttpPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uhttp.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'uhttp/:id/edit',
        component: UhttpPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uhttp.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'uhttp/:id/delete',
        component: UhttpDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uhttp.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
