package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.X2;
import com.hgicreate.rno.xdr.backend.repository.X2Repository;
import com.hgicreate.rno.xdr.backend.repository.search.X2SearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.X2DTO;
import com.hgicreate.rno.xdr.backend.service.mapper.X2Mapper;
import com.hgicreate.rno.xdr.backend.web.rest.cond.IndicatorCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing X2.
 */
@Service
@Transactional
public class X2Service {

    private final Logger log = LoggerFactory.getLogger(X2Service.class);

    private final X2Repository x2Repository;

    private final X2Mapper x2Mapper;

    private final X2SearchRepository x2SearchRepository;

    public X2Service(X2Repository x2Repository, X2Mapper x2Mapper, X2SearchRepository x2SearchRepository) {
        this.x2Repository = x2Repository;
        this.x2Mapper = x2Mapper;
        this.x2SearchRepository = x2SearchRepository;
    }

    /**
     * Save a x2.
     *
     * @param x2DTO the entity to save
     * @return the persisted entity
     */
    public X2DTO save(X2DTO x2DTO) {
        log.debug("Request to save X2 : {}", x2DTO);
        X2 x2 = x2Mapper.toEntity(x2DTO);
        x2 = x2Repository.save(x2);
        X2DTO result = x2Mapper.toDto(x2);
        x2SearchRepository.save(x2);
        return result;
    }

    /**
     *  Get all the x2S.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<X2DTO> findAll(Pageable pageable) {
        log.debug("Request to get all X2S");
        return x2Repository.findAll(pageable)
            .map(x2Mapper::toDto);
    }

    /**
     *  Get one x2 by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public X2DTO findOne(Long id) {
        log.debug("Request to get X2 : {}", id);
        X2 x2 = x2Repository.findOne(id);
        return x2Mapper.toDto(x2);
    }

    /**
     *  Delete the  x2 by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete X2 : {}", id);
        x2Repository.delete(id);
        x2SearchRepository.delete(id);
    }

    /**
     * Search for the x2 corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<X2DTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of X2S for query {}", query);
        Page<X2> result = x2SearchRepository.search(queryStringQuery(query), pageable);
        return result.map(x2Mapper::toDto);
    }

    @Transactional(readOnly = true)
    public Object findX2(String gradingType, String cellType, IndicatorCond indicatorCond) {
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
                result = x2Repository.findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1);
                break;
            case "imsi":
                result = x2Repository.findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = x2Repository.findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1, indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }

    private Object findByHour(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        LocalDate localDate = new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);
        switch (cellType) {
            case "network":
                result = x2Repository.findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(localDate, -1);
                break;
            case "imsi":
                result = x2Repository.findByPdateAndPhourIsNotAndImsi(localDate, -1, indicatorCond.getImsi());
                break;
            case "eci":
                result = x2Repository.findByPdateAndPhourIsNotAndCell(localDate, -1, indicatorCond.getEci());
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
                result = x2Repository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "imsi":
                result = x2Repository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "eci":
                result = x2Repository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            default:
                break;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Object downloadX2(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = x2Repository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                break;
            case "imsi":
                result = x2Repository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi());
                break;
            case "eci":
                result = x2Repository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }
}
