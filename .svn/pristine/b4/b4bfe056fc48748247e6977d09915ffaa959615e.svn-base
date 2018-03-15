import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';

@Component({
  selector: 'xdr-detail',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})

export class DetailsComponent implements OnInit {

  @Output() public search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() public export: EventEmitter<SearchValue> = new EventEmitter();

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2016, month: 8, day: 22 } };

  private condition = new SearchValue(
    this.model,
    'network',
    '',
    'uu');

  private _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: 'ECI', value: 'eci' },
    { label: 'IMSI', value: 'imsi' },
  ];

  private _interfaces: SelectItem[] = [
    { label: 'uu', value: 'uu' },
    { label: 'mr', value: 'mr' },
    { label: 'x2', value: 'x2' },
    { label: 'brd31', value: 'brd31' },
    { label: 'brd39', value: 'brd39' },
  ];

  public ngOnInit(): void {
    // console.log(this.selectedIndicator);
  }

  public searchDetailClick(e: MouseEvent) {
    const emit = new SearchValue(this.condition.date1,
      this.condition.cellType,
      this.condition.cellInput,
      this.condition.interfaceType,
    );
    // console.log('条件'+this.condition.date1);
    this.search.emit(emit);
  }

  public exportClick(e: MouseEvent) {
    const emit = new SearchValue(this.condition.date1,
      this.condition.cellType,
      this.condition.cellInput,
      this.condition.interfaceType,
    );
    this.export.emit(this.condition);
  }

}
