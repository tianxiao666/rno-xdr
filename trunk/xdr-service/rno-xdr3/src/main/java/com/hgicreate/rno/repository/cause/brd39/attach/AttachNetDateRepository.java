package com.hgicreate.rno.repository.cause.brd39.attach;

import com.hgicreate.rno.domain.cause.brd39.attach.AttachNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-attach_fault-network-date")
public interface AttachNetDateRepository extends JpaRepository<AttachNetDate, String>, INetDateRepository<AttachNetDate> {

}
