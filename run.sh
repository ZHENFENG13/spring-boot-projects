#!/usr/bin/env bash

set -e

# 打包并创建镜像
mvn clean install -Dmaven.test.skip=true
#如果已经创建好镜像,这一步要注释掉,避免重复操作(不注释也可以)
#mvn clean install -Dmaven.test.skip=true

# 停止原先运行的容器
docker-compose stop
docker-compose rm -f

# 使用docker-compose启动多容器应用
docker-compose up -d

# 日志
docker-compose logs
