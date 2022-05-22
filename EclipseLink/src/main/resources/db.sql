INSERT INTO COUNTRY (ID, NAME) VALUES (1, 'Burundi')
INSERT INTO COUNTRY (ID, NAME) VALUES (2, 'Malawi')
 

INSERT INTO AUTHOR (ID, NAME,COUNTRY_ID) VALUES (1, 'Pierre Shingiro',1)
INSERT INTO AUTHOR (ID, NAME,COUNTRY_ID) VALUES (2, 'Alfred Muhawenayo',1)
INSERT INTO AUTHOR (ID, NAME,COUNTRY_ID) VALUES (3, 'Roy Manda',2)
INSERT INTO AUTHOR (ID, NAME,COUNTRY_ID) VALUES (4, 'Airtel Gama',2)
INSERT INTO AUTHOR (ID, NAME,COUNTRY_ID) VALUES (5, 'Lazarus Nkhata',2)

INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (1, 'Spring Boot with JPA',   1 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (2, 'Modern garbage collection',  1 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (3, 'Why checked exceptions exist?',  2 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (4, 'Java server in Java 18',   2 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (5, 'Java for machine learning',   2 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (6, 'RESTful services in Java',  3 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (7, 'The best IDE for Java beginners', 4  )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (8, 'Integration testing',  4 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (9, 'Best Java libraries',   4 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (10, 'Cool Java features',   5 )
INSERT INTO POST (ID, NAME, AUTHOR_ID ) VALUES (11, 'Final and sealed classes',   5 )
 