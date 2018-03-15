import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Mme } from './mme.model';
import { MmePopupService } from './mme-popup.service';
import { MmeService } from './mme.service';

@Component({
    selector: 'jhi-mme-delete-dialog',
    templateUrl: './mme-delete-dialog.component.html'
})
export class MmeDeleteDialogComponent {

    mme: Mme;

    constructor(
        private mmeService: MmeService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.mmeService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'mmeListModification',
                content: 'Deleted an mme'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-mme-delete-popup',
    template: ''
})
export class MmeDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private mmePopupService: MmePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.mmePopupService
                .open(MmeDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
