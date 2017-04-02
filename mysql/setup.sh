#!/bin/bash
set -e
echo `service mysql status`
service mysql start
sleep 10
echo `service mysql status`
service mysql start
sleep 10
echo `service mysql status`
#导入数据
mysql < /mysql/schema.sql
#重新设置mysql密码
mysqladmin -u root password '123456'