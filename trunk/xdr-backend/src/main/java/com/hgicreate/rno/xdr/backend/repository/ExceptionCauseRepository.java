package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.ExceptionCause;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the ExceptionCause entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ExceptionCauseRepository extends JpaRepository<ExceptionCause,Long> {
    List<ExceptionCause> findByPdateAndIndicatorTypeAndCellIsNullAndImsiIsNull(LocalDate date, String indicatorType);

    List<ExceptionCause> findByPdateAndCellAndIndicatorType(LocalDate date, Long eci, String indicatorType);

    List<ExceptionCause> findByPdateAndImsiAndIndicatorType(LocalDate date, Long imsi, String indicatorType);
}
