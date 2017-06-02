DROP DATABASE IF EXISTS db_blog;
/*�������ݿ⣬�����ñ���*/
CREATE DATABASE db_blog DEFAULT CHARACTER SET utf8;

USE db_blog;

CREATE TABLE `t_blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `username` VARCHAR(50) NOT NULL COMMENT '��������',
  `password` VARCHAR(100) NOT NULL COMMENT '��������',
  `profile` TEXT COMMENT '������Ϣ',
  `nickname` VARCHAR(50) DEFAULT NULL COMMENT '�����ǳ�',
  `sign` VARCHAR(100) DEFAULT NULL COMMENT '����ǩ��',
  `imagename` VARCHAR(100) DEFAULT NULL COMMENT '����ͷ��·��',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `t_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '�������ӱ�id',
  `linkname` VARCHAR(100) DEFAULT NULL COMMENT '����������',
  `linkurl` VARCHAR(200) DEFAULT NULL COMMENT '��������url',
  `orderNum` INT(11) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blogtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `typeName` VARCHAR(30) DEFAULT NULL COMMENT '�������',
  `orderNum` INT(11) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '��������',
  `title` VARCHAR(200) NOT NULL COMMENT '������Ŀ',
  `summary` VARCHAR(400) DEFAULT NULL COMMENT '����ժҪ',
  `releaseDate` DATETIME DEFAULT NULL COMMENT '��������',
  `clickHit` INT(11) DEFAULT NULL COMMENT '���۴���',
  `replyHit` INT(11) DEFAULT NULL COMMENT '�ظ�����',
  `content` TEXT COMMENT '��������',
  `keyWord` VARCHAR(200) DEFAULT NULL COMMENT '�ؼ���',
  `type_id` INT(11) DEFAULT NULL COMMENT '��������������',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '���۱�id',
  `userIp` VARCHAR(50) DEFAULT NULL COMMENT '�����ߵ�ip',
  `content` VARCHAR(1000) DEFAULT NULL COMMENT '��������',
  `commentDate` DATETIME DEFAULT NULL COMMENT '��������',
  `state` INT(11) DEFAULT NULL COMMENT '���״̬',
  `blog_id` INT(11) DEFAULT NULL COMMENT '����������岩��',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


