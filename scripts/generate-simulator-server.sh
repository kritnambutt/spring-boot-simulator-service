#!/bin/bash

cd "$(dirname "$0")"/..

rm -rf target 
mvn clean generate-sources -P openapi-server 
cd target/generated-sources/main/java/com/aiaplushk 
cp -r server ../../../../../../src/main/java/com/aiaplushk
cd - >/dev/null  
rm -rf target 
