# eureka consumer demo

eureka 服务消费端

	集成 feign、hystrix

	其中 hystrix 开启监控需要在 Application 中使用注解 @EnableHystrix, 同时依赖 actuator

	actuator 单独使用，management.security.enabled=true 会控制权限