package com.krisrichardson.restume.api

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.jackson.Jackson
import org.joda.time.DateTime
import spock.lang.Specification

import static io.dropwizard.testing.FixtureHelpers.fixture

class ResumeListDtoSpec extends Specification {

    private ObjectMapper objectMapper


    void setup() {
        objectMapper = Jackson.newObjectMapper()
    }

    def "Serialize to json"() {

        setup:
        String expectedJson = objectMapper.writeValueAsString(
                objectMapper.readValue(fixture("fixtures/resume_list.json"), ResumeListDto))
        ResumeListDto resumeListDto = new ResumeListDto(
                count: 1,
                resumes: [
                        new ResumeDto(
                                id: 1,
                                name: 'Kris Richardson',
                                objective: 'To be the best I can be.',
                                lastUpdated: new DateTime(2015, 5, 24, 15, 22, 29, 817).toDate()
                        )
                ]
        )

        expect: 'Object is serialized to expected json'
        assert expectedJson == objectMapper.writeValueAsString(resumeListDto)

    }
}
