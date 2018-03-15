package com.hgicreate.rno.repository.cause.brd39.s1inter;

import com.hgicreate.rno.domain.cause.brd39.s1inter.S1interNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-s1_inter_fault-network-date")
public interface S1interNetDateRepository extends JpaRepository<S1interNetDate, String>, INetDateRepository<S1interNetDate> {

}
