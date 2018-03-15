package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Uu entity.
 */
public class UuDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Integer phour;

    private String cell;

    private String imei;

    private String imsi;

    private Integer rrcConnectRequest;

    private Integer rrcConnectSuccess;

    private Double rrcConnectSuccessRate;

    private Integer rrcReconfigRequest;

    private Integer rrcReconfigSuccess;

    private Double rrcReconfigSuccessRate;

    private Integer rrcReconstructionRequest;

    private Integer rrcReconstructionSuccess;

    private Double rrcReconstructionSuccessRate;

    private Integer rrcReleaseRequest;

    private Integer rrcReleaseSuccess;

    private Double rrcReleaseSuccessRate;

    private Integer smActivateRequest;

    private Integer smActivateSuccess;

    private Double smActivateSuccessRate;

    private Integer cellInterHandoverRequest;

    private Integer cellInterHandoverSuccess;

    private Double cellInterHandoverSuccessRate;

    private Integer stationIntraHandoverRequest;

    private Integer stationIntraHandoverSuccess;

    private Double stationIntraHandoverSuccessRate;

    private Integer stationInterHandoverRequest;

    private Integer stationInterHandoverSuccess;

    private Double stationInterHandoverSuccessRate;

    private Integer ratInRequest;

    private Integer ratInSuccess;

    private Double ratInSuccessRate;

    private Integer ratOutRequest;

    private Integer ratOutSuccess;

    private Double ratOutSuccessRate;

    private Integer psPagingRequest;

    private Integer psPagingSuccess;

    private Double psPagingSuccessRate;

    private Integer csPagingRequest;

    private Integer csPagingSuccess;

    private Double csPagingSuccessRate;

    private Integer othereventRequest;

    private Integer othereventSuccess;

    private Double othereventSuccessRate;

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

    public Integer getRrcConnectRequest() {
        return rrcConnectRequest;
    }

    public void setRrcConnectRequest(Integer rrcConnectRequest) {
        this.rrcConnectRequest = rrcConnectRequest;
    }

    public Integer getRrcConnectSuccess() {
        return rrcConnectSuccess;
    }

    public void setRrcConnectSuccess(Integer rrcConnectSuccess) {
        this.rrcConnectSuccess = rrcConnectSuccess;
    }

    public Double getRrcConnectSuccessRate() {
        return rrcConnectSuccessRate;
    }

    public void setRrcConnectSuccessRate(Double rrcConnectSuccessRate) {
        this.rrcConnectSuccessRate = rrcConnectSuccessRate;
    }

    public Integer getRrcReconfigRequest() {
        return rrcReconfigRequest;
    }

    public void setRrcReconfigRequest(Integer rrcReconfigRequest) {
        this.rrcReconfigRequest = rrcReconfigRequest;
    }

    public Integer getRrcReconfigSuccess() {
        return rrcReconfigSuccess;
    }

    public void setRrcReconfigSuccess(Integer rrcReconfigSuccess) {
        this.rrcReconfigSuccess = rrcReconfigSuccess;
    }

    public Double getRrcReconfigSuccessRate() {
        return rrcReconfigSuccessRate;
    }

    public void setRrcReconfigSuccessRate(Double rrcReconfigSuccessRate) {
        this.rrcReconfigSuccessRate = rrcReconfigSuccessRate;
    }

    public Integer getRrcReconstructionRequest() {
        return rrcReconstructionRequest;
    }

    public void setRrcReconstructionRequest(Integer rrcReconstructionRequest) {
        this.rrcReconstructionRequest = rrcReconstructionRequest;
    }

    public Integer getRrcReconstructionSuccess() {
        return rrcReconstructionSuccess;
    }

    public void setRrcReconstructionSuccess(Integer rrcReconstructionSuccess) {
        this.rrcReconstructionSuccess = rrcReconstructionSuccess;
    }

    public Double getRrcReconstructionSuccessRate() {
        return rrcReconstructionSuccessRate;
    }

    public void setRrcReconstructionSuccessRate(Double rrcReconstructionSuccessRate) {
        this.rrcReconstructionSuccessRate = rrcReconstructionSuccessRate;
    }

    public Integer getRrcReleaseRequest() {
        return rrcReleaseRequest;
    }

    public void setRrcReleaseRequest(Integer rrcReleaseRequest) {
        this.rrcReleaseRequest = rrcReleaseRequest;
    }

    public Integer getRrcReleaseSuccess() {
        return rrcReleaseSuccess;
    }

    public void setRrcReleaseSuccess(Integer rrcReleaseSuccess) {
        this.rrcReleaseSuccess = rrcReleaseSuccess;
    }

    public Double getRrcReleaseSuccessRate() {
        return rrcReleaseSuccessRate;
    }

    public void setRrcReleaseSuccessRate(Double rrcReleaseSuccessRate) {
        this.rrcReleaseSuccessRate = rrcReleaseSuccessRate;
    }

    public Integer getSmActivateRequest() {
        return smActivateRequest;
    }

    public void setSmActivateRequest(Integer smActivateRequest) {
        this.smActivateRequest = smActivateRequest;
    }

    public Integer getSmActivateSuccess() {
        return smActivateSuccess;
    }

    public void setSmActivateSuccess(Integer smActivateSuccess) {
        this.smActivateSuccess = smActivateSuccess;
    }

    public Double getSmActivateSuccessRate() {
        return smActivateSuccessRate;
    }

    public void setSmActivateSuccessRate(Double smActivateSuccessRate) {
        this.smActivateSuccessRate = smActivateSuccessRate;
    }

    public Integer getCellInterHandoverRequest() {
        return cellInterHandoverRequest;
    }

    public void setCellInterHandoverRequest(Integer cellInterHandoverRequest) {
        this.cellInterHandoverRequest = cellInterHandoverRequest;
    }

    public Integer getCellInterHandoverSuccess() {
        return cellInterHandoverSuccess;
    }

    public void setCellInterHandoverSuccess(Integer cellInterHandoverSuccess) {
        this.cellInterHandoverSuccess = cellInterHandoverSuccess;
    }

    public Double getCellInterHandoverSuccessRate() {
        return cellInterHandoverSuccessRate;
    }

    public void setCellInterHandoverSuccessRate(Double cellInterHandoverSuccessRate) {
        this.cellInterHandoverSuccessRate = cellInterHandoverSuccessRate;
    }

    public Integer getStationIntraHandoverRequest() {
        return stationIntraHandoverRequest;
    }

    public void setStationIntraHandoverRequest(Integer stationIntraHandoverRequest) {
        this.stationIntraHandoverRequest = stationIntraHandoverRequest;
    }

    public Integer getStationIntraHandoverSuccess() {
        return stationIntraHandoverSuccess;
    }

    public void setStationIntraHandoverSuccess(Integer stationIntraHandoverSuccess) {
        this.stationIntraHandoverSuccess = stationIntraHandoverSuccess;
    }

    public Double getStationIntraHandoverSuccessRate() {
        return stationIntraHandoverSuccessRate;
    }

    public void setStationIntraHandoverSuccessRate(Double stationIntraHandoverSuccessRate) {
        this.stationIntraHandoverSuccessRate = stationIntraHandoverSuccessRate;
    }

    public Integer getStationInterHandoverRequest() {
        return stationInterHandoverRequest;
    }

    public void setStationInterHandoverRequest(Integer stationInterHandoverRequest) {
        this.stationInterHandoverRequest = stationInterHandoverRequest;
    }

    public Integer getStationInterHandoverSuccess() {
        return stationInterHandoverSuccess;
    }

    public void setStationInterHandoverSuccess(Integer stationInterHandoverSuccess) {
        this.stationInterHandoverSuccess = stationInterHandoverSuccess;
    }

    public Double getStationInterHandoverSuccessRate() {
        return stationInterHandoverSuccessRate;
    }

    public void setStationInterHandoverSuccessRate(Double stationInterHandoverSuccessRate) {
        this.stationInterHandoverSuccessRate = stationInterHandoverSuccessRate;
    }

    public Integer getRatInRequest() {
        return ratInRequest;
    }

    public void setRatInRequest(Integer ratInRequest) {
        this.ratInRequest = ratInRequest;
    }

    public Integer getRatInSuccess() {
        return ratInSuccess;
    }

    public void setRatInSuccess(Integer ratInSuccess) {
        this.ratInSuccess = ratInSuccess;
    }

    public Double getRatInSuccessRate() {
        return ratInSuccessRate;
    }

    public void setRatInSuccessRate(Double ratInSuccessRate) {
        this.ratInSuccessRate = ratInSuccessRate;
    }

    public Integer getRatOutRequest() {
        return ratOutRequest;
    }

    public void setRatOutRequest(Integer ratOutRequest) {
        this.ratOutRequest = ratOutRequest;
    }

    public Integer getRatOutSuccess() {
        return ratOutSuccess;
    }

    public void setRatOutSuccess(Integer ratOutSuccess) {
        this.ratOutSuccess = ratOutSuccess;
    }

    public Double getRatOutSuccessRate() {
        return ratOutSuccessRate;
    }

    public void setRatOutSuccessRate(Double ratOutSuccessRate) {
        this.ratOutSuccessRate = ratOutSuccessRate;
    }

    public Integer getPsPagingRequest() {
        return psPagingRequest;
    }

    public void setPsPagingRequest(Integer psPagingRequest) {
        this.psPagingRequest = psPagingRequest;
    }

    public Integer getPsPagingSuccess() {
        return psPagingSuccess;
    }

    public void setPsPagingSuccess(Integer psPagingSuccess) {
        this.psPagingSuccess = psPagingSuccess;
    }

    public Double getPsPagingSuccessRate() {
        return psPagingSuccessRate;
    }

    public void setPsPagingSuccessRate(Double psPagingSuccessRate) {
        this.psPagingSuccessRate = psPagingSuccessRate;
    }

    public Integer getCsPagingRequest() {
        return csPagingRequest;
    }

    public void setCsPagingRequest(Integer csPagingRequest) {
        this.csPagingRequest = csPagingRequest;
    }

    public Integer getCsPagingSuccess() {
        return csPagingSuccess;
    }

    public void setCsPagingSuccess(Integer csPagingSuccess) {
        this.csPagingSuccess = csPagingSuccess;
    }

    public Double getCsPagingSuccessRate() {
        return csPagingSuccessRate;
    }

    public void setCsPagingSuccessRate(Double csPagingSuccessRate) {
        this.csPagingSuccessRate = csPagingSuccessRate;
    }

    public Integer getOthereventRequest() {
        return othereventRequest;
    }

    public void setOthereventRequest(Integer othereventRequest) {
        this.othereventRequest = othereventRequest;
    }

    public Integer getOthereventSuccess() {
        return othereventSuccess;
    }

    public void setOthereventSuccess(Integer othereventSuccess) {
        this.othereventSuccess = othereventSuccess;
    }

    public Double getOthereventSuccessRate() {
        return othereventSuccessRate;
    }

    public void setOthereventSuccessRate(Double othereventSuccessRate) {
        this.othereventSuccessRate = othereventSuccessRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UuDTO uuDTO = (UuDTO) o;
        if(uuDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), uuDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UuDTO{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", phour='" + getPhour() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", rrcConnectRequest='" + getRrcConnectRequest() + "'" +
            ", rrcConnectSuccess='" + getRrcConnectSuccess() + "'" +
            ", rrcConnectSuccessRate='" + getRrcConnectSuccessRate() + "'" +
            ", rrcReconfigRequest='" + getRrcReconfigRequest() + "'" +
            ", rrcReconfigSuccess='" + getRrcReconfigSuccess() + "'" +
            ", rrcReconfigSuccessRate='" + getRrcReconfigSuccessRate() + "'" +
            ", rrcReconstructionRequest='" + getRrcReconstructionRequest() + "'" +
            ", rrcReconstructionSuccess='" + getRrcReconstructionSuccess() + "'" +
            ", rrcReconstructionSuccessRate='" + getRrcReconstructionSuccessRate() + "'" +
            ", rrcReleaseRequest='" + getRrcReleaseRequest() + "'" +
            ", rrcReleaseSuccess='" + getRrcReleaseSuccess() + "'" +
            ", rrcReleaseSuccessRate='" + getRrcReleaseSuccessRate() + "'" +
            ", smActivateRequest='" + getSmActivateRequest() + "'" +
            ", smActivateSuccess='" + getSmActivateSuccess() + "'" +
            ", smActivateSuccessRate='" + getSmActivateSuccessRate() + "'" +
            ", cellInterHandoverRequest='" + getCellInterHandoverRequest() + "'" +
            ", cellInterHandoverSuccess='" + getCellInterHandoverSuccess() + "'" +
            ", cellInterHandoverSuccessRate='" + getCellInterHandoverSuccessRate() + "'" +
            ", stationIntraHandoverRequest='" + getStationIntraHandoverRequest() + "'" +
            ", stationIntraHandoverSuccess='" + getStationIntraHandoverSuccess() + "'" +
            ", stationIntraHandoverSuccessRate='" + getStationIntraHandoverSuccessRate() + "'" +
            ", stationInterHandoverRequest='" + getStationInterHandoverRequest() + "'" +
            ", stationInterHandoverSuccess='" + getStationInterHandoverSuccess() + "'" +
            ", stationInterHandoverSuccessRate='" + getStationInterHandoverSuccessRate() + "'" +
            ", ratInRequest='" + getRatInRequest() + "'" +
            ", ratInSuccess='" + getRatInSuccess() + "'" +
            ", ratInSuccessRate='" + getRatInSuccessRate() + "'" +
            ", ratOutRequest='" + getRatOutRequest() + "'" +
            ", ratOutSuccess='" + getRatOutSuccess() + "'" +
            ", ratOutSuccessRate='" + getRatOutSuccessRate() + "'" +
            ", psPagingRequest='" + getPsPagingRequest() + "'" +
            ", psPagingSuccess='" + getPsPagingSuccess() + "'" +
            ", psPagingSuccessRate='" + getPsPagingSuccessRate() + "'" +
            ", csPagingRequest='" + getCsPagingRequest() + "'" +
            ", csPagingSuccess='" + getCsPagingSuccess() + "'" +
            ", csPagingSuccessRate='" + getCsPagingSuccessRate() + "'" +
            ", othereventRequest='" + getOthereventRequest() + "'" +
            ", othereventSuccess='" + getOthereventSuccess() + "'" +
            ", othereventSuccessRate='" + getOthereventSuccessRate() + "'" +
            "}";
    }
}
