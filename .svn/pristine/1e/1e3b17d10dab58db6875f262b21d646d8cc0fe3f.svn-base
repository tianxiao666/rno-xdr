import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Signalling } from './signalling.model';
import { SignallingService } from './signalling.service';

@Component({
    selector: 'jhi-signalling-detail',
    templateUrl: './signalling-detail.component.html'
})
export class SignallingDetailComponent implements OnInit, OnDestroy {

    signalling: Signalling;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private signallingService: SignallingService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSignallings();
    }

    load(id) {
        this.signallingService.find(id).subscribe((signalling) => {
            this.signalling = signalling;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSignallings() {
        this.eventSubscriber = this.eventManager.subscribe(
            'signallingListModification',
            (response) => this.load(this.signalling.id)
        );
    }
}
