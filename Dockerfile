FROM java:8
MAINTAINER xuejike "xuejike2004@126.com"
ENV TZ=Asia/Shanghai
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime

COPY /build/libs/jk-faststart-0.0.1-SNAPSHOT.jar  /server.jar
EXPOSE 8080
CMD java -jar server.jar
