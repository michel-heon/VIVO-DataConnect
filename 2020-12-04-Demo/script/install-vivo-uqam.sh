#!/bin/bash
source environment.sh
cd $GIT_VIVO/vivo-installer-uqam
mvn -T 1.5C -s settings.xml -DskipTests=true clean install 