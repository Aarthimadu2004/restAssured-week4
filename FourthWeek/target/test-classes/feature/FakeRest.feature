#Author Aarthi
@fake
Feature: CRUD OPERATIONS on fake rest



Scenario:Create a activity
Given Base URI is set for Fake
When I send post request with title "Mag"
Then validate the status code 200

Scenario:Get a activity
Given Base URI is set for Fake
When I send get request 
Then validate the status code 200

Scenario:Update a activity
Given Base URI is set for Fake
When I send put request 
Then validate the status code 200

Scenario:Update a activity
Given Base URI is set for Fake
When I send delete request 
Then validate the status code 200