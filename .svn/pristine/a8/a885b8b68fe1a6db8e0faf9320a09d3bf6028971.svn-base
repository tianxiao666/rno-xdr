package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.ExceptionCauseService;
import com.hgicreate.rno.xdr.backend.web.rest.cond.ExceptionCauseCond;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.ExceptionCauseDTO;
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
 * REST controller for managing ExceptionCause.
 */
@RestController
@RequestMapping("/api")
public class ExceptionCauseResource {

    private final Logger log = LoggerFactory.getLogger(ExceptionCauseResource.class);

    private static final String ENTITY_NAME = "exceptionCause";

    private final ExceptionCauseService exceptionCauseService;

    public ExceptionCauseResource(ExceptionCauseService exceptionCauseService) {
        this.exceptionCauseService = exceptionCauseService;
    }

    /**
     * POST  /exception-causes : Create a new exceptionCause.
     *
     * @param exceptionCauseDTO the exceptionCauseDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new exceptionCauseDTO, or with status 400 (Bad Request) if the exceptionCause has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/exception-causes")
    @Timed
    public ResponseEntity<ExceptionCauseDTO> createExceptionCause(@Valid @RequestBody ExceptionCauseDTO exceptionCauseDTO) throws URISyntaxException {
        log.debug("REST request to save ExceptionCause : {}", exceptionCauseDTO);
        if (exceptionCauseDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new exceptionCause cannot already have an ID")).body(null);
        }
        ExceptionCauseDTO result = exceptionCauseService.save(exceptionCauseDTO);
        return ResponseEntity.created(new URI("/api/exception-causes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /exception-causes : Updates an existing exceptionCause.
     *
     * @param exceptionCauseDTO the exceptionCauseDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated exceptionCauseDTO,
     * or with status 400 (Bad Request) if the exceptionCauseDTO is not valid,
     * or with status 500 (Internal Server Error) if the exceptionCauseDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/exception-causes")
    @Timed
    public ResponseEntity<ExceptionCauseDTO> updateExceptionCause(@Valid @RequestBody ExceptionCauseDTO exceptionCauseDTO) throws URISyntaxException {
        log.debug("REST request to update ExceptionCause : {}", exceptionCauseDTO);
        if (exceptionCauseDTO.getId() == null) {
            return createExceptionCause(exceptionCauseDTO);
        }
        ExceptionCauseDTO result = exceptionCauseService.save(exceptionCauseDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, exceptionCauseDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /exception-causes : get all the exceptionCauses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of exceptionCauses in body
     */
    @GetMapping("/exception-causes")
    @Timed
    public ResponseEntity<List<ExceptionCauseDTO>> getAllExceptionCauses(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ExceptionCauses");
        Page<ExceptionCauseDTO> page = exceptionCauseService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/exception-causes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /exception-causes/:id : get the "id" exceptionCause.
     *
     * @param id the id of the exceptionCauseDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the exceptionCauseDTO, or with status 404 (Not Found)
     */
    @GetMapping("/exception-causes/{id}")
    @Timed
    public ResponseEntity<ExceptionCauseDTO> getExceptionCause(@PathVariable Long id) {
        log.debug("REST request to get ExceptionCause : {}", id);
        ExceptionCauseDTO exceptionCauseDTO = exceptionCauseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(exceptionCauseDTO));
    }

    /**
     * DELETE  /exception-causes/:id : delete the "id" exceptionCause.
     *
     * @param id the id of the exceptionCauseDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/exception-causes/{id}")
    @Timed
    public ResponseEntity<Void> deleteExceptionCause(@PathVariable Long id) {
        log.debug("REST request to delete ExceptionCause : {}", id);
        exceptionCauseService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/exception-causes?query=:query : search for the exceptionCause corresponding
     * to the query.
     *
     * @param query the query of the exceptionCause search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/exception-causes")
    @Timed
    public ResponseEntity<List<ExceptionCauseDTO>> searchExceptionCauses(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of ExceptionCauses for query {}", query);
        Page<ExceptionCauseDTO> page = exceptionCauseService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/exception-causes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /exception-causes/findByTimeAndImsiAndIndicatorType : get exceptionCauses by date and eci and indicator type.
     *
     * @param exceptionCauseCond the condition of the exceptionCauseDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of exceptionCauses in body
     */
    @GetMapping("/exception-causes/findByTimeAndImsiAndIndicatorType")
    @Timed
    public ResponseEntity<List<ExceptionCauseDTO>> findByTimeAndImsiAndIndicatorType(ExceptionCauseCond exceptionCauseCond) {
        log.debug("REST request to get a page of exceptionCauses : exceptionCauseCond = {}", exceptionCauseCond);
        List<ExceptionCauseDTO> exceptionCauseDTOs = exceptionCauseService.findByDateAndEciAndIndicatorType(exceptionCauseCond);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(exceptionCauseDTOs));
    }
}
