package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.X2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data JPA repository for the X2 entity.
 */
@SuppressWarnings("unused")
@Repository
public interface X2Repository extends JpaRepository<X2,Long> {
    List<X2> findByPdateBetweenAndPhourAndCellIsNullAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour);

    List<X2> findByPdateBetweenAndPhourAndCellAndImsiIsNullOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String cell);

    List<X2> findByPdateBetweenAndPhourAndCellIsNullAndImsiOrderByPdate(LocalDate beginDate, LocalDate endDate, Integer phour, String imsi);

    List<X2> findByPdateAndPhourIsNotAndCellIsNullAndImsiIsNull(LocalDate date, Integer phour);

    List<X2> findByPdateAndPhourIsNotAndCell(LocalDate date, Integer phour, String cell);

    List<X2> findByPdateAndPhourIsNotAndImsi(LocalDate date, Integer phour, String imsi);

    Page<X2> findByPdate(LocalDate date, Pageable pageable);

    Page<X2> findByPdateAndCell(LocalDate date, String cell, Pageable pageable);

    Page<X2> findByPdateAndImsi(LocalDate date, String imsi, Pageable pageable);

    List<X2> findByPdate(LocalDate date);

    List<X2> findByPdateAndCell(LocalDate date, String cell);

    List<X2> findByPdateAndImsi(LocalDate date, String imsi);
}
