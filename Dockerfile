FROM maven:3.8.1-openjdk-11 AS builder
#ENV http_proxy http://inet.bni.co.id:8080
#ENV https_proxy http://inet.bni.co.id:8080
#ENV DEBIAN_FRONTEND noninteractive

#make necessary dirs
RUN mkdir -p /app/bank-zulfikar
WORKDIR /app
COPY ./ /app/bank-zulfikar/
#clone repo
# RUN git clone -c http.proxy= -c http.sslVerify=false https://support:support123@192.168.68.123:3000/SOA-API-DEV/bank-zulfikar.git --branch development

#build jar
WORKDIR /app/bank-zulfikar
RUN mvn package

#this is the real container
FROM openjdk:11-jre-slim
#ENV http_proxy http://inet.bni.co.id:8080
#ENV https_proxy http://inet.bni.co.id:8080
#ENV DEBIAN_FRONTEND noninteractive

#create dirs
RUN mkdir -p /app/logs
# RUN mkdir /run/wsdl_coreService/

WORKDIR /app
COPY --from=builder /app/bank-zulfikar/target/bank-zulfikar-0.0.1-SNAPSHOT.jar /app/bank-zulfikar/bank-zulfikar-0.0.1-SNAPSHOT.jar
#COPY --from=builder /app/bank-zulfikar/log4j2-spring.xml /app/bank-zulfikar
#COPY --from=builder /app/bank-zulfikar/timezone /etc
#COPY --from=builder /app/bank-zulfikar/lib/* /app/bank-zulfikar/lib/

#ENV http_proxy=
#ENV https_proxy=
WORKDIR /app/bank-zulfikar

ENV PORT=8080

EXPOSE 8080
#run the main app
ENTRYPOINT ["java","-jar","bank-zulfikar-0.0.1-SNAPSHOT.jar"]

