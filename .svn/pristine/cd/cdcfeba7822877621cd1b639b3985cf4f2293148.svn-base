package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Uhttp;
import com.hgicreate.rno.xdr.backend.repository.UhttpRepository;
import com.hgicreate.rno.xdr.backend.service.UhttpService;
import com.hgicreate.rno.xdr.backend.repository.search.UhttpSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.UhttpDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.UhttpMapper;
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
 * Test class for the UhttpResource REST controller.
 *
 * @see UhttpResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class UhttpResourceIntTest {

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

    private static final Long DEFAULT_FLOW_SUM = 1L;
    private static final Long UPDATED_FLOW_SUM = 2L;

    private static final Double DEFAULT_RATE_FLOW_RATE = 1D;
    private static final Double UPDATED_RATE_FLOW_RATE = 2D;

    private static final Double DEFAULT_RATE_FLOW_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RATE_FLOW_SUCCESS_RATE = 2D;

    private static final Double DEFAULT_RATE_FLOW_SUCCESS_D_RATE = 1D;
    private static final Double UPDATED_RATE_FLOW_SUCCESS_D_RATE = 2D;

    private static final Long DEFAULT_RATE_FLOW = 1L;
    private static final Long UPDATED_RATE_FLOW = 2L;

    private static final Long DEFAULT_RATE_FLOW_REQUEST = 1L;
    private static final Long UPDATED_RATE_FLOW_REQUEST = 2L;

    private static final Long DEFAULT_RATE_FLOW_BP_SPEED = 1L;
    private static final Long UPDATED_RATE_FLOW_BP_SPEED = 2L;

    private static final Double DEFAULT_RATE_FLOW_BP_SPEED_D_RATE = 1D;
    private static final Double UPDATED_RATE_FLOW_BP_SPEED_D_RATE = 2D;

    private static final Long DEFAULT_RATE_FLOW_SP_DELAY = 1L;
    private static final Long UPDATED_RATE_FLOW_SP_DELAY = 2L;

    private static final Double DEFAULT_RATE_FLOW_SP_DELAY_D_RATE = 1D;
    private static final Double UPDATED_RATE_FLOW_SP_DELAY_D_RATE = 2D;

    private static final Double DEFAULT_DELAY_FLOW_RATE = 1D;
    private static final Double UPDATED_DELAY_FLOW_RATE = 2D;

    private static final Double DEFAULT_DELAY_FLOW_SUCCESS_RATE = 1D;
    private static final Double UPDATED_DELAY_FLOW_SUCCESS_RATE = 2D;

    private static final Double DEFAULT_DELAY_FLOW_SUCCESS_D_RATE = 1D;
    private static final Double UPDATED_DELAY_FLOW_SUCCESS_D_RATE = 2D;

    private static final Long DEFAULT_DELAY_FLOW = 1L;
    private static final Long UPDATED_DELAY_FLOW = 2L;

    private static final Long DEFAULT_DELAY_FLOW_REQUEST = 1L;
    private static final Long UPDATED_DELAY_FLOW_REQUEST = 2L;

    private static final Long DEFAULT_DELAY_FLOW_BP_SPEED = 1L;
    private static final Long UPDATED_DELAY_FLOW_BP_SPEED = 2L;

    private static final Double DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE = 1D;
    private static final Double UPDATED_DELAY_FLOW_BP_SPEED_D_RATE = 2D;

    private static final Long DEFAULT_DELAY_FLOW_SP_DELAY = 1L;
    private static final Long UPDATED_DELAY_FLOW_SP_DELAY = 2L;

    private static final Double DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE = 1D;
    private static final Double UPDATED_DELAY_FLOW_SP_DELAY_D_RATE = 2D;

    private static final Double DEFAULT_REFRESH_FLOW_RATE = 1D;
    private static final Double UPDATED_REFRESH_FLOW_RATE = 2D;

    private static final Double DEFAULT_REFRESH_FLOW_SUCCESS_RATE = 1D;
    private static final Double UPDATED_REFRESH_FLOW_SUCCESS_RATE = 2D;

    private static final Double DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE = 1D;
    private static final Double UPDATED_REFRESH_FLOW_SUCCESS_D_RATE = 2D;

    private static final Long DEFAULT_REFRESH_FLOW = 1L;
    private static final Long UPDATED_REFRESH_FLOW = 2L;

    private static final Long DEFAULT_REFRESH_FLOW_REQUEST = 1L;
    private static final Long UPDATED_REFRESH_FLOW_REQUEST = 2L;

    private static final Long DEFAULT_REFRESH_FLOW_BP_SPEED = 1L;
    private static final Long UPDATED_REFRESH_FLOW_BP_SPEED = 2L;

    private static final Double DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE = 1D;
    private static final Double UPDATED_REFRESH_FLOW_BP_SPEED_D_RATE = 2D;

    private static final Long DEFAULT_REFRESH_FLOW_SP_DELAY = 1L;
    private static final Long UPDATED_REFRESH_FLOW_SP_DELAY = 2L;

    private static final Double DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE = 1D;
    private static final Double UPDATED_REFRESH_FLOW_SP_DELAY_D_RATE = 2D;

    private static final Double DEFAULT_INSTANT_FLOW_RATE = 1D;
    private static final Double UPDATED_INSTANT_FLOW_RATE = 2D;

    private static final Double DEFAULT_INSTANT_FLOW_SUCCESS_RATE = 1D;
    private static final Double UPDATED_INSTANT_FLOW_SUCCESS_RATE = 2D;

    private static final Double DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE = 1D;
    private static final Double UPDATED_INSTANT_FLOW_SUCCESS_D_RATE = 2D;

    private static final Long DEFAULT_INSTANT_FLOW = 1L;
    private static final Long UPDATED_INSTANT_FLOW = 2L;

    private static final Long DEFAULT_INSTANT_FLOW_REQUEST = 1L;
    private static final Long UPDATED_INSTANT_FLOW_REQUEST = 2L;

    private static final Long DEFAULT_INSTANT_FLOW_BP_SPEED = 1L;
    private static final Long UPDATED_INSTANT_FLOW_BP_SPEED = 2L;

    private static final Double DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE = 1D;
    private static final Double UPDATED_INSTANT_FLOW_BP_SPEED_D_RATE = 2D;

    private static final Long DEFAULT_INSTANT_FLOW_SP_DELAY = 1L;
    private static final Long UPDATED_INSTANT_FLOW_SP_DELAY = 2L;

    private static final Double DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE = 1D;
    private static final Double UPDATED_INSTANT_FLOW_SP_DELAY_D_RATE = 2D;

    private static final Long DEFAULT_TCP_CREACTLINK_DELAY = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_DELAY = 2L;

    private static final Long DEFAULT_TCP_CREACTLINK_COUNT = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_COUNT = 2L;

    private static final Long DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_RESPONSE_DELAY = 2L;

    private static final Long DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_RESPONSE_COUNT = 2L;

    private static final Long DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_CONFIRM_DELAY = 2L;

    private static final Long DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT = 1L;
    private static final Long UPDATED_TCP_CREACTLINK_CONFIRM_COUNT = 2L;

    private static final Long DEFAULT_BP_FLOW = 1L;
    private static final Long UPDATED_BP_FLOW = 2L;

    private static final Long DEFAULT_BP_DELAY = 1L;
    private static final Long UPDATED_BP_DELAY = 2L;

    private static final Long DEFAULT_SERVICE_REQUEST = 1L;
    private static final Long UPDATED_SERVICE_REQUEST = 2L;

    private static final Long DEFAULT_SERVICE_SUCCESS = 1L;
    private static final Long UPDATED_SERVICE_SUCCESS = 2L;

    private static final Long DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST = 1L;
    private static final Long UPDATED_TENCENT_VIDEO_SERVICE_REQUEST = 2L;

    @Autowired
    private UhttpRepository uhttpRepository;

    @Autowired
    private UhttpMapper uhttpMapper;

    @Autowired
    private UhttpService uhttpService;

    @Autowired
    private UhttpSearchRepository uhttpSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restUhttpMockMvc;

    private Uhttp uhttp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UhttpResource uhttpResource = new UhttpResource(uhttpService);
        this.restUhttpMockMvc = MockMvcBuilders.standaloneSetup(uhttpResource)
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
    public static Uhttp createEntity(EntityManager em) {
        Uhttp uhttp = new Uhttp()
            .pdate(DEFAULT_PDATE)
            .phour(DEFAULT_PHOUR)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .flowSum(DEFAULT_FLOW_SUM)
            .rateFlowRate(DEFAULT_RATE_FLOW_RATE)
            .rateFlowSuccessRate(DEFAULT_RATE_FLOW_SUCCESS_RATE)
            .rateFlowSuccessDRate(DEFAULT_RATE_FLOW_SUCCESS_D_RATE)
            .rateFlow(DEFAULT_RATE_FLOW)
            .rateFlowRequest(DEFAULT_RATE_FLOW_REQUEST)
            .rateFlowBpSpeed(DEFAULT_RATE_FLOW_BP_SPEED)
            .rateFlowBpSpeedDRate(DEFAULT_RATE_FLOW_BP_SPEED_D_RATE)
            .rateFlowSpDelay(DEFAULT_RATE_FLOW_SP_DELAY)
            .rateFlowSpDelayDRate(DEFAULT_RATE_FLOW_SP_DELAY_D_RATE)
            .delayFlowRate(DEFAULT_DELAY_FLOW_RATE)
            .delayFlowSuccessRate(DEFAULT_DELAY_FLOW_SUCCESS_RATE)
            .delayFlowSuccessDRate(DEFAULT_DELAY_FLOW_SUCCESS_D_RATE)
            .delayFlow(DEFAULT_DELAY_FLOW)
            .delayFlowRequest(DEFAULT_DELAY_FLOW_REQUEST)
            .delayFlowBpSpeed(DEFAULT_DELAY_FLOW_BP_SPEED)
            .delayFlowBpSpeedDRate(DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE)
            .delayFlowSpDelay(DEFAULT_DELAY_FLOW_SP_DELAY)
            .delayFlowSpDelayDRate(DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE)
            .refreshFlowRate(DEFAULT_REFRESH_FLOW_RATE)
            .refreshFlowSuccessRate(DEFAULT_REFRESH_FLOW_SUCCESS_RATE)
            .refreshFlowSuccessDRate(DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE)
            .refreshFlow(DEFAULT_REFRESH_FLOW)
            .refreshFlowRequest(DEFAULT_REFRESH_FLOW_REQUEST)
            .refreshFlowBpSpeed(DEFAULT_REFRESH_FLOW_BP_SPEED)
            .refreshFlowBpSpeedDRate(DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE)
            .refreshFlowSpDelay(DEFAULT_REFRESH_FLOW_SP_DELAY)
            .refreshFlowSpDelayDRate(DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE)
            .instantFlowRate(DEFAULT_INSTANT_FLOW_RATE)
            .instantFlowSuccessRate(DEFAULT_INSTANT_FLOW_SUCCESS_RATE)
            .instantFlowSuccessDRate(DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE)
            .instantFlow(DEFAULT_INSTANT_FLOW)
            .instantFlowRequest(DEFAULT_INSTANT_FLOW_REQUEST)
            .instantFlowBpSpeed(DEFAULT_INSTANT_FLOW_BP_SPEED)
            .instantFlowBpSpeedDRate(DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE)
            .instantFlowSpDelay(DEFAULT_INSTANT_FLOW_SP_DELAY)
            .instantFlowSpDelayDRate(DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE)
            .tcpCreactlinkDelay(DEFAULT_TCP_CREACTLINK_DELAY)
            .tcpCreactlinkCount(DEFAULT_TCP_CREACTLINK_COUNT)
            .tcpCreactlinkResponseDelay(DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY)
            .tcpCreactlinkResponseCount(DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT)
            .tcpCreactlinkConfirmDelay(DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY)
            .tcpCreactlinkConfirmCount(DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT)
            .bpFlow(DEFAULT_BP_FLOW)
            .bpDelay(DEFAULT_BP_DELAY)
            .serviceRequest(DEFAULT_SERVICE_REQUEST)
            .serviceSuccess(DEFAULT_SERVICE_SUCCESS)
            .tencentVideoServiceRequest(DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST);
        return uhttp;
    }

    @Before
    public void initTest() {
        uhttpSearchRepository.deleteAll();
        uhttp = createEntity(em);
    }

    @Test
    @Transactional
    public void createUhttp() throws Exception {
        int databaseSizeBeforeCreate = uhttpRepository.findAll().size();

        // Create the Uhttp
        UhttpDTO uhttpDTO = uhttpMapper.toDto(uhttp);
        restUhttpMockMvc.perform(post("/api/uhttps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uhttpDTO)))
            .andExpect(status().isCreated());

        // Validate the Uhttp in the database
        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeCreate + 1);
        Uhttp testUhttp = uhttpList.get(uhttpList.size() - 1);
        assertThat(testUhttp.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testUhttp.getPhour()).isEqualTo(DEFAULT_PHOUR);
        assertThat(testUhttp.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testUhttp.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testUhttp.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testUhttp.getFlowSum()).isEqualTo(DEFAULT_FLOW_SUM);
        assertThat(testUhttp.getRateFlowRate()).isEqualTo(DEFAULT_RATE_FLOW_RATE);
        assertThat(testUhttp.getRateFlowSuccessRate()).isEqualTo(DEFAULT_RATE_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getRateFlowSuccessDRate()).isEqualTo(DEFAULT_RATE_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getRateFlow()).isEqualTo(DEFAULT_RATE_FLOW);
        assertThat(testUhttp.getRateFlowRequest()).isEqualTo(DEFAULT_RATE_FLOW_REQUEST);
        assertThat(testUhttp.getRateFlowBpSpeed()).isEqualTo(DEFAULT_RATE_FLOW_BP_SPEED);
        assertThat(testUhttp.getRateFlowBpSpeedDRate()).isEqualTo(DEFAULT_RATE_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getRateFlowSpDelay()).isEqualTo(DEFAULT_RATE_FLOW_SP_DELAY);
        assertThat(testUhttp.getRateFlowSpDelayDRate()).isEqualTo(DEFAULT_RATE_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getDelayFlowRate()).isEqualTo(DEFAULT_DELAY_FLOW_RATE);
        assertThat(testUhttp.getDelayFlowSuccessRate()).isEqualTo(DEFAULT_DELAY_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getDelayFlowSuccessDRate()).isEqualTo(DEFAULT_DELAY_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getDelayFlow()).isEqualTo(DEFAULT_DELAY_FLOW);
        assertThat(testUhttp.getDelayFlowRequest()).isEqualTo(DEFAULT_DELAY_FLOW_REQUEST);
        assertThat(testUhttp.getDelayFlowBpSpeed()).isEqualTo(DEFAULT_DELAY_FLOW_BP_SPEED);
        assertThat(testUhttp.getDelayFlowBpSpeedDRate()).isEqualTo(DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getDelayFlowSpDelay()).isEqualTo(DEFAULT_DELAY_FLOW_SP_DELAY);
        assertThat(testUhttp.getDelayFlowSpDelayDRate()).isEqualTo(DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getRefreshFlowRate()).isEqualTo(DEFAULT_REFRESH_FLOW_RATE);
        assertThat(testUhttp.getRefreshFlowSuccessRate()).isEqualTo(DEFAULT_REFRESH_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getRefreshFlowSuccessDRate()).isEqualTo(DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getRefreshFlow()).isEqualTo(DEFAULT_REFRESH_FLOW);
        assertThat(testUhttp.getRefreshFlowRequest()).isEqualTo(DEFAULT_REFRESH_FLOW_REQUEST);
        assertThat(testUhttp.getRefreshFlowBpSpeed()).isEqualTo(DEFAULT_REFRESH_FLOW_BP_SPEED);
        assertThat(testUhttp.getRefreshFlowBpSpeedDRate()).isEqualTo(DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getRefreshFlowSpDelay()).isEqualTo(DEFAULT_REFRESH_FLOW_SP_DELAY);
        assertThat(testUhttp.getRefreshFlowSpDelayDRate()).isEqualTo(DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getInstantFlowRate()).isEqualTo(DEFAULT_INSTANT_FLOW_RATE);
        assertThat(testUhttp.getInstantFlowSuccessRate()).isEqualTo(DEFAULT_INSTANT_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getInstantFlowSuccessDRate()).isEqualTo(DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getInstantFlow()).isEqualTo(DEFAULT_INSTANT_FLOW);
        assertThat(testUhttp.getInstantFlowRequest()).isEqualTo(DEFAULT_INSTANT_FLOW_REQUEST);
        assertThat(testUhttp.getInstantFlowBpSpeed()).isEqualTo(DEFAULT_INSTANT_FLOW_BP_SPEED);
        assertThat(testUhttp.getInstantFlowBpSpeedDRate()).isEqualTo(DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getInstantFlowSpDelay()).isEqualTo(DEFAULT_INSTANT_FLOW_SP_DELAY);
        assertThat(testUhttp.getInstantFlowSpDelayDRate()).isEqualTo(DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getTcpCreactlinkDelay()).isEqualTo(DEFAULT_TCP_CREACTLINK_DELAY);
        assertThat(testUhttp.getTcpCreactlinkCount()).isEqualTo(DEFAULT_TCP_CREACTLINK_COUNT);
        assertThat(testUhttp.getTcpCreactlinkResponseDelay()).isEqualTo(DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY);
        assertThat(testUhttp.getTcpCreactlinkResponseCount()).isEqualTo(DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT);
        assertThat(testUhttp.getTcpCreactlinkConfirmDelay()).isEqualTo(DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY);
        assertThat(testUhttp.getTcpCreactlinkConfirmCount()).isEqualTo(DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT);
        assertThat(testUhttp.getBpFlow()).isEqualTo(DEFAULT_BP_FLOW);
        assertThat(testUhttp.getBpDelay()).isEqualTo(DEFAULT_BP_DELAY);
        assertThat(testUhttp.getServiceRequest()).isEqualTo(DEFAULT_SERVICE_REQUEST);
        assertThat(testUhttp.getServiceSuccess()).isEqualTo(DEFAULT_SERVICE_SUCCESS);
        assertThat(testUhttp.getTencentVideoServiceRequest()).isEqualTo(DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST);

        // Validate the Uhttp in Elasticsearch
        Uhttp uhttpEs = uhttpSearchRepository.findOne(testUhttp.getId());
        assertThat(uhttpEs).isEqualToComparingFieldByField(testUhttp);
    }

    @Test
    @Transactional
    public void createUhttpWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = uhttpRepository.findAll().size();

        // Create the Uhttp with an existing ID
        uhttp.setId(1L);
        UhttpDTO uhttpDTO = uhttpMapper.toDto(uhttp);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUhttpMockMvc.perform(post("/api/uhttps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uhttpDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = uhttpRepository.findAll().size();
        // set the field null
        uhttp.setPdate(null);

        // Create the Uhttp, which fails.
        UhttpDTO uhttpDTO = uhttpMapper.toDto(uhttp);

        restUhttpMockMvc.perform(post("/api/uhttps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uhttpDTO)))
            .andExpect(status().isBadRequest());

        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUhttps() throws Exception {
        // Initialize the database
        uhttpRepository.saveAndFlush(uhttp);

        // Get all the uhttpList
        restUhttpMockMvc.perform(get("/api/uhttps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uhttp.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].flowSum").value(hasItem(DEFAULT_FLOW_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowRate").value(hasItem(DEFAULT_RATE_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSuccessRate").value(hasItem(DEFAULT_RATE_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSuccessDRate").value(hasItem(DEFAULT_RATE_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlow").value(hasItem(DEFAULT_RATE_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowRequest").value(hasItem(DEFAULT_RATE_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowBpSpeed").value(hasItem(DEFAULT_RATE_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowBpSpeedDRate").value(hasItem(DEFAULT_RATE_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSpDelay").value(hasItem(DEFAULT_RATE_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowSpDelayDRate").value(hasItem(DEFAULT_RATE_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowRate").value(hasItem(DEFAULT_DELAY_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSuccessRate").value(hasItem(DEFAULT_DELAY_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSuccessDRate").value(hasItem(DEFAULT_DELAY_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlow").value(hasItem(DEFAULT_DELAY_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowRequest").value(hasItem(DEFAULT_DELAY_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowBpSpeed").value(hasItem(DEFAULT_DELAY_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowBpSpeedDRate").value(hasItem(DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSpDelay").value(hasItem(DEFAULT_DELAY_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowSpDelayDRate").value(hasItem(DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowRate").value(hasItem(DEFAULT_REFRESH_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSuccessRate").value(hasItem(DEFAULT_REFRESH_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSuccessDRate").value(hasItem(DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlow").value(hasItem(DEFAULT_REFRESH_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowRequest").value(hasItem(DEFAULT_REFRESH_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowBpSpeed").value(hasItem(DEFAULT_REFRESH_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowBpSpeedDRate").value(hasItem(DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSpDelay").value(hasItem(DEFAULT_REFRESH_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSpDelayDRate").value(hasItem(DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowRate").value(hasItem(DEFAULT_INSTANT_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSuccessRate").value(hasItem(DEFAULT_INSTANT_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSuccessDRate").value(hasItem(DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlow").value(hasItem(DEFAULT_INSTANT_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowRequest").value(hasItem(DEFAULT_INSTANT_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowBpSpeed").value(hasItem(DEFAULT_INSTANT_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowBpSpeedDRate").value(hasItem(DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSpDelay").value(hasItem(DEFAULT_INSTANT_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowSpDelayDRate").value(hasItem(DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkCount").value(hasItem(DEFAULT_TCP_CREACTLINK_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkResponseDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkResponseCount").value(hasItem(DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkConfirmDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkConfirmCount").value(hasItem(DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].bpFlow").value(hasItem(DEFAULT_BP_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].bpDelay").value(hasItem(DEFAULT_BP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].serviceSuccess").value(hasItem(DEFAULT_SERVICE_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].tencentVideoServiceRequest").value(hasItem(DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST.intValue())));
    }

    @Test
    @Transactional
    public void getUhttp() throws Exception {
        // Initialize the database
        uhttpRepository.saveAndFlush(uhttp);

        // Get the uhttp
        restUhttpMockMvc.perform(get("/api/uhttps/{id}", uhttp.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(uhttp.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.phour").value(DEFAULT_PHOUR))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.toString()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.toString()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.toString()))
            .andExpect(jsonPath("$.flowSum").value(DEFAULT_FLOW_SUM.intValue()))
            .andExpect(jsonPath("$.rateFlowRate").value(DEFAULT_RATE_FLOW_RATE.doubleValue()))
            .andExpect(jsonPath("$.rateFlowSuccessRate").value(DEFAULT_RATE_FLOW_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.rateFlowSuccessDRate").value(DEFAULT_RATE_FLOW_SUCCESS_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.rateFlow").value(DEFAULT_RATE_FLOW.intValue()))
            .andExpect(jsonPath("$.rateFlowRequest").value(DEFAULT_RATE_FLOW_REQUEST.intValue()))
            .andExpect(jsonPath("$.rateFlowBpSpeed").value(DEFAULT_RATE_FLOW_BP_SPEED.intValue()))
            .andExpect(jsonPath("$.rateFlowBpSpeedDRate").value(DEFAULT_RATE_FLOW_BP_SPEED_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.rateFlowSpDelay").value(DEFAULT_RATE_FLOW_SP_DELAY.intValue()))
            .andExpect(jsonPath("$.rateFlowSpDelayDRate").value(DEFAULT_RATE_FLOW_SP_DELAY_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.delayFlowRate").value(DEFAULT_DELAY_FLOW_RATE.doubleValue()))
            .andExpect(jsonPath("$.delayFlowSuccessRate").value(DEFAULT_DELAY_FLOW_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.delayFlowSuccessDRate").value(DEFAULT_DELAY_FLOW_SUCCESS_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.delayFlow").value(DEFAULT_DELAY_FLOW.intValue()))
            .andExpect(jsonPath("$.delayFlowRequest").value(DEFAULT_DELAY_FLOW_REQUEST.intValue()))
            .andExpect(jsonPath("$.delayFlowBpSpeed").value(DEFAULT_DELAY_FLOW_BP_SPEED.intValue()))
            .andExpect(jsonPath("$.delayFlowBpSpeedDRate").value(DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.delayFlowSpDelay").value(DEFAULT_DELAY_FLOW_SP_DELAY.intValue()))
            .andExpect(jsonPath("$.delayFlowSpDelayDRate").value(DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.refreshFlowRate").value(DEFAULT_REFRESH_FLOW_RATE.doubleValue()))
            .andExpect(jsonPath("$.refreshFlowSuccessRate").value(DEFAULT_REFRESH_FLOW_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.refreshFlowSuccessDRate").value(DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.refreshFlow").value(DEFAULT_REFRESH_FLOW.intValue()))
            .andExpect(jsonPath("$.refreshFlowRequest").value(DEFAULT_REFRESH_FLOW_REQUEST.intValue()))
            .andExpect(jsonPath("$.refreshFlowBpSpeed").value(DEFAULT_REFRESH_FLOW_BP_SPEED.intValue()))
            .andExpect(jsonPath("$.refreshFlowBpSpeedDRate").value(DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.refreshFlowSpDelay").value(DEFAULT_REFRESH_FLOW_SP_DELAY.intValue()))
            .andExpect(jsonPath("$.refreshFlowSpDelayDRate").value(DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.instantFlowRate").value(DEFAULT_INSTANT_FLOW_RATE.doubleValue()))
            .andExpect(jsonPath("$.instantFlowSuccessRate").value(DEFAULT_INSTANT_FLOW_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.instantFlowSuccessDRate").value(DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.instantFlow").value(DEFAULT_INSTANT_FLOW.intValue()))
            .andExpect(jsonPath("$.instantFlowRequest").value(DEFAULT_INSTANT_FLOW_REQUEST.intValue()))
            .andExpect(jsonPath("$.instantFlowBpSpeed").value(DEFAULT_INSTANT_FLOW_BP_SPEED.intValue()))
            .andExpect(jsonPath("$.instantFlowBpSpeedDRate").value(DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.instantFlowSpDelay").value(DEFAULT_INSTANT_FLOW_SP_DELAY.intValue()))
            .andExpect(jsonPath("$.instantFlowSpDelayDRate").value(DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE.doubleValue()))
            .andExpect(jsonPath("$.tcpCreactlinkDelay").value(DEFAULT_TCP_CREACTLINK_DELAY.intValue()))
            .andExpect(jsonPath("$.tcpCreactlinkCount").value(DEFAULT_TCP_CREACTLINK_COUNT.intValue()))
            .andExpect(jsonPath("$.tcpCreactlinkResponseDelay").value(DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY.intValue()))
            .andExpect(jsonPath("$.tcpCreactlinkResponseCount").value(DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT.intValue()))
            .andExpect(jsonPath("$.tcpCreactlinkConfirmDelay").value(DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY.intValue()))
            .andExpect(jsonPath("$.tcpCreactlinkConfirmCount").value(DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT.intValue()))
            .andExpect(jsonPath("$.bpFlow").value(DEFAULT_BP_FLOW.intValue()))
            .andExpect(jsonPath("$.bpDelay").value(DEFAULT_BP_DELAY.intValue()))
            .andExpect(jsonPath("$.serviceRequest").value(DEFAULT_SERVICE_REQUEST.intValue()))
            .andExpect(jsonPath("$.serviceSuccess").value(DEFAULT_SERVICE_SUCCESS.intValue()))
            .andExpect(jsonPath("$.tencentVideoServiceRequest").value(DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingUhttp() throws Exception {
        // Get the uhttp
        restUhttpMockMvc.perform(get("/api/uhttps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUhttp() throws Exception {
        // Initialize the database
        uhttpRepository.saveAndFlush(uhttp);
        uhttpSearchRepository.save(uhttp);
        int databaseSizeBeforeUpdate = uhttpRepository.findAll().size();

        // Update the uhttp
        Uhttp updatedUhttp = uhttpRepository.findOne(uhttp.getId());
        updatedUhttp
            .pdate(UPDATED_PDATE)
            .phour(UPDATED_PHOUR)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .flowSum(UPDATED_FLOW_SUM)
            .rateFlowRate(UPDATED_RATE_FLOW_RATE)
            .rateFlowSuccessRate(UPDATED_RATE_FLOW_SUCCESS_RATE)
            .rateFlowSuccessDRate(UPDATED_RATE_FLOW_SUCCESS_D_RATE)
            .rateFlow(UPDATED_RATE_FLOW)
            .rateFlowRequest(UPDATED_RATE_FLOW_REQUEST)
            .rateFlowBpSpeed(UPDATED_RATE_FLOW_BP_SPEED)
            .rateFlowBpSpeedDRate(UPDATED_RATE_FLOW_BP_SPEED_D_RATE)
            .rateFlowSpDelay(UPDATED_RATE_FLOW_SP_DELAY)
            .rateFlowSpDelayDRate(UPDATED_RATE_FLOW_SP_DELAY_D_RATE)
            .delayFlowRate(UPDATED_DELAY_FLOW_RATE)
            .delayFlowSuccessRate(UPDATED_DELAY_FLOW_SUCCESS_RATE)
            .delayFlowSuccessDRate(UPDATED_DELAY_FLOW_SUCCESS_D_RATE)
            .delayFlow(UPDATED_DELAY_FLOW)
            .delayFlowRequest(UPDATED_DELAY_FLOW_REQUEST)
            .delayFlowBpSpeed(UPDATED_DELAY_FLOW_BP_SPEED)
            .delayFlowBpSpeedDRate(UPDATED_DELAY_FLOW_BP_SPEED_D_RATE)
            .delayFlowSpDelay(UPDATED_DELAY_FLOW_SP_DELAY)
            .delayFlowSpDelayDRate(UPDATED_DELAY_FLOW_SP_DELAY_D_RATE)
            .refreshFlowRate(UPDATED_REFRESH_FLOW_RATE)
            .refreshFlowSuccessRate(UPDATED_REFRESH_FLOW_SUCCESS_RATE)
            .refreshFlowSuccessDRate(UPDATED_REFRESH_FLOW_SUCCESS_D_RATE)
            .refreshFlow(UPDATED_REFRESH_FLOW)
            .refreshFlowRequest(UPDATED_REFRESH_FLOW_REQUEST)
            .refreshFlowBpSpeed(UPDATED_REFRESH_FLOW_BP_SPEED)
            .refreshFlowBpSpeedDRate(UPDATED_REFRESH_FLOW_BP_SPEED_D_RATE)
            .refreshFlowSpDelay(UPDATED_REFRESH_FLOW_SP_DELAY)
            .refreshFlowSpDelayDRate(UPDATED_REFRESH_FLOW_SP_DELAY_D_RATE)
            .instantFlowRate(UPDATED_INSTANT_FLOW_RATE)
            .instantFlowSuccessRate(UPDATED_INSTANT_FLOW_SUCCESS_RATE)
            .instantFlowSuccessDRate(UPDATED_INSTANT_FLOW_SUCCESS_D_RATE)
            .instantFlow(UPDATED_INSTANT_FLOW)
            .instantFlowRequest(UPDATED_INSTANT_FLOW_REQUEST)
            .instantFlowBpSpeed(UPDATED_INSTANT_FLOW_BP_SPEED)
            .instantFlowBpSpeedDRate(UPDATED_INSTANT_FLOW_BP_SPEED_D_RATE)
            .instantFlowSpDelay(UPDATED_INSTANT_FLOW_SP_DELAY)
            .instantFlowSpDelayDRate(UPDATED_INSTANT_FLOW_SP_DELAY_D_RATE)
            .tcpCreactlinkDelay(UPDATED_TCP_CREACTLINK_DELAY)
            .tcpCreactlinkCount(UPDATED_TCP_CREACTLINK_COUNT)
            .tcpCreactlinkResponseDelay(UPDATED_TCP_CREACTLINK_RESPONSE_DELAY)
            .tcpCreactlinkResponseCount(UPDATED_TCP_CREACTLINK_RESPONSE_COUNT)
            .tcpCreactlinkConfirmDelay(UPDATED_TCP_CREACTLINK_CONFIRM_DELAY)
            .tcpCreactlinkConfirmCount(UPDATED_TCP_CREACTLINK_CONFIRM_COUNT)
            .bpFlow(UPDATED_BP_FLOW)
            .bpDelay(UPDATED_BP_DELAY)
            .serviceRequest(UPDATED_SERVICE_REQUEST)
            .serviceSuccess(UPDATED_SERVICE_SUCCESS)
            .tencentVideoServiceRequest(UPDATED_TENCENT_VIDEO_SERVICE_REQUEST);
        UhttpDTO uhttpDTO = uhttpMapper.toDto(updatedUhttp);

        restUhttpMockMvc.perform(put("/api/uhttps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uhttpDTO)))
            .andExpect(status().isOk());

        // Validate the Uhttp in the database
        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeUpdate);
        Uhttp testUhttp = uhttpList.get(uhttpList.size() - 1);
        assertThat(testUhttp.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testUhttp.getPhour()).isEqualTo(UPDATED_PHOUR);
        assertThat(testUhttp.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testUhttp.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testUhttp.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testUhttp.getFlowSum()).isEqualTo(UPDATED_FLOW_SUM);
        assertThat(testUhttp.getRateFlowRate()).isEqualTo(UPDATED_RATE_FLOW_RATE);
        assertThat(testUhttp.getRateFlowSuccessRate()).isEqualTo(UPDATED_RATE_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getRateFlowSuccessDRate()).isEqualTo(UPDATED_RATE_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getRateFlow()).isEqualTo(UPDATED_RATE_FLOW);
        assertThat(testUhttp.getRateFlowRequest()).isEqualTo(UPDATED_RATE_FLOW_REQUEST);
        assertThat(testUhttp.getRateFlowBpSpeed()).isEqualTo(UPDATED_RATE_FLOW_BP_SPEED);
        assertThat(testUhttp.getRateFlowBpSpeedDRate()).isEqualTo(UPDATED_RATE_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getRateFlowSpDelay()).isEqualTo(UPDATED_RATE_FLOW_SP_DELAY);
        assertThat(testUhttp.getRateFlowSpDelayDRate()).isEqualTo(UPDATED_RATE_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getDelayFlowRate()).isEqualTo(UPDATED_DELAY_FLOW_RATE);
        assertThat(testUhttp.getDelayFlowSuccessRate()).isEqualTo(UPDATED_DELAY_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getDelayFlowSuccessDRate()).isEqualTo(UPDATED_DELAY_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getDelayFlow()).isEqualTo(UPDATED_DELAY_FLOW);
        assertThat(testUhttp.getDelayFlowRequest()).isEqualTo(UPDATED_DELAY_FLOW_REQUEST);
        assertThat(testUhttp.getDelayFlowBpSpeed()).isEqualTo(UPDATED_DELAY_FLOW_BP_SPEED);
        assertThat(testUhttp.getDelayFlowBpSpeedDRate()).isEqualTo(UPDATED_DELAY_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getDelayFlowSpDelay()).isEqualTo(UPDATED_DELAY_FLOW_SP_DELAY);
        assertThat(testUhttp.getDelayFlowSpDelayDRate()).isEqualTo(UPDATED_DELAY_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getRefreshFlowRate()).isEqualTo(UPDATED_REFRESH_FLOW_RATE);
        assertThat(testUhttp.getRefreshFlowSuccessRate()).isEqualTo(UPDATED_REFRESH_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getRefreshFlowSuccessDRate()).isEqualTo(UPDATED_REFRESH_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getRefreshFlow()).isEqualTo(UPDATED_REFRESH_FLOW);
        assertThat(testUhttp.getRefreshFlowRequest()).isEqualTo(UPDATED_REFRESH_FLOW_REQUEST);
        assertThat(testUhttp.getRefreshFlowBpSpeed()).isEqualTo(UPDATED_REFRESH_FLOW_BP_SPEED);
        assertThat(testUhttp.getRefreshFlowBpSpeedDRate()).isEqualTo(UPDATED_REFRESH_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getRefreshFlowSpDelay()).isEqualTo(UPDATED_REFRESH_FLOW_SP_DELAY);
        assertThat(testUhttp.getRefreshFlowSpDelayDRate()).isEqualTo(UPDATED_REFRESH_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getInstantFlowRate()).isEqualTo(UPDATED_INSTANT_FLOW_RATE);
        assertThat(testUhttp.getInstantFlowSuccessRate()).isEqualTo(UPDATED_INSTANT_FLOW_SUCCESS_RATE);
        assertThat(testUhttp.getInstantFlowSuccessDRate()).isEqualTo(UPDATED_INSTANT_FLOW_SUCCESS_D_RATE);
        assertThat(testUhttp.getInstantFlow()).isEqualTo(UPDATED_INSTANT_FLOW);
        assertThat(testUhttp.getInstantFlowRequest()).isEqualTo(UPDATED_INSTANT_FLOW_REQUEST);
        assertThat(testUhttp.getInstantFlowBpSpeed()).isEqualTo(UPDATED_INSTANT_FLOW_BP_SPEED);
        assertThat(testUhttp.getInstantFlowBpSpeedDRate()).isEqualTo(UPDATED_INSTANT_FLOW_BP_SPEED_D_RATE);
        assertThat(testUhttp.getInstantFlowSpDelay()).isEqualTo(UPDATED_INSTANT_FLOW_SP_DELAY);
        assertThat(testUhttp.getInstantFlowSpDelayDRate()).isEqualTo(UPDATED_INSTANT_FLOW_SP_DELAY_D_RATE);
        assertThat(testUhttp.getTcpCreactlinkDelay()).isEqualTo(UPDATED_TCP_CREACTLINK_DELAY);
        assertThat(testUhttp.getTcpCreactlinkCount()).isEqualTo(UPDATED_TCP_CREACTLINK_COUNT);
        assertThat(testUhttp.getTcpCreactlinkResponseDelay()).isEqualTo(UPDATED_TCP_CREACTLINK_RESPONSE_DELAY);
        assertThat(testUhttp.getTcpCreactlinkResponseCount()).isEqualTo(UPDATED_TCP_CREACTLINK_RESPONSE_COUNT);
        assertThat(testUhttp.getTcpCreactlinkConfirmDelay()).isEqualTo(UPDATED_TCP_CREACTLINK_CONFIRM_DELAY);
        assertThat(testUhttp.getTcpCreactlinkConfirmCount()).isEqualTo(UPDATED_TCP_CREACTLINK_CONFIRM_COUNT);
        assertThat(testUhttp.getBpFlow()).isEqualTo(UPDATED_BP_FLOW);
        assertThat(testUhttp.getBpDelay()).isEqualTo(UPDATED_BP_DELAY);
        assertThat(testUhttp.getServiceRequest()).isEqualTo(UPDATED_SERVICE_REQUEST);
        assertThat(testUhttp.getServiceSuccess()).isEqualTo(UPDATED_SERVICE_SUCCESS);
        assertThat(testUhttp.getTencentVideoServiceRequest()).isEqualTo(UPDATED_TENCENT_VIDEO_SERVICE_REQUEST);

        // Validate the Uhttp in Elasticsearch
        Uhttp uhttpEs = uhttpSearchRepository.findOne(testUhttp.getId());
        assertThat(uhttpEs).isEqualToComparingFieldByField(testUhttp);
    }

    @Test
    @Transactional
    public void updateNonExistingUhttp() throws Exception {
        int databaseSizeBeforeUpdate = uhttpRepository.findAll().size();

        // Create the Uhttp
        UhttpDTO uhttpDTO = uhttpMapper.toDto(uhttp);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restUhttpMockMvc.perform(put("/api/uhttps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uhttpDTO)))
            .andExpect(status().isCreated());

        // Validate the Uhttp in the database
        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteUhttp() throws Exception {
        // Initialize the database
        uhttpRepository.saveAndFlush(uhttp);
        uhttpSearchRepository.save(uhttp);
        int databaseSizeBeforeDelete = uhttpRepository.findAll().size();

        // Get the uhttp
        restUhttpMockMvc.perform(delete("/api/uhttps/{id}", uhttp.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean uhttpExistsInEs = uhttpSearchRepository.exists(uhttp.getId());
        assertThat(uhttpExistsInEs).isFalse();

        // Validate the database is empty
        List<Uhttp> uhttpList = uhttpRepository.findAll();
        assertThat(uhttpList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchUhttp() throws Exception {
        // Initialize the database
        uhttpRepository.saveAndFlush(uhttp);
        uhttpSearchRepository.save(uhttp);

        // Search the uhttp
        restUhttpMockMvc.perform(get("/api/_search/uhttps?query=id:" + uhttp.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uhttp.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].flowSum").value(hasItem(DEFAULT_FLOW_SUM.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowRate").value(hasItem(DEFAULT_RATE_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSuccessRate").value(hasItem(DEFAULT_RATE_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSuccessDRate").value(hasItem(DEFAULT_RATE_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlow").value(hasItem(DEFAULT_RATE_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowRequest").value(hasItem(DEFAULT_RATE_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowBpSpeed").value(hasItem(DEFAULT_RATE_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowBpSpeedDRate").value(hasItem(DEFAULT_RATE_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rateFlowSpDelay").value(hasItem(DEFAULT_RATE_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].rateFlowSpDelayDRate").value(hasItem(DEFAULT_RATE_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowRate").value(hasItem(DEFAULT_DELAY_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSuccessRate").value(hasItem(DEFAULT_DELAY_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSuccessDRate").value(hasItem(DEFAULT_DELAY_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlow").value(hasItem(DEFAULT_DELAY_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowRequest").value(hasItem(DEFAULT_DELAY_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowBpSpeed").value(hasItem(DEFAULT_DELAY_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowBpSpeedDRate").value(hasItem(DEFAULT_DELAY_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].delayFlowSpDelay").value(hasItem(DEFAULT_DELAY_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].delayFlowSpDelayDRate").value(hasItem(DEFAULT_DELAY_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowRate").value(hasItem(DEFAULT_REFRESH_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSuccessRate").value(hasItem(DEFAULT_REFRESH_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSuccessDRate").value(hasItem(DEFAULT_REFRESH_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlow").value(hasItem(DEFAULT_REFRESH_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowRequest").value(hasItem(DEFAULT_REFRESH_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowBpSpeed").value(hasItem(DEFAULT_REFRESH_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowBpSpeedDRate").value(hasItem(DEFAULT_REFRESH_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSpDelay").value(hasItem(DEFAULT_REFRESH_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].refreshFlowSpDelayDRate").value(hasItem(DEFAULT_REFRESH_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowRate").value(hasItem(DEFAULT_INSTANT_FLOW_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSuccessRate").value(hasItem(DEFAULT_INSTANT_FLOW_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSuccessDRate").value(hasItem(DEFAULT_INSTANT_FLOW_SUCCESS_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlow").value(hasItem(DEFAULT_INSTANT_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowRequest").value(hasItem(DEFAULT_INSTANT_FLOW_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowBpSpeed").value(hasItem(DEFAULT_INSTANT_FLOW_BP_SPEED.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowBpSpeedDRate").value(hasItem(DEFAULT_INSTANT_FLOW_BP_SPEED_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].instantFlowSpDelay").value(hasItem(DEFAULT_INSTANT_FLOW_SP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].instantFlowSpDelayDRate").value(hasItem(DEFAULT_INSTANT_FLOW_SP_DELAY_D_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkCount").value(hasItem(DEFAULT_TCP_CREACTLINK_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkResponseDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_RESPONSE_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkResponseCount").value(hasItem(DEFAULT_TCP_CREACTLINK_RESPONSE_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkConfirmDelay").value(hasItem(DEFAULT_TCP_CREACTLINK_CONFIRM_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].tcpCreactlinkConfirmCount").value(hasItem(DEFAULT_TCP_CREACTLINK_CONFIRM_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].bpFlow").value(hasItem(DEFAULT_BP_FLOW.intValue())))
            .andExpect(jsonPath("$.[*].bpDelay").value(hasItem(DEFAULT_BP_DELAY.intValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].serviceSuccess").value(hasItem(DEFAULT_SERVICE_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].tencentVideoServiceRequest").value(hasItem(DEFAULT_TENCENT_VIDEO_SERVICE_REQUEST.intValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Uhttp.class);
        Uhttp uhttp1 = new Uhttp();
        uhttp1.setId(1L);
        Uhttp uhttp2 = new Uhttp();
        uhttp2.setId(uhttp1.getId());
        assertThat(uhttp1).isEqualTo(uhttp2);
        uhttp2.setId(2L);
        assertThat(uhttp1).isNotEqualTo(uhttp2);
        uhttp1.setId(null);
        assertThat(uhttp1).isNotEqualTo(uhttp2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UhttpDTO.class);
        UhttpDTO uhttpDTO1 = new UhttpDTO();
        uhttpDTO1.setId(1L);
        UhttpDTO uhttpDTO2 = new UhttpDTO();
        assertThat(uhttpDTO1).isNotEqualTo(uhttpDTO2);
        uhttpDTO2.setId(uhttpDTO1.getId());
        assertThat(uhttpDTO1).isEqualTo(uhttpDTO2);
        uhttpDTO2.setId(2L);
        assertThat(uhttpDTO1).isNotEqualTo(uhttpDTO2);
        uhttpDTO1.setId(null);
        assertThat(uhttpDTO1).isNotEqualTo(uhttpDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(uhttpMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(uhttpMapper.fromId(null)).isNull();
    }
}
