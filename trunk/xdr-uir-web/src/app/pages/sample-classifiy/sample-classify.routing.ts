import { RouterModule, Routes } from '@angular/router';
import { SampleClassifyComponent } from './sample-classify.component';
export const routes: Routes = [
  {
    path: '',
    component: SampleClassifyComponent,

  },
];
export const classifyRouting = RouterModule.forChild(routes);

