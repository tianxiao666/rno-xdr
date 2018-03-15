package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.UuService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.UuDTO;
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
 * REST controller for managing Uu.
 */
@RestController
@RequestMapping("/api")
public class UuResource {

    private final Logger log = LoggerFactory.getLogger(UuResource.class);

    private static final String ENTITY_NAME = "uu";

    private final UuService uuService;

    public UuResource(UuService uuService) {
        this.uuService = uuService;
    }

    /**
     * POST  /uus : Create a new uu.
     *
     * @param uuDTO the uuDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new uuDTO, or with status 400 (Bad Request) if the uu has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/uus")
    @Timed
    public ResponseEntity<UuDTO> createUu(@Valid @RequestBody UuDTO uuDTO) throws URISyntaxException {
        log.debug("REST request to save Uu : {}", uuDTO);
        if (uuDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new uu cannot already have an ID")).body(null);
        }
        UuDTO result = uuService.save(uuDTO);
        return ResponseEntity.created(new URI("/api/uus/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /uus : Updates an existing uu.
     *
     * @param uuDTO the uuDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated uuDTO,
     * or with status 400 (Bad Request) if the uuDTO is not valid,
     * or with status 500 (Internal Server Error) if the uuDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/uus")
    @Timed
    public ResponseEntity<UuDTO> updateUu(@Valid @RequestBody UuDTO uuDTO) throws URISyntaxException {
        log.debug("REST request to update Uu : {}", uuDTO);
        if (uuDTO.getId() == null) {
            return createUu(uuDTO);
        }
        UuDTO result = uuService.save(uuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, uuDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /uus : get all the uus.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of uus in body
     */
    @GetMapping("/uus")
    @Timed
    public ResponseEntity<List<UuDTO>> getAllUus(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Uus");
        Page<UuDTO> page = uuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/uus");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /uus/:id : get the "id" uu.
     *
     * @param id the id of the uuDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the uuDTO, or with status 404 (Not Found)
     */
    @GetMapping("/uus/{id}")
    @Timed
    public ResponseEntity<UuDTO> getUu(@PathVariable Long id) {
        log.debug("REST request to get Uu : {}", id);
        UuDTO uuDTO = uuService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(uuDTO));
    }

    /**
     * DELETE  /uus/:id : delete the "id" uu.
     *
     * @param id the id of the uuDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/uus/{id}")
    @Timed
    public ResponseEntity<Void> deleteUu(@PathVariable Long id) {
        log.debug("REST request to delete Uu : {}", id);
        uuService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/uus?query=:query : search for the uu corresponding
     * to the query.
     *
     * @param query the query of the uu search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/uus")
    @Timed
    public ResponseEntity<List<UuDTO>> searchUus(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Uus for query {}", query);
        Page<UuDTO> page = uuService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/uus");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
