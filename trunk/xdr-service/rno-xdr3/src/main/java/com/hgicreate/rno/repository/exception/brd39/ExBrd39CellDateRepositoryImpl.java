package com.hgicreate.rno.repository.exception.brd39;

import com.hgicreate.rno.domain.exception.brd39.Brd39CellDate;
import com.hgicreate.rno.repository.IFindByQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Created by hadoop on 2016/12/23.
 */
public class ExBrd39CellDateRepositoryImpl implements IFindByQuery<Brd39CellDate> {
   /* private MongoOperations mongoOperations;
    private MongoTemplate mongoTemplate;*/

    /*public ExBrd39CellDateRepositoryImpl(MongoOperations mongoOperations, MongoTemplate mongoTemplate) {
        this.mongoOperations = mongoOperations;
        this.mongoTemplate = mongoTemplate;
    }*/

    @Override
    public Page<Brd39CellDate> findDbByQuery(String query, Pageable pageable) {
       /* System.out.println(query);
        Query query1 = new BasicQuery(query);

        List<Brd39CellDate> list= this.mongoTemplate.find(query1.with(pageable), Brd39CellDate.class);
        Long count =  this.mongoTemplate.count(query1,Brd39CellDate.class);
        return new PageImpl<Brd39CellDate>(list, pageable, count);*/

        return null;
    }
}
