import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { MrComponent } from './mr.component';
import { MrDetailComponent } from './mr-detail.component';
import { MrPopupComponent } from './mr-dialog.component';
import { MrDeletePopupComponent } from './mr-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class MrResolvePagingParams implements Resolve<any> {

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

export const mrRoute: Routes = [
    {
        path: 'mr',
        component: MrComponent,
        resolve: {
            'pagingParams': MrResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mr.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'mr/:id',
        component: MrDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mr.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const mrPopupRoute: Routes = [
    {
        path: 'mr-new',
        component: MrPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mr.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'mr/:id/edit',
        component: MrPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mr.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'mr/:id/delete',
        component: MrDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.mr.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
