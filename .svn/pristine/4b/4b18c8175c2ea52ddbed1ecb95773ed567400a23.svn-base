import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertService, EventManager } from 'ng-jhipster';

import { Area } from './area.model';
import { AreaPopupService } from './area-popup.service';
import { AreaService } from './area.service';

@Component({
    selector: 'jhi-area-delete-dialog',
    templateUrl: './area-delete-dialog.component.html'
})
export class AreaDeleteDialogComponent {

    area: Area;

    constructor(
        private areaService: AreaService,
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.areaService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'areaListModification',
                content: 'Deleted an area'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('backendApp.area.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-area-delete-popup',
    template: ''
})
export class AreaDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private areaPopupService: AreaPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.areaPopupService
                .open(AreaDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
