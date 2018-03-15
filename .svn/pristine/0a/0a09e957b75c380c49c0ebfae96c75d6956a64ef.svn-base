/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ExceptionStatsDetailComponent } from '../../../../../../main/webapp/app/entities/exception-stats/exception-stats-detail.component';
import { ExceptionStatsService } from '../../../../../../main/webapp/app/entities/exception-stats/exception-stats.service';
import { ExceptionStats } from '../../../../../../main/webapp/app/entities/exception-stats/exception-stats.model';

describe('Component Tests', () => {

    describe('ExceptionStats Management Detail Component', () => {
        let comp: ExceptionStatsDetailComponent;
        let fixture: ComponentFixture<ExceptionStatsDetailComponent>;
        let service: ExceptionStatsService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [ExceptionStatsDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ExceptionStatsService,
                    JhiEventManager
                ]
            }).overrideTemplate(ExceptionStatsDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ExceptionStatsDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ExceptionStatsService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ExceptionStats(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.exceptionStats).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
