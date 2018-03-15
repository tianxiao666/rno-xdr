package com.hgicreate.rno.domain.indicator.brd31;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "Indicator_brd31NetHour")
    @Data
    @Entity
    @Table(name = "INDICATOR_BRD31NETHOUR")
public class Brd31NetHour {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Integer flow_sum;
    private Double rate_flow_rat;
    private Double rate_flow_success_rat;
    private Double rate_flow_success_degradation_rat;
    private Integer rate_flow;
    private Integer rate_flow_request;
    private Double rate_flow_bp__speed;
    private Double rate_flow_bp_degradation_rat;
    private Double rate_flow_sp_delay;
    private Double rate_flow_sp_delay_degradation_rat;
    private Double delay_flow_rat;
    private Double delay_flow_success_rat;
    private Double delay_flow_success_degradation_rat;
    private Integer delay_flow;
    private Integer delay_flow_request;
    private Double delay_flow_bp_speed;
    private Double delay_flow_bp_speed_ratd;
    private Double delay_flow_sp_delay;
    private Double delay_flow_sp_delay_ratd;
    private Double refresh_flow_rat;
    private Double refresh_flow_success_rat;
    private Double refresh_flow_success_ratd;
    private Integer refresh_flow;
    private Integer refresh_flow_request;
    private Double refresh_flow_bp_speed;
    private Double refresh_flow_bp_speed_ratd;
    private Double refresh_flow_sp_delay;
    private Double refresh_flow_sp_delay_ratd;
    private Integer instant_flow_rat;
    private Double instant_flow_success_rat;
    private Double instant_flow_success_ratd;
    private Integer instant_flow;
    private Integer instant_flow_request;
    private Double instant_flow_bp_speed;
    private Double instant_flow_bp_speed_ratd;
    private Double instant_flow_sp_delay;
    private Double instant_flow_sp_delay_ratd;

    private Long date;
    private Long hour;
}
