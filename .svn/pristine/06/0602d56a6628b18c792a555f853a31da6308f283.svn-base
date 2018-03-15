import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { MyDatePickerModule } from 'mydatepicker';

import { TrackPresentComponent } from './track-present.component';
import { routing } from './track-present.routing';

import { PresentComponent } from './present/present.component';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { TrackPresentService } from './track-present.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgaModule,
    routing,
    MyDatePickerModule,
  ],
  declarations: [
    TrackPresentComponent,
    PresentComponent,
  ],
  providers: [
    GetJsonHttpService,
    TrackPresentService,
  ],
})
export class TrackPresentModule {
}

