import { Routes, RouterModule }  from '@angular/router';
import { SignalingEventTrackComponent } from './signaling-event-track.component';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: '',
    component: SignalingEventTrackComponent,
  }
];

export const routing = RouterModule.forChild(routes);
