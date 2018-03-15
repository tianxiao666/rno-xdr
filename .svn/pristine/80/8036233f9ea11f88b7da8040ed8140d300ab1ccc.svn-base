import { Injectable } from '@angular/core';
import { URLSearchParams, BaseRequestOptions, Http, Response, ResponseContentType } from '@angular/http';
import { FinalSearchCond } from '../final-search-cond';
import { Observable } from 'rxjs/Observable';
import { ResponseWrapper } from '../../common/response-wrapper';
import { environment } from '../../../environments/environment';
import {FileTransfer, FileTransferObject} from "@ionic-native/file-transfer";
import {Platform, AlertController, LoadingController} from "ionic-angular";
import {File} from "@ionic-native/file";
import {Storage} from "@ionic/storage";

@Injectable()
export class ExceptionStatService {

  private env = environment;
  private resourceUrl;

  constructor(private http: Http,
  private file: File,
  private fileTransfer: FileTransfer,
  private platform: Platform,
              private loadingCtrl: LoadingController,
              private alertCtrl: AlertController,
              private storage: Storage) {
  }

  public getData(inputs: FinalSearchCond): Promise<any> {
    if (inputs.operateType === 'query') {
      this.resourceUrl  = '/api/exception-stats/findByCond';
      const res: Observable<ResponseWrapper> = this.query(inputs);
      return res.toPromise();
    }else if (inputs.operateType === 'download') {
      this.storage.get("id_token")
        .then( id_token => {
      let url="";
      const options: BaseRequestOptions = new BaseRequestOptions();
      if (inputs) {
        options.responseType = ResponseContentType.Blob;
        options.headers.append('Authorization','Bearer ' + id_token);

        const dateModel = inputs.date1;
        const date1: Date = new Date(dateModel.date.year, dateModel.date.month - 1, dateModel.date.day);
        const dateMilli: number = date1.setHours(8);
        this.resourceUrl  = 'api/exception-stats/mobile/downloadByCond?'
          +"date="+dateMilli+"&eci="+inputs.cellInput
          +"&expressionConnector1="+inputs.expressionConnector1+"&expressionCondition1="+inputs.expressionCondition1+"&expressionOperator1="+inputs.expressionOperator1;
        if(inputs.expressionValue1){
          this.resourceUrl+="&expressionValue1="+inputs.expressionValue1;
        }
        this.resourceUrl +="&expressionConnector2="+inputs.expressionConnector2+"&expressionCondition2="+inputs.expressionCondition2+"&expressionOperator2="+inputs.expressionOperator2;
        if(inputs.expressionValue2){
          this.resourceUrl+="&expressionValue2="+inputs.expressionValue2;
        }
        this.resourceUrl +="&expressionConnector3="+inputs.expressionConnector3+"&expressionCondition3="+inputs.expressionCondition3+"&expressionOperator3="+inputs.expressionOperator3;
        if(inputs.expressionValue3){
          this.resourceUrl+="&expressionValue3="+inputs.expressionValue3;
        }
        url = `${this.env.host}/${this.resourceUrl}`;
      }else{return;}

      let loading = this.loadingCtrl.create({
        content: '请稍候...',
        enableBackdropDismiss: true
      });
      loading.present();
      if(this.platform.is('mobileweb')){
        location.href=url;
        loading.dismiss();
      }
      else if(this.platform.is('android')){
        const transferObject : FileTransferObject = this.fileTransfer.create();
        transferObject.download(
          url,
          this.file.externalRootDirectory+'/小区指标异常统计.xlsx',
          true,options)
          .then((entry) => {
            loading.dismiss();
            let alert = this.alertCtrl.create({
              title: '提取成功，文件位置在SD卡根目录下',
              buttons: ['确定']
            });
            alert.present();
            console.log(entry);
          }, (error) => {
            loading.dismiss();
            let alert2 = this.alertCtrl.create({
              title: '提取失败！',
              buttons: ['确定']
            });
            alert2.present();
            console.log(error);
          });
      }
      else{
        loading.dismiss();
        location.href=url;
      }
    });
      //下载结束
    }

  }

  private query(req?: any): Observable<ResponseWrapper> {
    const url = `${this.env.host}/${this.resourceUrl}`;
    const options = this.createRequestOption(req);
    return this.http.get(url, options)
      .map((res: Response) => this.convertResponse(res));
  }

  private createRequestOption(req?: any): BaseRequestOptions {
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
      params.append('expressionConnector1', req.expressionConnector1);
      params.append('expressionCondition1', req.expressionCondition1);
      params.append('expressionOperator1', req.expressionOperator1);
      if (req.expressionValue1) {
        params.append('expressionValue1', req.expressionValue1);
      }
      params.append('expressionConnector2', req.expressionConnector2);
      params.append('expressionCondition2', req.expressionCondition2);
      params.append('expressionOperator2', req.expressionOperator2);
      if (req.expressionValue2) {
        params.append('expressionValue2', req.expressionValue2);
      }
      params.append('expressionConnector3', req.expressionConnector3);
      params.append('expressionCondition3', req.expressionCondition3);
      params.append('expressionOperator3', req.expressionOperator3);
      if (req.expressionValue3) {
        params.append('expressionValue3', req.expressionValue3);
      }
      if (req.rowsOnPage) {
        if (req.rowsOnPage !== -1) {
          params.append('size', req.rowsOnPage);
        }
      }
      if (req.activePage) {
        if (req.activePage !== -1) {
          params.append('page', req.activePage);
        }
      }
      options.params = params;
    }
    return options;
  }

  private convertResponse(res: Response): ResponseWrapper {
    return new ResponseWrapper(res.headers, res.json(), res.status);
  }
}
