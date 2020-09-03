# 指定基础镜像 这里springboot项目运行只需要java jdk环境即可
FROM java:latest
# 维护者信息
MAINTAINER zhuqinyue <zqyynl@163.com>
#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /opt/springboot
#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
ADD target/system-v1.jar /opt/springboot/system-v1.jar
#给app.sh赋予可执行权限
#RUN chmod +x /app.sh
# 重命名
# 对外暴漏的端口号
EXPOSE 80
# 运行
# 方式一
#ENTRYPOINT ["/app.sh"]
ENTRYPOINT ["java", "-jar", "/opt/springboot/system-v1.jar"]
# 方式二
