import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import * as _ from 'lodash';
import { Parameter } from './get-parameter-value';

@Component({
  selector: 'xdr-import-tableshow',
  templateUrl: './table.component.html',
  styleUrls: ['./table.scss'],
})
export class TableComponent implements OnInit {

  public datalist: any[];
  public rowsOnPage = 10;
  public activePage = 1;
  public sortBy = 'date';
  public sortOrder = 'asc';
  public itemsTotal = 0;
  private dataId = ['0', '1', '2', '3', '4', '5', '6'];
  private dataName = ['导入时间', '地市', '用户', '文本标题', '文本类型', '文本大小', '是否上传成功'];
  private _input: any;

  @Output() private paragram: EventEmitter<Parameter> = new EventEmitter();
  @Output() private pageChange: EventEmitter<Parameter> = new EventEmitter();

  public ngOnInit(): void {
    this.dataParameter();
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
      this.loadData();
    }
  }

  public get input(): any {
    return this._input;
  }

}
