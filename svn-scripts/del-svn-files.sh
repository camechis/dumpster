# Remove all the .svn directories below the current directory tree
# Credit: Zed Shaw, at the Mongrel mailing list.

#!/bin/bash

find . -name ".svn" -exec rm -rf {} \;
