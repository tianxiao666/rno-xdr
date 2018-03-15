package com.hgicreate.rno.repository.indicator.uu;

import com.hgicreate.rno.domain.indicator.uu.UuCellUserDate;
import com.hgicreate.rno.repository.ICellUserDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-uu-eci-imsi-date")
public interface UuCellUserDateRepository extends JpaRepository<UuCellUserDate, String>,ICellUserDateRepository<UuCellUserDate> {

}
