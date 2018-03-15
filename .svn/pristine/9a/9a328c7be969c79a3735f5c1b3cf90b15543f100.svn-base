package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Signalling;
import com.hgicreate.rno.xdr.backend.repository.SignallingRepository;
import com.hgicreate.rno.xdr.backend.repository.search.SignallingSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.SignallingDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.SignallingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Signalling.
 */
@Service
@Transactional
public class SignallingService {

    private final Logger log = LoggerFactory.getLogger(SignallingService.class);

    private final SignallingRepository signallingRepository;

    private final SignallingMapper signallingMapper;

    private final SignallingSearchRepository signallingSearchRepository;

    public SignallingService(SignallingRepository signallingRepository, SignallingMapper signallingMapper, SignallingSearchRepository signallingSearchRepository) {
        this.signallingRepository = signallingRepository;
        this.signallingMapper = signallingMapper;
        this.signallingSearchRepository = signallingSearchRepository;
    }

    /**
     * Save a signalling.
     *
     * @param signallingDTO the entity to save
     * @return the persisted entity
     */
    public SignallingDTO save(SignallingDTO signallingDTO) {
        log.debug("Request to save Signalling : {}", signallingDTO);
        Signalling signalling = signallingMapper.toEntity(signallingDTO);
        signalling = signallingRepository.save(signalling);
        SignallingDTO result = signallingMapper.toDto(signalling);
        signallingSearchRepository.save(signalling);
        return result;
    }

    /**
     *  Get all the signallings.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<SignallingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Signallings");
        return signallingRepository.findAll(pageable)
            .map(signallingMapper::toDto);
    }

    /**
     *  Get one signalling by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public SignallingDTO findOne(Long id) {
        log.debug("Request to get Signalling : {}", id);
        Signalling signalling = signallingRepository.findOne(id);
        return signallingMapper.toDto(signalling);
    }

    /**
     *  Delete the  signalling by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Signalling : {}", id);
        signallingRepository.delete(id);
        signallingSearchRepository.delete(id);
    }

    /**
     * Search for the signalling corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<SignallingDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Signallings for query {}", query);
        Page<Signalling> result = signallingSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(signallingMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<SignallingDTO> findByTimeAndImsi(Long beginTime, Long endTime, Long imsi, Pageable pageable) {
        log.debug("Request to get a page of Signallings");
        return signallingRepository.findByStartTimeBetweenOrEndTimeBetweenAndImsi(beginTime, endTime, beginTime, endTime, imsi, pageable).map(signallingMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<SignallingDTO> downloadByTimeAndImsi(Long beginTime, Long endTime, Long imsi) {
        log.debug("Request to get a list of Signallings");
        return signallingMapper.toDto(signallingRepository.findByStartTimeBetweenOrEndTimeBetweenAndImsi(beginTime, endTime, beginTime, endTime, imsi));
    }
}
