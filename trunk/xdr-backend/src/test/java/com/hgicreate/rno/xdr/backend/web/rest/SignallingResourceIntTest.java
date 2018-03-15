package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Signalling;
import com.hgicreate.rno.xdr.backend.repository.SignallingRepository;
import com.hgicreate.rno.xdr.backend.service.SignallingService;
import com.hgicreate.rno.xdr.backend.repository.search.SignallingSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.SignallingDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.SignallingMapper;
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
 * Test class for the SignallingResource REST controller.
 *
 * @see SignallingResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class SignallingResourceIntTest {

    private static final LocalDate DEFAULT_PDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_START_TIME = 1L;
    private static final Long UPDATED_START_TIME = 2L;

    private static final Long DEFAULT_END_TIME = 1L;
    private static final Long UPDATED_END_TIME = 2L;

    private static final String DEFAULT_INTERFACE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INTERFACE_TYPE = "BBBBBBBBBB";

    private static final Long DEFAULT_CELL = 1L;
    private static final Long UPDATED_CELL = 2L;

    private static final Long DEFAULT_IMEI = 1L;
    private static final Long UPDATED_IMEI = 2L;

    private static final Long DEFAULT_IMSI = 1L;
    private static final Long UPDATED_IMSI = 2L;

    private static final Integer DEFAULT_APP_TYPE = 1;
    private static final Integer UPDATED_APP_TYPE = 2;

    private static final Integer DEFAULT_APP_STATUS = 1;
    private static final Integer UPDATED_APP_STATUS = 2;

    private static final Integer DEFAULT_PROTOCOL_TYPE = 1;
    private static final Integer UPDATED_PROTOCOL_TYPE = 2;

    private static final Integer DEFAULT_APP_SUB_TYPE = 1;
    private static final Integer UPDATED_APP_SUB_TYPE = 2;

    private static final Integer DEFAULT_UL_DATA = 1;
    private static final Integer UPDATED_UL_DATA = 2;

    private static final Integer DEFAULT_DL_DATA = 1;
    private static final Integer UPDATED_DL_DATA = 2;

    private static final Double DEFAULT_LAST_HTTP_RESPONSE_DELAY = 1D;
    private static final Double UPDATED_LAST_HTTP_RESPONSE_DELAY = 2D;

    private static final Integer DEFAULT_PROCEDURE_TYPE = 1;
    private static final Integer UPDATED_PROCEDURE_TYPE = 2;

    private static final Integer DEFAULT_PROCEDURE_STATUS = 1;
    private static final Integer UPDATED_PROCEDURE_STATUS = 2;

    private static final Integer DEFAULT_CAUSE = 1;
    private static final Integer UPDATED_CAUSE = 2;

    private static final Integer DEFAULT_KEYWORD = 1;
    private static final Integer UPDATED_KEYWORD = 2;

    private static final Long DEFAULT_TARGET_CELLID = 1L;
    private static final Long UPDATED_TARGET_CELLID = 2L;

    private static final Long DEFAULT_CSFB_INDICATION = 1L;
    private static final Long UPDATED_CSFB_INDICATION = 2L;

    private static final Integer DEFAULT_REQ_CAUSE_TYPE = 1;
    private static final Integer UPDATED_REQ_CAUSE_TYPE = 2;

    private static final Integer DEFAULT_REQ_CAUSE = 1;
    private static final Integer UPDATED_REQ_CAUSE = 2;

    private static final Integer DEFAULT_FAILURE_CAUSE_TYPE = 1;
    private static final Integer UPDATED_FAILURE_CAUSE_TYPE = 2;

    private static final Integer DEFAULT_FAILURE_CAUSE = 1;
    private static final Integer UPDATED_FAILURE_CAUSE = 2;

    private static final Integer DEFAULT_ERROR_CAUSE_TYPE = 1;
    private static final Integer UPDATED_ERROR_CAUSE_TYPE = 2;

    private static final Integer DEFAULT_ERROR_CAUSE = 1;
    private static final Integer UPDATED_ERROR_CAUSE = 2;

    private static final Integer DEFAULT_HO_CANCEL_CAUSE_TYPE = 1;
    private static final Integer UPDATED_HO_CANCEL_CAUSE_TYPE = 2;

    private static final Integer DEFAULT_HO_CANCEL_CAUSE = 1;
    private static final Integer UPDATED_HO_CANCEL_CAUSE = 2;

    private static final Integer DEFAULT_ROW_COUNT = 1;
    private static final Integer UPDATED_ROW_COUNT = 2;

    private static final Double DEFAULT_SERVING_RSRP = 1D;
    private static final Double UPDATED_SERVING_RSRP = 2D;

    private static final Double DEFAULT_SERVING_RSRP_AVG = 1D;
    private static final Double UPDATED_SERVING_RSRP_AVG = 2D;

    private static final Double DEFAULT_SERVING_RSRP_STD_DEV = 1D;
    private static final Double UPDATED_SERVING_RSRP_STD_DEV = 2D;

    private static final Double DEFAULT_SERVING_RSRQ = 1D;
    private static final Double UPDATED_SERVING_RSRQ = 2D;

    private static final Double DEFAULT_SERVING_RSRQ_AVG = 1D;
    private static final Double UPDATED_SERVING_RSRQ_AVG = 2D;

    private static final Double DEFAULT_SERVING_RSRQ_STD_DEV = 1D;
    private static final Double UPDATED_SERVING_RSRQ_STD_DEV = 2D;

    private static final Double DEFAULT_AOA = 1D;
    private static final Double UPDATED_AOA = 2D;

    private static final Double DEFAULT_AOA_AVG = 1D;
    private static final Double UPDATED_AOA_AVG = 2D;

    private static final Double DEFAULT_AOA_STD_DEV = 1D;
    private static final Double UPDATED_AOA_STD_DEV = 2D;

    private static final Double DEFAULT_TA = 1D;
    private static final Double UPDATED_TA = 2D;

    private static final Double DEFAULT_TA_AVG = 1D;
    private static final Double UPDATED_TA_AVG = 2D;

    private static final Double DEFAULT_TA_STD_DEV = 1D;
    private static final Double UPDATED_TA_STD_DEV = 2D;

    private static final Double DEFAULT_UL_SINR = 1D;
    private static final Double UPDATED_UL_SINR = 2D;

    private static final Double DEFAULT_UL_SINR_AVG = 1D;
    private static final Double UPDATED_UL_SINR_AVG = 2D;

    private static final Double DEFAULT_UL_SINR_STD_DEV = 1D;
    private static final Double UPDATED_UL_SINR_STD_DEV = 2D;

    private static final Double DEFAULT_ENB_RECEIVED_POWER = 1D;
    private static final Double UPDATED_ENB_RECEIVED_POWER = 2D;

    private static final Double DEFAULT_ENB_RECEIVED_POWER_AVG = 1D;
    private static final Double UPDATED_ENB_RECEIVED_POWER_AVG = 2D;

    private static final Double DEFAULT_ENB_RECEIVED_POWER_STD_DEV = 1D;
    private static final Double UPDATED_ENB_RECEIVED_POWER_STD_DEV = 2D;

    private static final Double DEFAULT_PHR = 1D;
    private static final Double UPDATED_PHR = 2D;

    private static final Double DEFAULT_PHR_AVG = 1D;
    private static final Double UPDATED_PHR_AVG = 2D;

    private static final Double DEFAULT_PHR_STD_DEV = 1D;
    private static final Double UPDATED_PHR_STD_DEV = 2D;

    @Autowired
    private SignallingRepository signallingRepository;

    @Autowired
    private SignallingMapper signallingMapper;

    @Autowired
    private SignallingService signallingService;

    @Autowired
    private SignallingSearchRepository signallingSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSignallingMockMvc;

    private Signalling signalling;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        SignallingResource signallingResource = new SignallingResource(signallingService);
        this.restSignallingMockMvc = MockMvcBuilders.standaloneSetup(signallingResource)
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
    public static Signalling createEntity(EntityManager em) {
        Signalling signalling = new Signalling()
            .pdate(DEFAULT_PDATE)
            .startTime(DEFAULT_START_TIME)
            .endTime(DEFAULT_END_TIME)
            .interfaceType(DEFAULT_INTERFACE_TYPE)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .appType(DEFAULT_APP_TYPE)
            .appStatus(DEFAULT_APP_STATUS)
            .protocolType(DEFAULT_PROTOCOL_TYPE)
            .appSubType(DEFAULT_APP_SUB_TYPE)
            .ulData(DEFAULT_UL_DATA)
            .dlData(DEFAULT_DL_DATA)
            .lastHttpResponseDelay(DEFAULT_LAST_HTTP_RESPONSE_DELAY)
            .procedureType(DEFAULT_PROCEDURE_TYPE)
            .procedureStatus(DEFAULT_PROCEDURE_STATUS)
            .cause(DEFAULT_CAUSE)
            .keyword(DEFAULT_KEYWORD)
            .targetCellid(DEFAULT_TARGET_CELLID)
            .csfbIndication(DEFAULT_CSFB_INDICATION)
            .reqCauseType(DEFAULT_REQ_CAUSE_TYPE)
            .reqCause(DEFAULT_REQ_CAUSE)
            .failureCauseType(DEFAULT_FAILURE_CAUSE_TYPE)
            .failureCause(DEFAULT_FAILURE_CAUSE)
            .errorCauseType(DEFAULT_ERROR_CAUSE_TYPE)
            .errorCause(DEFAULT_ERROR_CAUSE)
            .hoCancelCauseType(DEFAULT_HO_CANCEL_CAUSE_TYPE)
            .hoCancelCause(DEFAULT_HO_CANCEL_CAUSE)
            .rowCount(DEFAULT_ROW_COUNT)
            .servingRsrp(DEFAULT_SERVING_RSRP)
            .servingRsrpAvg(DEFAULT_SERVING_RSRP_AVG)
            .servingRsrpStdDev(DEFAULT_SERVING_RSRP_STD_DEV)
            .servingRsrq(DEFAULT_SERVING_RSRQ)
            .servingRsrqAvg(DEFAULT_SERVING_RSRQ_AVG)
            .servingRsrqStdDev(DEFAULT_SERVING_RSRQ_STD_DEV)
            .aoa(DEFAULT_AOA)
            .aoaAvg(DEFAULT_AOA_AVG)
            .aoaStdDev(DEFAULT_AOA_STD_DEV)
            .ta(DEFAULT_TA)
            .taAvg(DEFAULT_TA_AVG)
            .taStdDev(DEFAULT_TA_STD_DEV)
            .ulSinr(DEFAULT_UL_SINR)
            .ulSinrAvg(DEFAULT_UL_SINR_AVG)
            .ulSinrStdDev(DEFAULT_UL_SINR_STD_DEV)
            .enbReceivedPower(DEFAULT_ENB_RECEIVED_POWER)
            .enbReceivedPowerAvg(DEFAULT_ENB_RECEIVED_POWER_AVG)
            .enbReceivedPowerStdDev(DEFAULT_ENB_RECEIVED_POWER_STD_DEV)
            .phr(DEFAULT_PHR)
            .phrAvg(DEFAULT_PHR_AVG)
            .phrStdDev(DEFAULT_PHR_STD_DEV);
        return signalling;
    }

    @Before
    public void initTest() {
        signallingSearchRepository.deleteAll();
        signalling = createEntity(em);
    }

    @Test
    @Transactional
    public void createSignalling() throws Exception {
        int databaseSizeBeforeCreate = signallingRepository.findAll().size();

        // Create the Signalling
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);
        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isCreated());

        // Validate the Signalling in the database
        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeCreate + 1);
        Signalling testSignalling = signallingList.get(signallingList.size() - 1);
        assertThat(testSignalling.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testSignalling.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testSignalling.getEndTime()).isEqualTo(DEFAULT_END_TIME);
        assertThat(testSignalling.getInterfaceType()).isEqualTo(DEFAULT_INTERFACE_TYPE);
        assertThat(testSignalling.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testSignalling.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testSignalling.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testSignalling.getAppType()).isEqualTo(DEFAULT_APP_TYPE);
        assertThat(testSignalling.getAppStatus()).isEqualTo(DEFAULT_APP_STATUS);
        assertThat(testSignalling.getProtocolType()).isEqualTo(DEFAULT_PROTOCOL_TYPE);
        assertThat(testSignalling.getAppSubType()).isEqualTo(DEFAULT_APP_SUB_TYPE);
        assertThat(testSignalling.getUlData()).isEqualTo(DEFAULT_UL_DATA);
        assertThat(testSignalling.getDlData()).isEqualTo(DEFAULT_DL_DATA);
        assertThat(testSignalling.getLastHttpResponseDelay()).isEqualTo(DEFAULT_LAST_HTTP_RESPONSE_DELAY);
        assertThat(testSignalling.getProcedureType()).isEqualTo(DEFAULT_PROCEDURE_TYPE);
        assertThat(testSignalling.getProcedureStatus()).isEqualTo(DEFAULT_PROCEDURE_STATUS);
        assertThat(testSignalling.getCause()).isEqualTo(DEFAULT_CAUSE);
        assertThat(testSignalling.getKeyword()).isEqualTo(DEFAULT_KEYWORD);
        assertThat(testSignalling.getTargetCellid()).isEqualTo(DEFAULT_TARGET_CELLID);
        assertThat(testSignalling.getCsfbIndication()).isEqualTo(DEFAULT_CSFB_INDICATION);
        assertThat(testSignalling.getReqCauseType()).isEqualTo(DEFAULT_REQ_CAUSE_TYPE);
        assertThat(testSignalling.getReqCause()).isEqualTo(DEFAULT_REQ_CAUSE);
        assertThat(testSignalling.getFailureCauseType()).isEqualTo(DEFAULT_FAILURE_CAUSE_TYPE);
        assertThat(testSignalling.getFailureCause()).isEqualTo(DEFAULT_FAILURE_CAUSE);
        assertThat(testSignalling.getErrorCauseType()).isEqualTo(DEFAULT_ERROR_CAUSE_TYPE);
        assertThat(testSignalling.getErrorCause()).isEqualTo(DEFAULT_ERROR_CAUSE);
        assertThat(testSignalling.getHoCancelCauseType()).isEqualTo(DEFAULT_HO_CANCEL_CAUSE_TYPE);
        assertThat(testSignalling.getHoCancelCause()).isEqualTo(DEFAULT_HO_CANCEL_CAUSE);
        assertThat(testSignalling.getRowCount()).isEqualTo(DEFAULT_ROW_COUNT);
        assertThat(testSignalling.getServingRsrp()).isEqualTo(DEFAULT_SERVING_RSRP);
        assertThat(testSignalling.getServingRsrpAvg()).isEqualTo(DEFAULT_SERVING_RSRP_AVG);
        assertThat(testSignalling.getServingRsrpStdDev()).isEqualTo(DEFAULT_SERVING_RSRP_STD_DEV);
        assertThat(testSignalling.getServingRsrq()).isEqualTo(DEFAULT_SERVING_RSRQ);
        assertThat(testSignalling.getServingRsrqAvg()).isEqualTo(DEFAULT_SERVING_RSRQ_AVG);
        assertThat(testSignalling.getServingRsrqStdDev()).isEqualTo(DEFAULT_SERVING_RSRQ_STD_DEV);
        assertThat(testSignalling.getAoa()).isEqualTo(DEFAULT_AOA);
        assertThat(testSignalling.getAoaAvg()).isEqualTo(DEFAULT_AOA_AVG);
        assertThat(testSignalling.getAoaStdDev()).isEqualTo(DEFAULT_AOA_STD_DEV);
        assertThat(testSignalling.getTa()).isEqualTo(DEFAULT_TA);
        assertThat(testSignalling.getTaAvg()).isEqualTo(DEFAULT_TA_AVG);
        assertThat(testSignalling.getTaStdDev()).isEqualTo(DEFAULT_TA_STD_DEV);
        assertThat(testSignalling.getUlSinr()).isEqualTo(DEFAULT_UL_SINR);
        assertThat(testSignalling.getUlSinrAvg()).isEqualTo(DEFAULT_UL_SINR_AVG);
        assertThat(testSignalling.getUlSinrStdDev()).isEqualTo(DEFAULT_UL_SINR_STD_DEV);
        assertThat(testSignalling.getEnbReceivedPower()).isEqualTo(DEFAULT_ENB_RECEIVED_POWER);
        assertThat(testSignalling.getEnbReceivedPowerAvg()).isEqualTo(DEFAULT_ENB_RECEIVED_POWER_AVG);
        assertThat(testSignalling.getEnbReceivedPowerStdDev()).isEqualTo(DEFAULT_ENB_RECEIVED_POWER_STD_DEV);
        assertThat(testSignalling.getPhr()).isEqualTo(DEFAULT_PHR);
        assertThat(testSignalling.getPhrAvg()).isEqualTo(DEFAULT_PHR_AVG);
        assertThat(testSignalling.getPhrStdDev()).isEqualTo(DEFAULT_PHR_STD_DEV);

        // Validate the Signalling in Elasticsearch
        Signalling signallingEs = signallingSearchRepository.findOne(testSignalling.getId());
        assertThat(signallingEs).isEqualToComparingFieldByField(testSignalling);
    }

    @Test
    @Transactional
    public void createSignallingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = signallingRepository.findAll().size();

        // Create the Signalling with an existing ID
        signalling.setId(1L);
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = signallingRepository.findAll().size();
        // set the field null
        signalling.setPdate(null);

        // Create the Signalling, which fails.
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isBadRequest());

        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStartTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = signallingRepository.findAll().size();
        // set the field null
        signalling.setStartTime(null);

        // Create the Signalling, which fails.
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isBadRequest());

        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEndTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = signallingRepository.findAll().size();
        // set the field null
        signalling.setEndTime(null);

        // Create the Signalling, which fails.
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isBadRequest());

        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkInterfaceTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = signallingRepository.findAll().size();
        // set the field null
        signalling.setInterfaceType(null);

        // Create the Signalling, which fails.
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        restSignallingMockMvc.perform(post("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isBadRequest());

        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSignallings() throws Exception {
        // Initialize the database
        signallingRepository.saveAndFlush(signalling);

        // Get all the signallingList
        restSignallingMockMvc.perform(get("/api/signallings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(signalling.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.intValue())))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME.intValue())))
            .andExpect(jsonPath("$.[*].interfaceType").value(hasItem(DEFAULT_INTERFACE_TYPE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].appType").value(hasItem(DEFAULT_APP_TYPE)))
            .andExpect(jsonPath("$.[*].appStatus").value(hasItem(DEFAULT_APP_STATUS)))
            .andExpect(jsonPath("$.[*].protocolType").value(hasItem(DEFAULT_PROTOCOL_TYPE)))
            .andExpect(jsonPath("$.[*].appSubType").value(hasItem(DEFAULT_APP_SUB_TYPE)))
            .andExpect(jsonPath("$.[*].ulData").value(hasItem(DEFAULT_UL_DATA)))
            .andExpect(jsonPath("$.[*].dlData").value(hasItem(DEFAULT_DL_DATA)))
            .andExpect(jsonPath("$.[*].lastHttpResponseDelay").value(hasItem(DEFAULT_LAST_HTTP_RESPONSE_DELAY.doubleValue())))
            .andExpect(jsonPath("$.[*].procedureType").value(hasItem(DEFAULT_PROCEDURE_TYPE)))
            .andExpect(jsonPath("$.[*].procedureStatus").value(hasItem(DEFAULT_PROCEDURE_STATUS)))
            .andExpect(jsonPath("$.[*].cause").value(hasItem(DEFAULT_CAUSE)))
            .andExpect(jsonPath("$.[*].keyword").value(hasItem(DEFAULT_KEYWORD)))
            .andExpect(jsonPath("$.[*].targetCellid").value(hasItem(DEFAULT_TARGET_CELLID.intValue())))
            .andExpect(jsonPath("$.[*].csfbIndication").value(hasItem(DEFAULT_CSFB_INDICATION.intValue())))
            .andExpect(jsonPath("$.[*].reqCauseType").value(hasItem(DEFAULT_REQ_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].reqCause").value(hasItem(DEFAULT_REQ_CAUSE)))
            .andExpect(jsonPath("$.[*].failureCauseType").value(hasItem(DEFAULT_FAILURE_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].failureCause").value(hasItem(DEFAULT_FAILURE_CAUSE)))
            .andExpect(jsonPath("$.[*].errorCauseType").value(hasItem(DEFAULT_ERROR_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].errorCause").value(hasItem(DEFAULT_ERROR_CAUSE)))
            .andExpect(jsonPath("$.[*].hoCancelCauseType").value(hasItem(DEFAULT_HO_CANCEL_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].hoCancelCause").value(hasItem(DEFAULT_HO_CANCEL_CAUSE)))
            .andExpect(jsonPath("$.[*].rowCount").value(hasItem(DEFAULT_ROW_COUNT)))
            .andExpect(jsonPath("$.[*].servingRsrp").value(hasItem(DEFAULT_SERVING_RSRP.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrpAvg").value(hasItem(DEFAULT_SERVING_RSRP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrpStdDev").value(hasItem(DEFAULT_SERVING_RSRP_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrq").value(hasItem(DEFAULT_SERVING_RSRQ.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrqAvg").value(hasItem(DEFAULT_SERVING_RSRQ_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrqStdDev").value(hasItem(DEFAULT_SERVING_RSRQ_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].aoa").value(hasItem(DEFAULT_AOA.doubleValue())))
            .andExpect(jsonPath("$.[*].aoaAvg").value(hasItem(DEFAULT_AOA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].aoaStdDev").value(hasItem(DEFAULT_AOA_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].ta").value(hasItem(DEFAULT_TA.doubleValue())))
            .andExpect(jsonPath("$.[*].taAvg").value(hasItem(DEFAULT_TA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].taStdDev").value(hasItem(DEFAULT_TA_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinr").value(hasItem(DEFAULT_UL_SINR.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinrAvg").value(hasItem(DEFAULT_UL_SINR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinrStdDev").value(hasItem(DEFAULT_UL_SINR_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPower").value(hasItem(DEFAULT_ENB_RECEIVED_POWER.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPowerAvg").value(hasItem(DEFAULT_ENB_RECEIVED_POWER_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPowerStdDev").value(hasItem(DEFAULT_ENB_RECEIVED_POWER_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].phr").value(hasItem(DEFAULT_PHR.doubleValue())))
            .andExpect(jsonPath("$.[*].phrAvg").value(hasItem(DEFAULT_PHR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].phrStdDev").value(hasItem(DEFAULT_PHR_STD_DEV.doubleValue())));
    }

    @Test
    @Transactional
    public void getSignalling() throws Exception {
        // Initialize the database
        signallingRepository.saveAndFlush(signalling);

        // Get the signalling
        restSignallingMockMvc.perform(get("/api/signallings/{id}", signalling.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(signalling.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.startTime").value(DEFAULT_START_TIME.intValue()))
            .andExpect(jsonPath("$.endTime").value(DEFAULT_END_TIME.intValue()))
            .andExpect(jsonPath("$.interfaceType").value(DEFAULT_INTERFACE_TYPE.toString()))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.intValue()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.intValue()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.intValue()))
            .andExpect(jsonPath("$.appType").value(DEFAULT_APP_TYPE))
            .andExpect(jsonPath("$.appStatus").value(DEFAULT_APP_STATUS))
            .andExpect(jsonPath("$.protocolType").value(DEFAULT_PROTOCOL_TYPE))
            .andExpect(jsonPath("$.appSubType").value(DEFAULT_APP_SUB_TYPE))
            .andExpect(jsonPath("$.ulData").value(DEFAULT_UL_DATA))
            .andExpect(jsonPath("$.dlData").value(DEFAULT_DL_DATA))
            .andExpect(jsonPath("$.lastHttpResponseDelay").value(DEFAULT_LAST_HTTP_RESPONSE_DELAY.doubleValue()))
            .andExpect(jsonPath("$.procedureType").value(DEFAULT_PROCEDURE_TYPE))
            .andExpect(jsonPath("$.procedureStatus").value(DEFAULT_PROCEDURE_STATUS))
            .andExpect(jsonPath("$.cause").value(DEFAULT_CAUSE))
            .andExpect(jsonPath("$.keyword").value(DEFAULT_KEYWORD))
            .andExpect(jsonPath("$.targetCellid").value(DEFAULT_TARGET_CELLID.intValue()))
            .andExpect(jsonPath("$.csfbIndication").value(DEFAULT_CSFB_INDICATION.intValue()))
            .andExpect(jsonPath("$.reqCauseType").value(DEFAULT_REQ_CAUSE_TYPE))
            .andExpect(jsonPath("$.reqCause").value(DEFAULT_REQ_CAUSE))
            .andExpect(jsonPath("$.failureCauseType").value(DEFAULT_FAILURE_CAUSE_TYPE))
            .andExpect(jsonPath("$.failureCause").value(DEFAULT_FAILURE_CAUSE))
            .andExpect(jsonPath("$.errorCauseType").value(DEFAULT_ERROR_CAUSE_TYPE))
            .andExpect(jsonPath("$.errorCause").value(DEFAULT_ERROR_CAUSE))
            .andExpect(jsonPath("$.hoCancelCauseType").value(DEFAULT_HO_CANCEL_CAUSE_TYPE))
            .andExpect(jsonPath("$.hoCancelCause").value(DEFAULT_HO_CANCEL_CAUSE))
            .andExpect(jsonPath("$.rowCount").value(DEFAULT_ROW_COUNT))
            .andExpect(jsonPath("$.servingRsrp").value(DEFAULT_SERVING_RSRP.doubleValue()))
            .andExpect(jsonPath("$.servingRsrpAvg").value(DEFAULT_SERVING_RSRP_AVG.doubleValue()))
            .andExpect(jsonPath("$.servingRsrpStdDev").value(DEFAULT_SERVING_RSRP_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.servingRsrq").value(DEFAULT_SERVING_RSRQ.doubleValue()))
            .andExpect(jsonPath("$.servingRsrqAvg").value(DEFAULT_SERVING_RSRQ_AVG.doubleValue()))
            .andExpect(jsonPath("$.servingRsrqStdDev").value(DEFAULT_SERVING_RSRQ_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.aoa").value(DEFAULT_AOA.doubleValue()))
            .andExpect(jsonPath("$.aoaAvg").value(DEFAULT_AOA_AVG.doubleValue()))
            .andExpect(jsonPath("$.aoaStdDev").value(DEFAULT_AOA_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.ta").value(DEFAULT_TA.doubleValue()))
            .andExpect(jsonPath("$.taAvg").value(DEFAULT_TA_AVG.doubleValue()))
            .andExpect(jsonPath("$.taStdDev").value(DEFAULT_TA_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.ulSinr").value(DEFAULT_UL_SINR.doubleValue()))
            .andExpect(jsonPath("$.ulSinrAvg").value(DEFAULT_UL_SINR_AVG.doubleValue()))
            .andExpect(jsonPath("$.ulSinrStdDev").value(DEFAULT_UL_SINR_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.enbReceivedPower").value(DEFAULT_ENB_RECEIVED_POWER.doubleValue()))
            .andExpect(jsonPath("$.enbReceivedPowerAvg").value(DEFAULT_ENB_RECEIVED_POWER_AVG.doubleValue()))
            .andExpect(jsonPath("$.enbReceivedPowerStdDev").value(DEFAULT_ENB_RECEIVED_POWER_STD_DEV.doubleValue()))
            .andExpect(jsonPath("$.phr").value(DEFAULT_PHR.doubleValue()))
            .andExpect(jsonPath("$.phrAvg").value(DEFAULT_PHR_AVG.doubleValue()))
            .andExpect(jsonPath("$.phrStdDev").value(DEFAULT_PHR_STD_DEV.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSignalling() throws Exception {
        // Get the signalling
        restSignallingMockMvc.perform(get("/api/signallings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSignalling() throws Exception {
        // Initialize the database
        signallingRepository.saveAndFlush(signalling);
        signallingSearchRepository.save(signalling);
        int databaseSizeBeforeUpdate = signallingRepository.findAll().size();

        // Update the signalling
        Signalling updatedSignalling = signallingRepository.findOne(signalling.getId());
        updatedSignalling
            .pdate(UPDATED_PDATE)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .interfaceType(UPDATED_INTERFACE_TYPE)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .appType(UPDATED_APP_TYPE)
            .appStatus(UPDATED_APP_STATUS)
            .protocolType(UPDATED_PROTOCOL_TYPE)
            .appSubType(UPDATED_APP_SUB_TYPE)
            .ulData(UPDATED_UL_DATA)
            .dlData(UPDATED_DL_DATA)
            .lastHttpResponseDelay(UPDATED_LAST_HTTP_RESPONSE_DELAY)
            .procedureType(UPDATED_PROCEDURE_TYPE)
            .procedureStatus(UPDATED_PROCEDURE_STATUS)
            .cause(UPDATED_CAUSE)
            .keyword(UPDATED_KEYWORD)
            .targetCellid(UPDATED_TARGET_CELLID)
            .csfbIndication(UPDATED_CSFB_INDICATION)
            .reqCauseType(UPDATED_REQ_CAUSE_TYPE)
            .reqCause(UPDATED_REQ_CAUSE)
            .failureCauseType(UPDATED_FAILURE_CAUSE_TYPE)
            .failureCause(UPDATED_FAILURE_CAUSE)
            .errorCauseType(UPDATED_ERROR_CAUSE_TYPE)
            .errorCause(UPDATED_ERROR_CAUSE)
            .hoCancelCauseType(UPDATED_HO_CANCEL_CAUSE_TYPE)
            .hoCancelCause(UPDATED_HO_CANCEL_CAUSE)
            .rowCount(UPDATED_ROW_COUNT)
            .servingRsrp(UPDATED_SERVING_RSRP)
            .servingRsrpAvg(UPDATED_SERVING_RSRP_AVG)
            .servingRsrpStdDev(UPDATED_SERVING_RSRP_STD_DEV)
            .servingRsrq(UPDATED_SERVING_RSRQ)
            .servingRsrqAvg(UPDATED_SERVING_RSRQ_AVG)
            .servingRsrqStdDev(UPDATED_SERVING_RSRQ_STD_DEV)
            .aoa(UPDATED_AOA)
            .aoaAvg(UPDATED_AOA_AVG)
            .aoaStdDev(UPDATED_AOA_STD_DEV)
            .ta(UPDATED_TA)
            .taAvg(UPDATED_TA_AVG)
            .taStdDev(UPDATED_TA_STD_DEV)
            .ulSinr(UPDATED_UL_SINR)
            .ulSinrAvg(UPDATED_UL_SINR_AVG)
            .ulSinrStdDev(UPDATED_UL_SINR_STD_DEV)
            .enbReceivedPower(UPDATED_ENB_RECEIVED_POWER)
            .enbReceivedPowerAvg(UPDATED_ENB_RECEIVED_POWER_AVG)
            .enbReceivedPowerStdDev(UPDATED_ENB_RECEIVED_POWER_STD_DEV)
            .phr(UPDATED_PHR)
            .phrAvg(UPDATED_PHR_AVG)
            .phrStdDev(UPDATED_PHR_STD_DEV);
        SignallingDTO signallingDTO = signallingMapper.toDto(updatedSignalling);

        restSignallingMockMvc.perform(put("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isOk());

        // Validate the Signalling in the database
        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeUpdate);
        Signalling testSignalling = signallingList.get(signallingList.size() - 1);
        assertThat(testSignalling.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testSignalling.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testSignalling.getEndTime()).isEqualTo(UPDATED_END_TIME);
        assertThat(testSignalling.getInterfaceType()).isEqualTo(UPDATED_INTERFACE_TYPE);
        assertThat(testSignalling.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testSignalling.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testSignalling.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testSignalling.getAppType()).isEqualTo(UPDATED_APP_TYPE);
        assertThat(testSignalling.getAppStatus()).isEqualTo(UPDATED_APP_STATUS);
        assertThat(testSignalling.getProtocolType()).isEqualTo(UPDATED_PROTOCOL_TYPE);
        assertThat(testSignalling.getAppSubType()).isEqualTo(UPDATED_APP_SUB_TYPE);
        assertThat(testSignalling.getUlData()).isEqualTo(UPDATED_UL_DATA);
        assertThat(testSignalling.getDlData()).isEqualTo(UPDATED_DL_DATA);
        assertThat(testSignalling.getLastHttpResponseDelay()).isEqualTo(UPDATED_LAST_HTTP_RESPONSE_DELAY);
        assertThat(testSignalling.getProcedureType()).isEqualTo(UPDATED_PROCEDURE_TYPE);
        assertThat(testSignalling.getProcedureStatus()).isEqualTo(UPDATED_PROCEDURE_STATUS);
        assertThat(testSignalling.getCause()).isEqualTo(UPDATED_CAUSE);
        assertThat(testSignalling.getKeyword()).isEqualTo(UPDATED_KEYWORD);
        assertThat(testSignalling.getTargetCellid()).isEqualTo(UPDATED_TARGET_CELLID);
        assertThat(testSignalling.getCsfbIndication()).isEqualTo(UPDATED_CSFB_INDICATION);
        assertThat(testSignalling.getReqCauseType()).isEqualTo(UPDATED_REQ_CAUSE_TYPE);
        assertThat(testSignalling.getReqCause()).isEqualTo(UPDATED_REQ_CAUSE);
        assertThat(testSignalling.getFailureCauseType()).isEqualTo(UPDATED_FAILURE_CAUSE_TYPE);
        assertThat(testSignalling.getFailureCause()).isEqualTo(UPDATED_FAILURE_CAUSE);
        assertThat(testSignalling.getErrorCauseType()).isEqualTo(UPDATED_ERROR_CAUSE_TYPE);
        assertThat(testSignalling.getErrorCause()).isEqualTo(UPDATED_ERROR_CAUSE);
        assertThat(testSignalling.getHoCancelCauseType()).isEqualTo(UPDATED_HO_CANCEL_CAUSE_TYPE);
        assertThat(testSignalling.getHoCancelCause()).isEqualTo(UPDATED_HO_CANCEL_CAUSE);
        assertThat(testSignalling.getRowCount()).isEqualTo(UPDATED_ROW_COUNT);
        assertThat(testSignalling.getServingRsrp()).isEqualTo(UPDATED_SERVING_RSRP);
        assertThat(testSignalling.getServingRsrpAvg()).isEqualTo(UPDATED_SERVING_RSRP_AVG);
        assertThat(testSignalling.getServingRsrpStdDev()).isEqualTo(UPDATED_SERVING_RSRP_STD_DEV);
        assertThat(testSignalling.getServingRsrq()).isEqualTo(UPDATED_SERVING_RSRQ);
        assertThat(testSignalling.getServingRsrqAvg()).isEqualTo(UPDATED_SERVING_RSRQ_AVG);
        assertThat(testSignalling.getServingRsrqStdDev()).isEqualTo(UPDATED_SERVING_RSRQ_STD_DEV);
        assertThat(testSignalling.getAoa()).isEqualTo(UPDATED_AOA);
        assertThat(testSignalling.getAoaAvg()).isEqualTo(UPDATED_AOA_AVG);
        assertThat(testSignalling.getAoaStdDev()).isEqualTo(UPDATED_AOA_STD_DEV);
        assertThat(testSignalling.getTa()).isEqualTo(UPDATED_TA);
        assertThat(testSignalling.getTaAvg()).isEqualTo(UPDATED_TA_AVG);
        assertThat(testSignalling.getTaStdDev()).isEqualTo(UPDATED_TA_STD_DEV);
        assertThat(testSignalling.getUlSinr()).isEqualTo(UPDATED_UL_SINR);
        assertThat(testSignalling.getUlSinrAvg()).isEqualTo(UPDATED_UL_SINR_AVG);
        assertThat(testSignalling.getUlSinrStdDev()).isEqualTo(UPDATED_UL_SINR_STD_DEV);
        assertThat(testSignalling.getEnbReceivedPower()).isEqualTo(UPDATED_ENB_RECEIVED_POWER);
        assertThat(testSignalling.getEnbReceivedPowerAvg()).isEqualTo(UPDATED_ENB_RECEIVED_POWER_AVG);
        assertThat(testSignalling.getEnbReceivedPowerStdDev()).isEqualTo(UPDATED_ENB_RECEIVED_POWER_STD_DEV);
        assertThat(testSignalling.getPhr()).isEqualTo(UPDATED_PHR);
        assertThat(testSignalling.getPhrAvg()).isEqualTo(UPDATED_PHR_AVG);
        assertThat(testSignalling.getPhrStdDev()).isEqualTo(UPDATED_PHR_STD_DEV);

        // Validate the Signalling in Elasticsearch
        Signalling signallingEs = signallingSearchRepository.findOne(testSignalling.getId());
        assertThat(signallingEs).isEqualToComparingFieldByField(testSignalling);
    }

    @Test
    @Transactional
    public void updateNonExistingSignalling() throws Exception {
        int databaseSizeBeforeUpdate = signallingRepository.findAll().size();

        // Create the Signalling
        SignallingDTO signallingDTO = signallingMapper.toDto(signalling);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSignallingMockMvc.perform(put("/api/signallings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(signallingDTO)))
            .andExpect(status().isCreated());

        // Validate the Signalling in the database
        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteSignalling() throws Exception {
        // Initialize the database
        signallingRepository.saveAndFlush(signalling);
        signallingSearchRepository.save(signalling);
        int databaseSizeBeforeDelete = signallingRepository.findAll().size();

        // Get the signalling
        restSignallingMockMvc.perform(delete("/api/signallings/{id}", signalling.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean signallingExistsInEs = signallingSearchRepository.exists(signalling.getId());
        assertThat(signallingExistsInEs).isFalse();

        // Validate the database is empty
        List<Signalling> signallingList = signallingRepository.findAll();
        assertThat(signallingList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchSignalling() throws Exception {
        // Initialize the database
        signallingRepository.saveAndFlush(signalling);
        signallingSearchRepository.save(signalling);

        // Search the signalling
        restSignallingMockMvc.perform(get("/api/_search/signallings?query=id:" + signalling.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(signalling.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.intValue())))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME.intValue())))
            .andExpect(jsonPath("$.[*].interfaceType").value(hasItem(DEFAULT_INTERFACE_TYPE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].appType").value(hasItem(DEFAULT_APP_TYPE)))
            .andExpect(jsonPath("$.[*].appStatus").value(hasItem(DEFAULT_APP_STATUS)))
            .andExpect(jsonPath("$.[*].protocolType").value(hasItem(DEFAULT_PROTOCOL_TYPE)))
            .andExpect(jsonPath("$.[*].appSubType").value(hasItem(DEFAULT_APP_SUB_TYPE)))
            .andExpect(jsonPath("$.[*].ulData").value(hasItem(DEFAULT_UL_DATA)))
            .andExpect(jsonPath("$.[*].dlData").value(hasItem(DEFAULT_DL_DATA)))
            .andExpect(jsonPath("$.[*].lastHttpResponseDelay").value(hasItem(DEFAULT_LAST_HTTP_RESPONSE_DELAY.doubleValue())))
            .andExpect(jsonPath("$.[*].procedureType").value(hasItem(DEFAULT_PROCEDURE_TYPE)))
            .andExpect(jsonPath("$.[*].procedureStatus").value(hasItem(DEFAULT_PROCEDURE_STATUS)))
            .andExpect(jsonPath("$.[*].cause").value(hasItem(DEFAULT_CAUSE)))
            .andExpect(jsonPath("$.[*].keyword").value(hasItem(DEFAULT_KEYWORD)))
            .andExpect(jsonPath("$.[*].targetCellid").value(hasItem(DEFAULT_TARGET_CELLID.intValue())))
            .andExpect(jsonPath("$.[*].csfbIndication").value(hasItem(DEFAULT_CSFB_INDICATION.intValue())))
            .andExpect(jsonPath("$.[*].reqCauseType").value(hasItem(DEFAULT_REQ_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].reqCause").value(hasItem(DEFAULT_REQ_CAUSE)))
            .andExpect(jsonPath("$.[*].failureCauseType").value(hasItem(DEFAULT_FAILURE_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].failureCause").value(hasItem(DEFAULT_FAILURE_CAUSE)))
            .andExpect(jsonPath("$.[*].errorCauseType").value(hasItem(DEFAULT_ERROR_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].errorCause").value(hasItem(DEFAULT_ERROR_CAUSE)))
            .andExpect(jsonPath("$.[*].hoCancelCauseType").value(hasItem(DEFAULT_HO_CANCEL_CAUSE_TYPE)))
            .andExpect(jsonPath("$.[*].hoCancelCause").value(hasItem(DEFAULT_HO_CANCEL_CAUSE)))
            .andExpect(jsonPath("$.[*].rowCount").value(hasItem(DEFAULT_ROW_COUNT)))
            .andExpect(jsonPath("$.[*].servingRsrp").value(hasItem(DEFAULT_SERVING_RSRP.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrpAvg").value(hasItem(DEFAULT_SERVING_RSRP_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrpStdDev").value(hasItem(DEFAULT_SERVING_RSRP_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrq").value(hasItem(DEFAULT_SERVING_RSRQ.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrqAvg").value(hasItem(DEFAULT_SERVING_RSRQ_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].servingRsrqStdDev").value(hasItem(DEFAULT_SERVING_RSRQ_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].aoa").value(hasItem(DEFAULT_AOA.doubleValue())))
            .andExpect(jsonPath("$.[*].aoaAvg").value(hasItem(DEFAULT_AOA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].aoaStdDev").value(hasItem(DEFAULT_AOA_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].ta").value(hasItem(DEFAULT_TA.doubleValue())))
            .andExpect(jsonPath("$.[*].taAvg").value(hasItem(DEFAULT_TA_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].taStdDev").value(hasItem(DEFAULT_TA_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinr").value(hasItem(DEFAULT_UL_SINR.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinrAvg").value(hasItem(DEFAULT_UL_SINR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].ulSinrStdDev").value(hasItem(DEFAULT_UL_SINR_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPower").value(hasItem(DEFAULT_ENB_RECEIVED_POWER.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPowerAvg").value(hasItem(DEFAULT_ENB_RECEIVED_POWER_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].enbReceivedPowerStdDev").value(hasItem(DEFAULT_ENB_RECEIVED_POWER_STD_DEV.doubleValue())))
            .andExpect(jsonPath("$.[*].phr").value(hasItem(DEFAULT_PHR.doubleValue())))
            .andExpect(jsonPath("$.[*].phrAvg").value(hasItem(DEFAULT_PHR_AVG.doubleValue())))
            .andExpect(jsonPath("$.[*].phrStdDev").value(hasItem(DEFAULT_PHR_STD_DEV.doubleValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Signalling.class);
        Signalling signalling1 = new Signalling();
        signalling1.setId(1L);
        Signalling signalling2 = new Signalling();
        signalling2.setId(signalling1.getId());
        assertThat(signalling1).isEqualTo(signalling2);
        signalling2.setId(2L);
        assertThat(signalling1).isNotEqualTo(signalling2);
        signalling1.setId(null);
        assertThat(signalling1).isNotEqualTo(signalling2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SignallingDTO.class);
        SignallingDTO signallingDTO1 = new SignallingDTO();
        signallingDTO1.setId(1L);
        SignallingDTO signallingDTO2 = new SignallingDTO();
        assertThat(signallingDTO1).isNotEqualTo(signallingDTO2);
        signallingDTO2.setId(signallingDTO1.getId());
        assertThat(signallingDTO1).isEqualTo(signallingDTO2);
        signallingDTO2.setId(2L);
        assertThat(signallingDTO1).isNotEqualTo(signallingDTO2);
        signallingDTO1.setId(null);
        assertThat(signallingDTO1).isNotEqualTo(signallingDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(signallingMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(signallingMapper.fromId(null)).isNull();
    }
}
