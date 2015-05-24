package com.krisrichardson.restume.modules

import com.krisrichardson.restume.core.Education
import com.krisrichardson.restume.core.Experience
import com.krisrichardson.restume.core.Resume
import com.krisrichardson.restume.core.Skill
import com.krisrichardson.restume.dao.EducationDAO
import com.krisrichardson.restume.dao.ExperienceDAO
import com.krisrichardson.restume.dao.ResumeDAO
import com.krisrichardson.restume.dao.SkillDAO

class ResumeModule {

    private ResumeDAO resumeDAO
    private ExperienceDAO experienceDAO
    private EducationDAO educationDAO
    private SkillDAO skillDAO

    ResumeModule(final ResumeDAO resumeDAO,
                 final ExperienceDAO experienceDAO,
                 final EducationDAO educationDAO,
                 final SkillDAO skillDAO) {
        this.resumeDAO = resumeDAO
        this.experienceDAO = experienceDAO
        this.educationDAO = educationDAO
        this.skillDAO = skillDAO
    }

    List<Resume> listResumes() {
        return resumeDAO.list()
    }

    Resume getById(Long id, Boolean full = false) {
        Resume resume = resumeDAO.findById(id)
        if (full) {
            //Populate the components of the resume
            resume.educationList = educationDAO.findByResumeId(id)
            resume.experienceList = experienceDAO.findByResumeId(id)
            resume.skillList = skillDAO.findByResumeId(id)
        }
        return resume
    }

    List<Experience> listExperienceByResume(Long resumeId) {
        return experienceDAO.findByResumeId(resumeId)
    }

    List<Education> listEducationByResume(Long resumeId) {
        return educationDAO.findByResumeId(resumeId)
    }

    List<Skill> listSkillsByResume(Long resumeId) {
        return skillDAO.findByResumeId(resumeId)
    }

}
