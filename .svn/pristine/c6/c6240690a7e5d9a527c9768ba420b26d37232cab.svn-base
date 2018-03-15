package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Solve;

import com.hgicreate.rno.xdr.backend.repository.SolveRepository;
import com.hgicreate.rno.xdr.backend.repository.search.SolveSearchRepository;
import com.hgicreate.rno.xdr.backend.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Solve.
 */
@RestController
@RequestMapping("/api")
public class SolveResource {

    private final Logger log = LoggerFactory.getLogger(SolveResource.class);

    private static final String ENTITY_NAME = "solve";

    private final SolveRepository solveRepository;

    private final SolveSearchRepository solveSearchRepository;

    public SolveResource(SolveRepository solveRepository, SolveSearchRepository solveSearchRepository) {
        this.solveRepository = solveRepository;
        this.solveSearchRepository = solveSearchRepository;
    }

    /**
     * POST  /solves : Create a new solve.
     *
     * @param solve the solve to create
     * @return the ResponseEntity with status 201 (Created) and with body the new solve, or with status 400 (Bad Request) if the solve has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/solves")
    @Timed
    public ResponseEntity<Solve> createSolve(@Valid @RequestBody Solve solve) throws URISyntaxException {
        log.debug("REST request to save Solve : {}", solve);
        if (solve.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new solve cannot already have an ID")).body(null);
        }
        Solve result = solveRepository.save(solve);
        solveSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/solves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /solves : Updates an existing solve.
     *
     * @param solve the solve to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated solve,
     * or with status 400 (Bad Request) if the solve is not valid,
     * or with status 500 (Internal Server Error) if the solve couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/solves")
    @Timed
    public ResponseEntity<Solve> updateSolve(@Valid @RequestBody Solve solve) throws URISyntaxException {
        log.debug("REST request to update Solve : {}", solve);
        if (solve.getId() == null) {
            return createSolve(solve);
        }
        Solve result = solveRepository.save(solve);
        solveSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, solve.getId().toString()))
            .body(result);
    }

    /**
     * GET  /solves : get all the solves.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of solves in body
     */
    @GetMapping("/solves")
    @Timed
    public List<Solve> getAllSolves() {
        log.debug("REST request to get all Solves");
        return solveRepository.findAll();
    }

    /**
     * GET  /solves/:id : get the "id" solve.
     *
     * @param id the id of the solve to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the solve, or with status 404 (Not Found)
     */
    @GetMapping("/solves/{id}")
    @Timed
    public ResponseEntity<Solve> getSolve(@PathVariable Long id) {
        log.debug("REST request to get Solve : {}", id);
        Solve solve = solveRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(solve));
    }

    /**
     * DELETE  /solves/:id : delete the "id" solve.
     *
     * @param id the id of the solve to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/solves/{id}")
    @Timed
    public ResponseEntity<Void> deleteSolve(@PathVariable Long id) {
        log.debug("REST request to delete Solve : {}", id);
        solveRepository.delete(id);
        solveSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/solves?query=:query : search for the solve corresponding
     * to the query.
     *
     * @param query the query of the solve search
     * @return the result of the search
     */
    @GetMapping("/_search/solves")
    @Timed
    public List<Solve> searchSolves(@RequestParam String query) {
        log.debug("REST request to search Solves for query {}", query);
        return StreamSupport
            .stream(solveSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
