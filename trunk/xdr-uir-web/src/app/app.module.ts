import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgJhipsterModule } from 'ng-jhipster';

import { customHttpProvider } from './theme/interceptors';

/*
 * Platform and Environment providers/directives/pipes
 */
import { routing } from './app.routing';

// AppComponent is our top level component
import { AppComponent } from './app.component';
import { AppState, InternalStateType } from './app.service';
import { GlobalState } from './global.state';
import { NgaModule } from './theme/nga.module';
import { PagesModule } from './pages/pages.module';
import { AuthGuard } from './theme/guards/auth.guard';
import { JhiModuleConfig } from 'ng-jhipster/src/config';


// Application wide providers
const APP_PROVIDERS = [
  AppState,
  GlobalState,
  AuthGuard,
  customHttpProvider(),
];

export type StoreType = {
  state: InternalStateType,
  restoreInputValues: () => void,
  disposeOldHosts: () => void,
};

/**
 * `AppModule` is the main entry point into Angular2's bootstraping process
 */
@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
  ],
  imports: [ // import Angular's modules
    BrowserModule,
    HttpModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    NgaModule.forRoot(),
    NgbModule.forRoot(),
    PagesModule,
    routing,
    NgJhipsterModule.forRoot(<JhiModuleConfig>{}),
  ],
  providers: [ // expose our Services and Providers into Angular's dependency injection
    APP_PROVIDERS,
  ],
})

export class AppModule {

  constructor(public appState: AppState) {
  }
}
