package com.hgicreate.rno.repository.gis.userlonlat;

import com.hgicreate.rno.domain.gis.userlonlat.UserLonLat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by hadoop on 2017/2/10.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "userlonlat")
public interface UserLonLatRepository extends JpaRepository<UserLonLat, String> {
    List<UserLonLat> findByImsi(@Param("imsi") long imsi);

    List<UserLonLat> findByStarttimeAndImsi(@Param("starttime") long starttime, @Param("imsi") long imsi);

    List<UserLonLat> findByStarttimeBetweenAndImsi(@Param("beginTime") long beginTime, @Param("endTime") long endTime, @Param("imsi") long imsi);

//    List<UserLonLat> findByStarttimeBetweenAndImsiAndProceduretype(@Param("beginTime") long beginTime, @Param("endTime") long endTime, @Param("imsi") long imsi, @Param("proceduretype") int proceduretype);
}
