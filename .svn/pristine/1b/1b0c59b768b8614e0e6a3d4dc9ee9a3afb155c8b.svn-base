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
 * A Mr.
 */
@Entity
@Table(name = "mr")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "mr")
public class Mr implements Serializable {

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

    @Column(name = "rsrp_sum")
    private Long rsrpSum;

    @Column(name = "rsrp_count")
    private Long rsrpCount;

    @Column(name = "rsrp_avg")
    private Double rsrpAvg;

    @Column(name = "rsrq_sum")
    private Long rsrqSum;

    @Column(name = "rsrq_count")
    private Long rsrqCount;

    @Column(name = "rsrq_avg")
    private Double rsrqAvg;

    @Column(name = "ulsinr_sum")
    private Long ulsinrSum;

    @Column(name = "ulsinr_count")
    private Long ulsinrCount;

    @Column(name = "ulsinr_avg")
    private Double ulsinrAvg;

    @Column(name = "phr_sum")
    private Long phrSum;

    @Column(name = "phr_count")
    private Long phrCount;

    @Column(name = "phr_avg")
    private Double phrAvg;

    @Column(name = "erp_sum")
    private Long erpSum;

    @Column(name = "erp_count")
    private Long erpCount;

    @Column(name = "erp_avg")
    private Double erpAvg;

    @Column(name = "ta_sum")
    private Long taSum;

    @Column(name = "ta_count")
    private Long taCount;

    @Column(name = "ta_avg")
    private Double taAvg;

    @Column(name = "overlap_sum")
    private Long overlapSum;

    @Column(name = "overlap_count")
    private Long overlapCount;

    @Column(name = "overlap_avg")
    private Double overlapAvg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPdate() {
        return pdate;
    }

    public Mr pdate(LocalDate pdate) {
        this.pdate = pdate;
        return this;
    }

    public void setPdate(LocalDate pdate) {
        this.pdate = pdate;
    }

    public Integer getPhour() {
        return phour;
    }

    public Mr phour(Integer phour) {
        this.phour = phour;
        return this;
    }

    public void setPhour(Integer phour) {
        this.phour = phour;
    }

    public String getCell() {
        return cell;
    }

