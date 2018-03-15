package com.hgicreate.rno.repository.score;

import com.hgicreate.rno.domain.score.ScoreCellDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by chan on 17-3-2.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "score_cell_date")
public interface ScoreCellDateRepository extends JpaRepository<ScoreCellDate,String> {
    Page<ScoreCellDate> findByDate(@Param("date") long date, Pageable pageable);
    Page<ScoreCellDate> findByDateAndCellid(@Param("date") long date, @Param("cellid") long cellid, Pageable pageable);

}
