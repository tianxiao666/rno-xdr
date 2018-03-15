import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    MmeService,
    MmePopupService,
    MmeComponent,
    MmeDetailComponent,
    MmeDialogComponent,
    MmePopupComponent,
    MmeDeletePopupComponent,
    MmeDeleteDialogComponent,
    mmeRoute,
    mmePopupRoute,
    MmeResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...mmeRoute,
    ...mmePopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        MmeComponent,
        MmeDetailComponent,
        MmeDialogComponent,
        MmeDeleteDialogComponent,
        MmePopupComponent,
        MmeDeletePopupComponent,
    ],
    entryComponents: [
        MmeComponent,
        MmeDialogComponent,
        MmePopupComponent,
        MmeDeleteDialogComponent,
        MmeDeletePopupComponent,
    ],
    providers: [
        MmeService,
        MmePopupService,
        MmeResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendMmeModule {}
