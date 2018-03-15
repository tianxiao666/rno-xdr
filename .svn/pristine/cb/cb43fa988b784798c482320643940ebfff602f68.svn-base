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
 * A Uu.
 */
@Entity
@Table(name = "uu")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "uu")
public class Uu implements Serializable {

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

    @Column(name = "rrc_connect_request")
    private Integer rrcConnectRequest;

    @Column(name = "rrc_connect_success")
    private Integer rrcConnectSuccess;

    @Column(name = "rrc_connect_success_rate")
    private Double rrcConnectSuccessRate;

    @Column(name = "rrc_reconfig_request")
    private Integer rrcReconfigRequest;

    @Column(name = "rrc_reconfig_success")
    private Integer rrcReconfigSuccess;

    @Column(name = "rrc_reconfig_success_rate")
    private Double rrcReconfigSuccessRate;

    @Column(name = "rrc_reconstruction_request")
    private Integer rrcReconstructionRequest;

    @Column(name = "rrc_reconstruction_success")
    private Integer rrcReconstructionSuccess;

    @Column(name = "rrc_reconstruction_success_rate")
    private Double rrcReconstructionSuccessRate;

    @Column(name = "rrc_release_request")
    private Integer rrcReleaseRequest;

    @Column(name = "rrc_release_success")
    private Integer rrcReleaseSuccess;

    @Column(name = "rrc_release_success_rate")
    private Double rrcReleaseSuccessRate;

    @Column(name = "sm_activate_request")
    private Integer smActivateRequest;

    @Column(name = "sm_activate_success")
    private Integer smActivateSuccess;

    @Column(name = "sm_activate_success_rate")
    private Double smActivateSuccessRate;

    @Column(name = "cell_inter_handover_request")
    private Integer cellInterHandoverRequest;

    @Column(name = "cell_inter_handover_success")
    private Integer cellInterHandoverSuccess;

    @Column(name = "cell_inter_handover_success_rate")
    private Double cellInterHandoverSuccessRate;

    @Column(name = "station_intra_handover_request")
    private Integer stationIntraHandoverRequest;

    @Column(name = "station_intra_handover_success")
    private Integer stationIntraHandoverSuccess;

    @Column(name = "station_intra_handover_success_rate")
    private Double stationIntraHandoverSuccessRate;

    @Column(name = "station_inter_handover_request")
    private Integer stationInterHandoverRequest;

    @Column(name = "station_inter_handover_success")
    private Integer stationInterHandoverSuccess;

    @Column(name = "station_inter_handover_success_rate")
    private Double stationInterHandoverSuccessRate;

    @Column(name = "rat_in_request")
    private Integer ratInRequest;

    @Column(name = "rat_in_success")
    private Integer ratInSuccess;

    @Column(name = "rat_in_success_rate")
    private Double ratInSuccessRate;

    @Column(name = "rat_out_request")
    private Integer ratOutRequest;

    @Column(name = "rat_out_success")
    private Integer ratOutSuccess;

    @Column(name = "rat_out_success_rate")
    private Double ratOutSuccessRate;

    @Column(name = "ps_paging_request")
    private Integer psPagingRequest;

    @Column(name = "ps_paging_success")
    private Integer psPagingSuccess;

    @Column(name = "ps_paging_success_rate")
    private Double psPagingSuccessRate;

    @Column(name = "cs_paging_request")
    private Integer csPagingRequest;

    @Column(name = "cs_paging_success")
    private Integer csPagingSuccess;

    @Column(name = "cs_paging_success_rate")
    private Double csPagingSuccessRate;

    @Column(name = "otherevent_request")
    private Integer othereventRequest;

    @Column(name = "otherevent_success")
    private Integer othereventSuccess;

    @Column(name = "otherevent_success_rate")
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

    public Uu pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Integer getPhour() {
        return phour;
    }

