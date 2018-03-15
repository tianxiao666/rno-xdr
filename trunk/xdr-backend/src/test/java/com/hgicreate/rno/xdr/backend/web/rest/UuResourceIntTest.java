package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Uu;
import com.hgicreate.rno.xdr.backend.repository.UuRepository;
import com.hgicreate.rno.xdr.backend.service.UuService;
import com.hgicreate.rno.xdr.backend.repository.search.UuSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.UuDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.UuMapper;
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
 * Test class for the UuResource REST controller.
 *
 * @see UuResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class UuResourceIntTest {

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

    private static final Integer DEFAULT_RRC_CONNECT_REQUEST = 1;
    private static final Integer UPDATED_RRC_CONNECT_REQUEST = 2;

    private static final Integer DEFAULT_RRC_CONNECT_SUCCESS = 1;
    private static final Integer UPDATED_RRC_CONNECT_SUCCESS = 2;

    private static final Double DEFAULT_RRC_CONNECT_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RRC_CONNECT_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_RRC_RECONFIG_REQUEST = 1;
    private static final Integer UPDATED_RRC_RECONFIG_REQUEST = 2;

    private static final Integer DEFAULT_RRC_RECONFIG_SUCCESS = 1;
    private static final Integer UPDATED_RRC_RECONFIG_SUCCESS = 2;

    private static final Double DEFAULT_RRC_RECONFIG_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RRC_RECONFIG_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_RRC_RECONSTRUCTION_REQUEST = 1;
    private static final Integer UPDATED_RRC_RECONSTRUCTION_REQUEST = 2;

    private static final Integer DEFAULT_RRC_RECONSTRUCTION_SUCCESS = 1;
    private static final Integer UPDATED_RRC_RECONSTRUCTION_SUCCESS = 2;

    private static final Double DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RRC_RECONSTRUCTION_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_RRC_RELEASE_REQUEST = 1;
    private static final Integer UPDATED_RRC_RELEASE_REQUEST = 2;

    private static final Integer DEFAULT_RRC_RELEASE_SUCCESS = 1;
    private static final Integer UPDATED_RRC_RELEASE_SUCCESS = 2;

    private static final Double DEFAULT_RRC_RELEASE_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RRC_RELEASE_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_SM_ACTIVATE_REQUEST = 1;
    private static final Integer UPDATED_SM_ACTIVATE_REQUEST = 2;

    private static final Integer DEFAULT_SM_ACTIVATE_SUCCESS = 1;
    private static final Integer UPDATED_SM_ACTIVATE_SUCCESS = 2;

    private static final Double DEFAULT_SM_ACTIVATE_SUCCESS_RATE = 1D;
    private static final Double UPDATED_SM_ACTIVATE_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_CELL_INTER_HANDOVER_REQUEST = 1;
    private static final Integer UPDATED_CELL_INTER_HANDOVER_REQUEST = 2;

    private static final Integer DEFAULT_CELL_INTER_HANDOVER_SUCCESS = 1;
    private static final Integer UPDATED_CELL_INTER_HANDOVER_SUCCESS = 2;

    private static final Double DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE = 1D;
    private static final Double UPDATED_CELL_INTER_HANDOVER_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_STATION_INTRA_HANDOVER_REQUEST = 1;
    private static final Integer UPDATED_STATION_INTRA_HANDOVER_REQUEST = 2;

    private static final Integer DEFAULT_STATION_INTRA_HANDOVER_SUCCESS = 1;
    private static final Integer UPDATED_STATION_INTRA_HANDOVER_SUCCESS = 2;

    private static final Double DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE = 1D;
    private static final Double UPDATED_STATION_INTRA_HANDOVER_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_STATION_INTER_HANDOVER_REQUEST = 1;
    private static final Integer UPDATED_STATION_INTER_HANDOVER_REQUEST = 2;

    private static final Integer DEFAULT_STATION_INTER_HANDOVER_SUCCESS = 1;
    private static final Integer UPDATED_STATION_INTER_HANDOVER_SUCCESS = 2;

    private static final Double DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE = 1D;
    private static final Double UPDATED_STATION_INTER_HANDOVER_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_RAT_IN_REQUEST = 1;
    private static final Integer UPDATED_RAT_IN_REQUEST = 2;

    private static final Integer DEFAULT_RAT_IN_SUCCESS = 1;
    private static final Integer UPDATED_RAT_IN_SUCCESS = 2;

    private static final Double DEFAULT_RAT_IN_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RAT_IN_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_RAT_OUT_REQUEST = 1;
    private static final Integer UPDATED_RAT_OUT_REQUEST = 2;

    private static final Integer DEFAULT_RAT_OUT_SUCCESS = 1;
    private static final Integer UPDATED_RAT_OUT_SUCCESS = 2;

    private static final Double DEFAULT_RAT_OUT_SUCCESS_RATE = 1D;
    private static final Double UPDATED_RAT_OUT_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_PS_PAGING_REQUEST = 1;
    private static final Integer UPDATED_PS_PAGING_REQUEST = 2;

    private static final Integer DEFAULT_PS_PAGING_SUCCESS = 1;
    private static final Integer UPDATED_PS_PAGING_SUCCESS = 2;

    private static final Double DEFAULT_PS_PAGING_SUCCESS_RATE = 1D;
    private static final Double UPDATED_PS_PAGING_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_CS_PAGING_REQUEST = 1;
    private static final Integer UPDATED_CS_PAGING_REQUEST = 2;

    private static final Integer DEFAULT_CS_PAGING_SUCCESS = 1;
    private static final Integer UPDATED_CS_PAGING_SUCCESS = 2;

    private static final Double DEFAULT_CS_PAGING_SUCCESS_RATE = 1D;
    private static final Double UPDATED_CS_PAGING_SUCCESS_RATE = 2D;

    private static final Integer DEFAULT_OTHEREVENT_REQUEST = 1;
    private static final Integer UPDATED_OTHEREVENT_REQUEST = 2;

    private static final Integer DEFAULT_OTHEREVENT_SUCCESS = 1;
    private static final Integer UPDATED_OTHEREVENT_SUCCESS = 2;

    private static final Double DEFAULT_OTHEREVENT_SUCCESS_RATE = 1D;
    private static final Double UPDATED_OTHEREVENT_SUCCESS_RATE = 2D;

    @Autowired
    private UuRepository uuRepository;

    @Autowired
    private UuMapper uuMapper;

    @Autowired
    private UuService uuService;

    @Autowired
    private UuSearchRepository uuSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restUuMockMvc;

    private Uu uu;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UuResource uuResource = new UuResource(uuService);
        this.restUuMockMvc = MockMvcBuilders.standaloneSetup(uuResource)
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
    public static Uu createEntity(EntityManager em) {
        Uu uu = new Uu()
            .pdate(DEFAULT_PDATE)
            .phour(DEFAULT_PHOUR)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .rrcConnectRequest(DEFAULT_RRC_CONNECT_REQUEST)
            .rrcConnectSuccess(DEFAULT_RRC_CONNECT_SUCCESS)
            .rrcConnectSuccessRate(DEFAULT_RRC_CONNECT_SUCCESS_RATE)
            .rrcReconfigRequest(DEFAULT_RRC_RECONFIG_REQUEST)
            .rrcReconfigSuccess(DEFAULT_RRC_RECONFIG_SUCCESS)
            .rrcReconfigSuccessRate(DEFAULT_RRC_RECONFIG_SUCCESS_RATE)
            .rrcReconstructionRequest(DEFAULT_RRC_RECONSTRUCTION_REQUEST)
            .rrcReconstructionSuccess(DEFAULT_RRC_RECONSTRUCTION_SUCCESS)
            .rrcReconstructionSuccessRate(DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE)
            .rrcReleaseRequest(DEFAULT_RRC_RELEASE_REQUEST)
            .rrcReleaseSuccess(DEFAULT_RRC_RELEASE_SUCCESS)
            .rrcReleaseSuccessRate(DEFAULT_RRC_RELEASE_SUCCESS_RATE)
            .smActivateRequest(DEFAULT_SM_ACTIVATE_REQUEST)
            .smActivateSuccess(DEFAULT_SM_ACTIVATE_SUCCESS)
            .smActivateSuccessRate(DEFAULT_SM_ACTIVATE_SUCCESS_RATE)
            .cellInterHandoverRequest(DEFAULT_CELL_INTER_HANDOVER_REQUEST)
            .cellInterHandoverSuccess(DEFAULT_CELL_INTER_HANDOVER_SUCCESS)
            .cellInterHandoverSuccessRate(DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE)
            .stationIntraHandoverRequest(DEFAULT_STATION_INTRA_HANDOVER_REQUEST)
            .stationIntraHandoverSuccess(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS)
            .stationIntraHandoverSuccessRate(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE)
            .stationInterHandoverRequest(DEFAULT_STATION_INTER_HANDOVER_REQUEST)
            .stationInterHandoverSuccess(DEFAULT_STATION_INTER_HANDOVER_SUCCESS)
            .stationInterHandoverSuccessRate(DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE)
            .ratInRequest(DEFAULT_RAT_IN_REQUEST)
            .ratInSuccess(DEFAULT_RAT_IN_SUCCESS)
            .ratInSuccessRate(DEFAULT_RAT_IN_SUCCESS_RATE)
            .ratOutRequest(DEFAULT_RAT_OUT_REQUEST)
            .ratOutSuccess(DEFAULT_RAT_OUT_SUCCESS)
            .ratOutSuccessRate(DEFAULT_RAT_OUT_SUCCESS_RATE)
            .psPagingRequest(DEFAULT_PS_PAGING_REQUEST)
            .psPagingSuccess(DEFAULT_PS_PAGING_SUCCESS)
            .psPagingSuccessRate(DEFAULT_PS_PAGING_SUCCESS_RATE)
            .csPagingRequest(DEFAULT_CS_PAGING_REQUEST)
            .csPagingSuccess(DEFAULT_CS_PAGING_SUCCESS)
            .csPagingSuccessRate(DEFAULT_CS_PAGING_SUCCESS_RATE)
            .othereventRequest(DEFAULT_OTHEREVENT_REQUEST)
            .othereventSuccess(DEFAULT_OTHEREVENT_SUCCESS)
            .othereventSuccessRate(DEFAULT_OTHEREVENT_SUCCESS_RATE);
        return uu;
    }

    @Before
    public void initTest() {
        uuSearchRepository.deleteAll();
        uu = createEntity(em);
    }

    @Test
    @Transactional
    public void createUu() throws Exception {
        int databaseSizeBeforeCreate = uuRepository.findAll().size();

        // Create the Uu
        UuDTO uuDTO = uuMapper.toDto(uu);
        restUuMockMvc.perform(post("/api/uus")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uuDTO)))
            .andExpect(status().isCreated());

        // Validate the Uu in the database
        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeCreate + 1);
        Uu testUu = uuList.get(uuList.size() - 1);
        assertThat(testUu.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testUu.getPhour()).isEqualTo(DEFAULT_PHOUR);
        assertThat(testUu.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testUu.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testUu.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testUu.getRrcConnectRequest()).isEqualTo(DEFAULT_RRC_CONNECT_REQUEST);
        assertThat(testUu.getRrcConnectSuccess()).isEqualTo(DEFAULT_RRC_CONNECT_SUCCESS);
        assertThat(testUu.getRrcConnectSuccessRate()).isEqualTo(DEFAULT_RRC_CONNECT_SUCCESS_RATE);
        assertThat(testUu.getRrcReconfigRequest()).isEqualTo(DEFAULT_RRC_RECONFIG_REQUEST);
        assertThat(testUu.getRrcReconfigSuccess()).isEqualTo(DEFAULT_RRC_RECONFIG_SUCCESS);
        assertThat(testUu.getRrcReconfigSuccessRate()).isEqualTo(DEFAULT_RRC_RECONFIG_SUCCESS_RATE);
        assertThat(testUu.getRrcReconstructionRequest()).isEqualTo(DEFAULT_RRC_RECONSTRUCTION_REQUEST);
        assertThat(testUu.getRrcReconstructionSuccess()).isEqualTo(DEFAULT_RRC_RECONSTRUCTION_SUCCESS);
        assertThat(testUu.getRrcReconstructionSuccessRate()).isEqualTo(DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE);
        assertThat(testUu.getRrcReleaseRequest()).isEqualTo(DEFAULT_RRC_RELEASE_REQUEST);
        assertThat(testUu.getRrcReleaseSuccess()).isEqualTo(DEFAULT_RRC_RELEASE_SUCCESS);
        assertThat(testUu.getRrcReleaseSuccessRate()).isEqualTo(DEFAULT_RRC_RELEASE_SUCCESS_RATE);
        assertThat(testUu.getSmActivateRequest()).isEqualTo(DEFAULT_SM_ACTIVATE_REQUEST);
        assertThat(testUu.getSmActivateSuccess()).isEqualTo(DEFAULT_SM_ACTIVATE_SUCCESS);
        assertThat(testUu.getSmActivateSuccessRate()).isEqualTo(DEFAULT_SM_ACTIVATE_SUCCESS_RATE);
        assertThat(testUu.getCellInterHandoverRequest()).isEqualTo(DEFAULT_CELL_INTER_HANDOVER_REQUEST);
        assertThat(testUu.getCellInterHandoverSuccess()).isEqualTo(DEFAULT_CELL_INTER_HANDOVER_SUCCESS);
        assertThat(testUu.getCellInterHandoverSuccessRate()).isEqualTo(DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getStationIntraHandoverRequest()).isEqualTo(DEFAULT_STATION_INTRA_HANDOVER_REQUEST);
        assertThat(testUu.getStationIntraHandoverSuccess()).isEqualTo(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS);
        assertThat(testUu.getStationIntraHandoverSuccessRate()).isEqualTo(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getStationInterHandoverRequest()).isEqualTo(DEFAULT_STATION_INTER_HANDOVER_REQUEST);
        assertThat(testUu.getStationInterHandoverSuccess()).isEqualTo(DEFAULT_STATION_INTER_HANDOVER_SUCCESS);
        assertThat(testUu.getStationInterHandoverSuccessRate()).isEqualTo(DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getRatInRequest()).isEqualTo(DEFAULT_RAT_IN_REQUEST);
        assertThat(testUu.getRatInSuccess()).isEqualTo(DEFAULT_RAT_IN_SUCCESS);
        assertThat(testUu.getRatInSuccessRate()).isEqualTo(DEFAULT_RAT_IN_SUCCESS_RATE);
        assertThat(testUu.getRatOutRequest()).isEqualTo(DEFAULT_RAT_OUT_REQUEST);
        assertThat(testUu.getRatOutSuccess()).isEqualTo(DEFAULT_RAT_OUT_SUCCESS);
        assertThat(testUu.getRatOutSuccessRate()).isEqualTo(DEFAULT_RAT_OUT_SUCCESS_RATE);
        assertThat(testUu.getPsPagingRequest()).isEqualTo(DEFAULT_PS_PAGING_REQUEST);
        assertThat(testUu.getPsPagingSuccess()).isEqualTo(DEFAULT_PS_PAGING_SUCCESS);
        assertThat(testUu.getPsPagingSuccessRate()).isEqualTo(DEFAULT_PS_PAGING_SUCCESS_RATE);
        assertThat(testUu.getCsPagingRequest()).isEqualTo(DEFAULT_CS_PAGING_REQUEST);
        assertThat(testUu.getCsPagingSuccess()).isEqualTo(DEFAULT_CS_PAGING_SUCCESS);
        assertThat(testUu.getCsPagingSuccessRate()).isEqualTo(DEFAULT_CS_PAGING_SUCCESS_RATE);
        assertThat(testUu.getOthereventRequest()).isEqualTo(DEFAULT_OTHEREVENT_REQUEST);
        assertThat(testUu.getOthereventSuccess()).isEqualTo(DEFAULT_OTHEREVENT_SUCCESS);
        assertThat(testUu.getOthereventSuccessRate()).isEqualTo(DEFAULT_OTHEREVENT_SUCCESS_RATE);

        // Validate the Uu in Elasticsearch
        Uu uuEs = uuSearchRepository.findOne(testUu.getId());
        assertThat(uuEs).isEqualToComparingFieldByField(testUu);
    }

    @Test
    @Transactional
    public void createUuWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = uuRepository.findAll().size();

        // Create the Uu with an existing ID
        uu.setId(1L);
        UuDTO uuDTO = uuMapper.toDto(uu);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUuMockMvc.perform(post("/api/uus")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uuDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = uuRepository.findAll().size();
        // set the field null
        uu.setPdate(null);

        // Create the Uu, which fails.
        UuDTO uuDTO = uuMapper.toDto(uu);

        restUuMockMvc.perform(post("/api/uus")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uuDTO)))
            .andExpect(status().isBadRequest());

        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUus() throws Exception {
        // Initialize the database
        uuRepository.saveAndFlush(uu);

        // Get all the uuList
        restUuMockMvc.perform(get("/api/uus?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uu.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].rrcConnectRequest").value(hasItem(DEFAULT_RRC_CONNECT_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcConnectSuccess").value(hasItem(DEFAULT_RRC_CONNECT_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcConnectSuccessRate").value(hasItem(DEFAULT_RRC_CONNECT_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReconfigRequest").value(hasItem(DEFAULT_RRC_RECONFIG_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReconfigSuccess").value(hasItem(DEFAULT_RRC_RECONFIG_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReconfigSuccessRate").value(hasItem(DEFAULT_RRC_RECONFIG_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReconstructionRequest").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReconstructionSuccess").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReconstructionSuccessRate").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReleaseRequest").value(hasItem(DEFAULT_RRC_RELEASE_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReleaseSuccess").value(hasItem(DEFAULT_RRC_RELEASE_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReleaseSuccessRate").value(hasItem(DEFAULT_RRC_RELEASE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].smActivateRequest").value(hasItem(DEFAULT_SM_ACTIVATE_REQUEST)))
            .andExpect(jsonPath("$.[*].smActivateSuccess").value(hasItem(DEFAULT_SM_ACTIVATE_SUCCESS)))
            .andExpect(jsonPath("$.[*].smActivateSuccessRate").value(hasItem(DEFAULT_SM_ACTIVATE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].cellInterHandoverRequest").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].cellInterHandoverSuccess").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].cellInterHandoverSuccessRate").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].stationIntraHandoverRequest").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].stationIntraHandoverSuccess").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].stationIntraHandoverSuccessRate").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].stationInterHandoverRequest").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].stationInterHandoverSuccess").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].stationInterHandoverSuccessRate").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].ratInRequest").value(hasItem(DEFAULT_RAT_IN_REQUEST)))
            .andExpect(jsonPath("$.[*].ratInSuccess").value(hasItem(DEFAULT_RAT_IN_SUCCESS)))
            .andExpect(jsonPath("$.[*].ratInSuccessRate").value(hasItem(DEFAULT_RAT_IN_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].ratOutRequest").value(hasItem(DEFAULT_RAT_OUT_REQUEST)))
            .andExpect(jsonPath("$.[*].ratOutSuccess").value(hasItem(DEFAULT_RAT_OUT_SUCCESS)))
            .andExpect(jsonPath("$.[*].ratOutSuccessRate").value(hasItem(DEFAULT_RAT_OUT_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].psPagingRequest").value(hasItem(DEFAULT_PS_PAGING_REQUEST)))
            .andExpect(jsonPath("$.[*].psPagingSuccess").value(hasItem(DEFAULT_PS_PAGING_SUCCESS)))
            .andExpect(jsonPath("$.[*].psPagingSuccessRate").value(hasItem(DEFAULT_PS_PAGING_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].csPagingRequest").value(hasItem(DEFAULT_CS_PAGING_REQUEST)))
            .andExpect(jsonPath("$.[*].csPagingSuccess").value(hasItem(DEFAULT_CS_PAGING_SUCCESS)))
            .andExpect(jsonPath("$.[*].csPagingSuccessRate").value(hasItem(DEFAULT_CS_PAGING_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].othereventRequest").value(hasItem(DEFAULT_OTHEREVENT_REQUEST)))
            .andExpect(jsonPath("$.[*].othereventSuccess").value(hasItem(DEFAULT_OTHEREVENT_SUCCESS)))
            .andExpect(jsonPath("$.[*].othereventSuccessRate").value(hasItem(DEFAULT_OTHEREVENT_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void getUu() throws Exception {
        // Initialize the database
        uuRepository.saveAndFlush(uu);

        // Get the uu
        restUuMockMvc.perform(get("/api/uus/{id}", uu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(uu.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.phour").value(DEFAULT_PHOUR))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.toString()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.toString()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.toString()))
            .andExpect(jsonPath("$.rrcConnectRequest").value(DEFAULT_RRC_CONNECT_REQUEST))
            .andExpect(jsonPath("$.rrcConnectSuccess").value(DEFAULT_RRC_CONNECT_SUCCESS))
            .andExpect(jsonPath("$.rrcConnectSuccessRate").value(DEFAULT_RRC_CONNECT_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.rrcReconfigRequest").value(DEFAULT_RRC_RECONFIG_REQUEST))
            .andExpect(jsonPath("$.rrcReconfigSuccess").value(DEFAULT_RRC_RECONFIG_SUCCESS))
            .andExpect(jsonPath("$.rrcReconfigSuccessRate").value(DEFAULT_RRC_RECONFIG_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.rrcReconstructionRequest").value(DEFAULT_RRC_RECONSTRUCTION_REQUEST))
            .andExpect(jsonPath("$.rrcReconstructionSuccess").value(DEFAULT_RRC_RECONSTRUCTION_SUCCESS))
            .andExpect(jsonPath("$.rrcReconstructionSuccessRate").value(DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.rrcReleaseRequest").value(DEFAULT_RRC_RELEASE_REQUEST))
            .andExpect(jsonPath("$.rrcReleaseSuccess").value(DEFAULT_RRC_RELEASE_SUCCESS))
            .andExpect(jsonPath("$.rrcReleaseSuccessRate").value(DEFAULT_RRC_RELEASE_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.smActivateRequest").value(DEFAULT_SM_ACTIVATE_REQUEST))
            .andExpect(jsonPath("$.smActivateSuccess").value(DEFAULT_SM_ACTIVATE_SUCCESS))
            .andExpect(jsonPath("$.smActivateSuccessRate").value(DEFAULT_SM_ACTIVATE_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.cellInterHandoverRequest").value(DEFAULT_CELL_INTER_HANDOVER_REQUEST))
            .andExpect(jsonPath("$.cellInterHandoverSuccess").value(DEFAULT_CELL_INTER_HANDOVER_SUCCESS))
            .andExpect(jsonPath("$.cellInterHandoverSuccessRate").value(DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.stationIntraHandoverRequest").value(DEFAULT_STATION_INTRA_HANDOVER_REQUEST))
            .andExpect(jsonPath("$.stationIntraHandoverSuccess").value(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS))
            .andExpect(jsonPath("$.stationIntraHandoverSuccessRate").value(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.stationInterHandoverRequest").value(DEFAULT_STATION_INTER_HANDOVER_REQUEST))
            .andExpect(jsonPath("$.stationInterHandoverSuccess").value(DEFAULT_STATION_INTER_HANDOVER_SUCCESS))
            .andExpect(jsonPath("$.stationInterHandoverSuccessRate").value(DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.ratInRequest").value(DEFAULT_RAT_IN_REQUEST))
            .andExpect(jsonPath("$.ratInSuccess").value(DEFAULT_RAT_IN_SUCCESS))
            .andExpect(jsonPath("$.ratInSuccessRate").value(DEFAULT_RAT_IN_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.ratOutRequest").value(DEFAULT_RAT_OUT_REQUEST))
            .andExpect(jsonPath("$.ratOutSuccess").value(DEFAULT_RAT_OUT_SUCCESS))
            .andExpect(jsonPath("$.ratOutSuccessRate").value(DEFAULT_RAT_OUT_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.psPagingRequest").value(DEFAULT_PS_PAGING_REQUEST))
            .andExpect(jsonPath("$.psPagingSuccess").value(DEFAULT_PS_PAGING_SUCCESS))
            .andExpect(jsonPath("$.psPagingSuccessRate").value(DEFAULT_PS_PAGING_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.csPagingRequest").value(DEFAULT_CS_PAGING_REQUEST))
            .andExpect(jsonPath("$.csPagingSuccess").value(DEFAULT_CS_PAGING_SUCCESS))
            .andExpect(jsonPath("$.csPagingSuccessRate").value(DEFAULT_CS_PAGING_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.othereventRequest").value(DEFAULT_OTHEREVENT_REQUEST))
            .andExpect(jsonPath("$.othereventSuccess").value(DEFAULT_OTHEREVENT_SUCCESS))
            .andExpect(jsonPath("$.othereventSuccessRate").value(DEFAULT_OTHEREVENT_SUCCESS_RATE.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingUu() throws Exception {
        // Get the uu
        restUuMockMvc.perform(get("/api/uus/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUu() throws Exception {
        // Initialize the database
        uuRepository.saveAndFlush(uu);
        uuSearchRepository.save(uu);
        int databaseSizeBeforeUpdate = uuRepository.findAll().size();

        // Update the uu
        Uu updatedUu = uuRepository.findOne(uu.getId());
        updatedUu
            .pdate(UPDATED_PDATE)
            .phour(UPDATED_PHOUR)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .rrcConnectRequest(UPDATED_RRC_CONNECT_REQUEST)
            .rrcConnectSuccess(UPDATED_RRC_CONNECT_SUCCESS)
            .rrcConnectSuccessRate(UPDATED_RRC_CONNECT_SUCCESS_RATE)
            .rrcReconfigRequest(UPDATED_RRC_RECONFIG_REQUEST)
            .rrcReconfigSuccess(UPDATED_RRC_RECONFIG_SUCCESS)
            .rrcReconfigSuccessRate(UPDATED_RRC_RECONFIG_SUCCESS_RATE)
            .rrcReconstructionRequest(UPDATED_RRC_RECONSTRUCTION_REQUEST)
            .rrcReconstructionSuccess(UPDATED_RRC_RECONSTRUCTION_SUCCESS)
            .rrcReconstructionSuccessRate(UPDATED_RRC_RECONSTRUCTION_SUCCESS_RATE)
            .rrcReleaseRequest(UPDATED_RRC_RELEASE_REQUEST)
            .rrcReleaseSuccess(UPDATED_RRC_RELEASE_SUCCESS)
            .rrcReleaseSuccessRate(UPDATED_RRC_RELEASE_SUCCESS_RATE)
            .smActivateRequest(UPDATED_SM_ACTIVATE_REQUEST)
            .smActivateSuccess(UPDATED_SM_ACTIVATE_SUCCESS)
            .smActivateSuccessRate(UPDATED_SM_ACTIVATE_SUCCESS_RATE)
            .cellInterHandoverRequest(UPDATED_CELL_INTER_HANDOVER_REQUEST)
            .cellInterHandoverSuccess(UPDATED_CELL_INTER_HANDOVER_SUCCESS)
            .cellInterHandoverSuccessRate(UPDATED_CELL_INTER_HANDOVER_SUCCESS_RATE)
            .stationIntraHandoverRequest(UPDATED_STATION_INTRA_HANDOVER_REQUEST)
            .stationIntraHandoverSuccess(UPDATED_STATION_INTRA_HANDOVER_SUCCESS)
            .stationIntraHandoverSuccessRate(UPDATED_STATION_INTRA_HANDOVER_SUCCESS_RATE)
            .stationInterHandoverRequest(UPDATED_STATION_INTER_HANDOVER_REQUEST)
            .stationInterHandoverSuccess(UPDATED_STATION_INTER_HANDOVER_SUCCESS)
            .stationInterHandoverSuccessRate(UPDATED_STATION_INTER_HANDOVER_SUCCESS_RATE)
            .ratInRequest(UPDATED_RAT_IN_REQUEST)
            .ratInSuccess(UPDATED_RAT_IN_SUCCESS)
            .ratInSuccessRate(UPDATED_RAT_IN_SUCCESS_RATE)
            .ratOutRequest(UPDATED_RAT_OUT_REQUEST)
            .ratOutSuccess(UPDATED_RAT_OUT_SUCCESS)
            .ratOutSuccessRate(UPDATED_RAT_OUT_SUCCESS_RATE)
            .psPagingRequest(UPDATED_PS_PAGING_REQUEST)
            .psPagingSuccess(UPDATED_PS_PAGING_SUCCESS)
            .psPagingSuccessRate(UPDATED_PS_PAGING_SUCCESS_RATE)
            .csPagingRequest(UPDATED_CS_PAGING_REQUEST)
            .csPagingSuccess(UPDATED_CS_PAGING_SUCCESS)
            .csPagingSuccessRate(UPDATED_CS_PAGING_SUCCESS_RATE)
            .othereventRequest(UPDATED_OTHEREVENT_REQUEST)
            .othereventSuccess(UPDATED_OTHEREVENT_SUCCESS)
            .othereventSuccessRate(UPDATED_OTHEREVENT_SUCCESS_RATE);
        UuDTO uuDTO = uuMapper.toDto(updatedUu);

        restUuMockMvc.perform(put("/api/uus")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uuDTO)))
            .andExpect(status().isOk());

        // Validate the Uu in the database
        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeUpdate);
        Uu testUu = uuList.get(uuList.size() - 1);
        assertThat(testUu.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testUu.getPhour()).isEqualTo(UPDATED_PHOUR);
        assertThat(testUu.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testUu.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testUu.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testUu.getRrcConnectRequest()).isEqualTo(UPDATED_RRC_CONNECT_REQUEST);
        assertThat(testUu.getRrcConnectSuccess()).isEqualTo(UPDATED_RRC_CONNECT_SUCCESS);
        assertThat(testUu.getRrcConnectSuccessRate()).isEqualTo(UPDATED_RRC_CONNECT_SUCCESS_RATE);
        assertThat(testUu.getRrcReconfigRequest()).isEqualTo(UPDATED_RRC_RECONFIG_REQUEST);
        assertThat(testUu.getRrcReconfigSuccess()).isEqualTo(UPDATED_RRC_RECONFIG_SUCCESS);
        assertThat(testUu.getRrcReconfigSuccessRate()).isEqualTo(UPDATED_RRC_RECONFIG_SUCCESS_RATE);
        assertThat(testUu.getRrcReconstructionRequest()).isEqualTo(UPDATED_RRC_RECONSTRUCTION_REQUEST);
        assertThat(testUu.getRrcReconstructionSuccess()).isEqualTo(UPDATED_RRC_RECONSTRUCTION_SUCCESS);
        assertThat(testUu.getRrcReconstructionSuccessRate()).isEqualTo(UPDATED_RRC_RECONSTRUCTION_SUCCESS_RATE);
        assertThat(testUu.getRrcReleaseRequest()).isEqualTo(UPDATED_RRC_RELEASE_REQUEST);
        assertThat(testUu.getRrcReleaseSuccess()).isEqualTo(UPDATED_RRC_RELEASE_SUCCESS);
        assertThat(testUu.getRrcReleaseSuccessRate()).isEqualTo(UPDATED_RRC_RELEASE_SUCCESS_RATE);
        assertThat(testUu.getSmActivateRequest()).isEqualTo(UPDATED_SM_ACTIVATE_REQUEST);
        assertThat(testUu.getSmActivateSuccess()).isEqualTo(UPDATED_SM_ACTIVATE_SUCCESS);
        assertThat(testUu.getSmActivateSuccessRate()).isEqualTo(UPDATED_SM_ACTIVATE_SUCCESS_RATE);
        assertThat(testUu.getCellInterHandoverRequest()).isEqualTo(UPDATED_CELL_INTER_HANDOVER_REQUEST);
        assertThat(testUu.getCellInterHandoverSuccess()).isEqualTo(UPDATED_CELL_INTER_HANDOVER_SUCCESS);
        assertThat(testUu.getCellInterHandoverSuccessRate()).isEqualTo(UPDATED_CELL_INTER_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getStationIntraHandoverRequest()).isEqualTo(UPDATED_STATION_INTRA_HANDOVER_REQUEST);
        assertThat(testUu.getStationIntraHandoverSuccess()).isEqualTo(UPDATED_STATION_INTRA_HANDOVER_SUCCESS);
        assertThat(testUu.getStationIntraHandoverSuccessRate()).isEqualTo(UPDATED_STATION_INTRA_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getStationInterHandoverRequest()).isEqualTo(UPDATED_STATION_INTER_HANDOVER_REQUEST);
        assertThat(testUu.getStationInterHandoverSuccess()).isEqualTo(UPDATED_STATION_INTER_HANDOVER_SUCCESS);
        assertThat(testUu.getStationInterHandoverSuccessRate()).isEqualTo(UPDATED_STATION_INTER_HANDOVER_SUCCESS_RATE);
        assertThat(testUu.getRatInRequest()).isEqualTo(UPDATED_RAT_IN_REQUEST);
        assertThat(testUu.getRatInSuccess()).isEqualTo(UPDATED_RAT_IN_SUCCESS);
        assertThat(testUu.getRatInSuccessRate()).isEqualTo(UPDATED_RAT_IN_SUCCESS_RATE);
        assertThat(testUu.getRatOutRequest()).isEqualTo(UPDATED_RAT_OUT_REQUEST);
        assertThat(testUu.getRatOutSuccess()).isEqualTo(UPDATED_RAT_OUT_SUCCESS);
        assertThat(testUu.getRatOutSuccessRate()).isEqualTo(UPDATED_RAT_OUT_SUCCESS_RATE);
        assertThat(testUu.getPsPagingRequest()).isEqualTo(UPDATED_PS_PAGING_REQUEST);
        assertThat(testUu.getPsPagingSuccess()).isEqualTo(UPDATED_PS_PAGING_SUCCESS);
        assertThat(testUu.getPsPagingSuccessRate()).isEqualTo(UPDATED_PS_PAGING_SUCCESS_RATE);
        assertThat(testUu.getCsPagingRequest()).isEqualTo(UPDATED_CS_PAGING_REQUEST);
        assertThat(testUu.getCsPagingSuccess()).isEqualTo(UPDATED_CS_PAGING_SUCCESS);
        assertThat(testUu.getCsPagingSuccessRate()).isEqualTo(UPDATED_CS_PAGING_SUCCESS_RATE);
        assertThat(testUu.getOthereventRequest()).isEqualTo(UPDATED_OTHEREVENT_REQUEST);
        assertThat(testUu.getOthereventSuccess()).isEqualTo(UPDATED_OTHEREVENT_SUCCESS);
        assertThat(testUu.getOthereventSuccessRate()).isEqualTo(UPDATED_OTHEREVENT_SUCCESS_RATE);

        // Validate the Uu in Elasticsearch
        Uu uuEs = uuSearchRepository.findOne(testUu.getId());
        assertThat(uuEs).isEqualToComparingFieldByField(testUu);
    }

    @Test
    @Transactional
    public void updateNonExistingUu() throws Exception {
        int databaseSizeBeforeUpdate = uuRepository.findAll().size();

        // Create the Uu
        UuDTO uuDTO = uuMapper.toDto(uu);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restUuMockMvc.perform(put("/api/uus")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(uuDTO)))
            .andExpect(status().isCreated());

        // Validate the Uu in the database
        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteUu() throws Exception {
        // Initialize the database
        uuRepository.saveAndFlush(uu);
        uuSearchRepository.save(uu);
        int databaseSizeBeforeDelete = uuRepository.findAll().size();

        // Get the uu
        restUuMockMvc.perform(delete("/api/uus/{id}", uu.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean uuExistsInEs = uuSearchRepository.exists(uu.getId());
        assertThat(uuExistsInEs).isFalse();

        // Validate the database is empty
        List<Uu> uuList = uuRepository.findAll();
        assertThat(uuList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchUu() throws Exception {
        // Initialize the database
        uuRepository.saveAndFlush(uu);
        uuSearchRepository.save(uu);

        // Search the uu
        restUuMockMvc.perform(get("/api/_search/uus?query=id:" + uu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(uu.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].rrcConnectRequest").value(hasItem(DEFAULT_RRC_CONNECT_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcConnectSuccess").value(hasItem(DEFAULT_RRC_CONNECT_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcConnectSuccessRate").value(hasItem(DEFAULT_RRC_CONNECT_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReconfigRequest").value(hasItem(DEFAULT_RRC_RECONFIG_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReconfigSuccess").value(hasItem(DEFAULT_RRC_RECONFIG_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReconfigSuccessRate").value(hasItem(DEFAULT_RRC_RECONFIG_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReconstructionRequest").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReconstructionSuccess").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReconstructionSuccessRate").value(hasItem(DEFAULT_RRC_RECONSTRUCTION_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].rrcReleaseRequest").value(hasItem(DEFAULT_RRC_RELEASE_REQUEST)))
            .andExpect(jsonPath("$.[*].rrcReleaseSuccess").value(hasItem(DEFAULT_RRC_RELEASE_SUCCESS)))
            .andExpect(jsonPath("$.[*].rrcReleaseSuccessRate").value(hasItem(DEFAULT_RRC_RELEASE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].smActivateRequest").value(hasItem(DEFAULT_SM_ACTIVATE_REQUEST)))
            .andExpect(jsonPath("$.[*].smActivateSuccess").value(hasItem(DEFAULT_SM_ACTIVATE_SUCCESS)))
            .andExpect(jsonPath("$.[*].smActivateSuccessRate").value(hasItem(DEFAULT_SM_ACTIVATE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].cellInterHandoverRequest").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].cellInterHandoverSuccess").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].cellInterHandoverSuccessRate").value(hasItem(DEFAULT_CELL_INTER_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].stationIntraHandoverRequest").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].stationIntraHandoverSuccess").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].stationIntraHandoverSuccessRate").value(hasItem(DEFAULT_STATION_INTRA_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].stationInterHandoverRequest").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_REQUEST)))
            .andExpect(jsonPath("$.[*].stationInterHandoverSuccess").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_SUCCESS)))
            .andExpect(jsonPath("$.[*].stationInterHandoverSuccessRate").value(hasItem(DEFAULT_STATION_INTER_HANDOVER_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].ratInRequest").value(hasItem(DEFAULT_RAT_IN_REQUEST)))
            .andExpect(jsonPath("$.[*].ratInSuccess").value(hasItem(DEFAULT_RAT_IN_SUCCESS)))
            .andExpect(jsonPath("$.[*].ratInSuccessRate").value(hasItem(DEFAULT_RAT_IN_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].ratOutRequest").value(hasItem(DEFAULT_RAT_OUT_REQUEST)))
            .andExpect(jsonPath("$.[*].ratOutSuccess").value(hasItem(DEFAULT_RAT_OUT_SUCCESS)))
            .andExpect(jsonPath("$.[*].ratOutSuccessRate").value(hasItem(DEFAULT_RAT_OUT_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].psPagingRequest").value(hasItem(DEFAULT_PS_PAGING_REQUEST)))
            .andExpect(jsonPath("$.[*].psPagingSuccess").value(hasItem(DEFAULT_PS_PAGING_SUCCESS)))
            .andExpect(jsonPath("$.[*].psPagingSuccessRate").value(hasItem(DEFAULT_PS_PAGING_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].csPagingRequest").value(hasItem(DEFAULT_CS_PAGING_REQUEST)))
            .andExpect(jsonPath("$.[*].csPagingSuccess").value(hasItem(DEFAULT_CS_PAGING_SUCCESS)))
            .andExpect(jsonPath("$.[*].csPagingSuccessRate").value(hasItem(DEFAULT_CS_PAGING_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].othereventRequest").value(hasItem(DEFAULT_OTHEREVENT_REQUEST)))
            .andExpect(jsonPath("$.[*].othereventSuccess").value(hasItem(DEFAULT_OTHEREVENT_SUCCESS)))
            .andExpect(jsonPath("$.[*].othereventSuccessRate").value(hasItem(DEFAULT_OTHEREVENT_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Uu.class);
        Uu uu1 = new Uu();
        uu1.setId(1L);
        Uu uu2 = new Uu();
        uu2.setId(uu1.getId());
        assertThat(uu1).isEqualTo(uu2);
        uu2.setId(2L);
        assertThat(uu1).isNotEqualTo(uu2);
        uu1.setId(null);
        assertThat(uu1).isNotEqualTo(uu2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UuDTO.class);
        UuDTO uuDTO1 = new UuDTO();
        uuDTO1.setId(1L);
        UuDTO uuDTO2 = new UuDTO();
        assertThat(uuDTO1).isNotEqualTo(uuDTO2);
        uuDTO2.setId(uuDTO1.getId());
        assertThat(uuDTO1).isEqualTo(uuDTO2);
        uuDTO2.setId(2L);
        assertThat(uuDTO1).isNotEqualTo(uuDTO2);
        uuDTO1.setId(null);
        assertThat(uuDTO1).isNotEqualTo(uuDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(uuMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(uuMapper.fromId(null)).isNull();
    }
}
