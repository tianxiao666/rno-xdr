import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { X2 } from './x-2.model';
import { X2Service } from './x-2.service';

@Component({
    selector: 'jhi-x-2-detail',
    templateUrl: './x-2-detail.component.html'
})
export class X2DetailComponent implements OnInit, OnDestroy {

    x2: X2;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private x2Service: X2Service,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInX2S();
    }

    load(id) {
        this.x2Service.find(id).subscribe((x2) => {
            this.x2 = x2;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInX2S() {
        this.eventSubscriber = this.eventManager.subscribe(
            'x2ListModification',
            (response) => this.load(this.x2.id)
        );
    }
}
