import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ExceptionStats } from './exception-stats.model';
import { ExceptionStatsPopupService } from './exception-stats-popup.service';
import { ExceptionStatsService } from './exception-stats.service';

@Component({
    selector: 'jhi-exception-stats-delete-dialog',
    templateUrl: './exception-stats-delete-dialog.component.html'
})
export class ExceptionStatsDeleteDialogComponent {

    exceptionStats: ExceptionStats;

    constructor(
        private exceptionStatsService: ExceptionStatsService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.exceptionStatsService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'exceptionStatsListModification',
                content: 'Deleted an exceptionStats'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-exception-stats-delete-popup',
    template: ''
})
export class ExceptionStatsDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private exceptionStatsPopupService: ExceptionStatsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.exceptionStatsPopupService
                .open(ExceptionStatsDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
