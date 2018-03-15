import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TrainComponent } from './train/train.component';
import { NgModule } from '@angular/core';
import { MyDatePickerModule } from 'mydatepicker';
import { trainRouting } from './sample-train.routing';
import { SampleTrainComponent } from './sample-train.component';
import { AppTranslationModule } from '../../app.translation.module';
import { NG2DataTableModule } from 'angular2-datatable-pagination';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgaModule } from '../../theme/nga.module';
import { TrainAddComponent } from './train-add/train-add.component';
import { TableComponent } from './data-table/table.component';
import { SampleTrainService } from './sample-train.service';
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
        trainRouting,
    ],
    declarations: [
        TrainComponent,
       TrainAddComponent,
        SampleTrainComponent,
      TableComponent,
    ],
    entryComponents: [
      TrainAddComponent,
    ],
    providers: [
      GetJsonHttpService,
      SampleTrainService,
    ],
})

export class SampleTrainModule {}
