import { Routes, RouterModule } from '@angular/router';
import { DataImportComponent } from './data-import.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: DataImportComponent,
  },
];

export const routing = RouterModule.forChild(routes);
