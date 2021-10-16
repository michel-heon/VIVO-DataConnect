#!/bin/bash
source environment.sh

curl -i -d 'email=vivo@uqam.ca' -d 'password=Vivo2435....' -d '@sparql/insert.sparql' 'http://localhost:8080/vivo_i18n/api/sparqlUpdate'