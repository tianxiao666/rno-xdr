import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AngularEchartsModule } from 'ngx-echarts';

import { PerceptionTrendComponent } from './perception-trend.component';
import { routing } from './perception-trend.routing';

import { TrendComponent } from './trend/trend.component';
import { MultiselectDropdownModule } from 'angular-2-dropdown-multiselect';
import { IndicatorsService } from '../common/indicators.service';
import { PerceptionTrendService } from './perception-trend.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { DateParseService } from '../common/date-parse.service';
import { MyDatePickerModule } from 'mydatepicker';
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AppTranslationModule,
    NgaModule,
    routing,
    NgbModule,
    AngularEchartsModule,
    MultiselectDropdownModule,
    MyDatePickerModule,
  ],
  declarations: [
    PerceptionTrendComponent,
    TrendComponent,
  ],
  providers: [
    IndicatorsService,
    PerceptionTrendService,
    GetJsonHttpService,
    DateParseService,
  ],
})
export class PerceptionTrendModule {
}

