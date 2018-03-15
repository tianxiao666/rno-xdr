package com.hgicreate.rno.repository.indicator.brd39;

import com.hgicreate.rno.domain.indicator.brd39.Brd39UserHour;
import com.hgicreate.rno.repository.IUserHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-brd39-imsi-hour")
public interface Brd39UserHourRepository extends JpaRepository<Brd39UserHour,String>,IUserHourRepository<Brd39UserHour> {

}
