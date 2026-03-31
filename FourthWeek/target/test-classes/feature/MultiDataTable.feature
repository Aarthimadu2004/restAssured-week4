#Author aarthi

@multi
Feature:CRUD ops on multiple data table

Background:
Given Base URI is set for multiple data table

Scenario:Creating project with data table multiple data

 When I send POST request with project details
    | createdBy |  projectName | status |teamSize  |
    | StickMan  | Proj111      | Created | 0    |
    | StickMan  | Proj112      | Completed | 0    |
    | StickMan  | Proj113       | Created | 0    |
    | StickMan  | Proj114       | Completed | 0    |
  Then response status code should be 201 for data multi


