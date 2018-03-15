import { Component } from '@angular/core';
import {AlertController, NavController, ToastController} from 'ionic-angular';
import {Storage} from "@ionic/storage";
import {HomePage} from "../home/home";
import {SelectItem} from "../common/select-item";
import {Sel, SELE} from "./select-data";
import {FinalSearchCond} from "./final-search-cond";
import {StatsResultPage} from "./statsResult/statsResult";
import {FileTransfer, FileTransferObject} from "@ionic-native/file-transfer";
import {File} from "@ionic-native/file";
import {ExceptionStatService} from "./statsResult/exception-stats.service";
import {IndicatorsService} from "../common/indicatorService";

@Component({
  selector: 'page-exception-stats',
  templateUrl: 'exception-stats.html',
  providers: [IndicatorsService,File,FileTransfer,FileTransferObject]
})
export class ExceptionStatsPage {

  public cellType: string = "network";
  public cellInput: string = "";
  public date1: any;

  public logicalOperationone: string = "and";
  public indicatorSelectitemone: string = "attach_fault_rate";
  public operatorone: string = "=";
  public selone: number = 1;

  public logicalOperationtwo: string = "and";
  public indicatorSelectitemtwo: string = "attach_request";
  public operatortwo: string = "=";
  public seltwo: number = 1;

  public logicalOperationthree: string = "and";
  public indicatorSelectitemthree: string = "attach_fault";
  public operatorthree: string = "=";
  public selthree: number = 1;

  public rowsOnPage: any = 25;
  public activePage: any = 0;

  constructor(public navCtrl: NavController, public storage: Storage,
              private toastCtrl: ToastController,
              public alertCtrl: AlertController,
              private _analysisService: ExceptionStatService) {
    // this.date = new Date().toISOString();   //当前时间
    this.date1 = new Date('2016-08-22').toISOString();    //测试时使用的时间
    this._exceptionSelectItems;
    this._logicalOperation;
    this._logicalOperations;
    this._cellTypes;
    this._operators;

    let selItem = document.getElementById("selInputItem");
    let selInputOne = document.getElementById("selInputOne");
    let selInputTwo = document.getElementById("selInputTwo");
    let selInputThree = document.getElementById("selInputThree");

    // let h = selItem.height;
    // selInputOne.height = h +"px";
    // selInputTwo.style.height = h +"px";
    // selInputThree.style.height = h +"px";
  }

  private _exceptionSelectItems: Sel[] = SELE;

  private _logicalOperation: SelectItem[] = [
    { label: 'and', value: 'and' },
  ];
  private _logicalOperations: SelectItem[] = [
    { label: 'and', value: 'and' },
    { label: 'or', value: 'or' },
  ];
  private _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: '小区ECI', value: 'eci' },
  ];
  private _operators: SelectItem[] = [
    { label: '=', value: '=' },
    { label: '>', value: '>' },
    { label: '>=', value: '>=' },
    { label: '<', value: '<' },
    { label: '<=', value: '<=' },
  ];



  doSearch(){
    if(this.cellType != "network"){
      if(this.cellInput.length<=0){
        this.toastCtrl.create({
          message: '请输入'+this.cellType.toUpperCase(),
          duration: 3000,
          position: 'top'
        }).present();
        return;
      }
    }

    let d = new Date(this.date1);

    let date: Object = {date: {
      day:  d.getDate(),
      month: d.getMonth()+1,
      year: d.getFullYear()
    }};

    const finalCond = new FinalSearchCond(
      date,
      this.cellType,
      this.cellInput,
      this.logicalOperationone,
      this.indicatorSelectitemone,
      this.operatorone,
      this.selone,
      this.logicalOperationtwo,
      this.indicatorSelectitemtwo,
      this.operatortwo,
      this.seltwo,
      this.logicalOperationthree,
      this.indicatorSelectitemthree,
      this.operatorthree,
      this.selthree,
      this.rowsOnPage,
      this.activePage,
      'query',
    );
    this.navCtrl.push(StatsResultPage,{
      finalCond: finalCond
    })
  }

  doExport(){

    if(this.cellType != "network"){
      if(this.cellInput.length<=0){
        this.toastCtrl.create({
          message: '请输入'+this.cellType.toUpperCase(),
          duration: 3000,
          position: 'top'
        }).present();
        return;
      }
    }

    let d = new Date(this.date1);
    let date: Object = {date: {
      day:  d.getDate(),
      month: d.getMonth()+1,
      year: d.getFullYear()
    }};

    const finalCond = new FinalSearchCond(
      date,
      this.cellType,
      this.cellInput,
      this.logicalOperationone,
      this.indicatorSelectitemone,
      this.operatorone,
      this.selone,
      this.logicalOperationtwo,
      this.indicatorSelectitemtwo,
      this.operatortwo,
      this.seltwo,
      this.logicalOperationthree,
      this.indicatorSelectitemthree,
      this.operatorthree,
      this.selthree,
      -1,
      -1,
      'download',
    );
    this._analysisService.getData(finalCond);
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }
}
