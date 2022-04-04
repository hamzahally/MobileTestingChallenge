Feature: MyObservatory AATD

  Background:
    Given The app is open
    When I navigate to the 9 Day Forecast Page

  Scenario: Open app and navigate to 9 day forecast page
    Then I see the 9 Day Forecast Page

  Scenario Outline: 9 day forecast page shows the next 9 days of weather
    Then I see the forecast for the next 9 days

    Examples:
    |Day|
    |1 |
    |2 |
    |3 |
    |4 |
    |5 |
    |6 |
    |7 |
    |8 |
    |9 |

  Scenario: I click on the Extended Outlook then I can navigate to 9-day forecast

  Scenario: I click on the local forecast then I can navigate to 9-day forecast

  Scenario: I can see the forecast was updated today