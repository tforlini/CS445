# Assignment 1

## Install Java


First java need to be installed, it can be installed using the following command:
  

```
sudo apt-get install openjdk-7-jre
```

## Run the TestCreature

Once java is installed, you can run the TestCreature by going into `Assignemnt1/src/` and run:

```
java -jar Assignment1.jar
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