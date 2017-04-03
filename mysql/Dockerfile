FROM mysql:5.7
ENV MYSQL_DATABASE test
ENV MYSQL_ALLOW_EMPTY_PASSWORD yes
COPY setup.sh /mysql/setup.sh
COPY schema.sql /mysql/schema.sql
COPY editpassword.sql /mysql/editpassword.sql
CMD ["sh", "/mysql/setup.sh"]