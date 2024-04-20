CREATE TABLE Player
(
   ID INTEGER NOT NULL,
   Name VARCHAR(255) NOT NULL,
   Nationality VARCHAR(255) NOT NULL,
   Birth_date TIMESTAMP,
   Titles INTEGER,
   PRIMARY KEY (ID)
);

INSERT INTO player (ID, Name, Nationality, Birth_date, Titles) VALUES(1,'Djokovic', 'Serbia', '05/22/1987', 81);
INSERT INTO player (ID, Name, Nationality, Birth_date, Titles) VALUES(2,'Monfils', 'France', '09/01/1986', 10);
INSERT INTO player (ID, Name, Nationality, Birth_date, Titles) VALUES(3,'Isner', 'USA', '04/26/1985', 15);