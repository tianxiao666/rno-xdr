package com.hgicreate.rno.repository.indicator.brd31;

import com.hgicreate.rno.domain.indicator.brd31.Brd31CellUserDate;
import com.hgicreate.rno.repository.ICellUserDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-brd31-eci-imsi-date")
public interface Brd31CellUserDateRepository extends JpaRepository<Brd31CellUserDate, String>,ICellUserDateRepository<Brd31CellUserDate> {

}
