[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/lethaiviet/SeleniumLvl2">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Test Automation Framework</h3>

  <p align="center">
    Test Automation Framework uses Selenium, BDD, TestNg and Allure reports
    <br />
    <a href="https://github.com/lethaiviet/SeleniumLvl2"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/lethaiviet/SeleniumLvl2">View Demo</a>
    ·
    <a href="https://github.com/lethaiviet/SeleniumLvl2">Report Bug</a>
    ·
    <a href="https://github.com/lethaiviet/SeleniumLvl2">Request Feature</a>
  </p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#Issues">Issues</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Website need testing][product-screenshot]](http://www.railway.somee.com/Page/HomePage.cshtml)

You know, Time is not limit but with each person only have about 60 years in life.
This framework maybe not absolutely necessary, but it is available to help out work better and faster.
Save time for our life!

Test Automation Framework uses Selenium, BDD, TestNg and Allure reports to testing the  http://www.railway.somee.com website

### Built With

* [Selenium](http://www.seleniumhq.org/) - The web framework to automate browsers
* [Gradle](https://gradle.org/) - Dependency Management
* [Cucumber](https://cucumber.io/) - Behavior Driven Development (BDD) library
* [Allure reports](http://allure.qatools.ru/) - Reporting
* [Webdriver Manager](https://github.com/bonigarcia/webdrivermanager) - Driver Manager
* [TestNg](https://testng.org/doc/) - a testing framework

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* [Git](https://git-scm.com/downloads)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows)
* [Lombok Plugin on IntelliJ IDEA](https://projectlombok.org/setup/intellij)

### Installation

Clone the repo
   ```sh
   git clone https://github.com/lethaiviet/SeleniumLvl2.git
   ```

<!-- USAGE EXAMPLES -->
## Usage
1. Setup allure path to environment variable
   ```sh
   cmd\00_SetupAllureSever.bat
   ```
2. Run suite
   ```sh
   cmd\01_RunSuite.bat
   ```
3. Generate report and open allure server
   ```sh
   cmd\02_OpenAllureServer.bat
   ```
_For more examples, please refer to the [Documentation](https://example.com)_

<!-- CONTACT -->
## Contact

Le Thai Viet - [lethaiviet92@gmail.com]() 

Project Link: [https://github.com/lethaiviet/SeleniumLvl2](https://github.com/lethaiviet/SeleniumLvl2)



<!-- ISSUES -->
## Issues
Currently, the report is generated allure-testng have the below issue, so the report cannot show all the steps in cucumber
* [Allure Test NG report TestBody is missing](https://stackoverflow.com/questions/57566093/allure-test-ng-report-testbody-is-missing)
* [Test body is missed in report if run test via "java org.testng.TestNG suite.xml"](https://github.com/allure-framework/allure-java/issues/301)
* [Test body is missing in (cucumber) testNG report"](https://github.com/allure-framework/allure-java/issues/398)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/lethaiviet/SeleniumLvl2.svg?style=for-the-badge
[contributors-url]: https://github.com/lethaiviet/SeleniumLvl2/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/lethaiviet/SeleniumLvl2.svg?style=for-the-badge
[forks-url]: https://github.com/lethaiviet/SeleniumLvl2/graphs/network/members
[stars-shield]: https://img.shields.io/github/stars/lethaiviet/SeleniumLvl2.svg?style=for-the-badge
[stars-url]: https://github.com/lethaiviet/SeleniumLvl2/graphs/stargazers
[issues-shield]: https://img.shields.io/github/issues/lethaiviet/SeleniumLvl2.svg?style=for-the-badge
[issues-url]: https://github.com/lethaiviet/SeleniumLvl2/graphs/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]:https://github.com/lethaiviet/SeleniumLvl2/graphs/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[product-screenshot]: images/screenshot.png
