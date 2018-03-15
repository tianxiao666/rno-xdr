package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Mme entity.
 */
public class MmeDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Integer phour;

    private String cell;

    private String imei;

    private String imsi;

    private Long attachRequest;

    private Long attachSuccess;

    private Double attachSuccessRate;

    private Long serviceRequest;

    private Long serviceRequestSuccess;

    private Double serviceSuccessRate;

    private Long defaultBearerActivateRequest;

    private Long defaultBearerActivateSuccess;

    private Double defaultBearerSetupSuccessRate;

    private Long pdnRequest;

    private Long pdnRequestSuccess;

    private Double pdnRequestSuccessRate;

    private Long tauRequest;

    private Long tauSuccess;

    private Double tauSuccessRate;

    private Long xhoRequest;

    private Long xhoSuccess;

    private Double xhoSuccessRate;

    private Long shoRequest;

    private Long shoSuccess;

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

    public Long getAttachRequest() {
        return attachRequest;
    }

    public void setAttachRequest(Long attachRequest) {
        this.attachRequest = attachRequest;
    }

    public Long getAttachSuccess() {
        return attachSuccess;
    }

    public void setAttachSuccess(Long attachSuccess) {
        this.attachSuccess = attachSuccess;
    }

    public Double getAttachSuccessRate() {
        return attachSuccessRate;
    }

    public void setAttachSuccessRate(Double attachSuccessRate) {
        this.attachSuccessRate = attachSuccessRate;
    }

    public Long getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(Long serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Long getServiceRequestSuccess() {
        return serviceRequestSuccess;
    }

    public void setServiceRequestSuccess(Long serviceRequestSuccess) {
        this.serviceRequestSuccess = serviceRequestSuccess;
    }

    public Double getServiceSuccessRate() {
        return serviceSuccessRate;
    }

    public void setServiceSuccessRate(Double serviceSuccessRate) {
        this.serviceSuccessRate = serviceSuccessRate;
    }

    public Long getDefaultBearerActivateRequest() {
        return defaultBearerActivateRequest;
    }

    public void setDefaultBearerActivateRequest(Long defaultBearerActivateRequest) {
        this.defaultBearerActivateRequest = defaultBearerActivateRequest;
    }

    public Long getDefaultBearerActivateSuccess() {
        return defaultBearerActivateSuccess;
    }

    public void setDefaultBearerActivateSuccess(Long defaultBearerActivateSuccess) {
        this.defaultBearerActivateSuccess = defaultBearerActivateSuccess;
    }

    public Double getDefaultBearerSetupSuccessRate() {
        return defaultBearerSetupSuccessRate;
    }

    public void setDefaultBearerSetupSuccessRate(Double defaultBearerSetupSuccessRate) {
        this.defaultBearerSetupSuccessRate = defaultBearerSetupSuccessRate;
    }

    public Long getPdnRequest() {
        return pdnRequest;
    }

    public void setPdnRequest(Long pdnRequest) {
        this.pdnRequest = pdnRequest;
    }

    public Long getPdnRequestSuccess() {
        return pdnRequestSuccess;
    }

    public void setPdnRequestSuccess(Long pdnRequestSuccess) {
        this.pdnRequestSuccess = pdnRequestSuccess;
    }

    public Double getPdnRequestSuccessRate() {
        return pdnRequestSuccessRate;
    }

    public void setPdnRequestSuccessRate(Double pdnRequestSuccessRate) {
        this.pdnRequestSuccessRate = pdnRequestSuccessRate;
    }

    public Long getTauRequest() {
        return tauRequest;
    }

    public void setTauRequest(Long tauRequest) {
        this.tauRequest = tauRequest;
    }

    public Long getTauSuccess() {
        return tauSuccess;
    }

    public void setTauSuccess(Long tauSuccess) {
        this.tauSuccess = tauSuccess;
    }

    public Double getTauSuccessRate() {
        return tauSuccessRate;
    }

    public void setTauSuccessRate(Double tauSuccessRate) {
        this.tauSuccessRate = tauSuccessRate;
    }

    public Long getXhoRequest() {
        return xhoRequest;
    }

    public void setXhoRequest(Long xhoRequest) {
        this.xhoRequest = xhoRequest;
    }

    public Long getXhoSuccess() {
        return xhoSuccess;
    }

    public void setXhoSuccess(Long xhoSuccess) {
        this.xhoSuccess = xhoSuccess;
    }

    public Double getXhoSuccessRate() {
        return xhoSuccessRate;
    }

    public void setXhoSuccessRate(Double xhoSuccessRate) {
        this.xhoSuccessRate = xhoSuccessRate;
    }

    public Long getShoRequest() {
        return shoRequest;
    }

    public void setShoRequest(Long shoRequest) {
        this.shoRequest = shoRequest;
    }

    public Long getShoSuccess() {
        return shoSuccess;
    }

    public void setShoSuccess(Long shoSuccess) {
        this.shoSuccess = shoSuccess;
    }

    public Double getShoSuccessRate() {
        return shoSuccessRate;
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

        MmeDTO mmeDTO = (MmeDTO) o;
        if(mmeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mmeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MmeDTO{" +
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
