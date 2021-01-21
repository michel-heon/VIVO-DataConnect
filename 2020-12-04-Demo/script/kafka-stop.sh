#!/bin/bash
source environment.sh

sudo systemctl daemon-reload
sudo systemctl disable --now kafka
sudo systemctl disable --now zookeeper
sudo systemctl status kafka zookeeper
