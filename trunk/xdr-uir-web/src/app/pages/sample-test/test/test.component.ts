import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { IMyDpOptions } from 'mydatepicker';
import { SearchValue } from './search-value';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { TestAddComponent } from '../test-add/test-add.component';
import { Object } from '../../common/Object';
@Component({
  selector: 'uir-test',
  templateUrl: './test.component.html',
})

export class TestComponent implements OnInit {

  @Output() public search: EventEmitter<SearchValue> = new EventEmitter();

  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };
  public condition3: Object = {
    date: { year: 2016, month: 8, day: 22 }};
  public condition4: Object = {
    date: { year: 2017, month: 8, day: 22 }};
  test = new SearchValue( '广州', '' , '进行中', this.condition3, this.condition4);
  private isOpen = false;
  constructor(
    private modalService: NgbModal,
  ) {}

  add(): NgbModalRef {
    if (this.isOpen) {
      return;
    }
    this.isOpen = true;
    const modalRef = this.modalService.open(TestAddComponent);
    modalRef.result.then((result) => {
      this.isOpen = false;
    }, (reason) => {
      this.isOpen = false;
    });
  }
  ngOnInit(): void {
  }

  searchTrainClick(e: MouseEvent) {
    const emit = new SearchValue (
      this.test.city,
      this.test.testName,
      this.test.testStatus,
      this.test.dateFrom,
      this.test.dateTo,
    );
    this.search.emit(emit);
  }

}
