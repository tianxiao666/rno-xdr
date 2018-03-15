import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    AreaService,
    AreaPopupService,
    AreaComponent,
    AreaDetailComponent,
    AreaDialogComponent,
    AreaPopupComponent,
    AreaDeletePopupComponent,
    AreaDeleteDialogComponent,
    areaRoute,
    areaPopupRoute,
} from './';

const ENTITY_STATES = [
    ...areaRoute,
    ...areaPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        AreaComponent,
        AreaDetailComponent,
        AreaDialogComponent,
        AreaDeleteDialogComponent,
        AreaPopupComponent,
        AreaDeletePopupComponent,
    ],
    entryComponents: [
        AreaComponent,
        AreaDialogComponent,
        AreaPopupComponent,
        AreaDeleteDialogComponent,
        AreaDeletePopupComponent,
    ],
    providers: [
        AreaService,
        AreaPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendAreaModule {}
