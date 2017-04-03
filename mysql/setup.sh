#!/bin/bash
set -e
echo `service mysql status`
#启动mysql
service mysql start
sleep 10
echo `service mysql status`
#导入数据
mysql < /mysql/schema.sql
#停止mysql
service mysql stop
#以不启用grant-tables模式启动mysql
mysqld_safe --skip-grant-tables &
echo `service mysql status`
#重新设置mysql密码
mysql < /mysql/editpassword.sql
service mysql start
sleep 10
echo `service mysql status`