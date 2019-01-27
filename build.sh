#!/bin/bash
find . -name *.java -print >javafiles
javac -d bin -source 8 -target 8 @javafiles
jar -cvfm monapp.jar manifest.mf -C bin/ .
