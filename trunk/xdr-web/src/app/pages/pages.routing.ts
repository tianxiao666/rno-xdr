import { Routes, RouterModule } from '@angular/router';
import { PagesComponent } from './pages.component';
import { ModuleWithProviders } from '@angular/core';

import { AuthGuard } from '../theme/guards';
import { loginRoutes } from './login/login.routing';

export const routes: Routes = [
  {
    path: 'login',
    children : loginRoutes,
  },
  {
    path: 'register',
    loadChildren: 'app/pages/register/register.module#RegisterModule',
  },
  {
    path: 'reset',
    loadChildren: 'app/pages/password-reset/password-reset.module#PasswordResetModule',
  },
  {
    path: 'pages',
    component: PagesComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '',
        redirectTo: 'perception-analysis',
        pathMatch: 'full',
      },
      { path: 'perception-analysis',
        loadChildren: './perception-analysis/perception-analysis.module#PerceptionAnalysisModule',
      },
      { path: 'perception-trend',
        loadChildren: './perception-trend/perception-trend.module#PerceptionTrendModule',
      },
      { path: 'perception-details',
        loadChildren: './perception-details/perception-details.module#PerceptualDetailsModule',
      },
      { path: 'exception-cause',
        loadChildren: './exception-cause/exception-cause.module#ExceptionCauseModule',
      },
      { path: 'exception-stats',
        loadChildren: './exception-stats/exception-stats.module#ExceptionStatsModule',
      },
      { path: 'track-present',
        loadChildren: './track-present/track-present.module#TrackPresentModule',
      },
      { path: 'signaling-event-track',
        loadChildren: './signaling-event-track/signaling-event-track.module#SignalingEventTrackModule',
      },
      { path: 'user-setting',
        loadChildren: './user-setting/user-setting.module#UserSettingModule',
      },
    ],
  },
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
