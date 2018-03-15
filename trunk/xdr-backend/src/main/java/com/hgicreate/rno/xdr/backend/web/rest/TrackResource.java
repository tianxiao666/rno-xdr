package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.TrackService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.TrackDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Track.
 */
@RestController
@RequestMapping("/api")
public class TrackResource {

    private final Logger log = LoggerFactory.getLogger(TrackResource.class);

    private static final String ENTITY_NAME = "track";

    private final TrackService trackService;

    public TrackResource(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * POST  /tracks : Create a new track.
     *
     * @param trackDTO the trackDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new trackDTO, or with status 400 (Bad Request) if the track has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tracks")
    @Timed
    public ResponseEntity<TrackDTO> createTrack(@Valid @RequestBody TrackDTO trackDTO) throws URISyntaxException {
        log.debug("REST request to save Track : {}", trackDTO);
        if (trackDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new track cannot already have an ID")).body(null);
        }
        TrackDTO result = trackService.save(trackDTO);
        return ResponseEntity.created(new URI("/api/tracks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tracks : Updates an existing track.
     *
     * @param trackDTO the trackDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated trackDTO,
     * or with status 400 (Bad Request) if the trackDTO is not valid,
     * or with status 500 (Internal Server Error) if the trackDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tracks")
    @Timed
    public ResponseEntity<TrackDTO> updateTrack(@Valid @RequestBody TrackDTO trackDTO) throws URISyntaxException {
        log.debug("REST request to update Track : {}", trackDTO);
        if (trackDTO.getId() == null) {
            return createTrack(trackDTO);
        }
        TrackDTO result = trackService.save(trackDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, trackDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tracks : get all the tracks.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tracks in body
     */
    @GetMapping("/tracks")
    @Timed
    public ResponseEntity<List<TrackDTO>> getAllTracks(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Tracks");
        Page<TrackDTO> page = trackService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tracks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /tracks/:id : get the "id" track.
     *
     * @param id the id of the trackDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the trackDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tracks/{id}")
    @Timed
    public ResponseEntity<TrackDTO> getTrack(@PathVariable Long id) {
        log.debug("REST request to get Track : {}", id);
        TrackDTO trackDTO = trackService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(trackDTO));
    }

    /**
     * DELETE  /tracks/:id : delete the "id" track.
     *
     * @param id the id of the trackDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tracks/{id}")
    @Timed
    public ResponseEntity<Void> deleteTrack(@PathVariable Long id) {
        log.debug("REST request to delete Track : {}", id);
        trackService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/tracks?query=:query : search for the track corresponding
     * to the query.
     *
     * @param query the query of the track search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/tracks")
    @Timed
    public ResponseEntity<List<TrackDTO>> searchTracks(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Tracks for query {}", query);
        Page<TrackDTO> page = trackService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/tracks");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /tracks/findByTimeAndImsiAndIndicatorType : get tracks by time and imsi and indicator type.
     *
     * @param beginTime the begin time of the trackDTO to retrieve
     * @param endTime   the end time of the trackDTO to retrieve
     * @param imsi      the imsi of the trackDTO to retrieve
     * @param indicatorType      the indicator type of the trackDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of tracks in body
     */
    @GetMapping("/tracks/findByTimeAndImsiAndIndicatorType")
    @Timed
    public ResponseEntity<List<TrackDTO>> findByTimeAndImsiAndIndicatorType(@RequestParam Long beginTime, @RequestParam Long endTime, @RequestParam Long imsi,@RequestParam String indicatorType) {
        log.debug("REST request to get a page of tracks : beginTime = {}, endTime = {}, imsi = {}, indicatorType = {}", beginTime, endTime, imsi, indicatorType);
        List<TrackDTO> trackDTOs = trackService.findByTimeAndImsiAndIndicatorType(beginTime, endTime, imsi, indicatorType);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(trackDTOs));
    }
}
