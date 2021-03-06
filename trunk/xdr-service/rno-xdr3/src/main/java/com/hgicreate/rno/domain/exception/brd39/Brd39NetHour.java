package com.hgicreate.rno.domain.exception.brd39;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2016/12/23.
 */
//@Document(collection = "Exception_brd39NetHour")
    @Data
    @Entity
    @Table(name = "EXCEPTION_BRD39NETHOUR")
public class Brd39NetHour  {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String attach_fault_rat;
    private int attach_request;
    private int attach_fault;
    private String service_fault_rat;
    private int service_request;
    private int service_fault;
    private String csfb_fault_rat;
    private int csfb_request;
    private int csfb_fault;
    private String context_activate_fault_rat;
    private int contextdef_activate_request;
    private int context_activate_fault;
    private String pdn_request_fault_rat;
    private int pdn_request;
    private int pdn_request_fault;
    private String tau_fault_rat;
    private int tau_request;
    private int tau_fault;
    private String x2_inter_fault_rat;
    private int x2_inter_request;
    private int x2_inter_fault;
    private String s1_inter_fault_rat;
    private int s1_inter_request;
    private int s1_inter_fault;

    private long date;
    private long hour;

}
