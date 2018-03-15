import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Mr } from './mr.model';
import { MrPopupService } from './mr-popup.service';
import { MrService } from './mr.service';

@Component({
    selector: 'jhi-mr-delete-dialog',
    templateUrl: './mr-delete-dialog.component.html'
})
export class MrDeleteDialogComponent {

    mr: Mr;

    constructor(
        private mrService: MrService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.mrService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'mrListModification',
                content: 'Deleted an mr'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-mr-delete-popup',
    template: ''
})
export class MrDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private mrPopupService: MrPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.mrPopupService
                .open(MrDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
