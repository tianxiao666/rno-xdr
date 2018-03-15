import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';

import { PerceptionDetailsComponent } from './perception-details.component';
import { routing } from './perception-details.routing';

import { AppTranslationModule } from '../../app.translation.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { DetailsComponent } from './details/details.component';

import { PerceptualDetailsService } from './perception-details.service';
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
    AppTranslationModule,
    MyDatePickerModule,
    routing,
  ],
  declarations: [
    PerceptionDetailsComponent,
    DetailsComponent,
    TableComponent,
  ],
  providers: [
    PerceptualDetailsService,
    GetJsonHttpService,
    ExcelService,
  ],
})
export class PerceptualDetailsModule {}
