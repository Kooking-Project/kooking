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
    <form name="insFrm" id="insFrm" method="post">
    <div class="container recipe_regi">
    <div class="regi_center">
    <div class="regi_title">레시피 등록</div>
    <div class="cont_box pad_l_60">
      <div id="divMainPhotoUpload" class="cont_pic2">
        <input type="hidden" name="main_photo" id="main_photo" value="">
        <input type="hidden" name="new_main_photo" id="new_main_photo" value="">
		<input type="hidden" name="del_main_photo" id="del_main_photo" value="">
        <div style="position:absolute;left:-3000px">
        	<input type="file" name="q_main_file" id="q_main_file" file_gubun="main" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text="">
        </div>
        <!-- 요리대표사진등록 -->
        <div id="divMainPhotoBox" is_over="0">
            <img id="mainPhotoHolder" onclick="browseMainFile()" src="https://recipe1.ezmember.co.kr/img/pic_none4.gif" style="width: 200px; height: 200px; cursor:pointer">
        </div>
      </div>
      <div class="cont_line"><p class="cont_tit4">레시피 제목</p><input type="text" name="cok_title" id="cok_title" value="" class="form-control" placeholder="예) 소고기 미역국 끓이기" style="width:610px; "></div>
      <div class="cont_line pad_b_25"><p class="cont_tit4">요리소개</p>
      	<input type="text" name="cok_intro" id="cok_intro" class="form-control step_cont" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요. 어머니로부터 배운 미역국 레시피를 남편의 입맛에 맞게 고안했습니다." style="height:100px; width:610px; resize:none;"/>
      </div>


      <div class="cont_line"><p class="cont_tit4">카테고리</p>
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
                    </div>
            </div>
		<span class="guide" style="margin:20px 0 20px 40px;">분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</span>
      	</div>
      	<!-- 
      	<div class="cont_line"><p class="cont_tit4">요리정보</p>
      	<div class="container">
                    <div class="row">
                    	 <span class="pad_l_30">인원 </span>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_portion" id="receipe_portion"  text="인원">
                                <option value="" >인원</option><option value="1">1인분</option>
								<option value="2">2인분</option>
								<option value="3">3인분</option>
								<option value="4">4인분</option>
								<option value="5">5인분</option>
								<option value="6">6인분이상</option>
                            </select>
                        </div>
                        <span class="pad_l_30">시간 </span>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_time" id="receipe_time" text="시간">
                                <option value="" >시간</option><option value="5">5분이내</option>
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
                        <span class="pad_l_30">난이도 </span>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_degree" id="receipe_degree" text="난이도">
                                <option value="" >난이도</option><option value="1">아무나</option>
								<option value="2">초급</option>
								<option value="3">중급</option>
								<option value="4">고급</option>
								<option value="5">신의경지</option>
                            </select>
                        </div>
                    </div>
            </div>
           </div>-->
            
    </div><!--/cont_box-->
    
    <!-- 재료 start -->
    <div class="cont_box pad_l_60">
    	<div class="cont_line"><p class="cont_tit4">재료</p>
        <span class="guide mag_b_15" style="width:100%;">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
        <jsp:include page="receipeMeterial.jsp"/>
		<div class="mag_b_25" id="divMaterialGroupArea"></div>
    	</div>
   	</div>
   	<!-- 재료 end -->
   	
   	<!-- 요리순서 start -->
    <div class="cont_box pad_l_60">
      <input type="file" name="file" id="multifile_1" file_gubun="step" style="display:none;" multiple/>
      <p class="cont_tit4">요리순서</p>
	  <span class="guide mag_b_15"><b>요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.</b><br></span>
	  <script type="text/javascript">
			const add_textbox = () => {
			    const box = document.getElementById("process");
			    const newP = document.createElement('div');
			    newP.innerHTML =" <input type='text' style='width:610px; margin:10px;'> <input type='button' value='삭제' onclick='remove(this)'>";
			    box.appendChild(newP);
			}
			const remove = (obj) => {
			    document.getElementById('process').removeChild(obj.parentNode);
			}
		</script>
		<div id="process">
      	 <input type="button" id="addItem" value="추가하기" onclick="add_textbox();" />
    	</div>
    </div>
    <!-- 요리순서 End -->
    
    <!-- 태그 보류 xxxxxxx -->
    <!-- <div class="cont_box pad_l_60">
    <p class="cont_tit4">태그</p>
    <input type="text" name="boa_tx_tag" value="" id="mySingleFieldTags" style="width:100%">
    <span style="display:block; color:#666; margin-bottom:-8px;margin-left:140px">주재료, 목적, 효능, 대상 등을 태그로 남겨주세요.<em style="font-style:normal; color:#999; padding-left:8px;">예) 돼지고기, 다이어트, 비만, 칼슘, 감기예방, 이유식, 초간단</em></span>
    </div>-->

    	  </div><!--/regi_center-->
    	  <!-- 저장, 취소 버튼 button btn -->
    	  <div class="delicious-buttons-area">
                  <a href="#" onclick="#" class="btn delicious-btn m-1">저장</a>
                  <a href="#" onclick="#" class="btn delicious-btn m-1">취소</a>
          </div>
</div><!-- /container --></form>
    <!-- 레시피 등록하기 End -->
    
    <!-- footer -->
    <jsp:include page="../common/footer.jsp"/>  
</body>
</html>