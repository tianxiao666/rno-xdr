package com.hgicreate.rno.repository.exception.brd39;

import com.hgicreate.rno.domain.exception.brd39.Brd39CellHour;
import com.hgicreate.rno.repository.ICellHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hadoop on 2016/12/23.
 */
public interface ExBrd39CellHourRepository extends JpaRepository<Brd39CellHour,String>,ICellHourRepository<Brd39CellHour> {

}
