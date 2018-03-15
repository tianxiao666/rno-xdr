import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Uhttp } from './uhttp.model';
import { UhttpPopupService } from './uhttp-popup.service';
import { UhttpService } from './uhttp.service';

@Component({
    selector: 'jhi-uhttp-delete-dialog',
    templateUrl: './uhttp-delete-dialog.component.html'
})
export class UhttpDeleteDialogComponent {

    uhttp: Uhttp;

    constructor(
        private uhttpService: UhttpService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.uhttpService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'uhttpListModification',
                content: 'Deleted an uhttp'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-uhttp-delete-popup',
    template: ''
})
export class UhttpDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private uhttpPopupService: UhttpPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.uhttpPopupService
                .open(UhttpDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
