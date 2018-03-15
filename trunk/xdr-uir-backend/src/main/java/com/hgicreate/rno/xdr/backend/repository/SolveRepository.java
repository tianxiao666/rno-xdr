package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Solve;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Solve entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SolveRepository extends JpaRepository<Solve,Long> {
    
}
