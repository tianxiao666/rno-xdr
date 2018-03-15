package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Interfere;

import com.hgicreate.rno.xdr.backend.repository.InterfereRepository;
import com.hgicreate.rno.xdr.backend.repository.search.InterfereSearchRepository;
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
 * REST controller for managing Interfere.
 */
@RestController
@RequestMapping("/api")
public class InterfereResource {

    private final Logger log = LoggerFactory.getLogger(InterfereResource.class);

    private static final String ENTITY_NAME = "interfere";

    private final InterfereRepository interfereRepository;

    private final InterfereSearchRepository interfereSearchRepository;

    public InterfereResource(InterfereRepository interfereRepository, InterfereSearchRepository interfereSearchRepository) {
        this.interfereRepository = interfereRepository;
        this.interfereSearchRepository = interfereSearchRepository;
    }

    /**
     * POST  /interferes : Create a new interfere.
     *
     * @param interfere the interfere to create
     * @return the ResponseEntity with status 201 (Created) and with body the new interfere, or with status 400 (Bad Request) if the interfere has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/interferes")
    @Timed
    public ResponseEntity<Interfere> createInterfere(@Valid @RequestBody Interfere interfere) throws URISyntaxException {
        log.debug("REST request to save Interfere : {}", interfere);
        if (interfere.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new interfere cannot already have an ID")).body(null);
        }
        Interfere result = interfereRepository.save(interfere);
        interfereSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/interferes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /interferes : Updates an existing interfere.
     *
     * @param interfere the interfere to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated interfere,
     * or with status 400 (Bad Request) if the interfere is not valid,
     * or with status 500 (Internal Server Error) if the interfere couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/interferes")
    @Timed
    public ResponseEntity<Interfere> updateInterfere(@Valid @RequestBody Interfere interfere) throws URISyntaxException {
        log.debug("REST request to update Interfere : {}", interfere);
        if (interfere.getId() == null) {
            return createInterfere(interfere);
        }
        Interfere result = interfereRepository.save(interfere);
        interfereSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, interfere.getId().toString()))
            .body(result);
    }

    /**
     * GET  /interferes : get all the interferes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of interferes in body
     */
    @GetMapping("/interferes")
    @Timed
    public List<Interfere> getAllInterferes() {
        log.debug("REST request to get all Interferes");
        return interfereRepository.findAll();
    }

    /**
     * GET  /interferes/:id : get the "id" interfere.
     *
     * @param id the id of the interfere to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the interfere, or with status 404 (Not Found)
     */
    @GetMapping("/interferes/{id}")
    @Timed
    public ResponseEntity<Interfere> getInterfere(@PathVariable Long id) {
        log.debug("REST request to get Interfere : {}", id);
        Interfere interfere = interfereRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(interfere));
    }

    /**
     * DELETE  /interferes/:id : delete the "id" interfere.
     *
     * @param id the id of the interfere to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/interferes/{id}")
    @Timed
    public ResponseEntity<Void> deleteInterfere(@PathVariable Long id) {
        log.debug("REST request to delete Interfere : {}", id);
        interfereRepository.delete(id);
        interfereSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/interferes?query=:query : search for the interfere corresponding
     * to the query.
     *
     * @param query the query of the interfere search
     * @return the result of the search
     */
    @GetMapping("/_search/interferes")
    @Timed
    public List<Interfere> searchInterferes(@RequestParam String query) {
        log.debug("REST request to search Interferes for query {}", query);
        return StreamSupport
            .stream(interfereSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
