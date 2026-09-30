FROM amazoncorretto:25
LABEL authors="MSR"
EXPOSE 8080
ADD target/sb-k8s-demo.jar sb-k8s-demo.jar
ENTRYPOINT ["java","-jar","/sb-k8s-demo.jar"]
