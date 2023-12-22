## Getting Started


### Prerequisites

Before getting started, ensure that you have the following software installed on your machine:

```
1. Java JDK (the latest version)
2. Jetbrains Aqua or IntelliJ IDE or VSCode
```

### Installing
1. Clone this project.
2. Open the project in IntelliJ IDE or Aqua or VSCode.
3. Open the terminal in Intellij IDE or Aqua or VSCode.
4. Build the project

```
./gradlew build

```

### Running the test

To execute the automated tests with Chrome, run this: 
```
 export browserName=CHROME
./gradlew clean test

```

To execute the automated tests with Firefox, run this: 
```
 export browserName=FIREFOX
./gradlew clean test

```
These commands will run the Cucumber tests with the specified configurations and generate HTML test reports in the "target" directory.


## Report path
1. test-output(in automation folder)
2. target : from Cucumber
3. allure framework : The report can be obtained after running the tests and will be located in build/allure-reports.

![Screenshot CSV reports from allure framework](https://drive.google.com/uc?export=download&id=1D4XMWsrD13Rs6r0223mgZ4eekR4acT4d)


