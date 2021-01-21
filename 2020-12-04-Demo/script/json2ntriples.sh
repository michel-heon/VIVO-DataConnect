#!/bin/bash
source environment.sh
cat $1 | java -jar $DEMO_HOME/lib/json2rdf.jar $ORCID_VOC_IRI | riot --formatted=N-Triples
