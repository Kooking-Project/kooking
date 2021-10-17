--원재 연습장....

select * from users;

insert into USERS(USER_NO, USER_ID, USER_PWD, USER_NICNAME, USER_GENDER, USER_STATUS) values(3,'Jeon',1111,'전원재',0,10);
insert into USERS(USER_NO, USER_ID, USER_PWD, USER_NICNAME, USER_GENDER, USER_STATUS) values(4,'TestUser',1111,'테스트용',0,0);

update USERS set USER_STATUS=0 where USER_NO=4;
update USERS set USER_PWD='2222', USER_NICNAME='테스트', USER_GENDER=1 where USER_NO=4;

select * from posts;
select * from POSTS where USER_NO=4;

INSERT INTO POSTS(POST_NO, POST_TYPE_NO, USER_NO, POST_TITLE, POST_CONTENTS, POST_VIEW_COUNTS, POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 4, '테스트','테스트하자', 0, SYSDATE);

select * from comments;
select * from POSTS where USER_NO=4;

INSERT INTO COMMENTS(COMMENT_NO, USER_NO, POST_NO, COMMENT_CONTENTS) 
VALUES(POST_NO_SEQ.NEXTVAL, 1, 4, '테스트','테스트하자', 0, SYSDATE);
commit