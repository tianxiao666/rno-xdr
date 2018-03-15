import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Mr } from './mr.model';
import { MrService } from './mr.service';

@Component({
    selector: 'jhi-mr-detail',
    templateUrl: './mr-detail.component.html'
})
export class MrDetailComponent implements OnInit, OnDestroy {

    mr: Mr;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private mrService: MrService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInMrs();
    }

    load(id) {
        this.mrService.find(id).subscribe((mr) => {
            this.mr = mr;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInMrs() {
        this.eventSubscriber = this.eventManager.subscribe(
            'mrListModification',
            (response) => this.load(this.mr.id)
        );
    }
}
