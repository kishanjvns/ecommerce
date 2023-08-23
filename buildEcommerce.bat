@echo off

set PROJECTS=admin cartprocessing centeralconfig customer delivery inventory notification order payment review reward seller-partners support user-management

for %%p in (%PROJECTS%) do (
    echo Running Maven clean install for project: %%p
    cd %%p
    mvn clean install -Dspring.profiles.active=test
    cd ..
    echo.
)

echo All projects have been built.