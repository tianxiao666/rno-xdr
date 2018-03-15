import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AngularEchartsModule } from 'ngx-echarts';
import { MyDatePickerModule } from 'mydatepicker';

import { ExceptionCauseComponent } from './exception-cause.component';
import { ExceptionCauseService } from './exception-cause.service';
import { routing } from './exception-cause.routing';
import { CauseComponent } from './cause/cause.component';

import { DateParseService } from '../common';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgaModule,
    routing,
    NgbModule,
    AngularEchartsModule,
    MyDatePickerModule,
  ],
  declarations: [
    ExceptionCauseComponent,
    CauseComponent,
  ],
  providers: [
    ExceptionCauseService,
    DateParseService,
  ],
})
export class ExceptionCauseModule { }
