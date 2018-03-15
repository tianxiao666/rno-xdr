package com.hgicreate.rno.repository;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by hadoop on 2017/1/17.
 */
public interface ICellDateRepository<T> {
    List<T> findByCellid(@Param("cellid") long cellid);

    List<T> findByDate(@Param("date") long date);

    List<T> findByDateAndCellid(@Param("date") long date, @Param("cellid") long cellid);

    List<T> findByDateBetweenAndCellid(@Param("beginDate") long beginDate, @Param("endDate") long endDate, @Param("cellid") long cellid);
}
