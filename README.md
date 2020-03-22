# DB-App [![Build Status](https://travis-ci.com/Ubunfu/db-app.svg?branch=master)](https://travis-ci.com/Ubunfu/db-app)
Sample Boot app that connects to various databases and such.

### Starting up locally
1. Build the application:
    ```bash
    mvn clean install
    ```

2. Start up the local MongoDB container:
    ```bash
   docker-compose up 
   ```
   
3. Start up the application:
    ```bash
   mvn spring-boot:run
    ```