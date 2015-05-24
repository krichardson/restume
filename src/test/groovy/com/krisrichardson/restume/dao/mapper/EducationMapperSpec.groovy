package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Education
import com.krisrichardson.restume.core.EducationType
import org.joda.time.LocalDate
import org.skife.jdbi.v2.StatementContext
import spock.lang.Specification

import java.sql.ResultSet

class EducationMapperSpec extends Specification {

    EducationMapper mapper

    void setup() {
        mapper = new EducationMapper()
    }

    def "Map a Resume result set"() {

        setup:
        Long id = 1
        Long resumeId = 100
        EducationType type = EducationType.COLLEGE
        String institution = 'University of Minnesota'
        String location = 'Twin Cities, MN'
        String degree = 'Bachelors'
        LocalDate completeDate = new LocalDate(2006, 5, 1)
        String summary = 'Learned stuff'
        ResultSet resultSet = Mock()
        StatementContext statementContext = Mock()

        when:
        Education education = mapper.map(0, resultSet, statementContext)

        then:
        1 * resultSet.getLong('id') >> id
        1 * resultSet.getLong('resume_id') >> resumeId
        1 * resultSet.getString('type') >> type
        1 * resultSet.getString('institution') >> institution
        1 * resultSet.getString('location') >> location
        1 * resultSet.getString('degree') >> degree
        1 * resultSet.getDate('complete_date') >> new java.sql.Date(completeDate.toDate().time)
        1 * resultSet.getString('summary') >> summary
        0 * _

        assert id == education.id
        assert resumeId == education.resumeId
        assert type == education.type
        assert institution == education.institution
        assert location == education.location
        assert degree == education.degree
        assert completeDate == education.completeDate
        assert summary == education.summary



    }



}
