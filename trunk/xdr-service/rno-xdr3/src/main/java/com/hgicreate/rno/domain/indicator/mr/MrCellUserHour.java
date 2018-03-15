package com.hgicreate.rno.domain.indicator.mr;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hadoop on 2016/12/23.
 */
@Data
public class MrCellUserHour  {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private Double rsrp_avg;
    private Double rsrq_avg;
    private Double ulsinr_avg;
    private Double phr_avg;
    private Double erp_avg;
    private Double ta_avg;
    private Double overlap_avg;
}
