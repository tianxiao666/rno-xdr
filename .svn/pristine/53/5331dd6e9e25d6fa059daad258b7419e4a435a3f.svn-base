package com.hgicreate.rno.repository;

import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by hadoop on 2017/1/17.
 */
public interface IUserDateRepository<T> {
    List<T> findByDateAndImsi(@Param("date") long date, @Param("imsi") long imsi);

    List<T> findByDateBetweenAndImsi(@Param("beginDate") long beginDate, @Param("endDate") long endDate, @Param("imsi") long imsi);
}
