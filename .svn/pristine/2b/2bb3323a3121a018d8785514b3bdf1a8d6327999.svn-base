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
 * A Track.
 */
@Entity
@Table(name = "track")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "track")
public class Track implements Serializable {

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

    @Column(name = "cell")
    private Long cell;

    @Column(name = "imei")
    private Long imei;

    @Column(name = "imsi")
    private Long imsi;

    @Column(name = "msisdn")
    private Long msisdn;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "indicator_type")
    private String indicatorType;

    @Column(name = "status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public Track pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Track startTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Track endTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCell() {
        return cell;
    }

    public Track cell(Long cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public Long getImei() {
        return imei;
    }

    public Track imei(Long imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public Track imsi(Long imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public Track msisdn(Long msisdn) {
        this.msisdn = msisdn;
        return this;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public Double getLon() {
        return lon;
    }

    public Track lon(Double lon) {
        this.lon = lon;
        return this;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Track lat(Double lat) {
        this.lat = lat;
        return this;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getIndicatorType() {
        return indicatorType;
    }

    public Track indicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
        return this;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public Integer getStatus() {
        return status;
    }

    public Track status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        if (track.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), track.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Track{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", msisdn='" + getMsisdn() + "'" +
            ", lon='" + getLon() + "'" +
            ", lat='" + getLat() + "'" +
            ", indicatorType='" + getIndicatorType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
