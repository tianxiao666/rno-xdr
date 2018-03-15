import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ExceptionCauseComponent } from './exception-cause.component';

// noinspection TypeScriptValidateTypes
export const routes: Routes = [
  {
    path: '',
    component: ExceptionCauseComponent,
  },
];
export const routing: ModuleWithProviders = RouterModule.forChild(routes);
