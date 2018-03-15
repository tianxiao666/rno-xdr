package com.hgicreate.rno.repository.cause.brd39.s1inter;

import com.hgicreate.rno.domain.cause.brd39.s1inter.S1interCellDate;
import com.hgicreate.rno.repository.ICellDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/6.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-s1_inter_fault-eci-date")
public interface S1interCellDateRepository extends JpaRepository<S1interCellDate, String>, ICellDateRepository<S1interCellDate> {

}
