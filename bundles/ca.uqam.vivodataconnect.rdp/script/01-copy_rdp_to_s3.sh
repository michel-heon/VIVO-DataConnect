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
source $SCRIPT_DIR/00-env.sh

EXPERT_RDP=expertises_rdp

echo EXTRACTION DU RÉPERTOIRE RDP
curl --location --request GET 'https://wwt.sitelwebservices.uqam.ca:6002/application/ws_sitel/WS_Sitel_Services_INF.asmx/rechercher_expertises_rdp?p_cle_application='$RDP_PASSWORD > data/$EXPERT_RDP.xml

echo COPIE VERS LE BUCKET S3: s3://$BUCKET_NAME
cd data
xml2json < $EXPERT_RDP.xml | ifne json2rdf http://uqam.ca/data_src/expertises_rdp > $EXPERT_RDP.nt
aws s3 cp $EXPERT_RDP.nt s3://$BUCKET_NAME

