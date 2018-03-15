package com.hgicreate.rno.repository.indicator.mr;

import com.hgicreate.rno.domain.indicator.mr.MrNetDate;
import com.hgicreate.rno.repository.INetDateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hadoop on 2016/12/23.
 */
public interface MrNetDateRepository extends JpaRepository<MrNetDate, String>,INetDateRepository<MrNetDate> {

}
