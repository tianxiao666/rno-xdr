package com.hgicreate.rno.repository;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by hadoop on 2017/1/17.
 */
public interface ICellHourRepository<T> {
    List<T> findByDate(@Param("date") long date);
    List<T> findByCellid(@Param("cellid") long cellid);
    List<T> findByDateAndCellid(@Param("date") long date, @Param("cellid") long cellid);
}