    public Mr cell(String cell) {
        this.cell = cell;
        return this;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getImei() {
        return imei;
    }

    public Mr imei(String imei) {
        this.imei = imei;
        return this;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public Mr imsi(String imsi) {
        this.imsi = imsi;
        return this;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getRsrpSum() {
        return rsrpSum;
    }

    public Mr rsrpSum(Long rsrpSum) {
        this.rsrpSum = rsrpSum;
        return this;
    }

    public void setRsrpSum(Long rsrpSum) {
        this.rsrpSum = rsrpSum;
    }

    public Long getRsrpCount() {
        return rsrpCount;
    }

    public Mr rsrpCount(Long rsrpCount) {
        this.rsrpCount = rsrpCount;
        return this;
    }

    public void setRsrpCount(Long rsrpCount) {
        this.rsrpCount = rsrpCount;
    }

    public Double getRsrpAvg() {
        return rsrpAvg;
    }

    public Mr rsrpAvg(Double rsrpAvg) {
        this.rsrpAvg = rsrpAvg;
        return this;
    }

    public void setRsrpAvg(Double rsrpAvg) {
        this.rsrpAvg = rsrpAvg;
    }

    public Long getRsrqSum() {
        return rsrqSum;
    }

    public Mr rsrqSum(Long rsrqSum) {
        this.rsrqSum = rsrqSum;
        return this;
    }

    public void setRsrqSum(Long rsrqSum) {
        this.rsrqSum = rsrqSum;
    }

    public Long getRsrqCount() {
        return rsrqCount;
    }

    public Mr rsrqCount(Long rsrqCount) {
        this.rsrqCount = rsrqCount;
        return this;
    }

    public void setRsrqCount(Long rsrqCount) {
        this.rsrqCount = rsrqCount;
    }

    public Double getRsrqAvg() {
        return rsrqAvg;
    }

    public Mr rsrqAvg(Double rsrqAvg) {
        this.rsrqAvg = rsrqAvg;
        return this;
    }

    public void setRsrqAvg(Double rsrqAvg) {
        this.rsrqAvg = rsrqAvg;
    }

    public Long getUlsinrSum() {
        return ulsinrSum;
    }

    public Mr ulsinrSum(Long ulsinrSum) {
        this.ulsinrSum = ulsinrSum;
        return this;
    }

    public void setUlsinrSum(Long ulsinrSum) {
        this.ulsinrSum = ulsinrSum;
    }

    public Long getUlsinrCount() {
        return ulsinrCount;
    }

    public Mr ulsinrCount(Long ulsinrCount) {
        this.ulsinrCount = ulsinrCount;
        return this;
    }

    public void setUlsinrCount(Long ulsinrCount) {
        this.ulsinrCount = ulsinrCount;
    }

    public Double getUlsinrAvg() {
        return ulsinrAvg;
    }

    public Mr ulsinrAvg(Double ulsinrAvg) {
        this.ulsinrAvg = ulsinrAvg;
        return this;
    }

    public void setUlsinrAvg(Double ulsinrAvg) {
        this.ulsinrAvg = ulsinrAvg;
    }

    public Long getPhrSum() {
        return phrSum;
    }

    public Mr phrSum(Long phrSum) {
        this.phrSum = phrSum;
        return this;
    }

    public void setPhrSum(Long phrSum) {
        this.phrSum = phrSum;
    }

    public Long getPhrCount() {
        return phrCount;
    }

    public Mr phrCount(Long phrCount) {
        this.phrCount = phrCount;
        return this;
    }

    public void setPhrCount(Long phrCount) {
        this.phrCount = phrCount;
    }

    public Double getPhrAvg() {
        return phrAvg;
    }

    public Mr phrAvg(Double phrAvg) {
        this.phrAvg = phrAvg;
        return this;
    }

    public void setPhrAvg(Double phrAvg) {
        this.phrAvg = phrAvg;
    }

    public Long getErpSum() {
        return erpSum;
    }

    public Mr erpSum(Long erpSum) {
        this.erpSum = erpSum;
        return this;
    }

    public void setErpSum(Long erpSum) {
        this.erpSum = erpSum;
    }

    public Long getErpCount() {
        return erpCount;
    }

    public Mr erpCount(Long erpCount) {
        this.erpCount = erpCount;
        return this;
    }

    public void setErpCount(Long erpCount) {
        this.erpCount = erpCount;
    }

    public Double getErpAvg() {
        return erpAvg;
    }

    public Mr erpAvg(Double erpAvg) {
        this.erpAvg = erpAvg;
        return this;
    }

    public void setErpAvg(Double erpAvg) {
        this.erpAvg = erpAvg;
    }

    public Long getTaSum() {
        return taSum;
    }

    public Mr taSum(Long taSum) {
        this.taSum = taSum;
        return this;
    }

    public void setTaSum(Long taSum) {
        this.taSum = taSum;
    }

    public Long getTaCount() {
        return taCount;
    }

    public Mr taCount(Long taCount) {
        this.taCount = taCount;
        return this;
    }

    public void setTaCount(Long taCount) {
        this.taCount = taCount;
    }

    public Double getTaAvg() {
        return taAvg;
    }

    public Mr taAvg(Double taAvg) {
        this.taAvg = taAvg;
        return this;
    }

    public void setTaAvg(Double taAvg) {
        this.taAvg = taAvg;
    }

    public Long getOverlapSum() {
        return overlapSum;
    }

    public Mr overlapSum(Long overlapSum) {
        this.overlapSum = overlapSum;
        return this;
    }

    public void setOverlapSum(Long overlapSum) {
        this.overlapSum = overlapSum;
    }

    public Long getOverlapCount() {
        return overlapCount;
    }

    public Mr overlapCount(Long overlapCount) {
        this.overlapCount = overlapCount;
        return this;
    }

    public void setOverlapCount(Long overlapCount) {
        this.overlapCount = overlapCount;
    }

    public Double getOverlapAvg() {
        return overlapAvg;
    }

    public Mr overlapAvg(Double overlapAvg) {
        this.overlapAvg = overlapAvg;
        return this;
    }

    public void setOverlapAvg(Double overlapAvg) {
        this.overlapAvg = overlapAvg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mr mr = (Mr) o;
        if (mr.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mr.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Mr{" +
            "id=" + getId() +
            ", pdate='" + getPdate() + "'" +
            ", phour='" + getPhour() + "'" +
            ", cell='" + getCell() + "'" +
            ", imei='" + getImei() + "'" +
            ", imsi='" + getImsi() + "'" +
            ", rsrpSum='" + getRsrpSum() + "'" +
            ", rsrpCount='" + getRsrpCount() + "'" +
            ", rsrpAvg='" + getRsrpAvg() + "'" +
            ", rsrqSum='" + getRsrqSum() + "'" +
            ", rsrqCount='" + getRsrqCount() + "'" +
            ", rsrqAvg='" + getRsrqAvg() + "'" +
            ", ulsinrSum='" + getUlsinrSum() + "'" +
            ", ulsinrCount='" + getUlsinrCount() + "'" +
            ", ulsinrAvg='" + getUlsinrAvg() + "'" +
            ", phrSum='" + getPhrSum() + "'" +
            ", phrCount='" + getPhrCount() + "'" +
            ", phrAvg='" + getPhrAvg() + "'" +
            ", erpSum='" + getErpSum() + "'" +
            ", erpCount='" + getErpCount() + "'" +
            ", erpAvg='" + getErpAvg() + "'" +
            ", taSum='" + getTaSum() + "'" +
            ", taCount='" + getTaCount() + "'" +
            ", taAvg='" + getTaAvg() + "'" +
            ", overlapSum='" + getOverlapSum() + "'" +
            ", overlapCount='" + getOverlapCount() + "'" +
            ", overlapAvg='" + getOverlapAvg() + "'" +
            "}";
    }
}
