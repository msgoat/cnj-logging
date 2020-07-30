call mvn clean install -P commit-stage
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn clean install -P dockerize-stage -Dtest.target.route=http://localhost:38080
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%

call mvn clean verify -P integration-test-stage -Dtest.target.route=http://k8sapps.at.automotive.msg.team/cnj-security-oidc-backend-javaee
if %ERRORLEVEL% neq 0 exit /b %ERRORLEVEL%
