import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UuComponent } from './uu.component';
import { UuDetailComponent } from './uu-detail.component';
import { UuPopupComponent } from './uu-dialog.component';
import { UuDeletePopupComponent } from './uu-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class UuResolvePagingParams implements Resolve<any> {

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

export const uuRoute: Routes = [
    {
        path: 'uu',
        component: UuComponent,
        resolve: {
            'pagingParams': UuResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uu.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'uu/:id',
        component: UuDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uu.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const uuPopupRoute: Routes = [
    {
        path: 'uu-new',
        component: UuPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uu.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'uu/:id/edit',
        component: UuPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uu.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'uu/:id/delete',
        component: UuDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.uu.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
