package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionStatsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ExceptionStats and its DTO ExceptionStatsDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ExceptionStatsMapper extends EntityMapper <ExceptionStatsDTO, ExceptionStats> {
    
    
    default ExceptionStats fromId(Long id) {
        if (id == null) {
            return null;
        }
        ExceptionStats exceptionStats = new ExceptionStats();
        exceptionStats.setId(id);
        return exceptionStats;
    }
}
