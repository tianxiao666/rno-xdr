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
 * A Mme.
 */
@Entity
@Table(name = "mme")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "mme")
public class Mme implements Serializable {

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

    @Column(name = "attach_request")
    private Long attachRequest;

    @Column(name = "attach_success")
    private Long attachSuccess;

    @Column(name = "attach_success_rate")
    private Double attachSuccessRate;

    @Column(name = "service_request")
    private Long serviceRequest;

    @Column(name = "service_request_success")
    private Long serviceRequestSuccess;

    @Column(name = "service_success_rate")
    private Double serviceSuccessRate;

    @Column(name = "default_bearer_activate_request")
    private Long defaultBearerActivateRequest;

    @Column(name = "default_bearer_activate_success")
    private Long defaultBearerActivateSuccess;

    @Column(name = "default_bearer_setup_success_rate")
    private Double defaultBearerSetupSuccessRate;

    @Column(name = "pdn_request")
    private Long pdnRequest;

    @Column(name = "pdn_request_success")
    private Long pdnRequestSuccess;

    @Column(name = "pdn_request_success_rate")
    private Double pdnRequestSuccessRate;

    @Column(name = "tau_request")
    private Long tauRequest;

    @Column(name = "tau_success")
    private Long tauSuccess;

    @Column(name = "tau_success_rate")
    private Double tauSuccessRate;

    @Column(name = "xho_request")
    private Long xhoRequest;

    @Column(name = "xho_success")
    private Long xhoSuccess;

    @Column(name = "xho_success_rate")
    private Double xhoSuccessRate;

    @Column(name = "sho_request")
    private Long shoRequest;

    @Column(name = "sho_success")
    private Long shoSuccess;

    @Column(name = "sho_success_rate")
    private Double shoSuccessRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public Mme pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Integer getPhour() {
        return phour;
    }

