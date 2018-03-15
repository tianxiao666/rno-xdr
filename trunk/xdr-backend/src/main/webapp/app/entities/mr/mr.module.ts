import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    MrService,
    MrPopupService,
    MrComponent,
    MrDetailComponent,
    MrDialogComponent,
    MrPopupComponent,
    MrDeletePopupComponent,
    MrDeleteDialogComponent,
    mrRoute,
    mrPopupRoute,
    MrResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...mrRoute,
    ...mrPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        MrComponent,
        MrDetailComponent,
        MrDialogComponent,
        MrDeleteDialogComponent,
        MrPopupComponent,
        MrDeletePopupComponent,
    ],
    entryComponents: [
        MrComponent,
        MrDialogComponent,
        MrPopupComponent,
        MrDeleteDialogComponent,
        MrDeletePopupComponent,
    ],
    providers: [
        MrService,
        MrPopupService,
        MrResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendMrModule {}
