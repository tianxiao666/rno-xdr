import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ExceptionStats } from './exception-stats.model';
import { ExceptionStatsPopupService } from './exception-stats-popup.service';
import { ExceptionStatsService } from './exception-stats.service';

@Component({
    selector: 'jhi-exception-stats-dialog',
    templateUrl: './exception-stats-dialog.component.html'
})
export class ExceptionStatsDialogComponent implements OnInit {

    exceptionStats: ExceptionStats;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private exceptionStatsService: ExceptionStatsService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.exceptionStats.id !== undefined) {
            this.subscribeToSaveResponse(
                this.exceptionStatsService.update(this.exceptionStats));
        } else {
            this.subscribeToSaveResponse(
                this.exceptionStatsService.create(this.exceptionStats));
        }
    }

    private subscribeToSaveResponse(result: Observable<ExceptionStats>) {
        result.subscribe((res: ExceptionStats) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ExceptionStats) {
        this.eventManager.broadcast({ name: 'exceptionStatsListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }
}

@Component({
    selector: 'jhi-exception-stats-popup',
    template: ''
})
export class ExceptionStatsPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private exceptionStatsPopupService: ExceptionStatsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.exceptionStatsPopupService
                    .open(ExceptionStatsDialogComponent, params['id']);
            } else {
                this.modalRef = this.exceptionStatsPopupService
                    .open(ExceptionStatsDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
