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



Note that you can also run the project from your IDE

