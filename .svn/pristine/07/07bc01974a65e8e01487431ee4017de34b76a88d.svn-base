import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager  } from 'ng-jhipster';

import { DataImport } from './data-import.model';
import { DataImportService } from './data-import.service';

@Component({
    selector: 'jhi-data-import-detail',
    templateUrl: './data-import-detail.component.html'
})
export class DataImportDetailComponent implements OnInit, OnDestroy {

    dataImport: DataImport;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private dataImportService: DataImportService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDataImports();
    }

    load(id) {
        this.dataImportService.find(id).subscribe((dataImport) => {
            this.dataImport = dataImport;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDataImports() {
        this.eventSubscriber = this.eventManager.subscribe(
            'dataImportListModification',
            (response) => this.load(this.dataImport.id)
        );
    }
}
