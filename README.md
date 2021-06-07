# Spring Boot Azure Service Bus Example

This is a basic project to support a `GET` REST API call and demonstrate how to receive messages from Azure Service Bus using the java SDK.

## Prerequisites
* An existing Azure service bus topic

## How to Run
1) Supply the following values in your environment variables yaml file:
    * subscription name of the service bus
    * topic name
    * connection string for the service bus
2) Go to the Azure Portal and send a message to the topic. The message can contain any name. This name will be used in a greeting.
3) Run the project and hit the following endpoint:
"localhost:8080/hello"
4) You should see "Hello \<Name\>" as output 