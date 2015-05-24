package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Resume
import org.skife.jdbi.v2.StatementContext
import spock.lang.Specification

import java.sql.ResultSet
import java.sql.Timestamp

class ResumeMapperSpec extends Specification {

    ResumeMapper mapper

    void setup() {
        mapper = new ResumeMapper()
    }

    def "Map a Resume result set"() {

        setup:
        Long id = 1
        String name = 'Kris Richardson'
        String objective = 'To be the best I can be.'
        Timestamp lastUpdated = new Timestamp(2015, 5, 24, 10, 20, 30, 5)
        ResultSet resultSet = Mock()
        StatementContext statementContext = Mock()

        when:
        Resume resume = mapper.map(0, resultSet, statementContext)

        then:
        1 * resultSet.getLong('id') >> id
        1 * resultSet.getString('name') >> name
        1 * resultSet.getString('objective') >> objective
        1 * resultSet.getTimestamp('last_updated') >> lastUpdated
        0 * _

        assert id == resume.id
        assert name == resume.name
        assert objective == resume.objective
        assert lastUpdated == resume.lastUpdated


    }



}
