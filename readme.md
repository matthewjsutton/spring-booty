## What is this

* Java Web application: Spring Boot
  * https://projects.spring.io/spring-boot/
* OpenAPI (aka Swagger) integration via SpringFox
  * http://springfox.github.io/springfox/
* Build docker image
  * https://spring.io/guides/gs/spring-boot-docker/

## Run locally

Build: `./gradlew build`

Run: `./gradlew bootRun`

Swagger: `http://localhost:8080/swagger-ui.html`

## Docker

Build docker image: `./gradlew buildDocker`

Run docker image: `docker run -p 8080:8080 spring-booty:latest`

Remove stopped docker containers: `docker rm $(docker ps -a -q)`

Remove dangling images: `docker rmi $(docker images --filter "dangling=true" -q --no-trunc)`

## DIY

1. New project from spring initializer 
    * https://start.spring.io/
2. Make web project 
    * https://spring.io/guides/gs/rest-service/
3. Add swagger integration
    * http://heidloff.net/article/usage-of-swagger-2-0-in-spring-boot-applications-to-document-apis/
4. Add docker integration
    * https://geowarin.github.io/spring-boot-app-in-docker-image.html
5. Added Kotlin integration

## Next

* Jenkins configuration in project
* Configuration service / Spring Cloud Consul
