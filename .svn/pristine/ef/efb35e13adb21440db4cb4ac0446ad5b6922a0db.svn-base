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
 * A ExceptionStats.
 */
@Entity
@Table(name = "exception_stats")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "exceptionstats")
public class ExceptionStats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "pdate", nullable = false)
    private LocalDate pdate;

    @Column(name = "cell")
    private Long cell;

    @Column(name = "imei")
    private Long imei;

    @Column(name = "imsi")
    private Long imsi;

    @Column(name = "attach_fault_rate")
    private Double attachFaultRate;

    @Column(name = "attach_request")
    private Integer attachRequest;

    @Column(name = "attach_fault")
    private Integer attachFault;

    @Column(name = "service_fault_rate")
    private Double serviceFaultRate;

    @Column(name = "service_request")
    private Integer serviceRequest;

    @Column(name = "service_fault")
    private Integer serviceFault;

    @Column(name = "csfb_fault_rate")
    private Double csfbFaultRate;

    @Column(name = "csfb_request")
    private Integer csfbRequest;

    @Column(name = "csfb_fault")
    private Integer csfbFault;

    @Column(name = "context_activate_fault_rate")
    private Double contextActivateFaultRate;

    @Column(name = "context_activate_request")
    private Integer contextActivateRequest;

    @Column(name = "context_activate_fault")
    private Integer contextActivateFault;

    @Column(name = "pdn_request_fault_rate")
    private Double pdnRequestFaultRate;

    @Column(name = "pdn_request")
    private Integer pdnRequest;

    @Column(name = "pdn_request_fault")
    private Integer pdnRequestFault;

    @Column(name = "tau_fault_rate")
    private Double tauFaultRate;

    @Column(name = "tau_request")
    private Integer tauRequest;

    @Column(name = "tau_fault")
    private Integer tauFault;

    @Column(name = "xho_fault_rate")
    private Double xhoFaultRate;

    @Column(name = "xho_request")
    private Integer xhoRequest;

    @Column(name = "xho_fault")
    private Integer xhoFault;

    @Column(name = "sho_fault_rate")
    private Double shoFaultRate;

    @Column(name = "sho_request")
    private Integer shoRequest;

    @Column(name = "sho_fault")
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

    public ExceptionStats pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Long getCell() {
        return cell;
    }

    public ExceptionStats cell(Long cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public Long getImei() {
        return imei;
    }

    public ExceptionStats imei(Long imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public ExceptionStats imsi(Long imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public Double getAttachFaultRate() {
        return attachFaultRate;
    }

    public ExceptionStats attachFaultRate(Double attachFaultRate) {
        this.attachFaultRate = attachFaultRate;
        return this;
    }

    public void setAttachFaultRate(Double attachFaultRate) {
        this.attachFaultRate = attachFaultRate;
    }

    public Integer getAttachRequest() {
        return attachRequest;
    }

    public ExceptionStats attachRequest(Integer attachRequest) {
        this.attachRequest = attachRequest;
        return this;
    }

    public void setAttachRequest(Integer attachRequest) {
        this.attachRequest = attachRequest;
    }

    public Integer getAttachFault() {
        return attachFault;
    }

    public ExceptionStats attachFault(Integer attachFault) {
        this.attachFault = attachFault;
        return this;
    }

    public void setAttachFault(Integer attachFault) {
        this.attachFault = attachFault;
    }

    public Double getServiceFaultRate() {
        return serviceFaultRate;
    }

    public ExceptionStats serviceFaultRate(Double serviceFaultRate) {
        this.serviceFaultRate = serviceFaultRate;
        return this;
    }

    public void setServiceFaultRate(Double serviceFaultRate) {
        this.serviceFaultRate = serviceFaultRate;
    }

    public Integer getServiceRequest() {
        return serviceRequest;
    }

    public ExceptionStats serviceRequest(Integer serviceRequest) {
        this.serviceRequest = serviceRequest;
        return this;
    }

    public void setServiceRequest(Integer serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Integer getServiceFault() {
        return serviceFault;
    }

    public ExceptionStats serviceFault(Integer serviceFault) {
        this.serviceFault = serviceFault;
        return this;
    }

    public void setServiceFault(Integer serviceFault) {
        this.serviceFault = serviceFault;
    }

    public Double getCsfbFaultRate() {
        return csfbFaultRate;
    }

    public ExceptionStats csfbFaultRate(Double csfbFaultRate) {
        this.csfbFaultRate = csfbFaultRate;
        return this;
    }

    public void setCsfbFaultRate(Double csfbFaultRate) {
        this.csfbFaultRate = csfbFaultRate;
    }

    public Integer getCsfbRequest() {
        return csfbRequest;
    }

    public ExceptionStats csfbRequest(Integer csfbRequest) {
        this.csfbRequest = csfbRequest;
        return this;
    }

    public void setCsfbRequest(Integer csfbRequest) {
        this.csfbRequest = csfbRequest;
    }

    public Integer getCsfbFault() {
        return csfbFault;
    }

    public ExceptionStats csfbFault(Integer csfbFault) {
        this.csfbFault = csfbFault;
        return this;
    }

    public void setCsfbFault(Integer csfbFault) {
        this.csfbFault = csfbFault;
    }

    public Double getContextActivateFaultRate() {
        return contextActivateFaultRate;
    }

    public ExceptionStats contextActivateFaultRate(Double contextActivateFaultRate) {
        this.contextActivateFaultRate = contextActivateFaultRate;
        return this;
    }

    public void setContextActivateFaultRate(Double contextActivateFaultRate) {
        this.contextActivateFaultRate = contextActivateFaultRate;
    }

    public Integer getContextActivateRequest() {
        return contextActivateRequest;
    }

    public ExceptionStats contextActivateRequest(Integer contextActivateRequest) {
        this.contextActivateRequest = contextActivateRequest;
        return this;
    }

    public void setContextActivateRequest(Integer contextActivateRequest) {
        this.contextActivateRequest = contextActivateRequest;
    }

    public Integer getContextActivateFault() {
        return contextActivateFault;
    }

    public ExceptionStats contextActivateFault(Integer contextActivateFault) {
        this.contextActivateFault = contextActivateFault;
        return this;
    }

    public void setContextActivateFault(Integer contextActivateFault) {
        this.contextActivateFault = contextActivateFault;
    }

    public Double getPdnRequestFaultRate() {
        return pdnRequestFaultRate;
    }

    public ExceptionStats pdnRequestFaultRate(Double pdnRequestFaultRate) {
        this.pdnRequestFaultRate = pdnRequestFaultRate;
        return this;
    }

    public void setPdnRequestFaultRate(Double pdnRequestFaultRate) {
        this.pdnRequestFaultRate = pdnRequestFaultRate;
    }

    public Integer getPdnRequest() {
        return pdnRequest;
    }

    public ExceptionStats pdnRequest(Integer pdnRequest) {
        this.pdnRequest = pdnRequest;
        return this;
    }

    public void setPdnRequest(Integer pdnRequest) {
        this.pdnRequest = pdnRequest;
    }

    public Integer getPdnRequestFault() {
        return pdnRequestFault;
    }

    public ExceptionStats pdnRequestFault(Integer pdnRequestFault) {
        this.pdnRequestFault = pdnRequestFault;
        return this;
    }

    public void setPdnRequestFault(Integer pdnRequestFault) {
        this.pdnRequestFault = pdnRequestFault;
    }

    public Double getTauFaultRate() {
        return tauFaultRate;
    }

    public ExceptionStats tauFaultRate(Double tauFaultRate) {
        this.tauFaultRate = tauFaultRate;
        return this;
    }

    public void setTauFaultRate(Double tauFaultRate) {
        this.tauFaultRate = tauFaultRate;
    }

    public Integer getTauRequest() {
        return tauRequest;
    }

    public ExceptionStats tauRequest(Integer tauRequest) {
        this.tauRequest = tauRequest;
        return this;
    }

    public void setTauRequest(Integer tauRequest) {
        this.tauRequest = tauRequest;
    }

    public Integer getTauFault() {
        return tauFault;
    }

    public ExceptionStats tauFault(Integer tauFault) {
        this.tauFault = tauFault;
        return this;
    }

    public void setTauFault(Integer tauFault) {
        this.tauFault = tauFault;
    }

    public Double getXhoFaultRate() {
        return xhoFaultRate;
    }

    public ExceptionStats xhoFaultRate(Double xhoFaultRate) {
        this.xhoFaultRate = xhoFaultRate;
        return this;
    }

    public void setXhoFaultRate(Double xhoFaultRate) {
        this.xhoFaultRate = xhoFaultRate;
    }

    public Integer getXhoRequest() {
        return xhoRequest;
    }

    public ExceptionStats xhoRequest(Integer xhoRequest) {
        this.xhoRequest = xhoRequest;
        return this;
    }

    public void setXhoRequest(Integer xhoRequest) {
        this.xhoRequest = xhoRequest;
    }

    public Integer getXhoFault() {
        return xhoFault;
    }

    public ExceptionStats xhoFault(Integer xhoFault) {
        this.xhoFault = xhoFault;
        return this;
    }

    public void setXhoFault(Integer xhoFault) {
        this.xhoFault = xhoFault;
    }

    public Double getShoFaultRate() {
        return shoFaultRate;
    }

    public ExceptionStats shoFaultRate(Double shoFaultRate) {
        this.shoFaultRate = shoFaultRate;
        return this;
    }

    public void setShoFaultRate(Double shoFaultRate) {
        this.shoFaultRate = shoFaultRate;
    }

    public Integer getShoRequest() {
        return shoRequest;
    }

    public ExceptionStats shoRequest(Integer shoRequest) {
        this.shoRequest = shoRequest;
        return this;
    }

    public void setShoRequest(Integer shoRequest) {
        this.shoRequest = shoRequest;
    }

    public Integer getShoFault() {
        return shoFault;
    }

    public ExceptionStats shoFault(Integer shoFault) {
        this.shoFault = shoFault;
        return this;
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
        ExceptionStats exceptionStats = (ExceptionStats) o;
        if (exceptionStats.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exceptionStats.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExceptionStats{" +
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
