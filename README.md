# Logging Project

In this project, the following logging mechanisms are implemented using AOP:

* <b>Method Entry Logs:</b> For methods in the controller and service packages, logs are generated that include the class name, method name, and parameters.
* <b>Method Exit Logs:</b> When methods complete, logs are generated that include the class name and method name.
* <b>Error Logs:</b> If a service throws an exception, logs are generated that include the Exception class name, the line number where the error occurred, and the error message.

## Features

- AOP
- Slf4j for logging
- RESTful APIs with Spring Boot Web

## Technologies
* Java 17
* Spring Boot 3.0.5
    * AOP
    * Logging
    * Lombok

## How It Works?

There are 2 requests in this project.

`GET /api/log`
 
This request basically returns a String value. 
<br>Log:

```
com.test.loggingAOP.controller.LogController.successfulLog() method started.
com.test.loggingAOP.service.LogService.successfulLog(successful log) method started.
com.test.loggingAOP.service.LogService.successfulLog() method ended.
com.test.loggingAOP.controller.LogController.successfulLog() method ended.
```

`GET /api/log/error`

This request throws a RuntimeException.
<br>Log:

```
com.test.loggingAOP.controller.LogController.errorLog() method started.
com.test.loggingAOP.service.LogService.errorLog(error log) method started.
ERROR: RuntimeException WAS THROWN AT com.test.loggingAOP.service.LogService.errorLog(LogService.java:13). ERROR MESSAGE: error log
com.test.loggingAOP.service.LogService.errorLog() method ended.
com.test.loggingAOP.controller.LogController.errorLog() method ended.
```