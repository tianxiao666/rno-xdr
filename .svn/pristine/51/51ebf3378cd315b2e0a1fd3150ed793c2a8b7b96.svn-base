package com.hgicreate.rno.xdr.backend.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DataImport entity.
 */
public class DataImportDTO implements Serializable {

    private Long id;

    private String dataArea;

    private LocalDate dataDate;

    private String user;

    private String fileTitle;

    private String fileType;

    private String fileSize;

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

    public void setDataArea(String dataArea) {
        this.dataArea = dataArea;
    }

    public LocalDate getDataDate() {
        return dataDate;
    }

    public void setDataDate(LocalDate dataDate) {
        this.dataDate = dataDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getState() {
        return state;
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

        DataImportDTO dataImportDTO = (DataImportDTO) o;
        if(dataImportDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataImportDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataImportDTO{" +
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
