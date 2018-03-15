import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import { AppTranslationModule } from '../../app.translation.module';

import { routing } from './user-setting.routing';

import { UserSettingComponent } from './user-setting.component';
import { UserSettingService } from './user-setting.service';
import { GetJsonHttpService } from '../common/getJsonHttp.service';

@NgModule({
  imports: [
    CommonModule,
    AppTranslationModule,
    FormsModule,
    ReactiveFormsModule,
    NgaModule,
    routing,
  ],
  declarations: [
    UserSettingComponent,
  ],
  providers: [
    UserSettingService,
    GetJsonHttpService,
  ],
})
export class UserSettingModule {
}

