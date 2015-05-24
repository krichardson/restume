package com.krisrichardson.restume.resources

import com.codahale.metrics.annotation.Timed
import com.krisrichardson.restume.api.ExperienceListDto
import com.krisrichardson.restume.core.Experience
import com.krisrichardson.restume.core.converter.ExperienceConverter
import com.krisrichardson.restume.modules.ResumeModule
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.util.logging.Slf4j
import io.dropwizard.jersey.params.LongParam

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/resume/{id}/experience")
@Api("/resume/{id}/experience")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
class ExperienceResource {

    private ResumeModule resumeModule
    private ExperienceConverter experienceConverter

    public ExperienceResource(final ResumeModule resumeModule) {
        this.resumeModule = resumeModule
        this.experienceConverter = new ExperienceConverter()
    }

    @GET
    @ApiOperation("Get a list of experiences for a resume")
    @Timed
    public ExperienceListDto list(@PathParam('id') LongParam id) {
        List<Experience> experiences = resumeModule.listExperienceByResume(id.get())
        return new ExperienceListDto(
                count: experiences.size(),
                experiences: experiences.collect { experienceConverter.convert(it) }
        )
    }

}
