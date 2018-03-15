package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.X2Service;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.X2DTO;
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
 * REST controller for managing X2.
 */
@RestController
@RequestMapping("/api")
public class X2Resource {

    private final Logger log = LoggerFactory.getLogger(X2Resource.class);

    private static final String ENTITY_NAME = "x2";

    private final X2Service x2Service;

    public X2Resource(X2Service x2Service) {
        this.x2Service = x2Service;
    }

    /**
     * POST  /x-2-s : Create a new x2.
     *
     * @param x2DTO the x2DTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new x2DTO, or with status 400 (Bad Request) if the x2 has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/x-2-s")
    @Timed
    public ResponseEntity<X2DTO> createX2(@Valid @RequestBody X2DTO x2DTO) throws URISyntaxException {
        log.debug("REST request to save X2 : {}", x2DTO);
        if (x2DTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new x2 cannot already have an ID")).body(null);
        }
        X2DTO result = x2Service.save(x2DTO);
        return ResponseEntity.created(new URI("/api/x-2-s/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /x-2-s : Updates an existing x2.
     *
     * @param x2DTO the x2DTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated x2DTO,
     * or with status 400 (Bad Request) if the x2DTO is not valid,
     * or with status 500 (Internal Server Error) if the x2DTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/x-2-s")
    @Timed
    public ResponseEntity<X2DTO> updateX2(@Valid @RequestBody X2DTO x2DTO) throws URISyntaxException {
        log.debug("REST request to update X2 : {}", x2DTO);
        if (x2DTO.getId() == null) {
            return createX2(x2DTO);
        }
        X2DTO result = x2Service.save(x2DTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, x2DTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /x-2-s : get all the x2S.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of x2S in body
     */
    @GetMapping("/x-2-s")
    @Timed
    public ResponseEntity<List<X2DTO>> getAllX2S(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of X2S");
        Page<X2DTO> page = x2Service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/x-2-s");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /x-2-s/:id : get the "id" x2.
     *
     * @param id the id of the x2DTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the x2DTO, or with status 404 (Not Found)
     */
    @GetMapping("/x-2-s/{id}")
    @Timed
    public ResponseEntity<X2DTO> getX2(@PathVariable Long id) {
        log.debug("REST request to get X2 : {}", id);
        X2DTO x2DTO = x2Service.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(x2DTO));
    }

    /**
     * DELETE  /x-2-s/:id : delete the "id" x2.
     *
     * @param id the id of the x2DTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/x-2-s/{id}")
    @Timed
    public ResponseEntity<Void> deleteX2(@PathVariable Long id) {
        log.debug("REST request to delete X2 : {}", id);
        x2Service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/x-2-s?query=:query : search for the x2 corresponding
     * to the query.
     *
     * @param query the query of the x2 search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/x-2-s")
    @Timed
    public ResponseEntity<List<X2DTO>> searchX2S(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of X2S for query {}", query);
        Page<X2DTO> page = x2Service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/x-2-s");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
