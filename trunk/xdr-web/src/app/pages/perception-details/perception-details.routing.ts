import { Routes, RouterModule } from '@angular/router';
import { PerceptionDetailsComponent } from './perception-details.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: PerceptionDetailsComponent,
  },
];

export const routing = RouterModule.forChild(routes);
