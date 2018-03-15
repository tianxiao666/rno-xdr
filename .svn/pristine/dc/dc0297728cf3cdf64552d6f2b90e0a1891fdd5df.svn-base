package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Track;
import com.hgicreate.rno.xdr.backend.repository.TrackRepository;
import com.hgicreate.rno.xdr.backend.repository.search.TrackSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.TrackDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.TrackMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Track.
 */
@Service
@Transactional
public class TrackService {

    private final Logger log = LoggerFactory.getLogger(TrackService.class);

    private final TrackRepository trackRepository;

    private final TrackMapper trackMapper;

    private final TrackSearchRepository trackSearchRepository;

    public TrackService(TrackRepository trackRepository, TrackMapper trackMapper, TrackSearchRepository trackSearchRepository) {
        this.trackRepository = trackRepository;
        this.trackMapper = trackMapper;
        this.trackSearchRepository = trackSearchRepository;
    }

    /**
     * Save a track.
     *
     * @param trackDTO the entity to save
     * @return the persisted entity
     */
    public TrackDTO save(TrackDTO trackDTO) {
        log.debug("Request to save Track : {}", trackDTO);
        Track track = trackMapper.toEntity(trackDTO);
        track = trackRepository.save(track);
        TrackDTO result = trackMapper.toDto(track);
        trackSearchRepository.save(track);
        return result;
    }

    /**
     *  Get all the tracks.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TrackDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tracks");
        return trackRepository.findAll(pageable)
            .map(trackMapper::toDto);
    }

    /**
     *  Get one track by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public TrackDTO findOne(Long id) {
        log.debug("Request to get Track : {}", id);
        Track track = trackRepository.findOne(id);
        return trackMapper.toDto(track);
    }

    /**
     *  Delete the  track by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Track : {}", id);
        trackRepository.delete(id);
        trackSearchRepository.delete(id);
    }

    /**
     * Search for the track corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<TrackDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Tracks for query {}", query);
        Page<Track> result = trackSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(trackMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<TrackDTO> findByTimeAndImsiAndIndicatorType(Long beginTime, Long endTime, Long imsi, String indicatorType) {
        log.debug("Request to get a page of Tracks");
        List<Track> tracks = trackRepository.findByStartTimeBetweenOrEndTimeBetweenAndImsiAndIndicatorType(beginTime, endTime, beginTime, endTime, imsi, indicatorType);
        return trackMapper.toDto(tracks);
    }
}
