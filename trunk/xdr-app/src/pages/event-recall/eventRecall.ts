import {Component} from "@angular/core";
import {AlertController, LoadingController, NavController, Platform} from "ionic-angular";
import {HomePage} from "../home/home";
import {RecallResultPage} from "./recallResult/recallResult";
import {Storage} from "@ionic/storage";
import {Http, Headers,RequestOptions, ResponseContentType} from "@angular/http";
import {FileTransfer, FileTransferObject} from "@ionic-native/file-transfer";
import {IndicatorsService} from "../common/indicatorService";
import {saveAs} from 'file-saver';
import {File} from "@ionic-native/file";
import {environment} from "../../environments/environment";
/**
 * Created by yangch on 2017/8/7.
 */

@Component({
  selector: 'page-event-recall',
  templateUrl: 'eventRecall.html',
  providers: [IndicatorsService,File,FileTransfer,FileTransferObject]
})

export class EventRecallPage{
  beginTime = [];
  endTime = [];
  beg = '0';
  en = '23';
  imsi:any;
  myDate: any;
  public env = environment;
  constructor(public navCtrl: NavController,
              public storage: Storage,
              public http: Http,
              public loadingCtrl: LoadingController,
              public alertCtrl: AlertController,
              private file: File,
              private fileTransfer: FileTransfer,
              private platform: Platform){
    for(let i = 0; i < 24; i++){
      this.beginTime.push(i);
      this.endTime.push(i);
    }
    this.myDate=new Date('2017-07-17').toISOString();
  }

  checkTime(source){
    //console.log(source);
    if(parseInt(this.beg) > parseInt(this.en)){
      if(source == "en"){
        this.beg = this.en;
      }else if(source == 'beg') {
        this.en = this.beg;
      }
    }
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

  doSearch(){
    let date = new Date(this.myDate);
    let dateMillis =(new Date(date.getFullYear(),date.getMonth(), date.getDate())).setHours(0,0,0,0);
    let begin = dateMillis + parseInt(this.beg)*60*60*1000;
    let end = dateMillis + parseInt(this.en)*60*60*1000;
    let imsi = this.imsi;
    if(imsi == null || imsi.trim() ==''){
      let alert = this.alertCtrl.create({
        title: 'IMSI为必填项',
        buttons:['确定']
      })
      alert.present();
      return false;
    }
    let url = `/api/signallings/findByTimeAndImsi?beginTime=`+begin +`&endTime=`+end
              +`&imsi=`+ imsi +`&page=`+0+`&size=`+25;
    this.navCtrl.push(RecallResultPage , {
      url : url,
      page : 0,
      begin: begin,
      end: end,
      imsi: imsi,
    });
  }

  doExport(){
    let date = new Date(this.myDate);
    let dateMillis =(new Date(date.getFullYear(),date.getMonth(), date.getDate())).setHours(0,0,0,0);
    let begin = dateMillis + parseInt(this.beg)*60*60*1000;
    let end = dateMillis + parseInt(this.en)*60*60*1000;
    let imsi = this.imsi;
    if(imsi == null || imsi.trim() ==''){
      let alert = this.alertCtrl.create({
        title: 'IMSI为必填项',
        buttons:['确定']
      })
      alert.present();
      return false;
    }
    let url = `/api/signallings/mobile/downloadByTimeAndImsi?beginTime=`+begin +`&endTime=`+end
      +`&imsi=`+ imsi;

    this.storage.get("id_token")
      .then( id_token => {
        let loading = this.loadingCtrl.create({
          content: '请稍候...',
          enableBackdropDismiss: true
        });
        loading.present();
        let headers = new Headers({'Authorization':'Bearer ' + id_token});
        let options = new RequestOptions({
          headers : headers,
          responseType: ResponseContentType.Blob});
        if(this.platform.is('mobileweb')){
          location.href=this.env.host+url+'&id_token='+id_token;
          loading.dismiss();
        }else if(this.platform.is('android')){
          const transferObject : FileTransferObject = this.fileTransfer.create();
          transferObject.download(
            this.env.host+url,
            this.file.externalRootDirectory+'/用户信令事件回溯提取结果.xlsx',
            false,options)
            .then((entry) => {
              loading.dismiss();
              let alert = this.alertCtrl.create({
                title: '提取成功，文件位置在SD卡根目录下',
                buttons: ['确定']
              });
              alert.present();
            }, (error) => {
              loading.dismiss();
              let alert2 = this.alertCtrl.create({
                title: '提取失败，请检查应用是否开启存储权限！',
                buttons: ['确定']
              });
              alert2.present();
            });
          loading.present();
        }else{
          this.http.get(this.env.host+url,options)
            .subscribe( res => {
              saveAs(new Blob([res.blob()],{type: 'application/x.ms-excel'}),'用户信令事件回溯提取结果.xlsx');
              loading.dismiss();
            })
        }
      });
  }
}
