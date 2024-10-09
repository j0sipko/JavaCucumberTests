Feature: API tests
  Scenario: login Post request should return token
    When We send post request with login credentials from successLogin.json
    Then response should contain json with key success and value true as boolean
    And response should contain json with key message and value Login successful as string
    And response should contain json with token key

  Scenario: Get Git user request should return json with correct data
    When We send Get Git user request for user eugenp
    Then response should contain json with key name and value Eugen as string
    And response should contain json with key login and value eugenp as string
    And response should contain json with key type and value User as string
    And response should contain json with key location and value Bucharest, Romania as string
    And response should contain json with key id and value 1022859 as int