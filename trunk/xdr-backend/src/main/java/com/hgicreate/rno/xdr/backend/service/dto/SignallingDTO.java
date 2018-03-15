package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Signalling entity.
 */
public class SignallingDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    @NotNull
    private Long startTime;

    @NotNull
    private Long endTime;

    @NotNull
    private String interfaceType;

    private Long cell;

    private Long imei;

    private Long imsi;

    private Integer appType;

    private Integer appStatus;

    private Integer protocolType;

    private Integer appSubType;

    private Integer ulData;

    private Integer dlData;

    private Double lastHttpResponseDelay;

    private Integer procedureType;

    private Integer procedureStatus;

    private Integer cause;

    private Integer keyword;

    private Long targetCellid;

    private Long csfbIndication;

    private Integer reqCauseType;

    private Integer reqCause;

    private Integer failureCauseType;

    private Integer failureCause;

    private Integer errorCauseType;

    private Integer errorCause;

    private Integer hoCancelCauseType;

    private Integer hoCancelCause;

    private Integer rowCount;

    private Double servingRsrp;

    private Double servingRsrpAvg;

    private Double servingRsrpStdDev;

    private Double servingRsrq;

    private Double servingRsrqAvg;

    private Double servingRsrqStdDev;

    private Double aoa;

    private Double aoaAvg;

    private Double aoaStdDev;

    private Double ta;

    private Double taAvg;

    private Double taStdDev;

    private Double ulSinr;

    private Double ulSinrAvg;

    private Double ulSinrStdDev;

    private Double enbReceivedPower;

    private Double enbReceivedPowerAvg;

    private Double enbReceivedPowerStdDev;

    private Double phr;

    private Double phrAvg;

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

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Long getCell() {
        return cell;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getAppSubType() {
        return appSubType;
    }

    public void setAppSubType(Integer appSubType) {
        this.appSubType = appSubType;
    }

    public Integer getUlData() {
        return ulData;
    }

    public void setUlData(Integer ulData) {
        this.ulData = ulData;
    }

    public Integer getDlData() {
        return dlData;
    }

    public void setDlData(Integer dlData) {
        this.dlData = dlData;
    }

    public Double getLastHttpResponseDelay() {
        return lastHttpResponseDelay;
    }

    public void setLastHttpResponseDelay(Double lastHttpResponseDelay) {
        this.lastHttpResponseDelay = lastHttpResponseDelay;
    }

    public Integer getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(Integer procedureType) {
        this.procedureType = procedureType;
    }

    public Integer getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(Integer procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    public Integer getCause() {
        return cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    public Integer getKeyword() {
        return keyword;
    }

    public void setKeyword(Integer keyword) {
        this.keyword = keyword;
    }

    public Long getTargetCellid() {
        return targetCellid;
    }

    public void setTargetCellid(Long targetCellid) {
        this.targetCellid = targetCellid;
    }

    public Long getCsfbIndication() {
        return csfbIndication;
    }

    public void setCsfbIndication(Long csfbIndication) {
        this.csfbIndication = csfbIndication;
    }

    public Integer getReqCauseType() {
        return reqCauseType;
    }

    public void setReqCauseType(Integer reqCauseType) {
        this.reqCauseType = reqCauseType;
    }

    public Integer getReqCause() {
        return reqCause;
    }

    public void setReqCause(Integer reqCause) {
        this.reqCause = reqCause;
    }

    public Integer getFailureCauseType() {
        return failureCauseType;
    }

    public void setFailureCauseType(Integer failureCauseType) {
        this.failureCauseType = failureCauseType;
    }

    public Integer getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(Integer failureCause) {
        this.failureCause = failureCause;
    }

    public Integer getErrorCauseType() {
        return errorCauseType;
    }

    public void setErrorCauseType(Integer errorCauseType) {
        this.errorCauseType = errorCauseType;
    }

    public Integer getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(Integer errorCause) {
        this.errorCause = errorCause;
    }

    public Integer getHoCancelCauseType() {
        return hoCancelCauseType;
    }

    public void setHoCancelCauseType(Integer hoCancelCauseType) {
        this.hoCancelCauseType = hoCancelCauseType;
    }

    public Integer getHoCancelCause() {
        return hoCancelCause;
    }

    public void setHoCancelCause(Integer hoCancelCause) {
        this.hoCancelCause = hoCancelCause;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Double getServingRsrp() {
        return servingRsrp;
    }

    public void setServingRsrp(Double servingRsrp) {
        this.servingRsrp = servingRsrp;
    }

    public Double getServingRsrpAvg() {
        return servingRsrpAvg;
    }

    public void setServingRsrpAvg(Double servingRsrpAvg) {
        this.servingRsrpAvg = servingRsrpAvg;
    }

    public Double getServingRsrpStdDev() {
        return servingRsrpStdDev;
    }

    public void setServingRsrpStdDev(Double servingRsrpStdDev) {
        this.servingRsrpStdDev = servingRsrpStdDev;
    }

    public Double getServingRsrq() {
        return servingRsrq;
    }

    public void setServingRsrq(Double servingRsrq) {
        this.servingRsrq = servingRsrq;
    }

    public Double getServingRsrqAvg() {
        return servingRsrqAvg;
    }

    public void setServingRsrqAvg(Double servingRsrqAvg) {
        this.servingRsrqAvg = servingRsrqAvg;
    }

    public Double getServingRsrqStdDev() {
        return servingRsrqStdDev;
    }

    public void setServingRsrqStdDev(Double servingRsrqStdDev) {
        this.servingRsrqStdDev = servingRsrqStdDev;
    }

    public Double getAoa() {
        return aoa;
    }

    public void setAoa(Double aoa) {
        this.aoa = aoa;
    }

    public Double getAoaAvg() {
        return aoaAvg;
    }

    public void setAoaAvg(Double aoaAvg) {
        this.aoaAvg = aoaAvg;
    }

    public Double getAoaStdDev() {
        return aoaStdDev;
    }

    public void setAoaStdDev(Double aoaStdDev) {
        this.aoaStdDev = aoaStdDev;
    }

    public Double getTa() {
        return ta;
    }

    public void setTa(Double ta) {
        this.ta = ta;
    }

    public Double getTaAvg() {
        return taAvg;
    }

    public void setTaAvg(Double taAvg) {
        this.taAvg = taAvg;
    }

    public Double getTaStdDev() {
        return taStdDev;
    }

    public void setTaStdDev(Double taStdDev) {
        this.taStdDev = taStdDev;
    }

    public Double getUlSinr() {
        return ulSinr;
    }

    public void setUlSinr(Double ulSinr) {
        this.ulSinr = ulSinr;
    }

    public Double getUlSinrAvg() {
        return ulSinrAvg;
    }

    public void setUlSinrAvg(Double ulSinrAvg) {
        this.ulSinrAvg = ulSinrAvg;
    }

    public Double getUlSinrStdDev() {
        return ulSinrStdDev;
    }

    public void setUlSinrStdDev(Double ulSinrStdDev) {
        this.ulSinrStdDev = ulSinrStdDev;
    }

    public Double getEnbReceivedPower() {
        return enbReceivedPower;
    }

    public void setEnbReceivedPower(Double enbReceivedPower) {
        this.enbReceivedPower = enbReceivedPower;
    }

    public Double getEnbReceivedPowerAvg() {
        return enbReceivedPowerAvg;
    }

    public void setEnbReceivedPowerAvg(Double enbReceivedPowerAvg) {
        this.enbReceivedPowerAvg = enbReceivedPowerAvg;
    }

    public Double getEnbReceivedPowerStdDev() {
        return enbReceivedPowerStdDev;
    }

    public void setEnbReceivedPowerStdDev(Double enbReceivedPowerStdDev) {
        this.enbReceivedPowerStdDev = enbReceivedPowerStdDev;
    }

    public Double getPhr() {
        return phr;
    }

    public void setPhr(Double phr) {
        this.phr = phr;
    }

    public Double getPhrAvg() {
        return phrAvg;
    }

    public void setPhrAvg(Double phrAvg) {
        this.phrAvg = phrAvg;
    }

    public Double getPhrStdDev() {
        return phrStdDev;
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

        SignallingDTO signallingDTO = (SignallingDTO) o;
        if(signallingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), signallingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SignallingDTO{" +
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
