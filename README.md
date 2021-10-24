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
I didn't change the docker-compos files. Instead, I modified the deployment step to have different environment (scenarios).

### Scenarios

#### Scenario #1
Deploy an application with the default username, password, and email. Make sure that the application loads properly and user use the email to log into the app. 

* Execute the setTheStage.sh to deploy the application to your local machine.
* After you have the application running on your local host, execute the runtests.sh
* After you finish with one scenario, run the cleanup.sh script to kill all the docker containers, network and also remove the persisten volumes.

```
sh setTheStage.sh
sh runtests.sh
sh cleanup.sh
```


#### Scenario #2
Deploy an application with the ghost blog title matching the username. Then make sure that the deployment went well and the blog has changed the title.


* Execute the setTheStage.sh to deploy the application to your local machine.
* After you have the application running on your local host, execute the runtests.sh
* After you finish with one scenario, run the cleanup.sh script to kill all the docker containers, network and also remove the persisten volumes.

```
sh setTheStage.sh
sh runtests.sh
sh cleanup.sh
```

#### Helm chart tests

TBD