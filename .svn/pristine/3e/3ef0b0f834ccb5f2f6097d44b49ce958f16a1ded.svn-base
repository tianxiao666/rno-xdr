package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.ExceptionCause;
import com.hgicreate.rno.xdr.backend.repository.ExceptionCauseRepository;
import com.hgicreate.rno.xdr.backend.service.ExceptionCauseService;
import com.hgicreate.rno.xdr.backend.repository.search.ExceptionCauseSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionCauseDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.ExceptionCauseMapper;
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
 * Test class for the ExceptionCauseResource REST controller.
 *
 * @see ExceptionCauseResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class ExceptionCauseResourceIntTest {

    private static final LocalDate DEFAULT_PDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_CELL = 1L;
    private static final Long UPDATED_CELL = 2L;

    private static final Long DEFAULT_IMEI = 1L;
    private static final Long UPDATED_IMEI = 2L;

    private static final Long DEFAULT_IMSI = 1L;
    private static final Long UPDATED_IMSI = 2L;

    private static final String DEFAULT_INDICATOR_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CAUSE = 1;
    private static final Integer UPDATED_CAUSE = 2;

    private static final Integer DEFAULT_CAUSE_COUNT = 1;
    private static final Integer UPDATED_CAUSE_COUNT = 2;

    @Autowired
    private ExceptionCauseRepository exceptionCauseRepository;

    @Autowired
    private ExceptionCauseMapper exceptionCauseMapper;

    @Autowired
    private ExceptionCauseService exceptionCauseService;

    @Autowired
    private ExceptionCauseSearchRepository exceptionCauseSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restExceptionCauseMockMvc;

    private ExceptionCause exceptionCause;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ExceptionCauseResource exceptionCauseResource = new ExceptionCauseResource(exceptionCauseService);
        this.restExceptionCauseMockMvc = MockMvcBuilders.standaloneSetup(exceptionCauseResource)
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
    public static ExceptionCause createEntity(EntityManager em) {
        ExceptionCause exceptionCause = new ExceptionCause()
            .pdate(DEFAULT_PDATE)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .indicatorType(DEFAULT_INDICATOR_TYPE)
            .cause(DEFAULT_CAUSE)
            .causeCount(DEFAULT_CAUSE_COUNT);
        return exceptionCause;
    }

    @Before
    public void initTest() {
        exceptionCauseSearchRepository.deleteAll();
        exceptionCause = createEntity(em);
    }

    @Test
    @Transactional
    public void createExceptionCause() throws Exception {
        int databaseSizeBeforeCreate = exceptionCauseRepository.findAll().size();

        // Create the ExceptionCause
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseMapper.toDto(exceptionCause);
        restExceptionCauseMockMvc.perform(post("/api/exception-causes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionCauseDTO)))
            .andExpect(status().isCreated());

        // Validate the ExceptionCause in the database
        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeCreate + 1);
        ExceptionCause testExceptionCause = exceptionCauseList.get(exceptionCauseList.size() - 1);
        assertThat(testExceptionCause.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testExceptionCause.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testExceptionCause.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testExceptionCause.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testExceptionCause.getIndicatorType()).isEqualTo(DEFAULT_INDICATOR_TYPE);
        assertThat(testExceptionCause.getCause()).isEqualTo(DEFAULT_CAUSE);
        assertThat(testExceptionCause.getCauseCount()).isEqualTo(DEFAULT_CAUSE_COUNT);

        // Validate the ExceptionCause in Elasticsearch
        ExceptionCause exceptionCauseEs = exceptionCauseSearchRepository.findOne(testExceptionCause.getId());
        assertThat(exceptionCauseEs).isEqualToComparingFieldByField(testExceptionCause);
    }

    @Test
    @Transactional
    public void createExceptionCauseWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = exceptionCauseRepository.findAll().size();

        // Create the ExceptionCause with an existing ID
        exceptionCause.setId(1L);
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseMapper.toDto(exceptionCause);

        // An entity with an existing ID cannot be created, so this API call must fail
        restExceptionCauseMockMvc.perform(post("/api/exception-causes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionCauseDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = exceptionCauseRepository.findAll().size();
        // set the field null
        exceptionCause.setPdate(null);

        // Create the ExceptionCause, which fails.
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseMapper.toDto(exceptionCause);

        restExceptionCauseMockMvc.perform(post("/api/exception-causes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionCauseDTO)))
            .andExpect(status().isBadRequest());

        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllExceptionCauses() throws Exception {
        // Initialize the database
        exceptionCauseRepository.saveAndFlush(exceptionCause);

        // Get all the exceptionCauseList
        restExceptionCauseMockMvc.perform(get("/api/exception-causes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exceptionCause.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].indicatorType").value(hasItem(DEFAULT_INDICATOR_TYPE.toString())))
            .andExpect(jsonPath("$.[*].cause").value(hasItem(DEFAULT_CAUSE)))
            .andExpect(jsonPath("$.[*].causeCount").value(hasItem(DEFAULT_CAUSE_COUNT)));
    }

    @Test
    @Transactional
    public void getExceptionCause() throws Exception {
        // Initialize the database
        exceptionCauseRepository.saveAndFlush(exceptionCause);

        // Get the exceptionCause
        restExceptionCauseMockMvc.perform(get("/api/exception-causes/{id}", exceptionCause.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(exceptionCause.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.intValue()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.intValue()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.intValue()))
            .andExpect(jsonPath("$.indicatorType").value(DEFAULT_INDICATOR_TYPE.toString()))
            .andExpect(jsonPath("$.cause").value(DEFAULT_CAUSE))
            .andExpect(jsonPath("$.causeCount").value(DEFAULT_CAUSE_COUNT));
    }

    @Test
    @Transactional
    public void getNonExistingExceptionCause() throws Exception {
        // Get the exceptionCause
        restExceptionCauseMockMvc.perform(get("/api/exception-causes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateExceptionCause() throws Exception {
        // Initialize the database
        exceptionCauseRepository.saveAndFlush(exceptionCause);
        exceptionCauseSearchRepository.save(exceptionCause);
        int databaseSizeBeforeUpdate = exceptionCauseRepository.findAll().size();

        // Update the exceptionCause
        ExceptionCause updatedExceptionCause = exceptionCauseRepository.findOne(exceptionCause.getId());
        updatedExceptionCause
            .pdate(UPDATED_PDATE)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .indicatorType(UPDATED_INDICATOR_TYPE)
            .cause(UPDATED_CAUSE)
            .causeCount(UPDATED_CAUSE_COUNT);
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseMapper.toDto(updatedExceptionCause);

        restExceptionCauseMockMvc.perform(put("/api/exception-causes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionCauseDTO)))
            .andExpect(status().isOk());

        // Validate the ExceptionCause in the database
        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeUpdate);
        ExceptionCause testExceptionCause = exceptionCauseList.get(exceptionCauseList.size() - 1);
        assertThat(testExceptionCause.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testExceptionCause.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testExceptionCause.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testExceptionCause.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testExceptionCause.getIndicatorType()).isEqualTo(UPDATED_INDICATOR_TYPE);
        assertThat(testExceptionCause.getCause()).isEqualTo(UPDATED_CAUSE);
        assertThat(testExceptionCause.getCauseCount()).isEqualTo(UPDATED_CAUSE_COUNT);

        // Validate the ExceptionCause in Elasticsearch
        ExceptionCause exceptionCauseEs = exceptionCauseSearchRepository.findOne(testExceptionCause.getId());
        assertThat(exceptionCauseEs).isEqualToComparingFieldByField(testExceptionCause);
    }

    @Test
    @Transactional
    public void updateNonExistingExceptionCause() throws Exception {
        int databaseSizeBeforeUpdate = exceptionCauseRepository.findAll().size();

        // Create the ExceptionCause
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseMapper.toDto(exceptionCause);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restExceptionCauseMockMvc.perform(put("/api/exception-causes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(exceptionCauseDTO)))
            .andExpect(status().isCreated());

        // Validate the ExceptionCause in the database
        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteExceptionCause() throws Exception {
        // Initialize the database
        exceptionCauseRepository.saveAndFlush(exceptionCause);
        exceptionCauseSearchRepository.save(exceptionCause);
        int databaseSizeBeforeDelete = exceptionCauseRepository.findAll().size();

        // Get the exceptionCause
        restExceptionCauseMockMvc.perform(delete("/api/exception-causes/{id}", exceptionCause.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean exceptionCauseExistsInEs = exceptionCauseSearchRepository.exists(exceptionCause.getId());
        assertThat(exceptionCauseExistsInEs).isFalse();

        // Validate the database is empty
        List<ExceptionCause> exceptionCauseList = exceptionCauseRepository.findAll();
        assertThat(exceptionCauseList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchExceptionCause() throws Exception {
        // Initialize the database
        exceptionCauseRepository.saveAndFlush(exceptionCause);
        exceptionCauseSearchRepository.save(exceptionCause);

        // Search the exceptionCause
        restExceptionCauseMockMvc.perform(get("/api/_search/exception-causes?query=id:" + exceptionCause.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(exceptionCause.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].indicatorType").value(hasItem(DEFAULT_INDICATOR_TYPE.toString())))
            .andExpect(jsonPath("$.[*].cause").value(hasItem(DEFAULT_CAUSE)))
            .andExpect(jsonPath("$.[*].causeCount").value(hasItem(DEFAULT_CAUSE_COUNT)));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ExceptionCause.class);
        ExceptionCause exceptionCause1 = new ExceptionCause();
        exceptionCause1.setId(1L);
        ExceptionCause exceptionCause2 = new ExceptionCause();
        exceptionCause2.setId(exceptionCause1.getId());
        assertThat(exceptionCause1).isEqualTo(exceptionCause2);
        exceptionCause2.setId(2L);
        assertThat(exceptionCause1).isNotEqualTo(exceptionCause2);
        exceptionCause1.setId(null);
        assertThat(exceptionCause1).isNotEqualTo(exceptionCause2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ExceptionCauseDTO.class);
        ExceptionCauseDTO exceptionCauseDTO1 = new ExceptionCauseDTO();
        exceptionCauseDTO1.setId(1L);
        ExceptionCauseDTO exceptionCauseDTO2 = new ExceptionCauseDTO();
        assertThat(exceptionCauseDTO1).isNotEqualTo(exceptionCauseDTO2);
        exceptionCauseDTO2.setId(exceptionCauseDTO1.getId());
        assertThat(exceptionCauseDTO1).isEqualTo(exceptionCauseDTO2);
        exceptionCauseDTO2.setId(2L);
        assertThat(exceptionCauseDTO1).isNotEqualTo(exceptionCauseDTO2);
        exceptionCauseDTO1.setId(null);
        assertThat(exceptionCauseDTO1).isNotEqualTo(exceptionCauseDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(exceptionCauseMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(exceptionCauseMapper.fromId(null)).isNull();
    }
}
