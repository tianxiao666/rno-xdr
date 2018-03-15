import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AngularEchartsModule } from 'ngx-echarts';
import { MyDatePickerModule } from 'mydatepicker';

import { PerceptionAnalysisComponent } from './perception-analysis.component';
import { routing } from './perception-analysis.routing';

import { AnalysisComponent } from './analysis/analysis.component';
import { MultiselectDropdownModule } from 'angular-2-dropdown-multiselect';
import { IndicatorsService } from '../common/indicators.service';
import { PerceptionAnalysisService } from './perception-analysis.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
import { DateParseService } from '../common/date-parse.service';

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
    PerceptionAnalysisComponent,
    AnalysisComponent,
  ],
  providers: [
    IndicatorsService,
    PerceptionAnalysisService,
    GetJsonHttpService,
    DateParseService,
  ],
})
export class PerceptionAnalysisModule {
}

