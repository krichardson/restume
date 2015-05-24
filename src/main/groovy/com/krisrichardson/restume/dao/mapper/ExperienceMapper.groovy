package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Experience
import org.joda.time.LocalDate
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class ExperienceMapper implements ResultSetMapper<Experience> {

    public Experience map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Experience(
                id: resultSet.getLong('id'),
                resumeId: resultSet.getLong('resume_id'),
                title: resultSet.getString('title'),
                organization: resultSet.getString('organization'),
                fromDate: new LocalDate(resultSet.getDate('from_date')),
                toDate: new LocalDate(resultSet.getDate('to_date')),
                summary: resultSet.getString('summary')
        )
    }

}