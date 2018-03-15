import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Mme } from './mme.model';
import { MmeService } from './mme.service';

@Component({
    selector: 'jhi-mme-detail',
    templateUrl: './mme-detail.component.html'
})
export class MmeDetailComponent implements OnInit, OnDestroy {

    mme: Mme;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private mmeService: MmeService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInMmes();
    }

    load(id) {
        this.mmeService.find(id).subscribe((mme) => {
            this.mme = mme;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInMmes() {
        this.eventSubscriber = this.eventManager.subscribe(
            'mmeListModification',
            (response) => this.load(this.mme.id)
        );
    }
}
