package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.UhttpService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.UhttpDTO;
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
 * REST controller for managing Uhttp.
 */
@RestController
@RequestMapping("/api")
public class UhttpResource {

    private final Logger log = LoggerFactory.getLogger(UhttpResource.class);

    private static final String ENTITY_NAME = "uhttp";

    private final UhttpService uhttpService;

    public UhttpResource(UhttpService uhttpService) {
        this.uhttpService = uhttpService;
    }

    /**
     * POST  /uhttps : Create a new uhttp.
     *
     * @param uhttpDTO the uhttpDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new uhttpDTO, or with status 400 (Bad Request) if the uhttp has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/uhttps")
    @Timed
    public ResponseEntity<UhttpDTO> createUhttp(@Valid @RequestBody UhttpDTO uhttpDTO) throws URISyntaxException {
        log.debug("REST request to save Uhttp : {}", uhttpDTO);
        if (uhttpDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new uhttp cannot already have an ID")).body(null);
        }
        UhttpDTO result = uhttpService.save(uhttpDTO);
        return ResponseEntity.created(new URI("/api/uhttps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /uhttps : Updates an existing uhttp.
     *
     * @param uhttpDTO the uhttpDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated uhttpDTO,
     * or with status 400 (Bad Request) if the uhttpDTO is not valid,
     * or with status 500 (Internal Server Error) if the uhttpDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/uhttps")
    @Timed
    public ResponseEntity<UhttpDTO> updateUhttp(@Valid @RequestBody UhttpDTO uhttpDTO) throws URISyntaxException {
        log.debug("REST request to update Uhttp : {}", uhttpDTO);
        if (uhttpDTO.getId() == null) {
            return createUhttp(uhttpDTO);
        }
        UhttpDTO result = uhttpService.save(uhttpDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, uhttpDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /uhttps : get all the uhttps.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of uhttps in body
     */
    @GetMapping("/uhttps")
    @Timed
    public ResponseEntity<List<UhttpDTO>> getAllUhttps(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Uhttps");
        Page<UhttpDTO> page = uhttpService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/uhttps");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /uhttps/:id : get the "id" uhttp.
     *
     * @param id the id of the uhttpDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the uhttpDTO, or with status 404 (Not Found)
     */
    @GetMapping("/uhttps/{id}")
    @Timed
    public ResponseEntity<UhttpDTO> getUhttp(@PathVariable Long id) {
        log.debug("REST request to get Uhttp : {}", id);
        UhttpDTO uhttpDTO = uhttpService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(uhttpDTO));
    }

    /**
     * DELETE  /uhttps/:id : delete the "id" uhttp.
     *
     * @param id the id of the uhttpDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/uhttps/{id}")
    @Timed
    public ResponseEntity<Void> deleteUhttp(@PathVariable Long id) {
        log.debug("REST request to delete Uhttp : {}", id);
        uhttpService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/uhttps?query=:query : search for the uhttp corresponding
     * to the query.
     *
     * @param query the query of the uhttp search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/uhttps")
    @Timed
    public ResponseEntity<List<UhttpDTO>> searchUhttps(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Uhttps for query {}", query);
        Page<UhttpDTO> page = uhttpService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/uhttps");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
