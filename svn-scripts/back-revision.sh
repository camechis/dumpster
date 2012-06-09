#!/bin/bash

# Rollback (undo) changes from revision $1 to previous revision $2.

svn update
svn merge -r $1:$2 .
svn commit -m "Rolled back to "$2
