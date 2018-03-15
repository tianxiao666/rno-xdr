package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.service.MmeService;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import com.hgicreate.rno.xdr.backend.web.rest.util.PaginationUtil;
import com.hgicreate.rno.xdr.backend.service.dto.MmeDTO;
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
 * REST controller for managing Mme.
 */
@RestController
@RequestMapping("/api")
public class MmeResource {

    private final Logger log = LoggerFactory.getLogger(MmeResource.class);

    private static final String ENTITY_NAME = "mme";

    private final MmeService mmeService;

    public MmeResource(MmeService mmeService) {
        this.mmeService = mmeService;
    }

    /**
     * POST  /mmes : Create a new mme.
     *
     * @param mmeDTO the mmeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new mmeDTO, or with status 400 (Bad Request) if the mme has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/mmes")
    @Timed
    public ResponseEntity<MmeDTO> createMme(@Valid @RequestBody MmeDTO mmeDTO) throws URISyntaxException {
        log.debug("REST request to save Mme : {}", mmeDTO);
        if (mmeDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new mme cannot already have an ID")).body(null);
        }
        MmeDTO result = mmeService.save(mmeDTO);
        return ResponseEntity.created(new URI("/api/mmes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /mmes : Updates an existing mme.
     *
     * @param mmeDTO the mmeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated mmeDTO,
     * or with status 400 (Bad Request) if the mmeDTO is not valid,
     * or with status 500 (Internal Server Error) if the mmeDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/mmes")
    @Timed
    public ResponseEntity<MmeDTO> updateMme(@Valid @RequestBody MmeDTO mmeDTO) throws URISyntaxException {
        log.debug("REST request to update Mme : {}", mmeDTO);
        if (mmeDTO.getId() == null) {
            return createMme(mmeDTO);
        }
        MmeDTO result = mmeService.save(mmeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, mmeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /mmes : get all the mmes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of mmes in body
     */
    @GetMapping("/mmes")
    @Timed
    public ResponseEntity<List<MmeDTO>> getAllMmes(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Mmes");
        Page<MmeDTO> page = mmeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/mmes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /mmes/:id : get the "id" mme.
     *
     * @param id the id of the mmeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the mmeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/mmes/{id}")
    @Timed
    public ResponseEntity<MmeDTO> getMme(@PathVariable Long id) {
        log.debug("REST request to get Mme : {}", id);
        MmeDTO mmeDTO = mmeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(mmeDTO));
    }

    /**
     * DELETE  /mmes/:id : delete the "id" mme.
     *
     * @param id the id of the mmeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/mmes/{id}")
    @Timed
    public ResponseEntity<Void> deleteMme(@PathVariable Long id) {
        log.debug("REST request to delete Mme : {}", id);
        mmeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/mmes?query=:query : search for the mme corresponding
     * to the query.
     *
     * @param query the query of the mme search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/mmes")
    @Timed
    public ResponseEntity<List<MmeDTO>> searchMmes(@RequestParam String query, @ApiParam Pageable pageable) {
        log.debug("REST request to search for a page of Mmes for query {}", query);
        Page<MmeDTO> page = mmeService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/mmes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
