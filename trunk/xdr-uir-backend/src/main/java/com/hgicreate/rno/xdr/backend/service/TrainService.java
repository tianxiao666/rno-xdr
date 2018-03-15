package com.hgicreate.rno.xdr.backend.service;

import com.hgicreate.rno.xdr.backend.domain.Record;
import com.hgicreate.rno.xdr.backend.domain.Task;
import com.hgicreate.rno.xdr.backend.repository.RecordRepository;
import com.hgicreate.rno.xdr.backend.repository.TaskRepository;
import com.hgicreate.rno.xdr.backend.repository.search.RecordSearchRepository;
import com.hgicreate.rno.xdr.backend.repository.search.TaskSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yangch on 2017/9/12.
 */
@Service
@Transactional
public class TrainService {

    private final Logger log = LoggerFactory.getLogger(TrainService.class);

    private final TaskRepository taskRepository;

    private final RecordRepository recordRepository;

    private final TaskSearchRepository taskSearchRepository;

    public TrainService(TaskRepository taskRepository,
                        TaskSearchRepository taskSearchRepository,
                        RecordRepository recordRepository){
        this.taskRepository = taskRepository;
        this.taskSearchRepository = taskSearchRepository;
        this.recordRepository = recordRepository;
    }

    public Page<Task> findAll(Pageable pageable) {
        return taskSearchRepository.findAll(pageable);
    }

    public List<Record> findByType(String type){
        return recordRepository.findByTypeLike(type);
    }

    public Page<Task> findByNameAndStatusAndTime(String name,
                                                 String status,
                                                 Instant startTime,
                                                 Instant endTime,
                                                 String type,
                                                 Pageable pageable){
        if(name.trim().equals("")){
            return taskRepository.findByStatusAndStartTimeBetweenAndType(status,startTime,endTime,type,pageable);
        }else{
            return taskRepository.findByNameLikeAndStatusAndStartTimeBetweenAndType(name,status,startTime,endTime,type,pageable);
        }
    }

}
