import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { DataSearchComponent } from './data-search.component';
import { routing } from './data-search.routing';

import { AppTranslationModule } from '../../app.translation.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ConditionComponent } from './condition/search.component';

import { DataSearchService } from './data-search.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';

import { ExcelService } from '../common/export.service';
import { TableComponent } from './data-table/table.component';
import { NG2DataTableModule } from 'angular2-datatable-pagination';

import { MyDatePickerModule } from 'mydatepicker';
import { AngularEchartsModule } from 'ngx-echarts';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    NgbModule,
    NG2DataTableModule,
    AppTranslationModule,
    MyDatePickerModule,
    routing,
    AngularEchartsModule,
  ],
  declarations: [
    DataSearchComponent,
    ConditionComponent,
    TableComponent,
  ],
  providers: [
    DataSearchService,
    GetJsonHttpService,
    ExcelService,
  ],
})
export class DataSearchModule {}
