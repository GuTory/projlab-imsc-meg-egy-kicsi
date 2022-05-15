@ECHO OFF

javac src/*.java src/agens/*.java src/felszereles/*.java src/Graphics/*.java src/jatek/*.java src/terkep/*.java src/test/*.java src/util/*.java src/Graphics/ActionFrames/*.java src/virologus/*.java -encoding UTF-8 -d out

cd out

java MainProgram

cd..