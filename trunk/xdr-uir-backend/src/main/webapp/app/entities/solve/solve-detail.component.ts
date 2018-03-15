import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Solve } from './solve.model';
import { SolveService } from './solve.service';

@Component({
    selector: 'jhi-solve-detail',
    templateUrl: './solve-detail.component.html'
})
export class SolveDetailComponent implements OnInit, OnDestroy {

    solve: Solve;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private solveService: SolveService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSolves();
    }

    load(id) {
        this.solveService.find(id).subscribe((solve) => {
            this.solve = solve;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSolves() {
        this.eventSubscriber = this.eventManager.subscribe(
            'solveListModification',
            (response) => this.load(this.solve.id)
        );
    }
}
