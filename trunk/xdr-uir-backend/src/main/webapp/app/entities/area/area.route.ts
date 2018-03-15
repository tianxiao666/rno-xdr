import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { AreaComponent } from './area.component';
import { AreaDetailComponent } from './area-detail.component';
import { AreaPopupComponent } from './area-dialog.component';
import { AreaDeletePopupComponent } from './area-delete-dialog.component';

import { Principal } from '../../shared';

export const areaRoute: Routes = [
    {
        path: 'area',
        component: AreaComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.area.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'area/:id',
        component: AreaDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.area.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const areaPopupRoute: Routes = [
    {
        path: 'area-new',
        component: AreaPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.area.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'area/:id/edit',
        component: AreaPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.area.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'area/:id/delete',
        component: AreaDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.area.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
