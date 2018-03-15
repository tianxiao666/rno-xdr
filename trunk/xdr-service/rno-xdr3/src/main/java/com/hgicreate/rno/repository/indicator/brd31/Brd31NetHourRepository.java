package com.hgicreate.rno.repository.indicator.brd31;

import com.hgicreate.rno.domain.indicator.brd31.Brd31NetHour;
import com.hgicreate.rno.repository.INetHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "indicator-brd31-network-hour")
public interface Brd31NetHourRepository extends JpaRepository<Brd31NetHour,String>,INetHourRepository<Brd31NetHour> {
}
