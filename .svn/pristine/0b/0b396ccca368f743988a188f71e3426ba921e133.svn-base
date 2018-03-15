package com.hgicreate.rno.xdr.backend.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DataImport.
 */
@Entity
@Table(name = "data_import")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "dataimport")
public class DataImport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data_area")
    private String dataArea;

    @Column(name = "data_date")
    private LocalDate dataDate;

    @Column(name = "jhi_user")
    private String user;

    @Column(name = "file_title")
    private String fileTitle;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_size")
    private String fileSize;

    @Column(name = "state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataArea() {
        return dataArea;
    }

    public DataImport dataArea(String dataArea) {
        this.dataArea = dataArea;
        return this;
    }

    public void setDataArea(String dataArea) {
        this.dataArea = dataArea;
    }

    public LocalDate getDataDate() {
        return dataDate;
    }

    public DataImport dataDate(LocalDate dataDate) {
        this.dataDate = dataDate;
        return this;
    }

    public void setDataDate(LocalDate dataDate) {
        this.dataDate = dataDate;
    }

    public String getUser() {
        return user;
    }

    public DataImport user(String user) {
        this.user = user;
        return this;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public DataImport fileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
        return this;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileType() {
        return fileType;
    }

    public DataImport fileType(String fileType) {
        this.fileType = fileType;
        return this;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public DataImport fileSize(String fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getState() {
        return state;
    }

    public DataImport state(String state) {
        this.state = state;
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataImport dataImport = (DataImport) o;
        if (dataImport.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataImport.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataImport{" +
            "id=" + getId() +
            ", dataArea='" + getDataArea() + "'" +
            ", dataDate='" + getDataDate() + "'" +
            ", user='" + getUser() + "'" +
            ", fileTitle='" + getFileTitle() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", fileSize='" + getFileSize() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }
}
