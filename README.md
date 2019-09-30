<h3>Assumption</h3>
It’s a basic Authentication<br/>
Here I assumed we are getting token using username and password and token is valid for 120 second.<br/>
I assumed all Response parameters are mandatory.<br/>
I assume it's a one cluster(Not multi cluster with load balancer) responding my REST API. <br/>
API Data Validation is heavily depend on business logic and use of these API.<br/>

<h3>Test Scenarios </h3>
I prefer to design the system instead of making more assumption that can handle all type of request or Assumption in elegant way, So here is my approach <br/>
I tried to design a basic framework with basic automated API testing ( As writing plain code doesn’t make sense). <br/>
I am listing all the test case around these API only basic are automated as part of this assignments. <br/>

<h3> Benefits of this framework </h3>
-- Test Code is Modular. <br/>
-- Test Code is scalable without much change. <br/>
-- Most of the common code is reusable. <br/>
-- Writing any Rest based automation become fast and easy because <br/>
-- RestAssured by default provide most of the function, <br/>
-- TestNG help with Assertion and Grouping, <br/>
-- I putted common function in a place and return it,<br/> 
-- we have an interface for end point and <br/>
-- JSON is converted to pojo so Java Object Assertion become easier for bigger API<br/> 

<h3>Here are Some of the test cases I can think of to automate using my framework </h3>
<h4>Authentication </h4>
-- To Validate Authorization(Credential containing the authorization information). <br/> 
-- To Validate content type (text/html, text/JSON ). <br/> 
-- To Validate Cache Control (Important in case of query parameter design as it stored in cache). <br/> 
-- To Validate token Encryption (Common or inhouse design). <br/> 
-- To Validate Session ( Longevity of Session). <br/> 
-- To Validate IP based Restriction to consume and process the reuest <br/> 

<h4>Request Creation</h4> 

-- To Validate Request with valid creds only process <br/> 
-- To Validate Request query parameter have spoofing safe mechanism <br/> 

<h4>Response Status</h4> 
-- To Validate If Resource is not identified - 204 <br/> 
-- To Validate request is processed by Resource - 200 <br/> 
-- To Validate new resource created - 201 <br/> 
-- To Validate not implemented - 501 <br/> 
-- To Validate Bad Request - 400 <br/> 
These are some of the basic status code, more can be added based based on how the design is. <br/> 

<h4>Response Data Validation </h4>
Data validation is heavily depend on business logic and usage of these API <br/> 
<h5> Validation from external source</h5> 
● Structure Database(Mysql, Oracle) - write a common function in RestAssuredConfiguration.java and reuse it wherever required. <br/> 
● Non Structure Database(NoSql - Cassandra, Redis, hidef etc) - Write a function to fetch a value on key and add into RestAssuredConfiguration.java and return it and reuse whenever required. <br/> 
● Excel - Write a Function to read an excel and add into common place return and use it using Array list or Hash Map. -- I assume here all fields are mandatory, so we can validate not empty. 

<h3>Basic Framework Fundamentals</h3>
Using RestAssured library for all the http function.<br/> 
TestNg for Insertion.<br/> 
Common function in common framework place(ex:- mysql connection etc).<br/> 
Centralizing end point.<br/> 

<h3>CI/CD Pipeline</h3>
In order to dynamically bring this into CI/CD, we need to create out own jar with all thses depencies and who takes some input (grouping of test, endpoint, input source)<br>
jar can be run from the vm/machine from where you have integarted teamcity/jenkins pipeline.
timing to run the jar can be handled using cron.

At the end :- All the task can be achieved in many way, I am AWS certified solution architect, I have expertise around Docker and Microservices, so If we are developing the same for mucroservice I will prefer to use kubernetes pods, docker registry and PACT framework to run my test.  
there are endless way to achieved this, this isn't the most effective considering the not known depth of the problem.
Thanks for the opportunity.
 



