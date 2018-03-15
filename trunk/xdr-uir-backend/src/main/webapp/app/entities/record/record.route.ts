import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { RecordComponent } from './record.component';
import { RecordDetailComponent } from './record-detail.component';
import { RecordPopupComponent } from './record-dialog.component';
import { RecordDeletePopupComponent } from './record-delete-dialog.component';

import { Principal } from '../../shared';

export const recordRoute: Routes = [
    {
        path: 'record',
        component: RecordComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.record.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'record/:id',
        component: RecordDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.record.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const recordPopupRoute: Routes = [
    {
        path: 'record-new',
        component: RecordPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.record.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'record/:id/edit',
        component: RecordPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.record.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'record/:id/delete',
        component: RecordDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.record.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
