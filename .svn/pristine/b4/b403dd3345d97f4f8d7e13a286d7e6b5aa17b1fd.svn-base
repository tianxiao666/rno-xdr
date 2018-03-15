import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { X2Component } from './x-2.component';
import { X2DetailComponent } from './x-2-detail.component';
import { X2PopupComponent } from './x-2-dialog.component';
import { X2DeletePopupComponent } from './x-2-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class X2ResolvePagingParams implements Resolve<any> {

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

export const x2Route: Routes = [
    {
        path: 'x-2',
        component: X2Component,
        resolve: {
            'pagingParams': X2ResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.x2.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'x-2/:id',
        component: X2DetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.x2.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const x2PopupRoute: Routes = [
    {
        path: 'x-2-new',
        component: X2PopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.x2.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'x-2/:id/edit',
        component: X2PopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.x2.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'x-2/:id/delete',
        component: X2DeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.x2.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
