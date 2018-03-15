package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.MrService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.MrDTO;
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
 * REST controller for managing Mr.
 */
@RestController
@RequestMapping("/api")
public class MrResource {

    private final Logger log = LoggerFactory.getLogger(MrResource.class);

    private static final String ENTITY_NAME = "mr";

    private final MrService mrService;

    public MrResource(MrService mrService) {
        this.mrService = mrService;
    }

    /**
     * POST  /mrs : Create a new mr.
     *
     * @param mrDTO the mrDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new mrDTO, or with status 400 (Bad Request) if the mr has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/mrs")
    @Timed
    public ResponseEntity<MrDTO> createMr(@Valid @RequestBody MrDTO mrDTO) throws URISyntaxException {
        log.debug("REST request to save Mr : {}", mrDTO);
        if (mrDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new mr cannot already have an ID")).body(null);
        }
        MrDTO result = mrService.save(mrDTO);
        return ResponseEntity.created(new URI("/api/mrs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /mrs : Updates an existing mr.
     *
     * @param mrDTO the mrDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated mrDTO,
     * or with status 400 (Bad Request) if the mrDTO is not valid,
     * or with status 500 (Internal Server Error) if the mrDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/mrs")
    @Timed
    public ResponseEntity<MrDTO> updateMr(@Valid @RequestBody MrDTO mrDTO) throws URISyntaxException {
        log.debug("REST request to update Mr : {}", mrDTO);
        if (mrDTO.getId() == null) {
            return createMr(mrDTO);
        }
        MrDTO result = mrService.save(mrDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, mrDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /mrs : get all the mrs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of mrs in body
     */
    @GetMapping("/mrs")
    @Timed
    public ResponseEntity<List<MrDTO>> getAllMrs(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Mrs");
        Page<MrDTO> page = mrService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/mrs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /mrs/:id : get the "id" mr.
     *
     * @param id the id of the mrDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mrDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mrs/{id}")
    @Timed
    public ResponseEntity<MrDTO> getMr(@PathVariable Long id) {
        log.debug("REST request to get Mr : {}", id);
        MrDTO mrDTO = mrService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(mrDTO));
    }

    /**
     * DELETE  /mrs/:id : delete the "id" mr.
     *
     * @param id the id of the mrDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/mrs/{id}")
    @Timed
    public ResponseEntity<Void> deleteMr(@PathVariable Long id) {
        log.debug("REST request to delete Mr : {}", id);
        mrService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/mrs?query=:query : search for the mr corresponding
     * to the query.
     *
     * @param query the query of the mr search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/mrs")
    @Timed
    public ResponseEntity<List<MrDTO>> searchMrs(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Mrs for query {}", query);
        Page<MrDTO> page = mrService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/mrs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
