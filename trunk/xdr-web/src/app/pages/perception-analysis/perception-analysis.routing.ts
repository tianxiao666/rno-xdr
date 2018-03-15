import { Routes, RouterModule } from '@angular/router';

import { PerceptionAnalysisComponent } from './perception-analysis.component';
import { ModuleWithProviders } from '@angular/core';

export const routes: Routes = [
  {
    path: '',
    component: PerceptionAnalysisComponent,
    children: [
    ],
  },
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
