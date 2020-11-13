## Kollex Automation Challenge

This is the web test automation project for Kollex Automation Challenge. 
It was built using Java 13, Selenium 3 and JUnit4.
Project created using Page Object Pattern approach.
Automation documents: Screenshots of each step are taken during the test.

## Prerequisites Software/Tools

1. Java Development Kit (Java 13)
2. Java Runtime Environment
3. Gradle 6.7
5. Chrome browser Version 86.0.4240.198 (64-bit)
6. Operating System Windows 10

## Tests Scenarios

1. open start page [https://www.google.com/]
2. Accept CookiesAlert
3. Input in Search field box: "wikipedia.com" and click button "Google Search" -> result list
4. Click on Wikipedia link in result list -> open Wikipedia Page
5. Input in Search field box: "Giga Berlin" and click search icon -> open Giga Berlin page
6. Find Coordinates of the location and Logistics and Site Concerns data. -> assertion
7. CTRL+Click on coordinates link of the location -> open new Tab with Geo Links
8. Click on Google Maps icon -> open Google Map Page with location of the Giga Berlin

## Installation/Running Tests

clone https://github.com/esabitova/GigaChallenge.git

or extract files from the archive KollexAutChallenge.zip

$ cd KollexAutChallenge/

$ gradle test

## Contributors

Elena Sabitova eg.sabi@gmail.com
