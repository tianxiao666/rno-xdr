package com.hgicreate.rno.xdr.backend.web.rest;

import com.hgicreate.rno.xdr.backend.BackendApp;

import com.hgicreate.rno.xdr.backend.domain.Track;
import com.hgicreate.rno.xdr.backend.repository.TrackRepository;
import com.hgicreate.rno.xdr.backend.service.TrackService;
import com.hgicreate.rno.xdr.backend.repository.search.TrackSearchRepository;
import com.hgicreate.rno.xdr.backend.service.dto.TrackDTO;
import com.hgicreate.rno.xdr.backend.service.mapper.TrackMapper;
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
 * Test class for the TrackResource REST controller.
 *
 * @see TrackResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendApp.class)
public class TrackResourceIntTest {

    private static final LocalDate DEFAULT_PDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_START_TIME = 1L;
    private static final Long UPDATED_START_TIME = 2L;

    private static final Long DEFAULT_END_TIME = 1L;
    private static final Long UPDATED_END_TIME = 2L;

    private static final Long DEFAULT_CELL = 1L;
    private static final Long UPDATED_CELL = 2L;

    private static final Long DEFAULT_IMEI = 1L;
    private static final Long UPDATED_IMEI = 2L;

    private static final Long DEFAULT_IMSI = 1L;
    private static final Long UPDATED_IMSI = 2L;

    private static final Long DEFAULT_MSISDN = 1L;
    private static final Long UPDATED_MSISDN = 2L;

    private static final Double DEFAULT_LON = 1D;
    private static final Double UPDATED_LON = 2D;

    private static final Double DEFAULT_LAT = 1D;
    private static final Double UPDATED_LAT = 2D;

    private static final String DEFAULT_INDICATOR_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_INDICATOR_TYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackService trackService;

    @Autowired
    private TrackSearchRepository trackSearchRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTrackMockMvc;

    private Track track;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        TrackResource trackResource = new TrackResource(trackService);
        this.restTrackMockMvc = MockMvcBuilders.standaloneSetup(trackResource)
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
    public static Track createEntity(EntityManager em) {
        Track track = new Track()
            .pdate(DEFAULT_PDATE)
            .startTime(DEFAULT_START_TIME)
            .endTime(DEFAULT_END_TIME)
            .cell(DEFAULT_CELL)
            .imei(DEFAULT_IMEI)
            .imsi(DEFAULT_IMSI)
            .msisdn(DEFAULT_MSISDN)
            .lon(DEFAULT_LON)
            .lat(DEFAULT_LAT)
            .indicatorType(DEFAULT_INDICATOR_TYPE)
            .status(DEFAULT_STATUS);
        return track;
    }

    @Before
    public void initTest() {
        trackSearchRepository.deleteAll();
        track = createEntity(em);
    }

