package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Uhttp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the Uhttp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UhttpRepository extends JpaRepository<Uhttp,Long> {
    List<Uhttp> findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour);

    List<Uhttp> findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String cell);

    List<Uhttp> findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String imsi);

    List<Uhttp> findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(LocalDate date, Integer phour);

    List<Uhttp> findByPdateAndPhourIsNotAndCell(LocalDate date, Integer phour, String cell);

    List<Uhttp> findByPdateAndPhourIsNotAndImsi(LocalDate date, Integer phour, String imsi);

    Page<Uhttp> findByPdate(LocalDate date, Pageable pageable);

    Page<Uhttp> findByPdateAndCell(LocalDate date, String cell, Pageable pageable);

    Page<Uhttp> findByPdateAndImsi(LocalDate date, String imsi, Pageable pageable);

    List<Uhttp> findByPdate(LocalDate date);

    List<Uhttp> findByPdateAndCell(LocalDate date, String cell);

    List<Uhttp> findByPdateAndImsi(LocalDate date, String imsi);
}
