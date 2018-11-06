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
SELECT sailors.sname, sailors.age
	FROM SAILORS
	GROUP BY sailors.sid;
/* Old */
/* SELECT DISTINCT sailors.sname, sailors.age
	FROM SAILORS; */

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
SELECT sailors.sname
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	INNER JOIN BOATS ON reserves.bid = boats.bid
	WHERE boats.color = 'red'
	GROUP BY sailors.sid;
/* Old */
/* SELECT DISTINCT sailors.sname
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	INNER JOIN BOATS ON reserves.bid = boats.bid
	WHERE boats.color = 'red'; */

/* 6. Find the colors of boats reserved by Lubber */
SELECT DISTINCT boats.color
	FROM BOATS
	INNER JOIN RESERVES ON boats.bid = reserves.bid
	INNER JOIN SAILORS ON reserves.sid = sailors.sid
	WHERE sailors.sname = 'Lubber';

/* 7. Find the names of sailors who have reserved at least one boat */
SELECT sailors.sname
	(SELECT COUNT(reserves.sid) AS count_reserves_id
	FROM SAILORS
	INNER JOIN RESERVES ON sailors.sid = reserves.sid
	WHERE count_reserves_id >= 1);

/* 8. Compute increments for the ratings of persons who have sailed two different
boats on the same day */
SELECT sailors.sname, sailors.rating + 1
FROM sailors
INNER JOIN reserves r1 ON sailors.sid = r1.sid
INNER JOIN reserves r2 ON sailors.sid = r2.sid
WHERE r1.day = r2.day AND r1.bid <> r2.bid


/* 9. Find the ages of sailors whose name begins and ends with B and has at least three
characters */
SELECT sailors.age
	FROM sailors
	WHERE (position('B' in sailors.sname) = 1) and (position ('b' in sailors.sname) = 3) and (char_length(sailors.sname) = 3);

/* 10. Find the names of sailors who have reserved a red or a green boat. */
SELECT sailors.sname
	FROM sailors
	INNER JOIN reserves ON sailors.sid = reserves.sid
	INNER JOIN boats ON reserves.bid = boats.bid
	WHERE (boats.color = 'red') or (boats.color = 'green')
	GROUP BY sailors.sid;

/* 11. Find the names of sailors who have reserved both a red and a green boat. */
SELECT s1.sname
FROM sailors s1, reserves r1, boats b1
WHERE s1.sid = r1.sid AND r1.bid = b1.bid AND b1.color = 'red'
INTERSECT
SELECT s2.sname
FROM sailors s2, reserves r2, boats b2
WHERE s2.sid = r2.sid AND r2.bid = b2.bid AND b2.color = 'green'
/* similar to https://cs.nyu.edu/courses/Fall12/CSCI-GA.2433-001/lecture5.pdf */

/* 12. Find the sids of all sailors who have reserved red boats but not green boats. */
SELECT s1.sid
FROM sailors s1, reserves r1, boats b1
WHERE s1.sid = r1.sid AND r1.bid = b1.bid AND b1.color = 'red'
EXCEPT
SELECT s2.sid
FROM sailors s2, reserves r2, boats b2
WHERE s2.sid = r2.sid AND r2.bid = b2.bid AND b2.color = 'green'
/* similar to https://cs.nyu.edu/courses/Fall12/CSCI-GA.2433-001/lecture5.pdf */

/* 13. Find all sids of sailors who have rating of 10 or reserved boat 104 */
SELECT sailors.sid
FROM sailors
WHERE sailors.rating = 10
UNION
SELECT reserves.sid
FROM reserves
WHERE reserves.bid = 104
/* */

/* 14. Find the average age of all sailors. */
SELECT AVG(sailors.age)
FROM sailors
/* similar to https://www.cs.ubc.ca/~laks/cpsc304/Basic-SQL-Tutorial-Sol.pdf */

/* 15. Find the average age of sailors with a rating of 10 */
SELECT AVG(sailors.age)
FROM sailors
WHERE sailors.rating = 10
/* similar to https://www.cs.ubc.ca/~laks/cpsc304/Basic-SQL-Tutorial-Sol.pdf */

/* 16. Find the name and age of the oldest sailor */
SELECT sailors.sname, sailors.age
FROM sailors
WHERE sailors.age = (SELECT MAX(sailors.age)
					FROM sailors)

/* 17. Count the number of sailors */
SELECT COUNT(sailors)
FROM sailors

/* 18. Count the number of different sailor names.*/
SELECT COUNT(DISTINCT sailors.sname)
FROM sailors

/* 19. Find the age of the youngest sailor for each rating level.*/
SELECT MIN(sailors.age)
FROM sailors
GROUP BY sailors.rating

/* 20. Find the age of the youngest sailor who is eligible to vote (i.e., is at least 18 years
old) for each rating level with at least two such sailors. */
SELECT MIN(sailors.age)
FROM sailors
WHERE sailors.age >= 18
GROUP BY sailors.rating
HAVING COUNT(sailors) >= 2
/* similar to https://cs.nyu.edu/courses/Fall12/CSCI-GA.2433-001/lecture6.pdf*/



