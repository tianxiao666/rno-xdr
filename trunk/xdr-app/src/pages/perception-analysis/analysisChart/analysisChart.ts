/**
 * Created by yangch on 2017/7/19.
 */

import {Component, ElementRef, ViewChild} from "@angular/core";
import {LoadingController, NavController, NavParams, Platform, ToastController} from "ionic-angular";
import {Http} from "@angular/http";
import {environment} from "../../../environments/environment";
import {IndicatorsService} from "../../common/indicatorService";
import {HomePage} from "../../home/home";
import {NetworkService} from "../../common/networkService";

declare var echarts;

@Component({
  selector: 'page-perception-analysis-chart',
  templateUrl: 'analysisChart.html'
})



export class PerceptionAnalysisChart{
    public env = environment;
    public data: any;

    @ViewChild('container') container: ElementRef;
    chart: any;
    isShown: boolean = true;
  constructor(public navParams: NavParams,
            public loadingCtrl: LoadingController,
            public toastCtrl: ToastController,
            public http: Http,
            public indicatorService: IndicatorsService,
            public platform: Platform,
            public navCtrl: NavController,
            public networkService: NetworkService){
       this.networkService.loadWithTokenByGET(navParams.data.url)
         .then(data => {
           if(data.toString() == ""){
             let toast = this.toastCtrl.create({
               message:'抱歉，无查询结果',
               position: 'middle',
               duration: 3000,
             });
             toast.present();
           }else{
            this.data= data;
             this.isShown = true;
             this.initChart(navParams.data.interfaceNames);
           }
         }).catch( error => {
         let toast = this.toastCtrl.create({
           message:'连接错误',
           position: 'middle',
           duration: 3000,
         });
         toast.present();
       })
  }

  initChart(interfaceNames) {
    const legend = [];
    const xAxis = [];
    let serieses=[];
    for(const i of interfaceNames){
      legend.push(i);
    }
    for(let j =0; j< 24;j++){
      xAxis.push(j);
    }
    let seriesData=[];
    for(let s =0; s<interfaceNames.length;s++){
      if(!seriesData[s] ){
        seriesData[s]=[];
      }
      for(let w = 0; w<24;w++){
        seriesData[s][w]=parseFloat("0");
      }
    }
    for(let t =0; t<interfaceNames.length;t++){
      let ids=this.indicatorService
        .getIdByNameAndInter(this.navParams.data.interfaceType,interfaceNames[t]);
      for(let k = 0; k<24;k++){
        for(let l of this.data){
          if(parseInt(l.phour) == k){
            let valu=l[ids];
            if(valu.toString().indexOf(".")>-1){
              seriesData[t][k]=(parseFloat(valu)*100).toFixed(2);
            }else{
              seriesData[t][k]=parseInt(valu);
            }
          }
        }
      }
      for(let m =0;m< this.data.length;m++){
        if(m==0){
          if(this.data[m][ids].toString().indexOf(".")>-1){
            serieses.push({
              name: interfaceNames[t],
              type: 'line',
              data: seriesData[t],
              yAxisIndex:1
            });
          }else{
            serieses.push({
              name: interfaceNames[t],
              type: 'line',
              data: seriesData[t],
              yAxisIndex:0
            });
          }
        }
      }
    }

    let ctx = this.container.nativeElement;
    this.chart = echarts.init(ctx);
    this.chart.setOption({
      title: {
        text: '',
      },
      tooltip: {
        trigger: 'axis',
        formatter: (a)=>{
          let tooltipText = a[0].name;
          a.forEach(eachline =>{
            if((eachline.value+"").indexOf(".")>-1){
              eachline.value = eachline.value +"%";
              tooltipText += `<br/>${eachline.marker}${eachline.seriesName}&nbsp;:&nbsp;${eachline.value}`;
            }else {
              tooltipText += `<br/>${eachline.marker}${eachline.seriesName}&nbsp;:&nbsp;${eachline.value}`;
            }
            //console.log(eachline.value);
          })
          return tooltipText;
        }
      },
      legend: {
        data: legend,
        top:'0px'
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        y: 150,
        containLabel: true,
      },
      xAxis: [
        {
          type: 'category',
          boundaryGap: false,
          data: xAxis,
          splitLine: {
            show: false,
          },
        },
      ],
      yAxis: [
        {
          type: 'value',
          name: '数量',
          splitLine: {
            show: false
          }
        },{
          type: 'value',
          max: 100,
          min: 0,
          name: '比率(%)',
          splitLine: {
            show: false
          }
        },
      ],
      series: serieses
    });
    window.onresize = this.chart.resize;
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }
}
