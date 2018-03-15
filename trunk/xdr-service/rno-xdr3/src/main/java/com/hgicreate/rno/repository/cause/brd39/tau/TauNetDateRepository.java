package com.hgicreate.rno.repository.cause.brd39.tau;

import com.hgicreate.rno.domain.cause.brd39.tau.TauNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-tau_fault-network-date")
public interface TauNetDateRepository extends JpaRepository<TauNetDate, String>, INetDateRepository<TauNetDate> {

}
