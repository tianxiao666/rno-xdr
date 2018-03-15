package com.hgicreate.rno.repository.indicator.brd39;

import com.hgicreate.rno.domain.indicator.brd39.Brd39CellUserDate;
import com.hgicreate.rno.repository.ICellUserDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-brd39-eci-imsi-date")
public interface Brd39CellUserDateRepository extends JpaRepository<Brd39CellUserDate, String>,ICellUserDateRepository<Brd39CellUserDate> {

}
