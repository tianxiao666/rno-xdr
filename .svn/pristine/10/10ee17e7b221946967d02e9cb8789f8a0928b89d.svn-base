import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Uu } from './uu.model';
import { UuPopupService } from './uu-popup.service';
import { UuService } from './uu.service';

@Component({
    selector: 'jhi-uu-delete-dialog',
    templateUrl: './uu-delete-dialog.component.html'
})
export class UuDeleteDialogComponent {

    uu: Uu;

    constructor(
        private uuService: UuService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.uuService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'uuListModification',
                content: 'Deleted an uu'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-uu-delete-popup',
    template: ''
})
export class UuDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private uuPopupService: UuPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.uuPopupService
                .open(UuDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
