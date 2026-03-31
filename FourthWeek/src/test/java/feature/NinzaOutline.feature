@ninzaout

Feature: Create Project API - Ninza HRM

  Scenario Outline: Create multiple projects using POST API
    Given Base URI is set for NinzaHRM application 
    When request body is prepared with "<createdBy>", "<projectName>", "<status>", "<teamSize>"
    Then response status should be 201 for this


  Examples:
    | createdBy | projectName | status      | teamSize |
    | Aarthi    | AlProj   | Created     | 0        |
    | Aarthi    | BeProj    | OnGoing     | 0        |
    |Aarthi     | GamProj   | Completed   | 0        |
    |  Aarthi  | DelProj   | Created      | 0        |
    | Aarthi    | EpsiProj | OnGoing     | 0        |