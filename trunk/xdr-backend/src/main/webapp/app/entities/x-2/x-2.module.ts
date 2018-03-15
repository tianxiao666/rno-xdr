import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    X2Service,
    X2PopupService,
    X2Component,
    X2DetailComponent,
    X2DialogComponent,
    X2PopupComponent,
    X2DeletePopupComponent,
    X2DeleteDialogComponent,
    x2Route,
    x2PopupRoute,
    X2ResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...x2Route,
    ...x2PopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        X2Component,
        X2DetailComponent,
        X2DialogComponent,
        X2DeleteDialogComponent,
        X2PopupComponent,
        X2DeletePopupComponent,
    ],
    entryComponents: [
        X2Component,
        X2DialogComponent,
        X2PopupComponent,
        X2DeleteDialogComponent,
        X2DeletePopupComponent,
    ],
    providers: [
        X2Service,
        X2PopupService,
        X2ResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendX2Module {}
