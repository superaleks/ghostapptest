##Ghost application deployment tests

###Scenarios

####Scenario #1
Deploy an application with the default username and password and make sure that the application is deployed properly and user can log in to the app

* Execute the setTheStage.sh to deploy the application to your local machine.
* After you have the application running on your local host, execute the runtests.sh

```
sh setTheStage.sh
sh runtests.sh
```


####Scenario #2
Deploy an application with the ghost blog title matching the username. Then make sure that the deployment went well and the blog has changed the title.

