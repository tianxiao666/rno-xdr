import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Uu } from './uu.model';
import { UuService } from './uu.service';

@Component({
    selector: 'jhi-uu-detail',
    templateUrl: './uu-detail.component.html'
})
export class UuDetailComponent implements OnInit, OnDestroy {

    uu: Uu;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private uuService: UuService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInUus();
    }

    load(id) {
        this.uuService.find(id).subscribe((uu) => {
            this.uu = uu;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInUus() {
        this.eventSubscriber = this.eventManager.subscribe(
            'uuListModification',
            (response) => this.load(this.uu.id)
        );
    }
}
