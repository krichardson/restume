package com.krisrichardson.restume.core

import org.joda.time.LocalDate

class Experience {
    Long id
    Long resumeId
    String title
    String organization
    LocalDate fromDate
    LocalDate toDate
    String summary
}
