#!/bin/bash
source environment.sh

cat records/*_name.n3 > all_name.n3
cp all_name.n3 /home/heon/Documents/UQAM-DEV/vivo/home/rdf/abox/filegraph
