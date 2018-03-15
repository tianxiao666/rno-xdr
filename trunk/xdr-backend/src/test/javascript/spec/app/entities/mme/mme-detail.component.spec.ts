/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { BackendTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { MmeDetailComponent } from '../../../../../../main/webapp/app/entities/mme/mme-detail.component';
import { MmeService } from '../../../../../../main/webapp/app/entities/mme/mme.service';
import { Mme } from '../../../../../../main/webapp/app/entities/mme/mme.model';

describe('Component Tests', () => {

    describe('Mme Management Detail Component', () => {
        let comp: MmeDetailComponent;
        let fixture: ComponentFixture<MmeDetailComponent>;
        let service: MmeService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [BackendTestModule],
                declarations: [MmeDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    MmeService,
                    JhiEventManager
                ]
            }).overrideTemplate(MmeDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MmeDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MmeService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new Mme(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.mme).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
