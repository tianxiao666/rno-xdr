package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.UuDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Uu and its DTO UuDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UuMapper extends EntityMapper <UuDTO, Uu> {
    
    
    default Uu fromId(Long id) {
        if (id == null) {
            return null;
        }
        Uu uu = new Uu();
        uu.setId(id);
        return uu;
    }
}
