#!/usr/bin/env bash

set -e

# 停止原先运行的容器
docker-compose stop
docker-compose rm -f
#删除停止的容器
docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker rm
#删除名称为none的镜像
docker images|grep none|awk '{print $3 }'|xargs docker rmi
