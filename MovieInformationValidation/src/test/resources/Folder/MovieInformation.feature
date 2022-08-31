Feature: Verifying the movieinformation in wikipedia and imdp websites

  Scenario: Validating the movie information in wikipedia and imdp websites
    Given User should enter the movie name in google search page
    When User should click on wikipedia and imdp links then fetch date and country
    Then User should compare the data using Assert.
