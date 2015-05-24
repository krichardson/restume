package com.krisrichardson.restume.resources

import com.codahale.metrics.annotation.Timed
import com.krisrichardson.restume.api.SkillListDto
import com.krisrichardson.restume.core.Skill
import com.krisrichardson.restume.core.converter.SkillConverter
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

@Path("/resume/{id}/skills")
@Api("/resume/{id}/skills")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
class SkillsResource {

    private ResumeModule resumeModule
    private SkillConverter skillConverter

    public SkillsResource(final ResumeModule resumeModule) {
        this.resumeModule = resumeModule
        this.skillConverter = new SkillConverter()
    }

    @GET
    @ApiOperation("Get a list of skills for a resume")
    @Timed
    public SkillListDto list(@PathParam('id') LongParam id) {
        List<Skill> skills = resumeModule.listSkillsByResume(id.get())
        return new SkillListDto(
                count: skills.size(),
                skills: skills.collect { skillConverter.convert(it) }
        )
    }

}
