# 基础镜像
FROM openjdk:11-jre
  
# 指定工作目录
WORKDIR /app
  
# 将 jar 包添加到工作目录，比如 target/yuoj-backend-user-service-0.0.1-SNAPSHOT.jar
ADD ./target/oj-gateway-0.0.1-SNAPSHOT.jar .
  
# 暴露端口
EXPOSE 8104
  
# 启动命令
ENTRYPOINT ["java","-jar","/app/oj-gateway-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]