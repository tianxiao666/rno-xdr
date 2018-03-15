package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.X2DTO;

import org.mapstruct.*;

/**
 * Mapper for the entity X2 and its DTO X2DTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface X2Mapper extends EntityMapper <X2DTO, X2> {
    
    
    default X2 fromId(Long id) {
        if (id == null) {
            return null;
        }
        X2 x2 = new X2();
        x2.setId(id);
        return x2;
    }
}
