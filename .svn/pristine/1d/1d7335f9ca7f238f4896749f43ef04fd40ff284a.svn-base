import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Uhttp } from './uhttp.model';
import { UhttpService } from './uhttp.service';

@Injectable()
export class UhttpPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private uhttpService: UhttpService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.uhttpService.find(id).subscribe((uhttp) => {
                if (uhttp.pdate) {
                    uhttp.pdate = {
                        year: uhttp.pdate.getFullYear(),
                        month: uhttp.pdate.getMonth() + 1,
                        day: uhttp.pdate.getDate()
                    };
                }
                this.uhttpModalRef(component, uhttp);
            });
        } else {
            return this.uhttpModalRef(component, new Uhttp());
        }
    }

    uhttpModalRef(component: Component, uhttp: Uhttp): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.uhttp = uhttp;
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
