package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ExceptionStats entity.
 */
public class ExceptionStatsDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Long cell;

    private Long imei;

    private Long imsi;

    private Double attachFaultRate;

    private Integer attachRequest;

    private Integer attachFault;

    private Double serviceFaultRate;

    private Integer serviceRequest;

    private Integer serviceFault;

    private Double csfbFaultRate;

    private Integer csfbRequest;

    private Integer csfbFault;

    private Double contextActivateFaultRate;

    private Integer contextActivateRequest;

    private Integer contextActivateFault;

    private Double pdnRequestFaultRate;

    private Integer pdnRequest;

    private Integer pdnRequestFault;

    private Double tauFaultRate;

    private Integer tauRequest;

    private Integer tauFault;

    private Double xhoFaultRate;

    private Integer xhoRequest;

    private Integer xhoFault;

    private Double shoFaultRate;

    private Integer shoRequest;

    private Integer shoFault;

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

    public Double getAttachFaultRate() {
        return attachFaultRate;
    }

    public void setAttachFaultRate(Double attachFaultRate) {
        this.attachFaultRate = attachFaultRate;
    }

    public Integer getAttachRequest() {
        return attachRequest;
    }

    public void setAttachRequest(Integer attachRequest) {
        this.attachRequest = attachRequest;
    }

    public Integer getAttachFault() {
        return attachFault;
    }

    public void setAttachFault(Integer attachFault) {
        this.attachFault = attachFault;
    }

    public Double getServiceFaultRate() {
        return serviceFaultRate;
    }

    public void setServiceFaultRate(Double serviceFaultRate) {
        this.serviceFaultRate = serviceFaultRate;
    }

    public Integer getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(Integer serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Integer getServiceFault() {
        return serviceFault;
    }

    public void setServiceFault(Integer serviceFault) {
        this.serviceFault = serviceFault;
    }

    public Double getCsfbFaultRate() {
        return csfbFaultRate;
    }

    public void setCsfbFaultRate(Double csfbFaultRate) {
        this.csfbFaultRate = csfbFaultRate;
    }

    public Integer getCsfbRequest() {
        return csfbRequest;
    }

    public void setCsfbRequest(Integer csfbRequest) {
        this.csfbRequest = csfbRequest;
    }

    public Integer getCsfbFault() {
        return csfbFault;
    }

    public void setCsfbFault(Integer csfbFault) {
        this.csfbFault = csfbFault;
    }

    public Double getContextActivateFaultRate() {
        return contextActivateFaultRate;
    }

    public void setContextActivateFaultRate(Double contextActivateFaultRate) {
        this.contextActivateFaultRate = contextActivateFaultRate;
    }

    public Integer getContextActivateRequest() {
        return contextActivateRequest;
    }

    public void setContextActivateRequest(Integer contextActivateRequest) {
        this.contextActivateRequest = contextActivateRequest;
    }

    public Integer getContextActivateFault() {
        return contextActivateFault;
    }

    public void setContextActivateFault(Integer contextActivateFault) {
        this.contextActivateFault = contextActivateFault;
    }

    public Double getPdnRequestFaultRate() {
        return pdnRequestFaultRate;
    }

    public void setPdnRequestFaultRate(Double pdnRequestFaultRate) {
        this.pdnRequestFaultRate = pdnRequestFaultRate;
    }

    public Integer getPdnRequest() {
        return pdnRequest;
    }

    public void setPdnRequest(Integer pdnRequest) {
        this.pdnRequest = pdnRequest;
    }

    public Integer getPdnRequestFault() {
        return pdnRequestFault;
    }

    public void setPdnRequestFault(Integer pdnRequestFault) {
        this.pdnRequestFault = pdnRequestFault;
    }

    public Double getTauFaultRate() {
        return tauFaultRate;
    }

    public void setTauFaultRate(Double tauFaultRate) {
        this.tauFaultRate = tauFaultRate;
    }

    public Integer getTauRequest() {
        return tauRequest;
    }

    public void setTauRequest(Integer tauRequest) {
        this.tauRequest = tauRequest;
    }

    public Integer getTauFault() {
        return tauFault;
    }

    public void setTauFault(Integer tauFault) {
        this.tauFault = tauFault;
    }

    public Double getXhoFaultRate() {
        return xhoFaultRate;
    }

    public void setXhoFaultRate(Double xhoFaultRate) {
        this.xhoFaultRate = xhoFaultRate;
    }

    public Integer getXhoRequest() {
        return xhoRequest;
    }

    public void setXhoRequest(Integer xhoRequest) {
        this.xhoRequest = xhoRequest;
    }

    public Integer getXhoFault() {
        return xhoFault;
    }

    public void setXhoFault(Integer xhoFault) {
        this.xhoFault = xhoFault;
    }

    public Double getShoFaultRate() {
        return shoFaultRate;
    }

    public void setShoFaultRate(Double shoFaultRate) {
        this.shoFaultRate = shoFaultRate;
    }

    public Integer getShoRequest() {
        return shoRequest;
    }

    public void setShoRequest(Integer shoRequest) {
        this.shoRequest = shoRequest;
    }

    public Integer getShoFault() {
        return shoFault;
    }

    public void setShoFault(Integer shoFault) {
        this.shoFault = shoFault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExceptionStatsDTO exceptionStatsDTO = (ExceptionStatsDTO) o;
        if(exceptionStatsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exceptionStatsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExceptionStatsDTO{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", attachFaultRate='" + getAttachFaultRate() + "'" +
            ", attachRequest='" + getAttachRequest() + "'" +
            ", attachFault='" + getAttachFault() + "'" +
            ", serviceFaultRate='" + getServiceFaultRate() + "'" +
            ", serviceRequest='" + getServiceRequest() + "'" +
            ", serviceFault='" + getServiceFault() + "'" +
            ", csfbFaultRate='" + getCsfbFaultRate() + "'" +
            ", csfbRequest='" + getCsfbRequest() + "'" +
            ", csfbFault='" + getCsfbFault() + "'" +
            ", contextActivateFaultRate='" + getContextActivateFaultRate() + "'" +
            ", contextActivateRequest='" + getContextActivateRequest() + "'" +
            ", contextActivateFault='" + getContextActivateFault() + "'" +
            ", pdnRequestFaultRate='" + getPdnRequestFaultRate() + "'" +
            ", pdnRequest='" + getPdnRequest() + "'" +
            ", pdnRequestFault='" + getPdnRequestFault() + "'" +
            ", tauFaultRate='" + getTauFaultRate() + "'" +
            ", tauRequest='" + getTauRequest() + "'" +
            ", tauFault='" + getTauFault() + "'" +
            ", xhoFaultRate='" + getXhoFaultRate() + "'" +
            ", xhoRequest='" + getXhoRequest() + "'" +
            ", xhoFault='" + getXhoFault() + "'" +
            ", shoFaultRate='" + getShoFaultRate() + "'" +
            ", shoRequest='" + getShoRequest() + "'" +
            ", shoFault='" + getShoFault() + "'" +
            "}";
    }
}
