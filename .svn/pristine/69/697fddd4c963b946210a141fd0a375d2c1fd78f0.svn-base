import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import {PerceptionAnalysisPage} from "../pages/perception-analysis/perceptionAnalysis";
import {PerceptionTrendPage} from "../pages/perception-trend/perceptionTrend";
import {FormsModule} from "@angular/forms";
import {IndicatorsService} from "../pages/common/indicatorService";
import {HttpModule} from "@angular/http";
import {PerceptionAnalysisChart} from "../pages/perception-analysis/analysisChart/analysisChart";
import {TrendResultPage} from "../pages/perception-trend/trendResult/trendResult";
import {PerceptionDetailsPage} from "../pages/perception-details/perceptionDetails";
import {PerceptionDetailsResult} from "../pages/perception-details/detailResult/perceptionDetailResult";
import {LoginPage} from "../pages/login/login";
import {IonicStorageModule} from "@ionic/storage";
import {NetworkService} from "../pages/common/networkService";
import {ExceptionCausePage} from "../pages/exception-cause/exception-cause";
import {CauseResultPage} from "../pages/exception-cause/causeResult/causeResult";
import {TrackPresentPage} from "../pages/track-present/trackPresent";
import {TrackResultPage} from "../pages/track-present/trackResult/trackResult";
import {ExceptionStatsPage} from "../pages/exception-stats/exception-stats";
import {ExceptionStatService} from "../pages/exception-stats/statsResult/exception-stats.service";
import {StatsResultPage} from "../pages/exception-stats/statsResult/statsResult";
import {EventRecallPage} from "../pages/event-recall/eventRecall";
import {RecallResultPage} from "../pages/event-recall/recallResult/recallResult";
import {File} from "@ionic-native/file";
import {FileTransfer} from "@ionic-native/file-transfer";

@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    HomePage,
    PerceptionAnalysisPage,
    PerceptionTrendPage,
    PerceptionAnalysisChart,
    TrendResultPage,
    PerceptionDetailsPage,
    PerceptionDetailsResult,
    ExceptionCausePage,
    CauseResultPage,
    ExceptionStatsPage,
    StatsResultPage,
    TrackPresentPage,
    TrackResultPage,
    EventRecallPage,
    RecallResultPage
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginPage,
    HomePage,
    PerceptionAnalysisPage,
    PerceptionTrendPage,
    PerceptionAnalysisChart,
    TrendResultPage,
    PerceptionDetailsPage,
    PerceptionDetailsResult,
    ExceptionCausePage,
    CauseResultPage,
    ExceptionStatsPage,
    StatsResultPage,
    TrackPresentPage,
    TrackResultPage,
    EventRecallPage,
    RecallResultPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    IndicatorsService,
    NetworkService,
    ExceptionStatService,
    File,
    FileTransfer,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
