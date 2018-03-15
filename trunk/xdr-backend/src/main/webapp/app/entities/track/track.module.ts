import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BackendSharedModule } from '../../shared';
import {
    TrackService,
    TrackPopupService,
    TrackComponent,
    TrackDetailComponent,
    TrackDialogComponent,
    TrackPopupComponent,
    TrackDeletePopupComponent,
    TrackDeleteDialogComponent,
    trackRoute,
    trackPopupRoute,
    TrackResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...trackRoute,
    ...trackPopupRoute,
];

@NgModule({
    imports: [
        BackendSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        TrackComponent,
        TrackDetailComponent,
        TrackDialogComponent,
        TrackDeleteDialogComponent,
        TrackPopupComponent,
        TrackDeletePopupComponent,
    ],
    entryComponents: [
        TrackComponent,
        TrackDialogComponent,
        TrackPopupComponent,
        TrackDeleteDialogComponent,
        TrackDeletePopupComponent,
    ],
    providers: [
        TrackService,
        TrackPopupService,
        TrackResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendTrackModule {}
