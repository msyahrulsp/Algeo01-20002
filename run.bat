@echo off

cd %CD%/src/

echo Compiling Program...
javac -d ../bin ./Main.java

echo Running Program...
cd ..
cd %CD%/bin/
java Main
cd ..
PAUSE