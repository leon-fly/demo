springboot + zookeeper搭建心得
1.模块
	- dubbo服务api（接口定义包）
	- dubbo服务提供者（实现api并注册到zookeeper，@Service注解）
	- dubbo服务消费者（注册zookeeper，@Reference注解）
	
2.springboot的好处在于约定优于配置，尽量少配置特殊内容，尽量使用注解。
3.核心部分：
	1）pom文件，application.properties/yml文件将dubbo及zookeeper相关信息配置进去，注意默认使用的配置项key不能出错，否则找不到对应的配置会创建bean异常。
	2）dubbo由阿里迁移到了apache，如果使用xml配置会出现找不到xsd文件的问题