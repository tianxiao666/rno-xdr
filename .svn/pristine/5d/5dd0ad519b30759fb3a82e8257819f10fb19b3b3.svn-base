import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Solve } from './solve.model';
import { SolvePopupService } from './solve-popup.service';
import { SolveService } from './solve.service';

@Component({
    selector: 'jhi-solve-delete-dialog',
    templateUrl: './solve-delete-dialog.component.html'
})
export class SolveDeleteDialogComponent {

    solve: Solve;

    constructor(
        private solveService: SolveService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.solveService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'solveListModification',
                content: 'Deleted an solve'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-solve-delete-popup',
    template: ''
})
export class SolveDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private solvePopupService: SolvePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.solvePopupService
                .open(SolveDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
