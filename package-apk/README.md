## 一键打包
目前仅支持Linux。


## 使用

一键集成在packageApks.sh脚本中，执行如下：
```bash
./packageApks.sh ***.apk
```
最终各渠道包会生成在output文件夹中。

## 原理

最后打包做以下三步：

1. redex

2. 微信压缩

3. 多渠道packer-ng
