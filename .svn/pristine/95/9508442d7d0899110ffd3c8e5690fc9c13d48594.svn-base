import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    InterfereService,
    InterferePopupService,
    InterfereComponent,
    InterfereDetailComponent,
    InterfereDialogComponent,
    InterferePopupComponent,
    InterfereDeletePopupComponent,
    InterfereDeleteDialogComponent,
    interfereRoute,
    interferePopupRoute,
} from './';

const ENTITY_STATES = [
    ...interfereRoute,
    ...interferePopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        InterfereComponent,
        InterfereDetailComponent,
        InterfereDialogComponent,
        InterfereDeleteDialogComponent,
        InterferePopupComponent,
        InterfereDeletePopupComponent,
    ],
    entryComponents: [
        InterfereComponent,
        InterfereDialogComponent,
        InterferePopupComponent,
        InterfereDeleteDialogComponent,
        InterfereDeletePopupComponent,
    ],
    providers: [
        InterfereService,
        InterferePopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendInterfereModule {}
