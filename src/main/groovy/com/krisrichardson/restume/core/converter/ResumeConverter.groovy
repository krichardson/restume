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
                education: from.education.collect { educationConverter.convert(it) },
                experience: from.experience.collect { experienceConverter.convert(it) },
                skills: from.skills.collect { skillConverter.convert(it) }
        )
    }

}

