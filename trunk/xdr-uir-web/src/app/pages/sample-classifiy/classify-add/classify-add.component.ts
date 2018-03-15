import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Classify } from './classify';
import { FormControl, FormGroup } from '@angular/forms';
import {environment} from "../../../../environments/environment";
import {Http} from "@angular/http";
@Component({
  selector: 'classify-add',
  templateUrl: './classify-add.component.html',
})

export class ClassifyAddComponent implements OnInit {
  env = environment;
  classify = new Classify('', '', '');
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

  addClassifySample() {
    const url = `${this.env.host}/api/addClassifyTask?sampleName=${this.classify.classifyName}`
      + `&sampleExplain=${this.classify.classifyExplain}&sampleResource=${this.classify.classifyResource}`;
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

