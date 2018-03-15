import { Component } from '@angular/core';
import {NavController, ToastController} from 'ionic-angular';
import {environment} from "../../environments/environment";
import {Headers, Http, RequestOptions} from "@angular/http";
import {Storage} from "@ionic/storage";
import {HomePage} from "../home/home";


@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
  providers: []
})

export class LoginPage {

  public username: string = "";
  public password: string = "";
  public rememberMe: boolean;
  env = environment;

  constructor(public navCtrl: NavController, public http: Http
  , public storage: Storage, public toastCtrl: ToastController) {
    this.storage.get("rememberMe")
      .then(result => {
      if(result){
        this.rememberMe = true;
        this.storage.get("username").then(un=>{
          this.username = LoginPage.decrypt(un);
        }).catch(error =>{});
        this.storage.get("password").then(pw =>{
          this.password = LoginPage.decrypt(pw);
        }).catch(error => {});
      }else {
        this.rememberMe = false;
      }
    })
      .catch(error => {})
  }

  login(){

    if( this.username.length < 1 || this.username.length > 50 ){
      this.toastCtrl.create({
        message: '账号长度小于1或大于50个字符',
        position: 'top',
        duration: 3000
      }).present();
      return;
    }
    if( this.password.length < 4 || this.password.length > 100 ){
      this.toastCtrl.create({
        message: '密码长度小于4或大于100个字符',
        position: 'top',
        duration: 3000
      }).present();
      return;
    }

    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    this.http.post(this.env.host+'/api/authenticate',
      {"username" : this.username,
             "password" : this.password,
             "rememberMe" : this.rememberMe},
      options)
      .map(data => data.json())
      .subscribe(data => {
        this.storage.set("id_token",data.id_token);
        if(this.rememberMe){
          this.storage.set("rememberMe", true);
          this.storage.set("username", LoginPage.encrypt(this.username));
          this.storage.set("password", LoginPage.encrypt(this.password));
        }else {
          this.storage.set("rememberMe",false);
          this.storage.set("username", "");
          this.storage.set("password", "");
        }
        this.navCtrl.setRoot(HomePage);
      },
        error => {
        if( error.status == 401 ){
          this.toastCtrl.create({
            message: '账号或密码错误',
            position: 'top',
            duration: 2000
          }).present();
        }
      })
  }

  static encrypt(code){
    let c=String.fromCharCode(code.charCodeAt(0)+code.length);
    for(let i=1;i<code.length;i++)
    {
      c+=String.fromCharCode(code.charCodeAt(i)+code.charCodeAt(i-1));
    }
    return c;
  }
  static decrypt(code){
    let c=String.fromCharCode(code.charCodeAt(0)-code.length);
    for(let i=1;i<code.length;i++)
    {
      c+=String.fromCharCode(code.charCodeAt(i)-c.charCodeAt(i-1));
    }
    return c;
  }
}


