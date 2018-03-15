import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { IndicatorsService } from '../../common/indicators.service';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';
import { IMultiSelectOption, IMultiSelectSettings, IMultiSelectTexts } from 'angular-2-dropdown-multiselect';

@Component({
    selector: 'xdr-analysis',
    templateUrl: './analysis.component.html',
    styleUrls: ['./analysis.component.css'],
})

export class AnalysisComponent implements OnInit {

  public now = new Date(2016, 7 , 22);
  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  public _cellTypes: SelectItem[] = [
    { label: '全网', value: 'network' },
    { label: 'ECI', value: 'eci' },
    { label: 'IMSI', value: 'imsi' },
  ];

  public _interfaces: SelectItem[] = [
    { label: 'uu', value: 'uu' },
    { label: 'mr', value: 'mr' },
    { label: 'x2', value: 'x2' },
    { label: 'brd31', value: 'brd31' },
    { label: 'brd39', value: 'brd39' },
  ];

  // Settings configuration
  public mySettings: IMultiSelectSettings = {
    enableSearch: true,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn btn-default btn-block',
    dynamicTitleMaxItems: 0,
    displayAllSelectedText: false,
    showCheckAll: true,
    showUncheckAll: true,
  };

  // Text configuration
  public myTexts: IMultiSelectTexts = {
    checkAll: '全选',
    uncheckAll: '撤销',
    checked: '项已选择',
    checkedPlural: '项已选择',
    searchPlaceholder: '查找...',
    defaultTitle: '选择指标',
    allSelected: '全部选中',
  };

  @Output() private query: EventEmitter<SearchValue> = new EventEmitter();

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2016, month: 8, day: 22 } };

  private condition = new SearchValue(
        this.model,
        'network',
        '',
        'x2',
        [],
        []);

  private indicators: IMultiSelectOption[] = [];


  constructor(public _allIndicators: IndicatorsService) {
  }

  private get getIndicatorSelectItems(): IMultiSelectOption[] {
      return this._allIndicators.getIndicatorsSelects(this.condition.interfaceType);
  }

  public ngOnInit(): void {
    this.initIndicatorSelectItems();
    // console.log('ngOnInit-indicatorSelectItems:' + this.condition.indicatorSelectItems);
  }

  public onChangeInterfaceType() {
    this.initIndicatorSelectItems();
    // console.log('onChange-indicatorSelectItems:' + this.condition.indicatorSelectItems);
  }

  public searchClick() {
    // console.log(this.condition.indicatorSelectItems);
    this.condition.indicatorSelectItems = [];
    for (const i of this.condition.indicatorSelectItemIds) {
      // console.log('ts:' + i);
      for (const j of this.indicators) {
        // console.log('ts1:' + j.id);
        if (i === j.id) {
          // console.log('ts2:' + j.name);
          this.condition.indicatorSelectItems.push(j);
          break;
        }
      }
    }

    const emit = new SearchValue(this.condition.date1,
        this.condition.cellType,
        this.condition.cellInput,
        this.condition.interfaceType,
        this.condition.indicatorSelectItems,
        this.condition.indicatorSelectItemIds,
    );

    this.query.emit(emit);
  }

  private initIndicatorSelectItems() {
    const ids = this.getIndicatorSelectItems;
    this.condition.indicatorSelectItemIds = [];
    this.indicators = [];
    for (const i of ids) {
      this.condition.indicatorSelectItemIds.push(i.id);
      this.indicators.push(i);
    }
    // console.log('init-indicatorSelectItemIds:' + this.condition.indicatorSelectItemIds);
    return this.condition.indicatorSelectItemIds;
  }

}
