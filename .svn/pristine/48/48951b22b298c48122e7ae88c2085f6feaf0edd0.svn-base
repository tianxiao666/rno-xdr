package com.hgicreate.rno.repository.signalling;

import com.hgicreate.rno.domain.signalling.Signalling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/10.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "signalling")
public interface SignallingRepository extends JpaRepository<Signalling,String> {
    Page<Signalling> findByImsi(@Param("imsi") long imsi, Pageable pageable);
    Page<Signalling> findByStarttimeAndImsi(@Param("starttime") long starttime, @Param("imsi") long imsi, Pageable pageable);
    Page<Signalling> findByStarttimeBetweenAndImsi(@Param("beginTime") long beginTime, @Param("endTime") long endTime, @Param("imsi") long imsi, Pageable pageable);
}
