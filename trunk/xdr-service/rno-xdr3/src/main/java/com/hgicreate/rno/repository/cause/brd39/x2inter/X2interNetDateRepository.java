package com.hgicreate.rno.repository.cause.brd39.x2inter;

import com.hgicreate.rno.domain.cause.brd39.x2inter.X2interNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-x2_inter_fault-network-date")
public interface X2interNetDateRepository extends JpaRepository<X2interNetDate, String>, INetDateRepository<X2interNetDate> {

}
