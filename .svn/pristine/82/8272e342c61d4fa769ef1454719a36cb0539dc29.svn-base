import { Component, Output, EventEmitter, OnInit } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';

@Component({
  selector: 'xdr-search-condition',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})

export class ConditionComponent implements OnInit {

  @Output() public search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() public export: EventEmitter<SearchValue> = new EventEmitter();

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2016, month: 8, day: 22 } };

  private searchcondition = new SearchValue(
    this.model,
    'network',
    'uu',
    'aa',
    '',
    '',
    '');

  private _cellTypes: SelectItem[] = [
    { label: '广州', value: 'network' },
    { label: '佛山', value: 'eci' },
    { label: '珠海', value: 'imsi' },
  ];

  private _devices: SelectItem[] = [
    { label: 'HUAWEI', value: 'uu' },
    { label: 'ZHONGXIN', value: 'mr' },
    { label: 'AILIXIN', value: 'x2' },
  ];

  private _assortment: SelectItem[] = [
    { label: '超强干扰', value: 'aa' },
    { label: '强干扰', value: 'bb' },
    { label: '一般干扰', value: 'cc' },
    { label: '弱干扰', value: 'dd' },
    { label: '无干扰', value: 'ee' },
  ];

  ngOnInit(): void {
  }

  public setSelected() {
    if (this.searchcondition.showPRB) {
      this.searchcondition.showPRB = '';
    }else {
      this.searchcondition.showPRB = 'checked';
    }
  }

  public searchClick(e: MouseEvent) {
    this.search.emit(this.searchcondition);
  }

  public exportClick(e: MouseEvent) {
    this.export.emit(this.searchcondition);
  }

}
