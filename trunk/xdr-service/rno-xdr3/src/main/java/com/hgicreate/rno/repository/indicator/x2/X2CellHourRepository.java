package com.hgicreate.rno.repository.indicator.x2;

import com.hgicreate.rno.domain.indicator.x2.X2CellHour;
import com.hgicreate.rno.repository.ICellHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-x2-eci-hour")
public interface X2CellHourRepository extends JpaRepository<X2CellHour,String>,ICellHourRepository<X2CellHour> {

}
