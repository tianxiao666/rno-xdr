import { Component } from '@angular/core';
import {AlertController, NavController, ToastController} from 'ionic-angular';
import {IndicatorsService} from "../common/indicatorService";
import {environment} from "../../environments/environment"
import {Http} from "@angular/http";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {TrendResultPage} from "./trendResult/trendResult";
import {HomePage} from "../home/home";

@Component({
  selector: 'page-perception-trend',
  templateUrl: 'perceptionTrend.html',
  providers: [IndicatorsService]
})
export class PerceptionTrendPage {

  public cellType: string = 'network';
  public interfaces: string = 'uu';
  public condition: any =[];
  public beginTime: any;
  public endTime: any;
  public showResultOfCondition = "请选择";
  public cellTypeInput = "";

  public env = environment;

  constructor(public navCtrl: NavController
  , public alertCtrl: AlertController, public _allIndicators: IndicatorsService
  , public http: Http, public toastCtrl: ToastController) {
    // this.beginTime = new Date().toISOString();   //当前时间
    // this.endTime = new Date().toISOString();     //当前时间
    this.beginTime = new Date('2016-08-19').toISOString();    //测试时使用的时间
    this.endTime = new Date('2016-08-26').toISOString();      //测试时使用的时间
  }

  interfacesChange(){
    this.condition = [];
    this.showResultOfCondition = "请选择";
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

  showCheckbox() {
    let alert = this.alertCtrl.create();
    alert.setTitle("指标");
    let nowinterface = this._allIndicators.getIndicatorsSelects(this.interfaces);
    nowinterface.forEach(eachNowInterface => {
      let boo = false;
      this.condition.forEach(eachCondition => {
        if(eachCondition == eachNowInterface.id){
          boo = true;
        }
      });
      if(boo){
        alert.addInput({
          type: 'checkbox',
          label: eachNowInterface.name,
          value: eachNowInterface.id,
          checked: true
        });
      }else{
        alert.addInput({
          type: 'checkbox',
          label: eachNowInterface.name,
          value: eachNowInterface.id
        });
      }
    });
    alert.addButton('Cancel');
    alert.addButton({
      text: 'Okay',
      handler: data => {
        if(data.length > 5){
          this.toastCtrl.create({
            message: '最多选择5项指标',
            position: 'top',
            duration: 3000
          }).present();
          return false;
        }else if(data.length < 1){
          this.toastCtrl.create({
            message: '至少选择1项指标',
            position: 'top',
            duration: 3000
          }).present();
          return false;
        } else{
          this.condition = [];
          nowinterface.forEach( a => {
            data.forEach( eachData => {
              if(a.id == eachData){
                this.condition.push(eachData);
              }
            })
          });
          let name = this._allIndicators.getIndicatorNamebyID(this.interfaces,this.condition[0]);
          this.showResultOfCondition = name+"等共"+this.condition.length+"项";
        }
      }
    });
    alert.present();
  }

  doSearch(){
    if(this.condition.length < 1){
      this.toastCtrl.create({
        message: '至少选择1项指标',
        position: 'top',
        duration: 3000
      }).present();
    } else if(this.cellType =="eci" && this.cellTypeInput.length<1){
      this.toastCtrl.create({
        message: 'ECI为必填项',
        position: 'top',
        duration: 3000
      }).present();
    } else if(this.cellType =="imsi" && this.cellTypeInput.length<1){
      this.toastCtrl.create({
        message: 'IMSI为必填项',
        position: 'top',
        duration: 3000
      }).present();
    } else {
      let bt = Math.round((new Date(this.beginTime)).setHours(8,0,0,0));
      let et = Math.round((new Date(this.endTime)).setHours(8,0,0,0));
      let url = '/api/indicator/' + this.interfaces + '/day/' + this.cellType
        + '?beginDate=' + bt
        + '&endDate=' + et;
      switch (this.cellType) {
        case 'imsi':
          url = url + '&imsi=' + this.cellTypeInput;
          break;
        case 'eci':
          url = url + '&eci=' + this.cellTypeInput;
          break;
        default:
          break;
      }
      this.navCtrl.push(TrendResultPage,{url: url,beginTime: bt,endTime: et,condition: this.condition, interfaces: this.interfaces});
    }
  }
}

