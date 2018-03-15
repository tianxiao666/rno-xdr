import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Solve } from './solve.model';
import { SolvePopupService } from './solve-popup.service';
import { SolveService } from './solve.service';
import { Interfere, InterfereService } from '../interfere';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-solve-dialog',
    templateUrl: './solve-dialog.component.html'
})
export class SolveDialogComponent implements OnInit {

    solve: Solve;
    authorities: any[];
    isSaving: boolean;

    interferes: Interfere[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private solveService: SolveService,
        private interfereService: InterfereService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.interfereService.query()
            .subscribe((res: ResponseWrapper) => { this.interferes = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.solve.id !== undefined) {
            this.subscribeToSaveResponse(
                this.solveService.update(this.solve));
        } else {
            this.subscribeToSaveResponse(
                this.solveService.create(this.solve));
        }
    }

    private subscribeToSaveResponse(result: Observable<Solve>) {
        result.subscribe((res: Solve) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Solve) {
        this.eventManager.broadcast({ name: 'solveListModification', content: 'OK'});
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

    trackInterfereById(index: number, item: Interfere) {
        return item.id;
    }

    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }
}

@Component({
    selector: 'jhi-solve-popup',
    template: ''
})
export class SolvePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private solvePopupService: SolvePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.solvePopupService
                    .open(SolveDialogComponent, params['id']);
            } else {
                this.modalRef = this.solvePopupService
                    .open(SolveDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
