import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TestComponent } from './test/test.component';
import { NgModule } from '@angular/core';
import { MyDatePickerModule } from 'mydatepicker';
import { testRouting } from './sample-test.routing';
import { SampleTestComponent } from './sample-test.component';
import { AppTranslationModule } from '../../app.translation.module';
import { NG2DataTableModule } from 'angular2-datatable-pagination';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgaModule } from '../../theme/nga.module';
import { TestAddComponent } from './test-add/test-add.component';
import { TableComponent } from './data-table/table.component';
import { SampleTestService } from './sample-test.service';
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
    testRouting,
  ],
  declarations: [
    TestComponent,
    TestAddComponent,
    SampleTestComponent,
    TableComponent,
  ],
  entryComponents: [
    TestAddComponent,
  ],
  providers: [
    GetJsonHttpService,
    SampleTestService,
  ],
})

export class SampleTestModule {}

