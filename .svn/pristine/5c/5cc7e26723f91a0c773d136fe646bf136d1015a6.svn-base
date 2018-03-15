import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Track } from './track.model';
import { TrackPopupService } from './track-popup.service';
import { TrackService } from './track.service';

@Component({
    selector: 'jhi-track-dialog',
    templateUrl: './track-dialog.component.html'
})
export class TrackDialogComponent implements OnInit {

    track: Track;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private trackService: TrackService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.track.id !== undefined) {
            this.subscribeToSaveResponse(
                this.trackService.update(this.track));
        } else {
            this.subscribeToSaveResponse(
                this.trackService.create(this.track));
        }
    }

    private subscribeToSaveResponse(result: Observable<Track>) {
        result.subscribe((res: Track) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Track) {
        this.eventManager.broadcast({ name: 'trackListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }
}

@Component({
    selector: 'jhi-track-popup',
    template: ''
})
export class TrackPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private trackPopupService: TrackPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.trackPopupService
                    .open(TrackDialogComponent, params['id']);
            } else {
                this.modalRef = this.trackPopupService
                    .open(TrackDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
