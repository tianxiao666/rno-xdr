import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { TestSample } from './testSample';
import {environment} from "../../../../environments/environment";
import {Http} from "@angular/http";
@Component({
  selector: 'test-add',
  templateUrl: './test-add.component.html',
})

export class TestAddComponent implements OnInit {
  env = environment;
  sample = new TestSample('', '', '');
  @ViewChild('successAddTrain') public successAddTrain: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
  constructor(
    private activeModal: NgbActiveModal,
    private http: Http,
  ) {

  }
  ngOnInit(): void {
  }

  addTestSample() {
    const url = `${this.env.host}/api/addTestTask?sampleName=${this.sample.testName}`
      + `&sampleExplain=${this.sample.testExplain}&sampleResource=${this.sample.testResource}`;
    this.http.get(url).subscribe( data => {
      // this.activeModal.dismiss();
      setTimeout(() => {
        this.successAddTrain.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.successAddTrain.nativeElement.style.display = 'none';
      }, 3000);

    }, error => {
      // this.activeModal.dismiss();
      this.isShowLoading = false;
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'block';
      }, 0);
      setTimeout(() => {
        this.programError.nativeElement.style.display = 'none';
      }, 3000);

      return;
    });
  }
  closeModal() {
    this.activeModal.dismiss();
  }
}
