/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { MrDetailComponent } from '../../../../../../main/webapp/app/entities/mr/mr-detail.component';
import { MrService } from '../../../../../../main/webapp/app/entities/mr/mr.service';
import { Mr } from '../../../../../../main/webapp/app/entities/mr/mr.model';

describe('Component Tests', () => {

    describe('Mr Management Detail Component', () => {
        let comp: MrDetailComponent;
        let fixture: ComponentFixture<MrDetailComponent>;
        let service: MrService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [MrDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    MrService,
                    JhiEventManager
                ]
            }).overrideTemplate(MrDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MrDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MrService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Mr(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.mr).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
