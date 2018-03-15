import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import * as _ from 'lodash';
import { Parameter } from './get-parameter-value';

@Component({
  selector: 'xdr-classifyshow',
  templateUrl: './table.component.html',
  styleUrls: ['./table.scss'],
})
export class TableComponent implements OnInit {

  public datalist: any[];
  public rowsOnPage = 10;
  public activePage = 1;
  public sortBy = '训练名称';
  public sortOrder = 'asc';
  public itemsTotal = 0;
  dataName = new Array();
  dataId = new Array();
  private _input: any;

  @Output() private paragram: EventEmitter<Parameter> = new EventEmitter();
  @Output() private pageChange: EventEmitter<Parameter> = new EventEmitter();

  constructor() {
  }

  public ngOnInit(): void {
    this.dataParameter();
  }


  public loadData() {
    this.itemsTotal = (this._input)[1];
    this.activePage = (this._input)[2] + 1;
    this.datalist = _.orderBy((this._input)[0], this.sortBy, [this.sortOrder]);
    this.datalist = _.slice(this.datalist, 0, this.rowsOnPage);
  }

  public onPageChange(event) {
    this.rowsOnPage = event.rowsOnPage;
    this.activePage = event.activePage;
    // console.log(this.activePage );
    this.dataParameter();
    this.pageChange.emit();
  }

  private dataParameter() {
    const emit = new Parameter(
      this.rowsOnPage,
      this.activePage - 1,
    );
    this.paragram.emit(emit);
  }

  @Input()
  public set input(v: any) {
    this._input = v;
    if (v) {
      this.dataId = ['name', 'status', 'description', 'fileId', 'startTime', 'endTime'];
      this.dataName = ['分类任务名称', '分类任务状态', '分析描述', '分类文件', '任务提交时间', '任务完成时间'];
      this.loadData();
    }
  }

  public get input(): any {
    return this._input;
  }

}
