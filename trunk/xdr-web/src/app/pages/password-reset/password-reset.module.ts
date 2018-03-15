import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';

import { routing } from './password-reset.route';
import { PasswordResetFinishComponent } from './finish/password-reset-finish.component';
import { PasswordResetInitComponent } from './init/password-reset-init.component';
import { PasswordResetFinishService } from './finish/password-reset-finish.service';
import { PasswordResetInitService } from './init/password-reset-init.service';

@NgModule({
  imports: [
    CommonModule,
    AppTranslationModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    routing,
  ],
  declarations: [
    PasswordResetInitComponent,
    PasswordResetFinishComponent,
  ],
  providers: [
    PasswordResetInitService,
    PasswordResetFinishService,
  ],
})
export class PasswordResetModule {}
