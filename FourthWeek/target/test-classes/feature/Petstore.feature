#Author Aarthi

@petstore
Feature: Petstore CRUD Operations

 Scenario: Create a pet
  Given Base URI is set
  When I send post request with name "Max"
  Then response code must be 200
  
  Scenario: Get a pet
  Given Base URI is set
  When I send GET request with petId
  Then response code must be 200
  
  Scenario: Update a pet
  Given Base URI is set
  When I send PUT request to update pet
  Then response code must be 200
  
  Scenario: Delete a pet
  Given Base URI is set
  When I send DELETE request with petId
  Then response code must be 200



