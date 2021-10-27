#!/bin/bash  -x

###################################################################
# Script Name   :
# Description   :
# Args          : 
# Author       	: Michel Héon PhD
# Institution   : Université du Québec à Montréal
# Copyright     : Université du Québec à Montréal (c) 2021
# Email         : heon.michel@uqam.ca
###################################################################


function prop {
    grep "${1}" ../resources/ldap.properties|cut -d'=' -f2-
}
inputfile="$1"
password=$(prop 'password')
searchKey="'(uqamEduPersonNomUniteRegroupement=SPUQ)'"
login="uid="$(prop 'username')
ldapsearch -H ldaps://$(prop 'address'):$(prop 'port') -D "$login" -b "ou=personnes,dc=code,dc=uqam,dc=ca" "(uqamEduPersonNomUniteRegroupement=*)" -w "$password" | grep uqamEduPersonNomUniteRegroupement: | grep -v :: | sort | uniq -c | cut -f 2 -d ':'