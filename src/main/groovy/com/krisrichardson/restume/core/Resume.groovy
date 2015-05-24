package com.krisrichardson.restume.core

class Resume {
    Long id
    String name
    String objective
    Date lastUpdated
    List<Experience> experienceList
    List<Education> educationList
    List<Skill> skillList
}
