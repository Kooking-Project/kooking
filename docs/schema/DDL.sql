DROP TABLE USERS;
DROP TABLE POST_TYPE;
DROP TABLE POSTS;
DROP TABLE BOOKMARKS;
DROP TABLE RECOMMEND;
DROP TABLE COMMENTS;
DROP TABLE RECIPE_CATEGORY;
DROP TABLE RECIPE_DETAIL;
DROP TABLE RECIPES;
DROP TABLE INGREDIENTS;
DROP TABLE IMAGES;
DROP TABLE PROCESS;

SELECT * FROM TAB;

CREATE TABLE USERS(
    USER_NO 			NUMBER(10) 		PRIMARY KEY,
    USER_ID 			VARCHAR2(50) 	UNIQUE NOT NULL,
    USER_PWD 			VARCHAR2(530) 	NOT NULL,
    USER_NICNAME 		VARCHAR2(60) 	UNIQUE NOT NULL,
    USER_GENDER 		NUMBER(1),
    USER_ENROLL_DATE 	DATE 			DEFAULT SYSDATE,
    USER_PROFILE_IMG 	VARCHAR2(530),
    USER_STATUS 		NUMBER(2) 		DEFAULT 0
);

CREATE TABLE POST_TYPE(
    POST_TYPE_NO 	NUMBER(5) 		PRIMARY KEY,
    POST_TYPE_NAME 	VARCHAR2(60) 	UNIQUE NOT NULL
);

CREATE TABLE POSTS(
    POST_NO 			NUMBER(20) 		PRIMARY KEY,
    POST_TYPE_NO 		NUMBER(5) 		REFERENCES POST_TYPE(POST_TYPE_NO) ON DELETE CASCADE NOT NULL,
    USER_NO 			NUMBER(10)  	REFERENCES USERS(USER_NO) ON DELETE CASCADE NOT NULL,
    POST_TITLE 			VARCHAR2(150) 	NOT NULL,
    POST_CONTENTS 		VARCHAR2(4000) 	NOT NULL,
    POST_VIEW_COUNTS 	NUMBER(10) 		DEFAULT 0  NOT NULL,
    POST_DATE 			DATE 			DEFAULT SYSDATE NOT NULL
);

CREATE TABLE BOOKMARKS(
    USER_NO 		NUMBER(10) 		REFERENCES USERS(USER_NO) ON DELETE CASCADE NOT NULL,
    POST_NO 		NUMBER(20) 		REFERENCES  POSTS(POST_NO) ON DELETE CASCADE NOT NULL,
    BOOKMARK_DATE 	DATE 			DEFAULT SYSDATE NOT NULL,
    PRIMARY KEY(USER_NO, POST_NO)
);

CREATE TABLE RECOMMENDS(
    RECOMMEND_NO 			NUMBER(10) 		PRIMARY KEY,
    USER_NO 			NUMBER(10) 		REFERENCES USERS(USER_NO) ON DELETE CASCADE NOT NULL,
    POST_NO 			NUMBER(20) 		REFERENCES  POSTS(POST_NO) ON DELETE CASCADE NOT NULL,
    RECOMMEND_SCORE 	NUMBER(1) 		NOT NULL, 
    RECOMMEND_DATE 		DATE 			DEFAULT SYSDATE NOT NULL,
    UNIQUE(POST_NO, USER_NO)
);

CREATE TABLE COMMENTS(
    COMMENT_NO 			NUMBER(20) 		PRIMARY KEY,
    USER_NO 			NUMBER(10) 		REFERENCES USERS(USER_NO) NOT NULL,
    POST_NO 			NUMBER(20) 		REFERENCES  POSTS(POST_NO) NOT NULL,
    COMMENT_CONTENTS 	VARCHAR2(600) 	NOT NULL,
    COMMENT_DATE 		DATE 			DEFAULT SYSDATE,
    COMMENT_TOP 		NUMBER(20) 		REFERENCES COMMENTS(COMMENT_NO),
    COMMENT_DELETE_YN 	NUMBER(1) 		DEFAULT 0 NOT NULL
);

CREATE TABLE RECIPE_CATEGORY(
    RECIPE_CATEGORY_NO 		NUMBER(10) 		PRIMARY KEY,
    RECIPE_CATEGORY_NAME 	VARCHAR2(50) 	NOT NULL
);

CREATE TABLE RECIPE_DETAIL(
    RECIPE_DETAIL_NAME 		VARCHAR2(30) 	PRIMARY KEY,
    RECIPE_CATEGORY_NO 		NUMBER(10) 		REFERENCES RECIPE_CATEGORY(RECIPE_CATEGORY_NO) ON DELETE CASCADE NOT NULL
);

