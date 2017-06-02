# base environment
jdk 1.7
tomcat 8.0
mysql 5.7

### MySQL Config
CREATE SCHEMA `db_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
CREATE USER 'dbblog'@'localhost' IDENTIFIED BY 'dbblog';
GRANT ALL PRIVILEGES ON application.* TO 'dbblog'@'localhost' WITH GRANT OPTION;