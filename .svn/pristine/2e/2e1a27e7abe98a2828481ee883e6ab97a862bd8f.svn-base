import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import * as _ from 'lodash';
import { Parameter } from './get-parameter-value';
import { IndicatorsService } from '../../common/indicators.service';
import { HEADDATA, Head } from './head-data';

@Component({
  selector: 'xdr-exceptionshow',
  templateUrl: './table.component.html',
  styleUrls: ['./table.scss'],
  providers: [IndicatorsService],
})
export class TableComponent implements OnInit {

  public datalist: any[];
  public rowsOnPage = 10;
  public activePage = 1;
  public sortBy = 'pdate';
  public sortOrder = 'asc';
  public itemsTotal = 0;
  private dataId = [];
  private dataName = [];
  private _input: any;

  @Output() private paragrams: EventEmitter<Parameter> = new EventEmitter();
  @Output() private pageChanges: EventEmitter<Parameter> = new EventEmitter();

  private _exceptionHeadItems: Head[] = HEADDATA;

  public ngOnInit(): void {
    this.dataParameter();
    let num = 0;
    for (const i of this._exceptionHeadItems) {
      this.dataId.push(num);
      num++;
      this.dataName.push(i['header']);
    }
    /*console.log(this.dataId);
     console.log(this.dataName);*/
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
    // console.log(this.activePage );
    this.dataParameter();
    this.pageChanges.emit();
  }

  private dataParameter() {
    const emit = new Parameter(
      this.rowsOnPage,
      this.activePage - 1,
    );
    this.paragrams.emit(emit);
  }

  @Input()
  public set inputs(v: any) {
    this._input = v;
    if (v) {
      this.loadData();
    }
  }
  public get inputs(): any {
    return this._input;
  }

}
