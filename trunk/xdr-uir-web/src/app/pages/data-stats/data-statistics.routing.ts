import { Routes, RouterModule } from '@angular/router';
import { DataStatisticsComponent } from './data-statistics.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: DataStatisticsComponent,
  },
];

export const routing = RouterModule.forChild(routes);
