import { Routes, RouterModule } from '@angular/router';
import { DataSearchComponent } from './data-search.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: DataSearchComponent,
  },
];

export const routing = RouterModule.forChild(routes);
