/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { X2DetailComponent } from '../../../../../../main/webapp/app/entities/x-2/x-2-detail.component';
import { X2Service } from '../../../../../../main/webapp/app/entities/x-2/x-2.service';
import { X2 } from '../../../../../../main/webapp/app/entities/x-2/x-2.model';

describe('Component Tests', () => {

    describe('X2 Management Detail Component', () => {
        let comp: X2DetailComponent;
        let fixture: ComponentFixture<X2DetailComponent>;
        let service: X2Service;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [X2DetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    X2Service,
                    JhiEventManager
                ]
            }).overrideTemplate(X2DetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(X2DetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(X2Service);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new X2(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.x2).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
