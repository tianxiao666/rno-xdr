import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgaModule } from '../../theme/nga.module';
import { AppTranslationModule } from '../../app.translation.module';

import { AuthenticationService } from '../auth';
import { LoginComponent } from './';

@NgModule({
  imports: [
    CommonModule,
    AppTranslationModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
  ],
  declarations: [
    LoginComponent,
  ],
  providers: [
    AuthenticationService,
  ],
})
export class LoginModule {}
