package com.hgicreate.rno.xdr.backend.repository;

import com.hgicreate.rno.xdr.backend.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.Instant;
import java.time.ZonedDateTime;


/**
 * Spring Data JPA repository for the Task entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Page<Task> findByNameLikeAndStatusAndStartTimeBetweenAndType(String name,
                                                         String status,
                                                         Instant startTime,
                                                         Instant endTime,
                                                         String type,
                                                         Pageable pageable);

    Page<Task> findByStatusAndStartTimeBetweenAndType(String status,
                                                      Instant startTime,
                                                      Instant endTime,
                                                      String type,
                                                      Pageable pageable);
}
