package com.hgicreate.rno.repository.score;

import com.hgicreate.rno.domain.score.ScoreCellUserDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hadoop on 2017/2/28.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "score_cell_user_date")
public interface ScoreCellUserDateRepository extends JpaRepository<ScoreCellUserDate, String> {
    Page<ScoreCellUserDate> findByDate(@Param("date") long date, Pageable pageable);

    Page<ScoreCellUserDate> findByDateAndImsi(@Param("date") long date, @Param("imsi") long imsi, Pageable pageable);

    Page<ScoreCellUserDate> findByDateAndCellid(@Param("date") long date, @Param("cellid") long cellid, Pageable pageable);
}
