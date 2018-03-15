import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClassifyComponent } from './classify/classify.component';
import { NgModule } from '@angular/core';
import { MyDatePickerModule } from 'mydatepicker';
import { classifyRouting } from './sample-classify.routing';
import { SampleClassifyComponent } from './sample-classify.component';
import { AppTranslationModule } from '../../app.translation.module';
import { NG2DataTableModule } from 'angular2-datatable-pagination';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgaModule } from '../../theme/nga.module';
import { ClassifyAddComponent } from './classify-add/classify-add.component';
import { TableComponent } from './data-table/table.component';
import { SampleClassifyService } from './sample-classify.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';
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
    classifyRouting,
  ],
  declarations: [
    ClassifyComponent,
    ClassifyAddComponent,
    SampleClassifyComponent,
    TableComponent,
  ],
  entryComponents: [
    ClassifyAddComponent,
  ],
  providers: [
    GetJsonHttpService,
    SampleClassifyService,
  ],
})

export class SampleClassifyModule {}

