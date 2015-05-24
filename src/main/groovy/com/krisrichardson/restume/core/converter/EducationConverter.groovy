package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.EducationDto
import com.krisrichardson.restume.core.Education

class EducationConverter implements DtoConverter<EducationDto, Education> {

    EducationDto convert(Education from) {
        return new EducationDto(
                id: from.id,
                type: from.type,
                institution: from.institution,
                location: from.location,
                degree: from.degree,
                completeDate: from.completeDate,
                summary: from.summary,

        )
    }

}

