import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Interfere } from './interfere.model';
import { InterfereService } from './interfere.service';

@Component({
    selector: 'jhi-interfere-detail',
    templateUrl: './interfere-detail.component.html'
})
export class InterfereDetailComponent implements OnInit, OnDestroy {

    interfere: Interfere;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private interfereService: InterfereService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInInterferes();
    }

    load(id) {
        this.interfereService.find(id).subscribe((interfere) => {
            this.interfere = interfere;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInInterferes() {
        this.eventSubscriber = this.eventManager.subscribe(
            'interfereListModification',
            (response) => this.load(this.interfere.id)
        );
    }
}
