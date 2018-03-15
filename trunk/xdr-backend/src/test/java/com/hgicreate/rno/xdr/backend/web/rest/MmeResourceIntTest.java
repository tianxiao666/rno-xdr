package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Mme;
import com.hgicreate.rno.xdr.backend.repository.MmeRepository;
import com.hgicreate.rno.xdr.backend.service.MmeService;
import com.hgicreate.rno.xdr.backend.repository.search.MmeSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.MmeDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.MmeMapper;
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
 * Test class for the MmeResource REST controller.
 *
 * @see MmeResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class MmeResourceIntTest {

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

    private static final Long DEFAULT_ATTACH_REQUEST = 1L;
    private static final Long UPDATED_ATTACH_REQUEST = 2L;

    private static final Long DEFAULT_ATTACH_SUCCESS = 1L;
    private static final Long UPDATED_ATTACH_SUCCESS = 2L;

    private static final Double DEFAULT_ATTACH_SUCCESS_RATE = 1D;
    private static final Double UPDATED_ATTACH_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_SERVICE_REQUEST = 1L;
    private static final Long UPDATED_SERVICE_REQUEST = 2L;

    private static final Long DEFAULT_SERVICE_REQUEST_SUCCESS = 1L;
    private static final Long UPDATED_SERVICE_REQUEST_SUCCESS = 2L;

    private static final Double DEFAULT_SERVICE_SUCCESS_RATE = 1D;
    private static final Double UPDATED_SERVICE_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST = 1L;
    private static final Long UPDATED_DEFAULT_BEARER_ACTIVATE_REQUEST = 2L;

    private static final Long DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS = 1L;
    private static final Long UPDATED_DEFAULT_BEARER_ACTIVATE_SUCCESS = 2L;

    private static final Double DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE = 1D;
    private static final Double UPDATED_DEFAULT_BEARER_SETUP_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_PDN_REQUEST = 1L;
    private static final Long UPDATED_PDN_REQUEST = 2L;

    private static final Long DEFAULT_PDN_REQUEST_SUCCESS = 1L;
    private static final Long UPDATED_PDN_REQUEST_SUCCESS = 2L;

    private static final Double DEFAULT_PDN_REQUEST_SUCCESS_RATE = 1D;
    private static final Double UPDATED_PDN_REQUEST_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_TAU_REQUEST = 1L;
    private static final Long UPDATED_TAU_REQUEST = 2L;

    private static final Long DEFAULT_TAU_SUCCESS = 1L;
    private static final Long UPDATED_TAU_SUCCESS = 2L;

    private static final Double DEFAULT_TAU_SUCCESS_RATE = 1D;
    private static final Double UPDATED_TAU_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_XHO_REQUEST = 1L;
    private static final Long UPDATED_XHO_REQUEST = 2L;

    private static final Long DEFAULT_XHO_SUCCESS = 1L;
    private static final Long UPDATED_XHO_SUCCESS = 2L;

    private static final Double DEFAULT_XHO_SUCCESS_RATE = 1D;
    private static final Double UPDATED_XHO_SUCCESS_RATE = 2D;

    private static final Long DEFAULT_SHO_REQUEST = 1L;
    private static final Long UPDATED_SHO_REQUEST = 2L;

    private static final Long DEFAULT_SHO_SUCCESS = 1L;
    private static final Long UPDATED_SHO_SUCCESS = 2L;

    private static final Double DEFAULT_SHO_SUCCESS_RATE = 1D;
    private static final Double UPDATED_SHO_SUCCESS_RATE = 2D;

    @Autowired
    private MmeRepository mmeRepository;

    @Autowired
    private MmeMapper mmeMapper;

    @Autowired
    private MmeService mmeService;

    @Autowired
    private MmeSearchRepository mmeSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restMmeMockMvc;

    private Mme mme;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        MmeResource mmeResource = new MmeResource(mmeService);
        this.restMmeMockMvc = MockMvcBuilders.standaloneSetup(mmeResource)
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
    public static Mme createEntity(EntityManager em) {
        Mme mme = new Mme()
            .pdate(DEFAULT_PDATE)
            .phour(DEFAULT_PHOUR)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .attachRequest(DEFAULT_ATTACH_REQUEST)
            .attachSuccess(DEFAULT_ATTACH_SUCCESS)
            .attachSuccessRate(DEFAULT_ATTACH_SUCCESS_RATE)
            .serviceRequest(DEFAULT_SERVICE_REQUEST)
            .serviceRequestSuccess(DEFAULT_SERVICE_REQUEST_SUCCESS)
            .serviceSuccessRate(DEFAULT_SERVICE_SUCCESS_RATE)
            .defaultBearerActivateRequest(DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST)
            .defaultBearerActivateSuccess(DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS)
            .defaultBearerSetupSuccessRate(DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE)
            .pdnRequest(DEFAULT_PDN_REQUEST)
            .pdnRequestSuccess(DEFAULT_PDN_REQUEST_SUCCESS)
            .pdnRequestSuccessRate(DEFAULT_PDN_REQUEST_SUCCESS_RATE)
            .tauRequest(DEFAULT_TAU_REQUEST)
            .tauSuccess(DEFAULT_TAU_SUCCESS)
            .tauSuccessRate(DEFAULT_TAU_SUCCESS_RATE)
            .xhoRequest(DEFAULT_XHO_REQUEST)
            .xhoSuccess(DEFAULT_XHO_SUCCESS)
            .xhoSuccessRate(DEFAULT_XHO_SUCCESS_RATE)
            .shoRequest(DEFAULT_SHO_REQUEST)
            .shoSuccess(DEFAULT_SHO_SUCCESS)
            .shoSuccessRate(DEFAULT_SHO_SUCCESS_RATE);
        return mme;
    }

    @Before
    public void initTest() {
        mmeSearchRepository.deleteAll();
        mme = createEntity(em);
    }

    @Test
    @Transactional
    public void createMme() throws Exception {
        int databaseSizeBeforeCreate = mmeRepository.findAll().size();

        // Create the Mme
        MmeDTO mmeDTO = mmeMapper.toDto(mme);
        restMmeMockMvc.perform(post("/api/mmes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mmeDTO)))
            .andExpect(status().isCreated());

        // Validate the Mme in the database
        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeCreate + 1);
        Mme testMme = mmeList.get(mmeList.size() - 1);
        assertThat(testMme.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testMme.getPhour()).isEqualTo(DEFAULT_PHOUR);
        assertThat(testMme.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testMme.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testMme.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testMme.getAttachRequest()).isEqualTo(DEFAULT_ATTACH_REQUEST);
        assertThat(testMme.getAttachSuccess()).isEqualTo(DEFAULT_ATTACH_SUCCESS);
        assertThat(testMme.getAttachSuccessRate()).isEqualTo(DEFAULT_ATTACH_SUCCESS_RATE);
        assertThat(testMme.getServiceRequest()).isEqualTo(DEFAULT_SERVICE_REQUEST);
        assertThat(testMme.getServiceRequestSuccess()).isEqualTo(DEFAULT_SERVICE_REQUEST_SUCCESS);
        assertThat(testMme.getServiceSuccessRate()).isEqualTo(DEFAULT_SERVICE_SUCCESS_RATE);
        assertThat(testMme.getDefaultBearerActivateRequest()).isEqualTo(DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST);
        assertThat(testMme.getDefaultBearerActivateSuccess()).isEqualTo(DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS);
        assertThat(testMme.getDefaultBearerSetupSuccessRate()).isEqualTo(DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE);
        assertThat(testMme.getPdnRequest()).isEqualTo(DEFAULT_PDN_REQUEST);
        assertThat(testMme.getPdnRequestSuccess()).isEqualTo(DEFAULT_PDN_REQUEST_SUCCESS);
        assertThat(testMme.getPdnRequestSuccessRate()).isEqualTo(DEFAULT_PDN_REQUEST_SUCCESS_RATE);
        assertThat(testMme.getTauRequest()).isEqualTo(DEFAULT_TAU_REQUEST);
        assertThat(testMme.getTauSuccess()).isEqualTo(DEFAULT_TAU_SUCCESS);
        assertThat(testMme.getTauSuccessRate()).isEqualTo(DEFAULT_TAU_SUCCESS_RATE);
        assertThat(testMme.getXhoRequest()).isEqualTo(DEFAULT_XHO_REQUEST);
        assertThat(testMme.getXhoSuccess()).isEqualTo(DEFAULT_XHO_SUCCESS);
        assertThat(testMme.getXhoSuccessRate()).isEqualTo(DEFAULT_XHO_SUCCESS_RATE);
        assertThat(testMme.getShoRequest()).isEqualTo(DEFAULT_SHO_REQUEST);
        assertThat(testMme.getShoSuccess()).isEqualTo(DEFAULT_SHO_SUCCESS);
        assertThat(testMme.getShoSuccessRate()).isEqualTo(DEFAULT_SHO_SUCCESS_RATE);

        // Validate the Mme in Elasticsearch
        Mme mmeEs = mmeSearchRepository.findOne(testMme.getId());
        assertThat(mmeEs).isEqualToComparingFieldByField(testMme);
    }

    @Test
    @Transactional
    public void createMmeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = mmeRepository.findAll().size();

        // Create the Mme with an existing ID
        mme.setId(1L);
        MmeDTO mmeDTO = mmeMapper.toDto(mme);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMmeMockMvc.perform(post("/api/mmes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mmeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = mmeRepository.findAll().size();
        // set the field null
        mme.setPdate(null);

        // Create the Mme, which fails.
        MmeDTO mmeDTO = mmeMapper.toDto(mme);

        restMmeMockMvc.perform(post("/api/mmes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mmeDTO)))
            .andExpect(status().isBadRequest());

        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMmes() throws Exception {
        // Initialize the database
        mmeRepository.saveAndFlush(mme);

        // Get all the mmeList
        restMmeMockMvc.perform(get("/api/mmes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mme.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].attachRequest").value(hasItem(DEFAULT_ATTACH_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].attachSuccess").value(hasItem(DEFAULT_ATTACH_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].attachSuccessRate").value(hasItem(DEFAULT_ATTACH_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].serviceRequestSuccess").value(hasItem(DEFAULT_SERVICE_REQUEST_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].serviceSuccessRate").value(hasItem(DEFAULT_SERVICE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].defaultBearerActivateRequest").value(hasItem(DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].defaultBearerActivateSuccess").value(hasItem(DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].defaultBearerSetupSuccessRate").value(hasItem(DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].pdnRequest").value(hasItem(DEFAULT_PDN_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].pdnRequestSuccess").value(hasItem(DEFAULT_PDN_REQUEST_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].pdnRequestSuccessRate").value(hasItem(DEFAULT_PDN_REQUEST_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tauRequest").value(hasItem(DEFAULT_TAU_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].tauSuccess").value(hasItem(DEFAULT_TAU_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].tauSuccessRate").value(hasItem(DEFAULT_TAU_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xhoRequest").value(hasItem(DEFAULT_XHO_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].xhoSuccess").value(hasItem(DEFAULT_XHO_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].xhoSuccessRate").value(hasItem(DEFAULT_XHO_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].shoRequest").value(hasItem(DEFAULT_SHO_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].shoSuccess").value(hasItem(DEFAULT_SHO_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].shoSuccessRate").value(hasItem(DEFAULT_SHO_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void getMme() throws Exception {
        // Initialize the database
        mmeRepository.saveAndFlush(mme);

        // Get the mme
        restMmeMockMvc.perform(get("/api/mmes/{id}", mme.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(mme.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.phour").value(DEFAULT_PHOUR))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.toString()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.toString()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.toString()))
            .andExpect(jsonPath("$.attachRequest").value(DEFAULT_ATTACH_REQUEST.intValue()))
            .andExpect(jsonPath("$.attachSuccess").value(DEFAULT_ATTACH_SUCCESS.intValue()))
            .andExpect(jsonPath("$.attachSuccessRate").value(DEFAULT_ATTACH_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.serviceRequest").value(DEFAULT_SERVICE_REQUEST.intValue()))
            .andExpect(jsonPath("$.serviceRequestSuccess").value(DEFAULT_SERVICE_REQUEST_SUCCESS.intValue()))
            .andExpect(jsonPath("$.serviceSuccessRate").value(DEFAULT_SERVICE_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.defaultBearerActivateRequest").value(DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST.intValue()))
            .andExpect(jsonPath("$.defaultBearerActivateSuccess").value(DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS.intValue()))
            .andExpect(jsonPath("$.defaultBearerSetupSuccessRate").value(DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.pdnRequest").value(DEFAULT_PDN_REQUEST.intValue()))
            .andExpect(jsonPath("$.pdnRequestSuccess").value(DEFAULT_PDN_REQUEST_SUCCESS.intValue()))
            .andExpect(jsonPath("$.pdnRequestSuccessRate").value(DEFAULT_PDN_REQUEST_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.tauRequest").value(DEFAULT_TAU_REQUEST.intValue()))
            .andExpect(jsonPath("$.tauSuccess").value(DEFAULT_TAU_SUCCESS.intValue()))
            .andExpect(jsonPath("$.tauSuccessRate").value(DEFAULT_TAU_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.xhoRequest").value(DEFAULT_XHO_REQUEST.intValue()))
            .andExpect(jsonPath("$.xhoSuccess").value(DEFAULT_XHO_SUCCESS.intValue()))
            .andExpect(jsonPath("$.xhoSuccessRate").value(DEFAULT_XHO_SUCCESS_RATE.doubleValue()))
            .andExpect(jsonPath("$.shoRequest").value(DEFAULT_SHO_REQUEST.intValue()))
            .andExpect(jsonPath("$.shoSuccess").value(DEFAULT_SHO_SUCCESS.intValue()))
            .andExpect(jsonPath("$.shoSuccessRate").value(DEFAULT_SHO_SUCCESS_RATE.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingMme() throws Exception {
        // Get the mme
        restMmeMockMvc.perform(get("/api/mmes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMme() throws Exception {
        // Initialize the database
        mmeRepository.saveAndFlush(mme);
        mmeSearchRepository.save(mme);
        int databaseSizeBeforeUpdate = mmeRepository.findAll().size();

        // Update the mme
        Mme updatedMme = mmeRepository.findOne(mme.getId());
        updatedMme
            .pdate(UPDATED_PDATE)
            .phour(UPDATED_PHOUR)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .attachRequest(UPDATED_ATTACH_REQUEST)
            .attachSuccess(UPDATED_ATTACH_SUCCESS)
            .attachSuccessRate(UPDATED_ATTACH_SUCCESS_RATE)
            .serviceRequest(UPDATED_SERVICE_REQUEST)
            .serviceRequestSuccess(UPDATED_SERVICE_REQUEST_SUCCESS)
            .serviceSuccessRate(UPDATED_SERVICE_SUCCESS_RATE)
            .defaultBearerActivateRequest(UPDATED_DEFAULT_BEARER_ACTIVATE_REQUEST)
            .defaultBearerActivateSuccess(UPDATED_DEFAULT_BEARER_ACTIVATE_SUCCESS)
            .defaultBearerSetupSuccessRate(UPDATED_DEFAULT_BEARER_SETUP_SUCCESS_RATE)
            .pdnRequest(UPDATED_PDN_REQUEST)
            .pdnRequestSuccess(UPDATED_PDN_REQUEST_SUCCESS)
            .pdnRequestSuccessRate(UPDATED_PDN_REQUEST_SUCCESS_RATE)
            .tauRequest(UPDATED_TAU_REQUEST)
            .tauSuccess(UPDATED_TAU_SUCCESS)
            .tauSuccessRate(UPDATED_TAU_SUCCESS_RATE)
            .xhoRequest(UPDATED_XHO_REQUEST)
            .xhoSuccess(UPDATED_XHO_SUCCESS)
            .xhoSuccessRate(UPDATED_XHO_SUCCESS_RATE)
            .shoRequest(UPDATED_SHO_REQUEST)
            .shoSuccess(UPDATED_SHO_SUCCESS)
            .shoSuccessRate(UPDATED_SHO_SUCCESS_RATE);
        MmeDTO mmeDTO = mmeMapper.toDto(updatedMme);

        restMmeMockMvc.perform(put("/api/mmes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mmeDTO)))
            .andExpect(status().isOk());

        // Validate the Mme in the database
        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeUpdate);
        Mme testMme = mmeList.get(mmeList.size() - 1);
        assertThat(testMme.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testMme.getPhour()).isEqualTo(UPDATED_PHOUR);
        assertThat(testMme.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testMme.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testMme.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testMme.getAttachRequest()).isEqualTo(UPDATED_ATTACH_REQUEST);
        assertThat(testMme.getAttachSuccess()).isEqualTo(UPDATED_ATTACH_SUCCESS);
        assertThat(testMme.getAttachSuccessRate()).isEqualTo(UPDATED_ATTACH_SUCCESS_RATE);
        assertThat(testMme.getServiceRequest()).isEqualTo(UPDATED_SERVICE_REQUEST);
        assertThat(testMme.getServiceRequestSuccess()).isEqualTo(UPDATED_SERVICE_REQUEST_SUCCESS);
        assertThat(testMme.getServiceSuccessRate()).isEqualTo(UPDATED_SERVICE_SUCCESS_RATE);
        assertThat(testMme.getDefaultBearerActivateRequest()).isEqualTo(UPDATED_DEFAULT_BEARER_ACTIVATE_REQUEST);
        assertThat(testMme.getDefaultBearerActivateSuccess()).isEqualTo(UPDATED_DEFAULT_BEARER_ACTIVATE_SUCCESS);
        assertThat(testMme.getDefaultBearerSetupSuccessRate()).isEqualTo(UPDATED_DEFAULT_BEARER_SETUP_SUCCESS_RATE);
        assertThat(testMme.getPdnRequest()).isEqualTo(UPDATED_PDN_REQUEST);
        assertThat(testMme.getPdnRequestSuccess()).isEqualTo(UPDATED_PDN_REQUEST_SUCCESS);
        assertThat(testMme.getPdnRequestSuccessRate()).isEqualTo(UPDATED_PDN_REQUEST_SUCCESS_RATE);
        assertThat(testMme.getTauRequest()).isEqualTo(UPDATED_TAU_REQUEST);
        assertThat(testMme.getTauSuccess()).isEqualTo(UPDATED_TAU_SUCCESS);
        assertThat(testMme.getTauSuccessRate()).isEqualTo(UPDATED_TAU_SUCCESS_RATE);
        assertThat(testMme.getXhoRequest()).isEqualTo(UPDATED_XHO_REQUEST);
        assertThat(testMme.getXhoSuccess()).isEqualTo(UPDATED_XHO_SUCCESS);
        assertThat(testMme.getXhoSuccessRate()).isEqualTo(UPDATED_XHO_SUCCESS_RATE);
        assertThat(testMme.getShoRequest()).isEqualTo(UPDATED_SHO_REQUEST);
        assertThat(testMme.getShoSuccess()).isEqualTo(UPDATED_SHO_SUCCESS);
        assertThat(testMme.getShoSuccessRate()).isEqualTo(UPDATED_SHO_SUCCESS_RATE);

        // Validate the Mme in Elasticsearch
        Mme mmeEs = mmeSearchRepository.findOne(testMme.getId());
        assertThat(mmeEs).isEqualToComparingFieldByField(testMme);
    }

    @Test
    @Transactional
    public void updateNonExistingMme() throws Exception {
        int databaseSizeBeforeUpdate = mmeRepository.findAll().size();

        // Create the Mme
        MmeDTO mmeDTO = mmeMapper.toDto(mme);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restMmeMockMvc.perform(put("/api/mmes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(mmeDTO)))
            .andExpect(status().isCreated());

        // Validate the Mme in the database
        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteMme() throws Exception {
        // Initialize the database
        mmeRepository.saveAndFlush(mme);
        mmeSearchRepository.save(mme);
        int databaseSizeBeforeDelete = mmeRepository.findAll().size();

        // Get the mme
        restMmeMockMvc.perform(delete("/api/mmes/{id}", mme.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean mmeExistsInEs = mmeSearchRepository.exists(mme.getId());
        assertThat(mmeExistsInEs).isFalse();

        // Validate the database is empty
        List<Mme> mmeList = mmeRepository.findAll();
        assertThat(mmeList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchMme() throws Exception {
        // Initialize the database
        mmeRepository.saveAndFlush(mme);
        mmeSearchRepository.save(mme);

        // Search the mme
        restMmeMockMvc.perform(get("/api/_search/mmes?query=id:" + mme.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(mme.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].attachRequest").value(hasItem(DEFAULT_ATTACH_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].attachSuccess").value(hasItem(DEFAULT_ATTACH_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].attachSuccessRate").value(hasItem(DEFAULT_ATTACH_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].serviceRequest").value(hasItem(DEFAULT_SERVICE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].serviceRequestSuccess").value(hasItem(DEFAULT_SERVICE_REQUEST_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].serviceSuccessRate").value(hasItem(DEFAULT_SERVICE_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].defaultBearerActivateRequest").value(hasItem(DEFAULT_DEFAULT_BEARER_ACTIVATE_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].defaultBearerActivateSuccess").value(hasItem(DEFAULT_DEFAULT_BEARER_ACTIVATE_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].defaultBearerSetupSuccessRate").value(hasItem(DEFAULT_DEFAULT_BEARER_SETUP_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].pdnRequest").value(hasItem(DEFAULT_PDN_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].pdnRequestSuccess").value(hasItem(DEFAULT_PDN_REQUEST_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].pdnRequestSuccessRate").value(hasItem(DEFAULT_PDN_REQUEST_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].tauRequest").value(hasItem(DEFAULT_TAU_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].tauSuccess").value(hasItem(DEFAULT_TAU_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].tauSuccessRate").value(hasItem(DEFAULT_TAU_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].xhoRequest").value(hasItem(DEFAULT_XHO_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].xhoSuccess").value(hasItem(DEFAULT_XHO_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].xhoSuccessRate").value(hasItem(DEFAULT_XHO_SUCCESS_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].shoRequest").value(hasItem(DEFAULT_SHO_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].shoSuccess").value(hasItem(DEFAULT_SHO_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].shoSuccessRate").value(hasItem(DEFAULT_SHO_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Mme.class);
        Mme mme1 = new Mme();
        mme1.setId(1L);
        Mme mme2 = new Mme();
        mme2.setId(mme1.getId());
        assertThat(mme1).isEqualTo(mme2);
        mme2.setId(2L);
        assertThat(mme1).isNotEqualTo(mme2);
        mme1.setId(null);
        assertThat(mme1).isNotEqualTo(mme2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MmeDTO.class);
        MmeDTO mmeDTO1 = new MmeDTO();
        mmeDTO1.setId(1L);
        MmeDTO mmeDTO2 = new MmeDTO();
        assertThat(mmeDTO1).isNotEqualTo(mmeDTO2);
        mmeDTO2.setId(mmeDTO1.getId());
        assertThat(mmeDTO1).isEqualTo(mmeDTO2);
        mmeDTO2.setId(2L);
        assertThat(mmeDTO1).isNotEqualTo(mmeDTO2);
        mmeDTO1.setId(null);
        assertThat(mmeDTO1).isNotEqualTo(mmeDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(mmeMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(mmeMapper.fromId(null)).isNull();
    }
}
