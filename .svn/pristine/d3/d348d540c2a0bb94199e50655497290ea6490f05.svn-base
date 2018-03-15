import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ExceptionCause } from './exception-cause.model';
import { ExceptionCauseService } from './exception-cause.service';

@Injectable()
export class ExceptionCausePopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private exceptionCauseService: ExceptionCauseService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.exceptionCauseService.find(id).subscribe((exceptionCause) => {
                if (exceptionCause.pdate) {
                    exceptionCause.pdate = {
                        year: exceptionCause.pdate.getFullYear(),
                        month: exceptionCause.pdate.getMonth() + 1,
                        day: exceptionCause.pdate.getDate()
                    };
                }
                this.exceptionCauseModalRef(component, exceptionCause);
            });
        } else {
            return this.exceptionCauseModalRef(component, new ExceptionCause());
        }
    }

    exceptionCauseModalRef(component: Component, exceptionCause: ExceptionCause): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.exceptionCause = exceptionCause;
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
