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
//@Document(collection = "Indicator_brd31CellUserDate")
    @Data
    @Entity
    @Table(name = "INDICATOR_BRD31CELLUSERDATE")
public class ScoreCellUserDate {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private Long date;
    private Long cellid;
    private Long imsi;

    private Double rate_flow_success_rat;
    private Double rate_flow_bp__speed;
    private Double rate_flow_bp_degradation_rat;
    private Double rate_flow_sp_delay;
    private Double rate_flow_sp_delay_degradation_rat;


    private Double refresh_flow_success_rat;
    private Double refresh_flow_bp_speed;
    private Double refresh_flow_bp_speed_ratd;
    private Double refresh_flow_sp_delay;
    private Double refresh_flow_sp_delay_ratd;

    private Double delay_flow_success_rat;
    private Double delay_flow_sp_delay;
    private Double delay_flow_sp_delay_ratd;


    private Double instant_flow_success_rat;
    private Double instant_flow_sp_delay;
    private Double instant_flow_sp_delay_ratd;
}
