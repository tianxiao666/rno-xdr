package com.hgicreate.rno.repository.track;

import com.hgicreate.rno.domain.track.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by hadoop on 2017/2/10.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "track")
public interface TrackRepository extends JpaRepository<Track,String> {
    List<Track> findByImsi(@Param("imsi") long imsi);
    List<Track> findByStarttimeAndImsi(@Param("starttime") long starttime, @Param("imsi") long imsi);
    List<Track> findByStarttimeBetweenAndImsi(@Param("beginTime") long beginTime, @Param("endTime") long endTime, @Param("imsi") long imsi);
    List<Track> findByStarttimeBetweenAndImsiAndProceduretype(@Param("beginTime") long beginTime, @Param("endTime") long endTime, @Param("imsi") long imsi, @Param("proceduretype") int proceduretype);
}
