import { AfterViewInit, Component, ElementRef, EventEmitter, OnInit, Output, Renderer, ViewChild} from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Sample } from './sample';
import { Http, RequestOptions, Headers } from '@angular/http';
import { environment } from '../../../../environments/environment';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
    selector: 'train-add',
    templateUrl: './train-add.component.html',
})

export class TrainAddComponent implements OnInit {

  @Output() public query: EventEmitter<Sample> = new EventEmitter();
  @ViewChild('successAddTrain') public successAddTrain: ElementRef;
  @ViewChild('programError') public programError: ElementRef;
  public isShowLoading: boolean = false;
   env= environment;
   sample = new Sample('', '', '');
   sampleName: string;
   sampleExplain: string;
   sampleResource: string;
   sampleList = new Array();
   sampleForm: FormGroup;
  constructor(
    private activeModal: NgbActiveModal,
    private http: Http,
    private fb: FormBuilder,
  ) {
     this.getTrainSample().then(data => this.sampleList = data);
  }
  ngOnInit(): void {
    this.sampleForm = this.fb.group({
      sampleName: ['', Validators.required],
      sampleExplain: '',
      sampleResource: ['', Validators.required],
    });
  }

  getTrainSample(): Promise<any> {
    return this.http.get(`${this.env.host}/api/searchTrainSample`)
      .toPromise()
      .then(response => response.json())
      .catch(Promise.reject);
  }

  addSampleForm() {
    const url = `${this.env.host}/api/addTrainTask?sampleName=${this.sampleName}`
    + `&sampleExplain=${this.sampleExplain}&sampleResource=${this.sampleResource}`;
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
