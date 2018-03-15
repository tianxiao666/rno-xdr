import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Signalling } from './signalling.model';
import { SignallingPopupService } from './signalling-popup.service';
import { SignallingService } from './signalling.service';

@Component({
    selector: 'jhi-signalling-dialog',
    templateUrl: './signalling-dialog.component.html'
})
export class SignallingDialogComponent implements OnInit {

    signalling: Signalling;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private signallingService: SignallingService,
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
        if (this.signalling.id !== undefined) {
            this.subscribeToSaveResponse(
                this.signallingService.update(this.signalling));
        } else {
            this.subscribeToSaveResponse(
                this.signallingService.create(this.signalling));
        }
    }

    private subscribeToSaveResponse(result: Observable<Signalling>) {
        result.subscribe((res: Signalling) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Signalling) {
        this.eventManager.broadcast({ name: 'signallingListModification', content: 'OK'});
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
    selector: 'jhi-signalling-popup',
    template: ''
})
export class SignallingPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private signallingPopupService: SignallingPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.signallingPopupService
                    .open(SignallingDialogComponent, params['id']);
            } else {
                this.modalRef = this.signallingPopupService
                    .open(SignallingDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
