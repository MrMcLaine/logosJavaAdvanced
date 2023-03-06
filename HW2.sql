DROP DATABASE IF EXISTS gym;
CREATE DATABASE gym CHAR SET utf8;
USE gym;

CREATE TABLE coach (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL
);

CREATE TABLE exercise_machine (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  weight INT NOT NULL,
  number INT NOT NULL DEFAULT 1
);

CREATE TABLE client (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL
);  

INSERT INTO coach (first_name, last_name) VALUES
	('Will', 'Smith'),
    ('Daniel', 'Craig');
    
INSERT INTO exercise_machine (name, weight) VALUES
	('Smith', 75),
    ('The bench press', 7),
    ('Crossover', 120);    

INSERT INTO client (first_name, last_name) VALUES
	('Dima', 'Monatik'),
    ('Volodymyr', 'Dantes');

