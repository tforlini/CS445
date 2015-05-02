# CS 445 Final Project
# Wine Club

## Install Java


First java need to be installed, it can be installed using the following command:


```
sudo apt-get install openjdk-7-jre
```

## Install Apache Tomcat 8.0.21

Once java is installed, one needs to install an Apache Tomcat servlet container available on this link:

```
http://apache.mirrors.ionfish.org/tomcat/tomcat-8/v8.0.21/bin/apache-tomcat-8.0.21.tar.gz
```

Then untar the file with the following command:

```
tar -xzvf apache-tomcat-8.0.21.tar.gz
```


## Build the project

A build.xml has been deployed to ease the building of the application. To build the application, make sure ant is installed on you machine and run the following command in the root directory of the project:

```
ant
```

This command will build the project and create a .war file under the build/ directory.

## Deploy the app on Tomcat

To deploy the application on Tomcat you need to copy the .war file into the webapps directory in your apache-tomcat-8.0.21 folder.


Note that you can also deploy the project from your IDE by configuration the local server with Tomcat 8 and building the project (for instance with eclipse or eclipse with the Tomcat plugin). 


## How to use the wine club

The application follows the provided RESTful API at this address:

```
http://www.cs.iit.edu/~virgil/cs445/mail.spring2015/project-api.html
```
 
 Therse is two different options to use the application:
 
 *The client:
 
 Which is accessible at the root URL of the aplication : http://localhost:8080/edu.iit.cs445.vin/
 
 With this interface you can POST and PUT your requests via HTML forms which is a user friendly way to fill your wine club up.
 
 *The Curl requests:
 
 Which is accessible using your shell. Curl is a command line interface for HTTP resuests. The base URL oof the app is http://localhost:8080/edu.iit.cs445.vin/rest/vin and then follows the api categories such as /sub or /admin. You can execute different kind of requests such as:
 
-POST a request using a JSON file:
 
```
curl -X POST -H "Content-Type: application/json" -d @<your-json-file> <your-url>
```

-GET a response from URL:

```
curl -X GET <your-url>
```

-PUT a request using a JSON file:
 
```
curl -X PUT -H "Content-Type: application/json" -d @<your-json-file> <your-url>
```
 
-DELETE an object to URL:
 
```
curl -X DELETE <your-url>
``` 
 
## Run the unit testing

To run the unit testing of the project:


First install JUnit

```
sudo apt-get install junit
```

Then compile the unit testing class

```
javac -cp /usr/share/java/junit.jar TestClasses.java
```

Finally run the test

```
java -cp /usr/share/java/junit.jar:. org.junit.runner.JUnitCore TestClasses
```

Note that you can also run the unit testing from your IDE 

## Application on Google App Engine


You can use the application deployed on GEA on the following link:

```
http://steady-burner-92405.appspot.com/
```
 
