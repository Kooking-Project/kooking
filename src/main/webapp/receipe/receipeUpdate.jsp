<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/core-img/kfavicon.ico">
	<title>레시피 수정하기 | Kooking</title>
	<style>
	</style>
	<script type="text/javascript">
		function checkValid() {
		    var f = window.document.updFrm;
				
		    if ( f.post_title.value == "") {
	    	    alert( "레시피제목을 입력해 주세요." );
	    	    f.post_title.focus();
	    		return false;
	        }
	    	if ( f.post_content.value == "" ) {
	    		alert( "요리소개를 입력해 주세요." );
	    		f.post_content.focus();
	    		return false;
	    	}
	    	if ($("#recipe_nation").val() == '') {
				alert('국가별 카테고리를 선택해 주세요.');
				$("#recipe_nation").focus();
				return isSubmit = false;
			}
			if ($("#recipe_type").val() == '') {
				alert('음식분류별 카테고리를 선택해 주세요.');
				$("#recipe_type").focus();
				return isSubmit = false;
			}
			if ($("#recipe_level").val() == '') {
				alert('난이도를 선택해 주세요.');
				$("#recipe_level").focus();
				return isSubmit = false;
			}
			if ($("#calorie").val() == '') {
				alert('칼로리를 선택해 주세요.');
				$("#calorie").focus();
				return isSubmit = false;
			}
			if ($("#cookingTime").val() == '') {
				alert('요리시간을 선택해 주세요.');
				$("#cookingTime").focus();
				return isSubmit = false;
			}
			if ($("#ingredient_seq").val() == '') {
				alert('재료를 입력해 주세요.');
				$("#ingredient_seq").focus();
				return isSubmit = false;
			}
			if ($("#ingredient_name").val() == '') {
				alert('요리과정을 입력해 주세요.');
				$("#ingredient_name").focus();
				return isSubmit = false;
			}
	    	if ( f.password.value == "" ) {
	            alert( "비밀번호를 입력해 주세요" );
	            f.password.focus();
	            return false;
	        }
	    	
	        return true;
		}
		
		function SetSelectBox(){
		    var schField = $("#SetSelectBox(); option:selected").text(); // 제목, 작성자
		}
	</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="${pageContext.request.contextPath}/img/core-img/salad.png" alt="">
    </div>
    <!-- ---------------------------------------------------------------------------- -->
    
    <!-- 레시피 수정하기 Start -->
    <form name="writeForm" id="writeForm" method="post" action="${path}/front?key=recipe&methodName=update" 
    		onSubmit='return checkValid()' enctype="multipart/form-data">    <div class="container recipe_regi">
    <div class="regi_center">
    <div class="regi_title">레시피 등록</div>
    <div class="cont_box pad_l_60">
      <div id="divMainPhotoUpload" class="cont_pic2">
        <input type="hidden" name="main_photo" id="main_photo" value="">
        <input type="hidden" name="new_main_photo" id="new_main_photo" value="">
		<input type="hidden" name="del_main_photo" id="del_main_photo" value="">
        <!-- <div style="position:absolute;left:-3000px">
        	<input type="file" name="q_main_file" id="q_main_file" file_gubun="main" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text="">
        </div> -->
        <!-- 요리대표사진등록 -->
        <!-- <div id="divMainPhotoBox">
            <img id="mainPhotoHolder" src="https://recipe1.ezmember.co.kr/img/pic_none4.gif" style="width: 200px; height: 200px; cursor:pointer">
            <input type="file" style="background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;">
        </div>-->
      </div>
      <!-- post_title 레시피제목 start -->
      <div>
      	<p class="cont_tit4">레시피 제목</p>
      	<span>
      		<input type="text" name="post_title" id="post_title" value="" size="50" placeholder="예) 소고기 미역국 끓이기">
      	</span>
		<span>
      		<input type="file" name="recipe_thumbnail" id="recipe_thumbnail" style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'>
      	</span>
      </div>
      <hr>
      <!-- 레시피제목 end -->

	  <!-- recipes_name 요리제목 start -->
	  <div>
	  	<p class="cont_tit4">요리제목 </p>
	  	<span>
	  		<input type="text" name="recipes_name" id="recipes_name" size="50" placeholder="예) 미역국">
	  	</span>
	  </div>
	  <hr>
	  <!-- 요리제목 end -->
	
	  <!-- post_content 요리소개 start -->
      <div>
      	<p class="cont_tit4">요리소개</p>
      	<span>
      		<input type="text" name="post_content" id="post_content" size="80" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요." style="height:80px; resize:none;"/>
      	</span>
      </div>
      <hr>
      <!-- 요리소개 end -->

	  <!-- 요리정보 start -->
	  <div>
      	<p class="cont_tit4">요리정보</p>
        <div class="container">
                    <div class="row">
                        <div class="col-12 col-lg-3">
                            <select name="calorie" id="calorie" onchange="SetSelectBox();">
                            	<option value="">칼로리</option>
                                <option value="100">100kcal이하</option>
								<option value="200">200kcal</option>
								<option value="300">300kcal</option>
								<option value="400">400kcal</option>
								<option value="500">500kcal</option>
								<option value="600">600kcal</option>
								<option value="700">700kcal</option>
								<option value="800">800kcal</option>
								<option value="900">900kcal이상</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="cookingTime" id="cookingTime" onchange="SetSelectBox();">
								<option value="">시간</option>
								<option value="5">5분이내</option>
								<option value="10">10분이내</option>
								<option value="15">15분이내</option>
								<option value="20">20분이내</option>
								<option value="30">30분이내</option>
								<option value="60">60분이내</option>
								<option value="90">90분이내</option>
								<option value="120">2시간이내</option>
								<option value="999">2시간이상</option>
							</select>
                        </div>
                    </div>
            </div>
      	</div>
      	<hr>
	  <!-- 요리정보 end -->

	  <!-- 카테고리 start -->
      <div>
      	<p class="cont_tit4">카테고리</p>
      	<span class="guide">분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</span>
        <div class="container">
                    <div class="row">
                        <div class="col-12 col-lg-3">
                            <select name="recipe_nation" id="recipe_nation" text="국가별" onchange="SetSelectBox();">
                                <option value="">국가별</option>
								<option value="한식">한식</option>
								<option value="서양">서양</option>
								<option value="일본">일본</option>
								<option value="중국">중국</option>
								<option value="퓨전">퓨전</option>
								<option value="이탈리아">이탈리아</option>
								<option value="동남아시아">동남아시아</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="recipe_type" id="recipe_type" text="분류별" onchange="SetSelectBox();">
								<option value="">음식분류별</option>
								<option value="구이">구이</option>
								<option value="국">국</option>
								<option value="그라탕/리조또">그라탕/리조또</option>
								<option value="나물/생채/샐러드">나물/생채/샐러드</option>
								<option value="도시락/간식">도시락/간식</option>
								<option value="떡/한과">떡/한과</option>
								<option value="만두/면류">만두/면류</option>
								<option value="밑반찬/김치">밑반찬/김치</option>
								<option value="밥">밥</option>
								<option value="볶음">볶음</option>
								<option value="부침">부침</option>
								<option value="빵/과자">빵/과자</option>
								<option value="샌드위치/햄버거">샌드위치/햄버거</option>
								<option value="양념장">양념장</option>
								<option value="양식">양식</option>
								<option value="음료">음료</option>
								<option value="조림">조림</option>
								<option value="찌개/전골/스튜">찌개/전골/스튜</option>
								<option value="찜">찜</option>
								<option value="튀김/커틀릿">튀김/커틀릿</option>
								<option value="피자">피자</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="recipe_level" id="recipe_level" text="난이도">
                                <option value="">난이도</option>
								<option value="아무나">아무나</option>
								<option value="초보환영">초보환영</option>
								<option value="보통">보통</option>
								<option value="어려움">어려움</option>
								<option value="신의경지">신의경지</option>
                            </select>
                        </div>
                    </div><!-- /div row -->
            </div>
      	</div>    
      	<!-- 카테고리 end -->
    

    <!-- 재료 start -->
    <hr>
    <div>
    	<p class="cont_tit4">재료</p>
        <span class="guide">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
        <jsp:include page="receipeMeterial.jsp"/>
   	</div>
   	<hr>
   	<!-- 재료 end -->
   	
	<!-- process 요리순서 start -->
   	  <div>
      	<p class="cont_tit4">요리순서</p>
			<span class="guide mag_b_15" style="width: 100%;"> 요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.<br></span>
					<div class="mag_b_25" id="divMaterialGroupArea"></div> 
			<!-- 요리순서 SCRIPT START -->
			<script type="text/javascript">
				let index=0;
				const add_textbox = () => {
				    const box = document.getElementById("processAddbtn");
				    const newP = document.createElement('div');
				    newP.innerHTML ="<span class='process_seq'>"+(index+1) +"</span><input type='file' name='process_url"+ index++ +"' maxlength='60' size='40' style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'>"
				    + "<input type='hidden' name='process_seq' value='"+index +"'>"				    + "<input type='text' name='process_desc' style='width:610px; margin:10px;' placeholder='예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.'>"
				    + "<input type='text' name='process_tip' style='width:610px; margin:10px;' placeholder='요리 tip! 예) 위가 살짝 노릇할정도만 구워야 속이 쫀득합니다.'>"
				    + "<input type='button' value='삭제'  onclick='remove(this)'>";
				    box.appendChild(newP);
				}
				const remove = (obj) => {
				    document.getElementById('processAddbtn').removeChild(obj.parentNode);
				}
			</script>
			<!-- 요리순서 SCRIPT END -->
			<div id="processAddbtn">
	      	 <input type="button" id="addItem" value="추가하기"  onclick="add_textbox();" />
	    	</div>
	   </div>
	 <hr>
    <!-- 요리순서 End -->
			    
			    <!-- 비밀번호 입력 -->
			<!-- <div>
			    	<p class="cont_tit4">비밀번호</p>
			    	<span class="guide mag_b_15">비밀번호가 맞아야 수정이 가능합니다.</span>
			    	<div>
			    		<input type=password name="password" size="12">
			    	</div>
			    </div>비밀번호 값 추후 확인-->
    
    </div><!--/cont_box-->
    
    <!-- 태그 보류 xxxxxxx -->
    <!-- <div class="cont_box pad_l_60">
    <p class="cont_tit4">태그</p>
    <input type="text" name="boa_tx_tag" value="" id="mySingleFieldTags" style="width:100%">
    <span style="display:block; color:#666; margin-bottom:-8px;margin-left:140px">주재료, 목적, 효능, 대상 등을 태그로 남겨주세요.<em style="font-style:normal; color:#999; padding-left:8px;">예) 돼지고기, 다이어트, 비만, 칼슘, 감기예방, 이유식, 초간단</em></span>
    </div>-->

   </div><!--/regi_center-->
   
   
    	  <!-- 확인, 취소 버튼 start -->
    	  <div class="delicious-buttons-area">
    	  	<div class=" btn delicious-btn">
    	  		<input type="submit" value="수정" style="background-color:transparent;  border:0px transparent solid; font-weight: bold; color: #fff;">
    	  	</div>
    	  	<div class=" btn delicious-btn">
    	  	  	<input type="reset" value="취소" style="background-color:transparent;  border:0px transparent solid; font-weight: bold; color: #fff;">
    	  	</div>
          </div><!-- 확인, 취소 버튼 end -->
          
          
</div><!-- /container -->
</form>
<!-- 레시피 등록하기 End -->
    
    
    <!-- footer -->
    <jsp:include page="../common/footer.jsp"/>  
</body>
</html>