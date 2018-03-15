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
        redirectTo: 'data-import',
        pathMatch: 'full',
      },
      { path: 'data-import',
        loadChildren: './data-import/data-import.module#DataImportModule',
      },
      { path: 'data-search',
        loadChildren: './data-search/data-search.module#DataSearchModule',
      },
      { path: 'sample-train',
        loadChildren: './sample-train/sample-train.module#SampleTrainModule',
      },
      { path: 'sample-test',
        loadChildren: './sample-test/sample-test.module#SampleTestModule',
      },
      { path: 'sample-classify',
        loadChildren: './sample-classifiy/sample-classify.module#SampleClassifyModule',
      },
      { path: 'data-stats',
        loadChildren: './data-stats/data-statistics.module#DataStatisticsModule',
      },
      { path: 'user-setting',
        loadChildren: './user-setting/user-setting.module#UserSettingModule',
      },
    ],
  },
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
