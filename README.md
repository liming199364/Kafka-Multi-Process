# Kafka-Multi-Process

### 配置VM Option
```-Dtsf_consul_ip=127.0.0.1 -Dtsf_consul_port=8500```

### 配置kafka环境
```
zookeeper-server-start config/zookeeper.properties &  
kafka-server-start config/server.properties &
kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 4 --topic kafka-multi
```
```$xslt
javac -cp "/usr/local/Cellar/kafka/1.1.0/libexec/libs/*" ConsumerTest.java
java -classpath  /usr/local/Cellar/kafka/1.1.0/libexec/libs/*:. ConsumerTest kafka-multi my-group
```