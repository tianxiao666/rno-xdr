import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    ExceptionStatsService,
    ExceptionStatsPopupService,
    ExceptionStatsComponent,
    ExceptionStatsDetailComponent,
    ExceptionStatsDialogComponent,
    ExceptionStatsPopupComponent,
    ExceptionStatsDeletePopupComponent,
    ExceptionStatsDeleteDialogComponent,
    exceptionStatsRoute,
    exceptionStatsPopupRoute,
    ExceptionStatsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...exceptionStatsRoute,
    ...exceptionStatsPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ExceptionStatsComponent,
        ExceptionStatsDetailComponent,
        ExceptionStatsDialogComponent,
        ExceptionStatsDeleteDialogComponent,
        ExceptionStatsPopupComponent,
        ExceptionStatsDeletePopupComponent,
    ],
    entryComponents: [
        ExceptionStatsComponent,
        ExceptionStatsDialogComponent,
        ExceptionStatsPopupComponent,
        ExceptionStatsDeleteDialogComponent,
        ExceptionStatsDeletePopupComponent,
    ],
    providers: [
        ExceptionStatsService,
        ExceptionStatsPopupService,
        ExceptionStatsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendExceptionStatsModule {}
