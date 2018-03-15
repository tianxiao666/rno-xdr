import { RouterModule, Routes } from '@angular/router';
import { SampleTestComponent } from './sample-test.component';
export const routes: Routes = [
  {
    path: '',
    component: SampleTestComponent,

  },
];
export const testRouting = RouterModule.forChild(routes);

