package com.hgicreate.rno.domain.cause.brd39.csfb;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hadoop on 2016/12/23.
 */
@Data
public class CsfbCellUserHour  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private int cause;
    private int count_cause;
}