    public Uu phour(Integer phour) {
        this.phour = phour;
        return this;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public Uu cell(String cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public Uu imei(String imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public Uu imsi(String imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Integer getRrcConnectRequest() {
        return rrcConnectRequest;
    }

    public Uu rrcConnectRequest(Integer rrcConnectRequest) {
        this.rrcConnectRequest = rrcConnectRequest;
        return this;
    }

    public void setRrcConnectRequest(Integer rrcConnectRequest) {
        this.rrcConnectRequest = rrcConnectRequest;
    }

    public Integer getRrcConnectSuccess() {
        return rrcConnectSuccess;
    }

    public Uu rrcConnectSuccess(Integer rrcConnectSuccess) {
        this.rrcConnectSuccess = rrcConnectSuccess;
        return this;
    }

    public void setRrcConnectSuccess(Integer rrcConnectSuccess) {
        this.rrcConnectSuccess = rrcConnectSuccess;
    }

    public Double getRrcConnectSuccessRate() {
        return rrcConnectSuccessRate;
    }

    public Uu rrcConnectSuccessRate(Double rrcConnectSuccessRate) {
        this.rrcConnectSuccessRate = rrcConnectSuccessRate;
        return this;
    }

    public void setRrcConnectSuccessRate(Double rrcConnectSuccessRate) {
        this.rrcConnectSuccessRate = rrcConnectSuccessRate;
    }

    public Integer getRrcReconfigRequest() {
        return rrcReconfigRequest;
    }

    public Uu rrcReconfigRequest(Integer rrcReconfigRequest) {
        this.rrcReconfigRequest = rrcReconfigRequest;
        return this;
    }

    public void setRrcReconfigRequest(Integer rrcReconfigRequest) {
        this.rrcReconfigRequest = rrcReconfigRequest;
    }

    public Integer getRrcReconfigSuccess() {
        return rrcReconfigSuccess;
    }

    public Uu rrcReconfigSuccess(Integer rrcReconfigSuccess) {
        this.rrcReconfigSuccess = rrcReconfigSuccess;
        return this;
    }

    public void setRrcReconfigSuccess(Integer rrcReconfigSuccess) {
        this.rrcReconfigSuccess = rrcReconfigSuccess;
    }

    public Double getRrcReconfigSuccessRate() {
        return rrcReconfigSuccessRate;
    }

    public Uu rrcReconfigSuccessRate(Double rrcReconfigSuccessRate) {
        this.rrcReconfigSuccessRate = rrcReconfigSuccessRate;
        return this;
    }

    public void setRrcReconfigSuccessRate(Double rrcReconfigSuccessRate) {
        this.rrcReconfigSuccessRate = rrcReconfigSuccessRate;
    }

    public Integer getRrcReconstructionRequest() {
        return rrcReconstructionRequest;
    }

    public Uu rrcReconstructionRequest(Integer rrcReconstructionRequest) {
        this.rrcReconstructionRequest = rrcReconstructionRequest;
        return this;
    }

    public void setRrcReconstructionRequest(Integer rrcReconstructionRequest) {
        this.rrcReconstructionRequest = rrcReconstructionRequest;
    }

    public Integer getRrcReconstructionSuccess() {
        return rrcReconstructionSuccess;
    }

    public Uu rrcReconstructionSuccess(Integer rrcReconstructionSuccess) {
        this.rrcReconstructionSuccess = rrcReconstructionSuccess;
        return this;
    }

    public void setRrcReconstructionSuccess(Integer rrcReconstructionSuccess) {
        this.rrcReconstructionSuccess = rrcReconstructionSuccess;
    }

    public Double getRrcReconstructionSuccessRate() {
        return rrcReconstructionSuccessRate;
    }

    public Uu rrcReconstructionSuccessRate(Double rrcReconstructionSuccessRate) {
        this.rrcReconstructionSuccessRate = rrcReconstructionSuccessRate;
        return this;
    }

    public void setRrcReconstructionSuccessRate(Double rrcReconstructionSuccessRate) {
        this.rrcReconstructionSuccessRate = rrcReconstructionSuccessRate;
    }

    public Integer getRrcReleaseRequest() {
        return rrcReleaseRequest;
    }

    public Uu rrcReleaseRequest(Integer rrcReleaseRequest) {
        this.rrcReleaseRequest = rrcReleaseRequest;
        return this;
    }

    public void setRrcReleaseRequest(Integer rrcReleaseRequest) {
        this.rrcReleaseRequest = rrcReleaseRequest;
    }

    public Integer getRrcReleaseSuccess() {
        return rrcReleaseSuccess;
    }

    public Uu rrcReleaseSuccess(Integer rrcReleaseSuccess) {
        this.rrcReleaseSuccess = rrcReleaseSuccess;
        return this;
    }

    public void setRrcReleaseSuccess(Integer rrcReleaseSuccess) {
        this.rrcReleaseSuccess = rrcReleaseSuccess;
    }

    public Double getRrcReleaseSuccessRate() {
        return rrcReleaseSuccessRate;
    }

    public Uu rrcReleaseSuccessRate(Double rrcReleaseSuccessRate) {
        this.rrcReleaseSuccessRate = rrcReleaseSuccessRate;
        return this;
    }

    public void setRrcReleaseSuccessRate(Double rrcReleaseSuccessRate) {
        this.rrcReleaseSuccessRate = rrcReleaseSuccessRate;
    }

    public Integer getSmActivateRequest() {
        return smActivateRequest;
    }

    public Uu smActivateRequest(Integer smActivateRequest) {
        this.smActivateRequest = smActivateRequest;
        return this;
    }

    public void setSmActivateRequest(Integer smActivateRequest) {
        this.smActivateRequest = smActivateRequest;
    }

    public Integer getSmActivateSuccess() {
        return smActivateSuccess;
    }

    public Uu smActivateSuccess(Integer smActivateSuccess) {
        this.smActivateSuccess = smActivateSuccess;
        return this;
    }

    public void setSmActivateSuccess(Integer smActivateSuccess) {
        this.smActivateSuccess = smActivateSuccess;
    }

    public Double getSmActivateSuccessRate() {
        return smActivateSuccessRate;
    }

    public Uu smActivateSuccessRate(Double smActivateSuccessRate) {
        this.smActivateSuccessRate = smActivateSuccessRate;
        return this;
    }

    public void setSmActivateSuccessRate(Double smActivateSuccessRate) {
        this.smActivateSuccessRate = smActivateSuccessRate;
    }

    public Integer getCellInterHandoverRequest() {
        return cellInterHandoverRequest;
    }

    public Uu cellInterHandoverRequest(Integer cellInterHandoverRequest) {
        this.cellInterHandoverRequest = cellInterHandoverRequest;
        return this;
    }

    public void setCellInterHandoverRequest(Integer cellInterHandoverRequest) {
        this.cellInterHandoverRequest = cellInterHandoverRequest;
    }

    public Integer getCellInterHandoverSuccess() {
        return cellInterHandoverSuccess;
    }

    public Uu cellInterHandoverSuccess(Integer cellInterHandoverSuccess) {
        this.cellInterHandoverSuccess = cellInterHandoverSuccess;
        return this;
    }

    public void setCellInterHandoverSuccess(Integer cellInterHandoverSuccess) {
        this.cellInterHandoverSuccess = cellInterHandoverSuccess;
    }

    public Double getCellInterHandoverSuccessRate() {
        return cellInterHandoverSuccessRate;
    }

    public Uu cellInterHandoverSuccessRate(Double cellInterHandoverSuccessRate) {
        this.cellInterHandoverSuccessRate = cellInterHandoverSuccessRate;
        return this;
    }

    public void setCellInterHandoverSuccessRate(Double cellInterHandoverSuccessRate) {
        this.cellInterHandoverSuccessRate = cellInterHandoverSuccessRate;
    }

    public Integer getStationIntraHandoverRequest() {
        return stationIntraHandoverRequest;
    }

    public Uu stationIntraHandoverRequest(Integer stationIntraHandoverRequest) {
        this.stationIntraHandoverRequest = stationIntraHandoverRequest;
        return this;
    }

    public void setStationIntraHandoverRequest(Integer stationIntraHandoverRequest) {
        this.stationIntraHandoverRequest = stationIntraHandoverRequest;
    }

    public Integer getStationIntraHandoverSuccess() {
        return stationIntraHandoverSuccess;
    }

    public Uu stationIntraHandoverSuccess(Integer stationIntraHandoverSuccess) {
        this.stationIntraHandoverSuccess = stationIntraHandoverSuccess;
        return this;
    }

    public void setStationIntraHandoverSuccess(Integer stationIntraHandoverSuccess) {
        this.stationIntraHandoverSuccess = stationIntraHandoverSuccess;
    }

    public Double getStationIntraHandoverSuccessRate() {
        return stationIntraHandoverSuccessRate;
    }

    public Uu stationIntraHandoverSuccessRate(Double stationIntraHandoverSuccessRate) {
        this.stationIntraHandoverSuccessRate = stationIntraHandoverSuccessRate;
        return this;
    }

    public void setStationIntraHandoverSuccessRate(Double stationIntraHandoverSuccessRate) {
        this.stationIntraHandoverSuccessRate = stationIntraHandoverSuccessRate;
    }

    public Integer getStationInterHandoverRequest() {
        return stationInterHandoverRequest;
    }

    public Uu stationInterHandoverRequest(Integer stationInterHandoverRequest) {
        this.stationInterHandoverRequest = stationInterHandoverRequest;
        return this;
    }

    public void setStationInterHandoverRequest(Integer stationInterHandoverRequest) {
        this.stationInterHandoverRequest = stationInterHandoverRequest;
    }

    public Integer getStationInterHandoverSuccess() {
        return stationInterHandoverSuccess;
    }

    public Uu stationInterHandoverSuccess(Integer stationInterHandoverSuccess) {
        this.stationInterHandoverSuccess = stationInterHandoverSuccess;
        return this;
    }

    public void setStationInterHandoverSuccess(Integer stationInterHandoverSuccess) {
        this.stationInterHandoverSuccess = stationInterHandoverSuccess;
    }

    public Double getStationInterHandoverSuccessRate() {
        return stationInterHandoverSuccessRate;
    }

    public Uu stationInterHandoverSuccessRate(Double stationInterHandoverSuccessRate) {
        this.stationInterHandoverSuccessRate = stationInterHandoverSuccessRate;
        return this;
    }

    public void setStationInterHandoverSuccessRate(Double stationInterHandoverSuccessRate) {
        this.stationInterHandoverSuccessRate = stationInterHandoverSuccessRate;
    }

    public Integer getRatInRequest() {
        return ratInRequest;
    }

    public Uu ratInRequest(Integer ratInRequest) {
        this.ratInRequest = ratInRequest;
        return this;
    }

    public void setRatInRequest(Integer ratInRequest) {
        this.ratInRequest = ratInRequest;
    }

    public Integer getRatInSuccess() {
        return ratInSuccess;
    }

    public Uu ratInSuccess(Integer ratInSuccess) {
        this.ratInSuccess = ratInSuccess;
        return this;
    }

    public void setRatInSuccess(Integer ratInSuccess) {
        this.ratInSuccess = ratInSuccess;
    }

    public Double getRatInSuccessRate() {
        return ratInSuccessRate;
    }

    public Uu ratInSuccessRate(Double ratInSuccessRate) {
        this.ratInSuccessRate = ratInSuccessRate;
        return this;
    }

    public void setRatInSuccessRate(Double ratInSuccessRate) {
        this.ratInSuccessRate = ratInSuccessRate;
    }

    public Integer getRatOutRequest() {
        return ratOutRequest;
    }

    public Uu ratOutRequest(Integer ratOutRequest) {
        this.ratOutRequest = ratOutRequest;
        return this;
    }

    public void setRatOutRequest(Integer ratOutRequest) {
        this.ratOutRequest = ratOutRequest;
    }

    public Integer getRatOutSuccess() {
        return ratOutSuccess;
    }

    public Uu ratOutSuccess(Integer ratOutSuccess) {
        this.ratOutSuccess = ratOutSuccess;
        return this;
    }

    public void setRatOutSuccess(Integer ratOutSuccess) {
        this.ratOutSuccess = ratOutSuccess;
    }

    public Double getRatOutSuccessRate() {
        return ratOutSuccessRate;
    }

    public Uu ratOutSuccessRate(Double ratOutSuccessRate) {
        this.ratOutSuccessRate = ratOutSuccessRate;
        return this;
    }

    public void setRatOutSuccessRate(Double ratOutSuccessRate) {
        this.ratOutSuccessRate = ratOutSuccessRate;
    }

    public Integer getPsPagingRequest() {
        return psPagingRequest;
    }

    public Uu psPagingRequest(Integer psPagingRequest) {
        this.psPagingRequest = psPagingRequest;
        return this;
    }

    public void setPsPagingRequest(Integer psPagingRequest) {
        this.psPagingRequest = psPagingRequest;
    }

    public Integer getPsPagingSuccess() {
        return psPagingSuccess;
    }

    public Uu psPagingSuccess(Integer psPagingSuccess) {
        this.psPagingSuccess = psPagingSuccess;
        return this;
    }

    public void setPsPagingSuccess(Integer psPagingSuccess) {
        this.psPagingSuccess = psPagingSuccess;
    }

    public Double getPsPagingSuccessRate() {
        return psPagingSuccessRate;
    }

    public Uu psPagingSuccessRate(Double psPagingSuccessRate) {
        this.psPagingSuccessRate = psPagingSuccessRate;
        return this;
    }

    public void setPsPagingSuccessRate(Double psPagingSuccessRate) {
        this.psPagingSuccessRate = psPagingSuccessRate;
    }

    public Integer getCsPagingRequest() {
        return csPagingRequest;
    }

    public Uu csPagingRequest(Integer csPagingRequest) {
        this.csPagingRequest = csPagingRequest;
        return this;
    }

    public void setCsPagingRequest(Integer csPagingRequest) {
        this.csPagingRequest = csPagingRequest;
    }

    public Integer getCsPagingSuccess() {
        return csPagingSuccess;
    }

    public Uu csPagingSuccess(Integer csPagingSuccess) {
        this.csPagingSuccess = csPagingSuccess;
        return this;
    }

    public void setCsPagingSuccess(Integer csPagingSuccess) {
        this.csPagingSuccess = csPagingSuccess;
    }

    public Double getCsPagingSuccessRate() {
        return csPagingSuccessRate;
    }

    public Uu csPagingSuccessRate(Double csPagingSuccessRate) {
        this.csPagingSuccessRate = csPagingSuccessRate;
        return this;
    }

    public void setCsPagingSuccessRate(Double csPagingSuccessRate) {
        this.csPagingSuccessRate = csPagingSuccessRate;
    }

    public Integer getOthereventRequest() {
        return othereventRequest;
    }

    public Uu othereventRequest(Integer othereventRequest) {
        this.othereventRequest = othereventRequest;
        return this;
    }

    public void setOthereventRequest(Integer othereventRequest) {
        this.othereventRequest = othereventRequest;
    }

    public Integer getOthereventSuccess() {
        return othereventSuccess;
    }

    public Uu othereventSuccess(Integer othereventSuccess) {
        this.othereventSuccess = othereventSuccess;
        return this;
    }

    public void setOthereventSuccess(Integer othereventSuccess) {
        this.othereventSuccess = othereventSuccess;
    }

    public Double getOthereventSuccessRate() {
        return othereventSuccessRate;
    }

    public Uu othereventSuccessRate(Double othereventSuccessRate) {
        this.othereventSuccessRate = othereventSuccessRate;
        return this;
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
        Uu uu = (Uu) o;
        if (uu.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), uu.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Uu{" +
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
