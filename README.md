# Restume

## About

What better resume than a real-life application that shows off my actual work, right? That's what this
project is. In case you like good old fashioned resume information, then this application can serve up
that information.

I've built this using the tools and techniques I'm interested in at the moment:

* Groovy
* Gradle
* Dropwizard REST framework
* Spock for Testing
* PostgreSQL database
* Swagger for endpoint documentation and exploration
* Docker
    
## Developer getting Started

### Build the application

Use the provided gradle wrapper to build a fat jar

    > ./gradlew shadowJar

### Setup the database

Before running the app for the first time, you'll need to set up the
database schema

1. Create an empty PostgreSQL database
2. Update config.yml to reference your postgres instance and rebuild the application
    
    > ./gradlew shadowJar
    
3. Run the database migrations

    > java -jar build/libs/restume-1.0.0-SNAPSHOT-all.jar db migrate build/resources/main/config.yml

### Run the application

With gradle

    > ./gradlew run
    
With java

    > java -jar build/libs/restume-1.0.0-SNAPSHOT-all.jar server build/resources/main/config.yml
    
### Environment specific overrides

You can override any config by passing a java system property when running

    > java
        -Ddw.database.url=jdbc:postgresql://proddb/restume \
        -Ddw.database.user=produser \
        -Ddw.database.password=secret \    
        -jar build/libs/restume-1.0.0-SNAPSHOT-all.jar server build/resources/main/config.yml
