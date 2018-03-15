package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Track;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the Track entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
    @Query("select t from Track t where ((t.startTime between ?1 and ?2) or (t.endTime between ?3 and ?4)) and t.imsi = ?5 and t.indicatorType = ?6")
    List<Track> findByStartTimeBetweenOrEndTimeBetweenAndImsiAndIndicatorType(Long startTime1, Long endTime1, Long startTime2, Long endTime2, Long imsi, String indicatorType);
}
