@echo off

set PROJECTS=admin cartprocessing centeralconfig customer delivery inventory notification order payment review reward seller-partners support user-management

for %%p in (%PROJECTS%) do (
    echo Running Java for project: %%p
    cd %%p\target
    java -jar %%p-0.0.1-SNAPSHOT.jar
	popd
    cd ..\..
    echo.
)

echo All projects have been executed.
