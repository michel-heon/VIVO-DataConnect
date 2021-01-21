#!/bin/bash
source environment.sh

ID=$1
response=$(curl -s -H "Accept: application/vnd.orcid+json"  -H "$ORCID_KEY" "https://pub.orcid.org/v3.0/$ID/record")
echo $response | $DEMO_HOME/script/json2rdf.sh  | cat $DEMO_HOME/script/data/orcibMemberHeader.ttl - | sed 's/ORCIDID/'"$ID"'/g'