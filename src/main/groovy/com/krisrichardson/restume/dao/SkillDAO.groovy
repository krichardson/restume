package com.krisrichardson.restume.dao

import com.krisrichardson.restume.core.Skill
import com.krisrichardson.restume.dao.mapper.SkillMapper
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper

@RegisterMapper(SkillMapper)
interface SkillDAO {

    @SqlQuery("select * from skill where resume_id = :resumeId")
    List<Skill> findByResumeId(@Bind("resumeId") Long resumeId)

}