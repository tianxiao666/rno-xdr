package com.hgicreate.rno.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

/**
 * Created by hadoop on 2017/1/17.
 */
public interface ICellUserDateRepository<T> {
    Page<T> findByDate(@Param("date") long date, Pageable pageable);

    Page<T> findByDateAndCellid(@Param("date") long date, @Param("cellid") long cellid, Pageable pageable);

    Page<T> findByDateAndImsi(@Param("date") long date, @Param("imsi") long imsi, Pageable pageable);
}
