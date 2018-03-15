package com.hgicreate.rno.repository.exception.brd39;

import com.hgicreate.rno.domain.exception.brd39.Brd39NetHour;
import com.hgicreate.rno.repository.INetHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hadoop on 2016/12/23.
 */
public interface ExBrd39NetHourRepository extends JpaRepository<Brd39NetHour,String>,INetHourRepository<Brd39NetHour> {
}
