package com.hgicreate.rno.domain.cause.brd39.context;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "cause_brd39_contextNetHour")
    @Data
    @Entity
    @Table(name = "CAUSE_BRD39_CONTEXTNETHOUR")
public class ContextNetHour  {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private int cause;
    private int count_cause;

    private long date;
    private long hour;
}
