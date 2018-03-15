import {Component} from "@angular/core";
import {HomePage} from "../../home/home";
import {AlertController, NavController, NavParams} from "ionic-angular";
import {NetworkService} from "../../common/networkService";
import {IndicatorsService} from "../../common/indicatorService";
/**
 * Created by yangch on 2017/8/8.
 */

@Component({
  selector: 'page-recall-result',
  templateUrl: 'recallResult.html'
})

export class RecallResultPage{
  data: any;
  props = [];
  datas = [];
  oneData = [];
  public constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public networkService: NetworkService,
    public indicatorService: IndicatorsService){
    this.networkService.loadWithTokenByGET(this.navParams.data.url).then(
      data => {
        this.data=data;
        console.log(this.data);
      if(this.data ==null){
        let alert = this.alertCtrl.create({
          title: '抱歉，无查询结果！',
          buttons: ['确定']
        })
        alert.present();
      }else{
        //console.log(this.data);
        for(let re of this.data){
          if(this.data.indexOf(re) == 0){
            for(let r in re){
              if( r != 'id'){
                this.props.push(this.indicatorService.getIndicatorNamebyID('signaling',r));
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
      }
    )

  }
  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

  doInfinite(infiniteScroll): Promise<any>{
    let page = this.navParams.data.page +1;
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        let url = `/api/signallings/findByTimeAndImsi?beginTime=`+this.navParams.data.begin +`&endTime=`+this.navParams.data.end
          +`&imsi=`+ this.navParams.data.imsi +`&page=`+page+`&size=`+25;

        this.networkService.loadWithTokenByGetNoBack(url)
          .then( data => {
            this.data =data ;
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
}
