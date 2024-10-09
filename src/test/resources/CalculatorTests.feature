Feature: CalculatorTests
  Scenario Outline: Calculator should return proper value from specific method
    When We calculate <value1> <operator> <value2>
    Then Method should return <expectedResult>
    Examples:
      | value1  | operator | value2  | expectedResult |
      | 9       | +        | 3       | 12             |
      | 9       | -        | 3       | 6              |
      | 9       | *        | 3       | 27             |
      | 9       | /        | 3       | 3              |