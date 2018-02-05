<h2>base environment</h2>
<li>jdk 1.7</li>
<li>tomcat 8.0</li>
<li>mysql 5.7</li>

<br>

<h2>MySQL Config</h2>
<li>CREATE SCHEMA `db_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;</li>
<li>CREATE USER 'dbblog'@'localhost' IDENTIFIED BY 'dbblog';</li>
<li>GRANT ALL PRIVILEGES ON application.* TO 'dbblog'@'localhost' WITH GRANT OPTION;</li>

<br>

<h2>发布需注意</h2>
<li>1.修改ueditor的配置文件，前缀改成主机名(static/ueditor1_4_3_3/jsp/config.json)</li>
<li>2.修改lucene索引目录(/data/blog_index)</li>
<li>3.将lib下的ueditor-1.1.2.jar包添加到项目环境中</li>
<li>4.下载文件目录(/data/resources/)</li>