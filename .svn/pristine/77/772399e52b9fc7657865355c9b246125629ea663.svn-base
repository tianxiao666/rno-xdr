import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    RecordService,
    RecordPopupService,
    RecordComponent,
    RecordDetailComponent,
    RecordDialogComponent,
    RecordPopupComponent,
    RecordDeletePopupComponent,
    RecordDeleteDialogComponent,
    recordRoute,
    recordPopupRoute,
} from './';

const ENTITY_STATES = [
    ...recordRoute,
    ...recordPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        RecordComponent,
        RecordDetailComponent,
        RecordDialogComponent,
        RecordDeleteDialogComponent,
        RecordPopupComponent,
        RecordDeletePopupComponent,
    ],
    entryComponents: [
        RecordComponent,
        RecordDialogComponent,
        RecordPopupComponent,
        RecordDeleteDialogComponent,
        RecordDeletePopupComponent,
    ],
    providers: [
        RecordService,
        RecordPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendRecordModule {}
