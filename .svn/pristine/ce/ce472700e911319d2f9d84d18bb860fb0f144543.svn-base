import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { Track } from './track.model';
import { TrackService } from './track.service';

@Component({
    selector: 'jhi-track-detail',
    templateUrl: './track-detail.component.html'
})
export class TrackDetailComponent implements OnInit, OnDestroy {

    track: Track;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private trackService: TrackService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInTracks();
    }

    load(id) {
        this.trackService.find(id).subscribe((track) => {
            this.track = track;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInTracks() {
        this.eventSubscriber = this.eventManager.subscribe(
            'trackListModification',
            (response) => this.load(this.track.id)
        );
    }
}
