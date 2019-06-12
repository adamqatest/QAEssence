My Answer
---------
Here is my response to the QA Coding Challenge Below.

Note: That I ran into some issues with this challenge:
* The necessary MacBook 2.9 GHz is not available on the Apple Website anymore. So Instead I chose an alternative from those available. Consequently adjusted expected prices. (I also corrected some typos a) So so b) VAT.VAT)
* Selenium issues with using radio buttons. I used workarounds but ate into timelimit.
* Selenium issues with transparent overlay at bottom of Customise MacBook Screen absorbing clicks intended for objects below. I used workaround of scrolling to field below that intended, to ensure the required field was clear to get clicks but searching for a better solution is recommended.   
* Consequently I ran out of time based on the timelimit - so am aware that the code needs refactoring, especially for a real-life solution requiring more scenarios.
* Tested successfully under Chrome (Version 75.0.3770.80 (Official Build) (64-bit))
* With more time and more scenarios to justify the effort I would:
  * Deal with the TODO items left throughout the code.
  * Extract environment concerns to config file to handle multiple browsers/different directory structure/logging/reporting etc
  * Refactor to eliminate if else chains and other smells identified in "Clean Code"by Martin
  * Improve SOLID adherence
  * TearDown function to reset system to known point/log status data/screenshots for failures etc 
  * Refactor feature code to make clear second sceanrio is based on first and not independent.
  * Support other option regards processor sizes, storage options, available extras etc. 
  

Instructions 
------------
I have uploaded the project from Intellij so should include the required configuration for "Feature: buying_mac_on_website". But copied below in case of difficulties.

Note it **expected** the following:
* C:\Selenium-3.14   {Contains 3.141.59 versions of .jar}
* C:\Selenium-3.14\Drivers\chromedriver.exe  
* C:\Selenium-3.14\libs {commons-exec-1.3.jar, byte-buddy-1.8.15.jar, guava-25.0-jre.jar, okhttp-3.11.0.jar,okio-1.14.0.jar} 

Note: I ran project from here, but configuraiton shoudl be relative to root.
C:\Work\IdeaProjects\QAEssence

Refer to pom.xml for dependent code versions. Used Maven to build initial cucumber project

Copy of Run configuration:
* Cucumber Java
  * Feature: buying_mac_on_website
    Configuration:
      Main class = cucumber.api.cli.Main
      Glue = bindings
      Feature or folder path = C:\Work\IdeaProjects\QAEssence\src\test\resources
      Program arguments = --format org.jetbrains.plugins.cucumber.java.run.CucumberJvmSMFormatter --monochrome --name "^Buying a MacBook Pro on the website$"
      Use classpath of module = QAEssence
      
      
      


The QA coding challenge
-------------------------

We would like you to write a test harness suite in Java and Cucumber that follows the specification contained in the Gherkin feature file attached to this repository.

**We would like you to provide us with a well written, clean code, and SOLID principle compliant test suite.
Please also provide the instructions necessary to execute your solution.**

Time
----

We haven’t set a time limit for completing this challenge however we would like you not to spend more than 4 hour in total on it.

Submitting
----------

Please create a GIT repository with your code so we can review ahead of the final interview.
