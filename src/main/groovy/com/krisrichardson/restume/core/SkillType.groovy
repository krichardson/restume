package com.krisrichardson.restume.core


enum SkillType {
    TECHNICAL('Technical')

    private String label

    SkillType(String label) {
        this.label = label
    }

    String getLabel() {
        return label
    }
}