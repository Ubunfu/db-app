# DB-App [![Build Status](https://travis-ci.com/Ubunfu/db-app.svg?branch=master)](https://travis-ci.com/Ubunfu/db-app)
Sample Boot app with a database.

### Build and Test
1. Use Maven to build and test (uses embedded H2 database):
    ```bash
   mvn clean install 
   ```

### Starting up locally
1. Bring up the docker-compose environment:
    ```bash
    docker-compose up --build
    ```
   
### Build System
Travis CI is monitoring this project and will build it when commits are pushed to `master`.  Build health is indicated
by the badge next to the title.

Docker Hub is monitoring the project as well, and will build and publish an updated container image to 
[`ubunfu/db-app`](https://hub.docker.com/repository/docker/ubunfu/db-app) whenever commits are pushed to `master`.