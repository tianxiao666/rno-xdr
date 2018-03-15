import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { SignalingComponent } from './signaling/signaling.component';
import { routing }  from './signaling-event-track.routing';

import { AppTranslationModule } from '../../app.translation.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NG2DataTableModule } from 'angular2-datatable-pagination';

import { SignalingEventTrackService } from './signaling-event-track.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';

import { SignalingEventTrackComponent } from './signaling-event-track.component';
import { MyDatePickerModule } from 'mydatepicker';

import { ExcelService } from './signaling/export-to-excel';
import { TableComponent } from './data-table/table.component';


@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    NgbModule,
    AppTranslationModule,
    MyDatePickerModule,
    NG2DataTableModule,
    routing,
  ],
  declarations: [
    SignalingEventTrackComponent,
    SignalingComponent,
    TableComponent,
  ],
  providers: [
    SignalingEventTrackService,
    GetJsonHttpService,
    ExcelService,
  ],
})
export class SignalingEventTrackModule { }
