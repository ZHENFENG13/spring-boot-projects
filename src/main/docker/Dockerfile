FROM java:8
VOLUME /tmp
ADD *.jar app.jar
COPY startup.sh /startup.sh
RUN bash -c 'touch /app.jar'
CMD ["sh", "/startup.sh"]