#Author Aarthi

@emp
Feature: CRUD operations on employee

Background:
Given Base URI is set for emp

Scenario Outline: Full CRUD flow 

When I send POST request with "<designation>", "<dob>", "<email>", "<empName>", <experience>, "<mobileNo>", "<project>", "<role>", "<username>"
Then validate the status code 201 for emp
And validate the empName as "<empName>"

  When I send GET request for created employee
  Then validate the status code 200 for emp
 


  When I send PUT request with "<designation>", "<dob>", "<email>", "<empName>", <experience>, "<mobileNo>", "<project>", "<role>", "<username>"
  Then validate the status code 200 for emp




  When I send DELETE request for employee
  Then validate the status code 200 for emp
  
  Examples:
    | designation | dob        | email              | empName     | experience | mobileNo   | project   | role      | username    |
    | Tester      | 12/05/2000 | bhhimmi@gmail.com   | Skyy      | 2          | 9876543210 | Banking  | user      | shyydfas    |
    | HR          | 23/08/1998 | mahhu@gmail.com    | Landd    | 3          | 9123456780 | Healthcare| user      | sfggrr  |
    | QA          | 15/01/1995 | mathha@gmail.com   | Cloudd    | 5          | 9988776655 | Finance   | Admin     | jsrrpdd   |
    