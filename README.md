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