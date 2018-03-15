import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Mme } from './mme.model';
import { MmePopupService } from './mme-popup.service';
import { MmeService } from './mme.service';

@Component({
    selector: 'jhi-mme-dialog',
    templateUrl: './mme-dialog.component.html'
})
export class MmeDialogComponent implements OnInit {

    mme: Mme;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private mmeService: MmeService,
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
        if (this.mme.id !== undefined) {
            this.subscribeToSaveResponse(
                this.mmeService.update(this.mme));
        } else {
            this.subscribeToSaveResponse(
                this.mmeService.create(this.mme));
        }
    }

    private subscribeToSaveResponse(result: Observable<Mme>) {
        result.subscribe((res: Mme) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Mme) {
        this.eventManager.broadcast({ name: 'mmeListModification', content: 'OK'});
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
    selector: 'jhi-mme-popup',
    template: ''
})
export class MmePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private mmePopupService: MmePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.mmePopupService
                    .open(MmeDialogComponent, params['id']);
            } else {
                this.modalRef = this.mmePopupService
                    .open(MmeDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
