package com.hgicreate.rno.domain.indicator.x2;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "Indicator_x2NetHour")
    @Data
    @Entity
    @Table(name = "INDICATOR_X2NETHOUR")
public class X2NetHour  {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String x2_switch_success_rat;
    private Integer x2_switch_request;
    private Integer x2_switch_success;

    private Long date;
    private Long hour;

}
