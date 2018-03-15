import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Uu } from './uu.model';
import { UuPopupService } from './uu-popup.service';
import { UuService } from './uu.service';

@Component({
    selector: 'jhi-uu-dialog',
    templateUrl: './uu-dialog.component.html'
})
export class UuDialogComponent implements OnInit {

    uu: Uu;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private uuService: UuService,
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
        if (this.uu.id !== undefined) {
            this.subscribeToSaveResponse(
                this.uuService.update(this.uu));
        } else {
            this.subscribeToSaveResponse(
                this.uuService.create(this.uu));
        }
    }

    private subscribeToSaveResponse(result: Observable<Uu>) {
        result.subscribe((res: Uu) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Uu) {
        this.eventManager.broadcast({ name: 'uuListModification', content: 'OK'});
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
    selector: 'jhi-uu-popup',
    template: ''
})
export class UuPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private uuPopupService: UuPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.uuPopupService
                    .open(UuDialogComponent, params['id']);
            } else {
                this.modalRef = this.uuPopupService
                    .open(UuDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
