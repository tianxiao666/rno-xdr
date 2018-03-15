import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { SolveComponent } from './solve.component';
import { SolveDetailComponent } from './solve-detail.component';
import { SolvePopupComponent } from './solve-dialog.component';
import { SolveDeletePopupComponent } from './solve-delete-dialog.component';

import { Principal } from '../../shared';

export const solveRoute: Routes = [
    {
        path: 'solve',
        component: SolveComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.solve.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'solve/:id',
        component: SolveDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.solve.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const solvePopupRoute: Routes = [
    {
        path: 'solve-new',
        component: SolvePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.solve.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'solve/:id/edit',
        component: SolvePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.solve.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'solve/:id/delete',
        component: SolveDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.solve.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
