# TREEEASY

CRUD de registro usando as seguintes tecnologias:

- JAVA
- HIBERNATE;
- ANGULARJS
- Banco de dados MYSQL;

Executando o projeto:

- Na pasta build/libs, se encontra o .war do projeto;
- Criar a base de dados conforme especificação abaixo:

URL = jdbc:mysql://localhost:3306/treasy

USER = root

PASSWORD = treasy


Executar o CREATE TABLE:

CREATE TABLE `treedata` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `subpid` int(5) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

Após inserir o treeeasy.war no tomcat e iniciar, executar a seguinte url:

- http://localhost:8180/treeeasy/info/home
