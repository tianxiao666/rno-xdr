package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.UhttpDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Uhttp and its DTO UhttpDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UhttpMapper extends EntityMapper <UhttpDTO, Uhttp> {
    
    
    default Uhttp fromId(Long id) {
        if (id == null) {
            return null;
        }
        Uhttp uhttp = new Uhttp();
        uhttp.setId(id);
        return uhttp;
    }
}
