package com.hgicreate.rno.domain.indicator.uu;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "Indicator_uuCellDate")
    @Data
    @Entity
    @Table(name = "INDICATOR_UUCELLDATE")
public class UuCellDate {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String rrc_connect_success_rat;
    private Integer rrc_connect_request;
    private Integer rrc_connect_success;
    private String sm_activate_success_rat;
    private Integer sm_activate_request;
    private Integer sm_activate_success;
    private String rrc_reconfig_success_rat;
    private Integer rrc_reconfig_request;
    private Integer rrc_reconfig_success;
    private String rrc_reconstruction_success_rat;
    private Integer rrc_reconstruction_request;
    private Integer rrc_reconstruction_success;
    private String rrc_release_success_rat;
    private Integer rrc_release_request;
    private Integer rrc_release_success;
    private String cell_inter_success_rat;
    private Integer cell_inter_request;
    private Integer cell_inter_success;
    private String station_inter_success_rat;
    private Integer station_inter_request;
    private Integer station_inter_success;
    private String station_intra_success_rat;
    private Integer station_intra_request;
    private Integer station_intra_success;
    private String rat_in_success_rat;
    private Integer rat_in_request;
    private Integer rat_in_success;
    private String rat_out_success_rat;
    private Integer rat_out_request;
    private Integer rat_out_success;
    private String ps_paging_success_rat;
    private Integer ps_paging_request;
    private Integer ps_paging_success;
    private String cs_paging_success_rat;
    private Integer cs_paging_request;
    private Integer cs_pag_success;
    private String otherevent_success_rat;
    private Integer otherevent_request;
    private Integer otherevent_success;

    private Long date;
    private Long cellid;

}
