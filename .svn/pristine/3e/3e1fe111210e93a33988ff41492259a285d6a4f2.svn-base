import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    UhttpService,
    UhttpPopupService,
    UhttpComponent,
    UhttpDetailComponent,
    UhttpDialogComponent,
    UhttpPopupComponent,
    UhttpDeletePopupComponent,
    UhttpDeleteDialogComponent,
    uhttpRoute,
    uhttpPopupRoute,
    UhttpResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...uhttpRoute,
    ...uhttpPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        UhttpComponent,
        UhttpDetailComponent,
        UhttpDialogComponent,
        UhttpDeleteDialogComponent,
        UhttpPopupComponent,
        UhttpDeletePopupComponent,
    ],
    entryComponents: [
        UhttpComponent,
        UhttpDialogComponent,
        UhttpPopupComponent,
        UhttpDeleteDialogComponent,
        UhttpDeletePopupComponent,
    ],
    providers: [
        UhttpService,
        UhttpPopupService,
        UhttpResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendUhttpModule {}
