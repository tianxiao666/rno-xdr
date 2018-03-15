package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionCauseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ExceptionCause and its DTO ExceptionCauseDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ExceptionCauseMapper extends EntityMapper <ExceptionCauseDTO, ExceptionCause> {
    
    
    default ExceptionCause fromId(Long id) {
        if (id == null) {
            return null;
        }
        ExceptionCause exceptionCause = new ExceptionCause();
        exceptionCause.setId(id);
        return exceptionCause;
    }
}
