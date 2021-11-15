CREATE TABLE MYUSER (
	user_id 	INTEGER PRIMARY KEY AUTO_INCREMENT,
	user_name 	VARCHAR(30),
	user_age 	INTEGER,
	user_gender INTEGER
);

CREATE TABLE USERGENDER (
	gender_id 	INTEGER PRIMARY KEY,
	gender_name VARCHAR(30)
);

INSERT INTO MYUSER(user_name, user_age, user_gender) VALUES('NanKisu', 27, 0);
INSERT INTO USERGENDER(gender_id, gender_name) VALUES(0, 'Man');
INSERT INTO USERGENDER(gender_id, gender_name) VALUES(1, 'Woman');