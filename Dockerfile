FROM ubuntu:20.04 AS builder
WORKDIR /app
COPY . .
RUN sed -i 's/archive.ubuntu.com/mirrors.aliyun.com/g' /etc/apt/sources.list &&\
    sed -i 's/security.ubuntu.com/mirrors.aliyun.com/g' /etc/apt/sources.list && \
    apt-get update &&\
    apt-get install -y --no-install-recommends openjdk-17-jdk  &&\
    apt-get install -y curl &&\
    rm -rf /var/lib/apt/lists/* &&\
    curl -fsSL -o /tmp/apache-maven.tar.gz https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz && \
    tar -xzf /tmp/apache-maven.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.5 /opt/maven && \
    rm /tmp/apache-maven.tar.gz

# 配置环境变量
ENV PATH="/opt/maven/bin:$PATH"
RUN mvn clean package


FROM ubuntu:20.04
WORKDIR /NeoCache
COPY --from=builder /app/target/NeoCache-0.0.1-SNAPSHOT.jar /NeoCache/bin/
RUN chmod 755 /NeoCache/bin/NeoCache-0.0.1-SNAPSHOT.jar && \
    sed -i 's/archive.ubuntu.com/mirrors.aliyun.com/g' /etc/apt/sources.list &&\
    sed -i 's/security.ubuntu.com/mirrors.aliyun.com/g' /etc/apt/sources.list && \
    apt-get update &&\
    apt-get install -y --no-install-recommends openjdk-17-jre &&\
    rm -rf /var/lib/apt/lists/*
LABEL authors="lzy"
CMD ["java","-jar","/NeoCache/bin/NeoCache-0.0.1-SNAPSHOT.jar"]
