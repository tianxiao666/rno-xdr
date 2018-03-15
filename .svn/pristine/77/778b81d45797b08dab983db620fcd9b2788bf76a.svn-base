import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Signalling } from './signalling.model';
import { SignallingService } from './signalling.service';

@Injectable()
export class SignallingPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private signallingService: SignallingService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.signallingService.find(id).subscribe((signalling) => {
                if (signalling.pdate) {
                    signalling.pdate = {
                        year: signalling.pdate.getFullYear(),
                        month: signalling.pdate.getMonth() + 1,
                        day: signalling.pdate.getDate()
                    };
                }
                this.signallingModalRef(component, signalling);
            });
        } else {
            return this.signallingModalRef(component, new Signalling());
        }
    }

    signallingModalRef(component: Component, signalling: Signalling): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.signalling = signalling;
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
