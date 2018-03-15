/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { SignallingDetailComponent } from '../../../../../../main/webapp/app/entities/signalling/signalling-detail.component';
import { SignallingService } from '../../../../../../main/webapp/app/entities/signalling/signalling.service';
import { Signalling } from '../../../../../../main/webapp/app/entities/signalling/signalling.model';

describe('Component Tests', () => {

    describe('Signalling Management Detail Component', () => {
        let comp: SignallingDetailComponent;
        let fixture: ComponentFixture<SignallingDetailComponent>;
        let service: SignallingService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [SignallingDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    SignallingService,
                    JhiEventManager
                ]
            }).overrideTemplate(SignallingDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SignallingDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SignallingService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Signalling(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.signalling).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
