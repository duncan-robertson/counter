# Counter Microservice
## Usage
This is a very simple Spring Boot web microservice

You can get the current value of the counter by making a GET request to the root

    curl http://localhost:8080/

You can get update the counter value by making a PUT request to /update. The operation parameter must be set to ADD or SUB, these will increment and decrement by one respectively. The updated counter value will be returned.

    curl -XPUT http://localhost:8080/update -H "Content-Type: application/json" -d '{"operation": "ADD"}'

## Build

### Maven
From the project directory you can build and run the project by issuing the following commands on Linux, OS X, and Git bash

    ./mvnw clean install
    java -jar ./target/counter-0.0.1-SNAPSHOT.jar

On windows command prompt you can run

    .\mvnw.cmd clean install
    java -jar .\target\counter-0.0.1-SNAPSHOT.jar

You can also use the spring boot plugin to build and run immediately

    ./mvnw spring-boot:run

### Docker
Docker can also be used to build and run this service. To create an image the following command can be used

    docker build github.com/duncan-robertson/counter -t counter

Then an instance of the image can be run. The docker instance runs on port 8080 internally which will need to be exposed for network access. For example this command will run an instance on port 9999

    docker run -d -p 9999:8080 counter