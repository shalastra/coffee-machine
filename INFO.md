
#### How to test and run it
Since the project is built using Maven, all maven commands are valid.
 
To run it, simple execute the following command:
 
 `mvn clean compile exec:java`

#### Why State pattern?
Problematic part of implementing State pattern is hardcoding states and transitions. Usually it is a bad practice, but there are some cases, where it is not a problem. 
The coffee machine is a good example of State Machine pattern. We have to have defined order of transitions otherwise the machine will not behave as we want.  

#### Assumptions
Several assumptions have been made. 
 - Coffee machine is refilling automatically. 
 - Coffees are made from three basic ingredients: grains, water and milk, the difference is only in amount being used
 
 #### Stack
  - Java 8
  - Maven
  - Junit 5
  - Lombok
  - Slf4j and Logback