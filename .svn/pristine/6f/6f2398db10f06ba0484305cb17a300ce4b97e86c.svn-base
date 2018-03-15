package com.hgicreate.rno.xdr.backend.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Signalling.
 */
@Entity
@Table(name = "signalling")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "signalling")
public class Signalling implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "pdate", nullable = false)
    private LocalDate pdate;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private Long startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private Long endTime;

    @NotNull
    @Column(name = "interface_type", nullable = false)
    private String interfaceType;

    @Column(name = "cell")
    private Long cell;

    @Column(name = "imei")
    private Long imei;

    @Column(name = "imsi")
    private Long imsi;

    @Column(name = "app_type")
    private Integer appType;

    @Column(name = "app_status")
    private Integer appStatus;

    @Column(name = "protocol_type")
    private Integer protocolType;

    @Column(name = "app_sub_type")
    private Integer appSubType;

    @Column(name = "ul_data")
    private Integer ulData;

    @Column(name = "dl_data")
    private Integer dlData;

    @Column(name = "last_http_response_delay")
    private Double lastHttpResponseDelay;

    @Column(name = "procedure_type")
    private Integer procedureType;

    @Column(name = "procedure_status")
    private Integer procedureStatus;

    @Column(name = "cause")
    private Integer cause;

    @Column(name = "keyword")
    private Integer keyword;

    @Column(name = "target_cellid")
    private Long targetCellid;

    @Column(name = "csfb_indication")
    private Long csfbIndication;

    @Column(name = "req_cause_type")
    private Integer reqCauseType;

    @Column(name = "req_cause")
    private Integer reqCause;

    @Column(name = "failure_cause_type")
    private Integer failureCauseType;

    @Column(name = "failure_cause")
    private Integer failureCause;

    @Column(name = "error_cause_type")
    private Integer errorCauseType;

    @Column(name = "error_cause")
    private Integer errorCause;

    @Column(name = "ho_cancel_cause_type")
    private Integer hoCancelCauseType;

    @Column(name = "ho_cancel_cause")
    private Integer hoCancelCause;

    @Column(name = "row_count")
    private Integer rowCount;

    @Column(name = "serving_rsrp")
    private Double servingRsrp;

    @Column(name = "serving_rsrp_avg")
    private Double servingRsrpAvg;

    @Column(name = "serving_rsrp_std_dev")
    private Double servingRsrpStdDev;

    @Column(name = "serving_rsrq")
    private Double servingRsrq;

    @Column(name = "serving_rsrq_avg")
    private Double servingRsrqAvg;

    @Column(name = "serving_rsrq_std_dev")
    private Double servingRsrqStdDev;

    @Column(name = "aoa")
    private Double aoa;

    @Column(name = "aoa_avg")
    private Double aoaAvg;

    @Column(name = "aoa_std_dev")
    private Double aoaStdDev;

    @Column(name = "ta")
    private Double ta;

    @Column(name = "ta_avg")
    private Double taAvg;

    @Column(name = "ta_std_dev")
    private Double taStdDev;

    @Column(name = "ul_sinr")
    private Double ulSinr;

    @Column(name = "ul_sinr_avg")
    private Double ulSinrAvg;

    @Column(name = "ul_sinr_std_dev")
    private Double ulSinrStdDev;

    @Column(name = "enb_received_power")
    private Double enbReceivedPower;

    @Column(name = "enb_received_power_avg")
    private Double enbReceivedPowerAvg;

    @Column(name = "enb_received_power_std_dev")
    private Double enbReceivedPowerStdDev;

    @Column(name = "phr")
    private Double phr;

    @Column(name = "phr_avg")
    private Double phrAvg;

    @Column(name = "phr_std_dev")
    private Double phrStdDev;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public Signalling pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Signalling startTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Signalling endTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public Signalling interfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
        return this;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Long getCell() {
        return cell;
    }

    public Signalling cell(Long cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public Long getImei() {
        return imei;
    }

    public Signalling imei(Long imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public Signalling imsi(Long imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public Integer getAppType() {
        return appType;
    }

    public Signalling appType(Integer appType) {
        this.appType = appType;
        return this;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public Signalling appStatus(Integer appStatus) {
        this.appStatus = appStatus;
        return this;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public Signalling protocolType(Integer protocolType) {
        this.protocolType = protocolType;
        return this;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getAppSubType() {
        return appSubType;
    }

    public Signalling appSubType(Integer appSubType) {
        this.appSubType = appSubType;
        return this;
    }

    public void setAppSubType(Integer appSubType) {
        this.appSubType = appSubType;
    }

    public Integer getUlData() {
        return ulData;
    }

    public Signalling ulData(Integer ulData) {
        this.ulData = ulData;
        return this;
    }

    public void setUlData(Integer ulData) {
        this.ulData = ulData;
    }

    public Integer getDlData() {
        return dlData;
    }

    public Signalling dlData(Integer dlData) {
        this.dlData = dlData;
        return this;
    }

    public void setDlData(Integer dlData) {
        this.dlData = dlData;
    }

    public Double getLastHttpResponseDelay() {
        return lastHttpResponseDelay;
    }

    public Signalling lastHttpResponseDelay(Double lastHttpResponseDelay) {
        this.lastHttpResponseDelay = lastHttpResponseDelay;
        return this;
    }

    public void setLastHttpResponseDelay(Double lastHttpResponseDelay) {
        this.lastHttpResponseDelay = lastHttpResponseDelay;
    }

    public Integer getProcedureType() {
        return procedureType;
    }

    public Signalling procedureType(Integer procedureType) {
        this.procedureType = procedureType;
        return this;
    }

    public void setProcedureType(Integer procedureType) {
        this.procedureType = procedureType;
    }

    public Integer getProcedureStatus() {
        return procedureStatus;
    }

    public Signalling procedureStatus(Integer procedureStatus) {
        this.procedureStatus = procedureStatus;
        return this;
    }

    public void setProcedureStatus(Integer procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    public Integer getCause() {
        return cause;
    }

    public Signalling cause(Integer cause) {
        this.cause = cause;
        return this;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    public Integer getKeyword() {
        return keyword;
    }

    public Signalling keyword(Integer keyword) {
        this.keyword = keyword;
        return this;
    }

    public void setKeyword(Integer keyword) {
        this.keyword = keyword;
    }

    public Long getTargetCellid() {
        return targetCellid;
    }

    public Signalling targetCellid(Long targetCellid) {
        this.targetCellid = targetCellid;
        return this;
    }

    public void setTargetCellid(Long targetCellid) {
        this.targetCellid = targetCellid;
    }

    public Long getCsfbIndication() {
        return csfbIndication;
    }

    public Signalling csfbIndication(Long csfbIndication) {
        this.csfbIndication = csfbIndication;
        return this;
    }

    public void setCsfbIndication(Long csfbIndication) {
        this.csfbIndication = csfbIndication;
    }

    public Integer getReqCauseType() {
        return reqCauseType;
    }

    public Signalling reqCauseType(Integer reqCauseType) {
        this.reqCauseType = reqCauseType;
        return this;
    }

    public void setReqCauseType(Integer reqCauseType) {
        this.reqCauseType = reqCauseType;
    }

    public Integer getReqCause() {
        return reqCause;
    }

    public Signalling reqCause(Integer reqCause) {
        this.reqCause = reqCause;
        return this;
    }

    public void setReqCause(Integer reqCause) {
        this.reqCause = reqCause;
    }

    public Integer getFailureCauseType() {
        return failureCauseType;
    }

    public Signalling failureCauseType(Integer failureCauseType) {
        this.failureCauseType = failureCauseType;
        return this;
    }

    public void setFailureCauseType(Integer failureCauseType) {
        this.failureCauseType = failureCauseType;
    }

    public Integer getFailureCause() {
        return failureCause;
    }

    public Signalling failureCause(Integer failureCause) {
        this.failureCause = failureCause;
        return this;
    }

    public void setFailureCause(Integer failureCause) {
        this.failureCause = failureCause;
    }

    public Integer getErrorCauseType() {
        return errorCauseType;
    }

    public Signalling errorCauseType(Integer errorCauseType) {
        this.errorCauseType = errorCauseType;
        return this;
    }

    public void setErrorCauseType(Integer errorCauseType) {
        this.errorCauseType = errorCauseType;
    }

    public Integer getErrorCause() {
        return errorCause;
    }

    public Signalling errorCause(Integer errorCause) {
        this.errorCause = errorCause;
        return this;
    }

    public void setErrorCause(Integer errorCause) {
        this.errorCause = errorCause;
    }

    public Integer getHoCancelCauseType() {
        return hoCancelCauseType;
    }

    public Signalling hoCancelCauseType(Integer hoCancelCauseType) {
        this.hoCancelCauseType = hoCancelCauseType;
        return this;
    }

    public void setHoCancelCauseType(Integer hoCancelCauseType) {
        this.hoCancelCauseType = hoCancelCauseType;
    }

    public Integer getHoCancelCause() {
        return hoCancelCause;
    }

    public Signalling hoCancelCause(Integer hoCancelCause) {
        this.hoCancelCause = hoCancelCause;
        return this;
    }

    public void setHoCancelCause(Integer hoCancelCause) {
        this.hoCancelCause = hoCancelCause;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public Signalling rowCount(Integer rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Double getServingRsrp() {
        return servingRsrp;
    }

    public Signalling servingRsrp(Double servingRsrp) {
        this.servingRsrp = servingRsrp;
        return this;
    }

    public void setServingRsrp(Double servingRsrp) {
        this.servingRsrp = servingRsrp;
    }

    public Double getServingRsrpAvg() {
        return servingRsrpAvg;
    }

    public Signalling servingRsrpAvg(Double servingRsrpAvg) {
        this.servingRsrpAvg = servingRsrpAvg;
        return this;
    }

    public void setServingRsrpAvg(Double servingRsrpAvg) {
        this.servingRsrpAvg = servingRsrpAvg;
    }

    public Double getServingRsrpStdDev() {
        return servingRsrpStdDev;
    }

    public Signalling servingRsrpStdDev(Double servingRsrpStdDev) {
        this.servingRsrpStdDev = servingRsrpStdDev;
        return this;
    }

    public void setServingRsrpStdDev(Double servingRsrpStdDev) {
        this.servingRsrpStdDev = servingRsrpStdDev;
    }

    public Double getServingRsrq() {
        return servingRsrq;
    }

    public Signalling servingRsrq(Double servingRsrq) {
        this.servingRsrq = servingRsrq;
        return this;
    }

    public void setServingRsrq(Double servingRsrq) {
        this.servingRsrq = servingRsrq;
    }

    public Double getServingRsrqAvg() {
        return servingRsrqAvg;
    }

    public Signalling servingRsrqAvg(Double servingRsrqAvg) {
        this.servingRsrqAvg = servingRsrqAvg;
        return this;
    }

    public void setServingRsrqAvg(Double servingRsrqAvg) {
        this.servingRsrqAvg = servingRsrqAvg;
    }

    public Double getServingRsrqStdDev() {
        return servingRsrqStdDev;
    }

    public Signalling servingRsrqStdDev(Double servingRsrqStdDev) {
        this.servingRsrqStdDev = servingRsrqStdDev;
        return this;
    }

    public void setServingRsrqStdDev(Double servingRsrqStdDev) {
        this.servingRsrqStdDev = servingRsrqStdDev;
    }

    public Double getAoa() {
        return aoa;
    }

    public Signalling aoa(Double aoa) {
        this.aoa = aoa;
        return this;
    }

    public void setAoa(Double aoa) {
        this.aoa = aoa;
    }

    public Double getAoaAvg() {
        return aoaAvg;
    }

    public Signalling aoaAvg(Double aoaAvg) {
        this.aoaAvg = aoaAvg;
        return this;
    }

    public void setAoaAvg(Double aoaAvg) {
        this.aoaAvg = aoaAvg;
    }

    public Double getAoaStdDev() {
        return aoaStdDev;
    }

    public Signalling aoaStdDev(Double aoaStdDev) {
        this.aoaStdDev = aoaStdDev;
        return this;
    }

    public void setAoaStdDev(Double aoaStdDev) {
        this.aoaStdDev = aoaStdDev;
    }

    public Double getTa() {
        return ta;
    }

    public Signalling ta(Double ta) {
        this.ta = ta;
        return this;
    }

    public void setTa(Double ta) {
        this.ta = ta;
    }

    public Double getTaAvg() {
        return taAvg;
    }

    public Signalling taAvg(Double taAvg) {
        this.taAvg = taAvg;
        return this;
    }

    public void setTaAvg(Double taAvg) {
        this.taAvg = taAvg;
    }

    public Double getTaStdDev() {
        return taStdDev;
    }

    public Signalling taStdDev(Double taStdDev) {
        this.taStdDev = taStdDev;
        return this;
    }

    public void setTaStdDev(Double taStdDev) {
        this.taStdDev = taStdDev;
    }

    public Double getUlSinr() {
        return ulSinr;
    }

    public Signalling ulSinr(Double ulSinr) {
        this.ulSinr = ulSinr;
        return this;
    }

    public void setUlSinr(Double ulSinr) {
        this.ulSinr = ulSinr;
    }

    public Double getUlSinrAvg() {
        return ulSinrAvg;
    }

    public Signalling ulSinrAvg(Double ulSinrAvg) {
        this.ulSinrAvg = ulSinrAvg;
        return this;
    }

    public void setUlSinrAvg(Double ulSinrAvg) {
        this.ulSinrAvg = ulSinrAvg;
    }

    public Double getUlSinrStdDev() {
        return ulSinrStdDev;
    }

    public Signalling ulSinrStdDev(Double ulSinrStdDev) {
        this.ulSinrStdDev = ulSinrStdDev;
        return this;
    }

    public void setUlSinrStdDev(Double ulSinrStdDev) {
        this.ulSinrStdDev = ulSinrStdDev;
    }

    public Double getEnbReceivedPower() {
        return enbReceivedPower;
    }

    public Signalling enbReceivedPower(Double enbReceivedPower) {
        this.enbReceivedPower = enbReceivedPower;
        return this;
    }

    public void setEnbReceivedPower(Double enbReceivedPower) {
        this.enbReceivedPower = enbReceivedPower;
    }

    public Double getEnbReceivedPowerAvg() {
        return enbReceivedPowerAvg;
    }

    public Signalling enbReceivedPowerAvg(Double enbReceivedPowerAvg) {
        this.enbReceivedPowerAvg = enbReceivedPowerAvg;
        return this;
    }

    public void setEnbReceivedPowerAvg(Double enbReceivedPowerAvg) {
        this.enbReceivedPowerAvg = enbReceivedPowerAvg;
    }

    public Double getEnbReceivedPowerStdDev() {
        return enbReceivedPowerStdDev;
    }

    public Signalling enbReceivedPowerStdDev(Double enbReceivedPowerStdDev) {
        this.enbReceivedPowerStdDev = enbReceivedPowerStdDev;
        return this;
    }

    public void setEnbReceivedPowerStdDev(Double enbReceivedPowerStdDev) {
        this.enbReceivedPowerStdDev = enbReceivedPowerStdDev;
    }

    public Double getPhr() {
        return phr;
    }

    public Signalling phr(Double phr) {
        this.phr = phr;
        return this;
    }

    public void setPhr(Double phr) {
        this.phr = phr;
    }

    public Double getPhrAvg() {
        return phrAvg;
    }

    public Signalling phrAvg(Double phrAvg) {
        this.phrAvg = phrAvg;
        return this;
    }

    public void setPhrAvg(Double phrAvg) {
        this.phrAvg = phrAvg;
    }

    public Double getPhrStdDev() {
        return phrStdDev;
    }

    public Signalling phrStdDev(Double phrStdDev) {
        this.phrStdDev = phrStdDev;
        return this;
    }

    public void setPhrStdDev(Double phrStdDev) {
        this.phrStdDev = phrStdDev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Signalling signalling = (Signalling) o;
        if (signalling.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), signalling.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Signalling{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", interfaceType='" + getInterfaceType() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", appType='" + getAppType() + "'" +
            ", appStatus='" + getAppStatus() + "'" +
            ", protocolType='" + getProtocolType() + "'" +
            ", appSubType='" + getAppSubType() + "'" +
            ", ulData='" + getUlData() + "'" +
            ", dlData='" + getDlData() + "'" +
            ", lastHttpResponseDelay='" + getLastHttpResponseDelay() + "'" +
            ", procedureType='" + getProcedureType() + "'" +
            ", procedureStatus='" + getProcedureStatus() + "'" +
            ", cause='" + getCause() + "'" +
            ", keyword='" + getKeyword() + "'" +
            ", targetCellid='" + getTargetCellid() + "'" +
            ", csfbIndication='" + getCsfbIndication() + "'" +
            ", reqCauseType='" + getReqCauseType() + "'" +
            ", reqCause='" + getReqCause() + "'" +
            ", failureCauseType='" + getFailureCauseType() + "'" +
            ", failureCause='" + getFailureCause() + "'" +
            ", errorCauseType='" + getErrorCauseType() + "'" +
            ", errorCause='" + getErrorCause() + "'" +
            ", hoCancelCauseType='" + getHoCancelCauseType() + "'" +
            ", hoCancelCause='" + getHoCancelCause() + "'" +
            ", rowCount='" + getRowCount() + "'" +
            ", servingRsrp='" + getServingRsrp() + "'" +
            ", servingRsrpAvg='" + getServingRsrpAvg() + "'" +
            ", servingRsrpStdDev='" + getServingRsrpStdDev() + "'" +
            ", servingRsrq='" + getServingRsrq() + "'" +
            ", servingRsrqAvg='" + getServingRsrqAvg() + "'" +
            ", servingRsrqStdDev='" + getServingRsrqStdDev() + "'" +
            ", aoa='" + getAoa() + "'" +
            ", aoaAvg='" + getAoaAvg() + "'" +
            ", aoaStdDev='" + getAoaStdDev() + "'" +
            ", ta='" + getTa() + "'" +
            ", taAvg='" + getTaAvg() + "'" +
            ", taStdDev='" + getTaStdDev() + "'" +
            ", ulSinr='" + getUlSinr() + "'" +
            ", ulSinrAvg='" + getUlSinrAvg() + "'" +
            ", ulSinrStdDev='" + getUlSinrStdDev() + "'" +
            ", enbReceivedPower='" + getEnbReceivedPower() + "'" +
            ", enbReceivedPowerAvg='" + getEnbReceivedPowerAvg() + "'" +
            ", enbReceivedPowerStdDev='" + getEnbReceivedPowerStdDev() + "'" +
            ", phr='" + getPhr() + "'" +
            ", phrAvg='" + getPhrAvg() + "'" +
            ", phrStdDev='" + getPhrStdDev() + "'" +
            "}";
    }
}
