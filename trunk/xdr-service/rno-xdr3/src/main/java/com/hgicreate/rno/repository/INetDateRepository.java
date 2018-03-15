package com.hgicreate.rno.repository;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by hadoop on 2017/1/17.
 */
public interface INetDateRepository<T> {
    List<T> findByDate(@Param("date") long date);
    List<T> findByDateBetween(@Param("beginDate") long beginDate, @Param("endDate") long endDate);
}
