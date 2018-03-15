import { Routes, RouterModule } from '@angular/router';

import { UserSettingComponent } from './user-setting.component';
import { ModuleWithProviders } from '@angular/core';

export const routes: Routes = [
  {
    path: '',
    component: UserSettingComponent,
    children: [
    ],
  },
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
