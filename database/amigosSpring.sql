DROP DATABASE IF EXISTS amigosSpring;
CREATE DATABASE amigosSpring;
USE amigosSpring;


DROP TABLE IF EXISTS recibidos;
CREATE TABLE recibidos (
  id_mensaje int(5) unsigned NOT NULL auto_increment,
  fecha timestamp(14) NOT NULL,
  remitente varchar(20) NOT NULL default '',
  destinatario varchar(20) NOT NULL default '',
  asunto varchar(100) default NULL,
  texto mediumtext,
  PRIMARY KEY  (id_mensaje),
  UNIQUE KEY id_mensaje (id_mensaje),
  KEY id_mensaje_2 (id_mensaje)
) TYPE=MyISAM;



INSERT INTO recibidos VALUES("7", "20110310103531", "jsf", "javaee", "hola!!", "Pues nada, que he visto tu pagina y he pensado en mandarte un mensajito de saludo...a ver si te animas a decirme algo!!");



DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  login varchar(20) NOT NULL default '0',
  password varchar(20) NOT NULL default '',
  varon tinyint(1) unsigned NOT NULL default '0',
  fechaNac date NOT NULL default '0000-00-00',
  localidad varchar(30) NOT NULL default '',
  descripcion mediumtext NOT NULL,
  credito int(5) unsigned default '0',
  PRIMARY KEY  (login),
  UNIQUE KEY login (login),
  KEY login_2 (login)
) TYPE=MyISAM;




INSERT INTO usuarios VALUES("javaee", "javaee", "1", "1989-01-01", "Alicante", "En realidad yo ni quiero conocer a nadie ni nada, esto solamente es una prueba para el curso de javaee. ", "10");
INSERT INTO usuarios VALUES("jsf", "jsf", "0", "1987-10-02", "Alcoy", "Basicamente busco gente que le guste el tema de JSF para discutir sobre ello, crear algunos componentes GUI juntos, y quien sabe...", "4");
INSERT INTO usuarios VALUES("pepe", "pepe", "1", "1980-09-09", "Alicante", "Hola, soy un programador de .NET despistado que me he metido en esto de AmigosSpring a ver que pasa, espero conocer mucha gente.", "9");
INSERT INTO usuarios VALUES("maria", "maria", "0", "1980-09-07", "San Vicente del Raspeig", "Hola a todos, me aburria soberanamente y por eso he decidido darme de alta en AmigosSpring. A ver que os contais!!", "10");
