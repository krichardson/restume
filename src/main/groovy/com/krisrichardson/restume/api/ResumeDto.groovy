package com.krisrichardson.restume.api

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.constraints.NotNull

class ResumeDto {
    @NotNull
    Long id
    @NotEmpty
    String name
    @NotBlank
    String objective
    Date lastUpdated
}
