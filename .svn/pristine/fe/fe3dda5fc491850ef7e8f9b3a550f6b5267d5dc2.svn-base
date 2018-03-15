import { Component } from '@angular/core';
import {AlertController, NavController} from 'ionic-angular';
import {PerceptionAnalysisPage} from "../perception-analysis/perceptionAnalysis";
import {PerceptionTrendPage} from "../perception-trend/perceptionTrend";
import {PerceptionDetailsPage} from "../perception-details/perceptionDetails";
import {Storage} from "@ionic/storage";
import {LoginPage} from "../login/login";
import {ExceptionCausePage} from "../exception-cause/exception-cause";
import {TrackPresentPage} from "../track-present/trackPresent";
import {EventRecallPage} from "../event-recall/eventRecall";
import {ExceptionStatsPage} from "../exception-stats/exception-stats";

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, public storage: Storage, public alertCtrl: AlertController) {

  }

  pushPerceptionAnalysis(){
    this.navCtrl.push(PerceptionAnalysisPage);
  }
  pushPerceptionTrend(){
    this.navCtrl.push(PerceptionTrendPage);
  }

  pushPerceptionDetail(){
    this.navCtrl.push(PerceptionDetailsPage);
  }
  pushExceptionCause(){
    this.navCtrl.push(ExceptionCausePage);
  }
  pushExceptionStats(){
    this.navCtrl.push(ExceptionStatsPage);
  }
  pushTrackPresent(){
    this.navCtrl.push(TrackPresentPage);
  }

  pushEventRecall(){
    this.navCtrl.push(EventRecallPage);
  }
  logout(){
    let alert = this.alertCtrl.create({
      message: '是否注销',
      buttons: [ {
        text: 'Cancel'
        },
        {
          text: 'OK',
          handler: () => {
            this.storage.set("id_token","");
            this.navCtrl.setRoot(LoginPage);
          }
        }],
    });
    alert.present();
  }
}
