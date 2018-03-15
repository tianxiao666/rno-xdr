package com.hgicreate.rno.repository.cause.brd39.pdn;

import com.hgicreate.rno.domain.cause.brd39.pdn.PdnCellDate;
import com.hgicreate.rno.repository.ICellDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-pdn_request_fault-eci-date")
public interface PdnCellDateRepository extends JpaRepository<PdnCellDate, String>, ICellDateRepository<PdnCellDate> {

}
