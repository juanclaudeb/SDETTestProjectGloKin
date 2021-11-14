# SDETTestProjectGloKin
BDD Test Framework and Postman tests

# SECTION 1: SDETTestProject (Java Selenium BDD)

# ENVIRONMENT PRE-REQUISITES:

	* IDE: IntelliJ IDE community edition
	* SDK version: Java Development Kit (JDK) 17
	* Build tools: Apache Maven
	* Latest version of JAVA JRE (jre-8u311 for windows was used during development but any should work for the given OS used)
	* Google Chrome WebDriver - At the time of writing driver version 95 is used. NB if chrome is updated, please take this into account as the driver supports v95 alone.
	
# PLUGIN PRE-REQUISITES:

	* Cucumber for JAVA
	* Gherkin
	* JUnit generatorV2
	* Maven Runner
	* Maven
	* JUnit
	
# DEPENDENCIES USED:

	    <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
		
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.0.0</version>
            <scope>test</scope>
        </dependency>
		
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.0.0</version>
        </dependency>
		
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.0.0</version>
        </dependency>
		
		<!-- https://mvnrepository.com/artifact/net.masterthought/maven-cucumber-reporting -->
        <dependency>
            <groupId>net.masterthought</groupId>
            <artifactId>maven-cucumber-reporting</artifactId>
            <version>5.6.1</version>
        </dependency>
		
		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-picocontainer -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>7.0.0</version>
            <scope>test</scope>
        </dependency>
		
# TEST DESIGN APPROACH:

The test design approach mainly encompasses the use of Behaviour Driven Development (BDD) using the Java, Selenium and Cucumber / Gherkin tech stack as the primary tech used.
This automated test approach bridges the gap of communication between business users and developers to effortlessly analyze the goal of test scenarios and features reporting services / frameworks which requires minimal maintenance. The design principles used in its most granular form enables us to run the test framework cross enviroments such as Linux, iOS and Windows for most supported versions as well as different automation build software currently avaiable such as Jenkins, Azure DevOps, AWS, Travis CI etc. 

	1. BDD Test Methodology:
	
	Test scenarios are initially created with natural language using Gherkin to define a "Feature --> Scenario Outline --> Given, And, When, Then" test structure which makes use of dynamic "Example" tables in order to inject test data into a scenario outline which is then used to enable parameterization of test steps.

  2. Selenium POM (Page Object Model):

	The use of "WebEmelents" and "Page Actions" are impleted using page classes per web page in test. This design patern is used to increase ease of use and simplicity when creating selenium actions in the respective "Page definition class".
	
	3. Test Runner:
	
	The test runner class is used as a test runner to execute cucumber BDD test features which acts as the wrapper class to bind the "Glue" classes ( Features, Steps, Hooks ). In addition the test runner class is responsible for generating report results in HTML, JSON and XML data formats for the consumption of automation build software like Jenkins or Azure DevOps etc.
	
	4. Hooks
	
	A "hook" class is created which is responsible for the @Before and @After methods for cucumber test suite runs. This involves initiaiting a browser driver instance as well as configuring the browser options and then at teardown, closes all running browser instances (for chrome).
	
# TEST RUN INSTRUCTIONS:

Assuming all environemnt dependencies have been installed on the host OS, the instructions to run tests via command line are as follow:

CMD: 

	1. Navigate to the project folder:
		
		CD c:/SDETTestProject (or where ever your project is located)
		
	2. To run all tests and generate the report to view, run the following command:
	
		mvn clean test verify
		
		note- this will run the entire test suite and generate the report to view
		
	3. Open the report using your browser of choice:
	
		3.1 Report is located in the following directry from the project:
			c:\SDETTestProject\target\cucumber-report-html\cucumber-html-reports
			
		3.2 Open any of the HTML files and navigate to the sections you would like to view your overall test results
		
===============================================================================================================================================================================================
===============================================================================================================================================================================================
		
# SECTION 2: SDETPostManTest

# ENVIRONMENT PRE-REQUISITES:

	* PostMan should be installed
	
# Config Settings:

	* SSL should be disabled

# Instructions:

	1. A https://openweathermap.org/api account should be created
	2. The user requires an API Key to execute endpoint from the openweathermap.org site
	3. The API Key should be replaced on the collection varaible: apikey
	
# TEST DESIGN APPROACH:

API tests are created from requests	and is validated post endpoint execution. Test varaibles are stored within the collection parameters respectively and are changed from request to request eg. validtion of a newly created weather station by executing POST and GET endpoints in order. Test Case is run as an e2e (end to end) scenario.
	
# Test Run instructions:

	1. From the SDETPostManTest collection 
		1.1 Click run icon
		1.2 Click the "Run SDETPostManTest" button
		1.3 View the test run iteration
