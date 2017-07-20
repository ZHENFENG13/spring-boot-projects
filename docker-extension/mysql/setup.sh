#!/bin/bash

set -e

echo `service mysql status`

echo '1.启动mysql....'

#启动mysql
service mysql start

sleep 3

echo `service mysql status`
echo 'show databases'

DATABASES=$(mysql -e "show databases")
DATABASE="tale"
echo $DATABASES
echo $DATABASE
if [[ "$DATABASES" =~ "$DATABASE" ]];then

echo '数据库已存在'

else

echo '2.开始导入数据....'
#导入数据
mysql < /mysql/schema.sql

echo '3.导入数据完毕....'

sleep 3
echo `service mysql status`

#重新设置mysql密码
echo '4.开始修改密码....'

mysql < /mysql/privileges.sql

echo '5.修改密码完毕....'

#sleep 3
echo `service mysql status`
echo 'mysql容器启动完毕,且数据导入成功'

fi

tail -f /dev/null