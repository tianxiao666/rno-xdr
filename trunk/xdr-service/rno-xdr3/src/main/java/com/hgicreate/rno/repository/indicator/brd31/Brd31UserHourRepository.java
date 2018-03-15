package com.hgicreate.rno.repository.indicator.brd31;

import com.hgicreate.rno.domain.indicator.brd31.Brd31UserHour;
import com.hgicreate.rno.repository.IUserHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-brd31-imsi-hour")
public interface Brd31UserHourRepository extends JpaRepository<Brd31UserHour,String>,IUserHourRepository<Brd31UserHour> {

}