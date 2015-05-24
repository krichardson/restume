package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Resume
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

import java.sql.ResultSet
import java.sql.SQLException

class ResumeMapper implements ResultSetMapper<Resume> {

    public Resume map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Resume(
                id: resultSet.getLong('id'),
                name: resultSet.getString('name'),
                objective: resultSet.getString('objective'),
                lastUpdated: resultSet.getTimestamp('last_updated')
        )
    }

}
