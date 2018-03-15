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
 * A X2.
 */
@Entity
@Table(name = "x_2")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "x2")
public class X2 implements Serializable {

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

    @Column(name = "switch_request")
    private Long switchRequest;

    @Column(name = "switch_success")
    private Long switchSuccess;

    @Column(name = "switch_success_rate")
    private Double switchSuccessRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public X2 pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Integer getPhour() {
        return phour;
    }

    public X2 phour(Integer phour) {
        this.phour = phour;
        return this;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public X2 cell(String cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public X2 imei(String imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public X2 imsi(String imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getSwitchRequest() {
        return switchRequest;
    }

    public X2 switchRequest(Long switchRequest) {
        this.switchRequest = switchRequest;
        return this;
    }

    public void setSwitchRequest(Long switchRequest) {
        this.switchRequest = switchRequest;
    }

    public Long getSwitchSuccess() {
        return switchSuccess;
    }

    public X2 switchSuccess(Long switchSuccess) {
        this.switchSuccess = switchSuccess;
        return this;
    }

    public void setSwitchSuccess(Long switchSuccess) {
        this.switchSuccess = switchSuccess;
    }

    public Double getSwitchSuccessRate() {
        return switchSuccessRate;
    }

    public X2 switchSuccessRate(Double switchSuccessRate) {
        this.switchSuccessRate = switchSuccessRate;
        return this;
    }

    public void setSwitchSuccessRate(Double switchSuccessRate) {
        this.switchSuccessRate = switchSuccessRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        X2 x2 = (X2) o;
        if (x2.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), x2.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "X2{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", phour='" + getPhour() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", switchRequest='" + getSwitchRequest() + "'" +
            ", switchSuccess='" + getSwitchSuccess() + "'" +
            ", switchSuccessRate='" + getSwitchSuccessRate() + "'" +
            "}";
    }
}
