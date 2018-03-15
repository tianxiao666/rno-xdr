/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ExceptionCauseDetailComponent } from '../../../../../../main/webapp/app/entities/exception-cause/exception-cause-detail.component';
import { ExceptionCauseService } from '../../../../../../main/webapp/app/entities/exception-cause/exception-cause.service';
import { ExceptionCause } from '../../../../../../main/webapp/app/entities/exception-cause/exception-cause.model';

describe('Component Tests', () => {

    describe('ExceptionCause Management Detail Component', () => {
        let comp: ExceptionCauseDetailComponent;
        let fixture: ComponentFixture<ExceptionCauseDetailComponent>;
        let service: ExceptionCauseService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [ExceptionCauseDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ExceptionCauseService,
                    JhiEventManager
                ]
            }).overrideTemplate(ExceptionCauseDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ExceptionCauseDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ExceptionCauseService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ExceptionCause(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.exceptionCause).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
