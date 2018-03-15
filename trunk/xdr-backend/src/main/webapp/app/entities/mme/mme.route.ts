import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { MmeComponent } from './mme.component';
import { MmeDetailComponent } from './mme-detail.component';
import { MmePopupComponent } from './mme-dialog.component';
import { MmeDeletePopupComponent } from './mme-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class MmeResolvePagingParams implements Resolve<any> {

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

export const mmeRoute: Routes = [
    {
        path: 'mme',
        component: MmeComponent,
        resolve: {
            'pagingParams': MmeResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mme.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'mme/:id',
        component: MmeDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mme.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const mmePopupRoute: Routes = [
    {
        path: 'mme-new',
        component: MmePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mme.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'mme/:id/edit',
        component: MmePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mme.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'mme/:id/delete',
        component: MmeDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mme.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
