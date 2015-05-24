package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.ResumeDto
import com.krisrichardson.restume.core.Resume
import spock.lang.Specification

class ResumeConverterSpec extends Specification {

    def "convert Resume to ResumeDto"() {

        setup:
        Resume resume = buildResume()

        when:
        ResumeDto resumeDto = new ResumeConverter().convert(resume)

        then:
        assert resumeDto.id == resume.id
        assert resumeDto.name == resume.name
        assert resumeDto.objective == resume.objective
        assert resumeDto.lastUpdated == resume.lastUpdated

    }

    private buildResume() {
        return new Resume(
                id: 1,
                name: 'Kris Richardson',
                objective: 'To do great stuff',
                lastUpdated: new Date()
        )
    }


}
