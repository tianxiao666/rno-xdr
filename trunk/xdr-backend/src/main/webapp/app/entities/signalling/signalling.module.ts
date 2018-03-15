import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    SignallingService,
    SignallingPopupService,
    SignallingComponent,
    SignallingDetailComponent,
    SignallingDialogComponent,
    SignallingPopupComponent,
    SignallingDeletePopupComponent,
    SignallingDeleteDialogComponent,
    signallingRoute,
    signallingPopupRoute,
    SignallingResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...signallingRoute,
    ...signallingPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        SignallingComponent,
        SignallingDetailComponent,
        SignallingDialogComponent,
        SignallingDeleteDialogComponent,
        SignallingPopupComponent,
        SignallingDeletePopupComponent,
    ],
    entryComponents: [
        SignallingComponent,
        SignallingDialogComponent,
        SignallingPopupComponent,
        SignallingDeleteDialogComponent,
        SignallingDeletePopupComponent,
    ],
    providers: [
        SignallingService,
        SignallingPopupService,
        SignallingResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendSignallingModule {}
