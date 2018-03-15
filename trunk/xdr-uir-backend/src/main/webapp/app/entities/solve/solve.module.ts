import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    SolveService,
    SolvePopupService,
    SolveComponent,
    SolveDetailComponent,
    SolveDialogComponent,
    SolvePopupComponent,
    SolveDeletePopupComponent,
    SolveDeleteDialogComponent,
    solveRoute,
    solvePopupRoute,
} from './';

const ENTITY_STATES = [
    ...solveRoute,
    ...solvePopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        SolveComponent,
        SolveDetailComponent,
        SolveDialogComponent,
        SolveDeleteDialogComponent,
        SolvePopupComponent,
        SolveDeletePopupComponent,
    ],
    entryComponents: [
        SolveComponent,
        SolveDialogComponent,
        SolvePopupComponent,
        SolveDeleteDialogComponent,
        SolveDeletePopupComponent,
    ],
    providers: [
        SolveService,
        SolvePopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendSolveModule {}
