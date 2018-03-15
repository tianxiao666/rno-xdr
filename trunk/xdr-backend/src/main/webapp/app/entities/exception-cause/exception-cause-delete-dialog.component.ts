import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ExceptionCause } from './exception-cause.model';
import { ExceptionCausePopupService } from './exception-cause-popup.service';
import { ExceptionCauseService } from './exception-cause.service';

@Component({
    selector: 'jhi-exception-cause-delete-dialog',
    templateUrl: './exception-cause-delete-dialog.component.html'
})
export class ExceptionCauseDeleteDialogComponent {

    exceptionCause: ExceptionCause;

    constructor(
        private exceptionCauseService: ExceptionCauseService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.exceptionCauseService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'exceptionCauseListModification',
                content: 'Deleted an exceptionCause'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-exception-cause-delete-popup',
    template: ''
})
export class ExceptionCauseDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private exceptionCausePopupService: ExceptionCausePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.exceptionCausePopupService
                .open(ExceptionCauseDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
