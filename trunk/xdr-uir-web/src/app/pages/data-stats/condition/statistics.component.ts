import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';

@Component({
  selector: 'xdr-statistics-condition',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css'],
})

export class ConditionComponent implements OnInit {

  @Output() public statisticssearch: EventEmitter<SearchValue> = new EventEmitter();
  @Output() public analysissearch: EventEmitter<SearchValue> = new EventEmitter();

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2016, month: 8, day: 22 } };

  private statisticecondition = new SearchValue(
    this.model,
    'network',
    'uu',
    'table',
    '',
    '');

  private _cellTypes: SelectItem[] = [
    { label: '广州', value: 'network' },
    { label: '佛山', value: 'eci' },
    { label: '珠海', value: 'imsi' },
  ];

  private _device: SelectItem[] = [
    { label: 'HUAWEI', value: 'uu' },
    { label: 'ZHONGXIN', value: 'mr' },
    { label: 'AILIXIN', value: 'x2' },
  ];

  ngOnInit(): void {
  }

  public statisticsClick(e: MouseEvent) {
    this.statisticecondition.selectValue = 'statistics';
    this.analysissearch.emit(this.statisticecondition);
  }

  public analysisClick(e: MouseEvent) {
    this.statisticecondition.showType = 'chart';
    this.statisticecondition.selectValue = 'analysis';
    this.statisticssearch.emit(this.statisticecondition);
  }

}
