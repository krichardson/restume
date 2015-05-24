package com.krisrichardson.restume.dao

import com.krisrichardson.restume.core.Experience
import com.krisrichardson.restume.dao.mapper.ExperienceMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(ExperienceMapper)
interface ExperienceDAO {

    @SqlQuery("select * from experience where resume_id = :resumeId")
    List<Experience> findByResumeId(@Bind("resumeId") Long resumeId)

}