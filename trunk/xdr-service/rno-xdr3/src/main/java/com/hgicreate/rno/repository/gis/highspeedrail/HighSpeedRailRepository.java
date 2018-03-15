package com.hgicreate.rno.repository.gis.highspeedrail;

import com.hgicreate.rno.domain.gis.highspeedrail.HighSpeedRail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by hadoop on 2017/2/23.
 */
@RepositoryRestResource(path = "highspeedrail")
public interface HighSpeedRailRepository extends JpaRepository<HighSpeedRail, String> {
    List<HighSpeedRail> findByDate(@Param("date") Long date);
}
