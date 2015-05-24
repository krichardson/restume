package com.krisrichardson.restume.api

import com.krisrichardson.restume.core.SkillType
import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.NotNull

class SkillDto {

    @NotNull
    Long id
    @NotNull
    SkillType type
    @NotEmpty
    String name
    @NotBlank
    String description

}
