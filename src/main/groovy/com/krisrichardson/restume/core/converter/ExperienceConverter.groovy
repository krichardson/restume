package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.ExperienceDto
import com.krisrichardson.restume.core.Experience

class ExperienceConverter implements DtoConverter<ExperienceDto, Experience> {

    ExperienceDto convert(Experience from) {
        return new ExperienceDto(
                id: from.id,
                title: from.title,
                organization: from.organization,
                fromDate: from.fromDate,
                toDate: from.toDate,
                summary: from.summary
        )
    }

}

