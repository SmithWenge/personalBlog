   base environment
jdk 1.7
tomcat 8.0
mysql 5.7

   MySQL Config
CREATE SCHEMA `db_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
CREATE USER 'dbblog'@'localhost' IDENTIFIED BY 'dbblog';
GRANT ALL PRIVILEGES ON application.* TO 'dbblog'@'localhost' WITH GRANT OPTION;

   发布需注意
1.修改ueditor的配置文件，前缀改成主机名
2.修改lucene索引目录
3.将lib下的ueditor-1.1.2.jar包添加到项目环境中