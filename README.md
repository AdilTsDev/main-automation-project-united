﻿# main-automation-project-united
 
 This is the final project for our Cyram. In this project, we performed Web browser UI automation testing on the United airline’s Website that includes: smoke test, sanity test, and regression tests using Selenium Java. Testing the main functionality of the website. Followeing the page object model, inplemented the BDD framework using cucumber and TestNG.
 
 
Page object model design pattern helps us to better organize our web elements and the corresponding pages to increase the readability.  It also helps us to reduce code duplication and improves test maintenance.

![pom](https://user-images.githubusercontent.com/40803114/145421912-5cc21134-aae4-4336-a86d-016a06f55dc4.PNG)

And here is the full structure of the project

![full](https://user-images.githubusercontent.com/40803114/145424540-52df83d4-c1ae-4b69-add4-cebc8406d7bb.PNG)


Writing our test cases with Gerkin language in cucmber feature files once again incresed the redability, and Reusability.

![image](https://user-images.githubusercontent.com/40803114/145426205-a94e3383-fde0-41fb-9f1f-be7f8f7a009c.png)

Runner class with CucumberOptions shown below acts as a link between the step definition class and the feature files. It allows us to run the project entirely, or multiple feature files by giving tag names, also generating reports, and more.

![runner](https://user-images.githubusercontent.com/40803114/145430515-6fefc76a-0239-4ffa-aca8-b31866de6953.PNG)

In this project, we developed total of 51 Test cases
   smoke test cases: 4
   sanity test cases: 5
   regression test case: 42
   
Here is the report generated by cucumber report plugIn

![united-report](https://user-images.githubusercontent.com/40803114/145447601-75fa3d34-4610-40e1-bf9b-59456c6f64d2.PNG)




 
