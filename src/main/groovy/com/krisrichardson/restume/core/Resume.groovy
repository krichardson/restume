package com.krisrichardson.restume.core

class Resume {
    Long id
    String name
    String objective
    Date lastUpdated
    List<Experience> experience
    List<Education> education
    List<Skill> skills
}
