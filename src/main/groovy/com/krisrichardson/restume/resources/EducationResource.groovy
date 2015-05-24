package com.krisrichardson.restume.resources

import com.codahale.metrics.annotation.Timed
import com.krisrichardson.restume.api.EducationListDto
import com.krisrichardson.restume.core.Education
import com.krisrichardson.restume.core.converter.EducationConverter
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

@Path("/resume/{id}/education")
@Api("/resume/{id}/education")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
class EducationResource {

    private ResumeModule resumeModule
    private EducationConverter educationConverter

    public EducationResource(final ResumeModule resumeModule) {
        this.resumeModule = resumeModule
        this.educationConverter = new EducationConverter()
    }

    @GET
    @ApiOperation("Get a list of experiences for a resume")
    @Timed
    public EducationListDto list(@PathParam('id') LongParam id) {
        List<Education> educations = resumeModule.listEducationByResume(id.get())
        return new EducationListDto(
                count: educations.size(),
                educations: educations.collect { educationConverter.convert(it)  }
        )
    }

}
