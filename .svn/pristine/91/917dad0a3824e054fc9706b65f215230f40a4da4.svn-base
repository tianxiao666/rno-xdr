import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Interfere } from './interfere.model';
import { InterferePopupService } from './interfere-popup.service';
import { InterfereService } from './interfere.service';
import { Area, AreaService } from '../area';
import { Record, RecordService } from '../record';
import { Task, TaskService } from '../task';
import { Solve, SolveService } from '../solve';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-interfere-dialog',
    templateUrl: './interfere-dialog.component.html'
})
export class InterfereDialogComponent implements OnInit {

    interfere: Interfere;
    authorities: any[];
    isSaving: boolean;

    areaids: Area[];

    records: Record[];

    tasks: Task[];

    solves: Solve[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private interfereService: InterfereService,
        private areaService: AreaService,
        private recordService: RecordService,
        private taskService: TaskService,
        private solveService: SolveService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.areaService
            .query({filter: 'id-is-null'})
            .subscribe((res: ResponseWrapper) => {
                if (!this.interfere.areaId || !this.interfere.areaId.id) {
                    this.areaids = res.json;
                } else {
                    this.areaService
                        .find(this.interfere.areaId.id)
                        .subscribe((subRes: Area) => {
                            this.areaids = [subRes].concat(res.json);
                        }, (subRes: ResponseWrapper) => this.onError(subRes.json));
                }
            }, (res: ResponseWrapper) => this.onError(res.json));
        this.recordService.query()
            .subscribe((res: ResponseWrapper) => { this.records = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.taskService.query()
            .subscribe((res: ResponseWrapper) => { this.tasks = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.solveService.query()
            .subscribe((res: ResponseWrapper) => { this.solves = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.interfere.id !== undefined) {
            this.subscribeToSaveResponse(
                this.interfereService.update(this.interfere));
        } else {
            this.subscribeToSaveResponse(
                this.interfereService.create(this.interfere));
        }
    }

    private subscribeToSaveResponse(result: Observable<Interfere>) {
        result.subscribe((res: Interfere) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: Interfere) {
        this.eventManager.broadcast({ name: 'interfereListModification', content: 'OK'});
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

    trackAreaById(index: number, item: Area) {
        return item.id;
    }

    trackRecordById(index: number, item: Record) {
        return item.id;
    }

    trackTaskById(index: number, item: Task) {
        return item.id;
    }

    trackSolveById(index: number, item: Solve) {
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
    selector: 'jhi-interfere-popup',
    template: ''
})
export class InterferePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private interferePopupService: InterferePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.interferePopupService
                    .open(InterfereDialogComponent, params['id']);
            } else {
                this.modalRef = this.interferePopupService
                    .open(InterfereDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
