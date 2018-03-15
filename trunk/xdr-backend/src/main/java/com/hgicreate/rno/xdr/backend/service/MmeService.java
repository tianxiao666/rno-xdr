package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Mme;
import com.hgicreate.rno.xdr.backend.repository.MmeRepository;
import com.hgicreate.rno.xdr.backend.repository.search.MmeSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.MmeDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.MmeMapper;
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
 * Service Implementation for managing Mme.
 */
@Service
@Transactional
public class MmeService {

    private final Logger log = LoggerFactory.getLogger(MmeService.class);

    private final MmeRepository mmeRepository;

    private final MmeMapper mmeMapper;

    private final MmeSearchRepository mmeSearchRepository;

    public MmeService(MmeRepository mmeRepository, MmeMapper mmeMapper, MmeSearchRepository mmeSearchRepository) {
        this.mmeRepository = mmeRepository;
        this.mmeMapper = mmeMapper;
        this.mmeSearchRepository = mmeSearchRepository;
    }

    /**
     * Save a mme.
     *
     * @param mmeDTO the entity to save
     * @return the persisted entity
     */
    public MmeDTO save(MmeDTO mmeDTO) {
        log.debug("Request to save Mme : {}", mmeDTO);
        Mme mme = mmeMapper.toEntity(mmeDTO);
        mme = mmeRepository.save(mme);
        MmeDTO result = mmeMapper.toDto(mme);
        mmeSearchRepository.save(mme);
        return result;
    }

    /**
     *  Get all the mmes.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<MmeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Mmes");
        return mmeRepository.findAll(pageable)
            .map(mmeMapper::toDto);
    }

    /**
     *  Get one mme by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public MmeDTO findOne(Long id) {
        log.debug("Request to get Mme : {}", id);
        Mme mme = mmeRepository.findOne(id);
        return mmeMapper.toDto(mme);
    }

    /**
     *  Delete the  mme by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Mme : {}", id);
        mmeRepository.delete(id);
        mmeSearchRepository.delete(id);
    }

    /**
     * Search for the mme corresponding to the query.
     *
     *  @param query the query of the search
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<MmeDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Mmes for query {}", query);
        Page<Mme> result = mmeSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(mmeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Object findMme(String gradingType, String cellType, IndicatorCond indicatorCond) {
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
                result = mmeRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L);
                break;
            case "imsi":
                result = mmeRepository.findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L, indicatorCond.getImsi());
                break;
            case "eci":
                result = mmeRepository.findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(new Date(indicatorCond.getBeginDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date(indicatorCond.getEndDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L, indicatorCond.getEci());
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
                result = mmeRepository.findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L);
                break;
            case "imsi":
                result = mmeRepository.findByPdateAndPhourIsNotAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L, indicatorCond.getImsi());
                break;
            case "eci":
                result = mmeRepository.findByPdateAndPhourIsNotAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), -1L, indicatorCond.getEci());
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
                result = mmeRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "imsi":
                result = mmeRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            case "eci":
                result = mmeRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci(), new PageRequest(indicatorCond.getPage(), indicatorCond.getSize()));
                break;
            default:
                break;
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Object downloadMme(String cellType, IndicatorCond indicatorCond) {
        Object result = null;
        switch (cellType) {
            case "network":
                result = mmeRepository.findByPdate(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                break;
            case "imsi":
                result = mmeRepository.findByPdateAndImsi(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getImsi());
                break;
            case "eci":
                result = mmeRepository.findByPdateAndCell(new Date(indicatorCond.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), indicatorCond.getEci());
                break;
            default:
                break;
        }
        return result;
    }
}
