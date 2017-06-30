#!/bin/bash
set -e

#因为要等待mysql用户和权限设置完成
echo '等待mysql.....'

sleep 25

echo '开始启动项目.....'
nohup java -jar /app.jar