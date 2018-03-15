import { Component } from '@angular/core';
import {AlertController, NavController, ToastController} from 'ionic-angular';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {TrackResultPage} from "./trackResult/trackResult";
import {HomePage} from "../home/home";
import {SelectItem} from "../common/select-item";

@Component({
  selector: 'page-track-present',
  templateUrl: 'trackPresent.html'
})
export class TrackPresentPage {

  private imsi: any;
  private indicatorId: any;
  private date: any;
  private beginTime: any;
  private endTime: any;

  public timeOptions = [];

  public indicatorOptions: SelectItem[] = [
    { value: '1', label: 'RRC连接建立' },
    { value: '3', label: 'RRC连接重配' },
    { value: '4', label: 'RRC连接重建' },
    { value: '6', label: '小区内部切换' },
    { value: '7', label: '基站内切换' },
    { value: '8', label: '基站间切换' },
    { value: '10', label: '切出至其他RAT' },
  ];
  constructor(public navCtrl: NavController, public alertCtrl: AlertController
  , public toastCtrl: ToastController) {
    // this.date = new Date().toISOString();   //当前时间
    this.date = new Date('2017-07-18').toISOString();    //测试时使用的时间
    this.imsi= "460000891444152";
    this.indicatorId = 1;
    this.beginTime = 0;
    this.endTime = 23;
  }

  public ngOnInit() {
    for (let i = 0; i < 24; i++) {
      this.timeOptions.push({ value: i.toString(), label: `${i} ` });
    }
  }

  doSearch(){
    let parameters = {
      imsi: this.imsi,
      indicatorId: this.indicatorId,
      date: this.date,
      beginTime: this.beginTime,
      endTime: this.endTime
    };
    this.navCtrl.push(TrackResultPage,{
      params: parameters
    });
  }
  checkTime(source){
    if(this.beginTime>this.endTime){
      if(source=="endTime"){
        this.beginTime = this.endTime;
      }else if(source=="beginTime"){
        this.endTime = this.beginTime;
      }
    }
  }
  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

}

