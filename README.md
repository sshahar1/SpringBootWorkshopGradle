# Spring-Boot Workshop by Tikal
Welcome to the workshop for Spring boot

# Phase 1
Starting in this branch you are requested to:
1. Run the spring-boot application successfully
2. Use a default name by property in case the student body doesn't include a name
3. Pass all the unit tests provided

# Phase 2
Starting in this branch you are requested to:
1. Change the running port to 9090
2. Pass all the unit tests provided
3. Change the default name of the Spring-boot application from command line in 3 ways:
   * Set the default name in command line
   * Change the profile
   * Use external properties file

# Phase 3
1. An asynchronous post construct method was added to the controller, run the application again
2. Change the application server from tomcat to Jetty
   * How come we didn't need to set tomcat before?
   * Why is the application log so thin?
3. Run the application with debug
4. Add the actuator to your application
5. Add the server host name to the actuator health check
   * You can use [this](https://fabianlee.org/2022/06/29/java-adding-custom-health-indicator-to-spring-boot-actuator/) as a reference

## Final
Congratulations on finishing all exercises. If time is left add a database service to your controller

[This](https://www.baeldung.com/spring-boot-h2-database) can help you get started.

# Day 2
## Phase 1
Welcome to day 2 of the Spring training. You tasks are:
1. Convert this web application to an application that consumes student instances from a Kafka topic.
2. Add another microservice with a REST controller that receives student instances and pushes them into a Kafka topic.
3. Run the entire application with a Kafka cluster

For Kafka feel free to use this distribution (requires Docker) https://github.com/wurstmeister/kafka-docker
