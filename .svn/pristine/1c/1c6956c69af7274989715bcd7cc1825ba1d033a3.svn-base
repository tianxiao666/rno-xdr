package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.DataImportDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity DataImport and its DTO DataImportDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DataImportMapper extends EntityMapper <DataImportDTO, DataImport> {
    
    
    default DataImport fromId(Long id) {
        if (id == null) {
            return null;
        }
        DataImport dataImport = new DataImport();
        dataImport.setId(id);
        return dataImport;
    }
}
