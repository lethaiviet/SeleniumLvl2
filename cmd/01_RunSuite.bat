@ECHO OFF
@ECHO Executing: %~f0

SETLOCAL
SET CURRENT_PATH=%~dp0
CALL %CURRENT_PATH%Env.bat

PUSHD %WORKSPACE%
SET CMD=gradlew clean test
ECHO RUN TEST
ECHO %CMD%
CALL %CMD%
POPD

ENDLOCAL