CREATE TABLE RECIPES(
    RECIPES_NO 				NUMBER(20) 		PRIMARY KEY,
    POST_NO 				NUMBER(20) 		REFERENCES POSTS(POST_NO) ON DELETE CASCADE UNIQUE NOT NULL,
    RECIPES_CALORIE 		NUMBER(10),
    RECIPES_COOKING_TIME 	NUMBER(8),
    RECIPES_NATION 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE ,
    RECIPES_TYPE 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE ,
    RECIPES_LEVEL 			VARCHAR2(30) 	REFERENCES RECIPE_DETAIL(RECIPE_DETAIL_NAME) ON DELETE CASCADE 
);

CREATE TABLE INGREDIENTS(
    INGREDIENT_NO 		NUMBER(10) 		PRIMARY KEY,
    RECIPES_NO 			NUMBER(20) 		REFERENCES RECIPES(RECIPES_NO) ON DELETE CASCADE NOT NULL,
    INGREDIENT_NAME 	VARCHAR2(60) 	NOT NULL,
    INGREDIENT_SEQ 		NUMBER(2) 		NOT NULL,
    INGREDIENT_CACTY 	VARCHAR2(60)
);

CREATE TABLE IMAGES(
    IMAGE_NO NUMBER(30) PRIMARY KEY,
    IMAGE_URL 		VARCHAR2(530) ,
    POST_NO 		NUMBER(20) 		REFERENCES POSTS(POST_NO) ON DELETE CASCADE,
    IMAGE_SIZE 		NUMBER(38) 		NOT NULL
);

CREATE TABLE PROCESS(
    PROCESS_NO 		NUMBER(2) 		PRIMARY KEY,
    RECIPES_NO 		NUMBER(20) 		REFERENCES RECIPES(RECIPES_NO) ON DELETE CASCADE  NOT NULL,
    PROCESS_URL 		VARCHAR(530) ,
    PROCESS_SEQ 	NUMBER(2) 		NOT NULL,
    PROCESS_DESC 	VARCHAR2(1000),
    PROCESS_TIP 	VARCHAR2(1000)
);

DROP TABLE PROCESS;
DROP TABLE IMAGES;
DROP TABLE RECIPES;

SELECT * FROM RECIPES;

DELETE FROM RECIPES WHERE POST_NO=17;
COMMIT;

SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'RECIPES';
--ALTER TABLE RECIPES DROP FOREIGN KEY
ALTER TABLE RECIPES DROP CONSTRAINT SYS_C005307;
ALTER TABLE RECIPES ADD CONSTRAINT SYS_C005307 FOREIGN KEY (POST_NO) REFERENCES POSTS(POST_NO) ON DELETE CASCADE;

 DROP SEQUENCE POST_NO_SEQ;
 DROP SEQUENCE USER_NO_SEQ;
 DROP SEQUENCE COMMENT_NO_SEQ;
 DROP SEQUENCE RECOMMEND_NO_SEQ;
 DROP SEQUENCE PROCESS_NO_SEQ;
 DROP SEQUENCE INGREDIENTS_NO_SEQ;
 
 CREATE SEQUENCE POST_NO_SEQ 
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
CREATE SEQUENCE RECIPE_NO_SEQ 
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
 SELECT RECIPE_NO_SEQ.NEXTVAL,  RECIPE_NO_SEQ.NEXTVAL FROM DUAL;
 
 CREATE SEQUENCE USER_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
 CREATE SEQUENCE COMMENT_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
 CREATE SEQUENCE RECOMMEND_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
 CREATE SEQUENCE PROCESS_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
 CREATE SEQUENCE INGREDIENTS_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;
 
CREATE SEQUENCE IMAGE_NO_SEQ
 INCREMENT BY 1
 START WITH 1
 NOCYCLE
 NOCACHE;

-- LIST�� ���� �� ����
CREATE OR REPLACE VIEW VIEW_RECIPE_LIST
AS SELECT 
POST_NO, POST_TYPE_NO, USER_NO, USER_NICNAME, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS, POST_DATE, RECIPES_NO, RECIPES_NAME, RECIPES_CALORIE, RECIPES_COOKING_TIME, 
RECIPES_NATION, RECIPES_TYPE, RECIPES_LEVEL, NVL(SC, -1) AS SCORE
FROM POSTS P NATURAL JOIN RECIPES NATURAL JOIN USERS LEFT OUTER JOIN (SELECT POST_NO, AVG(RECOMMEND_SCORE) AS SC FROM RECOMMENDS GROUP BY POST_NO) USING(POST_NO) ORDER BY POST_DATE DESC;


