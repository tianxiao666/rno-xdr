import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

import {  SelectItem  } from './select-item';
import { SearchValue } from './search-value';
import { Inputs } from './inputs';
import { Object } from   '../../common/Object';
import { IMyDpOptions } from 'mydatepicker';
@Component({
  selector: 'signaling',
  templateUrl: './signaling.component.html',
  styleUrls: ['./signaling.component.css'],
})
export class SignalingComponent implements OnInit {

  @Output() search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() export: EventEmitter<SearchValue> = new EventEmitter();

  hourOptions: SelectItem[] = [];

  inputs: Inputs = {
    date: new Date(1453305600000),
    beginTime: 0,
    endTime: 23,
    imsi: 460000340879716,
  };
  now = new Date();
 /* today: NgbDateStruct = { year: this.now.getFullYear(), month: this.now.getMonth() + 1,
    day: this.now.getDate() };*/
  myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };
  today: Object = { date: { year: this.now.getFullYear(), month: this.now.getMonth() + 1, day: this.now.getDate() } };
  condition = new SearchValue(
    this.today,
    '0',
    '23',
    '460000340879716',
    '',
    [],
    []);

  getInterfaceType() {
    return this.condition.interfaceType;
  }
  setInterfaceType(value) {
    // console.log("interfaceType", value)
    this.condition.interfaceType = value;
  }

  ngOnInit(): void {
    this.initIndicatorSelectItems();
    // console.log(this.selectedIndicator);
    for (let i = 0; i < 24; i++) {
      this.hourOptions.push({ value: i, label: i + '' });
    }
  }

  onChangeType() {
    this.initIndicatorSelectItems();
  }

  searchClick(e: MouseEvent) {
    this.initIndicatorSelectItems();
    const emit = new SearchValue(this.condition.date1,
      this.condition.startTime,
      this.condition.endTime,
      this.condition.imsi,
      this.getInterfaceType(),
      this.condition.indicatorSelectItems,
      this.condition.indicatorSelectItemIds,
    );
    this.search.emit(emit);
  }

  outputClick(e: MouseEvent) {
    this.initIndicatorSelectItems();
    // console.log(this._searchData);
    this.export.emit(this.condition);
  }

  private initIndicatorSelectItems() {
    this.condition.indicatorSelectItemIds = [];
    this.condition.indicatorSelectItems = [];
    // console.log(this.condition.indicatorSelectItems);
    return this.condition.indicatorSelectItemIds;
  }

  exportClick(e: MouseEvent) {
    const emit = new SearchValue(this.condition.date1,
      this.condition.startTime,
      this.condition.endTime,
      this.condition.imsi,
      this.getInterfaceType(),
      this.condition.indicatorSelectItems,
      this.condition.indicatorSelectItemIds,
    );
    this.export.emit(this.condition);
  }

}
