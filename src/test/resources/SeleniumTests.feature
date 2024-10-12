@seleniumFeature
Feature: Selenium tests
  Scenario: search youtube in google and find if music videos have correct channels
    Given Go to https://www.google.com/ website
    When Search for youtube in google
    Then Check if first result is page youtube.com
    And Click on first result
    When We search for music video on youtube
    And Filter youtube videos by View count
    Then Check if 1. result is from Ed Sheeran
    Then Check if 2. result is from Maroon 5
    Then Check if 3. result is from Katy Perry
    And Wait for 2 seconds