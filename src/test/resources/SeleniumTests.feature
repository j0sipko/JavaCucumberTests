@seleniumFeature
Feature: Selenium tests
  Scenario Outline: search youtube in google and find if filtered videos there have expected channels and titles
    Given Go to https://www.google.com/ website
    When Search for youtube in google
    Then Check if first result is page youtube.com
    And Click on first result
    When We search for <searchText> on youtube
    And Filter youtube videos by View count
    Then Check if 1. result is from <firstChannel>
    And Check if 1. video title contains <firstTitle>
    And Check if 2. result is from <secondChannel>
    And Check if 2. video title contains <secondTitle>
    And Check if 3. result is from <thirdChannel>
    And Check if 3. video title contains <thirdTitle>
    And Wait for 2 seconds

    Examples:
      | searchText   | firstChannel | firstTitle    | secondChannel  | secondTitle  | thirdChannel  | thirdTitle  |
      | music video  | Ed Sheeran   | Shape of You  | Maroon 5       | Sugar        | Katy Perry    | Roar        |
      | linkin park  | Linkin Park  | Numb          | Linkin Park    | In The End   | TrapMusicHDTV | In The End  |
      | rap          | Future       | Life Is Good  | 50 Cent        | In Da Club   | EminemMusic   | Without Me  |