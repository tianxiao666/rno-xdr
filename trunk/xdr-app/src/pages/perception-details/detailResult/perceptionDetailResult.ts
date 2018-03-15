import {Component} from "@angular/core";
import {Http} from "@angular/http";
import {AlertController, Events, LoadingController, NavController, NavParams, ToastController} from "ionic-angular";
import {environment} from "../../../environments/environment";
import {HomePage} from "../../home/home";
import {NetworkService} from "../../common/networkService";

@Component({
  selector:'page-perception-details-result',
  templateUrl:'perceptionDetailResult.html'
})
export class PerceptionDetailsResult{
  interfaceType='';
  public data:any;
  env =environment;
  props= [];
  datas= [];
  oneData=[];
  constructor(public http: Http,
              public navCtrl: NavController,
              public navParams: NavParams,
              public loadingCtrl: LoadingController,
              public toastCtrl: ToastController,
              public alertCtrl: AlertController,
              public networkService: NetworkService,
              public events: Events){
    this.interfaceType=this.navParams.data.interfaceType;
    this.networkService.loadWithTokenByGET(this.navParams.data.url)
      .then(
        data => {
          //console.log(data['content']);
          if(data['content'].toString()== ''){
            let alert = this.alertCtrl.create({
              title:'抱歉，无查询结果',
              buttons:['OK']
            });
            alert.onDidDismiss(()=>{
              this.events.publish("popToLastPage","");
            });
            alert.present();
          }else{
            this.data =data['content'] ;
            console.log(this.data);
            for(let re of this.data){
              if(this.data.indexOf(re) == 0){
                for(let r in re){
                  if(r!='id'){
                    if(r=='pdate'){
                      this.props.push('日期');
                    }else if(r =='phour'){
                      this.props.push('小时');
                    }else{
                      this.props.push(r);
                    }

                  }

                }
              }
            }
            for(let re of this.data){
              this.oneData=[];
              for(let a in re){
                if(a != 'id'){
                  this.oneData.push(re[a]);
                }

              }
              this.datas.push(this.oneData);
            }
          }

      }) .catch( error => {
    })
  }

  doInfinite(infiniteScroll): Promise<any> {
    let page = this.navParams.data.page +1;
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        let url = `/api/indicator/`+this.navParams.data.interfaceType+`/detail/`
          +this.navParams.data.indicator+`?date=`+Math.round((new Date(this.navParams.data.time)).setHours(8,0,0,0))
          +`&page=`+page+`&size=`+25;
        switch (this.navParams.data.indicator){
          case 'imsi':
            url += `&imsi=`+this.navParams.data.subIndic;
            break;
          case 'eci':
            url += `&eci=`+this.navParams.data.subIndic;
            break;
          default:
            break;
        }

        this.networkService.loadWithTokenByGetNoBack(url)
          .then( data => {
            this.data =data['content'] ;
            //console.log(this.data);
            for(let re of this.data){
              this.oneData=[];
              for(let a in re){
                if(a != 'id'){
                  this.oneData.push(re[a]);
                }
              }
              this.datas.push(this.oneData);
            }
            resolve(this.datas);
          });
        infiniteScroll.complete();
      }, 500);
    });
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }
}
