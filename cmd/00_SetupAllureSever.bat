@ECHO OFF
@ECHO Executing: %~f0

SETLOCAL
SET CURRENT_PATH=%~dp0
CALL %CURRENT_PATH%Env.bat

SET CMD=SETX PATH "%path%;%ALLURE_BIN%"

WHERE /Q allure
IF ERRORLEVEL 1 (
    ECHO %CMD%
    CALL %CMD%
) ELSE (
    ECHO Application exists. Let's go!
)
ENDLOCAL