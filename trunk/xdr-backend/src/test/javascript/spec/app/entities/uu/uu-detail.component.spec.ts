/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { UuDetailComponent } from '../../../../../../main/webapp/app/entities/uu/uu-detail.component';
import { UuService } from '../../../../../../main/webapp/app/entities/uu/uu.service';
import { Uu } from '../../../../../../main/webapp/app/entities/uu/uu.model';

describe('Component Tests', () => {

    describe('Uu Management Detail Component', () => {
        let comp: UuDetailComponent;
        let fixture: ComponentFixture<UuDetailComponent>;
        let service: UuService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [UuDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    UuService,
                    JhiEventManager
                ]
            }).overrideTemplate(UuDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UuDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UuService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Uu(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.uu).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
