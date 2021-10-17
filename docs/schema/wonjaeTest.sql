--원재 연습장....

select * from users;

insert into USERS(USER_NO, USER_ID, USER_PWD, USER_NICNAME, USER_GENDER, USER_STATUS) values(3,'Jeon',1111,'전원재',0,10);
insert into USERS(USER_NO, USER_ID, USER_PWD, USER_NICNAME, USER_GENDER, USER_STATUS) values(4,'TestUser',1111,'테스트용',0,0);

update USERS set USER_STATUS=0 where USER_NO=4;
commit