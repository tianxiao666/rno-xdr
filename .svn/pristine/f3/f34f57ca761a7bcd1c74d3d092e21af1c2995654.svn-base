import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { X2 } from './x-2.model';
import { X2PopupService } from './x-2-popup.service';
import { X2Service } from './x-2.service';

@Component({
    selector: 'jhi-x-2-delete-dialog',
    templateUrl: './x-2-delete-dialog.component.html'
})
export class X2DeleteDialogComponent {

    x2: X2;

    constructor(
        private x2Service: X2Service,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.x2Service.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'x2ListModification',
                content: 'Deleted an x2'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-x-2-delete-popup',
    template: ''
})
export class X2DeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private x2PopupService: X2PopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.x2PopupService
                .open(X2DeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
