--RECIPE_CATEGORY TABLE INSERT
INSERT INTO RECIPE_CATEGORY(RECIPE_CATEGORY_NO,RECIPE_CATEGORY_NAME) VALUES(RECIPE_CATEGORY_NO_SEQ.NEXTVAL, '레시피국가');
INSERT INTO RECIPE_CATEGORY(RECIPE_CATEGORY_NO,RECIPE_CATEGORY_NAME) VALUES(RECIPE_CATEGORY_NO_SEQ.NEXTVAL, '레시피분류');
INSERT INTO RECIPE_CATEGORY(RECIPE_CATEGORY_NO,RECIPE_CATEGORY_NAME) VALUES(RECIPE_CATEGORY_NO_SEQ.NEXTVAL, '난이도');
------------------------------------------------------------------------------------
--RECIPE_DETAIL TABLE INSERT
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('동남아시아', 1);        --레시피국가
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('서양', 1);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('이탈리아', 1);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('일본', 1);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('중국', 1);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('퓨전', 1);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('한식', 1);

INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('국', 2);                --레시피분류
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('그라탕/리조또', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('나물/생채/샐러드', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('도시락/간식', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('떡/한과', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('만두/면류', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('밑반찬/김치', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('밥', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('볶음', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('부침', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('빵/과자', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('샌드위치/햄버거', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('양념장', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('양식', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('음료', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('조림', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('찌개/전골/스튜', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('찜', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('튀김/커틀릿', 2);
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('피자', 2);
                         
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('보통', 3);    			--레시피난이도
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('어려움', 3); 
INSERT INTO RECIPE_DETAIL(RECIPE_DETAIL_NAME,RECIPE_CATEGORY_NO) VALUES('초보환영', 3); 
------------------------------------------------------------------------------------
--POSTS TABLE INSERT
INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 1, '콩국수가 싫다면 잣국수','시원한 여름국수요리!', 0, SYSDATE); 
INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 2, '에어프라이어 마늘빵','SNS 핫한 트위터 겉바속촉 마늘빵 레시피', 0, SYSDATE); 
INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 2, '순두부찌개 황금 레시피','벌써 겨울? 바지락, 고기 없이도 기가 막힌 순두부찌개 만드는 법', 0, SYSDATE); 
INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 2, '팟타이를 집에서!!','태국을 대표하는 쌀국수 요리', 0, SYSDATE); 
INSERT INTO POSTS(POST_NO,POST_TYPE_NO,USER_NO,POST_TITLE,POST_CONTENTS,POST_VIEW_COUNTS,POST_DATE) VALUES(POST_NO_SEQ.NEXTVAL, 1, 2, '크림소스 치킨스테이크','영화 줄리앤줄리아에 나오는 요리로 쉽게 만들 수 있는 크림소스 레시피로 집에서 즐기기 좋은 레시피입니다.', 0, SYSDATE); 

UPDATE POSTS SET POST_CONTENTS='벌써 겨울? 바지락, 고기 없이도 기가 막힌 순두부찌개 만드는 법' WHERE POST_NO=5;

-------------------------------------------------------------------------------------
--RECIPES TABLE INSERT
INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(RECIPES_NO_SEQ.NEXTVAL,'잣국수',3, 513, 20, '한식', '만두/면류', '초보환영');
INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(RECIPES_NO_SEQ.NEXTVAL,'마늘빵',4, 276, 15, '서양', '빵/과자', '초보환영');
INSERT INTO RECIPES(RECIPES_NO,RECIPES_NANE,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(RECIPES_NO_SEQ.NEXTVAL,'순두부찌개',5, 253, 30, '한식', '찌개/전골/스튜', '보통');
INSERT INTO RECIPES(RECIPES_NO,RECIPES_NAME,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(6,'팟타이',15, 350, 20, '동남아시아', '볶음', '초보환영');
INSERT INTO RECIPES(RECIPES_NO,RECIPES_NAME,POST_NO,RECIPES_CALORIE,RECIPES_COOKING_TIME,RECIPES_NATION,RECIPES_TYPE,RECIPES_LEVEL) VALUES(RECIPES_NO_SEQ.NEXTVAL,'크림소스 치킨스테이크',POST_NO_SEQ.CURRVAL, 433, 30, '서양', '양식', '보통');

-------------------------------------------------------------------------------------
--INGREDIENTS TABLE INSERT
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'잣',1,'150g');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'닭 육수',2,'2+1/2종이컵');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소면',3,'1인분');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'오이',4,'1/3개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소금',5,'약간');

INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'식빵',1,'2장');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'마요네즈',2,'3숟갈');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'설탕',3,'2숟갈');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'다진마늘',4,'1숟갈');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소금',5,'1꼬집');

INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'순두부',1,'1개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'대파',2,'1/4개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'양파',3,'1/4개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'애호박',4,'1/4개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'청양고추',5,'1개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'달걀',6,'1개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'참기름',7,'1큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'식용류',8,'2큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'고추가루',9,'1+1/2큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소금',10,'1/2큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'설탕',11,'1꼬집');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'굴소스',12,'1큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'간장',13,'1큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'다진마늘',14,'1큰술');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'멸치',15,'6수');

INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'다진 돼지고기',1,'1/2컵');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'다진 파',2,'2T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'식용유',3,'2T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'쌀국수',4,'1인분');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'청양고추',5,'1/2개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'홍고추',6,'1/2개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'건새우',7,'1T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'칵테일새우',8,'1T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'달걀',9,'1개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'숙주',10,'1/2컵');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'다진마늘',11,'1개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'굴소스',12,'1/2T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'멸치액젓',13,'1/2T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'설탕',14,'1/2T');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,6,'물',15,'2T');

INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'닭가슴살',1,'2조각');--주재료
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'올리브유',2,'적당히');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'파슬리',3,'약간');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'양파',4,'1/2개');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'버터',5,'1스푼');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'우유',6,'1컵');--크림소스재료
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'전분가루',7,'2스푼');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'소금',8,'소금');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'후춧가루',9,'약간');
INSERT INTO INGREDIENTS(INGREDIENT_NO,RECIPES_NO,INGREDIENT_NAME,INGREDIENT_SEQ,INGREDIENT_CACTY) VALUES(INGREDIENTS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'치킨스톡(생략가능)',10,'1개');

