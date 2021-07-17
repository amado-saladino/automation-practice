# Mini Sample Test Project

Simple test that runs with maven and junit as a test runner.

## Run in Docker

Docker image could be built for this project using `Dockerfile`:

`docker build -t test:1.0 .`

```sh
docker run -v `pwd`:/app -v maven-repo:/root/.m2 amadosaladino/se
```

It could also run directly in a custom container using [this image](https://hub.docker.com/repository/docker/amadosaladino/se) with these options:

```sh
docker run -v `pwd`:/app -v maven-repo:/root/.m2 amadosaladino/se
```

## Workflows

This project has a workflow to run the tests in GitHub environment, check Actions tab. Upon the test it will provide the test report and the screenshots taken during test will be archived and available for download.