package com.hgicreate.rno.repository.indicator.uu;

import com.hgicreate.rno.domain.indicator.uu.UuUserDate;
import com.hgicreate.rno.repository.IUserDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2016/12/23.
 */
@RepositoryRestResource(collectionResourceRel = "data", path = "indicator-uu-imsi-date")
public interface UuUserDateRepository extends JpaRepository<UuUserDate, String>,IUserDateRepository<UuUserDate> {

}
