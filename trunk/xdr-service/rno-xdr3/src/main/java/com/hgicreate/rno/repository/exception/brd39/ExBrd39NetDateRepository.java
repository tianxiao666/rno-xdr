package com.hgicreate.rno.repository.exception.brd39;

import com.hgicreate.rno.domain.exception.brd39.Brd39NetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hadoop on 2016/12/23.
 */
public interface ExBrd39NetDateRepository extends JpaRepository<Brd39NetDate, String>,INetDateRepository<Brd39NetDate> {

}
