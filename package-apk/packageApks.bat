
echo "command is %1"
copy %1 new.apk
java -jar AndResGuard/AndResGuard-cli-1.1.13.jar new.apk -config AndResGuard/config.xml -out AndResGuard/output -signature ../.keystore/yuanai.jks yuanai yuanai yuanai
python packer-ng/PackerNg-1.0.7.py AndResGuard/output/new_signed_7zip_aligned.apk packer-ng/markets.txt output
copy AndResGuard\output\new_signed_7zip_aligned.apk output\%1
rd /s /q AndResGuard\output
del new.apk
