package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.X2;
import com.hgicreate.rno.xdr.backend.repository.X2Repository;
import com.hgicreate.rno.xdr.backend.service.X2Service;
import com.hgicreate.rno.xdr.backend.repository.search.X2SearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.X2DTO;
import com.hgicreate.rno.xdr.backend.service.mapper.X2Mapper;
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
 * Test class for the X2Resource REST controller.
 *
 * @see X2Resource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class X2ResourceIntTest {

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

    private static final Long DEFAULT_SWITCH_REQUEST = 1L;
    private static final Long UPDATED_SWITCH_REQUEST = 2L;

    private static final Long DEFAULT_SWITCH_SUCCESS = 1L;
    private static final Long UPDATED_SWITCH_SUCCESS = 2L;

    private static final Double DEFAULT_SWITCH_SUCCESS_RATE = 1D;
    private static final Double UPDATED_SWITCH_SUCCESS_RATE = 2D;

    @Autowired
    private X2Repository x2Repository;

    @Autowired
    private X2Mapper x2Mapper;

    @Autowired
    private X2Service x2Service;

    @Autowired
    private X2SearchRepository x2SearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restX2MockMvc;

    private X2 x2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        X2Resource x2Resource = new X2Resource(x2Service);
        this.restX2MockMvc = MockMvcBuilders.standaloneSetup(x2Resource)
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
    public static X2 createEntity(EntityManager em) {
        X2 x2 = new X2()
            .pdate(DEFAULT_PDATE)
            .phour(DEFAULT_PHOUR)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .switchRequest(DEFAULT_SWITCH_REQUEST)
            .switchSuccess(DEFAULT_SWITCH_SUCCESS)
            .switchSuccessRate(DEFAULT_SWITCH_SUCCESS_RATE);
        return x2;
    }

    @Before
    public void initTest() {
        x2SearchRepository.deleteAll();
        x2 = createEntity(em);
    }

    @Test
    @Transactional
    public void createX2() throws Exception {
        int databaseSizeBeforeCreate = x2Repository.findAll().size();

        // Create the X2
        X2DTO x2DTO = x2Mapper.toDto(x2);
        restX2MockMvc.perform(post("/api/x-2-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(x2DTO)))
            .andExpect(status().isCreated());

        // Validate the X2 in the database
        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeCreate + 1);
        X2 testX2 = x2List.get(x2List.size() - 1);
        assertThat(testX2.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testX2.getPhour()).isEqualTo(DEFAULT_PHOUR);
        assertThat(testX2.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testX2.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testX2.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testX2.getSwitchRequest()).isEqualTo(DEFAULT_SWITCH_REQUEST);
        assertThat(testX2.getSwitchSuccess()).isEqualTo(DEFAULT_SWITCH_SUCCESS);
        assertThat(testX2.getSwitchSuccessRate()).isEqualTo(DEFAULT_SWITCH_SUCCESS_RATE);

        // Validate the X2 in Elasticsearch
        X2 x2Es = x2SearchRepository.findOne(testX2.getId());
        assertThat(x2Es).isEqualToComparingFieldByField(testX2);
    }

    @Test
    @Transactional
    public void createX2WithExistingId() throws Exception {
        int databaseSizeBeforeCreate = x2Repository.findAll().size();

        // Create the X2 with an existing ID
        x2.setId(1L);
        X2DTO x2DTO = x2Mapper.toDto(x2);

        // An entity with an existing ID cannot be created, so this API call must fail
        restX2MockMvc.perform(post("/api/x-2-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(x2DTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = x2Repository.findAll().size();
        // set the field null
        x2.setPdate(null);

        // Create the X2, which fails.
        X2DTO x2DTO = x2Mapper.toDto(x2);

        restX2MockMvc.perform(post("/api/x-2-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(x2DTO)))
            .andExpect(status().isBadRequest());

        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllX2S() throws Exception {
        // Initialize the database
        x2Repository.saveAndFlush(x2);

        // Get all the x2List
        restX2MockMvc.perform(get("/api/x-2-s?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(x2.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].switchRequest").value(hasItem(DEFAULT_SWITCH_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].switchSuccess").value(hasItem(DEFAULT_SWITCH_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].switchSuccessRate").value(hasItem(DEFAULT_SWITCH_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void getX2() throws Exception {
        // Initialize the database
        x2Repository.saveAndFlush(x2);

        // Get the x2
        restX2MockMvc.perform(get("/api/x-2-s/{id}", x2.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(x2.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.phour").value(DEFAULT_PHOUR))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.toString()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.toString()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.toString()))
            .andExpect(jsonPath("$.switchRequest").value(DEFAULT_SWITCH_REQUEST.intValue()))
            .andExpect(jsonPath("$.switchSuccess").value(DEFAULT_SWITCH_SUCCESS.intValue()))
            .andExpect(jsonPath("$.switchSuccessRate").value(DEFAULT_SWITCH_SUCCESS_RATE.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingX2() throws Exception {
        // Get the x2
        restX2MockMvc.perform(get("/api/x-2-s/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateX2() throws Exception {
        // Initialize the database
        x2Repository.saveAndFlush(x2);
        x2SearchRepository.save(x2);
        int databaseSizeBeforeUpdate = x2Repository.findAll().size();

        // Update the x2
        X2 updatedX2 = x2Repository.findOne(x2.getId());
        updatedX2
            .pdate(UPDATED_PDATE)
            .phour(UPDATED_PHOUR)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .switchRequest(UPDATED_SWITCH_REQUEST)
            .switchSuccess(UPDATED_SWITCH_SUCCESS)
            .switchSuccessRate(UPDATED_SWITCH_SUCCESS_RATE);
        X2DTO x2DTO = x2Mapper.toDto(updatedX2);

        restX2MockMvc.perform(put("/api/x-2-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(x2DTO)))
            .andExpect(status().isOk());

        // Validate the X2 in the database
        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeUpdate);
        X2 testX2 = x2List.get(x2List.size() - 1);
        assertThat(testX2.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testX2.getPhour()).isEqualTo(UPDATED_PHOUR);
        assertThat(testX2.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testX2.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testX2.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testX2.getSwitchRequest()).isEqualTo(UPDATED_SWITCH_REQUEST);
        assertThat(testX2.getSwitchSuccess()).isEqualTo(UPDATED_SWITCH_SUCCESS);
        assertThat(testX2.getSwitchSuccessRate()).isEqualTo(UPDATED_SWITCH_SUCCESS_RATE);

        // Validate the X2 in Elasticsearch
        X2 x2Es = x2SearchRepository.findOne(testX2.getId());
        assertThat(x2Es).isEqualToComparingFieldByField(testX2);
    }

    @Test
    @Transactional
    public void updateNonExistingX2() throws Exception {
        int databaseSizeBeforeUpdate = x2Repository.findAll().size();

        // Create the X2
        X2DTO x2DTO = x2Mapper.toDto(x2);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restX2MockMvc.perform(put("/api/x-2-s")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(x2DTO)))
            .andExpect(status().isCreated());

        // Validate the X2 in the database
        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteX2() throws Exception {
        // Initialize the database
        x2Repository.saveAndFlush(x2);
        x2SearchRepository.save(x2);
        int databaseSizeBeforeDelete = x2Repository.findAll().size();

        // Get the x2
        restX2MockMvc.perform(delete("/api/x-2-s/{id}", x2.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean x2ExistsInEs = x2SearchRepository.exists(x2.getId());
        assertThat(x2ExistsInEs).isFalse();

        // Validate the database is empty
        List<X2> x2List = x2Repository.findAll();
        assertThat(x2List).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchX2() throws Exception {
        // Initialize the database
        x2Repository.saveAndFlush(x2);
        x2SearchRepository.save(x2);

        // Search the x2
        restX2MockMvc.perform(get("/api/_search/x-2-s?query=id:" + x2.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(x2.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].phour").value(hasItem(DEFAULT_PHOUR)))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.toString())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.toString())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.toString())))
            .andExpect(jsonPath("$.[*].switchRequest").value(hasItem(DEFAULT_SWITCH_REQUEST.intValue())))
            .andExpect(jsonPath("$.[*].switchSuccess").value(hasItem(DEFAULT_SWITCH_SUCCESS.intValue())))
            .andExpect(jsonPath("$.[*].switchSuccessRate").value(hasItem(DEFAULT_SWITCH_SUCCESS_RATE.doubleValue())));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(X2.class);
        X2 x21 = new X2();
        x21.setId(1L);
        X2 x22 = new X2();
        x22.setId(x21.getId());
        assertThat(x21).isEqualTo(x22);
        x22.setId(2L);
        assertThat(x21).isNotEqualTo(x22);
        x21.setId(null);
        assertThat(x21).isNotEqualTo(x22);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(X2DTO.class);
        X2DTO x2DTO1 = new X2DTO();
        x2DTO1.setId(1L);
        X2DTO x2DTO2 = new X2DTO();
        assertThat(x2DTO1).isNotEqualTo(x2DTO2);
        x2DTO2.setId(x2DTO1.getId());
        assertThat(x2DTO1).isEqualTo(x2DTO2);
        x2DTO2.setId(2L);
        assertThat(x2DTO1).isNotEqualTo(x2DTO2);
        x2DTO1.setId(null);
        assertThat(x2DTO1).isNotEqualTo(x2DTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(x2Mapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(x2Mapper.fromId(null)).isNull();
    }
}
