package com.hgicreate.rno.repository.indicator.uu;

import com.hgicreate.rno.domain.indicator.uu.UuCellDate;
import com.hgicreate.rno.repository.ICellDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-uu-eci-date")
public interface UuCellDateRepository extends JpaRepository<UuCellDate, String>,ICellDateRepository<UuCellDate> {

}
