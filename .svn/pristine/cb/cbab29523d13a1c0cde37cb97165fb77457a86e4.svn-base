import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Mme } from './mme.model';
import { MmeService } from './mme.service';

@Injectable()
export class MmePopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private mmeService: MmeService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.mmeService.find(id).subscribe((mme) => {
                if (mme.pdate) {
                    mme.pdate = {
                        year: mme.pdate.getFullYear(),
                        month: mme.pdate.getMonth() + 1,
                        day: mme.pdate.getDate()
                    };
                }
                this.mmeModalRef(component, mme);
            });
        } else {
            return this.mmeModalRef(component, new Mme());
        }
    }

    mmeModalRef(component: Component, mme: Mme): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.mme = mme;
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
