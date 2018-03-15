import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { DataImportComponent } from './data-import.component';
import { DataImportDetailComponent } from './data-import-detail.component';
import { DataImportPopupComponent } from './data-import-dialog.component';
import { DataImportDeletePopupComponent } from './data-import-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class DataImportResolvePagingParams implements Resolve<any> {

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

export const dataImportRoute: Routes = [
    {
        path: 'data-import',
        component: DataImportComponent,
        resolve: {
            'pagingParams': DataImportResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.dataImport.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'data-import/:id',
        component: DataImportDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.dataImport.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const dataImportPopupRoute: Routes = [
    {
        path: 'data-import-new',
        component: DataImportPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.dataImport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'data-import/:id/edit',
        component: DataImportPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.dataImport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'data-import/:id/delete',
        component: DataImportDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'backendApp.dataImport.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
