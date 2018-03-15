package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.SignallingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Signalling and its DTO SignallingDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SignallingMapper extends EntityMapper <SignallingDTO, Signalling> {
    
    
    default Signalling fromId(Long id) {
        if (id == null) {
            return null;
        }
        Signalling signalling = new Signalling();
        signalling.setId(id);
        return signalling;
    }
}
