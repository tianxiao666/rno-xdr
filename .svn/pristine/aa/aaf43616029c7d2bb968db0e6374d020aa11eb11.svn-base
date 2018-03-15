import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { X2 } from './x-2.model';
import { X2Service } from './x-2.service';

@Injectable()
export class X2PopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private x2Service: X2Service

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.x2Service.find(id).subscribe((x2) => {
                if (x2.pdate) {
                    x2.pdate = {
                        year: x2.pdate.getFullYear(),
                        month: x2.pdate.getMonth() + 1,
                        day: x2.pdate.getDate()
                    };
                }
                this.x2ModalRef(component, x2);
            });
        } else {
            return this.x2ModalRef(component, new X2());
        }
    }

    x2ModalRef(component: Component, x2: X2): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.x2 = x2;
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
