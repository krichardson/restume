package com.krisrichardson.restume.api

import com.krisrichardson.restume.core.EducationType
import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.LocalDate

import javax.validation.constraints.NotNull

class EducationDto {

    @NotNull
    Long id
    @NotNull
    EducationType type
    @NotEmpty
    String institution
    @NotBlank
    String location
    @NotBlank
    String degree
    LocalDate completeDate
    @NotBlank
    String summary

}
