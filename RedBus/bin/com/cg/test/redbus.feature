Feature: Online ticket booking
Scenario: User books the ticket using redbus
Given The user visits the redbus page
And the user fills the source,destination,date of travel and searches for buses
And the user views the seats in the buses
And the user select the required seats
And the user enters the passenger details
Then the user clicks proceed to pay
