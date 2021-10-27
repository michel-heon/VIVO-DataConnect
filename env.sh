#!/bin/bash 

###################################################################
# Script Name   : env.sh
# Description   : Configuration de l'environment
# Args          : 
# Author        : Michel Héon   
# Email         : heon.michel@uqam.ca
###################################################################
export PLUGIN_HOME="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

export STARDOG_HOME=/var/opt/stardog
export STARDOG_SERVER_JAVA_ARGS="-Xmx4g -Xms4g -XX:MaxDirectMemorySize=6g"

export PATH=$PATH:$PLUGIN_HOME/bash
