import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Uhttp } from './uhttp.model';
import { UhttpService } from './uhttp.service';

@Component({
    selector: 'jhi-uhttp-detail',
    templateUrl: './uhttp-detail.component.html'
})
export class UhttpDetailComponent implements OnInit, OnDestroy {

    uhttp: Uhttp;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private uhttpService: UhttpService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInUhttps();
    }

    load(id) {
        this.uhttpService.find(id).subscribe((uhttp) => {
            this.uhttp = uhttp;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInUhttps() {
        this.eventSubscriber = this.eventManager.subscribe(
            'uhttpListModification',
            (response) => this.load(this.uhttp.id)
        );
    }
}
