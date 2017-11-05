use mysql;

select host, user from user;

create user tale identified by '';

grant all on tale.* to tale@'%' identified by '' with grant option;

flush privileges;

-- privileges.sql