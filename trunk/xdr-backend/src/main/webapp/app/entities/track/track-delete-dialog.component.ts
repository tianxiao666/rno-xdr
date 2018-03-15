import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Track } from './track.model';
import { TrackPopupService } from './track-popup.service';
import { TrackService } from './track.service';

@Component({
    selector: 'jhi-track-delete-dialog',
    templateUrl: './track-delete-dialog.component.html'
})
export class TrackDeleteDialogComponent {

    track: Track;

    constructor(
        private trackService: TrackService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.trackService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'trackListModification',
                content: 'Deleted an track'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-track-delete-popup',
    template: ''
})
export class TrackDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private trackPopupService: TrackPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.trackPopupService
                .open(TrackDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
