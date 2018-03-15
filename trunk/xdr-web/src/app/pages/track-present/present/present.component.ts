import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { IMyDpOptions } from 'mydatepicker';
import { SelectItem } from '../../common/select-item';
import { Object } from '../../common/Object';
import { Condition } from '../track-present';

@Component({
  selector: 'xdr-present',
  templateUrl: './present.component.html',
  styleUrls: ['./present.component.scss'],
})
export class PresentComponent implements OnInit {

  public indicatorOptions: SelectItem[] = [
    { value: '1', label: 'RRC连接建立' },
    { value: '3', label: 'RRC连接重配' },
    { value: '4', label: 'RRC连接重建' },
    { value: '6', label: '小区内部切换' },
    { value: '7', label: '基站内切换' },
    { value: '8', label: '基站间切换' },
    { value: '10', label: '切出至其他RAT' },
  ];
  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };
  public localeOption: 'zh-cn';
  private timeOptions = [];

  @Output() private track: EventEmitter<Condition> = new EventEmitter();

  private now = new Date(2017, 6, 18);
  private today: Object = { date: { year: this.now.getFullYear(), month: this.now.getMonth() + 1,
    day: this.now.getDate() }};

  private cond = new Condition (
    this.today,
    0,
    23,
    460000891444152,
    '1',
    '',
  );

  constructor() {
  }

  public ngOnInit() {
    for (let i = 0; i < 24; i++) {
      this.timeOptions.push({ value: i.toString(), label: `${i} ` });
    }
  }

  public searchClick() {
    const emit = new Condition(this.cond.date,
      this.cond.beginTime,
      this.cond.endTime,
      this.cond.imsi,
      this.cond.indicatorId,
      this.cond.indicatorName,
    );
    this.track.emit(emit);
  }

}
