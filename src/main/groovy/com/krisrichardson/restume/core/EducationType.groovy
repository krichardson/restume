package com.krisrichardson.restume.core


enum EducationType {
    HIGH_SCHOOL('High School'),
    COLLEGE('College')

    private String label

    EducationType(String label) {
        this.label = label
    }

    String getLabel() {
        return label
    }
}