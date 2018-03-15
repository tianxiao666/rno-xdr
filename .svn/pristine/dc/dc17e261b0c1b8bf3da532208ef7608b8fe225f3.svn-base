package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the X2 entity.
 */
public class X2DTO implements Serializable {

    private Long id;

    @NotNull
    private LocalDate pdate;

    private Integer phour;

    private String cell;

    private String imei;

    private String imsi;

    private Long switchRequest;

    private Long switchSuccess;

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

    public Long getSwitchRequest() {
        return switchRequest;
    }

    public void setSwitchRequest(Long switchRequest) {
        this.switchRequest = switchRequest;
    }

    public Long getSwitchSuccess() {
        return switchSuccess;
    }

    public void setSwitchSuccess(Long switchSuccess) {
        this.switchSuccess = switchSuccess;
    }

    public Double getSwitchSuccessRate() {
        return switchSuccessRate;
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

        X2DTO x2DTO = (X2DTO) o;
        if(x2DTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), x2DTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "X2DTO{" +
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
