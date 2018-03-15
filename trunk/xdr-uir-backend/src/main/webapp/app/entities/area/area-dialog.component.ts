import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { Area } from './area.model';
import { AreaPopupService } from './area-popup.service';
import { AreaService } from './area.service';

@Component({
    selector: 'jhi-area-dialog',
    templateUrl: './area-dialog.component.html'
})
export class AreaDialogComponent implements OnInit {

    area: Area;
    authorities: any[];
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private areaService: AreaService,
        private eventManager: EventManager
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
        if (this.area.id !== undefined) {
            this.subscribeToSaveResponse(
                this.areaService.update(this.area), false);
        } else {
            this.subscribeToSaveResponse(
                this.areaService.create(this.area), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<Area>, isCreated: boolean) {
        result.subscribe((res: Area) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Area, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'backendApp.area.created'
            : 'backendApp.area.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'areaListModification', content: 'OK'});
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
    selector: 'jhi-area-popup',
    template: ''
})
export class AreaPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private areaPopupService: AreaPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.areaPopupService
                    .open(AreaDialogComponent, params['id']);
            } else {
                this.modalRef = this.areaPopupService
                    .open(AreaDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
