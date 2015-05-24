package com.krisrichardson.restume.core.converter

import com.krisrichardson.restume.api.SkillDto
import com.krisrichardson.restume.core.Skill

class SkillConverter implements DtoConverter<SkillDto, Skill> {

    SkillDto convert(Skill from) {
        return new SkillDto(
                id: from.id,
                type: from.type,
                name: from.name,
                description: from.description
        )
    }

}

