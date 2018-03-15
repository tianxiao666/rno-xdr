import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Mr } from './mr.model';
import { MrService } from './mr.service';

@Injectable()
export class MrPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private mrService: MrService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.mrService.find(id).subscribe((mr) => {
                if (mr.pdate) {
                    mr.pdate = {
                        year: mr.pdate.getFullYear(),
                        month: mr.pdate.getMonth() + 1,
                        day: mr.pdate.getDate()
                    };
                }
                this.mrModalRef(component, mr);
            });
        } else {
            return this.mrModalRef(component, new Mr());
        }
    }

    mrModalRef(component: Component, mr: Mr): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.mr = mr;
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
