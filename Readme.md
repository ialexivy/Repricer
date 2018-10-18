docker run --name=feedsql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=feedvisor -d mysql

docker run --name feedadmin -d --link feedsql:db -p 8080:80 phpmyadmin/phpmyadmin 
