# 服务启动说明
1. 使用spring-cloud config的先启动config-server
2. 使用eureka作为服务方的先启动eureka-server,否则服务提供方或消费方启动都会注册失败，提示连接拒绝

# 测试地址
1. [euraka服务管理界面](http://localhost:9999/)
2. [euraka服务提供方api](http://localhost:8080/spring-cloud-demo/eureka-provider/hello-world)
3. [访问euraka服务使用方](http://localhost:8081/spring-cloud-demo/eureka-consumer/consume)
4. [带有hystrix服务断路器的eureka服务使用方](http://localhost:8082/spring-cloud-demo/hystrix-eureka-consumer/consume)
5. [通过reign访问eureka服务使用方](http://localhost:8083/spring-cloud-demo/reign-eureka-consumer/consume)