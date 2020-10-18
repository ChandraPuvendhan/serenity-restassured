Feature: Google Maps API
  Verify different operations using and Serenity report

  Scenario: Verify places in Google Maps API
  Given I perform POST operation for Google Maps API
    Then I perform GET operation for Google Maps API
    Then I perform PUT operation for Google Maps API
    And I perform DELETE operation for Google Maps API

