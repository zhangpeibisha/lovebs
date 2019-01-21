### 模块信息

  服务名字   | 端口号    |  描述  
 --------  | -----   | ----
 love-eureka-service | 9000 | 注册中心
 love-zuul-service | 9010 | 网管ZUUL
 love-blog-application | 9020 | 博客应用
 love-oauth2-service | 9030 | 授权中心






#### 读书/参考文献

* OAuth2 in Action   作者：Justin and Antonio
* [SSO 使用学习例子](https://github.com/lexburner/oauth2-demo)
* [MD 语法学习](https://www.jianshu.com/p/96ecaa2cc989)
* [Swagger使用指南](https://blog.csdn.net/sanyaoxu_2/article/details/80555328)
* [springmvc校验注解](https://blog.csdn.net/pbyang_love/article/details/80553760)
* [GIT HUB README 语法](https://blog.csdn.net/qq_31796651/article/details/80803599)
* [通用框架WIKI-HU TOOL](http://hutool.mydoc.io/undefined)
* [Mockito浅谈](https://blog.csdn.net/guijiaoba/article/details/51945873#%E6%A8%A1%E6%8B%9F%E5%AF%B9%E8%B1%A1)
* [验证码谷歌生成器](https://blog.csdn.net/baidu_34211956/article/details/83007025)
* [验证码谷歌生成器配置信息](https://blog.csdn.net/elephantboy/article/details/52795309)

#### 不知道的知识
* ServletWebRequest
* SessionStrategy

### 一般API
{domain}:http://localhost:9030/swagger-ui.html
### 特殊API
接口名字 | url | 参数 | 说明
------|------|---- | ----
获取验证码|/verification|/{type} | type目前包含 sms：获取短信验证码 image: 获取图片验证码
验证码验证码|/**|sms|在你请求的路径中带上sms名字的参数并在这个参数上面赋值即可
验证图片验证码|/**|image|在你请求的路径中带上image名字的参数并在这个参数上面赋值即可
图片验证码登陆路径|/authentication/form|username password image|username: 用户名、邮箱、手机号码 password:用户密码 image: 图片验证码显示的文字
手机验证码登陆路径|/authentication/mobile|phone sms|phone: 用户手机号码 sms:发送到用户手机上的信息


### 注意事件 以todo标识需要在上线后处理
* org.nix.zpbs.utils.social.SocialConfig