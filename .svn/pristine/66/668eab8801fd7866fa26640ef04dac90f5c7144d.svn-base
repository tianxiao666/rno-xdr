package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ExceptionCause entity.
 */
public class ExceptionCauseDTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Long cell;

    private Long imei;

    private Long imsi;

    private String indicatorType;

    private Integer cause;

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

    public String getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(String indicatorType) {
        this.indicatorType = indicatorType;
    }

    public Integer getCause() {
        return cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    public Integer getCauseCount() {
        return causeCount;
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

        ExceptionCauseDTO exceptionCauseDTO = (ExceptionCauseDTO) o;
        if(exceptionCauseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exceptionCauseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExceptionCauseDTO{" +
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
