package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Uu;
import com.hgicreate.rno.xdr.backend.repository.UuRepository;
import com.hgicreate.rno.xdr.backend.repository.search.UuSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.UuDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.UuMapper;
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
 * Service Implementation for managing Uu.
 */
@Service
@Transactional
public class UuService {

    private final Logger log = LoggerFactory.getLogger(UuService.class);

    private final UuRepository uuRepository;

    private final UuMapper uuMapper;

    private final UuSearchRepository uuSearchRepository;

    public UuService(UuRepository uuRepository, UuMapper uuMapper, UuSearchRepository uuSearchRepository) {
        this.uuRepository = uuRepository;
        this.uuMapper = uuMapper;
        this.uuSearchRepository = uuSearchRepository;
    }

    /**
     * Save a uu.
     *
     * @param uuDTO the entity to save
     * @return the persisted entity
     */
    public UuDTO save(UuDTO uuDTO) {
        log.debug("Request to save Uu : {}", uuDTO);
        Uu uu = uuMapper.toEntity(uuDTO);
        uu = uuRepository.save(uu);
        UuDTO result = uuMapper.toDto(uu);
        uuSearchRepository.save(uu);
        return result;
    }

    /**
     *  Get all the uus.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<UuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Uus");
        return uuRepository.findAll(pageable)
            .map(uuMapper::toDto);
    }

    /**
     *  Get one uu by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public UuDTO findOne(Long id) {
        log.debug("Request to get Uu : {}", id);
        Uu uu = uuRepository.findOne(id);
        return uuMapper.toDto(uu);
    }

    /**
     *  Delete the  uu by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Uu : {}", id);
        uuRepository.delete(id);
        uuSearchRepository.delete(id);
    }

    /**
     * Search for the uu corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<UuDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Uus for query {}", query);
        Page<Uu> result = uuSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(uuMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Object findUu(String gradingType, String cellType, IndicatorCond indicatorCond) {
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
                result = uuRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = uuRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = uuRepository.findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
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
                result = uuRepository.findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = uuRepository.findByPdateAndPhourIsNotAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = uuRepository.findByPdateAndPhourIsNotAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
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
                result = uuRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "imsi":
                result = uuRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "eci":
                result = uuRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            default:
                break;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Object downloadUu(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = uuRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                break;
            case "imsi":
                result = uuRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi());
                break;
            case "eci":
                result = uuRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }
}
