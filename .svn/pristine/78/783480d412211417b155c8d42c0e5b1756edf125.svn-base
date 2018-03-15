/**
 * Created by yangch on 2017/7/18.
 */
import { Component } from '@angular/core';
import {Alert, AlertController, NavController} from 'ionic-angular';
import {AnalysisCond} from "./condition";
import {IndicatorsService} from "../common/indicatorService";
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";
import {PerceptionAnalysisChart} from "./analysisChart/analysisChart";
import {HomePage} from "../home/home";

@Component({
  selector: 'page-perception-analysis',
  templateUrl: 'perceptionAnalysis.html'
})
export class PerceptionAnalysisPage {
  submmitted= false;
  onSubmit(){ this.submmitted= true }
  time = new Date().toISOString();
  indicatorNames=[];
  public env = environment;
  cond = new AnalysisCond(new Date().toISOString(),"network",null,"uu",null);
  constructor(public navCtrl: NavController,
    public alertCtrl: AlertController,
    public http: Http,
    public indicatorService : IndicatorsService) {
    for(let indic of this.indicatorService.getIndicatorsSelects("uu")){
      this.indicatorNames.push(indic.name);
    }
    this.cond.interfaceName =this.indicatorNames;
  }

  fillIndicatorType(interfaceType){
    //console.log(interfaceType);
    this.indicatorNames = [];
    let indicatorTypes=["uu","mr","x2","brd31","brd39"];
    for(let indi of indicatorTypes){
      if(interfaceType == indi){
        for(let indic of this.indicatorService.getIndicatorsSelects(indi)){
          this.indicatorNames.push(indic.name);
        }
        this.cond.interfaceName=this.indicatorNames;
      }
    }
  }


  doSearch(){
    let interName=document.getElementById("interfaceName").innerText;
    let interN=[];
    for(let inter of interName.split(",")){
      //console.log(inter.trim());
      interN.push(inter.trim()) ;
    }
    //console.log(this.cond.subIndic);
    if(this.cond.subIndic==null && this.cond.indicator !="network" ){
      let alert = this.alertCtrl.create({
        title: this.cond.indicator+'不能为空',
        buttons:['确定']
      });
      alert.present();
      return false;
    }
    //console.log(interN.length);
    if(interN.length>5 ||interN.toString().trim()==='请选择'  ){
      let alert = this.alertCtrl.create({
        title: '指标选择最多五项，最少一项',
        buttons:['确定']
      });
      alert.present();
      return false;
    }
    let url ="/api/indicator/" + this.cond.interfaceType + '/hour/' +this.cond.indicator
    +"?date=" + Math.round((new Date(this.cond.time)).setHours(8,0,0,0));

    switch (this.cond.indicator){
      case 'imsi':
        url = url + '&imsi=' + this.cond.subIndic;
        break;
      case 'eci':
        url = url + '&eci=' + this.cond.subIndic;
        break;
      default:
        break;
    }
    this.navCtrl.push(PerceptionAnalysisChart,
      {  url:  url,
        interfaceNames: interN,
        interfaceType: this.cond.interfaceType
      });

  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }
}

