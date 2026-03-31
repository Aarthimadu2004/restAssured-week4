#Author Aarthi

@ninza
Feature: CRUD opertaions on ninza


  Scenario: Create a project

    Given Base URI is set for Ninza
    When I send POST request with projectName "Sky1"
    Then response code must be 201 for ninza
    
   Scenario:Get a project

    Given Base URI is set for Ninza
    When I send GET request
    Then response code must be 200 for ninza
    
    Scenario:Update a project

    Given Base URI is set for Ninza
    When I send PUT request with status "Completed"
    Then response code must be 200 for ninza
    
   Scenario:Delete a project
    
    Given Base URI is set for Ninza
    When I send DELETE request
    Then response code must be 204 for ninza
