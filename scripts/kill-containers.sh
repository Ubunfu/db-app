#!/bin/bash
CONTAINERS=$(docker container ls -aq)
docker container rm $CONTAINERS
