package com.hgicreate.rno.repository.indicator.uu;

import com.hgicreate.rno.domain.indicator.uu.UuCellHour;
import com.hgicreate.rno.repository.ICellHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-uu-eci-hour")
public interface UuCellHourRepository extends JpaRepository<UuCellHour,String>,ICellHourRepository<UuCellHour> {

}
