import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { ExceptionStatsComponent } from './exception-stats.component';
import { routing } from './exception-stats.routing';

// import { AppTranslationModule } from '../../app.translation.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ExceptionComponent } from './exception/exception.component';

import { ExceptionStatService } from './exception-stats.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';

import { ExcelService } from '../common/export.service';
import { TableComponent } from './data-table/table.component';
import { NG2DataTableModule } from 'angular2-datatable-pagination';

import { MyDatePickerModule } from 'mydatepicker';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    NgbModule,
    NG2DataTableModule,
    // AppTranslationModule,
    MyDatePickerModule,
    routing,
  ],
  declarations: [
    ExceptionStatsComponent,
    ExceptionComponent,
    TableComponent,
  ],
  providers: [
    ExceptionStatService,
    GetJsonHttpService,
    ExcelService,
  ],
})
export class ExceptionStatsModule {}
