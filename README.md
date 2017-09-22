# 张东方-LezVideo
这是一个类似开眼的一个视频应用，以下是Android端的工作开展。


* 开发人员：张东方 
* 周期：2周
* 工作量：30个界面

![Screenshot_2017-03-01-16-32-54.png](https://pm-box.tisp.com/public/7,039a889e4173)![Screenshot_2017-03-01-16-33-04.png](https://pm-box.tisp.com/public/5,039bc0ee11d5)
![Screenshot_2017-03-01-16-33-11.png](https://pm-box.tisp.com/public/3,039ccb95e350)![Screenshot_2017-03-01-16-33-17.png](https://pm-box.tisp.com/public/3,039d9374acbd)
![Screenshot_2017-03-01-16-33-24.png](https://pm-box.tisp.com/public/6,039e3c10a526)![Screenshot_2017-03-01-16-33-33.png](https://pm-box.tisp.com/public/4,039fa1e3138c)
## 1.服务端概要设计
#### 1.1系统架构
![LezVideo_Project_Architecture](https://pm-box.tisp.com/public/4,01dd1bd24098)
因为在相交项目中七牛上已经存在一些视频资源，结合自己的服务端api可以直接拿来用。也可以抓取外部app的一些视频资源的api。所以数据源有两个：七牛和外部抓取。
#### 1.2模块划分
根据需求可能的模块划分如下：

* 注册登陆模块
* 用户模块
* 视频列表模块
* 推荐模块
* 分类模块
* 搜索模块
* ...

#### 1.3数据交换
服务端和客户端使用json交换数据，使用自定义JSON格式，约定返回code,msg,data
```
{
    "code":500,
    "msg":"系统异常，请稍后重试",
    "data":""
}
```
## 2.Android客户端
#### 2.1基本结构
这个项目我不打算引入MVP或MVVM。处于项目本身和之前使用mvp后的经验。
![LezVideo_Code_Architecture](http://upload-images.jianshu.io/upload_images/4697074-83e4cfc7865bf555.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#### 2.2功能划分
注册登陆；个人信息；视频推荐，分类，播放；搜索；分享；系统设置等等
#### 2.3快速高效开发
* 界面开发———————>APK反编译外部App,获取资源文件，界面设计按照主流风格。
截图如下：
  ![LezVideo_ui_Architecture](https://pm-box.tisp.com/public/2,01dce7b7b76b)
* 第三方登陆和分享——————>公司内部封装的sdk
* 网络———————>rx响应式
* 事件———————>event第三方库
* 自动更新——————>封装的更新库
* debug调试——————>Stetho
* 代码检测——————>代码，字符串，颜色，lint,PMD,FindBugs,CheckStyle
* 性能优化——————>界面布局，OverDraw,LeakCanary,ANR,BlockCanary,Monkey...

#### 2.4接口测试

