import {Component, Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {URLSearchParams, BaseRequestOptions, Headers, Http, RequestOptions} from "@angular/http";
import {AlertController, Events, LoadingController, Nav} from "ionic-angular";
import {Storage} from "@ionic/storage";
import {environment} from "../../environments/environment"

@Component({
  providers: [Nav]
})

@Injectable()
export class NetworkService {

  env = environment;

  constructor(
               public loadingCtrl: LoadingController,
               public alertCtrl: AlertController,
               public storage: Storage,
               public http: Http,
               public events: Events
              ){
  }

  loadWithTokenByGET(params): Promise<any>{
    let loading = this.loadingCtrl.create({
      content: '请稍候...',
    });
    loading.present();
    return new Promise((resolve,reject) => {
      this.storage.get("id_token")
        .then(id_token => {
          let headers = new Headers({'Authorization':'Bearer ' + id_token});
          let options = new RequestOptions({headers: headers});
          this.http.get(this.env.host+params,options)
            .subscribe( data => {
              data = data.json();
              loading.dismiss();
              if(data.toString().length>0){
                resolve(data);
              }else {
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
              }
            },
             error =>{
              loading.dismiss();
               if(error.status == 0 || (error.status >= 500 && error.status < 600)){
                 let alert = this.alertCtrl.create({
                   message: '网络连接失败或服务器正在维护',
                   buttons: [{
                     text: 'OK'
                   }]
                 });
                 alert.onDidDismiss(()=>{
                   this.events.publish("popToLastPage","");
                 });
                 alert.present();
               } else if(error.status == 401 ) {
                 let alert = this.alertCtrl.create({
                   message: '未授权的操作',
                   buttons: [{
                     text: 'OK'
                   }]
                 });
                alert.onDidDismiss(() => {
                   this.events.publish("goto.login", "");
                 });
                 alert.present();
               } else if(error.status == 404) {
                 let alert = this.alertCtrl.create({
                   message: '错误的请求',
                   buttons: [{
                     text: 'OK'
                   }]
                 });
                 alert.onDidDismiss(() => {
                   this.events.publish("popToLastPage", "");
                 });
                 alert.present();
               } else {
                 let alert = this.alertCtrl.create({
                   message: '未知的错误',
                   buttons: [{
                     text: 'OK'
                   }]
                 });
                 alert.onDidDismiss(() => {
                   this.events.publish("goto.login", "");
                 });
                 alert.present();
               }
            })
        })
        .catch( error => {
          console.log(error)
          let alert = this.alertCtrl.create({
            message: '未登录',  //无法找到token
            buttons: [{
              text: 'OK'
            }]
          });
          alert.onDidDismiss(()=>{
            this.events.publish("goto.login","");
          });
          alert.present();
        })
    });
  }

  loadWithTokenByGETGivenHeader(url,searchValue): Promise<any>{     //自定义头
    let loading = this.loadingCtrl.create({
      content: '请稍候...',
    });
    loading.present();
    return new Promise((resolve,reject) => {
      this.storage.get("id_token")
        .then(id_token => {
          const options = this.createRequestOption(searchValue,id_token);
          this.http.get(url,options)
            .subscribe( data => {
                data = data.json();
                loading.dismiss();
                if(data.toString().length>0){
                  resolve(data);
                }else {
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
                }
              },
              error =>{
                loading.dismiss();
                if(error.status == 0 || (error.status >= 500 && error.status < 600)){
                  let alert = this.alertCtrl.create({
                    message: '网络连接失败或服务器正在维护',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.onDidDismiss(()=>{
                    this.events.publish("popToLastPage","");
                  });
                  alert.present();
                } else if(error.status == 401 ) {
                  let alert = this.alertCtrl.create({
                    message: '未授权的操作',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.onDidDismiss(() => {
                    this.events.publish("goto.login", "");
                  });
                  alert.present();
                } else if(error.status == 404) {
                  let alert = this.alertCtrl.create({
                    message: '错误的请求',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.onDidDismiss(() => {
                    this.events.publish("popToLastPage", "");
                  });
                  alert.present();
                } else {
                  let alert = this.alertCtrl.create({
                    message: '未知的错误',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.onDidDismiss(() => {
                    this.events.publish("goto.login", "");
                  });
                  alert.present();
                }
              })
        })
        .catch( error => {
          let alert = this.alertCtrl.create({
            message: '未登录',  //无法找到token
            buttons: [{
              text: 'OK'
            }]
          });
          alert.onDidDismiss(()=>{
            this.events.publish("goto.login","");
          });
          alert.present();
        })
    });
  }

  private createRequestOption(req: any,id_token: any): BaseRequestOptions {
    const options: BaseRequestOptions = new BaseRequestOptions();
    if (req) {
      const params: URLSearchParams = new URLSearchParams();
      if (req.date1) {
        const dateModel = req.date1;
        const date1: Date = new Date(dateModel.date.year, dateModel.date.month - 1, dateModel.date.day);
        const dateMilli: number = date1.setHours(8);
        params.set('date', dateMilli.toString());
      }
      switch (req.cellType) {
        case 'imsi':
          params.append('imsi', req.cellInput);
          break;
        case 'eci':
          params.append('eci', req.cellInput);
          break;
        default:
          break;
      }
      if (req.indicatorType) {
        params.append('indicatorType', req.indicatorType);
      }
      options.params = params;
      options.headers = new Headers({'Authorization':'Bearer ' + id_token});
    }
    return options;
  }

  loadWithTokenByGetNoBack(params): Promise<any>{
    let loading = this.loadingCtrl.create({
      content: '请稍候...',
    });
    loading.present();
    return new Promise((resolve,reject) => {
      this.storage.get("id_token")
        .then(id_token => {
          let headers = new Headers({'Authorization':'Bearer ' + id_token});
          let options = new RequestOptions({headers: headers});
          this.http.get(this.env.host+params,options)
            .subscribe( data => {
                data = data.json();
                loading.dismiss();
                if(data.toString().length>0){
                  resolve(data);
                }else {
                  let alert = this.alertCtrl.create({
                    message: '未查询到数据',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.present();
                }
              },
              error =>{
                loading.dismiss();
                if(error.status == 0 || (error.status >= 500 && error.status < 600)){
                  let alert = this.alertCtrl.create({
                    message: '网络连接失败或服务器正在维护',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.present();
                } else if(error.status == 401 ) {
                  let alert = this.alertCtrl.create({
                    message: '未授权的操作',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.present();
                } else if(error.status == 404) {
                  let alert = this.alertCtrl.create({
                    message: '错误的请求',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.present();
                } else {
                  let alert = this.alertCtrl.create({
                    message: '未知的错误',
                    buttons: [{
                      text: 'OK'
                    }]
                  });
                  alert.present();
                }
              })
        })
        .catch( error => {
          let alert = this.alertCtrl.create({
            message: '未登录',  //无法找到token
            buttons: [{
              text: 'OK'
            }]
          });
          alert.onDidDismiss(()=>{
            this.events.publish("goto.login","");
          });
          alert.present();
        })
    });
  }
}
