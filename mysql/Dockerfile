FROM mysql:5.7
ENV MYSQL_ROOT_PASSWORD 123456
ENV MYSQL_DATABASE tale
COPY setup.sh /mysql/setup.sh
COPY schema.sql /mysql/schema.sql
RUN /mysql/setup.sh