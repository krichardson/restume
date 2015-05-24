package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.ResumeDto
import com.krisrichardson.restume.api.ResumeWithDetailDto
import com.krisrichardson.restume.core.Resume

class ResumeConverter implements DtoConverter<ResumeDto, Resume> {

    private EducationConverter educationConverter = new EducationConverter()
    private ExperienceConverter experienceConverter = new ExperienceConverter()
    private SkillConverter skillConverter = new SkillConverter()

    ResumeDto convert(Resume from) {
        return new ResumeDto(
                id: from.id,
                name: from.name,
                objective: from.objective,
                lastUpdated: from.lastUpdated
        )
    }

    ResumeWithDetailDto convertFull(Resume from) {
        return new ResumeWithDetailDto(
                id: from.id,
                name: from.name,
                objective: from.objective,
                lastUpdated: from.lastUpdated,
                educationList: from.educationList.collect { educationConverter.convert(it) },
                experienceList: from.experienceList.collect { experienceConverter.convert(it) },
                skillList: from.skillList.collect { skillConverter.convert(it) }
        )
    }

}

