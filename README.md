# MobiquityRestAssuredAssignment

API Automation with Selenium, Rest-Assured, Java8, Maven, TestNG, docker-compose, gitlab-ci and circleci

## Requirements:
Below dependencies needs to be installed/configured
- Java 8 or higher (JAVA_HOME and PATH in environmental variables)
- Maven (M2, MAVEN_HOME and PATH in environmental variables)
- IDE (IntelliJ is preferred)

## Downloading Project:
- Using git command: https://github.com/Aj821990/MobiquityRestAssuredAssignment.git

*or*

- Download the project from https://github.com/Aj821990/MobiquityRestAssuredAssignment

## Execution:
1.. Run via TestNG
````sh
Click on the run button on your IDE or right click on your testNG file and click RUN

Below scenarios are mentioned in TestNG file:
<class name="APITesting.testCases.verifyUserService"> </class>
<class name="APITesting.testCases.verifyPostService"> </class>
<class name="APITesting.testCases.verifyEmailService"> </class>
<class name="APITesting.testCases.verifyEmailID"> </class>
````
2.. Run via terminal
```sh
mvn clean test -Dtest=<tests> -DreTry=<max retry>
example:
mvn clean test -Dtest=verifyUserService,verifyPostService,verif*EmailService,verifyEmailID -DreTry=0
```
3.. Run via gitlab CI pipeline
```sh
mvn clean -Dtest=<tests> test -DreTry=<max retry>
example:
mvn clean test -Dtest=verifyUserService,verifyPostService,verif*EmailService,verifyEmailID -DreTry=0
```
4.. Run via circleci pipeline ()
```sh 
mvn clean -Dtest=<tests> test -DreTry=<max retry>
example:
mvn clean test -Dtest=verifyUserService,verifyPostService,verif*EmailService,verifyEmailID -DreTry=0
```

##Important points to remember:
- ***Logging:*** Logging currently logs with INFO level. Log level can be modified by updating log4j.properties
- ***Unused Classes:*** Queries and Database Connection classes are currently not used. docker-compose and .gitlab-ci.yml are not tested at the moment
- ***Test Report:*** Test Report is saved in location - reports
- ***Logs:*** Logs are saved in location - log
- ***.gitignore:*** reports/, .idea/, log/, target/ are covered in .gitignore file
