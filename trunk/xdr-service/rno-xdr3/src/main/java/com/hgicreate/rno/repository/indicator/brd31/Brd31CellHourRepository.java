package com.hgicreate.rno.repository.indicator.brd31;

import com.hgicreate.rno.domain.indicator.brd31.Brd31CellHour;
import com.hgicreate.rno.repository.ICellHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-brd31-eci-hour")
public interface Brd31CellHourRepository extends JpaRepository<Brd31CellHour,String>,ICellHourRepository<Brd31CellHour> {

}
