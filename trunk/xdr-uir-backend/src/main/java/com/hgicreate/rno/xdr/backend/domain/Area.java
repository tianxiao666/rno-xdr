package com.hgicreate.rno.xdr.backend.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 区域表
 */
@ApiModel(description = "区域表")
@Entity
@Table(name = "rno_uir_area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "area")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "area_level", nullable = false)
    private Integer areaLevel;

    @NotNull
    @Column(name = "parent_id", nullable = false)
    private Integer parentId;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Area name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public Area areaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
        return this;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Area parentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Area longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Area latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Area area = (Area) o;
        if (area.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), area.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Area{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", areaLevel='" + getAreaLevel() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            "}";
    }
}
