import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    UuService,
    UuPopupService,
    UuComponent,
    UuDetailComponent,
    UuDialogComponent,
    UuPopupComponent,
    UuDeletePopupComponent,
    UuDeleteDialogComponent,
    uuRoute,
    uuPopupRoute,
    UuResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...uuRoute,
    ...uuPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        UuComponent,
        UuDetailComponent,
        UuDialogComponent,
        UuDeleteDialogComponent,
        UuPopupComponent,
        UuDeletePopupComponent,
    ],
    entryComponents: [
        UuComponent,
        UuDialogComponent,
        UuPopupComponent,
        UuDeleteDialogComponent,
        UuDeletePopupComponent,
    ],
    providers: [
        UuService,
        UuPopupService,
        UuResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendUuModule {}
