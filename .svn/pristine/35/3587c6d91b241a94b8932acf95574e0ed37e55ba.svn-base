import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { passwordResetInitRoute } from './init/password-reset-init.route';
import { passwordResetFinishRoute } from './finish/password-reset-finish.route';

export const routes: Routes = [
  {
    path: '',
    children: [
      { path: '', redirectTo: 'request', pathMatch: 'full' },
      passwordResetInitRoute,
      passwordResetFinishRoute,
    ],
  },
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
