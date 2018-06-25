# Programming-test-java
BookStore
Created back end Web Service project.
With this project generated output folder is included,
Generated folder contains web method files and wsdl files.
If you want to create new generated output, 
In pom.xml -> commented lines for wsdl generation plugin should be uncommented after build.
Junit test cases included for BookListService. 
Access url http://localhost:8080/BookStore/BookListService. you will find wsdl xml file.

To create Environment
1. Create new maven web application project with existing pom.xml

2. Add src file and bookstoredata.txt file into BookStore project.

3. Build and remove the commented plugin code from pom.xml for generation of wsdl file.

4. Build success with generated folder.

5. I have included generated folder for references of wsdl file. If not needed pls ignore.

6. You could also generate new wsdl file from project also.

7. Webservice name is BookListService.

8. publish url http://localhost:8080/BookStore/BookListService
