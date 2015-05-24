package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Skill
import com.krisrichardson.restume.core.SkillType
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class SkillMapper implements ResultSetMapper<Skill> {

    public Skill map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Skill(
                id: resultSet.getLong('id'),
                resumeId: resultSet.getLong('resume_id'),
                type: Enum.valueOf(SkillType, resultSet.getString('type')),
                name: resultSet.getString('name'),
                description: resultSet.getString('description')
        )
    }

}
