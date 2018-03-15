import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { DataImport } from './data-import.model';
import { DataImportPopupService } from './data-import-popup.service';
import { DataImportService } from './data-import.service';

@Component({
    selector: 'jhi-data-import-dialog',
    templateUrl: './data-import-dialog.component.html'
})
export class DataImportDialogComponent implements OnInit {

    dataImport: DataImport;
    authorities: any[];
    isSaving: boolean;
    dataDateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private dataImportService: DataImportService,
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
        if (this.dataImport.id !== undefined) {
            this.subscribeToSaveResponse(
                this.dataImportService.update(this.dataImport), false);
        } else {
            this.subscribeToSaveResponse(
                this.dataImportService.create(this.dataImport), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<DataImport>, isCreated: boolean) {
        result.subscribe((res: DataImport) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: DataImport, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'backendApp.dataImport.created'
            : 'backendApp.dataImport.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'dataImportListModification', content: 'OK'});
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
    selector: 'jhi-data-import-popup',
    template: ''
})
export class DataImportPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dataImportPopupService: DataImportPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.dataImportPopupService
                    .open(DataImportDialogComponent, params['id']);
            } else {
                this.modalRef = this.dataImportPopupService
                    .open(DataImportDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
