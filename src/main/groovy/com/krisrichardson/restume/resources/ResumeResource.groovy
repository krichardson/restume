package com.krisrichardson.restume.resources

import com.codahale.metrics.annotation.Timed
import com.krisrichardson.restume.api.ResumeDto
import com.krisrichardson.restume.api.ResumeListDto
import com.krisrichardson.restume.api.ResumeWithDetailDto
import com.krisrichardson.restume.core.Resume
import com.krisrichardson.restume.core.converter.EducationConverter
import com.krisrichardson.restume.core.converter.ExperienceConverter
import com.krisrichardson.restume.core.converter.ResumeConverter
import com.krisrichardson.restume.core.converter.SkillConverter
import com.krisrichardson.restume.modules.ResumeModule
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import io.dropwizard.jersey.params.BooleanParam
import io.dropwizard.jersey.params.LongParam

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/resume")
@Api("/resume")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class ResumeResource {

    private ResumeModule resumeModule
    private ResumeConverter resumeConverter

    public ResumeResource(final ResumeModule resumeModule) {
        this.resumeModule = resumeModule
        this.resumeConverter = new ResumeConverter()
    }

    @GET
    @ApiOperation("Get a list of resumes")
    @Timed
    public ResumeListDto list() {
        List<Resume> resumes = resumeModule.listResumes()
        return new ResumeListDto(
                count: resumes.size(),
                resumes: resumes.collect { resumeConverter.convert(it) }
        )
    }

    @GET
    @Path('/{id}')
    @ApiOperation("Get a single resume")
    @Timed
    public ResumeDto getResume(@PathParam('id') LongParam id,
                               @QueryParam('full') BooleanParam full) {

        Boolean fetchFullResume = full?.get()?:false
        Resume resume = resumeModule.getById(id.get(), fetchFullResume)

        if (fetchFullResume) {
            return resumeConverter.convertFull(resume)
        }
        return resumeConverter.convert(resume)

    }

}
