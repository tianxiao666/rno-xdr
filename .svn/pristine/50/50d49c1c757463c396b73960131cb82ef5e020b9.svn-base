package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.ExceptionStats;
import com.hgicreate.rno.xdr.backend.repository.ExceptionStatsRepository;
import com.hgicreate.rno.xdr.backend.service.ExceptionStatsService;
import com.hgicreate.rno.xdr.backend.repository.search.ExceptionStatsSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionStatsDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.ExceptionStatsMapper;
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
 * Test class for the ExceptionStatsResource REST controller.
 *
 * @see ExceptionStatsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class ExceptionStatsResourceIntTest {

    private static final LocalDate DEFAULT_PDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_CELL = 1L;
    private static final Long UPDATED_CELL = 2L;

    private static final Long DEFAULT_IMEI = 1L;
    private static final Long UPDATED_IMEI = 2L;

    private static final Long DEFAULT_IMSI = 1L;
    private static final Long UPDATED_IMSI = 2L;

    private static final Double DEFAULT_ATTACH_FAULT_RATE = 1D;
    private static final Double UPDATED_ATTACH_FAULT_RATE = 2D;

    private static final Integer DEFAULT_ATTACH_REQUEST = 1;
    private static final Integer UPDATED_ATTACH_REQUEST = 2;

    private static final Integer DEFAULT_ATTACH_FAULT = 1;
    private static final Integer UPDATED_ATTACH_FAULT = 2;

    private static final Double DEFAULT_SERVICE_FAULT_RATE = 1D;
    private static final Double UPDATED_SERVICE_FAULT_RATE = 2D;

    private static final Integer DEFAULT_SERVICE_REQUEST = 1;
    private static final Integer UPDATED_SERVICE_REQUEST = 2;

    private static final Integer DEFAULT_SERVICE_FAULT = 1;
    private static final Integer UPDATED_SERVICE_FAULT = 2;

    private static final Double DEFAULT_CSFB_FAULT_RATE = 1D;
    private static final Double UPDATED_CSFB_FAULT_RATE = 2D;

    private static final Integer DEFAULT_CSFB_REQUEST = 1;
    private static final Integer UPDATED_CSFB_REQUEST = 2;

    private static final Integer DEFAULT_CSFB_FAULT = 1;
    private static final Integer UPDATED_CSFB_FAULT = 2;

    private static final Double DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE = 1D;
    private static final Double UPDATED_CONTEXT_ACTIVATE_FAULT_RATE = 2D;

    private static final Integer DEFAULT_CONTEXT_ACTIVATE_REQUEST = 1;
    private static final Integer UPDATED_CONTEXT_ACTIVATE_REQUEST = 2;

    private static final Integer DEFAULT_CONTEXT_ACTIVATE_FAULT = 1;
    private static final Integer UPDATED_CONTEXT_ACTIVATE_FAULT = 2;

    private static final Double DEFAULT_PDN_REQUEST_FAULT_RATE = 1D;
    private static final Double UPDATED_PDN_REQUEST_FAULT_RATE = 2D;

    private static final Integer DEFAULT_PDN_REQUEST = 1;
    private static final Integer UPDATED_PDN_REQUEST = 2;

    private static final Integer DEFAULT_PDN_REQUEST_FAULT = 1;
    private static final Integer UPDATED_PDN_REQUEST_FAULT = 2;

    private static final Double DEFAULT_TAU_FAULT_RATE = 1D;
    private static final Double UPDATED_TAU_FAULT_RATE = 2D;

    private static final Integer DEFAULT_TAU_REQUEST = 1;
    private static final Integer UPDATED_TAU_REQUEST = 2;

    private static final Integer DEFAULT_TAU_FAULT = 1;
    private static final Integer UPDATED_TAU_FAULT = 2;

    private static final Double DEFAULT_XHO_FAULT_RATE = 1D;
    private static final Double UPDATED_XHO_FAULT_RATE = 2D;

    private static final Integer DEFAULT_XHO_REQUEST = 1;
    private static final Integer UPDATED_XHO_REQUEST = 2;

    private static final Integer DEFAULT_XHO_FAULT = 1;
    private static final Integer UPDATED_XHO_FAULT = 2;

    private static final Double DEFAULT_SHO_FAULT_RATE = 1D;
    private static final Double UPDATED_SHO_FAULT_RATE = 2D;

    private static final Integer DEFAULT_SHO_REQUEST = 1;
    private static final Integer UPDATED_SHO_REQUEST = 2;

    private static final Integer DEFAULT_SHO_FAULT = 1;
    private static final Integer UPDATED_SHO_FAULT = 2;

    @Autowired
    private ExceptionStatsRepository exceptionStatsRepository;

    @Autowired
    private ExceptionStatsMapper exceptionStatsMapper;

    @Autowired
    private ExceptionStatsService exceptionStatsService;

    @Autowired
    private ExceptionStatsSearchRepository exceptionStatsSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restExceptionStatsMockMvc;

    private ExceptionStats exceptionStats;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ExceptionStatsResource exceptionStatsResource = new ExceptionStatsResource(exceptionStatsService);
        this.restExceptionStatsMockMvc = MockMvcBuilders.standaloneSetup(exceptionStatsResource)
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
    public static ExceptionStats createEntity(EntityManager em) {
        ExceptionStats exceptionStats = new ExceptionStats()
            .pdate(DEFAULT_PDATE)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .attachFaultRate(DEFAULT_ATTACH_FAULT_RATE)
            .attachRequest(DEFAULT_ATTACH_REQUEST)
            .attachFault(DEFAULT_ATTACH_FAULT)
            .serviceFaultRate(DEFAULT_SERVICE_FAULT_RATE)
            .serviceRequest(DEFAULT_SERVICE_REQUEST)
            .serviceFault(DEFAULT_SERVICE_FAULT)
            .csfbFaultRate(DEFAULT_CSFB_FAULT_RATE)
            .csfbRequest(DEFAULT_CSFB_REQUEST)
            .csfbFault(DEFAULT_CSFB_FAULT)
            .contextActivateFaultRate(DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE)
            .contextActivateRequest(DEFAULT_CONTEXT_ACTIVATE_REQUEST)
            .contextActivateFault(DEFAULT_CONTEXT_ACTIVATE_FAULT)
            .pdnRequestFaultRate(DEFAULT_PDN_REQUEST_FAULT_RATE)
            .pdnRequest(DEFAULT_PDN_REQUEST)
            .pdnRequestFault(DEFAULT_PDN_REQUEST_FAULT)
            .tauFaultRate(DEFAULT_TAU_FAULT_RATE)
            .tauRequest(DEFAULT_TAU_REQUEST)
            .tauFault(DEFAULT_TAU_FAULT)
            .xhoFaultRate(DEFAULT_XHO_FAULT_RATE)
            .xhoRequest(DEFAULT_XHO_REQUEST)
            .xhoFault(DEFAULT_XHO_FAULT)
            .shoFaultRate(DEFAULT_SHO_FAULT_RATE)
            .shoRequest(DEFAULT_SHO_REQUEST)
            .shoFault(DEFAULT_SHO_FAULT);
        return exceptionStats;
    }

    @Before
    public void initTest() {
        exceptionStatsSearchRepository.deleteAll();
        exceptionStats = createEntity(em);
    }

    @Test
    @Transactional
    public void createExceptionStats() throws Exception {
        int databaseSizeBeforeCreate = exceptionStatsRepository.findAll().size();

        // Create the ExceptionStats
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsMapper.toDto(exceptionStats);
        restExceptionStatsMockMvc.perform(post("/api/exception-stats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionStatsDTO)))
            .andExpect(status().isCreated());

        // Validate the ExceptionStats in the database
        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeCreate + 1);
        ExceptionStats testExceptionStats = exceptionStatsList.get(exceptionStatsList.size() - 1);
        assertThat(testExceptionStats.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testExceptionStats.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testExceptionStats.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testExceptionStats.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testExceptionStats.getAttachFaultRate()).isEqualTo(DEFAULT_ATTACH_FAULT_RATE);
        assertThat(testExceptionStats.getAttachRequest()).isEqualTo(DEFAULT_ATTACH_REQUEST);
        assertThat(testExceptionStats.getAttachFault()).isEqualTo(DEFAULT_ATTACH_FAULT);
        assertThat(testExceptionStats.getServiceFaultRate()).isEqualTo(DEFAULT_SERVICE_FAULT_RATE);
        assertThat(testExceptionStats.getServiceRequest()).isEqualTo(DEFAULT_SERVICE_REQUEST);
        assertThat(testExceptionStats.getServiceFault()).isEqualTo(DEFAULT_SERVICE_FAULT);
        assertThat(testExceptionStats.getCsfbFaultRate()).isEqualTo(DEFAULT_CSFB_FAULT_RATE);
        assertThat(testExceptionStats.getCsfbRequest()).isEqualTo(DEFAULT_CSFB_REQUEST);
        assertThat(testExceptionStats.getCsfbFault()).isEqualTo(DEFAULT_CSFB_FAULT);
        assertThat(testExceptionStats.getContextActivateFaultRate()).isEqualTo(DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE);
        assertThat(testExceptionStats.getContextActivateRequest()).isEqualTo(DEFAULT_CONTEXT_ACTIVATE_REQUEST);
        assertThat(testExceptionStats.getContextActivateFault()).isEqualTo(DEFAULT_CONTEXT_ACTIVATE_FAULT);
        assertThat(testExceptionStats.getPdnRequestFaultRate()).isEqualTo(DEFAULT_PDN_REQUEST_FAULT_RATE);
        assertThat(testExceptionStats.getPdnRequest()).isEqualTo(DEFAULT_PDN_REQUEST);
        assertThat(testExceptionStats.getPdnRequestFault()).isEqualTo(DEFAULT_PDN_REQUEST_FAULT);
        assertThat(testExceptionStats.getTauFaultRate()).isEqualTo(DEFAULT_TAU_FAULT_RATE);
        assertThat(testExceptionStats.getTauRequest()).isEqualTo(DEFAULT_TAU_REQUEST);
        assertThat(testExceptionStats.getTauFault()).isEqualTo(DEFAULT_TAU_FAULT);
        assertThat(testExceptionStats.getXhoFaultRate()).isEqualTo(DEFAULT_XHO_FAULT_RATE);
        assertThat(testExceptionStats.getXhoRequest()).isEqualTo(DEFAULT_XHO_REQUEST);
        assertThat(testExceptionStats.getXhoFault()).isEqualTo(DEFAULT_XHO_FAULT);
        assertThat(testExceptionStats.getShoFaultRate()).isEqualTo(DEFAULT_SHO_FAULT_RATE);
        assertThat(testExceptionStats.getShoRequest()).isEqualTo(DEFAULT_SHO_REQUEST);
        assertThat(testExceptionStats.getShoFault()).isEqualTo(DEFAULT_SHO_FAULT);

        // Validate the ExceptionStats in Elasticsearch
        ExceptionStats exceptionStatsEs = exceptionStatsSearchRepository.findOne(testExceptionStats.getId());
        assertThat(exceptionStatsEs).isEqualToComparingFieldByField(testExceptionStats);
    }

    @Test
    @Transactional
    public void createExceptionStatsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = exceptionStatsRepository.findAll().size();

        // Create the ExceptionStats with an existing ID
        exceptionStats.setId(1L);
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsMapper.toDto(exceptionStats);

        // An entity with an existing ID cannot be created, so this API call must fail
        restExceptionStatsMockMvc.perform(post("/api/exception-stats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionStatsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = exceptionStatsRepository.findAll().size();
        // set the field null
        exceptionStats.setPdate(null);

        // Create the ExceptionStats, which fails.
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsMapper.toDto(exceptionStats);

        restExceptionStatsMockMvc.perform(post("/api/exception-stats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionStatsDTO)))
            .andExpect(status().isBadRequest());

        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllExceptionStats() throws Exception {
        // Initialize the database
        exceptionStatsRepository.saveAndFlush(exceptionStats);

        // Get all the exceptionStatsList
        restExceptionStatsMockMvc.perform(get("/api/exception-stats?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exceptionStats.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].attachFaultRate").value(hasItem(DEFAULT_ATTACH_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].attachRequest").value(hasItem(DEFAULT_ATTACH_REQUEST)))
            .andExpect(jsonPath("$.[*].attachFault").value(hasItem(DEFAULT_ATTACH_FAULT)))
            .andExpect(jsonPath("$.[*].serviceFaultRate").value(hasItem(DEFAULT_SERVICE_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST)))
            .andExpect(jsonPath("$.[*].serviceFault").value(hasItem(DEFAULT_SERVICE_FAULT)))
            .andExpect(jsonPath("$.[*].csfbFaultRate").value(hasItem(DEFAULT_CSFB_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].csfbRequest").value(hasItem(DEFAULT_CSFB_REQUEST)))
            .andExpect(jsonPath("$.[*].csfbFault").value(hasItem(DEFAULT_CSFB_FAULT)))
            .andExpect(jsonPath("$.[*].contextActivateFaultRate").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].contextActivateRequest").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_REQUEST)))
            .andExpect(jsonPath("$.[*].contextActivateFault").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_FAULT)))
            .andExpect(jsonPath("$.[*].pdnRequestFaultRate").value(hasItem(DEFAULT_PDN_REQUEST_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].pdnRequest").value(hasItem(DEFAULT_PDN_REQUEST)))
            .andExpect(jsonPath("$.[*].pdnRequestFault").value(hasItem(DEFAULT_PDN_REQUEST_FAULT)))
            .andExpect(jsonPath("$.[*].tauFaultRate").value(hasItem(DEFAULT_TAU_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tauRequest").value(hasItem(DEFAULT_TAU_REQUEST)))
            .andExpect(jsonPath("$.[*].tauFault").value(hasItem(DEFAULT_TAU_FAULT)))
            .andExpect(jsonPath("$.[*].xhoFaultRate").value(hasItem(DEFAULT_XHO_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xhoRequest").value(hasItem(DEFAULT_XHO_REQUEST)))
            .andExpect(jsonPath("$.[*].xhoFault").value(hasItem(DEFAULT_XHO_FAULT)))
            .andExpect(jsonPath("$.[*].shoFaultRate").value(hasItem(DEFAULT_SHO_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].shoRequest").value(hasItem(DEFAULT_SHO_REQUEST)))
            .andExpect(jsonPath("$.[*].shoFault").value(hasItem(DEFAULT_SHO_FAULT)));
    }

    @Test
    @Transactional
    public void getExceptionStats() throws Exception {
        // Initialize the database
        exceptionStatsRepository.saveAndFlush(exceptionStats);

        // Get the exceptionStats
        restExceptionStatsMockMvc.perform(get("/api/exception-stats/{id}", exceptionStats.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(exceptionStats.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.intValue()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.intValue()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.intValue()))
            .andExpect(jsonPath("$.attachFaultRate").value(DEFAULT_ATTACH_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.attachRequest").value(DEFAULT_ATTACH_REQUEST))
            .andExpect(jsonPath("$.attachFault").value(DEFAULT_ATTACH_FAULT))
            .andExpect(jsonPath("$.serviceFaultRate").value(DEFAULT_SERVICE_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.serviceRequest").value(DEFAULT_SERVICE_REQUEST))
            .andExpect(jsonPath("$.serviceFault").value(DEFAULT_SERVICE_FAULT))
            .andExpect(jsonPath("$.csfbFaultRate").value(DEFAULT_CSFB_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.csfbRequest").value(DEFAULT_CSFB_REQUEST))
            .andExpect(jsonPath("$.csfbFault").value(DEFAULT_CSFB_FAULT))
            .andExpect(jsonPath("$.contextActivateFaultRate").value(DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.contextActivateRequest").value(DEFAULT_CONTEXT_ACTIVATE_REQUEST))
            .andExpect(jsonPath("$.contextActivateFault").value(DEFAULT_CONTEXT_ACTIVATE_FAULT))
            .andExpect(jsonPath("$.pdnRequestFaultRate").value(DEFAULT_PDN_REQUEST_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.pdnRequest").value(DEFAULT_PDN_REQUEST))
            .andExpect(jsonPath("$.pdnRequestFault").value(DEFAULT_PDN_REQUEST_FAULT))
            .andExpect(jsonPath("$.tauFaultRate").value(DEFAULT_TAU_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.tauRequest").value(DEFAULT_TAU_REQUEST))
            .andExpect(jsonPath("$.tauFault").value(DEFAULT_TAU_FAULT))
            .andExpect(jsonPath("$.xhoFaultRate").value(DEFAULT_XHO_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.xhoRequest").value(DEFAULT_XHO_REQUEST))
            .andExpect(jsonPath("$.xhoFault").value(DEFAULT_XHO_FAULT))
            .andExpect(jsonPath("$.shoFaultRate").value(DEFAULT_SHO_FAULT_RATE.doubleValue()))
            .andExpect(jsonPath("$.shoRequest").value(DEFAULT_SHO_REQUEST))
            .andExpect(jsonPath("$.shoFault").value(DEFAULT_SHO_FAULT));
    }

    @Test
    @Transactional
    public void getNonExistingExceptionStats() throws Exception {
        // Get the exceptionStats
        restExceptionStatsMockMvc.perform(get("/api/exception-stats/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateExceptionStats() throws Exception {
        // Initialize the database
        exceptionStatsRepository.saveAndFlush(exceptionStats);
        exceptionStatsSearchRepository.save(exceptionStats);
        int databaseSizeBeforeUpdate = exceptionStatsRepository.findAll().size();

        // Update the exceptionStats
        ExceptionStats updatedExceptionStats = exceptionStatsRepository.findOne(exceptionStats.getId());
        updatedExceptionStats
            .pdate(UPDATED_PDATE)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .attachFaultRate(UPDATED_ATTACH_FAULT_RATE)
            .attachRequest(UPDATED_ATTACH_REQUEST)
            .attachFault(UPDATED_ATTACH_FAULT)
            .serviceFaultRate(UPDATED_SERVICE_FAULT_RATE)
            .serviceRequest(UPDATED_SERVICE_REQUEST)
            .serviceFault(UPDATED_SERVICE_FAULT)
            .csfbFaultRate(UPDATED_CSFB_FAULT_RATE)
            .csfbRequest(UPDATED_CSFB_REQUEST)
            .csfbFault(UPDATED_CSFB_FAULT)
            .contextActivateFaultRate(UPDATED_CONTEXT_ACTIVATE_FAULT_RATE)
            .contextActivateRequest(UPDATED_CONTEXT_ACTIVATE_REQUEST)
            .contextActivateFault(UPDATED_CONTEXT_ACTIVATE_FAULT)
            .pdnRequestFaultRate(UPDATED_PDN_REQUEST_FAULT_RATE)
            .pdnRequest(UPDATED_PDN_REQUEST)
            .pdnRequestFault(UPDATED_PDN_REQUEST_FAULT)
            .tauFaultRate(UPDATED_TAU_FAULT_RATE)
            .tauRequest(UPDATED_TAU_REQUEST)
            .tauFault(UPDATED_TAU_FAULT)
            .xhoFaultRate(UPDATED_XHO_FAULT_RATE)
            .xhoRequest(UPDATED_XHO_REQUEST)
            .xhoFault(UPDATED_XHO_FAULT)
            .shoFaultRate(UPDATED_SHO_FAULT_RATE)
            .shoRequest(UPDATED_SHO_REQUEST)
            .shoFault(UPDATED_SHO_FAULT);
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsMapper.toDto(updatedExceptionStats);

        restExceptionStatsMockMvc.perform(put("/api/exception-stats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionStatsDTO)))
            .andExpect(status().isOk());

        // Validate the ExceptionStats in the database
        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeUpdate);
        ExceptionStats testExceptionStats = exceptionStatsList.get(exceptionStatsList.size() - 1);
        assertThat(testExceptionStats.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testExceptionStats.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testExceptionStats.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testExceptionStats.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testExceptionStats.getAttachFaultRate()).isEqualTo(UPDATED_ATTACH_FAULT_RATE);
        assertThat(testExceptionStats.getAttachRequest()).isEqualTo(UPDATED_ATTACH_REQUEST);
        assertThat(testExceptionStats.getAttachFault()).isEqualTo(UPDATED_ATTACH_FAULT);
        assertThat(testExceptionStats.getServiceFaultRate()).isEqualTo(UPDATED_SERVICE_FAULT_RATE);
        assertThat(testExceptionStats.getServiceRequest()).isEqualTo(UPDATED_SERVICE_REQUEST);
        assertThat(testExceptionStats.getServiceFault()).isEqualTo(UPDATED_SERVICE_FAULT);
        assertThat(testExceptionStats.getCsfbFaultRate()).isEqualTo(UPDATED_CSFB_FAULT_RATE);
        assertThat(testExceptionStats.getCsfbRequest()).isEqualTo(UPDATED_CSFB_REQUEST);
        assertThat(testExceptionStats.getCsfbFault()).isEqualTo(UPDATED_CSFB_FAULT);
        assertThat(testExceptionStats.getContextActivateFaultRate()).isEqualTo(UPDATED_CONTEXT_ACTIVATE_FAULT_RATE);
        assertThat(testExceptionStats.getContextActivateRequest()).isEqualTo(UPDATED_CONTEXT_ACTIVATE_REQUEST);
        assertThat(testExceptionStats.getContextActivateFault()).isEqualTo(UPDATED_CONTEXT_ACTIVATE_FAULT);
        assertThat(testExceptionStats.getPdnRequestFaultRate()).isEqualTo(UPDATED_PDN_REQUEST_FAULT_RATE);
        assertThat(testExceptionStats.getPdnRequest()).isEqualTo(UPDATED_PDN_REQUEST);
        assertThat(testExceptionStats.getPdnRequestFault()).isEqualTo(UPDATED_PDN_REQUEST_FAULT);
        assertThat(testExceptionStats.getTauFaultRate()).isEqualTo(UPDATED_TAU_FAULT_RATE);
        assertThat(testExceptionStats.getTauRequest()).isEqualTo(UPDATED_TAU_REQUEST);
        assertThat(testExceptionStats.getTauFault()).isEqualTo(UPDATED_TAU_FAULT);
        assertThat(testExceptionStats.getXhoFaultRate()).isEqualTo(UPDATED_XHO_FAULT_RATE);
        assertThat(testExceptionStats.getXhoRequest()).isEqualTo(UPDATED_XHO_REQUEST);
        assertThat(testExceptionStats.getXhoFault()).isEqualTo(UPDATED_XHO_FAULT);
        assertThat(testExceptionStats.getShoFaultRate()).isEqualTo(UPDATED_SHO_FAULT_RATE);
        assertThat(testExceptionStats.getShoRequest()).isEqualTo(UPDATED_SHO_REQUEST);
        assertThat(testExceptionStats.getShoFault()).isEqualTo(UPDATED_SHO_FAULT);

        // Validate the ExceptionStats in Elasticsearch
        ExceptionStats exceptionStatsEs = exceptionStatsSearchRepository.findOne(testExceptionStats.getId());
        assertThat(exceptionStatsEs).isEqualToComparingFieldByField(testExceptionStats);
    }

    @Test
    @Transactional
    public void updateNonExistingExceptionStats() throws Exception {
        int databaseSizeBeforeUpdate = exceptionStatsRepository.findAll().size();

        // Create the ExceptionStats
        ExceptionStatsDTO exceptionStatsDTO = exceptionStatsMapper.toDto(exceptionStats);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restExceptionStatsMockMvc.perform(put("/api/exception-stats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionStatsDTO)))
            .andExpect(status().isCreated());

        // Validate the ExceptionStats in the database
        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteExceptionStats() throws Exception {
        // Initialize the database
        exceptionStatsRepository.saveAndFlush(exceptionStats);
        exceptionStatsSearchRepository.save(exceptionStats);
        int databaseSizeBeforeDelete = exceptionStatsRepository.findAll().size();

        // Get the exceptionStats
        restExceptionStatsMockMvc.perform(delete("/api/exception-stats/{id}", exceptionStats.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean exceptionStatsExistsInEs = exceptionStatsSearchRepository.exists(exceptionStats.getId());
        assertThat(exceptionStatsExistsInEs).isFalse();

        // Validate the database is empty
        List<ExceptionStats> exceptionStatsList = exceptionStatsRepository.findAll();
        assertThat(exceptionStatsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchExceptionStats() throws Exception {
        // Initialize the database
        exceptionStatsRepository.saveAndFlush(exceptionStats);
        exceptionStatsSearchRepository.save(exceptionStats);

        // Search the exceptionStats
        restExceptionStatsMockMvc.perform(get("/api/_search/exception-stats?query=id:" + exceptionStats.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exceptionStats.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].attachFaultRate").value(hasItem(DEFAULT_ATTACH_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].attachRequest").value(hasItem(DEFAULT_ATTACH_REQUEST)))
            .andExpect(jsonPath("$.[*].attachFault").value(hasItem(DEFAULT_ATTACH_FAULT)))
            .andExpect(jsonPath("$.[*].serviceFaultRate").value(hasItem(DEFAULT_SERVICE_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST)))
            .andExpect(jsonPath("$.[*].serviceFault").value(hasItem(DEFAULT_SERVICE_FAULT)))
            .andExpect(jsonPath("$.[*].csfbFaultRate").value(hasItem(DEFAULT_CSFB_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].csfbRequest").value(hasItem(DEFAULT_CSFB_REQUEST)))
            .andExpect(jsonPath("$.[*].csfbFault").value(hasItem(DEFAULT_CSFB_FAULT)))
            .andExpect(jsonPath("$.[*].contextActivateFaultRate").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].contextActivateRequest").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_REQUEST)))
            .andExpect(jsonPath("$.[*].contextActivateFault").value(hasItem(DEFAULT_CONTEXT_ACTIVATE_FAULT)))
            .andExpect(jsonPath("$.[*].pdnRequestFaultRate").value(hasItem(DEFAULT_PDN_REQUEST_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].pdnRequest").value(hasItem(DEFAULT_PDN_REQUEST)))
            .andExpect(jsonPath("$.[*].pdnRequestFault").value(hasItem(DEFAULT_PDN_REQUEST_FAULT)))
            .andExpect(jsonPath("$.[*].tauFaultRate").value(hasItem(DEFAULT_TAU_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tauRequest").value(hasItem(DEFAULT_TAU_REQUEST)))
            .andExpect(jsonPath("$.[*].tauFault").value(hasItem(DEFAULT_TAU_FAULT)))
            .andExpect(jsonPath("$.[*].xhoFaultRate").value(hasItem(DEFAULT_XHO_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xhoRequest").value(hasItem(DEFAULT_XHO_REQUEST)))
            .andExpect(jsonPath("$.[*].xhoFault").value(hasItem(DEFAULT_XHO_FAULT)))
            .andExpect(jsonPath("$.[*].shoFaultRate").value(hasItem(DEFAULT_SHO_FAULT_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].shoRequest").value(hasItem(DEFAULT_SHO_REQUEST)))
            .andExpect(jsonPath("$.[*].shoFault").value(hasItem(DEFAULT_SHO_FAULT)));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ExceptionStats.class);
        ExceptionStats exceptionStats1 = new ExceptionStats();
        exceptionStats1.setId(1L);
        ExceptionStats exceptionStats2 = new ExceptionStats();
        exceptionStats2.setId(exceptionStats1.getId());
        assertThat(exceptionStats1).isEqualTo(exceptionStats2);
        exceptionStats2.setId(2L);
        assertThat(exceptionStats1).isNotEqualTo(exceptionStats2);
        exceptionStats1.setId(null);
        assertThat(exceptionStats1).isNotEqualTo(exceptionStats2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ExceptionStatsDTO.class);
        ExceptionStatsDTO exceptionStatsDTO1 = new ExceptionStatsDTO();
        exceptionStatsDTO1.setId(1L);
        ExceptionStatsDTO exceptionStatsDTO2 = new ExceptionStatsDTO();
        assertThat(exceptionStatsDTO1).isNotEqualTo(exceptionStatsDTO2);
        exceptionStatsDTO2.setId(exceptionStatsDTO1.getId());
        assertThat(exceptionStatsDTO1).isEqualTo(exceptionStatsDTO2);
        exceptionStatsDTO2.setId(2L);
        assertThat(exceptionStatsDTO1).isNotEqualTo(exceptionStatsDTO2);
        exceptionStatsDTO1.setId(null);
        assertThat(exceptionStatsDTO1).isNotEqualTo(exceptionStatsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(exceptionStatsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(exceptionStatsMapper.fromId(null)).isNull();
    }
}
