#!/bin/bash

profile=${1:-production}

DIR=`dirname $0`
cd $DIR

java -jar lib/${project.artifactId}-${project.version}.jar \
  --spring.profiles.active=$profile \
  $*