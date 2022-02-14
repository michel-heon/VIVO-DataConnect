#!/bin/bash 

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon PhD
# Institution   : Université du Québec à Montréal
# Copyright     : Université du Québec à Montréal (c) 2022
# Email         : heon.michel@uqam.ca
###################################################################
export SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
source ~/.vivodataconnect_secret.sh
export JENA_HOME=/home/heon/01-SPRINT/2021-11-12-SPRINT-08/VIVO-Studio/plugins/ca.uqam.tool.external.jena_3.17.0/tools/
export PATH=$PATH:$JENA_HOME/bin
export BUCKET_NAME=uqam-rdp


