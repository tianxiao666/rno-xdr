package com.hgicreate.rno.domain.gis.userlonlat;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2017/2/21.
 */
//@Document(collection = "brd31_lonlat")
    @Data
    @Entity
    @Table(name = "BRD31_LONLAT")
public class UserLonLat {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Long imsi;
    private Long cellid;
    private Long imei;
    private Long msisdn;
    private Long starttime;
    private Long endtime;
    private Integer protocol;
    private Integer ulsinr;
    private Integer ta;
    private Integer aoa;
    private Integer servingrsrp;
    private Double lat;
    private Double lng;

}
