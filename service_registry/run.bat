cd target
cd
start /B java -jar -Dserver.port=8999 -Dspring.profiles.active=default service_registry-1.0.jar  > output.log 2>&1