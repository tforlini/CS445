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

## Run the Unit testing

First install JUnit

```
sudo apt-get install junit
```

Then compile the unit testing class

```
javac -cp /usr/share/java/junit.jar UnitTesting.java
```

Finally run the test

```
java -cp /usr/share/java/junit.jar:. org.junit.runner.JUnitCore UnitTesting
```

Note that you can also run the project from your IDE
