package com.hgicreate.rno.repository.indicator.x2;

import com.hgicreate.rno.domain.indicator.x2.X2NetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-x2-network-date")
public interface X2NetDateRepository extends JpaRepository<X2NetDate, String>,INetDateRepository<X2NetDate> {
}
