import {Component, ElementRef, ViewChild} from '@angular/core';
import {App, Events, NavController, NavParams} from 'ionic-angular';
import {environment} from "../../../environments/environment"
import {IndicatorsService} from "../../common/indicatorService";
import {HomePage} from "../../home/home";
import {Storage} from "@ionic/storage";
import {NetworkService} from "../../common/networkService";
import {INDICATOR_TYPES} from "../exception-cause.constants";
import {SelectItem} from "../../common/select-item";
import {Http} from "@angular/http";


declare var echarts;

@Component({
  selector: 'page-cause-result',
  templateUrl: 'causeResult.html',
  providers: [IndicatorsService]
})
export class CauseResultPage {

  public env = environment;
  private resourceUrl = 'api/exception-causes/findByTimeAndImsiAndIndicatorType';
  private causePath = '/assets/json/exception-cause/cause-number.json';
  private indicatorTypes: SelectItem[] = INDICATOR_TYPES;
  public data: any;
  @ViewChild('container') container: ElementRef;
  chart: any;
  public causeNumber: any;
  public title: any ="";
  public searchValue: any;

  private causeMap = {
    attachFault: 'EMM',
    serviceFault: 'EMM',
    csfbFault: 'EMM',
    tauFault: 'EMM',
    contextActivateFault: 'ESM',
    pdnRequestFault: 'ESM',
    xhoFault: 'S1AP',
    shoFault: 'S1AP',
  };

  constructor(public navCtrl: NavController
  , public _allIndicators: IndicatorsService
  , public navParams: NavParams, public storage: Storage
  , public networkService: NetworkService, public app: App
  , public http: Http,public events: Events) {
    this.http.get(this.causePath).subscribe(
      (data) => {
        this.causeNumber = data.json();
        this.searchValue = this.navParams.get("searchValue");
        let url = `${this.env.host}/${this.resourceUrl}`;
        this.networkService.loadWithTokenByGETGivenHeader(url,this.searchValue)
          .then(data => {
            this.data=data;
            let chartData = this.buildChartData(this.causeNumber[this.causeMap[this.searchValue.indicatorType]], data);
            // console.log(chartData);
            this.createEchartsOption(this.searchValue,chartData);
          })
          .catch( error => {})
      },
      (error: any) => console.error('An error occurred', error)
      );
  }

  private createEchartsOption(searchValue, chartData: any[]) {

    const legend = [];
    for (const d of chartData) {
      legend.push(d.name);
    }
    this.title = `${this.getTitle(searchValue.indicatorType)}异常原因`;

    let ctx = this.container.nativeElement;
    this.chart = echarts.init(ctx);
    window.onresize = this.chart.resize;

    this.chart.setOption(this.getOptions(legend,chartData));

    var lastHeight = window.outerHeight;
    setInterval(()=>{
      let newHeight = window.outerHeight;
      if(lastHeight != newHeight){
        lastHeight = newHeight;
        if(window.outerWidth > window.outerHeight){
          this.chart.setOption(this.getOptions(legend,chartData));
        }else {
          this.chart.setOption(this.getOptions(legend,chartData));
        }
      }


    },100);
  }

  private getOptions(legend,chartData){
    let chartOptions = {
      tooltip : {
        trigger: 'item',
        confine: true,
        formatter: '{b} <br/> {c} ({d}%)',
      },
      toolbox: {
        feature: {
          saveAsImage: {},
          restore: {},
        },
      },
      legend: {
        orient: 'vertical',
        left: 'left',
        data: legend,
      },
      series : [
        {
          name: this.title,
          type: 'pie',
          radius : '40%',
          center: [this.marginLeft(), this.marginTop(chartData)],
          data: chartData,
          itemStyle: {
            normal: {
              label:{
                show: true,
                confine: true,
//	                            position:'inside',
                formatter: ' {c} ({d}%)'
              }
            },
            emphasis: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)',
            },
          },
        },
      ],
    };
    return chartOptions;
  }

  private getTitle(indicatorType: string) {
    let indicatorTypeName = '';
    for (const i of this.indicatorTypes) {
      if (i.value === indicatorType) {
        indicatorTypeName = i.label;
      }
    }
    return indicatorTypeName;
  }

  private marginTop(chartData): string{
    let length = chartData.length;
    if(length>5){
      let num = 50+(length-5)*5;
      if(num>80){
        num=80;
      }
      return num+"%";
    }else{
      return "50%";
    }
  }

  private marginLeft(): string{
    if(window.outerWidth > window.outerHeight){
      return "70%";
    }else {
      return "50%";
    }

    // if(length>5){
    //   return (50+(length-5)*5)+"%";
    // }else{
    //   return "50%";
    // }
  }

  private buildChartData(causeNumber: any[], res): any[] {

    const result: { value: string, name: any }[] = [];
    for (const d of res) {
      result.push({
        name: `(${d.cause})${causeNumber[d.cause.toString()]}`,
        value: d.causeCount,
      });
    }
    return result;
  }

  toIndex(){
    this.navCtrl.popToRoot(HomePage);
  }
}

