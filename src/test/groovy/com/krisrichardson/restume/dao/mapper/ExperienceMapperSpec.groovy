package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Experience
import org.joda.time.LocalDate
import org.skife.jdbi.v2.StatementContext
import spock.lang.Specification

import java.sql.ResultSet

class ExperienceMapperSpec extends Specification {

    ExperienceMapper mapper

    void setup() {
        mapper = new ExperienceMapper()
    }

    def "Map a Resume result set"() {

        setup:
        Long id = 1
        Long resumeId = 100
        String title = 'Software Engineer'
        String organization = 'Twitter'
        LocalDate fromDate = new LocalDate(2014,1,1)
        LocalDate toDate = new LocalDate(2015, 2, 15)
        String summary = 'Tweeting'
        ResultSet resultSet = Mock()
        StatementContext statementContext = Mock()

        when:
        Experience experience = mapper.map(0, resultSet, statementContext)

        then:
        1 * resultSet.getLong('id') >> id
        1 * resultSet.getLong('resume_id') >> resumeId
        1 * resultSet.getString('title') >> title
        1 * resultSet.getString('organization') >> organization
        1 * resultSet.getDate('from_date') >> new java.sql.Date(fromDate.toDate().time)
        1 * resultSet.getDate('to_date') >> new java.sql.Date(toDate.toDate().time)
        1 * resultSet.getString('summary') >> summary
        0 * _

        assert id == experience.id
        assert resumeId == experience.resumeId
        assert title == experience.title
        assert organization == experience.organization
        assert fromDate == experience.fromDate
        assert toDate == experience.toDate
        assert summary == experience.summary




    }



}
