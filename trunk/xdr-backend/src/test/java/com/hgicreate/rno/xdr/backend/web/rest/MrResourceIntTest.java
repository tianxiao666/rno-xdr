package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Mr;
import com.hgicreate.rno.xdr.backend.repository.MrRepository;
import com.hgicreate.rno.xdr.backend.service.MrService;
import com.hgicreate.rno.xdr.backend.repository.search.MrSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.MrDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.MrMapper;
import com.hgicreate.rno.xdr.backend.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the MrResource REST controller.
 *
 * @see MrResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class MrResourceIntTest {

    private static final LocalDate DEFAULT_PDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_PHOUR = 1;
    private static final Integer UPDATED_PHOUR = 2;

    private static final String DEFAULT_CELL = "AAAAAAAAAA";
    private static final String UPDATED_CELL = "BBBBBBBBBB";

    private static final String DEFAULT_IMEI = "AAAAAAAAAA";
    private static final String UPDATED_IMEI = "BBBBBBBBBB";

    private static final String DEFAULT_IMSI = "AAAAAAAAAA";
    private static final String UPDATED_IMSI = "BBBBBBBBBB";

    private static final Long DEFAULT_RSRP_SUM = 1L;
    private static final Long UPDATED_RSRP_SUM = 2L;

    private static final Long DEFAULT_RSRP_COUNT = 1L;
    private static final Long UPDATED_RSRP_COUNT = 2L;

    private static final Double DEFAULT_RSRP_AVG = 1D;
    private static final Double UPDATED_RSRP_AVG = 2D;

    private static final Long DEFAULT_RSRQ_SUM = 1L;
    private static final Long UPDATED_RSRQ_SUM = 2L;

    private static final Long DEFAULT_RSRQ_COUNT = 1L;
    private static final Long UPDATED_RSRQ_COUNT = 2L;

    private static final Double DEFAULT_RSRQ_AVG = 1D;
    private static final Double UPDATED_RSRQ_AVG = 2D;

    private static final Long DEFAULT_ULSINR_SUM = 1L;
    private static final Long UPDATED_ULSINR_SUM = 2L;

    private static final Long DEFAULT_ULSINR_COUNT = 1L;
    private static final Long UPDATED_ULSINR_COUNT = 2L;

    private static final Double DEFAULT_ULSINR_AVG = 1D;
    private static final Double UPDATED_ULSINR_AVG = 2D;

    private static final Long DEFAULT_PHR_SUM = 1L;
    private static final Long UPDATED_PHR_SUM = 2L;

    private static final Long DEFAULT_PHR_COUNT = 1L;
    private static final Long UPDATED_PHR_COUNT = 2L;

    private static final Double DEFAULT_PHR_AVG = 1D;
    private static final Double UPDATED_PHR_AVG = 2D;

    private static final Long DEFAULT_ERP_SUM = 1L;
    private static final Long UPDATED_ERP_SUM = 2L;

    private static final Long DEFAULT_ERP_COUNT = 1L;
    private static final Long UPDATED_ERP_COUNT = 2L;

    private static final Double DEFAULT_ERP_AVG = 1D;
    private static final Double UPDATED_ERP_AVG = 2D;

    private static final Long DEFAULT_TA_SUM = 1L;
    private static final Long UPDATED_TA_SUM = 2L;

    private static final Long DEFAULT_TA_COUNT = 1L;
    private static final Long UPDATED_TA_COUNT = 2L;

    private static final Double DEFAULT_TA_AVG = 1D;
    private static final Double UPDATED_TA_AVG = 2D;

    private static final Long DEFAULT_OVERLAP_SUM = 1L;
    private static final Long UPDATED_OVERLAP_SUM = 2L;

    private static final Long DEFAULT_OVERLAP_COUNT = 1L;
    private static final Long UPDATED_OVERLAP_COUNT = 2L;

    private static final Double DEFAULT_OVERLAP_AVG = 1D;
    private static final Double UPDATED_OVERLAP_AVG = 2D;

    @Autowired
    private MrRepository mrRepository;

    @Autowired
    private MrMapper mrMapper;

    @Autowired
    private MrService mrService;

    @Autowired
    private MrSearchRepository mrSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restMrMockMvc;

    private Mr mr;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MrResource mrResource = new MrResource(mrService);
        this.restMrMockMvc = MockMvcBuilders.standaloneSetup(mrResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Mr createEntity(EntityManager em) {
        Mr mr = new Mr()
            .pdate(DEFAULT_PDATE)
            .phour(DEFAULT_PHOUR)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .rsrpSum(DEFAULT_RSRP_SUM)
            .rsrpCount(DEFAULT_RSRP_COUNT)
            .rsrpAvg(DEFAULT_RSRP_AVG)
            .rsrqSum(DEFAULT_RSRQ_SUM)
            .rsrqCount(DEFAULT_RSRQ_COUNT)
            .rsrqAvg(DEFAULT_RSRQ_AVG)
            .ulsinrSum(DEFAULT_ULSINR_SUM)
            .ulsinrCount(DEFAULT_ULSINR_COUNT)
            .ulsinrAvg(DEFAULT_ULSINR_AVG)
            .phrSum(DEFAULT_PHR_SUM)
            .phrCount(DEFAULT_PHR_COUNT)
            .phrAvg(DEFAULT_PHR_AVG)
            .erpSum(DEFAULT_ERP_SUM)
            .erpCount(DEFAULT_ERP_COUNT)
            .erpAvg(DEFAULT_ERP_AVG)
            .taSum(DEFAULT_TA_SUM)
            .taCount(DEFAULT_TA_COUNT)
            .taAvg(DEFAULT_TA_AVG)
            .overlapSum(DEFAULT_OVERLAP_SUM)
            .overlapCount(DEFAULT_OVERLAP_COUNT)
            .overlapAvg(DEFAULT_OVERLAP_AVG);
        return mr;
    }

    @Before
    public void initTest() {
        mrSearchRepository.deleteAll();
        mr = createEntity(em);
    }

    @Test
    @Transactional
    public void createMr() throws Exception {
        int databaseSizeBeforeCreate = mrRepository.findAll().size();

        // Create the Mr
        MrDTO mrDTO = mrMapper.toDto(mr);
        restMrMockMvc.perform(post("/api/mrs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mrDTO)))
            .andExpect(status().isCreated());

        // Validate the Mr in the database
        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeCreate + 1);
        Mr testMr = mrList.get(mrList.size() - 1);
        assertThat(testMr.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testMr.getPhour()).isEqualTo(DEFAULT_PHOUR);
        assertThat(testMr.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testMr.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testMr.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testMr.getRsrpSum()).isEqualTo(DEFAULT_RSRP_SUM);
        assertThat(testMr.getRsrpCount()).isEqualTo(DEFAULT_RSRP_COUNT);
        assertThat(testMr.getRsrpAvg()).isEqualTo(DEFAULT_RSRP_AVG);
        assertThat(testMr.getRsrqSum()).isEqualTo(DEFAULT_RSRQ_SUM);
        assertThat(testMr.getRsrqCount()).isEqualTo(DEFAULT_RSRQ_COUNT);
        assertThat(testMr.getRsrqAvg()).isEqualTo(DEFAULT_RSRQ_AVG);
        assertThat(testMr.getUlsinrSum()).isEqualTo(DEFAULT_ULSINR_SUM);
        assertThat(testMr.getUlsinrCount()).isEqualTo(DEFAULT_ULSINR_COUNT);
        assertThat(testMr.getUlsinrAvg()).isEqualTo(DEFAULT_ULSINR_AVG);
        assertThat(testMr.getPhrSum()).isEqualTo(DEFAULT_PHR_SUM);
        assertThat(testMr.getPhrCount()).isEqualTo(DEFAULT_PHR_COUNT);
        assertThat(testMr.getPhrAvg()).isEqualTo(DEFAULT_PHR_AVG);
        assertThat(testMr.getErpSum()).isEqualTo(DEFAULT_ERP_SUM);
        assertThat(testMr.getErpCount()).isEqualTo(DEFAULT_ERP_COUNT);
        assertThat(testMr.getErpAvg()).isEqualTo(DEFAULT_ERP_AVG);
        assertThat(testMr.getTaSum()).isEqualTo(DEFAULT_TA_SUM);
        assertThat(testMr.getTaCount()).isEqualTo(DEFAULT_TA_COUNT);
        assertThat(testMr.getTaAvg()).isEqualTo(DEFAULT_TA_AVG);
        assertThat(testMr.getOverlapSum()).isEqualTo(DEFAULT_OVERLAP_SUM);
        assertThat(testMr.getOverlapCount()).isEqualTo(DEFAULT_OVERLAP_COUNT);
        assertThat(testMr.getOverlapAvg()).isEqualTo(DEFAULT_OVERLAP_AVG);

        // Validate the Mr in Elasticsearch
        Mr mrEs = mrSearchRepository.findOne(testMr.getId());
        assertThat(mrEs).isEqualToComparingFieldByField(testMr);
    }

    @Test
    @Transactional
    public void createMrWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mrRepository.findAll().size();

        // Create the Mr with an existing ID
        mr.setId(1L);
        MrDTO mrDTO = mrMapper.toDto(mr);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMrMockMvc.perform(post("/api/mrs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mrDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = mrRepository.findAll().size();
        // set the field null
        mr.setPdate(null);

        // Create the Mr, which fails.
        MrDTO mrDTO = mrMapper.toDto(mr);

        restMrMockMvc.perform(post("/api/mrs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mrDTO)))
            .andExpect(status().isBadRequest());

        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMrs() throws Exception {
        // Initialize the database
        mrRepository.saveAndFlush(mr);

        // Get all the mrList
        restMrMockMvc.perform(get("/api/mrs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mr.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].rsrpSum").value(hasItem(DEFAULT_RSRP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rsrpCount").value(hasItem(DEFAULT_RSRP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].rsrpAvg").value(hasItem(DEFAULT_RSRP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].rsrqSum").value(hasItem(DEFAULT_RSRQ_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rsrqCount").value(hasItem(DEFAULT_RSRQ_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].rsrqAvg").value(hasItem(DEFAULT_RSRQ_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].ulsinrSum").value(hasItem(DEFAULT_ULSINR_SUM.intValue())))
            .andExpect(jsonPath("$.[*].ulsinrCount").value(hasItem(DEFAULT_ULSINR_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].ulsinrAvg").value(hasItem(DEFAULT_ULSINR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].phrSum").value(hasItem(DEFAULT_PHR_SUM.intValue())))
            .andExpect(jsonPath("$.[*].phrCount").value(hasItem(DEFAULT_PHR_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].phrAvg").value(hasItem(DEFAULT_PHR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].erpSum").value(hasItem(DEFAULT_ERP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].erpCount").value(hasItem(DEFAULT_ERP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].erpAvg").value(hasItem(DEFAULT_ERP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].taSum").value(hasItem(DEFAULT_TA_SUM.intValue())))
            .andExpect(jsonPath("$.[*].taCount").value(hasItem(DEFAULT_TA_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].taAvg").value(hasItem(DEFAULT_TA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].overlapSum").value(hasItem(DEFAULT_OVERLAP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].overlapCount").value(hasItem(DEFAULT_OVERLAP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].overlapAvg").value(hasItem(DEFAULT_OVERLAP_AVG.doubleValue())));
    }

    @Test
    @Transactional
    public void getMr() throws Exception {
        // Initialize the database
        mrRepository.saveAndFlush(mr);

        // Get the mr
        restMrMockMvc.perform(get("/api/mrs/{id}", mr.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(mr.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.phour").value(DEFAULT_PHOUR))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.toString()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.toString()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.toString()))
            .andExpect(jsonPath("$.rsrpSum").value(DEFAULT_RSRP_SUM.intValue()))
            .andExpect(jsonPath("$.rsrpCount").value(DEFAULT_RSRP_COUNT.intValue()))
            .andExpect(jsonPath("$.rsrpAvg").value(DEFAULT_RSRP_AVG.doubleValue()))
            .andExpect(jsonPath("$.rsrqSum").value(DEFAULT_RSRQ_SUM.intValue()))
            .andExpect(jsonPath("$.rsrqCount").value(DEFAULT_RSRQ_COUNT.intValue()))
            .andExpect(jsonPath("$.rsrqAvg").value(DEFAULT_RSRQ_AVG.doubleValue()))
            .andExpect(jsonPath("$.ulsinrSum").value(DEFAULT_ULSINR_SUM.intValue()))
            .andExpect(jsonPath("$.ulsinrCount").value(DEFAULT_ULSINR_COUNT.intValue()))
            .andExpect(jsonPath("$.ulsinrAvg").value(DEFAULT_ULSINR_AVG.doubleValue()))
            .andExpect(jsonPath("$.phrSum").value(DEFAULT_PHR_SUM.intValue()))
            .andExpect(jsonPath("$.phrCount").value(DEFAULT_PHR_COUNT.intValue()))
            .andExpect(jsonPath("$.phrAvg").value(DEFAULT_PHR_AVG.doubleValue()))
            .andExpect(jsonPath("$.erpSum").value(DEFAULT_ERP_SUM.intValue()))
            .andExpect(jsonPath("$.erpCount").value(DEFAULT_ERP_COUNT.intValue()))
            .andExpect(jsonPath("$.erpAvg").value(DEFAULT_ERP_AVG.doubleValue()))
            .andExpect(jsonPath("$.taSum").value(DEFAULT_TA_SUM.intValue()))
            .andExpect(jsonPath("$.taCount").value(DEFAULT_TA_COUNT.intValue()))
            .andExpect(jsonPath("$.taAvg").value(DEFAULT_TA_AVG.doubleValue()))
            .andExpect(jsonPath("$.overlapSum").value(DEFAULT_OVERLAP_SUM.intValue()))
            .andExpect(jsonPath("$.overlapCount").value(DEFAULT_OVERLAP_COUNT.intValue()))
            .andExpect(jsonPath("$.overlapAvg").value(DEFAULT_OVERLAP_AVG.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingMr() throws Exception {
        // Get the mr
        restMrMockMvc.perform(get("/api/mrs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMr() throws Exception {
        // Initialize the database
        mrRepository.saveAndFlush(mr);
        mrSearchRepository.save(mr);
        int databaseSizeBeforeUpdate = mrRepository.findAll().size();

        // Update the mr
        Mr updatedMr = mrRepository.findOne(mr.getId());
        updatedMr
            .pdate(UPDATED_PDATE)
            .phour(UPDATED_PHOUR)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .rsrpSum(UPDATED_RSRP_SUM)
            .rsrpCount(UPDATED_RSRP_COUNT)
            .rsrpAvg(UPDATED_RSRP_AVG)
            .rsrqSum(UPDATED_RSRQ_SUM)
            .rsrqCount(UPDATED_RSRQ_COUNT)
            .rsrqAvg(UPDATED_RSRQ_AVG)
            .ulsinrSum(UPDATED_ULSINR_SUM)
            .ulsinrCount(UPDATED_ULSINR_COUNT)
            .ulsinrAvg(UPDATED_ULSINR_AVG)
            .phrSum(UPDATED_PHR_SUM)
            .phrCount(UPDATED_PHR_COUNT)
            .phrAvg(UPDATED_PHR_AVG)
            .erpSum(UPDATED_ERP_SUM)
            .erpCount(UPDATED_ERP_COUNT)
            .erpAvg(UPDATED_ERP_AVG)
            .taSum(UPDATED_TA_SUM)
            .taCount(UPDATED_TA_COUNT)
            .taAvg(UPDATED_TA_AVG)
            .overlapSum(UPDATED_OVERLAP_SUM)
            .overlapCount(UPDATED_OVERLAP_COUNT)
            .overlapAvg(UPDATED_OVERLAP_AVG);
        MrDTO mrDTO = mrMapper.toDto(updatedMr);

        restMrMockMvc.perform(put("/api/mrs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mrDTO)))
            .andExpect(status().isOk());

        // Validate the Mr in the database
        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeUpdate);
        Mr testMr = mrList.get(mrList.size() - 1);
        assertThat(testMr.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testMr.getPhour()).isEqualTo(UPDATED_PHOUR);
        assertThat(testMr.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testMr.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testMr.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testMr.getRsrpSum()).isEqualTo(UPDATED_RSRP_SUM);
        assertThat(testMr.getRsrpCount()).isEqualTo(UPDATED_RSRP_COUNT);
        assertThat(testMr.getRsrpAvg()).isEqualTo(UPDATED_RSRP_AVG);
        assertThat(testMr.getRsrqSum()).isEqualTo(UPDATED_RSRQ_SUM);
        assertThat(testMr.getRsrqCount()).isEqualTo(UPDATED_RSRQ_COUNT);
        assertThat(testMr.getRsrqAvg()).isEqualTo(UPDATED_RSRQ_AVG);
        assertThat(testMr.getUlsinrSum()).isEqualTo(UPDATED_ULSINR_SUM);
        assertThat(testMr.getUlsinrCount()).isEqualTo(UPDATED_ULSINR_COUNT);
        assertThat(testMr.getUlsinrAvg()).isEqualTo(UPDATED_ULSINR_AVG);
        assertThat(testMr.getPhrSum()).isEqualTo(UPDATED_PHR_SUM);
        assertThat(testMr.getPhrCount()).isEqualTo(UPDATED_PHR_COUNT);
        assertThat(testMr.getPhrAvg()).isEqualTo(UPDATED_PHR_AVG);
        assertThat(testMr.getErpSum()).isEqualTo(UPDATED_ERP_SUM);
        assertThat(testMr.getErpCount()).isEqualTo(UPDATED_ERP_COUNT);
        assertThat(testMr.getErpAvg()).isEqualTo(UPDATED_ERP_AVG);
        assertThat(testMr.getTaSum()).isEqualTo(UPDATED_TA_SUM);
        assertThat(testMr.getTaCount()).isEqualTo(UPDATED_TA_COUNT);
        assertThat(testMr.getTaAvg()).isEqualTo(UPDATED_TA_AVG);
        assertThat(testMr.getOverlapSum()).isEqualTo(UPDATED_OVERLAP_SUM);
        assertThat(testMr.getOverlapCount()).isEqualTo(UPDATED_OVERLAP_COUNT);
        assertThat(testMr.getOverlapAvg()).isEqualTo(UPDATED_OVERLAP_AVG);

        // Validate the Mr in Elasticsearch
        Mr mrEs = mrSearchRepository.findOne(testMr.getId());
        assertThat(mrEs).isEqualToComparingFieldByField(testMr);
    }

    @Test
    @Transactional
    public void updateNonExistingMr() throws Exception {
        int databaseSizeBeforeUpdate = mrRepository.findAll().size();

        // Create the Mr
        MrDTO mrDTO = mrMapper.toDto(mr);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restMrMockMvc.perform(put("/api/mrs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mrDTO)))
            .andExpect(status().isCreated());

        // Validate the Mr in the database
        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteMr() throws Exception {
        // Initialize the database
        mrRepository.saveAndFlush(mr);
        mrSearchRepository.save(mr);
        int databaseSizeBeforeDelete = mrRepository.findAll().size();

        // Get the mr
        restMrMockMvc.perform(delete("/api/mrs/{id}", mr.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean mrExistsInEs = mrSearchRepository.exists(mr.getId());
        assertThat(mrExistsInEs).isFalse();

        // Validate the database is empty
        List<Mr> mrList = mrRepository.findAll();
        assertThat(mrList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchMr() throws Exception {
        // Initialize the database
        mrRepository.saveAndFlush(mr);
        mrSearchRepository.save(mr);

        // Search the mr
        restMrMockMvc.perform(get("/api/_search/mrs?query=id:" + mr.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mr.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].rsrpSum").value(hasItem(DEFAULT_RSRP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rsrpCount").value(hasItem(DEFAULT_RSRP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].rsrpAvg").value(hasItem(DEFAULT_RSRP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].rsrqSum").value(hasItem(DEFAULT_RSRQ_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rsrqCount").value(hasItem(DEFAULT_RSRQ_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].rsrqAvg").value(hasItem(DEFAULT_RSRQ_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].ulsinrSum").value(hasItem(DEFAULT_ULSINR_SUM.intValue())))
            .andExpect(jsonPath("$.[*].ulsinrCount").value(hasItem(DEFAULT_ULSINR_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].ulsinrAvg").value(hasItem(DEFAULT_ULSINR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].phrSum").value(hasItem(DEFAULT_PHR_SUM.intValue())))
            .andExpect(jsonPath("$.[*].phrCount").value(hasItem(DEFAULT_PHR_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].phrAvg").value(hasItem(DEFAULT_PHR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].erpSum").value(hasItem(DEFAULT_ERP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].erpCount").value(hasItem(DEFAULT_ERP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].erpAvg").value(hasItem(DEFAULT_ERP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].taSum").value(hasItem(DEFAULT_TA_SUM.intValue())))
            .andExpect(jsonPath("$.[*].taCount").value(hasItem(DEFAULT_TA_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].taAvg").value(hasItem(DEFAULT_TA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].overlapSum").value(hasItem(DEFAULT_OVERLAP_SUM.intValue())))
            .andExpect(jsonPath("$.[*].overlapCount").value(hasItem(DEFAULT_OVERLAP_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].overlapAvg").value(hasItem(DEFAULT_OVERLAP_AVG.doubleValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Mr.class);
        Mr mr1 = new Mr();
        mr1.setId(1L);
        Mr mr2 = new Mr();
        mr2.setId(mr1.getId());
        assertThat(mr1).isEqualTo(mr2);
        mr2.setId(2L);
        assertThat(mr1).isNotEqualTo(mr2);
        mr1.setId(null);
        assertThat(mr1).isNotEqualTo(mr2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MrDTO.class);
        MrDTO mrDTO1 = new MrDTO();
        mrDTO1.setId(1L);
        MrDTO mrDTO2 = new MrDTO();
        assertThat(mrDTO1).isNotEqualTo(mrDTO2);
        mrDTO2.setId(mrDTO1.getId());
        assertThat(mrDTO1).isEqualTo(mrDTO2);
        mrDTO2.setId(2L);
        assertThat(mrDTO1).isNotEqualTo(mrDTO2);
        mrDTO1.setId(null);
        assertThat(mrDTO1).isNotEqualTo(mrDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(mrMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(mrMapper.fromId(null)).isNull();
    }
}
