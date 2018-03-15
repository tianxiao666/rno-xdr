import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Interfere } from './interfere.model';
import { InterferePopupService } from './interfere-popup.service';
import { InterfereService } from './interfere.service';

@Component({
    selector: 'jhi-interfere-delete-dialog',
    templateUrl: './interfere-delete-dialog.component.html'
})
export class InterfereDeleteDialogComponent {

    interfere: Interfere;

    constructor(
        private interfereService: InterfereService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.interfereService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'interfereListModification',
                content: 'Deleted an interfere'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-interfere-delete-popup',
    template: ''
})
export class InterfereDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private interferePopupService: InterferePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.interferePopupService
                .open(InterfereDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
