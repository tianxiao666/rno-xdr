package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Interfere;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the Interfere entity.
 */
@SuppressWarnings("unused")
@Repository
public interface InterfereRepository extends JpaRepository<Interfere,Long> {
    List<Interfere> findByTaskId(Long taskId);
    List<Interfere> findByFileId(Long fileId);
}
