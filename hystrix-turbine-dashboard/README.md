# hystrix dashboard 

加入：

. 聚合 turbine

. 服务发现 eureka

注意：

	turbine.aggregator.clusterConfig=COMPUTE-CONSUMER
	
	turbine.appConfig=compute-consumer
	
	#turbine.clusterNameExpression= new String("default")
	

 clusterConfi 需要与 eureka 上的被监控应用名一致，最好大写  
 
 填入url时为 
 
 	http://turbine.server:port/turbine.stream?cluster=COMPUTE-CONSUMER
 
    或
    
    http://hystrix.client:port/hystrix.stream
    
    