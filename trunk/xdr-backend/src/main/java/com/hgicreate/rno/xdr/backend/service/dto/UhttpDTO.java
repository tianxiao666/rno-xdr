package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Uhttp entity.
 */
public class UhttpDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Integer phour;

    private String cell;

    private String imei;

    private String imsi;

    private Long flowSum;

    private Double rateFlowRate;

    private Double rateFlowSuccessRate;

    private Double rateFlowSuccessDRate;

    private Long rateFlow;

    private Long rateFlowRequest;

    private Long rateFlowBpSpeed;

    private Double rateFlowBpSpeedDRate;

    private Long rateFlowSpDelay;

    private Double rateFlowSpDelayDRate;

    private Double delayFlowRate;

    private Double delayFlowSuccessRate;

    private Double delayFlowSuccessDRate;

    private Long delayFlow;

    private Long delayFlowRequest;

    private Long delayFlowBpSpeed;

    private Double delayFlowBpSpeedDRate;

    private Long delayFlowSpDelay;

    private Double delayFlowSpDelayDRate;

    private Double refreshFlowRate;

    private Double refreshFlowSuccessRate;

    private Double refreshFlowSuccessDRate;

    private Long refreshFlow;

    private Long refreshFlowRequest;

    private Long refreshFlowBpSpeed;

    private Double refreshFlowBpSpeedDRate;

    private Long refreshFlowSpDelay;

    private Double refreshFlowSpDelayDRate;

    private Double instantFlowRate;

    private Double instantFlowSuccessRate;

    private Double instantFlowSuccessDRate;

    private Long instantFlow;

    private Long instantFlowRequest;

    private Long instantFlowBpSpeed;

    private Double instantFlowBpSpeedDRate;

    private Long instantFlowSpDelay;

    private Double instantFlowSpDelayDRate;

    private Long tcpCreactlinkDelay;

    private Long tcpCreactlinkCount;

    private Long tcpCreactlinkResponseDelay;

    private Long tcpCreactlinkResponseCount;

    private Long tcpCreactlinkConfirmDelay;

    private Long tcpCreactlinkConfirmCount;

    private Long bpFlow;

    private Long bpDelay;

    private Long serviceRequest;

    private Long serviceSuccess;

    private Long tencentVideoServiceRequest;

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

    public Integer getPhour() {
        return phour;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getFlowSum() {
        return flowSum;
    }

    public void setFlowSum(Long flowSum) {
        this.flowSum = flowSum;
    }

    public Double getRateFlowRate() {
        return rateFlowRate;
    }

    public void setRateFlowRate(Double rateFlowRate) {
        this.rateFlowRate = rateFlowRate;
    }

    public Double getRateFlowSuccessRate() {
        return rateFlowSuccessRate;
    }

    public void setRateFlowSuccessRate(Double rateFlowSuccessRate) {
        this.rateFlowSuccessRate = rateFlowSuccessRate;
    }

    public Double getRateFlowSuccessDRate() {
        return rateFlowSuccessDRate;
    }

    public void setRateFlowSuccessDRate(Double rateFlowSuccessDRate) {
        this.rateFlowSuccessDRate = rateFlowSuccessDRate;
    }

    public Long getRateFlow() {
        return rateFlow;
    }

    public void setRateFlow(Long rateFlow) {
        this.rateFlow = rateFlow;
    }

    public Long getRateFlowRequest() {
        return rateFlowRequest;
    }

    public void setRateFlowRequest(Long rateFlowRequest) {
        this.rateFlowRequest = rateFlowRequest;
    }

    public Long getRateFlowBpSpeed() {
        return rateFlowBpSpeed;
    }

    public void setRateFlowBpSpeed(Long rateFlowBpSpeed) {
        this.rateFlowBpSpeed = rateFlowBpSpeed;
    }

    public Double getRateFlowBpSpeedDRate() {
        return rateFlowBpSpeedDRate;
    }

    public void setRateFlowBpSpeedDRate(Double rateFlowBpSpeedDRate) {
        this.rateFlowBpSpeedDRate = rateFlowBpSpeedDRate;
    }

    public Long getRateFlowSpDelay() {
        return rateFlowSpDelay;
    }

    public void setRateFlowSpDelay(Long rateFlowSpDelay) {
        this.rateFlowSpDelay = rateFlowSpDelay;
    }

    public Double getRateFlowSpDelayDRate() {
        return rateFlowSpDelayDRate;
    }

    public void setRateFlowSpDelayDRate(Double rateFlowSpDelayDRate) {
        this.rateFlowSpDelayDRate = rateFlowSpDelayDRate;
    }

    public Double getDelayFlowRate() {
        return delayFlowRate;
    }

    public void setDelayFlowRate(Double delayFlowRate) {
        this.delayFlowRate = delayFlowRate;
    }

    public Double getDelayFlowSuccessRate() {
        return delayFlowSuccessRate;
    }

    public void setDelayFlowSuccessRate(Double delayFlowSuccessRate) {
        this.delayFlowSuccessRate = delayFlowSuccessRate;
    }

    public Double getDelayFlowSuccessDRate() {
        return delayFlowSuccessDRate;
    }

    public void setDelayFlowSuccessDRate(Double delayFlowSuccessDRate) {
        this.delayFlowSuccessDRate = delayFlowSuccessDRate;
    }

    public Long getDelayFlow() {
        return delayFlow;
    }

    public void setDelayFlow(Long delayFlow) {
        this.delayFlow = delayFlow;
    }

    public Long getDelayFlowRequest() {
        return delayFlowRequest;
    }

    public void setDelayFlowRequest(Long delayFlowRequest) {
        this.delayFlowRequest = delayFlowRequest;
    }

    public Long getDelayFlowBpSpeed() {
        return delayFlowBpSpeed;
    }

    public void setDelayFlowBpSpeed(Long delayFlowBpSpeed) {
        this.delayFlowBpSpeed = delayFlowBpSpeed;
    }

    public Double getDelayFlowBpSpeedDRate() {
        return delayFlowBpSpeedDRate;
    }

    public void setDelayFlowBpSpeedDRate(Double delayFlowBpSpeedDRate) {
        this.delayFlowBpSpeedDRate = delayFlowBpSpeedDRate;
    }

    public Long getDelayFlowSpDelay() {
        return delayFlowSpDelay;
    }

    public void setDelayFlowSpDelay(Long delayFlowSpDelay) {
        this.delayFlowSpDelay = delayFlowSpDelay;
    }

    public Double getDelayFlowSpDelayDRate() {
        return delayFlowSpDelayDRate;
    }

    public void setDelayFlowSpDelayDRate(Double delayFlowSpDelayDRate) {
        this.delayFlowSpDelayDRate = delayFlowSpDelayDRate;
    }

    public Double getRefreshFlowRate() {
        return refreshFlowRate;
    }

    public void setRefreshFlowRate(Double refreshFlowRate) {
        this.refreshFlowRate = refreshFlowRate;
    }

    public Double getRefreshFlowSuccessRate() {
        return refreshFlowSuccessRate;
    }

    public void setRefreshFlowSuccessRate(Double refreshFlowSuccessRate) {
        this.refreshFlowSuccessRate = refreshFlowSuccessRate;
    }

    public Double getRefreshFlowSuccessDRate() {
        return refreshFlowSuccessDRate;
    }

    public void setRefreshFlowSuccessDRate(Double refreshFlowSuccessDRate) {
        this.refreshFlowSuccessDRate = refreshFlowSuccessDRate;
    }

    public Long getRefreshFlow() {
        return refreshFlow;
    }

    public void setRefreshFlow(Long refreshFlow) {
        this.refreshFlow = refreshFlow;
    }

    public Long getRefreshFlowRequest() {
        return refreshFlowRequest;
    }

    public void setRefreshFlowRequest(Long refreshFlowRequest) {
        this.refreshFlowRequest = refreshFlowRequest;
    }

    public Long getRefreshFlowBpSpeed() {
        return refreshFlowBpSpeed;
    }

    public void setRefreshFlowBpSpeed(Long refreshFlowBpSpeed) {
        this.refreshFlowBpSpeed = refreshFlowBpSpeed;
    }

    public Double getRefreshFlowBpSpeedDRate() {
        return refreshFlowBpSpeedDRate;
    }

    public void setRefreshFlowBpSpeedDRate(Double refreshFlowBpSpeedDRate) {
        this.refreshFlowBpSpeedDRate = refreshFlowBpSpeedDRate;
    }

    public Long getRefreshFlowSpDelay() {
        return refreshFlowSpDelay;
    }

    public void setRefreshFlowSpDelay(Long refreshFlowSpDelay) {
        this.refreshFlowSpDelay = refreshFlowSpDelay;
    }

    public Double getRefreshFlowSpDelayDRate() {
        return refreshFlowSpDelayDRate;
    }

    public void setRefreshFlowSpDelayDRate(Double refreshFlowSpDelayDRate) {
        this.refreshFlowSpDelayDRate = refreshFlowSpDelayDRate;
    }

    public Double getInstantFlowRate() {
        return instantFlowRate;
    }

    public void setInstantFlowRate(Double instantFlowRate) {
        this.instantFlowRate = instantFlowRate;
    }

    public Double getInstantFlowSuccessRate() {
        return instantFlowSuccessRate;
    }

    public void setInstantFlowSuccessRate(Double instantFlowSuccessRate) {
        this.instantFlowSuccessRate = instantFlowSuccessRate;
    }

    public Double getInstantFlowSuccessDRate() {
        return instantFlowSuccessDRate;
    }

    public void setInstantFlowSuccessDRate(Double instantFlowSuccessDRate) {
        this.instantFlowSuccessDRate = instantFlowSuccessDRate;
    }

    public Long getInstantFlow() {
        return instantFlow;
    }

    public void setInstantFlow(Long instantFlow) {
        this.instantFlow = instantFlow;
    }

    public Long getInstantFlowRequest() {
        return instantFlowRequest;
    }

    public void setInstantFlowRequest(Long instantFlowRequest) {
        this.instantFlowRequest = instantFlowRequest;
    }

    public Long getInstantFlowBpSpeed() {
        return instantFlowBpSpeed;
    }

    public void setInstantFlowBpSpeed(Long instantFlowBpSpeed) {
        this.instantFlowBpSpeed = instantFlowBpSpeed;
    }

    public Double getInstantFlowBpSpeedDRate() {
        return instantFlowBpSpeedDRate;
    }

    public void setInstantFlowBpSpeedDRate(Double instantFlowBpSpeedDRate) {
        this.instantFlowBpSpeedDRate = instantFlowBpSpeedDRate;
    }

    public Long getInstantFlowSpDelay() {
        return instantFlowSpDelay;
    }

    public void setInstantFlowSpDelay(Long instantFlowSpDelay) {
        this.instantFlowSpDelay = instantFlowSpDelay;
    }

    public Double getInstantFlowSpDelayDRate() {
        return instantFlowSpDelayDRate;
    }

    public void setInstantFlowSpDelayDRate(Double instantFlowSpDelayDRate) {
        this.instantFlowSpDelayDRate = instantFlowSpDelayDRate;
    }

    public Long getTcpCreactlinkDelay() {
        return tcpCreactlinkDelay;
    }

    public void setTcpCreactlinkDelay(Long tcpCreactlinkDelay) {
        this.tcpCreactlinkDelay = tcpCreactlinkDelay;
    }

    public Long getTcpCreactlinkCount() {
        return tcpCreactlinkCount;
    }

    public void setTcpCreactlinkCount(Long tcpCreactlinkCount) {
        this.tcpCreactlinkCount = tcpCreactlinkCount;
    }

    public Long getTcpCreactlinkResponseDelay() {
        return tcpCreactlinkResponseDelay;
    }

    public void setTcpCreactlinkResponseDelay(Long tcpCreactlinkResponseDelay) {
        this.tcpCreactlinkResponseDelay = tcpCreactlinkResponseDelay;
    }

    public Long getTcpCreactlinkResponseCount() {
        return tcpCreactlinkResponseCount;
    }

    public void setTcpCreactlinkResponseCount(Long tcpCreactlinkResponseCount) {
        this.tcpCreactlinkResponseCount = tcpCreactlinkResponseCount;
    }

    public Long getTcpCreactlinkConfirmDelay() {
        return tcpCreactlinkConfirmDelay;
    }

    public void setTcpCreactlinkConfirmDelay(Long tcpCreactlinkConfirmDelay) {
        this.tcpCreactlinkConfirmDelay = tcpCreactlinkConfirmDelay;
    }

    public Long getTcpCreactlinkConfirmCount() {
        return tcpCreactlinkConfirmCount;
    }

    public void setTcpCreactlinkConfirmCount(Long tcpCreactlinkConfirmCount) {
        this.tcpCreactlinkConfirmCount = tcpCreactlinkConfirmCount;
    }

    public Long getBpFlow() {
        return bpFlow;
    }

    public void setBpFlow(Long bpFlow) {
        this.bpFlow = bpFlow;
    }

    public Long getBpDelay() {
        return bpDelay;
    }

    public void setBpDelay(Long bpDelay) {
        this.bpDelay = bpDelay;
    }

    public Long getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Long getServiceSuccess() {
        return serviceSuccess;
    }

    public void setServiceSuccess(Long serviceSuccess) {
        this.serviceSuccess = serviceSuccess;
    }

    public Long getTencentVideoServiceRequest() {
        return tencentVideoServiceRequest;
    }

    public void setTencentVideoServiceRequest(Long tencentVideoServiceRequest) {
        this.tencentVideoServiceRequest = tencentVideoServiceRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UhttpDTO uhttpDTO = (UhttpDTO) o;
        if(uhttpDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), uhttpDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UhttpDTO{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", phour='" + getPhour() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", flowSum='" + getFlowSum() + "'" +
            ", rateFlowRate='" + getRateFlowRate() + "'" +
            ", rateFlowSuccessRate='" + getRateFlowSuccessRate() + "'" +
            ", rateFlowSuccessDRate='" + getRateFlowSuccessDRate() + "'" +
            ", rateFlow='" + getRateFlow() + "'" +
            ", rateFlowRequest='" + getRateFlowRequest() + "'" +
            ", rateFlowBpSpeed='" + getRateFlowBpSpeed() + "'" +
            ", rateFlowBpSpeedDRate='" + getRateFlowBpSpeedDRate() + "'" +
            ", rateFlowSpDelay='" + getRateFlowSpDelay() + "'" +
            ", rateFlowSpDelayDRate='" + getRateFlowSpDelayDRate() + "'" +
            ", delayFlowRate='" + getDelayFlowRate() + "'" +
            ", delayFlowSuccessRate='" + getDelayFlowSuccessRate() + "'" +
            ", delayFlowSuccessDRate='" + getDelayFlowSuccessDRate() + "'" +
            ", delayFlow='" + getDelayFlow() + "'" +
            ", delayFlowRequest='" + getDelayFlowRequest() + "'" +
            ", delayFlowBpSpeed='" + getDelayFlowBpSpeed() + "'" +
            ", delayFlowBpSpeedDRate='" + getDelayFlowBpSpeedDRate() + "'" +
            ", delayFlowSpDelay='" + getDelayFlowSpDelay() + "'" +
            ", delayFlowSpDelayDRate='" + getDelayFlowSpDelayDRate() + "'" +
            ", refreshFlowRate='" + getRefreshFlowRate() + "'" +
            ", refreshFlowSuccessRate='" + getRefreshFlowSuccessRate() + "'" +
            ", refreshFlowSuccessDRate='" + getRefreshFlowSuccessDRate() + "'" +
            ", refreshFlow='" + getRefreshFlow() + "'" +
            ", refreshFlowRequest='" + getRefreshFlowRequest() + "'" +
            ", refreshFlowBpSpeed='" + getRefreshFlowBpSpeed() + "'" +
            ", refreshFlowBpSpeedDRate='" + getRefreshFlowBpSpeedDRate() + "'" +
            ", refreshFlowSpDelay='" + getRefreshFlowSpDelay() + "'" +
            ", refreshFlowSpDelayDRate='" + getRefreshFlowSpDelayDRate() + "'" +
            ", instantFlowRate='" + getInstantFlowRate() + "'" +
            ", instantFlowSuccessRate='" + getInstantFlowSuccessRate() + "'" +
            ", instantFlowSuccessDRate='" + getInstantFlowSuccessDRate() + "'" +
            ", instantFlow='" + getInstantFlow() + "'" +
            ", instantFlowRequest='" + getInstantFlowRequest() + "'" +
            ", instantFlowBpSpeed='" + getInstantFlowBpSpeed() + "'" +
            ", instantFlowBpSpeedDRate='" + getInstantFlowBpSpeedDRate() + "'" +
            ", instantFlowSpDelay='" + getInstantFlowSpDelay() + "'" +
            ", instantFlowSpDelayDRate='" + getInstantFlowSpDelayDRate() + "'" +
            ", tcpCreactlinkDelay='" + getTcpCreactlinkDelay() + "'" +
            ", tcpCreactlinkCount='" + getTcpCreactlinkCount() + "'" +
            ", tcpCreactlinkResponseDelay='" + getTcpCreactlinkResponseDelay() + "'" +
            ", tcpCreactlinkResponseCount='" + getTcpCreactlinkResponseCount() + "'" +
            ", tcpCreactlinkConfirmDelay='" + getTcpCreactlinkConfirmDelay() + "'" +
            ", tcpCreactlinkConfirmCount='" + getTcpCreactlinkConfirmCount() + "'" +
            ", bpFlow='" + getBpFlow() + "'" +
            ", bpDelay='" + getBpDelay() + "'" +
            ", serviceRequest='" + getServiceRequest() + "'" +
            ", serviceSuccess='" + getServiceSuccess() + "'" +
            ", tencentVideoServiceRequest='" + getTencentVideoServiceRequest() + "'" +
            "}";
    }
}
