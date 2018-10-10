CREATE TABLE SAILORS
(
	sid INTEGER PRIMARY KEY,
	sname VARCHAR,
	rating INTEGER,
	age REAL
);

CREATE TABLE BOATS
(
	bid INTEGER PRIMARY KEY,
	bname VARCHAR,
	color VARCHAR
);

CREATE TABLE RESERVES
(
	sid INTEGER,
	bid INTEGER,
	day DATE,
	PRIMARY KEY (sid, bid, day)
);

INSERT INTO SAILORS
	VALUES (22, 'Dustin', 7, 45.0);
INSERT INTO SAILORS
	VALUES (29, 'Brutus', 1, 33.0);
INSERT INTO SAILORS
	VALUES (31, 'Lubber', 8, 55.5);
INSERT INTO SAILORS
	VALUES (32, 'Andy', 8, 25.5;
INSERT INTO SAILORS
	VALUES (58, 'Rusty', 10, 35.0);
INSERT INTO SAILORS
	VALUES (64, 'Horatio', 7, 35.0);
INSERT INTO SAILORS
	VALUES (71, 'Zorba', 10, 16.0);
INSERT INTO SAILORS
	VALUES (74, 'Horatio', 9, 35.0);
INSERT INTO SAILORS
	VALUES (85, 'Art', 3, 25.5);
INSERT INTO SAILORS
	VALUES (95, 'Bob', 3, 63.5);

INSERT INTO BOATS
	VALUES (101, 'Interlake', 'blue');
INSERT INTO BOATS
	VALUES (102, 'Interlake', 'red');
INSERT INTO BOATS
	VALUES (103, 'Clipper', 'green');
INSERT INTO BOATS
	VALUES (104, 'Marine', 'red');

INSERT INTO RESERVES
	VALUES (22, 101, '10/10/98');
INSERT INTO RESERVES
	VALUES (22, 102, '10/10/98');
INSERT INTO RESERVES
	VALUES (22, 103, '10/8/98');
INSERT INTO RESERVES
	VALUES (22, 104, '10/7/98');
INSERT INTO RESERVES
	VALUES (31, 102, '11/10/98');
INSERT INTO RESERVES
	VALUES (31, 103, '11/6/98');
INSERT INTO RESERVES
	VALUES (31, 104, '11/12/98');
INSERT INTO RESERVES
	VALUES (64, 101, '9/5/98');
INSERT INTO RESERVES
	VALUES (64, 102, '9/8/98');
INSERT INTO RESERVES
	VALUES (74, 103, '9/8/98');

/* 1. Find the name and ages of all sailors */
SELECT sailors.sname, sailors.age
	FROM SAILORS;

/* 2. Find the distinct names and ages of all sailors */
SELECT DISTINCT sailors.sname, sailors.age
	FROM SAILORS;

/* 3. Find all sailors with a rating above 7. */
SELECT sailors.sid, sailors.sname, sailors.rating, sailors.age
	FROM SAILORS
	WHERE sailors.rating > 7;

/* 4. Find the names of sailors who have reserved boat number 103 */
SELECT sailors.sname
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	WHERE reserves.bid = 103;

/* 5. Find the names of sailors who have reserved a red boat */
SELECT DISTINCT sailors.sname
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	INNER JOIN BOATS ON reserves.bid = boats.bid
	WHERE boats.color = 'red';

/* 6. Find the colors of boats reserved by Lubber */
SELECT DISTINCT boats.color
	FROM BOATS
	INNER JOIN RESERVES ON boats.bid = reserves.bid
	INNER JOIN SAILORS ON reserves.sid = sailors.sid
	WHERE sailors.sname = 'Lubber';

/* 7. Find the names of sailors who have reserved at least one boat */
/*
SELECT sailors.sname
	(SELECT COUNT(reserves.sid) AS count_reserves_id
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	WHERE count_reserves_id >= 1);
*/






