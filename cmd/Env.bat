@ECHO OFF

SET CURRENT_PATH=%~dp0
SET WORKSPACE=%CURRENT_PATH%..

SET BUILD_PATH=%WORKSPACE%\build
SET TOOL_PATH=%WORKSPACE%\tool

SET ALLURE_EXE=%TOOL_PATH%\allure-commandline-2.13.9\bin\allure.bat
SET ALLURE_BIN=%TOOL_PATH%\allure-commandline-2.13.9\bin\
SET ALLURE_RESULTS=%WORKSPACE%\allure-results
SET ALLURE_REPORT=%WORKSPACE%\allure-report
