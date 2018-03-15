package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.ExceptionStats;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ExceptionStats entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExceptionStatsRepository extends JpaRepository<ExceptionStats,Long> {
    
}
