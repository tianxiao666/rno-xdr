package com.hgicreate.rno.repository.cause.brd39.csfb;

import com.hgicreate.rno.domain.cause.brd39.csfb.CsfbNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-csfb_fault-network-date")
public interface CsfbNetDateRepository extends JpaRepository<CsfbNetDate, String>, INetDateRepository<CsfbNetDate> {

}
