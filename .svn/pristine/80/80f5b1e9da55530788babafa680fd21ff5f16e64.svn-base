import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { ExceptionCause } from './exception-cause.model';
import { ExceptionCauseService } from './exception-cause.service';

@Component({
    selector: 'jhi-exception-cause-detail',
    templateUrl: './exception-cause-detail.component.html'
})
export class ExceptionCauseDetailComponent implements OnInit, OnDestroy {

    exceptionCause: ExceptionCause;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private exceptionCauseService: ExceptionCauseService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInExceptionCauses();
    }

    load(id) {
        this.exceptionCauseService.find(id).subscribe((exceptionCause) => {
            this.exceptionCause = exceptionCause;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInExceptionCauses() {
        this.eventSubscriber = this.eventManager.subscribe(
            'exceptionCauseListModification',
            (response) => this.load(this.exceptionCause.id)
        );
    }
}
