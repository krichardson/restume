package com.krisrichardson.restume.api

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty
import org.joda.time.LocalDate

import javax.validation.constraints.NotNull

class ExperienceDto {

    @NotNull
    Long id
    @NotEmpty
    String title
    @NotEmpty
    String organization
    @NotNull
    LocalDate fromDate
    @NotNull
    LocalDate toDate
    @NotBlank
    String summary

}
