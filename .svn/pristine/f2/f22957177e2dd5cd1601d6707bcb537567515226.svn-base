package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Mr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the Mr entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MrRepository extends JpaRepository<Mr,Long> {
    List<Mr> findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour);

    List<Mr> findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String cell);

    List<Mr> findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String imsi);

    List<Mr> findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(LocalDate date, Integer phour);

    List<Mr> findByPdateAndPhourIsNotAndCell(LocalDate date, Integer phour, String cell);

    List<Mr> findByPdateAndPhourIsNotAndImsi(LocalDate date, Integer phour, String imsi);

    Page<Mr> findByPdate(LocalDate date, Pageable pageable);

    Page<Mr> findByPdateAndCell(LocalDate date, String cell, Pageable pageable);

    Page<Mr> findByPdateAndImsi(LocalDate date, String imsi, Pageable pageable);

    List<Mr> findByPdate(LocalDate date);

    List<Mr> findByPdateAndCell(LocalDate date, String cell);

    List<Mr> findByPdateAndImsi(LocalDate date, String imsi);
}
