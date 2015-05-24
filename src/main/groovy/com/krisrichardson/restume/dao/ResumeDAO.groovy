package com.krisrichardson.restume.dao

import com.krisrichardson.restume.core.Resume
import com.krisrichardson.restume.dao.mapper.ResumeMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(ResumeMapper)
interface ResumeDAO {

    @SqlQuery("select * from resume")
    List<Resume> list()

    @SqlQuery("select * from resume where id = :id")
    Resume findById(@Bind("id") Long id)
}
