import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import * as _ from 'lodash';
import { Parameter } from './get-parameter-value';
import { IndicatorsService } from '../../common/indicators.service';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';

@Component({
  selector: 'signalingshow',
  templateUrl: './table.component.html',
  styleUrls: ['./table.scss'],
  providers: [IndicatorsService],
})
export class TableComponent implements OnInit {

  public datalist: any[];
  public rowsOnPage = 10;
  public activePage = 1;
  public sortBy = "pdate";
  public sortOrder = "asc";
  public itemsTotal = 0;
  private interfaceType: any;
  private dataId: any;
  private dataName: any;

  @Output() paragram: EventEmitter<Parameter> = new EventEmitter();
  @Output() pageChange: EventEmitter<Parameter> = new EventEmitter();

  ngOnInit(): void {
    this.dataParameter();
  }

  constructor(public _allIndicators: IndicatorsService) {
  }

  get getIndicatorSelectItems(): IMultiSelectOption[] {
    return this._allIndicators.getIndicatorsSelects(this.interfaceType);
  }

  public loadData() {
    this.itemsTotal = (this._input)[1];
    this.activePage = (this._input)[2] + 1;
    this.datalist = _.orderBy((this._input)[0], this.sortBy, [this.sortOrder]);
    this.datalist = _.slice(this.datalist, 0, this.rowsOnPage);
  }

  public toInt(num: string) {
    return +num;
  }

  public onPageChange(event) {
    this.rowsOnPage = event.rowsOnPage;
    this.activePage = event.activePage;
    //console.log(this.activePage );
    this.dataParameter();
    this.pageChange.emit();
  }

  dataParameter() {
    const emit = new Parameter(
      this.rowsOnPage,
      this.activePage - 1,
    );
    this.paragram.emit(emit);
  }

  _input: any;

  @Input()
  public set input(v: any) {
    this._input = v;
    if (v) {
      this.interfaceType = v[3];
      const ids = this.getIndicatorSelectItems;
      this.dataId = [];
      this.dataName = [];

      for (const i of ids) {
        this.dataId.push(i['id']);
        this.dataName.push(i['name']);
      }
      /*console.log(this.dataId);
       console.log(this.dataName);*/
      this.loadData();
    }
  }

  public get input(): any {
    return this._input;
  }

}
