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
 * A Uhttp.
 */
@Entity
@Table(name = "uhttp")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "uhttp")
public class Uhttp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "pdate", nullable = false)
    private LocalDate pdate;

    @Column(name = "phour")
    private Integer phour;

    @Column(name = "cell")
    private String cell;

    @Column(name = "imei")
    private String imei;

    @Column(name = "imsi")
    private String imsi;

    @Column(name = "flow_sum")
    private Long flowSum;

    @Column(name = "rate_flow_rate")
    private Double rateFlowRate;

    @Column(name = "rate_flow_success_rate")
    private Double rateFlowSuccessRate;

    @Column(name = "rate_flow_success_d_rate")
    private Double rateFlowSuccessDRate;

    @Column(name = "rate_flow")
    private Long rateFlow;

    @Column(name = "rate_flow_request")
    private Long rateFlowRequest;

    @Column(name = "rate_flow_bp_speed")
    private Long rateFlowBpSpeed;

    @Column(name = "rate_flow_bp_speed_d_rate")
    private Double rateFlowBpSpeedDRate;

    @Column(name = "rate_flow_sp_delay")
    private Long rateFlowSpDelay;

    @Column(name = "rate_flow_sp_delay_d_rate")
    private Double rateFlowSpDelayDRate;

    @Column(name = "delay_flow_rate")
    private Double delayFlowRate;

    @Column(name = "delay_flow_success_rate")
    private Double delayFlowSuccessRate;

    @Column(name = "delay_flow_success_d_rate")
    private Double delayFlowSuccessDRate;

    @Column(name = "delay_flow")
    private Long delayFlow;

    @Column(name = "delay_flow_request")
    private Long delayFlowRequest;

    @Column(name = "delay_flow_bp_speed")
    private Long delayFlowBpSpeed;

    @Column(name = "delay_flow_bp_speed_d_rate")
    private Double delayFlowBpSpeedDRate;

    @Column(name = "delay_flow_sp_delay")
    private Long delayFlowSpDelay;

    @Column(name = "delay_flow_sp_delay_d_rate")
    private Double delayFlowSpDelayDRate;

    @Column(name = "refresh_flow_rate")
    private Double refreshFlowRate;

    @Column(name = "refresh_flow_success_rate")
    private Double refreshFlowSuccessRate;

    @Column(name = "refresh_flow_success_d_rate")
    private Double refreshFlowSuccessDRate;

    @Column(name = "refresh_flow")
    private Long refreshFlow;

    @Column(name = "refresh_flow_request")
    private Long refreshFlowRequest;

    @Column(name = "refresh_flow_bp_speed")
    private Long refreshFlowBpSpeed;

    @Column(name = "refresh_flow_bp_speed_d_rate")
    private Double refreshFlowBpSpeedDRate;

    @Column(name = "refresh_flow_sp_delay")
    private Long refreshFlowSpDelay;

    @Column(name = "refresh_flow_sp_delay_d_rate")
    private Double refreshFlowSpDelayDRate;

    @Column(name = "instant_flow_rate")
    private Double instantFlowRate;

    @Column(name = "instant_flow_success_rate")
    private Double instantFlowSuccessRate;

    @Column(name = "instant_flow_success_d_rate")
    private Double instantFlowSuccessDRate;

    @Column(name = "instant_flow")
    private Long instantFlow;

    @Column(name = "instant_flow_request")
    private Long instantFlowRequest;

    @Column(name = "instant_flow_bp_speed")
    private Long instantFlowBpSpeed;

    @Column(name = "instant_flow_bp_speed_d_rate")
    private Double instantFlowBpSpeedDRate;

    @Column(name = "instant_flow_sp_delay")
    private Long instantFlowSpDelay;

    @Column(name = "instant_flow_sp_delay_d_rate")
    private Double instantFlowSpDelayDRate;

    @Column(name = "tcp_creactlink_delay")
    private Long tcpCreactlinkDelay;

    @Column(name = "tcp_creactlink_count")
    private Long tcpCreactlinkCount;

    @Column(name = "tcp_creactlink_response_delay")
    private Long tcpCreactlinkResponseDelay;

    @Column(name = "tcp_creactlink_response_count")
    private Long tcpCreactlinkResponseCount;

    @Column(name = "tcp_creactlink_confirm_delay")
    private Long tcpCreactlinkConfirmDelay;

    @Column(name = "tcp_creactlink_confirm_count")
    private Long tcpCreactlinkConfirmCount;

    @Column(name = "bp_flow")
    private Long bpFlow;

    @Column(name = "bp_delay")
    private Long bpDelay;

    @Column(name = "service_request")
    private Long serviceRequest;

    @Column(name = "service_success")
    private Long serviceSuccess;

    @Column(name = "tencent_video_service_request")
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

    public Uhttp pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Integer getPhour() {
        return phour;
    }

    public Uhttp phour(Integer phour) {
        this.phour = phour;
        return this;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public Uhttp cell(String cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public Uhttp imei(String imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public Uhttp imsi(String imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getFlowSum() {
        return flowSum;
    }

    public Uhttp flowSum(Long flowSum) {
        this.flowSum = flowSum;
        return this;
    }

    public void setFlowSum(Long flowSum) {
        this.flowSum = flowSum;
    }

    public Double getRateFlowRate() {
        return rateFlowRate;
    }

    public Uhttp rateFlowRate(Double rateFlowRate) {
        this.rateFlowRate = rateFlowRate;
        return this;
    }

    public void setRateFlowRate(Double rateFlowRate) {
        this.rateFlowRate = rateFlowRate;
    }

    public Double getRateFlowSuccessRate() {
        return rateFlowSuccessRate;
    }

    public Uhttp rateFlowSuccessRate(Double rateFlowSuccessRate) {
        this.rateFlowSuccessRate = rateFlowSuccessRate;
        return this;
    }

    public void setRateFlowSuccessRate(Double rateFlowSuccessRate) {
        this.rateFlowSuccessRate = rateFlowSuccessRate;
    }

    public Double getRateFlowSuccessDRate() {
        return rateFlowSuccessDRate;
    }

    public Uhttp rateFlowSuccessDRate(Double rateFlowSuccessDRate) {
        this.rateFlowSuccessDRate = rateFlowSuccessDRate;
        return this;
    }

    public void setRateFlowSuccessDRate(Double rateFlowSuccessDRate) {
        this.rateFlowSuccessDRate = rateFlowSuccessDRate;
    }

    public Long getRateFlow() {
        return rateFlow;
    }

    public Uhttp rateFlow(Long rateFlow) {
        this.rateFlow = rateFlow;
        return this;
    }

    public void setRateFlow(Long rateFlow) {
        this.rateFlow = rateFlow;
    }

    public Long getRateFlowRequest() {
        return rateFlowRequest;
    }

    public Uhttp rateFlowRequest(Long rateFlowRequest) {
        this.rateFlowRequest = rateFlowRequest;
        return this;
    }

    public void setRateFlowRequest(Long rateFlowRequest) {
        this.rateFlowRequest = rateFlowRequest;
    }

    public Long getRateFlowBpSpeed() {
        return rateFlowBpSpeed;
    }

    public Uhttp rateFlowBpSpeed(Long rateFlowBpSpeed) {
        this.rateFlowBpSpeed = rateFlowBpSpeed;
        return this;
    }

    public void setRateFlowBpSpeed(Long rateFlowBpSpeed) {
        this.rateFlowBpSpeed = rateFlowBpSpeed;
    }

    public Double getRateFlowBpSpeedDRate() {
        return rateFlowBpSpeedDRate;
    }

    public Uhttp rateFlowBpSpeedDRate(Double rateFlowBpSpeedDRate) {
        this.rateFlowBpSpeedDRate = rateFlowBpSpeedDRate;
        return this;
    }

    public void setRateFlowBpSpeedDRate(Double rateFlowBpSpeedDRate) {
        this.rateFlowBpSpeedDRate = rateFlowBpSpeedDRate;
    }

    public Long getRateFlowSpDelay() {
        return rateFlowSpDelay;
    }

    public Uhttp rateFlowSpDelay(Long rateFlowSpDelay) {
        this.rateFlowSpDelay = rateFlowSpDelay;
        return this;
    }

    public void setRateFlowSpDelay(Long rateFlowSpDelay) {
        this.rateFlowSpDelay = rateFlowSpDelay;
    }

    public Double getRateFlowSpDelayDRate() {
        return rateFlowSpDelayDRate;
    }

    public Uhttp rateFlowSpDelayDRate(Double rateFlowSpDelayDRate) {
        this.rateFlowSpDelayDRate = rateFlowSpDelayDRate;
        return this;
    }

    public void setRateFlowSpDelayDRate(Double rateFlowSpDelayDRate) {
        this.rateFlowSpDelayDRate = rateFlowSpDelayDRate;
    }

    public Double getDelayFlowRate() {
        return delayFlowRate;
    }

    public Uhttp delayFlowRate(Double delayFlowRate) {
        this.delayFlowRate = delayFlowRate;
        return this;
    }

    public void setDelayFlowRate(Double delayFlowRate) {
        this.delayFlowRate = delayFlowRate;
    }

    public Double getDelayFlowSuccessRate() {
        return delayFlowSuccessRate;
    }

    public Uhttp delayFlowSuccessRate(Double delayFlowSuccessRate) {
        this.delayFlowSuccessRate = delayFlowSuccessRate;
        return this;
    }

    public void setDelayFlowSuccessRate(Double delayFlowSuccessRate) {
        this.delayFlowSuccessRate = delayFlowSuccessRate;
    }

    public Double getDelayFlowSuccessDRate() {
        return delayFlowSuccessDRate;
    }

    public Uhttp delayFlowSuccessDRate(Double delayFlowSuccessDRate) {
        this.delayFlowSuccessDRate = delayFlowSuccessDRate;
        return this;
    }

    public void setDelayFlowSuccessDRate(Double delayFlowSuccessDRate) {
        this.delayFlowSuccessDRate = delayFlowSuccessDRate;
    }

    public Long getDelayFlow() {
        return delayFlow;
    }

    public Uhttp delayFlow(Long delayFlow) {
        this.delayFlow = delayFlow;
        return this;
    }

    public void setDelayFlow(Long delayFlow) {
        this.delayFlow = delayFlow;
    }

    public Long getDelayFlowRequest() {
        return delayFlowRequest;
    }

    public Uhttp delayFlowRequest(Long delayFlowRequest) {
        this.delayFlowRequest = delayFlowRequest;
        return this;
    }

    public void setDelayFlowRequest(Long delayFlowRequest) {
        this.delayFlowRequest = delayFlowRequest;
    }

    public Long getDelayFlowBpSpeed() {
        return delayFlowBpSpeed;
    }

    public Uhttp delayFlowBpSpeed(Long delayFlowBpSpeed) {
        this.delayFlowBpSpeed = delayFlowBpSpeed;
        return this;
    }

    public void setDelayFlowBpSpeed(Long delayFlowBpSpeed) {
        this.delayFlowBpSpeed = delayFlowBpSpeed;
    }

    public Double getDelayFlowBpSpeedDRate() {
        return delayFlowBpSpeedDRate;
    }

    public Uhttp delayFlowBpSpeedDRate(Double delayFlowBpSpeedDRate) {
        this.delayFlowBpSpeedDRate = delayFlowBpSpeedDRate;
        return this;
    }

    public void setDelayFlowBpSpeedDRate(Double delayFlowBpSpeedDRate) {
        this.delayFlowBpSpeedDRate = delayFlowBpSpeedDRate;
    }

    public Long getDelayFlowSpDelay() {
        return delayFlowSpDelay;
    }

    public Uhttp delayFlowSpDelay(Long delayFlowSpDelay) {
        this.delayFlowSpDelay = delayFlowSpDelay;
        return this;
    }

    public void setDelayFlowSpDelay(Long delayFlowSpDelay) {
        this.delayFlowSpDelay = delayFlowSpDelay;
    }

    public Double getDelayFlowSpDelayDRate() {
        return delayFlowSpDelayDRate;
    }

    public Uhttp delayFlowSpDelayDRate(Double delayFlowSpDelayDRate) {
        this.delayFlowSpDelayDRate = delayFlowSpDelayDRate;
        return this;
    }

    public void setDelayFlowSpDelayDRate(Double delayFlowSpDelayDRate) {
        this.delayFlowSpDelayDRate = delayFlowSpDelayDRate;
    }

    public Double getRefreshFlowRate() {
        return refreshFlowRate;
    }

    public Uhttp refreshFlowRate(Double refreshFlowRate) {
        this.refreshFlowRate = refreshFlowRate;
        return this;
    }

    public void setRefreshFlowRate(Double refreshFlowRate) {
        this.refreshFlowRate = refreshFlowRate;
    }

    public Double getRefreshFlowSuccessRate() {
        return refreshFlowSuccessRate;
    }

    public Uhttp refreshFlowSuccessRate(Double refreshFlowSuccessRate) {
        this.refreshFlowSuccessRate = refreshFlowSuccessRate;
        return this;
    }

    public void setRefreshFlowSuccessRate(Double refreshFlowSuccessRate) {
        this.refreshFlowSuccessRate = refreshFlowSuccessRate;
    }

    public Double getRefreshFlowSuccessDRate() {
        return refreshFlowSuccessDRate;
    }

    public Uhttp refreshFlowSuccessDRate(Double refreshFlowSuccessDRate) {
        this.refreshFlowSuccessDRate = refreshFlowSuccessDRate;
        return this;
    }

    public void setRefreshFlowSuccessDRate(Double refreshFlowSuccessDRate) {
        this.refreshFlowSuccessDRate = refreshFlowSuccessDRate;
    }

    public Long getRefreshFlow() {
        return refreshFlow;
    }

    public Uhttp refreshFlow(Long refreshFlow) {
        this.refreshFlow = refreshFlow;
        return this;
    }

    public void setRefreshFlow(Long refreshFlow) {
        this.refreshFlow = refreshFlow;
    }

    public Long getRefreshFlowRequest() {
        return refreshFlowRequest;
    }

    public Uhttp refreshFlowRequest(Long refreshFlowRequest) {
        this.refreshFlowRequest = refreshFlowRequest;
        return this;
    }

    public void setRefreshFlowRequest(Long refreshFlowRequest) {
        this.refreshFlowRequest = refreshFlowRequest;
    }

    public Long getRefreshFlowBpSpeed() {
        return refreshFlowBpSpeed;
    }

    public Uhttp refreshFlowBpSpeed(Long refreshFlowBpSpeed) {
        this.refreshFlowBpSpeed = refreshFlowBpSpeed;
        return this;
    }

    public void setRefreshFlowBpSpeed(Long refreshFlowBpSpeed) {
        this.refreshFlowBpSpeed = refreshFlowBpSpeed;
    }

    public Double getRefreshFlowBpSpeedDRate() {
        return refreshFlowBpSpeedDRate;
    }

    public Uhttp refreshFlowBpSpeedDRate(Double refreshFlowBpSpeedDRate) {
        this.refreshFlowBpSpeedDRate = refreshFlowBpSpeedDRate;
        return this;
    }

    public void setRefreshFlowBpSpeedDRate(Double refreshFlowBpSpeedDRate) {
        this.refreshFlowBpSpeedDRate = refreshFlowBpSpeedDRate;
    }

    public Long getRefreshFlowSpDelay() {
        return refreshFlowSpDelay;
    }

    public Uhttp refreshFlowSpDelay(Long refreshFlowSpDelay) {
        this.refreshFlowSpDelay = refreshFlowSpDelay;
        return this;
    }

    public void setRefreshFlowSpDelay(Long refreshFlowSpDelay) {
        this.refreshFlowSpDelay = refreshFlowSpDelay;
    }

    public Double getRefreshFlowSpDelayDRate() {
        return refreshFlowSpDelayDRate;
    }

    public Uhttp refreshFlowSpDelayDRate(Double refreshFlowSpDelayDRate) {
        this.refreshFlowSpDelayDRate = refreshFlowSpDelayDRate;
        return this;
    }

    public void setRefreshFlowSpDelayDRate(Double refreshFlowSpDelayDRate) {
        this.refreshFlowSpDelayDRate = refreshFlowSpDelayDRate;
    }

    public Double getInstantFlowRate() {
        return instantFlowRate;
    }

    public Uhttp instantFlowRate(Double instantFlowRate) {
        this.instantFlowRate = instantFlowRate;
        return this;
    }

    public void setInstantFlowRate(Double instantFlowRate) {
        this.instantFlowRate = instantFlowRate;
    }

    public Double getInstantFlowSuccessRate() {
        return instantFlowSuccessRate;
    }

    public Uhttp instantFlowSuccessRate(Double instantFlowSuccessRate) {
        this.instantFlowSuccessRate = instantFlowSuccessRate;
        return this;
    }

    public void setInstantFlowSuccessRate(Double instantFlowSuccessRate) {
        this.instantFlowSuccessRate = instantFlowSuccessRate;
    }

    public Double getInstantFlowSuccessDRate() {
        return instantFlowSuccessDRate;
    }

    public Uhttp instantFlowSuccessDRate(Double instantFlowSuccessDRate) {
        this.instantFlowSuccessDRate = instantFlowSuccessDRate;
        return this;
    }

    public void setInstantFlowSuccessDRate(Double instantFlowSuccessDRate) {
        this.instantFlowSuccessDRate = instantFlowSuccessDRate;
    }

    public Long getInstantFlow() {
        return instantFlow;
    }

    public Uhttp instantFlow(Long instantFlow) {
        this.instantFlow = instantFlow;
        return this;
    }

    public void setInstantFlow(Long instantFlow) {
        this.instantFlow = instantFlow;
    }

    public Long getInstantFlowRequest() {
        return instantFlowRequest;
    }

    public Uhttp instantFlowRequest(Long instantFlowRequest) {
        this.instantFlowRequest = instantFlowRequest;
        return this;
    }

    public void setInstantFlowRequest(Long instantFlowRequest) {
        this.instantFlowRequest = instantFlowRequest;
    }

    public Long getInstantFlowBpSpeed() {
        return instantFlowBpSpeed;
    }

    public Uhttp instantFlowBpSpeed(Long instantFlowBpSpeed) {
        this.instantFlowBpSpeed = instantFlowBpSpeed;
        return this;
    }

    public void setInstantFlowBpSpeed(Long instantFlowBpSpeed) {
        this.instantFlowBpSpeed = instantFlowBpSpeed;
    }

    public Double getInstantFlowBpSpeedDRate() {
        return instantFlowBpSpeedDRate;
    }

    public Uhttp instantFlowBpSpeedDRate(Double instantFlowBpSpeedDRate) {
        this.instantFlowBpSpeedDRate = instantFlowBpSpeedDRate;
        return this;
    }

    public void setInstantFlowBpSpeedDRate(Double instantFlowBpSpeedDRate) {
        this.instantFlowBpSpeedDRate = instantFlowBpSpeedDRate;
    }

    public Long getInstantFlowSpDelay() {
        return instantFlowSpDelay;
    }

    public Uhttp instantFlowSpDelay(Long instantFlowSpDelay) {
        this.instantFlowSpDelay = instantFlowSpDelay;
        return this;
    }

    public void setInstantFlowSpDelay(Long instantFlowSpDelay) {
        this.instantFlowSpDelay = instantFlowSpDelay;
    }

    public Double getInstantFlowSpDelayDRate() {
        return instantFlowSpDelayDRate;
    }

    public Uhttp instantFlowSpDelayDRate(Double instantFlowSpDelayDRate) {
        this.instantFlowSpDelayDRate = instantFlowSpDelayDRate;
        return this;
    }

    public void setInstantFlowSpDelayDRate(Double instantFlowSpDelayDRate) {
        this.instantFlowSpDelayDRate = instantFlowSpDelayDRate;
    }

    public Long getTcpCreactlinkDelay() {
        return tcpCreactlinkDelay;
    }

    public Uhttp tcpCreactlinkDelay(Long tcpCreactlinkDelay) {
        this.tcpCreactlinkDelay = tcpCreactlinkDelay;
        return this;
    }

    public void setTcpCreactlinkDelay(Long tcpCreactlinkDelay) {
        this.tcpCreactlinkDelay = tcpCreactlinkDelay;
    }

    public Long getTcpCreactlinkCount() {
        return tcpCreactlinkCount;
    }

    public Uhttp tcpCreactlinkCount(Long tcpCreactlinkCount) {
        this.tcpCreactlinkCount = tcpCreactlinkCount;
        return this;
    }

    public void setTcpCreactlinkCount(Long tcpCreactlinkCount) {
        this.tcpCreactlinkCount = tcpCreactlinkCount;
    }

    public Long getTcpCreactlinkResponseDelay() {
        return tcpCreactlinkResponseDelay;
    }

    public Uhttp tcpCreactlinkResponseDelay(Long tcpCreactlinkResponseDelay) {
        this.tcpCreactlinkResponseDelay = tcpCreactlinkResponseDelay;
        return this;
    }

    public void setTcpCreactlinkResponseDelay(Long tcpCreactlinkResponseDelay) {
        this.tcpCreactlinkResponseDelay = tcpCreactlinkResponseDelay;
    }

    public Long getTcpCreactlinkResponseCount() {
        return tcpCreactlinkResponseCount;
    }

    public Uhttp tcpCreactlinkResponseCount(Long tcpCreactlinkResponseCount) {
        this.tcpCreactlinkResponseCount = tcpCreactlinkResponseCount;
        return this;
    }

    public void setTcpCreactlinkResponseCount(Long tcpCreactlinkResponseCount) {
        this.tcpCreactlinkResponseCount = tcpCreactlinkResponseCount;
    }

    public Long getTcpCreactlinkConfirmDelay() {
        return tcpCreactlinkConfirmDelay;
    }

    public Uhttp tcpCreactlinkConfirmDelay(Long tcpCreactlinkConfirmDelay) {
        this.tcpCreactlinkConfirmDelay = tcpCreactlinkConfirmDelay;
        return this;
    }

    public void setTcpCreactlinkConfirmDelay(Long tcpCreactlinkConfirmDelay) {
        this.tcpCreactlinkConfirmDelay = tcpCreactlinkConfirmDelay;
    }

    public Long getTcpCreactlinkConfirmCount() {
        return tcpCreactlinkConfirmCount;
    }

    public Uhttp tcpCreactlinkConfirmCount(Long tcpCreactlinkConfirmCount) {
        this.tcpCreactlinkConfirmCount = tcpCreactlinkConfirmCount;
        return this;
    }

    public void setTcpCreactlinkConfirmCount(Long tcpCreactlinkConfirmCount) {
        this.tcpCreactlinkConfirmCount = tcpCreactlinkConfirmCount;
    }

    public Long getBpFlow() {
        return bpFlow;
    }

    public Uhttp bpFlow(Long bpFlow) {
        this.bpFlow = bpFlow;
        return this;
    }

    public void setBpFlow(Long bpFlow) {
        this.bpFlow = bpFlow;
    }

    public Long getBpDelay() {
        return bpDelay;
    }

    public Uhttp bpDelay(Long bpDelay) {
        this.bpDelay = bpDelay;
        return this;
    }

    public void setBpDelay(Long bpDelay) {
        this.bpDelay = bpDelay;
    }

    public Long getServiceRequest() {
        return serviceRequest;
    }

    public Uhttp serviceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
        return this;
    }

    public void setServiceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Long getServiceSuccess() {
        return serviceSuccess;
    }

    public Uhttp serviceSuccess(Long serviceSuccess) {
        this.serviceSuccess = serviceSuccess;
        return this;
    }

    public void setServiceSuccess(Long serviceSuccess) {
        this.serviceSuccess = serviceSuccess;
    }

    public Long getTencentVideoServiceRequest() {
        return tencentVideoServiceRequest;
    }

    public Uhttp tencentVideoServiceRequest(Long tencentVideoServiceRequest) {
        this.tencentVideoServiceRequest = tencentVideoServiceRequest;
        return this;
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
        Uhttp uhttp = (Uhttp) o;
        if (uhttp.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), uhttp.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Uhttp{" +
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
