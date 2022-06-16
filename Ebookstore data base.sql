create database if not exists ebookstore_db;
USE ebookstore_db;

drop table if exists TASKS;
create table Books(
  ID int(10)NOT NULL AUTO_INCREMENT,
  TITLE varchar(225),
  AUTHOR varchar(225),
  QTY int(10),
  PRIMARY KEY (ID));
  
INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('1', 'Roadwork', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('2', 'The Running Man', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
 VALUES('3', 'The Eyes of the Dragon', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('4', 'It', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('5', 'The Green Mile', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('6', 'From a Buick 8', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('7', 'Joyland', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('8', 'The Institute', 'Stephen King', '100');

INSERT INTO BOOKS (ID, TITLE, AUTHOR, QTY)
VALUES('9', 'The Outsider', 'Stephen King', '100');

