package com.hgicreate.rno.domain.indicator.x2;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hadoop on 2016/12/23.
 */
@Data
public class X2Base {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String x2_switch_success_rat;
    private Integer x2_switch_request;
    private Integer x2_switch_success;

}
