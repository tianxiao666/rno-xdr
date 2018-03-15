import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Mr } from './mr.model';
import { MrPopupService } from './mr-popup.service';
import { MrService } from './mr.service';

@Component({
    selector: 'jhi-mr-dialog',
    templateUrl: './mr-dialog.component.html'
})
export class MrDialogComponent implements OnInit {

    mr: Mr;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private mrService: MrService,
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
        if (this.mr.id !== undefined) {
            this.subscribeToSaveResponse(
                this.mrService.update(this.mr));
        } else {
            this.subscribeToSaveResponse(
                this.mrService.create(this.mr));
        }
    }

    private subscribeToSaveResponse(result: Observable<Mr>) {
        result.subscribe((res: Mr) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Mr) {
        this.eventManager.broadcast({ name: 'mrListModification', content: 'OK'});
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
    selector: 'jhi-mr-popup',
    template: ''
})
export class MrPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private mrPopupService: MrPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.mrPopupService
                    .open(MrDialogComponent, params['id']);
            } else {
                this.modalRef = this.mrPopupService
                    .open(MrDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
