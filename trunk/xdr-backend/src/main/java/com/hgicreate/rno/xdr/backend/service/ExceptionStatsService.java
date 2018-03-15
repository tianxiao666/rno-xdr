package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.ExceptionStats;
import com.hgicreate.rno.xdr.backend.repository.ExceptionStatsRepository;
import com.hgicreate.rno.xdr.backend.repository.search.ExceptionStatsSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionStatsDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.ExceptionStatsMapper;
import com.hgicreate.rno.xdr.backend.web.rest.cond.ExceptionStatsCond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing ExceptionStats.
 */
@Service
@Transactional
public class ExceptionStatsService {

    private final Logger log = LoggerFactory.getLogger(ExceptionStatsService.class);

    private final ExceptionStatsRepository exceptionStatsRepository;

    private final ExceptionStatsMapper exceptionStatsMapper;

    private final ExceptionStatsSearchRepository exceptionStatsSearchRepository;

    private final EntityManager entityManager;

    public ExceptionStatsService(ExceptionStatsRepository exceptionStatsRepository, ExceptionStatsMapper exceptionStatsMapper, ExceptionStatsSearchRepository exceptionStatsSearchRepository, EntityManager entityManager) {
        this.exceptionStatsRepository = exceptionStatsRepository;
        this.exceptionStatsMapper = exceptionStatsMapper;
        this.exceptionStatsSearchRepository = exceptionStatsSearchRepository;
        this.entityManager = entityManager;
    }

    /**
     * Save a exceptionStats.
     *
     * @param exceptionStatsDTO the entity to save
     * @return the persisted entity
     */
    public ExceptionStatsDTO save(ExceptionStatsDTO exceptionStatsDTO) {
        log.debug("Request to save ExceptionStats : {}", exceptionStatsDTO);
        ExceptionStats exceptionStats = exceptionStatsMapper.toEntity(exceptionStatsDTO);
        exceptionStats = exceptionStatsRepository.save(exceptionStats);
        ExceptionStatsDTO result = exceptionStatsMapper.toDto(exceptionStats);
        exceptionStatsSearchRepository.save(exceptionStats);
        return result;
    }

    /**
     *  Get all the exceptionStats.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ExceptionStatsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ExceptionStats");
        return exceptionStatsRepository.findAll(pageable)
            .map(exceptionStatsMapper::toDto);
    }

    /**
     *  Get one exceptionStats by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public ExceptionStatsDTO findOne(Long id) {
        log.debug("Request to get ExceptionStats : {}", id);
        ExceptionStats exceptionStats = exceptionStatsRepository.findOne(id);
        return exceptionStatsMapper.toDto(exceptionStats);
    }

    /**
     *  Delete the  exceptionStats by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete ExceptionStats : {}", id);
        exceptionStatsRepository.delete(id);
        exceptionStatsSearchRepository.delete(id);
    }

    /**
     * Search for the exceptionStats corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ExceptionStatsDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of ExceptionStats for query {}", query);
        Page<ExceptionStats> result = exceptionStatsSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(exceptionStatsMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<ExceptionStatsDTO> findByCond(ExceptionStatsCond cond, Pageable pageable) {
        String sql = cond.buildSql();
        String countSql = "select count(*) from (" + sql + ") count_sql";
        Query query = entityManager.createNativeQuery(sql);
        Query countQuery = entityManager.createNativeQuery(countSql);
        if (query == null || countQuery == null) {
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
        Long total = ((BigInteger)countQuery.getSingleResult()).longValue();
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List<ExceptionStatsDTO> content = total > pageable.getOffset() ? query.getResultList() : Collections.emptyList();
//        List<ExceptionStats> content = total > pageable.getOffset() ? query.getResultList() : Collections.emptyList();
//        return new PageImpl<>(content, pageable, total).map(exceptionStatsMapper::toDto);
        return new PageImpl<>(content, pageable, total);
    }

    @Transactional(readOnly = true)
    public List<ExceptionStatsDTO> downloadByCond(ExceptionStatsCond cond) {
        String sql = cond.buildSql();
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<ExceptionStatsDTO> downloadByCondMobile(ExceptionStatsCond cond) {
        String sql = cond.buildSqlMobile();
        Query query = entityManager.createNativeQuery(sql, ExceptionStats.class);
        return exceptionStatsMapper.toDto(query.getResultList());
    }
}
