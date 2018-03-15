import {Component, ElementRef, ViewChild} from '@angular/core';
import { App, NavController, NavParams} from 'ionic-angular';
import {environment} from "../../../environments/environment"
import 'rxjs/add/operator/map';
import {IndicatorsService} from "../../common/indicatorService";
import {HomePage} from "../../home/home";
import {Storage} from "@ionic/storage";
import {NetworkService} from "../../common/networkService";


declare var echarts;

@Component({
  selector: 'page-trend-result',
  templateUrl: 'trendResult.html',
  providers: [IndicatorsService]
})
export class TrendResultPage {

  public env = environment;
  public data: any;
  @ViewChild('container') container: ElementRef;
  chart: any;
  public beginTime: any;
  public endTime: any;
  public condition: any;
  public interfaces: any;
  public xAxis = [];
  public legend = [];
  public networkResultInLines: any;

  constructor(public navCtrl: NavController
  , public _allIndicators: IndicatorsService
  , public navParams: NavParams, public storage: Storage
  , public networkService: NetworkService, public app: App) {


    this.interfaces = navParams.data.interfaces;
    this.condition = this.navParams.data.condition;

    this.beginTime = this.navParams.data.beginTime;
    this.endTime = this.navParams.data.endTime;

    let bt = new Date(this.beginTime);
    let et = new Date(this.endTime);
    bt = new Date(bt.setDate(bt.getDate()-1));
    while(bt.toISOString()!=et.toISOString()){
      bt = new Date(bt.setDate(bt.getDate()+1));
      let yearMonthDayString = bt.toISOString().substr(0,10);
      this.xAxis.push(yearMonthDayString);
    }
    console.log(navParams.data.url);
    this.networkService.loadWithTokenByGET(navParams.data.url)
      .then(data => {
        this.data=data;
        this.networkResultInLines = this.networkResultsToLines();
        this.initChart();
      })
      .catch( error => {})
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }

  networkResultsToLines(){
    let collector = [];
    this.condition.forEach(data => {
      let name = this._allIndicators.getIndicatorNamebyID(this.interfaces,data);
      let row=[];
      this.data.forEach(eachDayData => {
        let val;
        if(eachDayData[data].toString().indexOf(".") > -1){
          val=eachDayData[data]*100;
        }else {
          val = eachDayData[data];
        }
        let content = {"id": data,"name": name,"value": val, "date": eachDayData.pdate};
        row.push(content);
      })
      collector.push(row);
    })
    return collector;
  }

  initSeries(networkResultInLines){
    let Series = [];
    networkResultInLines.forEach(eachLine => {
      let data = [];
      let val="";
      for(let i=0;i<this.xAxis.length;i++){
        eachLine.forEach(eachColumn => {
          if(this.xAxis[i]==eachColumn.date){
            val = eachColumn.value;
          }
        })
        if(val!=""){
          data.push(val);
          val="";
        }else {
          data.push(0);
        }
      }
      this.legend.push(eachLine[0].name);
      let serie;
      if(eachLine[0].value.toString().indexOf(".")>-1){
        serie = {
          name: eachLine[0].name,
          type:'line',
          smooth: true,
          yAxisIndex: 1,
          data: data,
        };
      }else {
        serie = {
          name: eachLine[0].name,
          type:'line',
          smooth: true,
          yAxisIndex: 0,
          data: data,
        };
      }
      Series.push(serie);
    })
    return Series;
  }

  initChart() {
    let Series = this.initSeries(this.networkResultInLines);
    let ctx = this.container.nativeElement;
    this.chart = echarts.init(ctx);
    this.chart.setOption({
      tooltip : {
        trigger: 'axis',
        formatter: (a)=>{
          let tooltipText = a[0].name;
          a.forEach(eachline =>{
            if(((eachline.value/100)+"").startsWith("0.")){
              eachline.data = (eachline.data).toFixed(2)+"%";
              tooltipText += `<br/>${eachline.marker}${eachline.seriesName}&nbsp;:&nbsp;${eachline.data}`;
            }else {
              tooltipText += `<br/>${eachline.marker}${eachline.seriesName}&nbsp;:&nbsp;${eachline.value}`;
            }
          })
          return tooltipText;
        },
        confine: true,
        axisPointer : {
          type : 'line',
        }
      },
      legend: {
        x: 'center',
        y: 'top',
        data: this.legend,
      },
      // toolbox: {
      //   y: 'bottom',
      //   feature: {
      //     saveAsImage: {},
      //   },
      // },
      grid: {
        left: '3%',
        right: '3%',
        top: '12%',
        width: '94%',
        height: '85%',
        containLabel: true
      },
      xAxis : [
        {
          type : 'category',
          data : this.xAxis,
          axisTick: {
            alignWithLabel: true
          }
        }
      ],
      yAxis : [
        {
          type: 'value',
          name: '数量',
          splitLine: {
            show: false,
          },
        },
        {
          type: 'value',
          // max: 100,
          // min: 0,
          name: '比率(%)',
          splitLine: {
            show: false,
          },
        },
      ],
      series : Series,
    });
    window.onresize = this.chart.resize;
  }
}

