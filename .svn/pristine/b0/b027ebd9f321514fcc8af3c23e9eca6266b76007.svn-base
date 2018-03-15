import { Component } from '@angular/core';
import {NavController, NavParams, ToastController} from 'ionic-angular';
import {environment} from "../../environments/environment";
import {SelectItem} from "../common/select-item";
import {INDICATOR_TYPES} from "./exception-cause.constants";
import {CauseResultPage} from "./causeResult/causeResult";

/**
 * Generated class for the ExceptionCausePage page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-exception-cause',
  templateUrl: 'exception-cause.html',
})
export class ExceptionCausePage {

  public cellType: string = 'network';
  public cellInput = "";
  public date: any;
  public indicatorType = "attachFault";
  private _indicatorTypes: SelectItem[] = INDICATOR_TYPES;

  public env = environment;

  constructor(public navCtrl: NavController, public navParams: NavParams,public toastCtrl: ToastController) {
    // this.date = new Date().toISOString();   //当前时间
    this._indicatorTypes;
    this.date = new Date('2016-08-22').toISOString();    //测试时使用的时间
  }

  doSearch(){

    if(this.cellType != "network"){
      if(this.cellInput.length < 1 ){
        this.toastCtrl.create({
          message: '请填写'+this.cellType.toUpperCase()+"指标",
          position: 'top',
          duration: 3000
        }).present();
        return;
      }
    }

    let date = new Date(this.date);
    let searchValue={
      "cellType": this.cellType,
      "cellInput": this.cellInput,
      "indicatorType": this.indicatorType,
      "date1": {
        "date": {
          "day": date.getDate(),
          "month": date.getMonth()+1,
          "year": date.getFullYear()
        }
      }
    };
    this.navCtrl.push(CauseResultPage,{
      searchValue: searchValue
    })
  }

}
