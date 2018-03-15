package com.hgicreate.rno.domain.gis.highspeedrail;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2017/2/23.
 */
//@Document(collection = "highspeedrail")
    @Data
    @Entity
    @Table(name = "HIGHSPEEDRAIL")
public class HighSpeedRail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Long date;
    private Long eci;
    private String cellname;
    private Double lon;
    private Double lat;
    private Integer count;
    private Double sinrul;
    private Double rsrp;
    private Double rsrq;
    private Integer locid;
}
