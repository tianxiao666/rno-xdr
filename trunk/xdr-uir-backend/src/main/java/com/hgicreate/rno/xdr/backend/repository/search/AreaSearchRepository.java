package com.hgicreate.rno.xdr.backend.repository.search;

import com.hgicreate.rno.xdr.backend.domain.Area;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Area entity.
 */
public interface AreaSearchRepository extends ElasticsearchRepository<Area, Long> {
}
