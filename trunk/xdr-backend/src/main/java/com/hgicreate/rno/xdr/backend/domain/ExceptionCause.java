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
 * A ExceptionCause.
 */
@Entity
@Table(name = "exception_cause")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "exceptioncause")
public class ExceptionCause implements Serializable {

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

    @Column(name = "indicator_type")
    private String indicatorType;

    @Column(name = "cause")
    private Integer cause;

    @Column(name = "cause_count")
    private Integer causeCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public ExceptionCause pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Long getCell() {
        return cell;
    }

    public ExceptionCause cell(Long cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public Long getImei() {
        return imei;
    }

    public ExceptionCause imei(Long imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public ExceptionCause imsi(Long imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public String getIndicatorType() {
        return indicatorType;
    }

    public ExceptionCause indicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
        return this;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public Integer getCause() {
        return cause;
    }

    public ExceptionCause cause(Integer cause) {
        this.cause = cause;
        return this;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    public Integer getCauseCount() {
        return causeCount;
    }

    public ExceptionCause causeCount(Integer causeCount) {
        this.causeCount = causeCount;
        return this;
    }

    public void setCauseCount(Integer causeCount) {
        this.causeCount = causeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExceptionCause exceptionCause = (ExceptionCause) o;
        if (exceptionCause.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exceptionCause.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExceptionCause{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", indicatorType='" + getIndicatorType() + "'" +
            ", cause='" + getCause() + "'" +
            ", causeCount='" + getCauseCount() + "'" +
            "}";
    }
}
