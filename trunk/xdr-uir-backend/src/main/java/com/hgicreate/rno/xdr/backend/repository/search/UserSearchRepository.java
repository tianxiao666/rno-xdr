package com.hgicreate.rno.xdr.backend.repository.search;

import com.hgicreate.rno.xdr.backend.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {
}
