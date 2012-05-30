#!/bin/bash

svn status | grep "^\!" | sed 's/^\! *//g' | xargs svn rm
