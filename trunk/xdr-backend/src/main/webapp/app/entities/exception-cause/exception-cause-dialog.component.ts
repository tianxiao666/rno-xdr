import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ExceptionCause } from './exception-cause.model';
import { ExceptionCausePopupService } from './exception-cause-popup.service';
import { ExceptionCauseService } from './exception-cause.service';

@Component({
    selector: 'jhi-exception-cause-dialog',
    templateUrl: './exception-cause-dialog.component.html'
})
export class ExceptionCauseDialogComponent implements OnInit {

    exceptionCause: ExceptionCause;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private exceptionCauseService: ExceptionCauseService,
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
        if (this.exceptionCause.id !== undefined) {
            this.subscribeToSaveResponse(
                this.exceptionCauseService.update(this.exceptionCause));
        } else {
            this.subscribeToSaveResponse(
                this.exceptionCauseService.create(this.exceptionCause));
        }
    }

    private subscribeToSaveResponse(result: Observable<ExceptionCause>) {
        result.subscribe((res: ExceptionCause) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ExceptionCause) {
        this.eventManager.broadcast({ name: 'exceptionCauseListModification', content: 'OK'});
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
    selector: 'jhi-exception-cause-popup',
    template: ''
})
export class ExceptionCausePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private exceptionCausePopupService: ExceptionCausePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.exceptionCausePopupService
                    .open(ExceptionCauseDialogComponent, params['id']);
            } else {
                this.modalRef = this.exceptionCausePopupService
                    .open(ExceptionCauseDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
