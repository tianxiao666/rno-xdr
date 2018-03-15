package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.ExceptionCause;
import com.hgicreate.rno.xdr.backend.repository.ExceptionCauseRepository;
import com.hgicreate.rno.xdr.backend.repository.search.ExceptionCauseSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionCauseDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.ExceptionCauseMapper;
import com.hgicreate.rno.xdr.backend.web.rest.cond.ExceptionCauseCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing ExceptionCause.
 */
@Service
@Transactional
public class ExceptionCauseService {

    private final Logger log = LoggerFactory.getLogger(ExceptionCauseService.class);

    private final ExceptionCauseRepository exceptionCauseRepository;

    private final ExceptionCauseMapper exceptionCauseMapper;

    private final ExceptionCauseSearchRepository exceptionCauseSearchRepository;

    public ExceptionCauseService(ExceptionCauseRepository exceptionCauseRepository, ExceptionCauseMapper exceptionCauseMapper, ExceptionCauseSearchRepository exceptionCauseSearchRepository) {
        this.exceptionCauseRepository = exceptionCauseRepository;
        this.exceptionCauseMapper = exceptionCauseMapper;
        this.exceptionCauseSearchRepository = exceptionCauseSearchRepository;
    }

    /**
     * Save a exceptionCause.
     *
     * @param exceptionCauseDTO the entity to save
     * @return the persisted entity
     */
    public ExceptionCauseDTO save(ExceptionCauseDTO exceptionCauseDTO) {
        log.debug("Request to save ExceptionCause : {}", exceptionCauseDTO);
        ExceptionCause exceptionCause = exceptionCauseMapper.toEntity(exceptionCauseDTO);
        exceptionCause = exceptionCauseRepository.save(exceptionCause);
        ExceptionCauseDTO result = exceptionCauseMapper.toDto(exceptionCause);
        exceptionCauseSearchRepository.save(exceptionCause);
        return result;
    }

    /**
     *  Get all the exceptionCauses.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ExceptionCauseDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ExceptionCauses");
        return exceptionCauseRepository.findAll(pageable)
            .map(exceptionCauseMapper::toDto);
    }

    /**
     *  Get one exceptionCause by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public ExceptionCauseDTO findOne(Long id) {
        log.debug("Request to get ExceptionCause : {}", id);
        ExceptionCause exceptionCause = exceptionCauseRepository.findOne(id);
        return exceptionCauseMapper.toDto(exceptionCause);
    }

    /**
     *  Delete the  exceptionCause by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete ExceptionCause : {}", id);
        exceptionCauseRepository.delete(id);
        exceptionCauseSearchRepository.delete(id);
    }

    /**
     * Search for the exceptionCause corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ExceptionCauseDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of ExceptionCauses for query {}", query);
        Page<ExceptionCause> result = exceptionCauseSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(exceptionCauseMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<ExceptionCauseDTO> findByDateAndEciAndIndicatorType(ExceptionCauseCond exceptionCauseCond) {
        LocalDate localDate = Instant.ofEpochMilli(exceptionCauseCond.getDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        Long eci = exceptionCauseCond.getEci();
        Long imsi = exceptionCauseCond.getImsi();
        String indicatorType = exceptionCauseCond.getIndicatorType();
        List<ExceptionCause> exceptionCauses = null;
        if (eci == null && imsi == null){
            exceptionCauses = exceptionCauseRepository.findByPdateAndIndicatorTypeAndCellIsNullAndImsiIsNull(localDate, indicatorType);
        } else if(eci !=null && imsi == null) {
            exceptionCauses = exceptionCauseRepository.findByPdateAndCellAndIndicatorType(localDate, eci, indicatorType);
        } else if (eci == null) {
            exceptionCauses = exceptionCauseRepository.findByPdateAndImsiAndIndicatorType(localDate, imsi, indicatorType);
        }
        return exceptionCauseMapper.toDto(exceptionCauses);
    }
}
