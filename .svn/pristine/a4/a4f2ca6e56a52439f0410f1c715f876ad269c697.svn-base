import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { InterfereComponent } from './interfere.component';
import { InterfereDetailComponent } from './interfere-detail.component';
import { InterferePopupComponent } from './interfere-dialog.component';
import { InterfereDeletePopupComponent } from './interfere-delete-dialog.component';

import { Principal } from '../../shared';

export const interfereRoute: Routes = [
    {
        path: 'interfere',
        component: InterfereComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.interfere.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'interfere/:id',
        component: InterfereDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.interfere.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const interferePopupRoute: Routes = [
    {
        path: 'interfere-new',
        component: InterferePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.interfere.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'interfere/:id/edit',
        component: InterferePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.interfere.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'interfere/:id/delete',
        component: InterfereDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.interfere.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
