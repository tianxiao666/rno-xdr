package com.hgicreate.rno.domain.track;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2017/2/10.
 */
//@Document(collection = "track")
    @Data
    @Entity
    @Table(name = "TRACK")
public class Track {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private long imsi;
    private long imei;
    private long msisdn;
    private int proceduretype;
    private long starttime;
    private long endtime;
    private int status;
    private long cellid;
    private double lat;
    private double lon;
}
