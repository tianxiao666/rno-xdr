package com.hgicreate.rno.domain.cause.brd39.attach;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "cause_brd39_attachNetDate")
@Entity
@Table(name = "CAUSE_BRD39_ATTACHNETDATE")
@Data
public class AttachNetDate  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Integer cause;
    private Integer count_cause;

    private long date;
}
