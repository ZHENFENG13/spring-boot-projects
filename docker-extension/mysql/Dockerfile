FROM mysql:5.7

#这条语句可有可无
ENV MYSQL_DATABASE test

#设置免密登录
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes

#将所需文件放到容器中
COPY setup.sh /mysql/setup.sh
COPY schema.sql /mysql/schema.sql
COPY editpassword.sql /mysql/editpassword.sql

#设置容器启动时执行的命令
CMD ["sh", "/mysql/setup.sh"]