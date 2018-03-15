import { Injectable } from '@angular/core';

const allIndicator = {
  uu: {
    indicators: [
      { id: 'rrcConnectSuccessRate', name: 'RRC连接建立成功率', params: 'bar'},
      { id: 'rrcConnectRequest', name: 'RRC连接建立请求次数', params: 'line'},
      { id: 'rrcConnectSuccess', name: 'RRC连接建立成功次数', params: 'line'},
      { id: 'smActivateSuccessRate', name: '安全模式激活成功率', params: 'bar'},
      { id: 'smActivateRequest', name: '安全模式激活请求次数', params: 'line'},
      { id: 'smActivateSuccess', name: '安全模式激活成功次数', params: 'line'},
      { id: 'rrcReconfigSuccessRate', name: 'RRC连接重配成功率', params: 'bar'},
      { id: 'rrcReconfigRequest', name: 'RRC连接重配请求次数', params: 'line'},
      { id: 'rrcReconfigSuccess', name: 'RRC连接重配成功次数', params: 'line'},
      { id: 'rrcReconstructionSuccessRate', name: 'RRC连接重建成功率', params: 'bar'},
      { id: 'rrcReconstructionRequest', name: 'RRC连接重建请求次数', params: 'line'},
      { id: 'rrcReconstructionSuccess', name: 'RRC连接重建成功次数', params: 'line'},
      { id: 'rrcReleaseSuccessRate', name: 'RRC连接释放成功率', params: 'bar'},
      { id: 'rrcReleaseRequest', name: 'RRC连接释放请求次数', params: 'line'},
      { id: 'rrcReleaseSuccess', name: 'RRC连接释放成功次数', params: 'line'},
      { id: 'cellInterHandoverSuccessRate', name: '小区内部切换成功率', params: 'bar'},
      { id: 'cellInterHandoverRequest', name: '小区内部切换请求次数', params: 'line'},
      { id: 'cellInterHandoverSuccess', name: '小区内部切换成功次数', params: 'line'},
      { id: 'stationInterHandoverSuccessRate', name: '基站内切换成功率', params: 'bar'},
      { id: 'stationInterHandoverRequest', name: '基站内切换请求次数', params: 'line'},
      { id: 'stationInterHandoverSuccess', name: '基站内切换成功次数', params: 'line'},
      { id: 'stationIntraHandoverSuccessRate', name: '基站间切换成功率', params: 'bar'},
      { id: 'stationIntraHandoverRequest', name: '基站间切换请求次数', params: 'line'},
      { id: 'stationIntraHandoverSuccess', name: '基站间切换成功次数', params: 'line'},
      { id: 'ratInSuccessRate', name: '从其它RAT切入成功率', params: 'bar'},
      { id: 'ratInRequest', name: '从其它RAT切入请求次数', params: 'line'},
      { id: 'ratInSuccess', name: '从其它RAT切入成功次数', params: 'line'},
      { id: 'ratOutSuccessRate', name: '切出至其他RAT成功率', params: 'bar'},
      { id: 'ratOutRequest', name: '切出至其他RAT请求次数', params: 'line'},
      { id: 'ratOutSuccess', name: '切出至其他RAT成功次数', params: 'line'},
      { id: 'psPagingSuccessRate', name: 'PS寻呼成功率', params: 'bar'},
      { id: 'psPagingRequest', name: 'PS寻呼请求次数', params: 'line'},
      { id: 'psPagingSuccess', name: 'PS寻呼成功次数', params: 'line'},
      { id: 'csPagingSuccessRate', name: 'CS寻呼成功率', params: 'bar'},
      { id: 'csPagingRequest', name: 'CS寻呼请求次数', params: 'line'},
      { id: 'csPagingSuccess', name: 'CS寻呼成功次数', params: 'line'},
      { id: 'othereventSuccessRate', name: '其它事件成功率', params: 'bar'},
      { id: 'othereventRequest', name: '其它事件请求次数', params: 'line'},
      { id: 'othereventSuccess', name: '其它事件成功次数', params: 'line'},
    ],
  }
  ,
  mr: {
    indicators: [
      { id: 'rsrpAvg', name: '平均电平统计', params: 'line'},
      { id: 'rsrqAvg', name: '平均RSRQ统计', params: 'line'},
      { id: 'ulsinrAvg', name: '平均ULSINR统计', params: 'line'},
      { id: 'phrAvg', name: '平均PHR统计', params: 'line'},
      { id: 'erpAvg', name: '平均eNB Received Power统计', params: 'line'},
      { id: 'taAvg', name: '平均TA统计', params: 'line'},
      { id: 'overlapAvg', name: '重叠覆盖度', params: 'line'},
    ],
  }
  ,
  x2: {
    indicators: [
      { id: 'switchSuccessRate', name: 'X2切换成功率', params: 'bar'},
      { id: 'switchRequest', name: 'X2切换请求次数', params: 'line'},
      { id: 'switchSuccess', name: 'X2切换成功次数', params: 'line'},
    ],
  }
  ,
  brd31: {
    indicators: [
      { id: 'flowSum', name: '全业务访问总量', params: 'line'},
      { id: 'rateFlowRate', name: '速率要求类业务访问量占比', params: 'line'},
      { id: 'rateFlowSuccessRate', name: '速率要求类业务访问成功率', params: 'bar'},
      { id: 'rateFlowSuccessDegradationRate', name: '速率要求类业务访问成功率劣化比例', params: 'bar'},
      { id: 'rateFlow', name: '速率要求类业务访问量', params: 'line'},
      { id: 'rateFlowRequest', name: '速率要求类业务请求次数', params: 'line'},
      { id: 'rateFlowBpSpeed', name: '速率要求类业务大包下载速率（500KB以上文件）(kb/s)', params: 'line'},
      { id: 'rateFlowBpDegradationRate', name: '速率要求类业务大包下载速率劣化比例', params: 'bar'},
      { id: 'rateFlowSpDelay', name: '速率要求类业务小包时延（30KB以下文件）(ms)', params: 'line'},
      { id: 'rateFlowSpDelayDegradationRate', name: '速率要求类业务小包时延劣化比例', params: 'bar'},
      { id: 'delayFlowRate', name: '时延要求类业务访问量占比', params: 'bar'},
      { id: 'delayFlowSuccessRate', name: '时延要求类业务访问成功率', params: 'bar'},
      { id: 'delayFlowSuccessDegradationRate', name: '时延要求类业务访问成功率劣化比例', params: 'bar'},
      { id: 'delayFlow', name: '时延要求类业务访问量', params: 'line'},
      { id: 'delayFlowRequest', name: '时延要求类业务请求次数', params: 'line'},
      { id: 'delayFlowBpSpeed', name: '时延要求类业务大包下载速率（500KB以上文件）(kb/s)', params: 'line'},
      { id: 'delayFlowBpSpeedRated', name: '时延要求类业务大包下载速率劣化比例', params: 'bar'},
      { id: 'delayFlowSpDelay', name: '时延要求类业务小包时延（30KB以下文件）(ms)', params: 'line'},
      { id: 'delayFlowSpDelayRated', name: '时延要求类业务小包时延劣化比例', params: 'bar'},
      { id: 'refreshFlowRate', name: '普通刷新类业务访问量占比', params: 'bar'},
      { id: 'refreshFlowSuccessRate', name: '普通刷新类业务访问成功率', params: 'bar'},
      { id: 'refreshFlowSuccessRated', name: '普通刷新类业务访问成功率劣化比例', params: 'bar'},
      { id: 'refreshFlow', name: '普通刷新类业务访问量', params: 'line'},
      { id: 'refreshFlowRequest', name: '普通刷新类业务页面请求次数', params: 'line'},
      { id: 'refreshFlowBpSpeed', name: '普通刷新类业务大包下载速率（500KB以上文件）(kb/s)', params: 'line'},
      { id: 'refreshFlowBpSpeedRated', name: '普通刷新类业务大包下载速率劣化比例', params: 'bar'},
      { id: 'refreshFlowSpDelay', name: '普通刷新类业务小包时延（30KB以下文件）(ms)', params: 'line'},
      { id: 'refreshFlowSpDelayRated', name: '普通刷新类业务小包时延劣化比例', params: 'bar'},
      { id: 'instantFlow', name: '即时通信访问量占比', params: 'line'},
      { id: 'instantFlowSuccessRate', name: '即时通信访问成功率', params: 'bar'},
      { id: 'instantFlowSuccessRated', name: '即时通信访问成功率劣化比例', params: 'bar'},
      { id: 'instantFlow', name: '即时通信访问量', params: 'line'},
      { id: 'instantFlowRequest', name: '即时通信请求次数', params: 'line'},
      { id: 'instantFlowBpSpeed', name: '即时通信大包下载速率（500KB以上文件）(kb/s)', params: 'line'},
      { id: 'instantFlowBpSpeedRated', name: '即时通信大包下载速率劣化比例', params: 'bar'},
      { id: 'instantFlowSpDelay', name: '即时通信小包时延（30KB以下文件）(ms)', params: 'line'},
      { id: 'instantFlowSpDelayRated', name: '即时通信小包时延劣化比例', params: 'bar'},
    ],
  }
  ,
  brd39: {
    indicators: [
      { id: 'attachSuccessRate', name: 'Attach成功率', params: 'bar'},
      { id: 'attachRequest', name: 'Attach请求次数', params: 'line'},
      { id: 'attachSuccess', name: 'Attach成功次数', params: 'line'},
      { id: 'serviceSuccessRate', name: 'SERVICE成功率', params: 'bar'},
      { id: 'serviceRequest', name: 'SERVICE请求次数', params: 'line'},
      { id: 'serviceRequestSuccess', name: 'SERVICE请求成功次数', params: 'line'},
      { id: 'contextdefSetupSuccessRate ', name: '默认承载建立成功率', params: 'bar'},
      { id: 'contextdefActivateRequest', name: '默认承载激活请求次数', params: 'line'},
      { id: 'contextdefActivateSuccess', name: '默认承载激活成功次数', params: 'line'},
      { id: 'pdnRequestSuccessRate', name: 'UE请求PDN连接成功率', params: 'bar'},
      { id: 'pdnRequest', name: 'UE请求PDN连接请求次数', params: 'line'},
      { id: 'pdnRequestSuccess', name: 'UE请求PDN连接成功次数', params: 'line'},
      { id: 'tauSuccessRate', name: 'TAU成功率', params: 'bar'},
      { id: 'tauRequest', name: 'TAU请求次数', params: 'line'},
      { id: 'tauSuccess', name: 'TAU成功次数', params: 'line'},
      { id: 'xhoSuccessRate', name: 'X2接口切换成功率', params: 'bar'},
      { id: 'xhoRequest', name: 'X2接口切换尝试数', params: 'line'},
      { id: 'xhoSuccess', name: 'X2接口切换成功次数', params: 'line'},
      { id: 'shoSuccessRate', name: 'S1接口切换成功率', params: 'bar'},
      { id: 'shoRequest', name: 'S1接口切换请求次数', params: 'line'},
      { id: 'shoSuccess', name: 'S1接口切换成功次数', params: 'line'},
    ],
  },
  signaling: {
    indicators: [
      { id: 'pdate', name: '日期', params: 'bar' },
      { id: 'startTime', name: '开始时间', params: 'line' },
      { id: 'endTime', name: '结束时间', params: 'line' },
      { id: 'interfaceType', name: '接口类型', params: 'bar' },
      { id: 'cell', name: 'cell', params: 'line' },
      { id: 'imei', name: 'imei', params: 'line' },
      { id: 'imsi', name: 'imsi', params: 'bar' },
      { id: 'appType', name: 'appType', params: 'line' },
      { id: 'appStatus', name: 'appStatus', params: 'line' },
      { id: 'protocolType', name: '协议类型', params: 'bar' },
      { id: 'appSubType', name: '应用程序子类型', params: 'line' },
      { id: 'ulData', name: '上行数据流量', params: 'line' },
      { id: 'dlData', name: '下行数据流量', params: 'bar' },
      { id: 'lastHttpResponseDelay', name: 'Http响应延迟', params: 'line' },
      { id: 'procedureType', name: '程序类型', params: 'line' },
      { id: 'procedureStatus', name: '程序状态', params: 'bar' },
      { id: 'cause', name: '原因', params: 'line' },
      { id: 'keyword', name: '关键词', params: 'line' },
      { id: 'targetCellid', name: '目标小区标识', params: 'bar' },
      { id: 'csfbIndication', name: 'csfb指标', params: 'line' },
      { id: 'reqCauseType', name: '请求原因类型', params: 'line' },
      { id: 'reqCause', name: '请求原因', params: 'line' },
      { id: 'failureCauseType', name: '故障原因类型', params: 'line' },
      { id: 'failureCause', name: '失败原因', params: 'line' },
      { id: 'errorCauseType', name: '错误原因类型', params: 'line' },
      { id: 'errorCause', name: '错误原因', params: 'line' },
      { id: 'hoCancelCauseType', name: '切换取消原因类型', params: 'line' },
      { id: 'hoCancelCause', name: '切换取消原因', params: 'line' },
      { id: 'rowCount', name: '匹配MR行数', params: 'line' },
      { id: 'servingRsrp', name: '服务Rsrp', params: 'line' },
      { id: 'servingRsrpAvg', name: '服务平均Rsrp', params: 'line' },
      { id: 'servingRsrpStdDev', name: '服务Rsrp标准差', params: 'line' },
      { id: 'servingRsrq', name: '服务Rsrq', params: 'line' },
      { id: 'servingRsrqAvg', name: '服务平均Rsrq', params: 'line' },
      { id: 'servingRsrqStdDev', name: '服务Rsrq标准差', params: 'line' },
      { id: 'aoa', name: 'aoa', params: 'line' },
      { id: 'aoaAvg', name: '平均aoa', params: 'line' },
      { id: 'aoaStdDev', name: 'aoa标准差', params: 'line' },
      { id: 'ta', name: 'ta', params: 'line' },
      { id: 'taAvg', name: '平均ta', params: 'line' },
      { id: 'taStdDev', name: 'ta标准差', params: 'line' },
      { id: 'ulSinr', name: 'ulSinr', params: 'line' },
      { id: 'ulSinrAvg', name: '平均ulSinr', params: 'line' },
      { id: 'ulSinrStdDev', name: 'ulSinr标准差', params: 'line' },
      { id: 'enbReceivedPower', name: 'enbReceivedPower', params: 'line' },
      { id: 'enbReceivedPowerAvg', name: '平均enbReceivedPower', params: 'line' },
      { id: 'enbReceivedPowerStdDev', name: 'enbReceivedPower标准差', params: 'line' },
      { id: 'phr', name: 'phr', params: 'line' },
      { id: 'phrAvg', name: '平均phr', params: 'line' },
      { id: 'phrStdDev', name: 'phr标准差', params: 'line' },
    ],
  },
};

@Injectable()
export class IndicatorsService {

  constructor() {
  }

  getAllIndicators() {
    return allIndicator;
  }

  getIndicatorsSelects(inter: string) {
    return allIndicator[inter].indicators;
  }

  getIndicatorNamebyID(interfaces, id ) {
    let resultName = "";
    allIndicator[interfaces].indicators.forEach(item => {
      if(item.id == id){
        resultName = item.name;
      }
    })
    return resultName;
  }

  getIdByNameAndInter(inter: string, name: string){
    let indicatorId="";
    for(let indicator of allIndicator[inter].indicators){
      if(indicator.name == name){
        indicatorId= indicator.id;
      }
    }
    return indicatorId;
  }
}
