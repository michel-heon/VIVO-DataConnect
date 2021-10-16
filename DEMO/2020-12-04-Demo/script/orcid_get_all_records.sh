#!/bin/bash
source environment.sh

for n in `$DEMO_HOME/script/orcid_search_uqam.sh` ; do
    ((i=i+1))
    ((j=j+1))
    echo process $i $n
    $DEMO_HOME/script/orcid_get_record.sh $n > $DEMO_HOME/script/records/$n.ttl &
    if [ $j = "5" ]; then
    echo 'waiting...'
    wait
    ((j=0))
    fi
done
echo "Done!"