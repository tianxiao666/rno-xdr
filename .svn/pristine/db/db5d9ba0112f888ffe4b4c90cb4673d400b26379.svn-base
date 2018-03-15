import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { SignallingComponent } from './signalling.component';
import { SignallingDetailComponent } from './signalling-detail.component';
import { SignallingPopupComponent } from './signalling-dialog.component';
import { SignallingDeletePopupComponent } from './signalling-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class SignallingResolvePagingParams implements Resolve<any> {

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

export const signallingRoute: Routes = [
    {
        path: 'signalling',
        component: SignallingComponent,
        resolve: {
            'pagingParams': SignallingResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.signalling.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'signalling/:id',
        component: SignallingDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.signalling.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const signallingPopupRoute: Routes = [
    {
        path: 'signalling-new',
        component: SignallingPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.signalling.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'signalling/:id/edit',
        component: SignallingPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.signalling.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'signalling/:id/delete',
        component: SignallingDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.signalling.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
