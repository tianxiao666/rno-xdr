package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Uu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the Uu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UuRepository extends JpaRepository<Uu,Long> {
    List<Uu> findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour);

    List<Uu> findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String cell);

    List<Uu> findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String imsi);

    List<Uu> findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(LocalDate date, Integer phour);

    List<Uu> findByPdateAndPhourIsNotAndCell(LocalDate date, Integer phour, String cell);

    List<Uu> findByPdateAndPhourIsNotAndImsi(LocalDate date, Integer phour, String imsi);

    Page<Uu> findByPdate(LocalDate date, Pageable pageable);

    Page<Uu> findByPdateAndCell(LocalDate date, String cell, Pageable pageable);

    Page<Uu> findByPdateAndImsi(LocalDate date, String imsi, Pageable pageable);

    List<Uu> findByPdate(LocalDate date);

    List<Uu> findByPdateAndCell(LocalDate date, String cell);

    List<Uu> findByPdateAndImsi(LocalDate date, String imsi);
}
