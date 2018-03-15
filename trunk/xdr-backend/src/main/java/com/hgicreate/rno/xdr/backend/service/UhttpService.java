package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Uhttp;
import com.hgicreate.rno.xdr.backend.repository.UhttpRepository;
import com.hgicreate.rno.xdr.backend.repository.search.UhttpSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.UhttpDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.UhttpMapper;
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
 * Service Implementation for managing Uhttp.
 */
@Service
@Transactional
public class UhttpService {

    private final Logger log = LoggerFactory.getLogger(UhttpService.class);

    private final UhttpRepository uhttpRepository;

    private final UhttpMapper uhttpMapper;

    private final UhttpSearchRepository uhttpSearchRepository;

    public UhttpService(UhttpRepository uhttpRepository, UhttpMapper uhttpMapper, UhttpSearchRepository uhttpSearchRepository) {
        this.uhttpRepository = uhttpRepository;
        this.uhttpMapper = uhttpMapper;
        this.uhttpSearchRepository = uhttpSearchRepository;
    }

    /**
     * Save a uhttp.
     *
     * @param uhttpDTO the entity to save
     * @return the persisted entity
     */
    public UhttpDTO save(UhttpDTO uhttpDTO) {
        log.debug("Request to save Uhttp : {}", uhttpDTO);
        Uhttp uhttp = uhttpMapper.toEntity(uhttpDTO);
        uhttp = uhttpRepository.save(uhttp);
        UhttpDTO result = uhttpMapper.toDto(uhttp);
        uhttpSearchRepository.save(uhttp);
        return result;
    }

    /**
     *  Get all the uhttps.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<UhttpDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Uhttps");
        return uhttpRepository.findAll(pageable)
            .map(uhttpMapper::toDto);
    }

    /**
     *  Get one uhttp by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public UhttpDTO findOne(Long id) {
        log.debug("Request to get Uhttp : {}", id);
        Uhttp uhttp = uhttpRepository.findOne(id);
        return uhttpMapper.toDto(uhttp);
    }

    /**
     *  Delete the  uhttp by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Uhttp : {}", id);
        uhttpRepository.delete(id);
        uhttpSearchRepository.delete(id);
    }

    /**
     * Search for the uhttp corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<UhttpDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Uhttps for query {}", query);
        Page<Uhttp> result = uhttpSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(uhttpMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Object findUhttp(String gradingType, String cellType, IndicatorCond indicatorCond) {
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
                result = uhttpRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = uhttpRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = uhttpRepository.findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
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
                result = uhttpRepository.findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = uhttpRepository.findByPdateAndPhourIsNotAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = uhttpRepository.findByPdateAndPhourIsNotAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
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
                result = uhttpRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "imsi":
                result = uhttpRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "eci":
                result = uhttpRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            default:
                break;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Object downloadUhttp(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = uhttpRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                break;
            case "imsi":
                result = uhttpRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi());
                break;
            case "eci":
                result = uhttpRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }
}
