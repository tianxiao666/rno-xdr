import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Track } from './track.model';
import { TrackService } from './track.service';

@Injectable()
export class TrackPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private trackService: TrackService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.trackService.find(id).subscribe((track) => {
                if (track.pdate) {
                    track.pdate = {
                        year: track.pdate.getFullYear(),
                        month: track.pdate.getMonth() + 1,
                        day: track.pdate.getDate()
                    };
                }
                this.trackModalRef(component, track);
            });
        } else {
            return this.trackModalRef(component, new Track());
        }
    }

    trackModalRef(component: Component, track: Track): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.track = track;
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
