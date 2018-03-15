package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.web.rest.cond.IndicatorCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Uu.
 */
@Service
@Transactional
public class IndicatorService {

    private final Logger log = LoggerFactory.getLogger(IndicatorService.class);

    private final MmeService mmeService;
    private final MrService mrService;
    private final UhttpService uhttpService;
    private final UuService uuService;
    private final X2Service x2Service;

    public IndicatorService(MmeService mmeService, MrService mrService, UhttpService uhttpService, UuService uuService, X2Service x2Service) {
        this.mmeService = mmeService;
        this.mrService = mrService;
        this.uhttpService = uhttpService;
        this.uuService = uuService;
        this.x2Service = x2Service;
    }

    public Object findBrd39(String gradingType, String cellType, IndicatorCond indicatorCond) {
        return mmeService.findMme(gradingType, cellType, indicatorCond);
    }

    public Object findMr(String gradingType, String cellType, IndicatorCond indicatorCond) {
        return mrService.findMr(gradingType, cellType, indicatorCond);
    }

    public Object findBrd31(String gradingType, String cellType, IndicatorCond indicatorCond) {
        return uhttpService.findUhttp(gradingType, cellType, indicatorCond);
    }

    public Object findUu(String gradingType, String cellType, IndicatorCond indicatorCond) {
        return uuService.findUu(gradingType, cellType, indicatorCond);
    }

    public Object findX2(String gradingType, String cellType, IndicatorCond indicatorCond) {
        return x2Service.findX2(gradingType, cellType, indicatorCond);
    }

    public Object downloadMr(String cellType, IndicatorCond indicatorCond) {
        return mrService.downloadMr(cellType, indicatorCond);
    }

    public Object downloadBrd31(String cellType, IndicatorCond indicatorCond) {
        return uhttpService.downloadUhttp(cellType, indicatorCond);
    }

    public Object downloadBrd39(String cellType, IndicatorCond indicatorCond) {
        return mmeService.downloadMme(cellType, indicatorCond);
    }

    public Object downloadUu(String cellType, IndicatorCond indicatorCond) {
        return uuService.downloadUu(cellType, indicatorCond);
    }

    public Object downloadX2(String cellType, IndicatorCond indicatorCond) {
        return x2Service.downloadX2(cellType, indicatorCond);
    }
}
