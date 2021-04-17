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
      <ul>
        <li><a href="#built-with">Folder Structure</a></li>
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

You know, Time is not limit but with each person only have about 60 years in life. This framework maybe not absolutely
necessary, but it is available to help out work better and faster. Save time for our life!

Test Automation Framework uses Selenium, BDD, TestNg and Allure reports to testing the  http://www.railway.somee.com
website

### Built With

* [Selenium](http://www.seleniumhq.org/) - The web framework to automate browsers
* [Gradle](https://gradle.org/) - Dependency Management
* [Cucumber](https://cucumber.io/) - Behavior Driven Development (BDD) library
* [Allure reports](http://allure.qatools.ru/) - Reporting
* [Webdriver Manager](https://github.com/bonigarcia/webdrivermanager) - Driver Manager
* [TestNg](https://testng.org/doc/) - a testing framework

### Folder Structure

<details><summary>CLICK ME</summary>

- __https://github.com/lethaiviet/SeleniumLvl2__
    - [README.md](README.md)
    - [build.gradle](build.gradle)
    - __cmd__
        - [00\_SetupAllureSever.bat](cmd/00_SetupAllureSever.bat)
        - [01\_RunSuite.bat](cmd/01_RunSuite.bat)
        - [02\_OpenAllureServer.bat](cmd/02_OpenAllureServer.bat)
        - [03\_OpenExtentReport.bat](cmd/03_OpenExtentReport.bat)
        - [Env.bat](cmd/Env.bat)
    - __gradle__
        - __wrapper__
            - [gradle\-wrapper.jar](gradle/wrapper/gradle-wrapper.jar)
            - [gradle\-wrapper.properties](gradle/wrapper/gradle-wrapper.properties)
    - [gradlew](gradlew)
    - [gradlew.bat](gradlew.bat)
    - __images__
        - [allure\_report.png](images/allure_report.png)
        - [extent\_report.png](images/extent_report.png)
        - [logo.png](images/logo.png)
        - [screenshot.png](images/screenshot.png)
    - [settings.gradle](settings.gradle)
    - __src__
        - __main__
            - __java__
                - __commons__
                    - [Constants.java](src/main/java/commons/Constants.java)

                    - __enums__
                        - [Dropdown.java](src/main/java/commons/enums/Dropdown.java)
                        - [NavBar.java](src/main/java/commons/enums/NavBar.java)
                        - [PageURL.java](src/main/java/commons/enums/PageURL.java)
                - __controls__
                    - __base__
                        - [IBaseControl.java](src/main/java/controls/base/IBaseControl.java)
                        - [IClickable.java](src/main/java/controls/base/IClickable.java)
                        - [IEditable.java](src/main/java/controls/base/IEditable.java)
                        - __imp__
                            - [Action.java](src/main/java/controls/base/imp/Action.java)
                            - [BaseControl.java](src/main/java/controls/base/imp/BaseControl.java)
                            - [Clickable.java](src/main/java/controls/base/imp/Clickable.java)
                            - [Editable.java](src/main/java/controls/base/imp/Editable.java)
                    - __common__
                        - [IButton.java](src/main/java/controls/common/IButton.java)
                        - [IComboBox.java](src/main/java/controls/common/IComboBox.java)
                        - [IElement.java](src/main/java/controls/common/IElement.java)
                        - [ILabel.java](src/main/java/controls/common/ILabel.java)
                        - [ITextBox.java](src/main/java/controls/common/ITextBox.java)
                        - __imp__
                            - [Button.java](src/main/java/controls/common/imp/Button.java)
                            - [ComboBox.java](src/main/java/controls/common/imp/ComboBox.java)
                            - [Element.java](src/main/java/controls/common/imp/Element.java)
                            - [Label.java](src/main/java/controls/common/imp/Label.java)
                            - [TextBox.java](src/main/java/controls/common/imp/TextBox.java)
                - __data__
                    - [TicketInfo.java](src/main/java/data/TicketInfo.java)
                    - [UserInfo.java](src/main/java/data/UserInfo.java)
                - __drivers__
                    - [ChromeDriver.java](src/main/java/drivers/ChromeDriver.java)
                    - [DriverFactory.java](src/main/java/drivers/DriverFactory.java)
                    - [DriverManager.java](src/main/java/drivers/DriverManager.java)
                    - [FirefoxDriver.java](src/main/java/drivers/FirefoxDriver.java)
                - __pages__
                    - [BasePage.java](src/main/java/pages/BasePage.java)
                    - [BookTicketPage.java](src/main/java/pages/BookTicketPage.java)
                    - [HomePage.java](src/main/java/pages/HomePage.java)
                    - [LoginPage.java](src/main/java/pages/LoginPage.java)
                    - [MyTicketPage.java](src/main/java/pages/MyTicketPage.java)
                    - [RegisterPage.java](src/main/java/pages/RegisterPage.java)
                - __utils__
                    - [CacheHelper.java](src/main/java/utils/CacheHelper.java)
                    - [DriverUtils.java](src/main/java/utils/DriverUtils.java)
                    - [JsonHelper.java](src/main/java/utils/JsonHelper.java)
                    - [JsonLocatorUtils.java](src/main/java/utils/JsonLocatorUtils.java)
                    - [LogUtils.java](src/main/java/utils/LogUtils.java)
                    - [ScraperHelper.java](src/main/java/utils/ScraperHelper.java)
                    - [StringHelper.java](src/main/java/utils/StringHelper.java)
                    - [UserInfoUtils.java](src/main/java/utils/UserInfoUtils.java)
                    - [common.java](src/main/java/utils/common.java)
            - __resources__
        - __test__
            - __java__
                - __definitions__
                    - [BookTicketDefinition.java](src/test/java/definitions/BookTicketDefinition.java)
                    - [CommonDefinition.java](src/test/java/definitions/CommonDefinition.java)
                    - [Hook.java](src/test/java/definitions/Hook.java)
                    - [LoginDefinition.java](src/test/java/definitions/LoginDefinition.java)
                    - [MyTicketDefinition.java](src/test/java/definitions/MyTicketDefinition.java)
                    - [RegisterDefinition.java](src/test/java/definitions/RegisterDefinition.java)
                - __test__
                    - [BookTicketValidation.java](src/test/java/test/BookTicketValidation.java)
                    - [CommonValidation.java](src/test/java/test/CommonValidation.java)
                    - [LoginValidation.java](src/test/java/test/LoginValidation.java)
                    - [MyTicketValidation.java](src/test/java/test/MyTicketValidation.java)
                    - [RegisterValidation.java](src/test/java/test/RegisterValidation.java)
            - __resources__
                - __data__
                    - __dataExcel__
                        - [user\_info.xlsx](src/test/resources/data/dataExcel/user_info.xlsx)
                    - __dataJson__
                        - [user\_info.json](src/test/resources/data/dataJson/user_info.json)
                - __features__
                    - [book\_ticket\_validation.feature](src/test/resources/features/book_ticket_validation.feature)
                    - [login\_validation.feature](src/test/resources/features/login_validation.feature)
                    - [my\_ticket\_validation.feature](src/test/resources/features/my_ticket_validation.feature)
                    - [register\_validation.feature](src/test/resources/features/register_validation.feature)
                - __locators__
                    - [JsonLocators.json](src/test/resources/locators/JsonLocators.json)
                - __suites__
                    - [suite01.xml](src/test/resources/suites/suite01.xml)
                - [log4j.properties](src/test/resources/log4j.properties)
                - [allure.properties](src/test/resources/allure.properties)
                - [extent.properties](src/test/resources/extent.properties)
- __tool__
    - __allure\-commandline\-2.13.9__
    - __converterTool__
        - [ConverterExcelAndJson.exe](tool/converterTool/ConverterExcelAndJson.exe)

</details>

<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally. To get a local copy up and
running follow these simple example steps.

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
   [![allure-report][allure-report]](https://github.com/lethaiviet/SeleniumLvl2/blob/master/images/allure_report.png)
4. Or Open extent report
   ```sh
   cmd\03_OpenExtentReport.bat
   ```
   [![extent-report][extent-report]](https://github.com/lethaiviet/SeleniumLvl2/blob/master/images/extent_report.png)

<!-- CONTACT -->

## Contact

Le Thai Viet - [lethaiviet92@gmail.com]()

Project Link: [https://github.com/lethaiviet/SeleniumLvl2](https://github.com/lethaiviet/SeleniumLvl2)



<!-- ISSUES -->

## Issues

Currently, the report is generated allure-testng have the below issue, so the report cannot show all the steps in
cucumber

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

[allure-report]: images/allure_report.png

[extent-report]: images/extent_report.png
