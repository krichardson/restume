package com.krisrichardson.restume.core

import org.joda.time.LocalDate

class Education {
    Long id
    Long resumeId
    EducationType type
    String institution
    String location
    String degree
    LocalDate completeDate
    String summary
}
