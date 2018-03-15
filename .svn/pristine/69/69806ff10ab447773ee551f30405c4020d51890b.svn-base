package com.hgicreate.rno.domain.score;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2017/2/28.
 */
//@Document(collection = "Indicator_brd31CellDate")
    @Data
    @Entity
    @Table(name = "INDICATOR_BRD31CELLDATE")
public class ScoreCellDate {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private long date;
    private long cellid;


    private Double rate_flow_success_rat;
    private Double rate_flow_bp__speed;
    private Double rate_flow_bp_degradation_rat;
    private Double rate_flow_sp_delay;
    private Double rate_flow_sp_delay_degradation_rat;

    private Double delay_flow_success_rat;
    private Double delay_flow_bp_speed;
    private Double delay_flow_bp_degradation_rat;
    private Double delay_flow_sp_delay;
    private Double delay_flow_sp_delay_degradation_rat;

    private Double refresh_flow_success_rat;
    private Double refresh_flow_bp_speed;
    private Double refresh_flow_bp_degradation_rat;
    private Double refresh_flow_sp_delay;
    private Double refresh_flow_sp_delay_degradation_rat;

    private Double instant_flow_success_rat;
    private Double instant_flow_bp_speed;
    private Double instant_flow_bp_degradation_rat;
    private Double instant_flow_sp_delay;
    private Double instant_flow_sp_delay_degradation_rat;

}
