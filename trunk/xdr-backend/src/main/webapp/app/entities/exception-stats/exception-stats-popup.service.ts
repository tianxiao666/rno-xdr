import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ExceptionStats } from './exception-stats.model';
import { ExceptionStatsService } from './exception-stats.service';

@Injectable()
export class ExceptionStatsPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private exceptionStatsService: ExceptionStatsService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.exceptionStatsService.find(id).subscribe((exceptionStats) => {
                if (exceptionStats.pdate) {
                    exceptionStats.pdate = {
                        year: exceptionStats.pdate.getFullYear(),
                        month: exceptionStats.pdate.getMonth() + 1,
                        day: exceptionStats.pdate.getDate()
                    };
                }
                this.exceptionStatsModalRef(component, exceptionStats);
            });
        } else {
            return this.exceptionStatsModalRef(component, new ExceptionStats());
        }
    }

    exceptionStatsModalRef(component: Component, exceptionStats: ExceptionStats): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.exceptionStats = exceptionStats;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.isOpen = false;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.isOpen = false;
        });
        return modalRef;
    }
}
