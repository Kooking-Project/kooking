<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/img/core-img/kfavicon.ico">
    
    <!-- Script -->
    <script type="text/javascript">
	    function checkValid() {
	        var f = window.document.insFrm;
	    		
	    	if ( f.cok_title.value == "") {
	    	    alert( "레시피제목을 입력해 주세요." );
	    	    f.cok_title.focus();
	    		return false;
	        }
	    	if ( f.cok_intro.value == "" ) {
	    		alert( "요리소개를 입력해 주세요." );
	    		f.cok_intro.focus();
	    		return false;
	    	}
	    	if ( f.receipe_category1.value == "" ) {
	    		alert( "국가별 카테고리를 선택해 주세요." );
	    		f.receipe_category1.focus();
	    		return false;
	    	}
	    	if ( f.receipe_category2.value == "" ) {
	    		alert( "분류별 카테고리를 선택해 주세요." );
	    		f.receipe_category2.focus();
	    		return false;
	    	}
	    	if ( f.receipe_category3.value == "" ) {
	    		alert( "난이도 카테고리를 선택해 주세요." );
	    		f.receipe_category3.focus();
	    		return false;
	    	}
	    	if ( f.ingredient_name.value == "" ) {
	            alert( "재료를 입력해 주세요." );
	            f.ingredient_name.focus();
	            return false;
	        }
	    	if ( f.receipe_process.value == "" ) {
	            alert( "요리과정을 입력해 주세요" );
	            f.receipe_process.focus();
	            return false;
	        }
	    	
	        return true;
	    }
    </script>
    
    
    <!-- Title -->
    <title>레시피 등록하기 | Kooking</title>    
</head>
<body>
	<!-- header -->
	<jsp:include page="../common/header.jsp"/>
	
    <!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="${pageContext.request.contextPath}/img/core-img/salad.png" alt="">
    </div>
    
    <!-- 레시피 등록하기 Start -->
    <form name="insFrm" id="insFrm" method="post" action="" onSubmit='return checkValid()' enctype="multipart/form-data">
    <div class="container recipe_regi">
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
      <!-- 레시피제목 start -->
      <div>
      	<p class="cont_tit4">레시피 제목</p>
      	<span>
      		<input type="text" name="cok_title" id="cok_title" value="" size="50" placeholder="예) 소고기 미역국 끓이기">
      	</span>
      	<span>
      		<input type="file" style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'>
      	</span>
      </div>
      <hr>
      <!-- 레시피제목 end -->

      <div>
      	<p class="cont_tit4">요리소개</p>
      	<span>
      		<input type="text" name="cok_intro" id="cok_intro" size="80" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요." style="height:80px; resize:none;"/>
      	</span>
      </div>
      <hr>


      <div>
      	<p class="cont_tit4">카테고리</p>
      	<span class="guide">분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</span>
        <div class="container">
                    <div class="row">
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category1" id="receipe_category1" text="국가별">
                                <option value="" >국가별</option>
								<option value="56">동남아시아</option>
								<option value="54">서양</option>
								<option value="55">이탈리아</option>
								<option value="60">일본</option>
								<option value="53">중국</option>
								<option value="52">퓨전</option>
								<option value="61">한식</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category2" id="receipe_category2" text="분류별">
                                <option value="" >분류별</option>
								<option value="18">국</option>
								<option value="13">그라탕/리조또</option>
								<option value="19">나물/생채/샐러드</option>
								<option value="21">도시락/간식</option>
								<option value="15">떡/한과</option>
								<option value="43">만두/면류</option>
								<option value="17">밑반찬/김치</option>
								<option value="45">밥</option>
								<option value="20">볶음</option>
								<option value="46">부침</option>
								<option value="44">빵/과자</option>
								<option value="14">샌드위치/햄버거</option>
								<option value="22">양념장</option>
								<option value="22">양식</option>
								<option value="22">음료</option>
								<option value="22">조림</option>
								<option value="22">찌개/전골/스튜</option>
								<option value="22">찜</option>
								<option value="22">튀김/커틀릿</option>
								<option value="22">피자</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category3" id="receipe_category3" text="난이도">
                                <option value="" >난이도</option>
								<option value="1">보통</option>
								<option value="1">어려움</option>
								<option value="7">초보환영</option>
                            </select>
                        </div>
                    </div><!-- /div row -->
            </div>
      	</div>    
    

    <!-- 재료 start -->
    <hr>
    <div>
    	<p class="cont_tit4">재료</p>
        <span class="guide">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
        <jsp:include page="receipeMeterial.jsp"/>
   	</div>
   	<hr>
   	<!-- 재료 end -->
   	
   	<!-- 요리순서 start -->
   	  <div>
      	<p class="cont_tit4">요리순서</p>
	 	 <span class="guide mag_b_15">요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.<br></span>
		  <!-- 요리순서 SCRIPT START -->
		  <script type="text/javascript">
				const add_textbox = () => {
				    const box = document.getElementById("process");
				    const newP = document.createElement('div');
				    newP.innerHTML ="<input type='file' maxlength='60' size='40' style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'> <input type='text' name='receipe_process' style='width:610px; margin:10px;' placeholder='예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.'> <input type='button' value='삭제' onclick='remove(this)'>";
				    box.appendChild(newP);
				}
				const remove = (obj) => {
				    document.getElementById('process').removeChild(obj.parentNode);
				}
			</script>
			<!-- 요리순서 SCRIPT END -->
			<div id="process">
	      	 <input type="button" id="addItem" value="추가하기" onclick="add_textbox();" />
	    	</div>
	    </div>
	    <hr>
    <!-- 요리순서 End -->
    
    <!-- 비밀번호 입력 -->
    <div>
    	<p class="cont_tit4">비밀번호</p>
    	<span class="guide mag_b_15">글 수정,삭제시 필요합니다.</span>
    	<div>
    		<input type=password name="password" size="12">
    	</div>
    </div>
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
    	  		<input type="submit" value="확인" style="background-color:transparent;  border:0px transparent solid; font-weight: bold; color: #fff;">
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