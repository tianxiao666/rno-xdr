import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Record } from './record.model';
import { RecordService } from './record.service';

@Component({
    selector: 'jhi-record-detail',
    templateUrl: './record-detail.component.html'
})
export class RecordDetailComponent implements OnInit, OnDestroy {

    record: Record;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private recordService: RecordService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInRecords();
    }

    load(id) {
        this.recordService.find(id).subscribe((record) => {
            this.record = record;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInRecords() {
        this.eventSubscriber = this.eventManager.subscribe(
            'recordListModification',
            (response) => this.load(this.record.id)
        );
    }
}
