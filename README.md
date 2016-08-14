Selenium Webdriver:
-------------------

=> We can run the testclasses 'LoginTest.java' and 'HomeTest.java' as a part of testng xml(testng.xml) and also can run single test method from any of the IDE (IntellijIdea) is preferred,
   and below are some of the assumptions.

1. Selenium webdriver with java bindings
2. TestNG as unit test framework
3. Running in windows(windows 10) environment
4. FireFox version - 46.0.1
5. Chrome version - 51.0.2704.103 m
6. IE version - IE 11

Note: : If you want to run in any of the specific browser(firefox/chrome/ie), then go to application.properties file and change the "browser" paramters.
     valid parameters are "firefox/chrome/ie".
     
     
     
 Jmeter:
 ---------

Jmeter version used here is  2.13.

Below are the test plans

1. Http_Get_Request.jmx - > load test case for HTTP GET request
2. Http_Get_Request_Using_Constant_Timer.jmx - > load test case for HTTP GET request using contant timer
3. Http_Post_Using_Regular_Expression_Extractor.jmx - >  load test case for HTTP POST request (Login into an application using username and password, 
   here sessionId is extracted using Regular expression extractor)