    @Test
    @Transactional
    public void createTrack() throws Exception {
        int databaseSizeBeforeCreate = trackRepository.findAll().size();

        // Create the Track
        TrackDTO trackDTO = trackMapper.toDto(track);
        restTrackMockMvc.perform(post("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isCreated());

        // Validate the Track in the database
        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeCreate + 1);
        Track testTrack = trackList.get(trackList.size() - 1);
        assertThat(testTrack.getPdate()).isEqualTo(DEFAULT_PDATE);
        assertThat(testTrack.getStartTime()).isEqualTo(DEFAULT_START_TIME);
        assertThat(testTrack.getEndTime()).isEqualTo(DEFAULT_END_TIME);
        assertThat(testTrack.getCell()).isEqualTo(DEFAULT_CELL);
        assertThat(testTrack.getImei()).isEqualTo(DEFAULT_IMEI);
        assertThat(testTrack.getImsi()).isEqualTo(DEFAULT_IMSI);
        assertThat(testTrack.getMsisdn()).isEqualTo(DEFAULT_MSISDN);
        assertThat(testTrack.getLon()).isEqualTo(DEFAULT_LON);
        assertThat(testTrack.getLat()).isEqualTo(DEFAULT_LAT);
        assertThat(testTrack.getIndicatorType()).isEqualTo(DEFAULT_INDICATOR_TYPE);
        assertThat(testTrack.getStatus()).isEqualTo(DEFAULT_STATUS);

        // Validate the Track in Elasticsearch
        Track trackEs = trackSearchRepository.findOne(testTrack.getId());
        assertThat(trackEs).isEqualToComparingFieldByField(testTrack);
    }

    @Test
    @Transactional
    public void createTrackWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = trackRepository.findAll().size();

        // Create the Track with an existing ID
        track.setId(1L);
        TrackDTO trackDTO = trackMapper.toDto(track);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTrackMockMvc.perform(post("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkPdateIsRequired() throws Exception {
        int databaseSizeBeforeTest = trackRepository.findAll().size();
        // set the field null
        track.setPdate(null);

        // Create the Track, which fails.
        TrackDTO trackDTO = trackMapper.toDto(track);

        restTrackMockMvc.perform(post("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isBadRequest());

        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStartTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = trackRepository.findAll().size();
        // set the field null
        track.setStartTime(null);

        // Create the Track, which fails.
        TrackDTO trackDTO = trackMapper.toDto(track);

        restTrackMockMvc.perform(post("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isBadRequest());

        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEndTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = trackRepository.findAll().size();
        // set the field null
        track.setEndTime(null);

        // Create the Track, which fails.
        TrackDTO trackDTO = trackMapper.toDto(track);

        restTrackMockMvc.perform(post("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isBadRequest());

        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllTracks() throws Exception {
        // Initialize the database
        trackRepository.saveAndFlush(track);

        // Get all the trackList
        restTrackMockMvc.perform(get("/api/tracks?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(track.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.intValue())))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME.intValue())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].msisdn").value(hasItem(DEFAULT_MSISDN.intValue())))
            .andExpect(jsonPath("$.[*].lon").value(hasItem(DEFAULT_LON.doubleValue())))
            .andExpect(jsonPath("$.[*].lat").value(hasItem(DEFAULT_LAT.doubleValue())))
            .andExpect(jsonPath("$.[*].indicatorType").value(hasItem(DEFAULT_INDICATOR_TYPE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)));
    }

    @Test
    @Transactional
    public void getTrack() throws Exception {
        // Initialize the database
        trackRepository.saveAndFlush(track);

        // Get the track
        restTrackMockMvc.perform(get("/api/tracks/{id}", track.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(track.getId().intValue()))
            .andExpect(jsonPath("$.pdate").value(DEFAULT_PDATE.toString()))
            .andExpect(jsonPath("$.startTime").value(DEFAULT_START_TIME.intValue()))
            .andExpect(jsonPath("$.endTime").value(DEFAULT_END_TIME.intValue()))
            .andExpect(jsonPath("$.cell").value(DEFAULT_CELL.intValue()))
            .andExpect(jsonPath("$.imei").value(DEFAULT_IMEI.intValue()))
            .andExpect(jsonPath("$.imsi").value(DEFAULT_IMSI.intValue()))
            .andExpect(jsonPath("$.msisdn").value(DEFAULT_MSISDN.intValue()))
            .andExpect(jsonPath("$.lon").value(DEFAULT_LON.doubleValue()))
            .andExpect(jsonPath("$.lat").value(DEFAULT_LAT.doubleValue()))
            .andExpect(jsonPath("$.indicatorType").value(DEFAULT_INDICATOR_TYPE.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS));
    }

    @Test
    @Transactional
    public void getNonExistingTrack() throws Exception {
        // Get the track
        restTrackMockMvc.perform(get("/api/tracks/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTrack() throws Exception {
        // Initialize the database
        trackRepository.saveAndFlush(track);
        trackSearchRepository.save(track);
        int databaseSizeBeforeUpdate = trackRepository.findAll().size();

        // Update the track
        Track updatedTrack = trackRepository.findOne(track.getId());
        updatedTrack
            .pdate(UPDATED_PDATE)
            .startTime(UPDATED_START_TIME)
            .endTime(UPDATED_END_TIME)
            .cell(UPDATED_CELL)
            .imei(UPDATED_IMEI)
            .imsi(UPDATED_IMSI)
            .msisdn(UPDATED_MSISDN)
            .lon(UPDATED_LON)
            .lat(UPDATED_LAT)
            .indicatorType(UPDATED_INDICATOR_TYPE)
            .status(UPDATED_STATUS);
        TrackDTO trackDTO = trackMapper.toDto(updatedTrack);

        restTrackMockMvc.perform(put("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isOk());

        // Validate the Track in the database
        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeUpdate);
        Track testTrack = trackList.get(trackList.size() - 1);
        assertThat(testTrack.getPdate()).isEqualTo(UPDATED_PDATE);
        assertThat(testTrack.getStartTime()).isEqualTo(UPDATED_START_TIME);
        assertThat(testTrack.getEndTime()).isEqualTo(UPDATED_END_TIME);
        assertThat(testTrack.getCell()).isEqualTo(UPDATED_CELL);
        assertThat(testTrack.getImei()).isEqualTo(UPDATED_IMEI);
        assertThat(testTrack.getImsi()).isEqualTo(UPDATED_IMSI);
        assertThat(testTrack.getMsisdn()).isEqualTo(UPDATED_MSISDN);
        assertThat(testTrack.getLon()).isEqualTo(UPDATED_LON);
        assertThat(testTrack.getLat()).isEqualTo(UPDATED_LAT);
        assertThat(testTrack.getIndicatorType()).isEqualTo(UPDATED_INDICATOR_TYPE);
        assertThat(testTrack.getStatus()).isEqualTo(UPDATED_STATUS);

        // Validate the Track in Elasticsearch
        Track trackEs = trackSearchRepository.findOne(testTrack.getId());
        assertThat(trackEs).isEqualToComparingFieldByField(testTrack);
    }

    @Test
    @Transactional
    public void updateNonExistingTrack() throws Exception {
        int databaseSizeBeforeUpdate = trackRepository.findAll().size();

        // Create the Track
        TrackDTO trackDTO = trackMapper.toDto(track);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTrackMockMvc.perform(put("/api/tracks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trackDTO)))
            .andExpect(status().isCreated());

        // Validate the Track in the database
        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteTrack() throws Exception {
        // Initialize the database
        trackRepository.saveAndFlush(track);
        trackSearchRepository.save(track);
        int databaseSizeBeforeDelete = trackRepository.findAll().size();

        // Get the track
        restTrackMockMvc.perform(delete("/api/tracks/{id}", track.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate Elasticsearch is empty
        boolean trackExistsInEs = trackSearchRepository.exists(track.getId());
        assertThat(trackExistsInEs).isFalse();

        // Validate the database is empty
        List<Track> trackList = trackRepository.findAll();
        assertThat(trackList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void searchTrack() throws Exception {
        // Initialize the database
        trackRepository.saveAndFlush(track);
        trackSearchRepository.save(track);

        // Search the track
        restTrackMockMvc.perform(get("/api/_search/tracks?query=id:" + track.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(track.getId().intValue())))
            .andExpect(jsonPath("$.[*].pdate").value(hasItem(DEFAULT_PDATE.toString())))
            .andExpect(jsonPath("$.[*].startTime").value(hasItem(DEFAULT_START_TIME.intValue())))
            .andExpect(jsonPath("$.[*].endTime").value(hasItem(DEFAULT_END_TIME.intValue())))
            .andExpect(jsonPath("$.[*].cell").value(hasItem(DEFAULT_CELL.intValue())))
            .andExpect(jsonPath("$.[*].imei").value(hasItem(DEFAULT_IMEI.intValue())))
            .andExpect(jsonPath("$.[*].imsi").value(hasItem(DEFAULT_IMSI.intValue())))
            .andExpect(jsonPath("$.[*].msisdn").value(hasItem(DEFAULT_MSISDN.intValue())))
            .andExpect(jsonPath("$.[*].lon").value(hasItem(DEFAULT_LON.doubleValue())))
            .andExpect(jsonPath("$.[*].lat").value(hasItem(DEFAULT_LAT.doubleValue())))
            .andExpect(jsonPath("$.[*].indicatorType").value(hasItem(DEFAULT_INDICATOR_TYPE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)));
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Track.class);
        Track track1 = new Track();
        track1.setId(1L);
        Track track2 = new Track();
        track2.setId(track1.getId());
        assertThat(track1).isEqualTo(track2);
        track2.setId(2L);
        assertThat(track1).isNotEqualTo(track2);
        track1.setId(null);
        assertThat(track1).isNotEqualTo(track2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrackDTO.class);
        TrackDTO trackDTO1 = new TrackDTO();
        trackDTO1.setId(1L);
        TrackDTO trackDTO2 = new TrackDTO();
        assertThat(trackDTO1).isNotEqualTo(trackDTO2);
        trackDTO2.setId(trackDTO1.getId());
        assertThat(trackDTO1).isEqualTo(trackDTO2);
        trackDTO2.setId(2L);
        assertThat(trackDTO1).isNotEqualTo(trackDTO2);
        trackDTO1.setId(null);
        assertThat(trackDTO1).isNotEqualTo(trackDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(trackMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(trackMapper.fromId(null)).isNull();
    }
}
