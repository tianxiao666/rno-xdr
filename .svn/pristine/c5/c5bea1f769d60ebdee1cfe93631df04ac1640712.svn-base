package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.MrDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Mr and its DTO MrDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MrMapper extends EntityMapper <MrDTO, Mr> {
    
    
    default Mr fromId(Long id) {
        if (id == null) {
            return null;
        }
        Mr mr = new Mr();
        mr.setId(id);
        return mr;
    }
}
