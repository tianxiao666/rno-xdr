import {Component} from "@angular/core";
import {environment} from "../../environments/environment";
import {AnalysisCond} from "../perception-analysis/condition";
import {AlertController, LoadingController, NavController, Platform, ToastController} from "ionic-angular";
import {PerceptionDetailsResult} from "./detailResult/perceptionDetailResult";
import {Http, Headers,RequestOptions, ResponseContentType} from "@angular/http";
import {IndicatorsService} from "../common/indicatorService";
import {HomePage} from "../home/home";
import {Storage} from "@ionic/storage";
import {saveAs} from 'file-saver';
import {File} from "@ionic-native/file";
import {FileTransfer, FileTransferObject} from "@ionic-native/file-transfer";
/**
 * Created by yangch on 2017/7/24.
 */
@Component({
  selector: 'page-perception-details',
  templateUrl: 'perceptionDetails.html',
  providers: [IndicatorsService,File,FileTransfer,FileTransferObject]
})
export class PerceptionDetailsPage {

  submmitted= false;
  onSubmit(){ this.submmitted= true }
  time = new Date().toISOString();
  indicatorNames=[];
  public env = environment;
  page = 0;
  public dataId: any;
  public dataName:any;
  cond = new AnalysisCond(new Date().toISOString(),"network",null,"uu",null);

  constructor(public navCtrl: NavController,
              public loadingCtrl: LoadingController,
              public alertCtrl: AlertController,
              public platform: Platform,
              private http: Http,
              private file: File,
              private fileTransfer: FileTransfer,
              private storage: Storage,
              public toastCtrl: ToastController){
  }

  doSearch(){
    if((this.cond.subIndic==null || this.cond.subIndic.trim()=='')&& this.cond.indicator !="network" ){
      let alert = this.alertCtrl.create({
        title: this.cond.indicator+'不能为空',
        buttons:['确定']
      });
      alert.present();
      return false;
    }
    let url = `/api/indicator/`+this.cond.interfaceType+`/detail/`
          +this.cond.indicator+`?date=`+Math.round((new Date(this.cond.time)).setHours(8,0,0,0))
        +`&page=`+this.page+`&size=`+25;
    switch (this.cond.indicator) {
      case 'imsi':
        url += `&imsi=`+this.cond.subIndic.toString().trim();
        break;
      case 'eci':
        url += `&eci=`+this.cond.subIndic.toString().trim();
        break;
      default:
        break;
    }
    this.navCtrl.push(PerceptionDetailsResult, {
        url:url,
        interfaceType:this.cond.interfaceType,
        indicator: this.cond.indicator,
        subIndic: this.cond.subIndic,
        time: this.cond.time,
        page: this.page
      });
  }

  doExport(){
    if(this.cond.indicator=='network'){
      let alert = this.alertCtrl.create({
        title: '数据较多，请指定范围IMSI或ECI进行导出',
        buttons:['确定']
      });
      alert.present();
      return false;
    }
    //console.log(this.cond.subIndic);
    if(this.cond.subIndic ==null || this.cond.subIndic.toString().trim()==''){
      let alert = this.alertCtrl.create({
        title: this.cond.indicator+'为必填项',
        buttons:['确定']
      });
      alert.present();
      return false;
    }

    let url = `/api/indicator/mobile/detail/download/`+this.cond.interfaceType
          +`/`+this.cond.indicator+`?date=`+Math.round((new Date(this.cond.time)).setHours(8,0,0,0));
    switch (this.cond.indicator) {
      case `imsi`:
        url += `&imsi=`+this.cond.subIndic.toString().trim();
        break;
      case `eci`:
        url += `&eci=` + this.cond.subIndic.toString().trim();
      default:
        break;
    }
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
            this.file.externalRootDirectory+"/"+this.cond.interfaceType+'接口提取结果.xlsx',
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
              saveAs(new Blob([res.blob()],{type: 'application/x.ms-excel'}),this.cond.interfaceType+'接口提取结果.xlsx');
              loading.dismiss();
            })
        }
      });

        }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

}
