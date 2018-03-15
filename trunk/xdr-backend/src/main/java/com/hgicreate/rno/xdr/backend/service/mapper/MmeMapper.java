package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.MmeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Mme and its DTO MmeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MmeMapper extends EntityMapper <MmeDTO, Mme> {
    
    
    default Mme fromId(Long id) {
        if (id == null) {
            return null;
        }
        Mme mme = new Mme();
        mme.setId(id);
        return mme;
    }
}
