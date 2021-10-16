#!/bin/bash
source environment.sh

sudo systemctl daemon-reload
sudo systemctl enable --now zookeeper
sudo systemctl enable --now kafka
sudo systemctl status kafka zookeeper
