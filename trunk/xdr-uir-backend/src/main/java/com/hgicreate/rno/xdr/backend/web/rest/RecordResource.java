package com.hgicreate.rno.xdr.backend.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.hgicreate.rno.xdr.backend.domain.Record;

import com.hgicreate.rno.xdr.backend.repository.RecordRepository;
import com.hgicreate.rno.xdr.backend.repository.search.RecordSearchRepository;
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
 * REST controller for managing Record.
 */
@RestController
@RequestMapping("/api")
public class RecordResource {

    private final Logger log = LoggerFactory.getLogger(RecordResource.class);

    private static final String ENTITY_NAME = "record";

    private final RecordRepository recordRepository;

    private final RecordSearchRepository recordSearchRepository;

    public RecordResource(RecordRepository recordRepository, RecordSearchRepository recordSearchRepository) {
        this.recordRepository = recordRepository;
        this.recordSearchRepository = recordSearchRepository;
    }

    /**
     * POST  /records : Create a new record.
     *
     * @param record the record to create
     * @return the ResponseEntity with status 201 (Created) and with body the new record, or with status 400 (Bad Request) if the record has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/records")
    @Timed
    public ResponseEntity<Record> createRecord(@Valid @RequestBody Record record) throws URISyntaxException {
        log.debug("REST request to save Record : {}", record);
        if (record.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new record cannot already have an ID")).body(null);
        }
        Record result = recordRepository.save(record);
        recordSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /records : Updates an existing record.
     *
     * @param record the record to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated record,
     * or with status 400 (Bad Request) if the record is not valid,
     * or with status 500 (Internal Server Error) if the record couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/records")
    @Timed
    public ResponseEntity<Record> updateRecord(@Valid @RequestBody Record record) throws URISyntaxException {
        log.debug("REST request to update Record : {}", record);
        if (record.getId() == null) {
            return createRecord(record);
        }
        Record result = recordRepository.save(record);
        recordSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, record.getId().toString()))
            .body(result);
    }

    /**
     * GET  /records : get all the records.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of records in body
     */
    @GetMapping("/records")
    @Timed
    public List<Record> getAllRecords() {
        log.debug("REST request to get all Records");
        return recordRepository.findAll();
    }

    /**
     * GET  /records/:id : get the "id" record.
     *
     * @param id the id of the record to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the record, or with status 404 (Not Found)
     */
    @GetMapping("/records/{id}")
    @Timed
    public ResponseEntity<Record> getRecord(@PathVariable Long id) {
        log.debug("REST request to get Record : {}", id);
        Record record = recordRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(record));
    }

    /**
     * DELETE  /records/:id : delete the "id" record.
     *
     * @param id the id of the record to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/records/{id}")
    @Timed
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        log.debug("REST request to delete Record : {}", id);
        recordRepository.delete(id);
        recordSearchRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/records?query=:query : search for the record corresponding
     * to the query.
     *
     * @param query the query of the record search
     * @return the result of the search
     */
    @GetMapping("/_search/records")
    @Timed
    public List<Record> searchRecords(@RequestParam String query) {
        log.debug("REST request to search Records for query {}", query);
        return StreamSupport
            .stream(recordSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .collect(Collectors.toList());
    }

}
