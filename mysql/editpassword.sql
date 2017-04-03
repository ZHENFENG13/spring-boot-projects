use mysql;

update user set Password=PASSWORD("123456") where user="root";

flush privileges;

exit;