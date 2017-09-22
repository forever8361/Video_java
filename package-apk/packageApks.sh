#!/usr/bin/env bash

if [ $# -lt 1 ]; then
    echo "error.. need args"
    exit 1
fi
echo "commond is $0"
for arg in "$@"
do
   echo $arg
   cd /home/jay/code/Vpngo/package-apk
   rm -fr output
   redex $arg -o redex.apk
   java -jar AndResGuard/AndResGuard-cli-1.1.13.jar redex.apk -config AndResGuard/config.xml -out AndResGuard/output -signature ../.keystore/yunji.jks 2wsxcderty 2wsxcderty yunji
   mkdir output
   python packer-ng/PackerNg-1.0.7.py AndResGuard/output/redex_signed_7zip_aligned.apk packer-ng/markets.txt output
   cp AndResGuard/output/redex_signed_7zip_aligned.apk output/$arg
   rm -fr AndResGuard/output
   rm redex.apk
done
