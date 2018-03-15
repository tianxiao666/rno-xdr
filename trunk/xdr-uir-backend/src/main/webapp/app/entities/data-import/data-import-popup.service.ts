import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DataImport } from './data-import.model';
import { DataImportService } from './data-import.service';

@Injectable()
export class DataImportPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private dataImportService: DataImportService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.dataImportService.find(id).subscribe((dataImport) => {
                if (dataImport.dataDate) {
                    dataImport.dataDate = {
                        year: dataImport.dataDate.getFullYear(),
                        month: dataImport.dataDate.getMonth() + 1,
                        day: dataImport.dataDate.getDate()
                    };
                }
                this.dataImportModalRef(component, dataImport);
            });
        } else {
            return this.dataImportModalRef(component, new DataImport());
        }
    }

    dataImportModalRef(component: Component, dataImport: DataImport): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.dataImport = dataImport;
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
