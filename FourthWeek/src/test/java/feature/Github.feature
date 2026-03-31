@github


Feature: CRUD opertaions on github

Background:
 Given Base URI is set for github

  Scenario: Create a repo

   
    When I send POST request with with repoName "Proj2"
    Then response code must be 201 for github

    
   Scenario:Get a repo

   
    When I send GET request for github
    Then response code must be 200 for github
    
    Scenario:Update a repo

    
    When I send PUT request with description "New file"
    Then response code must be 200 for github
    
   Scenario:Delete a repo
  
    When I send DELETE request for github
    Then response code must be 204 for github