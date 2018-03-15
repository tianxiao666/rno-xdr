import { Component } from '@angular/core';
import {NavController, ToastController, Events, NavParams, AlertController} from 'ionic-angular';
import {environment} from "../../../environments/environment";
import {Storage} from "@ionic/storage";
import {ExceptionStatService} from "./exception-stats.service";
import {Head, HEADDATA} from "./head-data";
import {HomePage} from "../../home/home";

@Component({
  selector: 'page-stats-result',
  templateUrl: 'statsResult.html',
  providers: []
})

export class StatsResultPage {

  env = environment;
  public data: any;
  props= [];
  datas= [];
  oneData=[];
  private _exceptionHeadItems: Head[] = HEADDATA;
  private finalCond: any;
  constructor(public navCtrl: NavController, public navParams: NavParams
              , public events: Events, public alertCtrl: AlertController
              , public storage: Storage, public toastCtrl: ToastController
              , private _analysisService: ExceptionStatService) {
    this.finalCond = navParams.get("finalCond");
    this._analysisService.getData(this.finalCond)
      .then(data => {
        if (data.json.length === 0) {
          let alert = this.alertCtrl.create({
            message: '未查询到数据',
            buttons: [{
              text: 'OK'
            }]
          });
          alert.onDidDismiss(()=>{
            this.events.publish("popToLastPage","");
          });
          alert.present();
        }else{
          // const totalItems = data.headers.get('X-Total-Count');
          this.data = data.json;
          for (const i of this._exceptionHeadItems) {
            this.props.push(i['header']);
          }
          for(let re of this.data){
            this.oneData=[];
            for(let a in re){
                this.oneData.push(re[a]);
            }
            this.datas.push(this.oneData);
          }
        }
      });
  }

  doInfinite(infiniteScroll): Promise<any> {

    return new Promise((resolve, reject) => {
      setTimeout(() => {
        this.finalCond.activePage +=1;
        this._analysisService.getData(this.finalCond)
          .then(data => {
            if (data.json.length === 0) {
              let alert = this.alertCtrl.create({
                message: '未查询到数据',
                buttons: [{
                  text: 'OK'
                }]
              });
              alert.onDidDismiss(()=>{
                this.events.publish("popToLastPage","");
              });
              alert.present();
            }else{
              // const totalItems = data.headers.get('X-Total-Count');
              this.data = data.json;
              for(let re of this.data){
                this.oneData=[];
                for(let a in re){
                  this.oneData.push(re[a]);
                }
                this.datas.push(this.oneData);
              }
            }
          });
        infiniteScroll.complete();
      }, 500);
    });
  }

  download(){
    this.finalCond.activePage = -1;
    this.finalCond.rowsOnPage = -1;
    this.finalCond.operateType = "download";
    this._analysisService.getData(this.finalCond);
  }
  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

}


