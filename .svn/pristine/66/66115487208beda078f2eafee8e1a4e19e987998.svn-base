package com.hgicreate.rno.xdr.backend.service.mapper;

import com.hgicreate.rno.xdr.backend.domain.*;
import com.hgicreate.rno.xdr.backend.service.dto.TrackDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Track and its DTO TrackDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TrackMapper extends EntityMapper <TrackDTO, Track> {
    
    
    default Track fromId(Long id) {
        if (id == null) {
            return null;
        }
        Track track = new Track();
        track.setId(id);
        return track;
    }
}
