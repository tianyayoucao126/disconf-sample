#!/bin/bash
cd ../../../
gradle pack -x test
cd build/install/disconf-sample
mv lib/* ../
cd ../
rm -rf disconf-sample
mkdir -p lib
mkdir -p bin
mv resources lib
mv *.jar lib
cp ../../src/main/sh/start.sh ./bin
