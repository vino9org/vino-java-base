# Base POM for Vino Microservice

This repository will publish 2 pom.xml for use in vino project:

1. ```vino-bom``` which is the Bill of Material(BOM) POM for the project. It contains only dependency management directives to centrally manage the dependency versions.
2. ```vino-svc-parent``` the parent POM for a microservice. It will import the bom pom from above, as well as setting . The goal is to simplify configuration needed in each microservice and reduce the duplicate configuration in each microservice pom.
3. The module ```vino-demo-svc``` is for testing only, the artifact will not be published to a repository server/registry.

__The modules here will use strict semantic versioning__. No SNAPSHOT versions will be release nor should it be used in other modules.

## Features

### API endpoints
* [X] REST endpoint using SpringMVC
* [X] [Netflix DGS framework](https://netflix.github.io/dgs/) for GraphQL endpoint with sample schema and data fetcher
* [X] DSG extension for [Relay pagination](https://netflix.github.io/dgs/advanced/relay-pagination/) support

### Database Access and Caching
* [X] [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) repository with [embedded MongoDB](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo) for testing
* [X] [ModelMapper](https://modelmapper.org/) for Java bean mapping
* [X] [Spring Data JPA](https://spring.io/projects/spring-data-jpa) support for PostgreSQL and MySQL. Use H2 as embedded database for testing.
* [X] [Flyway](https://flywaydb.org/) for relational database migration.
* [X] Spring Cache support with Redis binding. Includes [jdeis mock](https://github.com/fppt/jedis-mock) for unit tests

### Security
* [ ] JWT token validation with Spring Security

### Devops related
* [X] Generate K8S manifest and configuration for [Skaffold](https://skaffold.dev/) to do local development in cluster
* [X] [Git commit id](https://github.com/git-commit-id/git-commit-id-maven-plugin) exposed in Actuator Info endpoint
* [X] Expose other configuration properties, e.g. jvm, in Actuator Info endpoint
* [X] Create multi-arch (x64/arm64) container image using Google [JIB](https://cloud.google.com/java/getting-started/jib) maven plugin
* [X] Code coverage using [Jacoco](https://www.jacoco.org/jacoco/trunk/index.html)
* [X] [jQAssistant](https://jqassistant.org/) for code quality analysis
* [X] [ArchUnit](https://www.archunit.org/) support by [arch-unit-maven-plugin](https://github.com/societe-generale/arch-unit-maven-plugin)
* [X] [Spotless](https://github.com/diffplug/spotless/tree/main/plugin-maven) maven plugin for code formatting

## Why not ....
* Reactive - not a fan. With virtual threads coming in Java 17, most developers don't need to worry about the complexity of reactive programming.
* Spring Cloud - too much complexity for a simple microservice. We can always add it later if needed.
* Other databases, JooQ, JDBC etc. - Good ideas but currently I don't have use cases for them. The developers I work with are more familiar with Spring Data.
* Other bean mappers, e.g. mapstruct. etc - Hm... I haven't seen any need for any of those. ModelMapper is good enough for now.

## Notes on QA tools
Maven plugins for [jQAssistant](https://jqassistant.org/), [ArchUnit](https://www.archunit.org/), [Spotless](https://github.com/diffplug/spotless/tree/main/plugin-maven)
 are configured in the [vino-svc-parent pom.xml](vino-svc-parent/pom.xml). 
The setting can and should be customized per requirements for each project and applied uniformly on the coe base.

### Use Spotless plugin to format code
```bash

# check if code is formatted
./mvnw spotless:check

# automatically apply default formatting
./mvnw spotless:apply


```

### Use jqassistant to analyze code structure
Before running the jqassistant plugin, make sure to update the following files to project specific configuration and rules.
* ```.jqassistant.yml``` configuration
* ```jqassistant/my-project.adoc```  rules


```bash
# ./mvn/jvm.config contains the configuration to run jqassistant

./mvnw jqassistant:scan

# if the result is written to embedded neo4j, run the server to explore the result
./mvnw jqassistant:server
```

### run sonarqube scanner
```bash
# adjust credentials and url accordingly
./mvnw sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=username -Dsonar.password=password

```

### archunit
Archunit test rules are configured in parent pom and are automated executed during test execution. 

By default, only minimal rules are configured and each project can add rules by either adding rules defined in [arch-unit-build-plugin-core](https://github.com/societe-generale/arch-unit-build-plugin-core) or fork the repo, and update and add new rules, then define the settings in parent pom.xml
```xml
<plugin>
        <groupId>com.societegenerale.commons</groupId>
        <artifactId>arch-unit-maven-plugin</artifactId>
        <version>${archunit.plugin.version}</version>
        <configuration>
            <properties>
                <archunit.propertyName>propertyValue</archunit.propertyName>
            </properties>
            <rules>
                <!-- only minimal set rules is configured here, each project needs to set more specific rules -->
                <preConfiguredRules>
                    <rule>com.societegenerale.commons.plugin.rules.NoStandardStreamRuleTest</rule>
                    <rule>com.societegenerale.commons.plugin.rules.NoPublicFieldRuleTest</rule>
                    <rule>com.societegenerale.commons.plugin.rules.NoTestIgnoreWithoutCommentRuleTest</rule>
                </preConfiguredRules>
            </rules>
        </configuration>
</plugin>

```

## JaCOCO Test Coverage Report
[Test Coverage Report hosted in gh-pages](https://vino9.github.io/vino-java-base/)