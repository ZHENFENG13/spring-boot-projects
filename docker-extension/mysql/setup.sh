#!/bin/bash

set -e

#比较字符串的函数
haveDatabase(){
	DATABASES=$1
	DATABASE=$2
	result=$(echo $DATABASES | grep "${DATABASE}")
	if [[ "$result" != "" ]]
 	then
  	   	return 1
 	else
    	return 0
	 fi
}

echo `service mysql status`

echo '1.启动mysql....'

#启动mysql
service mysql start

sleep 3

echo `service mysql status`
echo '2.开始导入数据....'

echo 'SHOW DATABASES'

DATABASES=`mysql> SHOW DATABASES;`

haveDatabase $DATABASES "tale"
if [ $? -ne 1 ];then
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

else

echo '数据库已存在'

fi

tail -f /dev/null