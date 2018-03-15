package com.hgicreate.rno.repository;

import com.hgicreate.rno.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by chao.xj on 2017/5/27.
 */
@RepositoryRestResource(collectionResourceRel = "data",path = "cause-brd39-attach_fault-eci-date")
public interface UserTestRepository extends JpaRepository<UserInfo,Long> {

    UserInfo findByName(String name);

    UserInfo findByNameAndAge(String name, Integer age);

    @Query("from UserInfo u where u.name =:name")
    UserInfo findUser(@Param("name") String name);
}
