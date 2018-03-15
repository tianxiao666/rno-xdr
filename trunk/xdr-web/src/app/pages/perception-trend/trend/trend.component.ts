import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { IndicatorsService } from '../../common/indicators.service';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { IMultiSelectOption, IMultiSelectSettings, IMultiSelectTexts } from 'angular-2-dropdown-multiselect';
import {IMyDpOptions} from "mydatepicker";
import { Object } from  '../../common/Object';
@Component({
  selector: 'trend',
  templateUrl: './trend.component.html',
  styleUrls: ['./trend.component.css'],
})

export class TrendComponent implements OnInit {

  @Output() search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() output: EventEmitter<SearchValue> = new EventEmitter();

  now = new Date();
  mid = new Date().getTime() + ( 1000 * 3600 * 24 * 5);
  addnow = new Date(this.mid);
  myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };
  today: Object = { date: { year: this.now.getFullYear(), month: this.now.getMonth() + 1, day: this.now.getDate() } };
  oneday: Object = { date: { year: this.addnow.getFullYear(), month: this.addnow.getMonth() + 1, day: this.addnow.getDate() } };
  condition = new SearchValue(
    this.today,
    this.oneday,
    'network',
    '',
    '',
    'uu',
    [],
    [],
    []);
  indicators: IMultiSelectOption[] = [];

  _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: 'ECI', value: 'eci' },
    { label: 'IMSI', value: 'imsi' },
  ];

  _interfaces: SelectItem[] = [
    { label: 'uu', value: 'uu' },
    { label: 'mr', value: 'mr' },
    { label: 'x2', value: 'x2' },
    { label: 'brd31', value: 'brd31' },
    { label: 'brd39', value: 'brd39' },
  ];

  // Settings configuration
  mySettings: IMultiSelectSettings = {
    enableSearch: true,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn btn-default btn-block',
    dynamicTitleMaxItems: 0,
    displayAllSelectedText: false,
    showCheckAll: true,
    showUncheckAll: true,
  };

  // Text configuration
  myTexts: IMultiSelectTexts = {
    checkAll: '全选',
    uncheckAll: '撤销',
    checked: '项已选择',
    checkedPlural: '项已选择',
    searchPlaceholder: '查找...',
    defaultTitle: '选择指标',
    allSelected: '全部选中',
  };

  constructor(public _allIndicators: IndicatorsService) {
  }

  getInterfaceType() {
    return this.condition.interfaceType;
  }

  setInterfaceType(value) {
    this.condition.interfaceType = value;
  }
  get getIndicatorSelectItems(): IMultiSelectOption[] {
    return this._allIndicators.getIndicatorsSelects(this.condition.interfaceType);
  }

  ngOnInit(): void {
    this.initIndicatorSelectItems();
  }

  onChangeInterfaceType() {
    this.initIndicatorSelectItems();
  }

  onChange() {
    // console.log(this.condition.indicatorSelectItems);
  }

  searchClick(e: MouseEvent) {
    this.condition.indicatorSelectItems = [];
    for (const i of this.condition.indicatorSelectItemIds) {
      for (const j of this.indicators) {
        if (i === j.id) {
          this.condition.indicatorSelectItems.push(j);
          break;
        }
      }
    }

    const emit = new SearchValue(this.condition.startTime,
      this.condition.endTime,
      this.condition.cellType,
      this.condition.cellInput,
      this.condition.dataType,
      this.condition.interfaceType,
      this.condition.indicators,
      this.condition.indicatorSelectItems,
      this.condition.indicatorSelectItemIds,
    );

    this.search.emit(emit);
  }

  outputClick(e: MouseEvent) {
    this.initIndicatorSelectItems();
    this.output.emit(this.condition);
  }

  private initIndicatorSelectItems() {
    const ids = this.getIndicatorSelectItems;
    this.condition.indicatorSelectItemIds = [];
    for (const i of ids) {
      this.condition.indicatorSelectItemIds.push(i.id);
      this.indicators.push(i);
    }
    return this.condition.indicatorSelectItemIds;
  }

}
