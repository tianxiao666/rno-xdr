import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { ExceptionStats } from './exception-stats.model';
import { ExceptionStatsService } from './exception-stats.service';

@Component({
    selector: 'jhi-exception-stats-detail',
    templateUrl: './exception-stats-detail.component.html'
})
export class ExceptionStatsDetailComponent implements OnInit, OnDestroy {

    exceptionStats: ExceptionStats;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private exceptionStatsService: ExceptionStatsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInExceptionStats();
    }

    load(id) {
        this.exceptionStatsService.find(id).subscribe((exceptionStats) => {
            this.exceptionStats = exceptionStats;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInExceptionStats() {
        this.eventSubscriber = this.eventManager.subscribe(
            'exceptionStatsListModification',
            (response) => this.load(this.exceptionStats.id)
        );
    }
}
