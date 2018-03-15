package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Mr;
import com.hgicreate.rno.xdr.backend.repository.MrRepository;
import com.hgicreate.rno.xdr.backend.repository.search.MrSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.MrDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.MrMapper;
import com.hgicreate.rno.xdr.backend.web.rest.cond.IndicatorCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.ZoneId;
import java.util.Date;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Mr.
 */
@Service
@Transactional
public class MrService {

    private final Logger log = LoggerFactory.getLogger(MrService.class);

    private final MrRepository mrRepository;

    private final MrMapper mrMapper;

    private final MrSearchRepository mrSearchRepository;

    public MrService(MrRepository mrRepository, MrMapper mrMapper, MrSearchRepository mrSearchRepository) {
        this.mrRepository = mrRepository;
        this.mrMapper = mrMapper;
        this.mrSearchRepository = mrSearchRepository;
    }

    /**
     * Save a mr.
     *
     * @param mrDTO the entity to save
     * @return the persisted entity
     */
    public MrDTO save(MrDTO mrDTO) {
        log.debug("Request to save Mr : {}", mrDTO);
        Mr mr = mrMapper.toEntity(mrDTO);
        mr = mrRepository.save(mr);
        MrDTO result = mrMapper.toDto(mr);
        mrSearchRepository.save(mr);
        return result;
    }

    /**
     *  Get all the mrs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<MrDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Mrs");
        return mrRepository.findAll(pageable)
            .map(mrMapper::toDto);
    }

    /**
     *  Get one mr by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public MrDTO findOne(Long id) {
        log.debug("Request to get Mr : {}", id);
        Mr mr = mrRepository.findOne(id);
        return mrMapper.toDto(mr);
    }

    /**
     *  Delete the  mr by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Mr : {}", id);
        mrRepository.delete(id);
        mrSearchRepository.delete(id);
    }

    /**
     * Search for the mr corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<MrDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Mrs for query {}", query);
        Page<Mr> result = mrSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(mrMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Object findMr(String gradingType, String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (gradingType) {
            case "day":
                result = findByDay(cellType, indicatorCond);
                break;
            case "hour":
                result = findByHour(cellType, indicatorCond);
                break;
            case "detail":
                result = findByDetail(cellType, indicatorCond);
                break;
            default:
                break;
        }
        return result;
    }

    private Object findByDay(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = mrRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = mrRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = mrRepository.findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }

    private Object findByHour(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = mrRepository.findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = mrRepository.findByPdateAndPhourIsNotAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = mrRepository.findByPdateAndPhourIsNotAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }

    private Object findByDetail(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = mrRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "imsi":
                result = mrRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "eci":
                result = mrRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            default:
                break;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Object downloadMr(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = mrRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                break;
            case "imsi":
                result = mrRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi());
                break;
            case "eci":
                result = mrRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }
}
