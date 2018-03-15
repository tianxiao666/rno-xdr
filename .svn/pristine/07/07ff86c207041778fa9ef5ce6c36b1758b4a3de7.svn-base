package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Signalling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the Signalling entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SignallingRepository extends JpaRepository<Signalling,Long> {
    @Query("select t from Signalling t where ((t.startTime between ?1 and ?2) or (t.endTime between ?3 and ?4)) and t.imsi = ?5")
    Page<Signalling> findByStartTimeBetweenOrEndTimeBetweenAndImsi(Long startTime1, Long endTime1, Long startTime2, Long endTime2, Long imsi, Pageable pageable);
    @Query("select t from Signalling t where ((t.startTime between ?1 and ?2) or (t.endTime between ?3 and ?4)) and t.imsi = ?5")
    List<Signalling> findByStartTimeBetweenOrEndTimeBetweenAndImsi(Long beginTime, Long endTime, Long beginTime1, Long endTime1, Long imsi);
}
