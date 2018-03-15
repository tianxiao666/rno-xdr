package com.hgicreate.rno.xdr.backend.repository.search;

import com.hgicreate.rno.xdr.backend.domain.Solve;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Solve entity.
 */
public interface SolveSearchRepository extends ElasticsearchRepository<Solve, Long> {
}
