# Student-Registration-Project

## About 
Student registration project is an application used for performing below operations;

  - Create new student record after receiving required student details
  - Update student class details based on student id
  - Delete student record based on student id
  - Retrieve all students in a class
  - Retrieve student details for a specific student id

# Import Project

Clone below git repository in order to get the project directories/files using below command;

```sh
 git clone https://github.com/soniven/Student-Registration-Project.git
```

# Build Project

In order to build maven project from command line, use below command;
```sh
mvn clean install
```

#Run Project

For running student application, you need to start the SpringBoot server. In order to do that, navigate to 
```sh
src/main/java/com.java.student/StudentApplication.java
```

Right click on the IDE window and choose **Run StudentApplication..main()**
![](https://github.com/soniven/Student-Registration-Project/blob/main/RunStudentMainApplication.png?raw=true)

# Test APIs

##### Create new student (POST)
  - For creating new student record, below Payload must be passed to POST request;
  
  ```sh
payload = "{\n" +
                "    \"id\": 223445,\n" +
                "    \"firstName\": \"Mike\",\n" +
                "    \"lastName\": \"Wong\",\n" +
                "    \"className\": \"3 A\",\n" +
                "    \"nationality\":\"Singapore\"\n" +
                "}";
```

![](https://github.com/soniven/Student-Registration-Project/blob/main/POST.png?raw=true)


##### Update student class name by student id (PUT)
- For updating class name of a student, below payload needs to be passed for PUT request
 ```sh
payload = "{\n" +
                "    \"id\": 223445,\n" +
                "    \"className\": \"3 C\",\n" +
                "}";
```
![](https://github.com/soniven/Student-Registration-Project/blob/main/PUT.png?raw=true)

##### Delete student record by student id (DELETE)
- For delete a student record, send student id as a path variable in the DELETE API URL
 ```sh
http://localhost:8080/api/v1/students/223445
```
![](https://github.com/soniven/Student-Registration-Project/blob/main/DELETE.png?raw=true)

##### Fetch all students (GET)
-For retriving details of all students, use below API URL

 ```sh
http://localhost:8080/api/v1/students
```
![](https://github.com/soniven/Student-Registration-Project/blob/main/GET_ALL.png?raw=true)

##### Fetch student details by id (GET)
-For retriving details of a particular student by id, use below API URL with id as path parameter

 ```sh
http://localhost:8080/api/v1/students/223445
```
![](https://github.com/soniven/Student-Registration-Project/blob/main/GET_BY_ID.png?raw=true)

### Tests

##### Cucumber Tests

###### Feature File : student.feature
This file contains test scenario, written in gherkin syntax. The scenario written is understandable by business user.

###### Step Definitions: Steps
This file converts each step from feature file as a function which will perform some action on the respective elements and return results.

###### Test Runner: CucumberTestRunner
This is the test runner for running all cucumber tests. In order to execute cucumber tests in sequence, please open below file.Right click and select **Run CucumberTestRunner**

```sh
src/test/java/com.java.student/controller/CucumberTestRunner.java
```

It will execute all the scenarios mentioned in feature file one after the other and provide test results in the console.

![](https://github.com/soniven/Student-Registration-Project/blob/main/Run_Cucumber_Tests.png?raw=true)





