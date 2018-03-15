package com.hgicreate.rno.xdr.backend.web.rest.cond;

import lombok.Data;

/**
 * View Model object for storing a Logback logger.
 */
@Data
public class IndicatorCond {

    private String imsi;

    private String eci;

    private Long beginDate;

    private Long endDate;

    private Long date;

    private Integer size;

    private Integer page;
}
