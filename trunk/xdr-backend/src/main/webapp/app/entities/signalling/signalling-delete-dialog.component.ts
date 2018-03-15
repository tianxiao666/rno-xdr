import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Signalling } from './signalling.model';
import { SignallingPopupService } from './signalling-popup.service';
import { SignallingService } from './signalling.service';

@Component({
    selector: 'jhi-signalling-delete-dialog',
    templateUrl: './signalling-delete-dialog.component.html'
})
export class SignallingDeleteDialogComponent {

    signalling: Signalling;

    constructor(
        private signallingService: SignallingService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.signallingService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'signallingListModification',
                content: 'Deleted an signalling'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-signalling-delete-popup',
    template: ''
})
export class SignallingDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private signallingPopupService: SignallingPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.signallingPopupService
                .open(SignallingDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
