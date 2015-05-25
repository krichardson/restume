package com.krisrichardson.restume.api

import org.joda.time.DateTime

import static io.dropwizard.testing.FixtureHelpers.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.krisrichardson.restume.core.EducationType
import com.krisrichardson.restume.core.SkillType
import io.dropwizard.jackson.Jackson
import org.joda.time.LocalDate
import spock.lang.Specification

class ResumeWithDetailsDtoSpec extends Specification {

    private ObjectMapper objectMapper


    void setup() {
        objectMapper = Jackson.newObjectMapper()
    }

    def "Serialize to json"() {

        setup:
        String expectedJson = objectMapper.writeValueAsString(
                objectMapper.readValue(fixture("fixtures/resume_full.json"), ResumeWithDetailDto))
        ResumeWithDetailDto resumeWithDetailDto = new ResumeWithDetailDto(
                id: 1,
                name: 'Kris Richardson',
                objective: 'To be the best I can be.',
                lastUpdated: new DateTime(2015, 5, 24, 15, 22, 29, 817).toDate(),
                education: [
                        new EducationDto(
                                id: 1,
                                type: EducationType.COLLEGE,
                                degree: 'Bachelors',
                                institution: 'University of Minnesota',
                                location: 'Twin Cities, MN',
                                completeDate: new LocalDate(2006, 5, 1),
                                summary: 'Learned some stuff'
                        )
                ],
                experience: [
                        new ExperienceDto(
                                id: 1,
                                title: 'Internal Systems Developer',
                                organization: 'JobDig',
                                fromDate: new LocalDate(2006, 7, 1),
                                toDate: new LocalDate(2008, 1, 1),
                                summary: "Writing code"
                        ),
                        new ExperienceDto(
                                id: 2,
                                title: 'Senior Software Engineer',
                                organization: 'Internet Broadcasting',
                                fromDate: new LocalDate(2008, 1, 1),
                                toDate: new LocalDate(2013, 2, 1),
                                summary: "Writing more code"
                        )
                ],
                skills: [
                        new SkillDto(
                                id: 1,
                                type: SkillType.TECHNICAL,
                                name: 'Java',
                                description: '5 years'
                        ),
                        new SkillDto(
                                id: 2,
                                type: SkillType.TECHNICAL,
                                name: 'Groovy',
                                description: '5 years'
                        )
                ]

        )

        expect: 'Object is serialized to expected json'
        assert expectedJson == objectMapper.writeValueAsString(resumeWithDetailDto)

    }

}
