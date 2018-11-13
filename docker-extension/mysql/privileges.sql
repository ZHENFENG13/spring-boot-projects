use mysql;

select host, user from user;

create user tale identified by 'P4)P/n+n#.xK';

grant all on tale.* to tale@'%' identified by 'P4)P/n+n#.xK' with grant option;

flush privileges;

-- privileges.sql