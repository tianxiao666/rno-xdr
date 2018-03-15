package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Record;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the Record entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findByTypeLike(String type);
    Record findByTitle(String title);
}
