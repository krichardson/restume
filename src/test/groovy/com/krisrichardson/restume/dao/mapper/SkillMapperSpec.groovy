package com.krisrichardson.restume.dao.mapper

import com.krisrichardson.restume.core.Skill
import com.krisrichardson.restume.core.SkillType
import org.skife.jdbi.v2.StatementContext
import spock.lang.Specification

import java.sql.ResultSet
import java.sql.Timestamp

class SkillMapperSpec extends Specification {

    SkillMapper mapper

    void setup() {
        mapper = new SkillMapper()
    }

    def "Map a Resume result set"() {

        setup:
        Long id = 1
        Long resumeId = 100
        SkillType type = SkillType.TECHNICAL
        String name = 'Java'
        String description = 'Pretty good'
        ResultSet resultSet = Mock()
        StatementContext statementContext = Mock()

        when:
        Skill skill = mapper.map(0, resultSet, statementContext)

        then:
        1 * resultSet.getLong('id') >> id
        1 * resultSet.getLong('resume_id') >> resumeId
        1 * resultSet.getString('type') >> type
        1 * resultSet.getString('name') >> name
        1 * resultSet.getString('description') >> description
        0 * _

        assert id == skill.id
        assert resumeId == skill.resumeId
        assert type == skill.type
        assert name == skill.name
        assert description == skill.description


    }



}