    public Mme phour(Integer phour) {
        this.phour = phour;
        return this;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public Mme cell(String cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public Mme imei(String imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public Mme imsi(String imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getAttachRequest() {
        return attachRequest;
    }

    public Mme attachRequest(Long attachRequest) {
        this.attachRequest = attachRequest;
        return this;
    }

    public void setAttachRequest(Long attachRequest) {
        this.attachRequest = attachRequest;
    }

    public Long getAttachSuccess() {
        return attachSuccess;
    }

    public Mme attachSuccess(Long attachSuccess) {
        this.attachSuccess = attachSuccess;
        return this;
    }

    public void setAttachSuccess(Long attachSuccess) {
        this.attachSuccess = attachSuccess;
    }

    public Double getAttachSuccessRate() {
        return attachSuccessRate;
    }

    public Mme attachSuccessRate(Double attachSuccessRate) {
        this.attachSuccessRate = attachSuccessRate;
        return this;
    }

    public void setAttachSuccessRate(Double attachSuccessRate) {
        this.attachSuccessRate = attachSuccessRate;
    }

    public Long getServiceRequest() {
        return serviceRequest;
    }

    public Mme serviceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
        return this;
    }

    public void setServiceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Long getServiceRequestSuccess() {
        return serviceRequestSuccess;
    }

    public Mme serviceRequestSuccess(Long serviceRequestSuccess) {
        this.serviceRequestSuccess = serviceRequestSuccess;
        return this;
    }

    public void setServiceRequestSuccess(Long serviceRequestSuccess) {
        this.serviceRequestSuccess = serviceRequestSuccess;
    }

    public Double getServiceSuccessRate() {
        return serviceSuccessRate;
    }

    public Mme serviceSuccessRate(Double serviceSuccessRate) {
        this.serviceSuccessRate = serviceSuccessRate;
        return this;
    }

    public void setServiceSuccessRate(Double serviceSuccessRate) {
        this.serviceSuccessRate = serviceSuccessRate;
    }

    public Long getDefaultBearerActivateRequest() {
        return defaultBearerActivateRequest;
    }

    public Mme defaultBearerActivateRequest(Long defaultBearerActivateRequest) {
        this.defaultBearerActivateRequest = defaultBearerActivateRequest;
        return this;
    }

    public void setDefaultBearerActivateRequest(Long defaultBearerActivateRequest) {
        this.defaultBearerActivateRequest = defaultBearerActivateRequest;
    }

    public Long getDefaultBearerActivateSuccess() {
        return defaultBearerActivateSuccess;
    }

    public Mme defaultBearerActivateSuccess(Long defaultBearerActivateSuccess) {
        this.defaultBearerActivateSuccess = defaultBearerActivateSuccess;
        return this;
    }

    public void setDefaultBearerActivateSuccess(Long defaultBearerActivateSuccess) {
        this.defaultBearerActivateSuccess = defaultBearerActivateSuccess;
    }

    public Double getDefaultBearerSetupSuccessRate() {
        return defaultBearerSetupSuccessRate;
    }

    public Mme defaultBearerSetupSuccessRate(Double defaultBearerSetupSuccessRate) {
        this.defaultBearerSetupSuccessRate = defaultBearerSetupSuccessRate;
        return this;
    }

    public void setDefaultBearerSetupSuccessRate(Double defaultBearerSetupSuccessRate) {
        this.defaultBearerSetupSuccessRate = defaultBearerSetupSuccessRate;
    }

    public Long getPdnRequest() {
        return pdnRequest;
    }

    public Mme pdnRequest(Long pdnRequest) {
        this.pdnRequest = pdnRequest;
        return this;
    }

    public void setPdnRequest(Long pdnRequest) {
        this.pdnRequest = pdnRequest;
    }

    public Long getPdnRequestSuccess() {
        return pdnRequestSuccess;
    }

    public Mme pdnRequestSuccess(Long pdnRequestSuccess) {
        this.pdnRequestSuccess = pdnRequestSuccess;
        return this;
    }

    public void setPdnRequestSuccess(Long pdnRequestSuccess) {
        this.pdnRequestSuccess = pdnRequestSuccess;
    }

    public Double getPdnRequestSuccessRate() {
        return pdnRequestSuccessRate;
    }

    public Mme pdnRequestSuccessRate(Double pdnRequestSuccessRate) {
        this.pdnRequestSuccessRate = pdnRequestSuccessRate;
        return this;
    }

    public void setPdnRequestSuccessRate(Double pdnRequestSuccessRate) {
        this.pdnRequestSuccessRate = pdnRequestSuccessRate;
    }

    public Long getTauRequest() {
        return tauRequest;
    }

    public Mme tauRequest(Long tauRequest) {
        this.tauRequest = tauRequest;
        return this;
    }

    public void setTauRequest(Long tauRequest) {
        this.tauRequest = tauRequest;
    }

    public Long getTauSuccess() {
        return tauSuccess;
    }

    public Mme tauSuccess(Long tauSuccess) {
        this.tauSuccess = tauSuccess;
        return this;
    }

    public void setTauSuccess(Long tauSuccess) {
        this.tauSuccess = tauSuccess;
    }

    public Double getTauSuccessRate() {
        return tauSuccessRate;
    }

    public Mme tauSuccessRate(Double tauSuccessRate) {
        this.tauSuccessRate = tauSuccessRate;
        return this;
    }

    public void setTauSuccessRate(Double tauSuccessRate) {
        this.tauSuccessRate = tauSuccessRate;
    }

    public Long getXhoRequest() {
        return xhoRequest;
    }

    public Mme xhoRequest(Long xhoRequest) {
        this.xhoRequest = xhoRequest;
        return this;
    }

    public void setXhoRequest(Long xhoRequest) {
        this.xhoRequest = xhoRequest;
    }

    public Long getXhoSuccess() {
        return xhoSuccess;
    }

    public Mme xhoSuccess(Long xhoSuccess) {
        this.xhoSuccess = xhoSuccess;
        return this;
    }

    public void setXhoSuccess(Long xhoSuccess) {
        this.xhoSuccess = xhoSuccess;
    }

    public Double getXhoSuccessRate() {
        return xhoSuccessRate;
    }

    public Mme xhoSuccessRate(Double xhoSuccessRate) {
        this.xhoSuccessRate = xhoSuccessRate;
        return this;
    }

    public void setXhoSuccessRate(Double xhoSuccessRate) {
        this.xhoSuccessRate = xhoSuccessRate;
    }

    public Long getShoRequest() {
        return shoRequest;
    }

    public Mme shoRequest(Long shoRequest) {
        this.shoRequest = shoRequest;
        return this;
    }

    public void setShoRequest(Long shoRequest) {
        this.shoRequest = shoRequest;
    }

    public Long getShoSuccess() {
        return shoSuccess;
    }

    public Mme shoSuccess(Long shoSuccess) {
        this.shoSuccess = shoSuccess;
        return this;
    }

    public void setShoSuccess(Long shoSuccess) {
        this.shoSuccess = shoSuccess;
    }

    public Double getShoSuccessRate() {
        return shoSuccessRate;
    }

    public Mme shoSuccessRate(Double shoSuccessRate) {
        this.shoSuccessRate = shoSuccessRate;
        return this;
    }

    public void setShoSuccessRate(Double shoSuccessRate) {
        this.shoSuccessRate = shoSuccessRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mme mme = (Mme) o;
        if (mme.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mme.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Mme{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", phour='" + getPhour() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", attachRequest='" + getAttachRequest() + "'" +
            ", attachSuccess='" + getAttachSuccess() + "'" +
            ", attachSuccessRate='" + getAttachSuccessRate() + "'" +
            ", serviceRequest='" + getServiceRequest() + "'" +
            ", serviceRequestSuccess='" + getServiceRequestSuccess() + "'" +
            ", serviceSuccessRate='" + getServiceSuccessRate() + "'" +
            ", defaultBearerActivateRequest='" + getDefaultBearerActivateRequest() + "'" +
            ", defaultBearerActivateSuccess='" + getDefaultBearerActivateSuccess() + "'" +
            ", defaultBearerSetupSuccessRate='" + getDefaultBearerSetupSuccessRate() + "'" +
            ", pdnRequest='" + getPdnRequest() + "'" +
            ", pdnRequestSuccess='" + getPdnRequestSuccess() + "'" +
            ", pdnRequestSuccessRate='" + getPdnRequestSuccessRate() + "'" +
            ", tauRequest='" + getTauRequest() + "'" +
            ", tauSuccess='" + getTauSuccess() + "'" +
            ", tauSuccessRate='" + getTauSuccessRate() + "'" +
            ", xhoRequest='" + getXhoRequest() + "'" +
            ", xhoSuccess='" + getXhoSuccess() + "'" +
            ", xhoSuccessRate='" + getXhoSuccessRate() + "'" +
            ", shoRequest='" + getShoRequest() + "'" +
            ", shoSuccess='" + getShoSuccess() + "'" +
            ", shoSuccessRate='" + getShoSuccessRate() + "'" +
            "}";
    }
}
