## Ghost application deployment tests

Welcome to this mini test framework! To use it, first you'll need to clone this repository to your local machine. Then please follow the rest of the steps.

You will need:
* Docker 
* Chrome web browser installed
* Java 8
* Maven

Other dependencies used:

* Maven surefire plugin: to run Junit tests from the CLI
* Selenium 4
* JUnit 5
* WebDriverManager

Don't worry about downloading the Webdriver binary. It is already handled by the WebDriverManager.
In case you are a Windows user, please feel free to convert my scripts into cmd files. I'll try to provide Windows friendly scripts if the time permits.
First, I'll show you how I imagined the scenarios based on what I understood from this assignment.
For both of the scenarios, the tests will be executed in the same way.
I didn't change the docker-compose files. Instead, I modified the deployment step to have different environment (scenarios).

### Scenarios

#### Scenario #1
Deploy an application with the default username, password, and email. Make sure that the application loads properly and user use the email to log into the app. 

* Execute the setTheStage.sh to deploy the application to your local machine.
* After you have the application running on your local host, go back to the source folder and execute maven test. Test execution is packaged in the runtestscenario1
* After you finish with one scenario, run the cleanup.sh script to kill all the docker containers, network and also remove the persisten volumes.

```
sh setTheStage.sh
runtestscenario1.sh
sh cleanup.sh
```


#### Scenario #2
Deploy an application with the ghost blog title matching the username. Then make sure that the deployment went well and the blog has changed the title.

* Execute the setTheStage.sh from Scenario 2 folder to deploy the application to your local machine.
* After you have the application running on your local host, execute maven test
* After you finish with one scenario, run the cleanup.sh script to kill all the docker containers, network and also remove the persisten volumes.

```
sh setTheStage.sh
sh runtestscenario2.sh
sh cleanup.sh
```

#### TODO
* See why the application is not behaving as I expect and the credentials are not being used anywhere
* Add scenario2 test case as if the application were working properly

#### Scenario 1 and 2 with Helm Chart

In order to deploy the Ghost application using Helm chart, I´ve followed the documentation provided on this page [MIT](https://github.com/bitnami/charts/tree/master/bitnami/ghost).
I've added a helm folder under test, with two folders that follow the structure I implemented earlier. 
In order to deploy the application with Scenario 1 or 2, you need to run the setTheStage.sh.
The URL of the application should be localhost. (http://localhost/).
Then, you can run the test suite Scenario1Test or Scenario2Test using the commands I've mentioned above.

```
sh setTheStage.sh
helm delete my-release
```

#### TODO
* Fix the wait in Scenario2
* Try to deploy on Google cloud (waiting for Payment configuration)
* Complete the README