package com.hgicreate.rno.repository.indicator.uu;

import com.hgicreate.rno.domain.indicator.uu.UuNetHour;
import com.hgicreate.rno.repository.INetHourRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-uu-network-hour")
public interface UuNetHourRepository extends JpaRepository<UuNetHour,String>,INetHourRepository<UuNetHour> {
}