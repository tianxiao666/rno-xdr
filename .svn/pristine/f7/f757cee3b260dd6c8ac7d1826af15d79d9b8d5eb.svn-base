import {Component, ViewChild} from '@angular/core';
import {Events, Nav, Platform} from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import {LoginPage} from "../pages/login/login";
import {Storage} from "@ionic/storage";
import {HomePage} from "../pages/home/home";

@Component({
  templateUrl: 'app.html'
})
export class MyApp {

  @ViewChild(Nav) nav: Nav;
  rootPage:any ;  //测试时使用页面

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen
              ,public events: Events,public storage: Storage) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
    this.events.subscribe("popToLastPage",()=> {
      this.nav.pop();
    });
    this.events.subscribe("goto.login",()=> {
      this.nav.setRoot(LoginPage);
    });
    // 完成时取消注释
    this.storage.get("id_token")
      .then(result => {
        if(result.length>0){
          this.rootPage = HomePage;
        }else {
          this.rootPage = LoginPage;
        }
      })
      .catch(error => {
        this.rootPage = LoginPage;
      })
  }
}

