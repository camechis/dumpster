# Register all files that were manually delete on SVN as deleted (sync)

#!/bin/bash

svn status | grep "^\!" | sed 's/^\! *//g' | xargs svn rm
