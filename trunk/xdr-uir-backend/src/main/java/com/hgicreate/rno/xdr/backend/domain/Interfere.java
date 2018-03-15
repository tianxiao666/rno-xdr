package com.hgicreate.rno.xdr.backend.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 干扰数据
 */
@ApiModel(description = "干扰数据")
@Entity
@Table(name = "rno_uir_interfere_data")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "interfere")
public class Interfere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "time")
    private Instant time;

    @NotNull
    @Column(name = "file_id", nullable = false)
    private Long fileId;

    @NotNull
    @Column(name = "area_id", nullable = false)
    private Long areaId;

    @NotNull
    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "factory")
    private String factory;

    @Column(name = "enodeb")
    private String enodeb;

    @Column(name = "cell_name")
    private String cellName;

    @Column(name = "cell_identifier")
    private Integer cellIdendifier;

    @Column(name = "cover_type")
    private String coverType;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "working_band")
    private String workBand;

    @Column(name = "carrier_frequency")
    private Double carrierFrequency;

    @NotNull
    @Column(name = "prb0", nullable = false)
    private Double prb0;

    @NotNull
    @Column(name = "prb1", nullable = false)
    private Double prb1;

    @NotNull
    @Column(name = "prb2", nullable = false)
    private Double prb2;

    @NotNull
    @Column(name = "prb3", nullable = false)
    private Double prb3;

    @NotNull
    @Column(name = "prb4", nullable = false)
    private Double prb4;

    @NotNull
    @Column(name = "prb5", nullable = false)
    private Double prb5;

    @NotNull
    @Column(name = "prb6", nullable = false)
    private Double prb6;

    @NotNull
    @Column(name = "prb7", nullable = false)
    private Double prb7;

    @NotNull
    @Column(name = "prb8", nullable = false)
    private Double prb8;

    @NotNull
    @Column(name = "prb9", nullable = false)
    private Double prb9;

    @NotNull
    @Column(name = "prb10", nullable = false)
    private Double prb10;

    @NotNull
    @Column(name = "prb11", nullable = false)
    private Double prb11;

    @NotNull
    @Column(name = "prb12", nullable = false)
    private Double prb12;

    @NotNull
    @Column(name = "prb13", nullable = false)
    private Double prb13;

    @NotNull
    @Column(name = "prb14", nullable = false)
    private Double prb14;

    @NotNull
    @Column(name = "prb15", nullable = false)
    private Double prb15;

    @NotNull
    @Column(name = "prb16", nullable = false)
    private Double prb16;

    @NotNull
    @Column(name = "prb17", nullable = false)
    private Double prb17;

    @NotNull
    @Column(name = "prb18", nullable = false)
    private Double prb18;

    @NotNull
    @Column(name = "prb19", nullable = false)
    private Double prb19;

    @NotNull
    @Column(name = "prb20", nullable = false)
    private Double prb20;

    @NotNull
    @Column(name = "prb21", nullable = false)
    private Double prb21;

    @NotNull
    @Column(name = "prb22", nullable = false)
    private Double prb22;

    @NotNull
    @Column(name = "prb23", nullable = false)
    private Double prb23;

    @NotNull
    @Column(name = "prb24", nullable = false)
    private Double prb24;

    @NotNull
    @Column(name = "prb25", nullable = false)
    private Double prb25;

    @NotNull
    @Column(name = "prb26", nullable = false)
    private Double prb26;

    @NotNull
    @Column(name = "prb27", nullable = false)
    private Double prb27;

    @NotNull
    @Column(name = "prb28", nullable = false)
    private Double prb28;

    @NotNull
    @Column(name = "prb29", nullable = false)
    private Double prb29;

    @NotNull
    @Column(name = "prb30", nullable = false)
    private Double prb30;

    @NotNull
    @Column(name = "prb31", nullable = false)
    private Double prb31;

    @NotNull
    @Column(name = "prb32", nullable = false)
    private Double prb32;

    @NotNull
    @Column(name = "prb33", nullable = false)
    private Double prb33;

    @NotNull
    @Column(name = "prb34", nullable = false)
    private Double prb34;

    @NotNull
    @Column(name = "prb35", nullable = false)
    private Double prb35;

    @NotNull
    @Column(name = "prb36", nullable = false)
    private Double prb36;

    @NotNull
    @Column(name = "prb37", nullable = false)
    private Double prb37;

    @NotNull
    @Column(name = "prb38", nullable = false)
    private Double prb38;

    @NotNull
    @Column(name = "prb39", nullable = false)
    private Double prb39;

    @NotNull
    @Column(name = "prb40", nullable = false)
    private Double prb40;

    @NotNull
    @Column(name = "prb41", nullable = false)
    private Double prb41;

    @NotNull
    @Column(name = "prb42", nullable = false)
    private Double prb42;

    @NotNull
    @Column(name = "prb43", nullable = false)
    private Double prb43;

    @NotNull
    @Column(name = "prb44", nullable = false)
    private Double prb44;

    @NotNull
    @Column(name = "prb45", nullable = false)
    private Double prb45;

    @NotNull
    @Column(name = "prb46", nullable = false)
    private Double prb46;

    @NotNull
    @Column(name = "prb47", nullable = false)
    private Double prb47;

    @NotNull
    @Column(name = "prb48", nullable = false)
    private Double prb48;

    @NotNull
    @Column(name = "prb49", nullable = false)
    private Double prb49;

    @NotNull
    @Column(name = "prb50", nullable = false)
    private Double prb50;

    @NotNull
    @Column(name = "prb51", nullable = false)
    private Double prb51;

    @NotNull
    @Column(name = "prb52", nullable = false)
    private Double prb52;

    @NotNull
    @Column(name = "prb53", nullable = false)
    private Double prb53;

    @NotNull
    @Column(name = "prb54", nullable = false)
    private Double prb54;

    @NotNull
    @Column(name = "prb55", nullable = false)
    private Double prb55;

    @NotNull
    @Column(name = "prb56", nullable = false)
    private Double prb56;

    @NotNull
    @Column(name = "prb57", nullable = false)
    private Double prb57;

    @NotNull
    @Column(name = "prb58", nullable = false)
    private Double prb58;

    @NotNull
    @Column(name = "prb59", nullable = false)
    private Double prb59;

    @NotNull
    @Column(name = "prb60", nullable = false)
    private Double prb60;

    @NotNull
    @Column(name = "prb61", nullable = false)
    private Double prb61;

    @NotNull
    @Column(name = "prb62", nullable = false)
    private Double prb62;

    @NotNull
    @Column(name = "prb63", nullable = false)
    private Double prb63;

    @NotNull
    @Column(name = "prb64", nullable = false)
    private Double prb64;

    @NotNull
    @Column(name = "prb65", nullable = false)
    private Double prb65;

    @NotNull
    @Column(name = "prb66", nullable = false)
    private Double prb66;

    @NotNull
    @Column(name = "prb67", nullable = false)
    private Double prb67;

    @NotNull
    @Column(name = "prb68", nullable = false)
    private Double prb68;

    @NotNull
    @Column(name = "prb69", nullable = false)
    private Double prb69;

    @NotNull
    @Column(name = "prb70", nullable = false)
    private Double prb70;

    @NotNull
    @Column(name = "prb71", nullable = false)
    private Double prb71;

    @NotNull
    @Column(name = "prb72", nullable = false)
    private Double prb72;

    @NotNull
    @Column(name = "prb73", nullable = false)
    private Double prb73;

    @NotNull
    @Column(name = "prb74", nullable = false)
    private Double prb74;

    @NotNull
    @Column(name = "prb75", nullable = false)
    private Double prb75;

    @NotNull
    @Column(name = "prb76", nullable = false)
    private Double prb76;

    @NotNull
    @Column(name = "prb77", nullable = false)
    private Double prb77;

    @NotNull
    @Column(name = "prb78", nullable = false)
    private Double prb78;

    @NotNull
    @Column(name = "prb79", nullable = false)
    private Double prb79;

    @NotNull
    @Column(name = "prb80", nullable = false)
    private Double prb80;

    @NotNull
    @Column(name = "prb81", nullable = false)
    private Double prb81;

    @NotNull
    @Column(name = "prb82", nullable = false)
    private Double prb82;

    @NotNull
    @Column(name = "prb83", nullable = false)
    private Double prb83;

    @NotNull
    @Column(name = "prb84", nullable = false)
    private Double prb84;

    @NotNull
    @Column(name = "prb85", nullable = false)
    private Double prb85;

    @NotNull
    @Column(name = "prb86", nullable = false)
    private Double prb86;

    @NotNull
    @Column(name = "prb87", nullable = false)
    private Double prb87;

    @NotNull
    @Column(name = "prb88", nullable = false)
    private Double prb88;

    @NotNull
    @Column(name = "prb89", nullable = false)
    private Double prb89;

    @NotNull
    @Column(name = "prb90", nullable = false)
    private Double prb90;

    @NotNull
    @Column(name = "prb91", nullable = false)
    private Double prb91;

    @NotNull
    @Column(name = "prb92", nullable = false)
    private Double prb92;

    @NotNull
    @Column(name = "prb93", nullable = false)
    private Double prb93;

    @NotNull
    @Column(name = "prb94", nullable = false)
    private Double prb94;

    @NotNull
    @Column(name = "prb95", nullable = false)
    private Double prb95;

    @NotNull
    @Column(name = "prb96", nullable = false)
    private Double prb96;

    @NotNull
    @Column(name = "prb97", nullable = false)
    private Double prb97;

    @NotNull
    @Column(name = "prb98", nullable = false)
    private Double prb98;

    @NotNull
    @Column(name = "prb99", nullable = false)
    private Double prb99;

    @Column(name = "average_interfere")
    private Double averageInterfere;

    @Column(name = "first_rb")
    private Double firstRb;

    @Column(name = "second_rb")
    private Double secondRb;

    @Column(name = "third_rb")
    private Double thirdRb;

    @Column(name = "fourth_rb")
    private Double fourthRb;

    @Column(name = "fifth_rb")
    private Double fifthRb;

    @Column(name = "interfered_rb")
    private Double interferedRb;

    @Column(name = "interfere_coefficient")
    private Double interfereCoefficient;

    @Column(name = "interfere_grade")
    private String interfereGrade;

    @Column(name = "interfere_type")
    private String interfereType;

    @Column(name = "solve_type")
    private String solveType;

    public String getSolveType() {
        return solveType;
    }

    public void setSolveType(String solveType) {
        this.solveType = solveType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public Interfere time(Instant time) {
        this.time = time;
        return this;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public Long getFileId() {
        return fileId;
    }

    public Interfere fileId(Long fileId) {
        this.fileId = fileId;
        return this;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public Interfere areaId(Long areaId) {
        this.areaId = areaId;
        return this;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Interfere taskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getFactory() {
        return factory;
    }

    public Interfere factory(String factory) {
        this.factory = factory;
        return this;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getEnodeb() {
        return enodeb;
    }

    public Interfere enodeb(String enodeb) {
        this.enodeb = enodeb;
        return this;
    }

    public void setEnodeb(String enodeb) {
        this.enodeb = enodeb;
    }

    public String getCellName() {
        return cellName;
    }

    public Interfere cellName(String cellName) {
        this.cellName = cellName;
        return this;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public Integer getCellIdendifier() {
        return cellIdendifier;
    }

    public Interfere cellIdendifier(Integer cellIdendifier) {
        this.cellIdendifier = cellIdendifier;
        return this;
    }

    public void setCellIdendifier(Integer cellIdendifier) {
        this.cellIdendifier = cellIdendifier;
    }

    public String getCoverType() {
        return coverType;
    }

    public Interfere coverType(String coverType) {
        this.coverType = coverType;
        return this;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Interfere longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Interfere latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getWorkBand() {
        return workBand;
    }

    public Interfere workBand(String workBand) {
        this.workBand = workBand;
        return this;
    }

    public void setWorkBand(String workBand) {
        this.workBand = workBand;
    }

    public Double getCarrierFrequency() {
        return carrierFrequency;
    }

    public Interfere carrierFrequency(Double carrierFrequency) {
        this.carrierFrequency = carrierFrequency;
        return this;
    }

    public void setCarrierFrequency(Double carrierFrequency) {
        this.carrierFrequency = carrierFrequency;
    }

    public Double getPrb0() {
        return prb0;
    }

    public Interfere prb0(Double prb0) {
        this.prb0 = prb0;
        return this;
    }

    public void setPrb0(Double prb0) {
        this.prb0 = prb0;
    }

    public Double getPrb1() {
        return prb1;
    }

    public Interfere prb1(Double prb1) {
        this.prb1 = prb1;
        return this;
    }

    public void setPrb1(Double prb1) {
        this.prb1 = prb1;
    }

    public Double getPrb2() {
        return prb2;
    }

    public Interfere prb2(Double prb2) {
        this.prb2 = prb2;
        return this;
    }

    public void setPrb2(Double prb2) {
        this.prb2 = prb2;
    }

    public Double getPrb3() {
        return prb3;
    }

    public Interfere prb3(Double prb3) {
        this.prb3 = prb3;
        return this;
    }

    public void setPrb3(Double prb3) {
        this.prb3 = prb3;
    }

    public Double getPrb4() {
        return prb4;
    }

    public Interfere prb4(Double prb4) {
        this.prb4 = prb4;
        return this;
    }

    public void setPrb4(Double prb4) {
        this.prb4 = prb4;
    }

    public Double getPrb5() {
        return prb5;
    }

    public Interfere prb5(Double prb5) {
        this.prb5 = prb5;
        return this;
    }

    public void setPrb5(Double prb5) {
        this.prb5 = prb5;
    }

    public Double getPrb6() {
        return prb6;
    }

    public Interfere prb6(Double prb6) {
        this.prb6 = prb6;
        return this;
    }

    public void setPrb6(Double prb6) {
        this.prb6 = prb6;
    }

    public Double getPrb7() {
        return prb7;
    }

    public Interfere prb7(Double prb7) {
        this.prb7 = prb7;
        return this;
    }

    public void setPrb7(Double prb7) {
        this.prb7 = prb7;
    }

    public Double getPrb8() {
        return prb8;
    }

    public Interfere prb8(Double prb8) {
        this.prb8 = prb8;
        return this;
    }

    public void setPrb8(Double prb8) {
        this.prb8 = prb8;
    }

    public Double getPrb9() {
        return prb9;
    }

    public Interfere prb9(Double prb9) {
        this.prb9 = prb9;
        return this;
    }

    public void setPrb9(Double prb9) {
        this.prb9 = prb9;
    }

    public Double getPrb10() {
        return prb10;
    }

    public Interfere prb10(Double prb10) {
        this.prb10 = prb10;
        return this;
    }

    public void setPrb10(Double prb10) {
        this.prb10 = prb10;
    }

    public Double getPrb11() {
        return prb11;
    }

    public Interfere prb11(Double prb11) {
        this.prb11 = prb11;
        return this;
    }

    public void setPrb11(Double prb11) {
        this.prb11 = prb11;
    }

    public Double getPrb12() {
        return prb12;
    }

    public Interfere prb12(Double prb12) {
        this.prb12 = prb12;
        return this;
    }

    public void setPrb12(Double prb12) {
        this.prb12 = prb12;
    }

    public Double getPrb13() {
        return prb13;
    }

    public Interfere prb13(Double prb13) {
        this.prb13 = prb13;
        return this;
    }

    public void setPrb13(Double prb13) {
        this.prb13 = prb13;
    }

    public Double getPrb14() {
        return prb14;
    }

    public Interfere prb14(Double prb14) {
        this.prb14 = prb14;
        return this;
    }

    public void setPrb14(Double prb14) {
        this.prb14 = prb14;
    }

    public Double getPrb15() {
        return prb15;
    }

    public Interfere prb15(Double prb15) {
        this.prb15 = prb15;
        return this;
    }

    public void setPrb15(Double prb15) {
        this.prb15 = prb15;
    }

    public Double getPrb16() {
        return prb16;
    }

    public Interfere prb16(Double prb16) {
        this.prb16 = prb16;
        return this;
    }

    public void setPrb16(Double prb16) {
        this.prb16 = prb16;
    }

    public Double getPrb17() {
        return prb17;
    }

    public Interfere prb17(Double prb17) {
        this.prb17 = prb17;
        return this;
    }

    public void setPrb17(Double prb17) {
        this.prb17 = prb17;
    }

    public Double getPrb18() {
        return prb18;
    }

    public Interfere prb18(Double prb18) {
        this.prb18 = prb18;
        return this;
    }

    public void setPrb18(Double prb18) {
        this.prb18 = prb18;
    }

    public Double getPrb19() {
        return prb19;
    }

    public Interfere prb19(Double prb19) {
        this.prb19 = prb19;
        return this;
    }

    public void setPrb19(Double prb19) {
        this.prb19 = prb19;
    }

    public Double getPrb20() {
        return prb20;
    }

    public Interfere prb20(Double prb20) {
        this.prb20 = prb20;
        return this;
    }

    public void setPrb20(Double prb20) {
        this.prb20 = prb20;
    }

    public Double getPrb21() {
        return prb21;
    }

    public Interfere prb21(Double prb21) {
        this.prb21 = prb21;
        return this;
    }

    public void setPrb21(Double prb21) {
        this.prb21 = prb21;
    }

    public Double getPrb22() {
        return prb22;
    }

    public Interfere prb22(Double prb22) {
        this.prb22 = prb22;
        return this;
    }

    public void setPrb22(Double prb22) {
        this.prb22 = prb22;
    }

    public Double getPrb23() {
        return prb23;
    }

    public Interfere prb23(Double prb23) {
        this.prb23 = prb23;
        return this;
    }

    public void setPrb23(Double prb23) {
        this.prb23 = prb23;
    }

    public Double getPrb24() {
        return prb24;
    }

    public Interfere prb24(Double prb24) {
        this.prb24 = prb24;
        return this;
    }

    public void setPrb24(Double prb24) {
        this.prb24 = prb24;
    }

    public Double getPrb25() {
        return prb25;
    }

    public Interfere prb25(Double prb25) {
        this.prb25 = prb25;
        return this;
    }

    public void setPrb25(Double prb25) {
        this.prb25 = prb25;
    }

    public Double getPrb26() {
        return prb26;
    }

    public Interfere prb26(Double prb26) {
        this.prb26 = prb26;
        return this;
    }

    public void setPrb26(Double prb26) {
        this.prb26 = prb26;
    }

    public Double getPrb27() {
        return prb27;
    }

    public Interfere prb27(Double prb27) {
        this.prb27 = prb27;
        return this;
    }

    public void setPrb27(Double prb27) {
        this.prb27 = prb27;
    }

    public Double getPrb28() {
        return prb28;
    }

    public Interfere prb28(Double prb28) {
        this.prb28 = prb28;
        return this;
    }

    public void setPrb28(Double prb28) {
        this.prb28 = prb28;
    }

    public Double getPrb29() {
        return prb29;
    }

    public Interfere prb29(Double prb29) {
        this.prb29 = prb29;
        return this;
    }

    public void setPrb29(Double prb29) {
        this.prb29 = prb29;
    }

    public Double getPrb30() {
        return prb30;
    }

    public Interfere prb30(Double prb30) {
        this.prb30 = prb30;
        return this;
    }

    public void setPrb30(Double prb30) {
        this.prb30 = prb30;
    }

    public Double getPrb31() {
        return prb31;
    }

    public Interfere prb31(Double prb31) {
        this.prb31 = prb31;
        return this;
    }

    public void setPrb31(Double prb31) {
        this.prb31 = prb31;
    }

    public Double getPrb32() {
        return prb32;
    }

    public Interfere prb32(Double prb32) {
        this.prb32 = prb32;
        return this;
    }

    public void setPrb32(Double prb32) {
        this.prb32 = prb32;
    }

    public Double getPrb33() {
        return prb33;
    }

    public Interfere prb33(Double prb33) {
        this.prb33 = prb33;
        return this;
    }

    public void setPrb33(Double prb33) {
        this.prb33 = prb33;
    }

    public Double getPrb34() {
        return prb34;
    }

    public Interfere prb34(Double prb34) {
        this.prb34 = prb34;
        return this;
    }

    public void setPrb34(Double prb34) {
        this.prb34 = prb34;
    }

    public Double getPrb35() {
        return prb35;
    }

    public Interfere prb35(Double prb35) {
        this.prb35 = prb35;
        return this;
    }

    public void setPrb35(Double prb35) {
        this.prb35 = prb35;
    }

    public Double getPrb36() {
        return prb36;
    }

    public Interfere prb36(Double prb36) {
        this.prb36 = prb36;
        return this;
    }

    public void setPrb36(Double prb36) {
        this.prb36 = prb36;
    }

    public Double getPrb37() {
        return prb37;
    }

    public Interfere prb37(Double prb37) {
        this.prb37 = prb37;
        return this;
    }

    public void setPrb37(Double prb37) {
        this.prb37 = prb37;
    }

    public Double getPrb38() {
        return prb38;
    }

    public Interfere prb38(Double prb38) {
        this.prb38 = prb38;
        return this;
    }

    public void setPrb38(Double prb38) {
        this.prb38 = prb38;
    }

    public Double getPrb39() {
        return prb39;
    }

    public Interfere prb39(Double prb39) {
        this.prb39 = prb39;
        return this;
    }

    public void setPrb39(Double prb39) {
        this.prb39 = prb39;
    }

    public Double getPrb40() {
        return prb40;
    }

    public Interfere prb40(Double prb40) {
        this.prb40 = prb40;
        return this;
    }

    public void setPrb40(Double prb40) {
        this.prb40 = prb40;
    }

    public Double getPrb41() {
        return prb41;
    }

    public Interfere prb41(Double prb41) {
        this.prb41 = prb41;
        return this;
    }

    public void setPrb41(Double prb41) {
        this.prb41 = prb41;
    }

    public Double getPrb42() {
        return prb42;
    }

    public Interfere prb42(Double prb42) {
        this.prb42 = prb42;
        return this;
    }

    public void setPrb42(Double prb42) {
        this.prb42 = prb42;
    }

    public Double getPrb43() {
        return prb43;
    }

    public Interfere prb43(Double prb43) {
        this.prb43 = prb43;
        return this;
    }

    public void setPrb43(Double prb43) {
        this.prb43 = prb43;
    }

    public Double getPrb44() {
        return prb44;
    }

    public Interfere prb44(Double prb44) {
        this.prb44 = prb44;
        return this;
    }

    public void setPrb44(Double prb44) {
        this.prb44 = prb44;
    }

    public Double getPrb45() {
        return prb45;
    }

    public Interfere prb45(Double prb45) {
        this.prb45 = prb45;
        return this;
    }

    public void setPrb45(Double prb45) {
        this.prb45 = prb45;
    }

    public Double getPrb46() {
        return prb46;
    }

    public Interfere prb46(Double prb46) {
        this.prb46 = prb46;
        return this;
    }

    public void setPrb46(Double prb46) {
        this.prb46 = prb46;
    }

    public Double getPrb47() {
        return prb47;
    }

    public Interfere prb47(Double prb47) {
        this.prb47 = prb47;
        return this;
    }

    public void setPrb47(Double prb47) {
        this.prb47 = prb47;
    }

    public Double getPrb48() {
        return prb48;
    }

    public Interfere prb48(Double prb48) {
        this.prb48 = prb48;
        return this;
    }

    public void setPrb48(Double prb48) {
        this.prb48 = prb48;
    }

    public Double getPrb49() {
        return prb49;
    }

    public Interfere prb49(Double prb49) {
        this.prb49 = prb49;
        return this;
    }

    public void setPrb49(Double prb49) {
        this.prb49 = prb49;
    }

    public Double getPrb50() {
        return prb50;
    }

    public Interfere prb50(Double prb50) {
        this.prb50 = prb50;
        return this;
    }

    public void setPrb50(Double prb50) {
        this.prb50 = prb50;
    }

    public Double getPrb51() {
        return prb51;
    }

    public Interfere prb51(Double prb51) {
        this.prb51 = prb51;
        return this;
    }

    public void setPrb51(Double prb51) {
        this.prb51 = prb51;
    }

    public Double getPrb52() {
        return prb52;
    }

    public Interfere prb52(Double prb52) {
        this.prb52 = prb52;
        return this;
    }

    public void setPrb52(Double prb52) {
        this.prb52 = prb52;
    }

    public Double getPrb53() {
        return prb53;
    }

    public Interfere prb53(Double prb53) {
        this.prb53 = prb53;
        return this;
    }

    public void setPrb53(Double prb53) {
        this.prb53 = prb53;
    }

    public Double getPrb54() {
        return prb54;
    }

    public Interfere prb54(Double prb54) {
        this.prb54 = prb54;
        return this;
    }

    public void setPrb54(Double prb54) {
        this.prb54 = prb54;
    }

    public Double getPrb55() {
        return prb55;
    }

    public Interfere prb55(Double prb55) {
        this.prb55 = prb55;
        return this;
    }

    public void setPrb55(Double prb55) {
        this.prb55 = prb55;
    }

    public Double getPrb56() {
        return prb56;
    }

    public Interfere prb56(Double prb56) {
        this.prb56 = prb56;
        return this;
    }

    public void setPrb56(Double prb56) {
        this.prb56 = prb56;
    }

    public Double getPrb57() {
        return prb57;
    }

    public Interfere prb57(Double prb57) {
        this.prb57 = prb57;
        return this;
    }

    public void setPrb57(Double prb57) {
        this.prb57 = prb57;
    }

    public Double getPrb58() {
        return prb58;
    }

    public Interfere prb58(Double prb58) {
        this.prb58 = prb58;
        return this;
    }

    public void setPrb58(Double prb58) {
        this.prb58 = prb58;
    }

    public Double getPrb59() {
        return prb59;
    }

    public Interfere prb59(Double prb59) {
        this.prb59 = prb59;
        return this;
    }

    public void setPrb59(Double prb59) {
        this.prb59 = prb59;
    }

    public Double getPrb60() {
        return prb60;
    }

    public Interfere prb60(Double prb60) {
        this.prb60 = prb60;
        return this;
    }

    public void setPrb60(Double prb60) {
        this.prb60 = prb60;
    }

    public Double getPrb61() {
        return prb61;
    }

    public Interfere prb61(Double prb61) {
        this.prb61 = prb61;
        return this;
    }

    public void setPrb61(Double prb61) {
        this.prb61 = prb61;
    }

    public Double getPrb62() {
        return prb62;
    }

    public Interfere prb62(Double prb62) {
        this.prb62 = prb62;
        return this;
    }

    public void setPrb62(Double prb62) {
        this.prb62 = prb62;
    }

    public Double getPrb63() {
        return prb63;
    }

    public Interfere prb63(Double prb63) {
        this.prb63 = prb63;
        return this;
    }

    public void setPrb63(Double prb63) {
        this.prb63 = prb63;
    }

    public Double getPrb64() {
        return prb64;
    }

    public Interfere prb64(Double prb64) {
        this.prb64 = prb64;
        return this;
    }

    public void setPrb64(Double prb64) {
        this.prb64 = prb64;
    }

    public Double getPrb65() {
        return prb65;
    }

    public Interfere prb65(Double prb65) {
        this.prb65 = prb65;
        return this;
    }

    public void setPrb65(Double prb65) {
        this.prb65 = prb65;
    }

    public Double getPrb66() {
        return prb66;
    }

    public Interfere prb66(Double prb66) {
        this.prb66 = prb66;
        return this;
    }

    public void setPrb66(Double prb66) {
        this.prb66 = prb66;
    }

    public Double getPrb67() {
        return prb67;
    }

    public Interfere prb67(Double prb67) {
        this.prb67 = prb67;
        return this;
    }

    public void setPrb67(Double prb67) {
        this.prb67 = prb67;
    }

    public Double getPrb68() {
        return prb68;
    }

    public Interfere prb68(Double prb68) {
        this.prb68 = prb68;
        return this;
    }

    public void setPrb68(Double prb68) {
        this.prb68 = prb68;
    }

    public Double getPrb69() {
        return prb69;
    }

    public Interfere prb69(Double prb69) {
        this.prb69 = prb69;
        return this;
    }

    public void setPrb69(Double prb69) {
        this.prb69 = prb69;
    }

    public Double getPrb70() {
        return prb70;
    }

    public Interfere prb70(Double prb70) {
        this.prb70 = prb70;
        return this;
    }

    public void setPrb70(Double prb70) {
        this.prb70 = prb70;
    }

    public Double getPrb71() {
        return prb71;
    }

    public Interfere prb71(Double prb71) {
        this.prb71 = prb71;
        return this;
    }

    public void setPrb71(Double prb71) {
        this.prb71 = prb71;
    }

    public Double getPrb72() {
        return prb72;
    }

    public Interfere prb72(Double prb72) {
        this.prb72 = prb72;
        return this;
    }

    public void setPrb72(Double prb72) {
        this.prb72 = prb72;
    }

    public Double getPrb73() {
        return prb73;
    }

    public Interfere prb73(Double prb73) {
        this.prb73 = prb73;
        return this;
    }

    public void setPrb73(Double prb73) {
        this.prb73 = prb73;
    }

    public Double getPrb74() {
        return prb74;
    }

    public Interfere prb74(Double prb74) {
        this.prb74 = prb74;
        return this;
    }

    public void setPrb74(Double prb74) {
        this.prb74 = prb74;
    }

    public Double getPrb75() {
        return prb75;
    }

    public Interfere prb75(Double prb75) {
        this.prb75 = prb75;
        return this;
    }

    public void setPrb75(Double prb75) {
        this.prb75 = prb75;
    }

    public Double getPrb76() {
        return prb76;
    }

    public Interfere prb76(Double prb76) {
        this.prb76 = prb76;
        return this;
    }

    public void setPrb76(Double prb76) {
        this.prb76 = prb76;
    }

    public Double getPrb77() {
        return prb77;
    }

    public Interfere prb77(Double prb77) {
        this.prb77 = prb77;
        return this;
    }

    public void setPrb77(Double prb77) {
        this.prb77 = prb77;
    }

    public Double getPrb78() {
        return prb78;
    }

    public Interfere prb78(Double prb78) {
        this.prb78 = prb78;
        return this;
    }

    public void setPrb78(Double prb78) {
        this.prb78 = prb78;
    }

    public Double getPrb79() {
        return prb79;
    }

    public Interfere prb79(Double prb79) {
        this.prb79 = prb79;
        return this;
    }

    public void setPrb79(Double prb79) {
        this.prb79 = prb79;
    }

    public Double getPrb80() {
        return prb80;
    }

    public Interfere prb80(Double prb80) {
        this.prb80 = prb80;
        return this;
    }

    public void setPrb80(Double prb80) {
        this.prb80 = prb80;
    }

    public Double getPrb81() {
        return prb81;
    }

    public Interfere prb81(Double prb81) {
        this.prb81 = prb81;
        return this;
    }

    public void setPrb81(Double prb81) {
        this.prb81 = prb81;
    }

    public Double getPrb82() {
        return prb82;
    }

    public Interfere prb82(Double prb82) {
        this.prb82 = prb82;
        return this;
    }

    public void setPrb82(Double prb82) {
        this.prb82 = prb82;
    }

    public Double getPrb83() {
        return prb83;
    }

    public Interfere prb83(Double prb83) {
        this.prb83 = prb83;
        return this;
    }

    public void setPrb83(Double prb83) {
        this.prb83 = prb83;
    }

    public Double getPrb84() {
        return prb84;
    }

    public Interfere prb84(Double prb84) {
        this.prb84 = prb84;
        return this;
    }

    public void setPrb84(Double prb84) {
        this.prb84 = prb84;
    }

    public Double getPrb85() {
        return prb85;
    }

    public Interfere prb85(Double prb85) {
        this.prb85 = prb85;
        return this;
    }

    public void setPrb85(Double prb85) {
        this.prb85 = prb85;
    }

    public Double getPrb86() {
        return prb86;
    }

    public Interfere prb86(Double prb86) {
        this.prb86 = prb86;
        return this;
    }

    public void setPrb86(Double prb86) {
        this.prb86 = prb86;
    }

    public Double getPrb87() {
        return prb87;
    }

    public Interfere prb87(Double prb87) {
        this.prb87 = prb87;
        return this;
    }

    public void setPrb87(Double prb87) {
        this.prb87 = prb87;
    }

    public Double getPrb88() {
        return prb88;
    }

    public Interfere prb88(Double prb88) {
        this.prb88 = prb88;
        return this;
    }

    public void setPrb88(Double prb88) {
        this.prb88 = prb88;
    }

    public Double getPrb89() {
        return prb89;
    }

    public Interfere prb89(Double prb89) {
        this.prb89 = prb89;
        return this;
    }

    public void setPrb89(Double prb89) {
        this.prb89 = prb89;
    }

    public Double getPrb90() {
        return prb90;
    }

    public Interfere prb90(Double prb90) {
        this.prb90 = prb90;
        return this;
    }

    public void setPrb90(Double prb90) {
        this.prb90 = prb90;
    }

    public Double getPrb91() {
        return prb91;
    }

    public Interfere prb91(Double prb91) {
        this.prb91 = prb91;
        return this;
    }

    public void setPrb91(Double prb91) {
        this.prb91 = prb91;
    }

    public Double getPrb92() {
        return prb92;
    }

    public Interfere prb92(Double prb92) {
        this.prb92 = prb92;
        return this;
    }

    public void setPrb92(Double prb92) {
        this.prb92 = prb92;
    }

    public Double getPrb93() {
        return prb93;
    }

    public Interfere prb93(Double prb93) {
        this.prb93 = prb93;
        return this;
    }

    public void setPrb93(Double prb93) {
        this.prb93 = prb93;
    }

    public Double getPrb94() {
        return prb94;
    }

    public Interfere prb94(Double prb94) {
        this.prb94 = prb94;
        return this;
    }

    public void setPrb94(Double prb94) {
        this.prb94 = prb94;
    }

    public Double getPrb95() {
        return prb95;
    }

    public Interfere prb95(Double prb95) {
        this.prb95 = prb95;
        return this;
    }

    public void setPrb95(Double prb95) {
        this.prb95 = prb95;
    }

    public Double getPrb96() {
        return prb96;
    }

    public Interfere prb96(Double prb96) {
        this.prb96 = prb96;
        return this;
    }

    public void setPrb96(Double prb96) {
        this.prb96 = prb96;
    }

    public Double getPrb97() {
        return prb97;
    }

    public Interfere prb97(Double prb97) {
        this.prb97 = prb97;
        return this;
    }

    public void setPrb97(Double prb97) {
        this.prb97 = prb97;
    }

    public Double getPrb98() {
        return prb98;
    }

    public Interfere prb98(Double prb98) {
        this.prb98 = prb98;
        return this;
    }

    public void setPrb98(Double prb98) {
        this.prb98 = prb98;
    }

    public Double getPrb99() {
        return prb99;
    }

    public Interfere prb99(Double prb99) {
        this.prb99 = prb99;
        return this;
    }

    public void setPrb99(Double prb99) {
        this.prb99 = prb99;
    }

    public Double getAverageInterfere() {
        return averageInterfere;
    }

    public Interfere averageInterfere(Double averageInterfere) {
        this.averageInterfere = averageInterfere;
        return this;
    }

    public void setAverageInterfere(Double averageInterfere) {
        this.averageInterfere = averageInterfere;
    }

    public Double getFirstRb() {
        return firstRb;
    }

    public Interfere firstRb(Double firstRb) {
        this.firstRb = firstRb;
        return this;
    }

    public void setFirstRb(Double firstRb) {
        this.firstRb = firstRb;
    }

    public Double getSecondRb() {
        return secondRb;
    }

    public Interfere secondRb(Double secondRb) {
        this.secondRb = secondRb;
        return this;
    }

    public void setSecondRb(Double secondRb) {
        this.secondRb = secondRb;
    }

    public Double getThirdRb() {
        return thirdRb;
    }

    public Interfere thirdRb(Double thirdRb) {
        this.thirdRb = thirdRb;
        return this;
    }

    public void setThirdRb(Double thirdRb) {
        this.thirdRb = thirdRb;
    }

    public Double getFourthRb() {
        return fourthRb;
    }

    public Interfere fourthRb(Double fourthRb) {
        this.fourthRb = fourthRb;
        return this;
    }

    public void setFourthRb(Double fourthRb) {
        this.fourthRb = fourthRb;
    }

    public Double getFifthRb() {
        return fifthRb;
    }

    public Interfere fifthRb(Double fifthRb) {
        this.fifthRb = fifthRb;
        return this;
    }

    public void setFifthRb(Double fifthRb) {
        this.fifthRb = fifthRb;
    }

    public Double getInterferedRb() {
        return interferedRb;
    }

    public Interfere interferedRb(Double interferedRb) {
        this.interferedRb = interferedRb;
        return this;
    }

    public void setInterferedRb(Double interferedRb) {
        this.interferedRb = interferedRb;
    }

    public Double getInterfereCoefficient() {
        return interfereCoefficient;
    }

    public Interfere interfereCoefficient(Double interfereCoefficient) {
        this.interfereCoefficient = interfereCoefficient;
        return this;
    }

    public void setInterfereCoefficient(Double interfereCoefficient) {
        this.interfereCoefficient = interfereCoefficient;
    }

    public String getInterfereGrade() {
        return interfereGrade;
    }

    public Interfere interfereGrade(String interfereGrade) {
        this.interfereGrade = interfereGrade;
        return this;
    }

    public void setInterfereGrade(String interfereGrade) {
        this.interfereGrade = interfereGrade;
    }

    public String getInterfereType() {
        return interfereType;
    }

    public Interfere interfereType(String interfereType) {
        this.interfereType = interfereType;
        return this;
    }

    public void setInterfereType(String interfereType) {
        this.interfereType = interfereType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Interfere interfere = (Interfere) o;
        if (interfere.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), interfere.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Interfere{" +
            "id=" + getId() +
            ", time='" + getTime() + "'" +
            ", fileId='" + getFileId() + "'" +
            ", areaId='" + getAreaId() + "'" +
            ", taskId='" + getTaskId() + "'" +
            ", factory='" + getFactory() + "'" +
            ", enodeb='" + getEnodeb() + "'" +
            ", cellName='" + getCellName() + "'" +
            ", cellIdendifier='" + getCellIdendifier() + "'" +
            ", coverType='" + getCoverType() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", workBand='" + getWorkBand() + "'" +
            ", carrierFrequency='" + getCarrierFrequency() + "'" +
            ", prb0='" + getPrb0() + "'" +
            ", prb1='" + getPrb1() + "'" +
            ", prb2='" + getPrb2() + "'" +
            ", prb3='" + getPrb3() + "'" +
            ", prb4='" + getPrb4() + "'" +
            ", prb5='" + getPrb5() + "'" +
            ", prb6='" + getPrb6() + "'" +
            ", prb7='" + getPrb7() + "'" +
            ", prb8='" + getPrb8() + "'" +
            ", prb9='" + getPrb9() + "'" +
            ", prb10='" + getPrb10() + "'" +
            ", prb11='" + getPrb11() + "'" +
            ", prb12='" + getPrb12() + "'" +
            ", prb13='" + getPrb13() + "'" +
            ", prb14='" + getPrb14() + "'" +
            ", prb15='" + getPrb15() + "'" +
            ", prb16='" + getPrb16() + "'" +
            ", prb17='" + getPrb17() + "'" +
            ", prb18='" + getPrb18() + "'" +
            ", prb19='" + getPrb19() + "'" +
            ", prb20='" + getPrb20() + "'" +
            ", prb21='" + getPrb21() + "'" +
            ", prb22='" + getPrb22() + "'" +
            ", prb23='" + getPrb23() + "'" +
            ", prb24='" + getPrb24() + "'" +
            ", prb25='" + getPrb25() + "'" +
            ", prb26='" + getPrb26() + "'" +
            ", prb27='" + getPrb27() + "'" +
            ", prb28='" + getPrb28() + "'" +
            ", prb29='" + getPrb29() + "'" +
            ", prb30='" + getPrb30() + "'" +
            ", prb31='" + getPrb31() + "'" +
            ", prb32='" + getPrb32() + "'" +
            ", prb33='" + getPrb33() + "'" +
            ", prb34='" + getPrb34() + "'" +
            ", prb35='" + getPrb35() + "'" +
            ", prb36='" + getPrb36() + "'" +
            ", prb37='" + getPrb37() + "'" +
            ", prb38='" + getPrb38() + "'" +
            ", prb39='" + getPrb39() + "'" +
            ", prb40='" + getPrb40() + "'" +
            ", prb41='" + getPrb41() + "'" +
            ", prb42='" + getPrb42() + "'" +
            ", prb43='" + getPrb43() + "'" +
            ", prb44='" + getPrb44() + "'" +
            ", prb45='" + getPrb45() + "'" +
            ", prb46='" + getPrb46() + "'" +
            ", prb47='" + getPrb47() + "'" +
            ", prb48='" + getPrb48() + "'" +
            ", prb49='" + getPrb49() + "'" +
            ", prb50='" + getPrb50() + "'" +
            ", prb51='" + getPrb51() + "'" +
            ", prb52='" + getPrb52() + "'" +
            ", prb53='" + getPrb53() + "'" +
            ", prb54='" + getPrb54() + "'" +
            ", prb55='" + getPrb55() + "'" +
            ", prb56='" + getPrb56() + "'" +
            ", prb57='" + getPrb57() + "'" +
            ", prb58='" + getPrb58() + "'" +
            ", prb59='" + getPrb59() + "'" +
            ", prb60='" + getPrb60() + "'" +
            ", prb61='" + getPrb61() + "'" +
            ", prb62='" + getPrb62() + "'" +
            ", prb63='" + getPrb63() + "'" +
            ", prb64='" + getPrb64() + "'" +
            ", prb65='" + getPrb65() + "'" +
            ", prb66='" + getPrb66() + "'" +
            ", prb67='" + getPrb67() + "'" +
            ", prb68='" + getPrb68() + "'" +
            ", prb69='" + getPrb69() + "'" +
            ", prb70='" + getPrb70() + "'" +
            ", prb71='" + getPrb71() + "'" +
            ", prb72='" + getPrb72() + "'" +
            ", prb73='" + getPrb73() + "'" +
            ", prb74='" + getPrb74() + "'" +
            ", prb75='" + getPrb75() + "'" +
            ", prb76='" + getPrb76() + "'" +
            ", prb77='" + getPrb77() + "'" +
            ", prb78='" + getPrb78() + "'" +
            ", prb79='" + getPrb79() + "'" +
            ", prb80='" + getPrb80() + "'" +
            ", prb81='" + getPrb81() + "'" +
            ", prb82='" + getPrb82() + "'" +
            ", prb83='" + getPrb83() + "'" +
            ", prb84='" + getPrb84() + "'" +
            ", prb85='" + getPrb85() + "'" +
            ", prb86='" + getPrb86() + "'" +
            ", prb87='" + getPrb87() + "'" +
            ", prb88='" + getPrb88() + "'" +
            ", prb89='" + getPrb89() + "'" +
            ", prb90='" + getPrb90() + "'" +
            ", prb91='" + getPrb91() + "'" +
            ", prb92='" + getPrb92() + "'" +
            ", prb93='" + getPrb93() + "'" +
            ", prb94='" + getPrb94() + "'" +
            ", prb95='" + getPrb95() + "'" +
            ", prb96='" + getPrb96() + "'" +
            ", prb97='" + getPrb97() + "'" +
            ", prb98='" + getPrb98() + "'" +
            ", prb99='" + getPrb99() + "'" +
            ", averageInterfere='" + getAverageInterfere() + "'" +
            ", firstRb='" + getFirstRb() + "'" +
            ", secondRb='" + getSecondRb() + "'" +
            ", thirdRb='" + getThirdRb() + "'" +
            ", fourthRb='" + getFourthRb() + "'" +
            ", fifthRb='" + getFifthRb() + "'" +
            ", interferedRb='" + getInterferedRb() + "'" +
            ", interfereCoefficient='" + getInterfereCoefficient() + "'" +
            ", interfereGrade='" + getInterfereGrade() + "'" +
            ", interfereType='" + getInterfereType() + "'" +
            ", solveType='" + getSolveType() + "'" +
            "}";
    }
}
