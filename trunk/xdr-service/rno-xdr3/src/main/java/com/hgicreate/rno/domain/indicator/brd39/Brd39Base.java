package com.hgicreate.rno.domain.indicator.brd39;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hadoop on 2016/12/23.
 */
@Data
public class Brd39Base {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Double attach_success_rat;
    private Integer attach_request;
    private Integer attach_success;
    private Double service_success_rat;
    private Integer service_request;
    private Integer service_request_success;
    private Double contextdef_setup_success_rat;
    private Integer contextdef_activate_request;
    private Integer contextdef_activate_success;
    private Double pdn_request_success_rat;
    private Integer pdn_request;
    private Integer pdn_request_success;
    private Double tau_success_rat;
    private Integer tau_request;
    private Integer tau_success;
    private Double x2_Integerer_success_rat;
    private Integer x2_Integerer_request;
    private Integer x2_Integerer_success;
    private Double s1_Integerer_success_rat;
    private Integer s1_Integerer_request;
    private Integer s1_Integerer_success;
}
