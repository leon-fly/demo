FROM openjdk:7
# docker运行主机的工作项目跟目录
WORKDIR /home/ops/workspace/docker-demo

# 对外暴露的端口
EXPOSE 9999

# 复制的jar文件
COPY target/docker-demo-1.0.jar .

# 运行的docker命令
CMD ["java","-jar", "docker-demo-1.0.jar"]
