/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { UhttpDetailComponent } from '../../../../../../main/webapp/app/entities/uhttp/uhttp-detail.component';
import { UhttpService } from '../../../../../../main/webapp/app/entities/uhttp/uhttp.service';
import { Uhttp } from '../../../../../../main/webapp/app/entities/uhttp/uhttp.model';

describe('Component Tests', () => {

    describe('Uhttp Management Detail Component', () => {
        let comp: UhttpDetailComponent;
        let fixture: ComponentFixture<UhttpDetailComponent>;
        let service: UhttpService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [UhttpDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    UhttpService,
                    JhiEventManager
                ]
            }).overrideTemplate(UhttpDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UhttpDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UhttpService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Uhttp(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.uhttp).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
