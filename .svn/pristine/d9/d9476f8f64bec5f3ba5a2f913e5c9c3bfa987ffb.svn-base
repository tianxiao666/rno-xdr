import { NgModule } from '@angular/core';
import { Http } from '@angular/http';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TranslateService } from '@ngx-translate/core';

export function translatePartialLoader(http: Http) {
  return new TranslateHttpLoader(http);
}

const translateOptions = {
  loader: {
    provide: TranslateLoader,
    useFactory: (translatePartialLoader),
    deps: [Http],
  },
};

@NgModule({
  imports: [TranslateModule.forRoot(translateOptions)],
  exports: [TranslateModule],
  providers: [TranslateService],
})
export class AppTranslationModule {
  constructor(private translate: TranslateService) {
    translate.addLangs(['US/en', 'CN/zh']);
    translate.setDefaultLang('CN/zh');
    translate.use('CN/zh');
  }
}
