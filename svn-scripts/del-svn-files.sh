# Apaga todos os diretórios .svn em baixo de uma árvore
# Credit: Zed Shaw, at the Mongrel mailing list.

#!/bin/bash

find . -name ".svn" -exec rm -rf {} \;
