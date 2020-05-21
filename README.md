# recko
recko assignment
This project is solution of following problem given to me in recko interview assignment 

There are multiple parallel universes. Each person in a universe has an identity `id` and a
power. Power can be a positive or negative integer. All people are divided into families identified
by `family_id`. A special creature from 4th dimension has been given a task to
1. List families in a particular universe
2. Check if families with given family_id have the same power in all universes. If powers
don’t match then family_id is unbalanced
3. Find unbalanced family_ids
4. Balance given family_id
You have to help him by providing a REST API to store the data of universes and to do the
above tasks. If he is happy he might give you a portal gun to hop between universes. Best of
luck.


In Order to run this program  user need to create Db and table using flowing command;

CREATE DATABASE `recko`;

CREATE TABLE `family` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `universeid` int NOT NULL,
  `familyid` int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `universe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `power` int NOT NULL,
  `universeid` int NOT NULL,
  `familyid` int NOT NULL,
  PRIMARY KEY (`id`)
);



Once database and table is created you need to update application.properties file with your db username and password.
In order to access API we have Created Swagger UI with following controller ( use this url in order to access swagger 
http://localhost:8080/swagger-ui.html#/ )

1. universe-controller ( for creating, updating , deleting universe )
2. family-controller ( for creating, updating , deleting family in a univers )
3. person-controller  ( for creating, updating , deleting person in a univers family )
4 . Answer controller ( Provide Api for Assigment Questions Solution )
   a.  List families in a particular universe
   API URL : http://localhost:8080/swagger-ui.html#/answer-controller/getByUniverseIdUsingGET
   
   b.  check if a given family is balance are not
   API URL : http://localhost:8080/swagger-ui.html#/answer-controller/getByfamilyIdUsingGET
   
   c. Find unbalanced family_ids
    API URL : http://localhost:8080/swagger-ui.html#/answer-controller/getAllUnBlalanceFamiliesUsingGET
    
   d. Balance given family_id
   API URI : http://localhost:8080/swagger-ui.html#/answer-controller/balanceGivenFamilyUsingGET








