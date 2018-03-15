import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiAlertService, JhiEventManager } from 'ng-jhipster';

import { DataImport } from './data-import.model';
import { DataImportPopupService } from './data-import-popup.service';
import { DataImportService } from './data-import.service';

@Component({
    selector: 'jhi-data-import-delete-dialog',
    templateUrl: './data-import-delete-dialog.component.html'
})
export class DataImportDeleteDialogComponent {

    dataImport: DataImport;

    constructor(
        private dataImportService: DataImportService,
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.dataImportService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'dataImportListModification',
                content: 'Deleted an dataImport'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('backendApp.dataImport.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-data-import-delete-popup',
    template: ''
})
export class DataImportDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dataImportPopupService: DataImportPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.dataImportPopupService
                .open(DataImportDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
