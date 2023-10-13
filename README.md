# Selenium Boilerplate:

This java project contains the essentials to get started with selenium quickly without having to go through the hassle of downloading individual dependencies one by one.

## Installation and downloads:

Note:

There can be version compatibility issues between Java and Gradle.
Please visit this link to know more: https://docs.gradle.org/current/userguide/compatibility.html

We suggest you to use the below Java and Gradle versions:

Download links:

Java: 17.05:

https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

Gradle: 7.5.1:

https://gradle.org/releases/


## What does this project use?

This project uses gradle , webdriver manager , selenium v4

## Pre-requesites:

- git: https://github.com/git-guides/install-git
- Java : https://www.java.com/en/download/help/download_options.html
- Gradle: https://docs.gradle.org/current/userguide/installation.html

## Getting started:

1.  clone this repo to your machine using git clone
2.  To build the project:

    _MacOS_ / _Linux_ / _Windows_
    ```
    ./gradlew build
     ```

3.  To run the project:

    _MacOS_ / _Linux_ / _Windows_
    ```
    ./gradlew run
    ```

## Writing your test case:

_Test cases are part of the /src/main/java/demo/TestCases.java file._

### Defining new test case:

1.  Open TestCases.java file
2.  Create a copy of the function testCase01()
3.  Update the contents of the newly created method with your own custom logic

### Calling the newly created test case:

1.  open /src/App.java
2.  notice the TODO block:

```
//TODO: call your test case functions one after other here
```

3.  Call the newly created methods under the TODO block

### Java doc for reference:

1.  Selenium - https://javadoc.io/doc/org.seleniumhq.selenium/selenium-api/latest/index.html
2.  WebDriverManager - https://javadoc.io/doc/io.github.bonigarcia/webdrivermanager/latest/index.html
3.  JUnit - https://javadoc.io/doc/org.junit.jupiter/junit-jupiter-api/latest/index.html
