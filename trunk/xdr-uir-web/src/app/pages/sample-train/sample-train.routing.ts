import { RouterModule, Routes } from '@angular/router';
import { SampleTrainComponent } from './sample-train.component';
export const routes: Routes = [
{
    path: '',
    component: SampleTrainComponent,

},
];
export const trainRouting = RouterModule.forChild(routes);
