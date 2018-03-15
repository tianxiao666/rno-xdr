import { Component, ViewChild, Input, Output, EventEmitter, ElementRef, OnInit } from '@angular/core';
import { SelectItem } from '../../common/select-item';
import { SearchValue } from './search-value';
import { IMyDpOptions } from 'mydatepicker';
import { Object } from '../../common/Object';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Principal } from '../../auth/principal.service';

export class Mes {
  area: string;
  type: string;
  author: string;
}

@Component({
  selector: 'xdr-import-condition',
  templateUrl: './condition.component.html',
  styleUrls: ['./condition.component.css'],
})

export class ConditionComponent implements OnInit {

  @Output() public search: EventEmitter<SearchValue> = new EventEmitter();
  @Output() public typeErr: EventEmitter<any> = new EventEmitter();
  @Output() public importMes: EventEmitter<SearchValue> = new EventEmitter();

  @Input() multiple: boolean = false;
  @ViewChild('fileInput') inputEl: ElementRef;

  private myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  private author: any;

  // Initialized to specific date (09.10.2018).
  private model: Object = { date: { year: 2017, month: 8, day: 22 } };

  private conditions = new SearchValue(
    this.model,
    this.model,
    '440100',
    '干扰数据');

  private _cellTypes: SelectItem[] = [
    { label: '广州', value: '440100' },
    { label: '佛山', value: '440600' },
    { label: '深圳', value: '440300' },
  ];

  private _interfaces: SelectItem[] = [
    { label: '干扰数据', value: '干扰数据' },
    { label: '干扰数据训练样本', value: '干扰数据训练样本' },
    { label: '干扰数据测试样本', value: '干扰数据测试样本' },
  ];

  private formData: any;

  private message: Mes = {
    area: this.conditions.area,
    type: this.conditions.interfereType,
    author: '',
  };

  constructor(private http: Http, private principal: Principal) {
    this.principal.identity(true).then((account) => {
      this.author = account.login;
      this.message.author = this.author;
    });
  }

  uploadSelect() {
    const inputEl: HTMLInputElement = this.inputEl.nativeElement;
    const fileCount: number = inputEl.files.length;
    this.formData = new FormData();
    let key = this.conditions.interfereType;
    if (fileCount > 0) {
      for (let i = 0; i < fileCount; i++) {
        if (inputEl.files.item(i).type === '.csv' || inputEl.files.item(i).type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
          || inputEl.files.item(i).type === 'application/vnd.ms-excel' || inputEl.files.item(i).type === 'text/plain') {
          key += i.toString();
          this.formData.append(key, inputEl.files.item(i));
        }else {
          this.typeErr.emit();
        }
      }
    }
  }

  import() {
    this.message.area = this.conditions.area;
    this.message.type = this.conditions.interfereType;
    this.http.post('http://localhost:8080/api/_import/data-imports-message', this.message)
      .map(res => '')
      .catch(error => Observable.throw(error))
      .subscribe(
        data => console.info('success'),
        error => console.info(error),
      );
      this.http.post('http://localhost:8080/api/_import/data-imports', this.formData)
        .map(res => this.showMess(res))
        .catch(error => Observable.throw(error))
        .subscribe(
          data => console.info('success'),
          error => console.info(error),
        );
  }

  public ngOnInit(): void {
    // console.log(this.selectedIndicator);
  }

  public searchDetailClick(e: MouseEvent) {
    this.search.emit(this.conditions);
  }

  public showMess(mess) {
    this.importMes.emit();
  }


}
