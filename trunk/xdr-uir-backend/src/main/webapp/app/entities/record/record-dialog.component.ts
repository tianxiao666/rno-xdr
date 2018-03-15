import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Record } from './record.model';
import { RecordPopupService } from './record-popup.service';
import { RecordService } from './record.service';

@Component({
    selector: 'jhi-record-dialog',
    templateUrl: './record-dialog.component.html'
})
export class RecordDialogComponent implements OnInit {

    record: Record;
    authorities: any[];
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private recordService: RecordService,
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
        if (this.record.id !== undefined) {
            this.subscribeToSaveResponse(
                this.recordService.update(this.record));
        } else {
            this.subscribeToSaveResponse(
                this.recordService.create(this.record));
        }
    }

    private subscribeToSaveResponse(result: Observable<Record>) {
        result.subscribe((res: Record) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Record) {
        this.eventManager.broadcast({ name: 'recordListModification', content: 'OK'});
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
    selector: 'jhi-record-popup',
    template: ''
})
export class RecordPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private recordPopupService: RecordPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.recordPopupService
                    .open(RecordDialogComponent, params['id']);
            } else {
                this.modalRef = this.recordPopupService
                    .open(RecordDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
