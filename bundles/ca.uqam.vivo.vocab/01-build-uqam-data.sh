#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon PhD
# Institution   : Université du Québec à Montréal
# Copyright     : Université du Québec à Montréal (c) 2021
# Email         : heon.michel@uqam.ca
###################################################################
export SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
source $SCRIPT_DIR/00-env.sh
mvn org.codehaus.mojo:exec-maven-plugin:java@uqam-organization &
mvn org.codehaus.mojo:exec-maven-plugin:java@uqam-event &
mvn org.codehaus.mojo:exec-maven-plugin:java@uqam-people &
mvn org.codehaus.mojo:exec-maven-plugin:java@uqam-research &
mvn org.codehaus.mojo:exec-maven-plugin:java@uqam-data &
wait
mvn install -Dexec.skip=true
echo "DONE!"

