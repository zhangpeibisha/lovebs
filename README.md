# 使用说明
1. 导入依赖
> 浏览器依赖
```xml
<dependency>
    <groupId>org.nix.lovedomain</groupId>
    <artifactId>love-security-browser</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
> app依赖
```xml
<dependency>
    <groupId>org.nix.lovedomain</groupId>
    <artifactId>love-security-app</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
2. 配置信息查看 
> org.nix.lovedomain.security.core.properties.SecurityProperties
> org.nix.lovedomain.security.core.properties.SecurityConstants

3. 增加接口实现
> UserDetailsService

4. 记住我功能
> 在表单中增加 remember-me 字段 且value为 true
> 数据库表为 doc/remeber-me.sql

5. 社交登陆功能
> 实现接口 SocialUserDetailsService
> 添加配置(该配置不可用，请自己配置自己的应用信息)
```yaml
love:
  security:
    social:
      qq:
        # 该应用回调地址为 127.0.0.1 www.ictgu.cn 需要配置
        # 回调地址 http://www.ictgu.cn/login/qq
        appId: 101386962
        appSecret: 2a0f820407df400b84a854d054be8b6a
      filterProcessesUrl: /login
      weixin:
        appId: wxd99431bbff8305a0
        appSecret: 60f78681d063590a469f1b297feff3c4
```
> 创建并配置社交登陆，并实现注册服务（需要配置权限允许）,载服务中使用 
```java
@Autowired
private ProviderSignInUtils providerSignInUtils;
```
> 社交登陆数据库 doc/JdbcUsersConnectionRepository.sql

> 查看用户绑定的社交信息路径 /connect