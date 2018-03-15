package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Mme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the Mme entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MmeRepository extends JpaRepository<Mme,Long> {
    List<Mme> findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Long phour);

    List<Mme> findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Long phour, String cell);

    List<Mme> findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(LocalDate beginDate, LocalDate endDate, Long phour, String imsi);

    List<Mme> findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(LocalDate date, Long phour);

    List<Mme> findByPdateAndPhourIsNotAndCell(LocalDate date, Long phour, String cell);

    List<Mme> findByPdateAndPhourIsNotAndImsi(LocalDate date, Long phour, String imsi);

    Page<Mme> findByPdate(LocalDate date, Pageable pageable);

    Page<Mme> findByPdateAndCell(LocalDate date, String cell, Pageable pageable);

    Page<Mme> findByPdateAndImsi(LocalDate date, String imsi, Pageable pageable);

    List<Mme> findByPdate(LocalDate date);

    List<Mme> findByPdateAndCell(LocalDate date, String cell);

    List<Mme> findByPdateAndImsi(LocalDate date, String imsi);
}
