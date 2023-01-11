package com.membermanagement.Member.Management.repository;

import com.membermanagement.Member.Management.entity.People;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Repository
public interface MemberRepository extends CrudRepository<People, Integer> {
    @Query("SELECT p FROM People p WHERE p.peopleId = :peopleId")
    Optional<People> retrieveMemberByPeopleId(@Param("peopleId") Integer peopleId);

//    @Query("SELECT new com.membermanagement.Member.Management.entity.JobLevel(j.jobLevelId, p) "
//            + "FROM JobLevel j INNER JOIN j.people p")
//    List<People> retrievePeopleById();
}
