# Spring Boot Azure Service Bus Example

This is a basic project to support a `GET` REST API call and demonstrate how to receive messages from Azure Service Bus using the java SDK.

## Prerequisites
* An existing Azure service bus with topic (Standard tier Azure Service Bus)

## How to Run
1) Run with docker

    1.1 Supply environment variables needed in Dockerfile. You can create a file with extension as .env and add the variables there.
                
        Sample env file content:
        TOPIC_NAME=greetingstopic
        SUBSCRIPTION_NAME=s1
        CONNECTION_STRING=<service-bus-connection-string>
    
    1.2 Docker commands
    
    `docker pull vibhuti0910/spring`    
    
    `docker run -p 8080 -env--file your-env-file.env vibhuti0910/spring`
    
2) Go to the Azure Portal and send a message to the topic. The message can contain any name. This name will be used in a greeting.

3) Hit the following endpoint in your browser:
"localhost:8080/hello"

4) You should see "Hello \<Name\>" as output 
