import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgUploaderModule } from 'ngx-uploader';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import { JhiConfigService } from 'ng-jhipster/src/config.service';

import { AppTranslationModule } from '../app.translation.module';
import { AuthModule } from '../pages/auth';
import { LoginService } from '../pages/login';

import { BaThemeConfig } from './theme.config';
import { BaThemeConfigProvider } from './theme.configProvider';

import {
  BaAmChart,
  BaBackTopComponent,
  BaCard,
  BaCardBlur,
  BaChartistChart,
  BaCheckbox,
  BaContentTop,
  BaFullCalendar,
  BaMenuItemComponent,
  BaMenuComponent,
  BaMsgCenter,
  BaMultiCheckbox,
  BaPageBottomComponent,
  BaPageTopComponent,
  BaPictureUploader,
  BaSidebarComponent,
  BaFileUploader,
} from './components';

import {
  BaScrollPosition,
  BaSlimScroll,
  BaThemeRun,
} from './directives';

import {
  BaAppPicturePipe,
  BaKameleonPicturePipe,
  BaProfilePicturePipe,
} from './pipes';

import {
  BaImageLoaderService,
  BaMenuService,
  BaThemePreloader,
  BaThemeSpinner,
} from './services';

import {
  EmailValidator,
  EqualPasswordsValidator,
} from './validators';

const NGA_COMPONENTS = [
  BaAmChart,
  BaBackTopComponent,
  BaCard,
  BaChartistChart,
  BaCheckbox,
  BaContentTop,
  BaFullCalendar,
  BaMenuItemComponent,
  BaMenuComponent,
  BaMsgCenter,
  BaMultiCheckbox,
  BaPageBottomComponent,
  BaPageTopComponent,
  BaPictureUploader,
  BaSidebarComponent,
  BaFileUploader,
];

const NGA_DIRECTIVES = [
  BaScrollPosition,
  BaSlimScroll,
  BaThemeRun,
  BaCardBlur,
];

const NGA_PIPES = [
  BaAppPicturePipe,
  BaKameleonPicturePipe,
  BaProfilePicturePipe,
];

const NGA_SERVICES = [
  BaImageLoaderService,
  BaThemePreloader,
  BaThemeSpinner,
  BaMenuService,
  LoginService,
  JhiEventManager,
  JhiAlertService,
  JhiConfigService,
];

const NGA_VALIDATORS = [
  EmailValidator,
  EqualPasswordsValidator,
];

@NgModule({
  declarations: [
    ...NGA_PIPES,
    ...NGA_DIRECTIVES,
    ...NGA_COMPONENTS,
    BaPageBottomComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    AppTranslationModule,
    NgUploaderModule,
    AuthModule,
  ],
  exports: [
    ...NGA_PIPES,
    ...NGA_DIRECTIVES,
    ...NGA_COMPONENTS,
  ],
})
export class NgaModule {
  static forRoot(): ModuleWithProviders {
    return <ModuleWithProviders> {
      ngModule: NgaModule,
      providers: [
        BaThemeConfigProvider,
        BaThemeConfig,
        ...NGA_VALIDATORS,
        ...NGA_SERVICES,
      ],
    };
  }
}
