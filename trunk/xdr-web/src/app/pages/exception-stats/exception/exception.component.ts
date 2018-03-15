import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';
import { SELE, Sel } from './select-data';

@Component({
  selector: 'xdr-exception',
  templateUrl: 'exception.component.html',
  styleUrls: ['exception.component.css'],
})

export class ExceptionComponent implements OnInit {

  @Output() public search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() public export: EventEmitter<SearchValue> = new EventEmitter();

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2016, month: 8, day: 22 } };

  private countcondition = new SearchValue(
    this.model,
    'network',
    '',
    'and',
    'attach_fault_rate',
    '=',
    1,
    'and',
    'attach_request',
    '=',
    1,
    'and',
    'attach_fault',
    '=',
    1);

  private _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: '小区ECI', value: 'eci' },
  ];

  private _exceptionSelectItems: Sel[] = SELE;

  private _operators: SelectItem[] = [
    { label: '=', value: '=' },
    { label: '>', value: '>' },
    { label: '>=', value: '>=' },
    { label: '<', value: '<' },
    { label: '<=', value: '<=' },
  ];

  private _logicalOperation: SelectItem[] = [
    { label: 'and', value: 'and' },
  ];

  private _logicalOperations: SelectItem[] = [
    { label: 'and', value: 'and' },
    { label: 'or', value: 'or' },
  ];

  public ngOnInit(): void {
    // console.log(this.selectedIndicator);
  }

  public searchExceptionClick(e: MouseEvent) {
    // console.log(this.countcondition);
     this.search.emit(this.countcondition);
  }

  public exportExceptionClick(e: MouseEvent) {
    this.export.emit(this.countcondition);
  }

}
