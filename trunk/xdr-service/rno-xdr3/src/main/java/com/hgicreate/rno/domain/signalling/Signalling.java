package com.hgicreate.rno.domain.signalling;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 2017/2/24.
 */
//@Document(collection = "uu_mm_ue")
    @Data
    @Entity
    @Table(name = "UU_MM_UE")
public class Signalling {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Integer interf;
    private Long imsi;
    private Long imei;
    private Long cellid;
    private Long starttime;
    private Long endtime;
    private Integer app_type;
    private Integer app_status;
    private Integer protocol_type;
    private Integer app_sub_type;
    private Integer ul_data;
    private Integer dl_data;
    private Double last_http_response_delay;
    private Integer procedure_type;
    private Integer procedure_status;
    private Integer cause;
    private Integer keyword;
    private Long targetcellid;
    private Long csfbindication;
    private Integer reqcausetype;
    private Integer reqcause;
    private Integer failurecausetype;
    private Integer failurecause;
    private Integer errorcausetype;
    private Integer errorcause;
    private Integer hocancelcausetype;
    private Integer hocancelcause;
    private Integer rowcount;
    private Double servingrsrp;
    private Double servingrsrp_avg;
    private Double servingrsrp_stddev;
    private Double servingrsrq;
    private Double servingrsrq_avg;
    private Double servingrsrq_stddev;
    private Double aoa;
    private Double aoa_avg;
    private Double aoa_stddev;
    private Double ta;
    private Double ta_avg;
    private Double ta_stddev;
    private Double ulsinr;
    private Double ulsinr_avg;
    private Double ulsinr_stddev;
    private Double enbreceivedpower;
    private Double enbreceivedpower_avg;
    private Double enbreceivedpower_stddev;
    private Double phr;
    private Double phr_avg;
    private Double phr_stddev;
}
