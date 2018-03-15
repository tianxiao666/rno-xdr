package com.hgicreate.rno.repository.indicator.x2;

import com.hgicreate.rno.domain.indicator.x2.X2NetHour;
import com.hgicreate.rno.repository.INetHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-x2-network-hour")
public interface X2NetHourRepository extends JpaRepository<X2NetHour,String>,INetHourRepository<X2NetHour> {
}
