@ECHO OFF

javac src/*.java src/*/*.java src/*/*/*.java -encoding UTF-8 -d out

cd out

java MainProgram

cd..