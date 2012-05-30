#!/bin/bash

#Voltando da revisão atual (150) para a antiga (140)

svn update
svn merge -r 150:140 .
svn commit -m "Rolled back to r140"
