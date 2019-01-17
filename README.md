### 远程调用Java组件

#### 组件的安装
         <dependency>
	         <groupId>com.myhexin</groupId>
	         <artifactId>library</artifactId>
         </dependency>
#### 描述 （如果有什么不对，我想和你一起商讨一下你的方案）
1. 基本使用指南
> 用户调用RemoteCallComponentUtil.request(.....);方法就可以得到自己想要的结果
> 对于 ..... 这些参数，我有个大概的想法

|参数名| 参数意义 | 备注|
|:------:|:--------:|:----:|
| parameter | 参数实体 |我会提供一个参数接口，具体参数封装由用户自定义|
|respones|结果返回映射实体的CLASS对象|通过该对象进行对返回结果的封装|

2. 扩展功能
> 1. 仿照tomcat采用责任链模式开发过滤链，因此带来的扩展空间是可以让用户自定义添加移除功能过滤器，在doFilter(request,respones,chain)前面为请求前置处理，在其后面为请求后置处理，可以方便做各种可拔插的自定义功能。
> 2. 例如 实现一个参数过滤器： 
  
```Java
public class ParamterCheckFilter implement Filter{
  public void doFilter(request,respones,chain{
    request.getAttribute("Paramter");
      ......
  }
}
```
	 然后开始你的操作
> 3. RemoteCallConfig类将用于配置组件的所有参数，比如重试次数，超时时间，过滤器集合，线程池的选择等数据，目前考虑提供方案为：配置文件配置

3. 考虑组件默认带有的功能 （由于之前说过，过滤器可以自由拔插，那么默认实现可以被覆盖的）
> 1. 请求失败名单过滤器，该过滤器主要是对请求超时的请求进行拦截。比如说，一个URL在上次请求中是超时失败，那么该URL将进入失败名单里，下次请求将不再尝试去请求远程服务器，而是直接返回第一次失败的失败信息。但是呢，并不代表这个请求将永久不能使用，使用的条件是，当组件自己通过定时的尝试请求成功后，该URL将从失败名单中移除，下次用户再请求就可以正常通过请求了。
> 2. 日志生成过滤器，该过滤器可以记录用户的请求信息和得到的响应信息，可以方便用户进行程序调试
> 3.缓存过滤器，当组件发现某个（URL+参数）请求会消耗大量的时间，那么这个请求结果将被缓存，并设定缓存时间。

4. 实现你的Servlet
> 1. 改servlet是相当于HTTP中的执行器，你只需要实现该接口并打上@Servlet(url="URL")就可以使用他请求你指定的地址了。
> 2. 使用示例
```Java
@Servlet(url="http://www.myhexin.lib.com"
,description="这是请求同花顺的接口",name="StockServlet")
public class StockServlet extends AbsractServlet{
    @Override
  public void service(Request request,Respones respones){
    // 处理你自己的其他逻辑
    // 如果没有则不处理，后续功能由组件完成
  }
}
```
5. 实现你自己的Requst
> 1. 实现一个示例
```Java
@Requst(description="XXX的请求参数实体",name="MyRequst")
public class MyRequst extends AbsractRequest{
   @Paramter(name="method",description="请求的方法")
   privater String method;
   @Paramter(name="test",description="请求的值")
   privater Integer value;
  // 此处需要你去指定一个servlet
  public Class<? extends Servlet> getServlet(){}
}
```
> 2. 使用说明
     1. 继承AbsractRequest可达到快速配置参数的目的，如果不继承则必须实现Request接口 
	2. @Paramter(name="method",description="请求的方法")注解是用来表示这是一个参数的注解，如果name不存在，则默认为字段值，description字段没有意义，只是用来生成文档使用
	3. @Requst没有实际用处，只是用来生成文档
6. 实现你自己自己的Response
> 1. 实现一个例子
