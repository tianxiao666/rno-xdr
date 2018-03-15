import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { X2 } from './x-2.model';
import { X2PopupService } from './x-2-popup.service';
import { X2Service } from './x-2.service';

@Component({
    selector: 'jhi-x-2-dialog',
    templateUrl: './x-2-dialog.component.html'
})
export class X2DialogComponent implements OnInit {

    x2: X2;
    authorities: any[];
    isSaving: boolean;
    pdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private x2Service: X2Service,
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
        if (this.x2.id !== undefined) {
            this.subscribeToSaveResponse(
                this.x2Service.update(this.x2));
        } else {
            this.subscribeToSaveResponse(
                this.x2Service.create(this.x2));
        }
    }

    private subscribeToSaveResponse(result: Observable<X2>) {
        result.subscribe((res: X2) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: X2) {
        this.eventManager.broadcast({ name: 'x2ListModification', content: 'OK'});
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
    selector: 'jhi-x-2-popup',
    template: ''
})
export class X2PopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private x2PopupService: X2PopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.x2PopupService
                    .open(X2DialogComponent, params['id']);
            } else {
                this.modalRef = this.x2PopupService
                    .open(X2DialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
