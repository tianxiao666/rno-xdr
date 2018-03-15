import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    ExceptionCauseService,
    ExceptionCausePopupService,
    ExceptionCauseComponent,
    ExceptionCauseDetailComponent,
    ExceptionCauseDialogComponent,
    ExceptionCausePopupComponent,
    ExceptionCauseDeletePopupComponent,
    ExceptionCauseDeleteDialogComponent,
    exceptionCauseRoute,
    exceptionCausePopupRoute,
    ExceptionCauseResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...exceptionCauseRoute,
    ...exceptionCausePopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ExceptionCauseComponent,
        ExceptionCauseDetailComponent,
        ExceptionCauseDialogComponent,
        ExceptionCauseDeleteDialogComponent,
        ExceptionCausePopupComponent,
        ExceptionCauseDeletePopupComponent,
    ],
    entryComponents: [
        ExceptionCauseComponent,
        ExceptionCauseDialogComponent,
        ExceptionCausePopupComponent,
        ExceptionCauseDeleteDialogComponent,
        ExceptionCauseDeletePopupComponent,
    ],
    providers: [
        ExceptionCauseService,
        ExceptionCausePopupService,
        ExceptionCauseResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendExceptionCauseModule {}
