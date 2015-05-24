package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Education
import com.krisrichardson.restume.core.EducationType
import org.joda.time.LocalDate
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class EducationMapper implements ResultSetMapper<Education> {

    public Education map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Education(
                id: resultSet.getLong('id'),
                resumeId: resultSet.getLong('resume_id'),
                type: Enum.valueOf(EducationType, resultSet.getString('type')),
                institution: resultSet.getString('institution'),
                location: resultSet.getString('location'),
                degree: resultSet.getString('degree'),
                completeDate: new LocalDate(resultSet.getDate('complete_date')),
                summary: resultSet.getString('summary')
        )
    }

}
