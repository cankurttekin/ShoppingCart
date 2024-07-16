FROM openjdk:17
MAINTAINER cankurttekin
COPY ./target/production/market/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","market"]