-------------------------------------------------------------------------------------
--IMAGES TABLE INSERT
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',POST_NO_SEQ.CURRVAL,3721); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png',POST_NO_SEQ.CURRVAL,3395); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/85cce2bddd66d150dc77adaf7e877ab41.png',POST_NO_SEQ.CURRVAL,2683); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/7603c22d0bb956f0bfbe3d74df6a66161.png',POST_NO_SEQ.CURRVAL,2573); 

INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/a3c3003d1e1b8b9c5ba1047146de1d8f1.jpg',POST_NO_SEQ.CURRVAL,1542); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/392b401c9c13aac2ae3609b67ba72ed31.jpg',POST_NO_SEQ.CURRVAL,2571); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/f527619b4905735ab8215944771c0e081.jpg',POST_NO_SEQ.CURRVAL,1643); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/584b1fb73b02df4471f5a2f10e388b251.jpg',POST_NO_SEQ.CURRVAL,1924); 

INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/c61060aa1cfb9186c9f052e3da7396881.png',13,3721); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/004ee446b98e781ed713fbfbb5c9f6be1.png',13,3395); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/e64a5cba69c455689cdeb90cfbfefe4e1.png',13,2683); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES(IMAGE_NO_SEQ.NEXTVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/127d9dd4cbb9f7da7b8187fb2bb9764a1.png',13,2573); 

INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이1.png',15,2000); 
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이2.png',15,2001);
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이3.png',15,2500);
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이4.png',15,2000);
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이5.png',15,3000);
INSERT INTO IMAGES(IMAGE_NO,IMAGE_URL,POST_NO,IMAGE_SIZE) VALUES (IMAGE_NO_SEQ.NEXTVAL,'팟타이6.png',15,2800);

-------------------------------------------------------------------------------------
--PROCESS TABLE INSERT
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',1,'오이는 채 썬다.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/72d6a27278d2eb32b960ceafd49ea2741.png',2,'믹서에 잣, 닭 육수, 소금을 넣고 곱게 간 후 체에 내린다.','잣 국물은 냉장고에 차게 보관해 주세요.');
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/85cce2bddd66d150dc77adaf7e877ab41.png',3,'끓는 물에 소금을 넣고 소면을 넣어 삶는다.','찬물을 조금씩 넣어가며 삶으면 면이 더 쫄긴해져요');
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2021/07/15/c78ab39d260bfa1b8d49d4e612a918f31.png',4,'그릇에 삶은 소면을 담고 잣 국물을 넉넉히 부은 후 채 썬 오이를 올려 완성한다.',NULL);

INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/a3c3003d1e1b8b9c5ba1047146de1d8f1.jpg',1,'그릇에 마요네즈, 설탕, 소금, 다진마늘을 넣고 골고루 섞어주세요.','설탕, 소금, 마늘, 마요네즈 순서로 계량하면 숟갈 한개로 끝나요 :) 설탕은 다 녹이는게 아니라 재료가 서로 골고루 섞일정도만');
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/392b401c9c13aac2ae3609b67ba72ed31.jpg',2,'소스를 2등분하여 빵에 골고루 펴발라주세요.','소스가 도톰하게 발려야 겉은 바삭하고 속은 쫀득해요. 식빵도 좋고 바게트빵도 좋아요');
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/f527619b4905735ab8215944771c0e081.jpg',3,'에어프라이어에 넣고 180℃에서 8분간 구워주세요.','위가 살짝 노릇할정도만 구워야 속이 쫀득합니다.');
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2019/12/25/584b1fb73b02df4471f5a2f10e388b251.jpg',4,'막 구워진 상태에서 먹어야 가장 맛이 좋습니다.',NULL);

INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/f73915fc84e7b107a26321ee272b3f341.jpg',1,'먼저 멸치 육수를 끓이고, 대파 1/4과 양파 1/4을 잘게 썰어주세요.','멸치외에 있으면 표고버섯 약간, 다시마 약간 넣고 끓이면 되는데 없으면 멸치만 넣고 그냥 끓여도 됩니다.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/bb4df35e1f740f4a21e3ddc64c6406491.jpg',2,'매콤한걸 좋아하시는분은 청양고추 하나 어슷하게 썰어주시고',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/7ae21ace8bffd2d31fed93ca6b7824e21.jpg',3,'호박 1/4은 반달 모양으로 썰어주세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/03bd3a5f24c39d3562275c0850f3cd061.jpg',4,'재료손질은 벌써 끝났네요. 다음은 준비한 뚝배기나 냄비에 참기름 1큰술,식용유 2큰술을 넣어주세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/03bd3a5f24c39d3562275c0850f3cd061.jpg',5,'그리고 준비한 양파, 대파를 넣고 볶아주세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/417884b615064e79dd8f8f37f9c771151.jpg',6,'그리고 고추가루 1큰술 반을 넣고 고추기름을 만들어줍니다. 매운걸 못드시는 분은 한큰술만 넣으세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/da49924b76985251a2420e08ce8f7c561.jpg',7,'고추기름을 만들었으면 소금 반큰술, 설탕 한꼬집을 넣어주세요. 설탕은 안넣으셔도 되긴 한데 보통 식당에서는 넣죠.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/418861dd4723e999bb2bf61cef1e670d1.jpg',8,'그 다음엔 굴소스 1큰술, 간장 1큰술을 넣고 저어서 섞어주세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/08a7420bac4018c2f1466e7d970afbbb1.jpg',9,'그 다음은 멸치육수를 부어주세요. 준비된 냄비에 반 정도를 채워주세요. 너무 많이 부으면 순두부 넣을때 넘칩니다.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/19af706c994589fb99a593689f6dd4671.jpg',10,'자 이제 팔팔 끓여줍니다. 끓기 시작하면 호박과 고추를 넣고, 다진마늘도 한큰술 넣어주세요~',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/d43d205adc4e97623856c1ccb7bf4e861.jpg',11,'그 다음은 순두부를 넣어줍니다.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/255e5df93377dde02765b93aa0afcd2f1.jpg',12,'마지막으로 달걀과 파를 넣어 마무리 해줍니다.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,4,'https://recipe1.ezmember.co.kr/cache/recipe/2019/05/16/44e2623a6e563f5a38c6c9d5da2b99031.jpg',13,'완성!! 사실 순두부찌개의 맛을 좌우하는 바지락이나 돼지고기 없이 맛을 내려면 쉽지 않은데요. 제가 생각하는 포인트는 바지락이나 돼지고기가 없으면 굴소스 정도는 꼭 들어가야 하고, 멸치육수도 필요합니다. 그리고 간이 적당히 맞아야 합니다.',NULL);

INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이1.png',1,'쌀국수는 미리 물에 넣어 준비한다.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이2.png',2,'팬에 식용유를 두르고 다진 마늘 1작은술, 다진 파 2큰술을 넣고 파기름을 만들어준다.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이3.png',3,'다진 돼지고기 1/2컵을 넣고 어느 정도 익으면 칵테일 새우 7마리와 건 새우 1큰 술을 넣고 볶아준다.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이4.png',4,'볶고 있는 것들을 한쪽으로 몰아주고 다른 쪽에 기름을 두른 후 계란을 스크램블 해준다.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이5.png',5,'어느 정도 익으면 같이 섞어주고, 청양고추 1/2개, 홍고추 1/2개, 물 4큰 술, 멸치액젓 1큰 술, 굴 소스 1큰 술, 설탕 1큰 술, 쌀국수를 넣고 볶아준다.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,6,'팟타이6.png',6,'숙주 1/2컵을 넣고 2~3분간 같이 볶아 완성한다.', NULL);

INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/c61060aa1cfb9186c9f052e3da7396881.png',1,'양파볶기: 버터를 녹인 후라이팬에 양파를 볶아주세요.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/004ee446b98e781ed713fbfbb5c9f6be1.png',2,'소스만들기: 양파가 투명해지면 우유와 전분가루, 치킨스톡, 후추, 소금을 넣고 졸여주세요.', NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/e64a5cba69c455689cdeb90cfbfefe4e1.png',3,'닭가슴살 굽기: 다른 후라이팬에 올리브융를 두르고 닭가슴살을 앞뒤로 구워주세요.',NULL);
INSERT INTO PROCESS(PROCESS_NO,RECIPES_NO,PROCESS_URL,PROCESS_SEQ,PROCESS_DESC,PROCESS_TIP) VALUES(PROCESS_NO_SEQ.NEXTVAL,RECIPES_NO_SEQ.CURRVAL,'https://recipe1.ezmember.co.kr/cache/recipe/2017/09/21/127d9dd4cbb9f7da7b8187fb2bb9764a1.png.png',4,'완성: 접시에 닭가슴살을 담고 소스를 올리고 파슬리를 뿌려주면 완성',NULL);

UPDATE PROCESS SET PROCESS_URL='https://recipe1.ezmember.co.kr/cache/recipe/2020/06/03/a9e82f81bf966b8828f2f94327ad49911.png', PROCESS_DESC='먼저 쌀국수면 1.5인분은 따뜻한물에 담가서 잠시 불려주세요.' WHERE RECIPES_NO=6 AND PROCESS_SEQ=1; 

------------------------------------------------------------------------------------- 



