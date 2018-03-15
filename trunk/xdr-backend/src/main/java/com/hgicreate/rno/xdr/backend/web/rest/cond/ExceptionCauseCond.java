package com.hgicreate.rno.xdr.backend.web.rest.cond;

import lombok.Data;

/**
 * View Model object for storing a Logback logger.
 */
@Data
public class ExceptionCauseCond {

    private Long date;

    private Long imsi;

    private Long eci;

    private String indicatorType;
}
