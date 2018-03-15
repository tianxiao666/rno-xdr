import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { Interfere } from './interfere.model';
import { InterfereService } from './interfere.service';

@Injectable()
export class InterferePopupService {
    private isOpen = false;
    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private interfereService: InterfereService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.interfereService.find(id).subscribe((interfere) => {
                interfere.time = this.datePipe
                    .transform(interfere.time, 'yyyy-MM-ddThh:mm');
                this.interfereModalRef(component, interfere);
            });
        } else {
            return this.interfereModalRef(component, new Interfere());
        }
    }

    interfereModalRef(component: Component, interfere: Interfere): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.interfere = interfere;
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
