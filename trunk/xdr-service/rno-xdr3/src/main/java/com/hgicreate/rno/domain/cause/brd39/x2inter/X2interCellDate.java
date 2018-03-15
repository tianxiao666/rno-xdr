package com.hgicreate.rno.domain.cause.brd39.x2inter;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "cause_brd39_x2interCellDate")
    @Data
    @Entity
    @Table(name = "CAUSE_BRD39_X2INTERCELLDATE")
public class X2interCellDate  {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private int cause;
    private int count_cause;

    private long date;
    private long cellid;
}