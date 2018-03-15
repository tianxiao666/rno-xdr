import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value.model';
import { INDICATOR_TYPES } from '../exception-cause.constants';

@Component({
  selector: 'xdr-cause',
  templateUrl: './cause.component.html',
  styleUrls: ['./cause.component.scss'],
})
export class CauseComponent implements OnInit {

  @Output() private query: EventEmitter<SearchValue> = new EventEmitter();

  private locale: string = 'zh-cn';

  private model: Object;

  private condition: SearchValue;

  private _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: 'ECI', value: 'eci' },
    { label: 'IMSI', value: 'imsi' },
  ];

  private _indicatorTypes: SelectItem[] = INDICATOR_TYPES;

  constructor() {
    // const now: Date = new Date();
    const now: Date = new Date('2016-08-22');
    this.model = {
      date: {
        year: now.getFullYear(),
        month: now.getMonth() + 1,
        day: now.getDate(),
      }};
    this.condition = new SearchValue(this.model, 'network', '', 'serviceFault');
  }

  public ngOnInit(): void {}

  private searchClick(e: MouseEvent) {
    this.query.emit(this.condition);
  }
}
