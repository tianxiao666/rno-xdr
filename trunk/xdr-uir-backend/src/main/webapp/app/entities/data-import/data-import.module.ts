import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    DataImportService,
    DataImportPopupService,
    DataImportComponent,
    DataImportDetailComponent,
    DataImportDialogComponent,
    DataImportPopupComponent,
    DataImportDeletePopupComponent,
    DataImportDeleteDialogComponent,
    dataImportRoute,
    dataImportPopupRoute,
    DataImportResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...dataImportRoute,
    ...dataImportPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        DataImportComponent,
        DataImportDetailComponent,
        DataImportDialogComponent,
        DataImportDeleteDialogComponent,
        DataImportPopupComponent,
        DataImportDeletePopupComponent,
    ],
    entryComponents: [
        DataImportComponent,
        DataImportDialogComponent,
        DataImportPopupComponent,
        DataImportDeleteDialogComponent,
        DataImportDeletePopupComponent,
    ],
    providers: [
        DataImportService,
        DataImportPopupService,
        DataImportResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendDataImportModule {}
