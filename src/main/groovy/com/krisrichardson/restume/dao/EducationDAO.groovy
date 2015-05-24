package com.krisrichardson.restume.dao

import com.krisrichardson.restume.core.Education
import com.krisrichardson.restume.dao.mapper.EducationMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(EducationMapper)
interface EducationDAO {

    @SqlQuery("select * from education where resume_id = :resumeId")
    List<Education> findByResumeId(@Bind("resumeId") Long resumeId)

}