import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Record } from './record.model';
import { RecordPopupService } from './record-popup.service';
import { RecordService } from './record.service';

@Component({
    selector: 'jhi-record-delete-dialog',
    templateUrl: './record-delete-dialog.component.html'
})
export class RecordDeleteDialogComponent {

    record: Record;

    constructor(
        private recordService: RecordService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.recordService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'recordListModification',
                content: 'Deleted an record'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-record-delete-popup',
    template: ''
})
export class RecordDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private recordPopupService: RecordPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.recordPopupService
                .open(RecordDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
