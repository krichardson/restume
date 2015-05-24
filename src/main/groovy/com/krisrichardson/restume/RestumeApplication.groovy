package com.krisrichardson.restume

import com.krisrichardson.jdbi.JodaLocalDateArgumentFactory
import com.krisrichardson.jdbi.JodaLocalDateMapper
import com.krisrichardson.restume.dao.EducationDAO
import com.krisrichardson.restume.dao.ExperienceDAO
import com.krisrichardson.restume.dao.ResumeDAO
import com.krisrichardson.restume.dao.SkillDAO
import com.krisrichardson.restume.modules.ResumeModule
import com.krisrichardson.restume.resources.EducationResource
import com.krisrichardson.restume.resources.ExperienceResource
import com.krisrichardson.restume.resources.ResumeResource
import com.krisrichardson.restume.resources.SkillsResource
import io.dropwizard.Application
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.jdbi.DBIFactory
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.federecio.dropwizard.swagger.SwaggerBundle
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration
import org.skife.jdbi.v2.DBI

class RestumeApplication extends Application<RestumeConfiguration> {
    public static void main(String[] args) throws Exception {
        new RestumeApplication().run(args)
    }

    @Override
    public void initialize(Bootstrap<RestumeConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.configurationSourceProvider = new SubstitutingSourceProvider(
                bootstrap.configurationSourceProvider,
                new EnvironmentVariableSubstitutor(false)
        )
        bootstrap.addBundle(new MigrationsBundle<RestumeConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(RestumeConfiguration configuration) {
                return configuration.dataSourceFactory
            }
        })
        bootstrap.addBundle(new SwaggerBundle<RestumeConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RestumeConfiguration configuration) {
                return configuration.swaggerBundleConfiguration
            }
        })
    }

    @Override
    public void run(RestumeConfiguration configuration, Environment environment) {

        final DBIFactory factory = new DBIFactory()
        final DBI jdbi = factory.build(environment, configuration.dataSourceFactory, "db")
        jdbi.registerArgumentFactory(new JodaLocalDateArgumentFactory())
        jdbi.registerMapper(new JodaLocalDateMapper())

        final ResumeDAO resumeDAO = jdbi.onDemand(ResumeDAO)
        final ExperienceDAO experienceDAO = jdbi.onDemand(ExperienceDAO)
        final EducationDAO educationDAO = jdbi.onDemand(EducationDAO)
        final SkillDAO skillDAO = jdbi.onDemand(SkillDAO)

        final ResumeModule resumeModule = new ResumeModule(resumeDAO, experienceDAO, educationDAO, skillDAO)

        environment.jersey().register(new ResumeResource(resumeModule))
        environment.jersey().register(new EducationResource(resumeModule))
        environment.jersey().register(new ExperienceResource(resumeModule))
        environment.jersey().register(new SkillsResource(resumeModule))
    }

}
