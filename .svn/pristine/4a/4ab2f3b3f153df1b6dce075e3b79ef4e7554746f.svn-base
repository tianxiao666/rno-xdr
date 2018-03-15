import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Uhttp } from './uhttp.model';
import { UhttpPopupService } from './uhttp-popup.service';
import { UhttpService } from './uhttp.service';

@Component({
    selector: 'jhi-uhttp-dialog',
    templateUrl: './uhttp-dialog.component.html'
})
export class UhttpDialogComponent implements OnInit {

    uhttp: Uhttp;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private uhttpService: UhttpService,
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
        if (this.uhttp.id !== undefined) {
            this.subscribeToSaveResponse(
                this.uhttpService.update(this.uhttp));
        } else {
            this.subscribeToSaveResponse(
                this.uhttpService.create(this.uhttp));
        }
    }

    private subscribeToSaveResponse(result: Observable<Uhttp>) {
        result.subscribe((res: Uhttp) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Uhttp) {
        this.eventManager.broadcast({ name: 'uhttpListModification', content: 'OK'});
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
    selector: 'jhi-uhttp-popup',
    template: ''
})
export class UhttpPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private uhttpPopupService: UhttpPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.uhttpPopupService
                    .open(UhttpDialogComponent, params['id']);
            } else {
                this.modalRef = this.uhttpPopupService
                    .open(UhttpDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
