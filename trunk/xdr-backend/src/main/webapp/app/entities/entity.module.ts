import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { BackendMmeModule } from './mme/mme.module';
import { BackendMrModule } from './mr/mr.module';
import { BackendUhttpModule } from './uhttp/uhttp.module';
import { BackendUuModule } from './uu/uu.module';
import { BackendX2Module } from './x-2/x-2.module';
import { BackendTrackModule } from './track/track.module';
import { BackendExceptionCauseModule } from './exception-cause/exception-cause.module';
import { BackendExceptionStatsModule } from './exception-stats/exception-stats.module';
import { BackendSignallingModule } from './signalling/signalling.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        BackendMmeModule,
        BackendMrModule,
        BackendUhttpModule,
        BackendUuModule,
        BackendX2Module,
        BackendTrackModule,
        BackendExceptionCauseModule,
        BackendExceptionStatsModule,
        BackendSignallingModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BackendEntityModule {}
