@ECHO OFF

javac src/*.java src/felszereles/*.java src/agens/*.java src/jatek/*.java src/Serialization/*.java src/terkep/*.java src/test/*.java src/util/*.java src/virologus/*.java -encoding UTF-8 -d out

cd out

java ProtoProgram