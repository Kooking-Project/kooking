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
      <div class="cont_line pad_b_25"><p class="cont_tit4">요리소개</p><textarea name="cok_intro" id="cok_intro" class="form-control step_cont" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요. 어머니로부터 배운 미역국 레시피를 남편의 입맛에 맞게 고안했습니다." style="height:100px; width:610px; resize:none;"></textarea></div>

	  

      <div class="cont_line"><p class="cont_tit4">카테고리</p>
        <div class="container">
                <form action="#" method="post">
                    <div class="row">
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category1" id="receipe_category1" text="종류별">
                                <option value="" >종류별</option><option value="63">밑반찬</option>
								<option value="56">메인반찬</option>
								<option value="54">국/탕</option>
								<option value="55">찌개</option>
								<option value="60">디저트</option>
								<option value="53">면/만두</option>
								<option value="52">밥/죽/떡</option>
								<option value="61">퓨전</option>
								<option value="57">김치/젓갈/장류</option>
								<option value="58">양념/소스/잼</option>
								<option value="65">양식</option>
								<option value="64">샐러드</option>
								<option value="68">스프</option>
								<option value="66">빵</option>
								<option value="69">과자</option>
								<option value="59">차/음료/술</option>
								<option value="62">기타</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category2" id="receipe_category2" text="상황별">
                                <option value="" >상황별</option><option value="12">일상</option>
								<option value="18">초스피드</option>
								<option value="13">손님접대</option>
								<option value="19">술안주</option>
								<option value="21">다이어트</option>
								<option value="15">도시락</option>
								<option value="43">영양식</option>
								<option value="17">간식</option>
								<option value="45">야식</option>
								<option value="20">푸드스타일링</option>
								<option value="46">해장</option>
								<option value="44">명절</option>
								<option value="14">이유식</option>
								<option value="22">기타</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category3" id="receipe_category3" text="방법별">
                                <option value="" >방법별</option><option value="6">볶음</option>
								<option value="1">끓이기</option>
								<option value="7">부침</option>
								<option value="36">조림</option>
								<option value="41">무침</option>
								<option value="42">비빔</option>
								<option value="8">찜</option>
								<option value="10">절임</option>
								<option value="9">튀김</option>
								<option value="38">삶기</option>
								<option value="67">굽기</option>
								<option value="39">데치기</option>
								<option value="37">회</option>
								<option value="11">기타</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="receipe_category4" id="receipe_category4" text="재료별">
                                <option value="" >재료별</option><option value="70">소고기</option>
								<option value="71">돼지고기</option>
								<option value="72">닭고기</option>
								<option value="23">육류</option>
								<option value="28">채소류</option>
								<option value="24">해물류</option>
								<option value="50">달걀/유제품</option>
								<option value="33">가공식품류</option>
								<option value="47">쌀</option>
								<option value="32">밀가루</option>
								<option value="25">건어물류</option>
								<option value="31">버섯류</option>
								<option value="48">과일류</option>
								<option value="27">콩/견과류</option>
								<option value="26">곡류</option>
								<option value="34">기타</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
		<span class="guide" style="margin:20px 0 20px 40px;">분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</span>
      	</div>
      	
      	<div class="cont_line"><p class="cont_tit4">요리정보</p>
      	<div class="container">
                <form action="#" method="post">
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
                </form>
            </div>
           </div>
            
    </div><!--/cont_box-->
    <div class="cont_box pad_l_60">
    	<div class="cont_line"><p class="cont_tit4">재료</p>
        <span class="guide mag_b_15" style="width:100%;">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
        <jsp:include page="receipeMeterial.jsp"/>
		<div class="mag_b_25" id="divMaterialGroupArea"></div>
    	</div><!--/cont_box-->
   	</div>
    <div class="cont_box pad_l_60">
      <input type="file" name="file" id="multifile_1" file_gubun="step" style="display:none;" multiple/>
      <p class="cont_tit4">요리순서
      </p>
	  <span class="guide mag_b_15"><b>요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.</b><br>
		예) 10분간 익혀주세요 ▷ 10분간 약한불로 익혀주세요.<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;마늘편은 익혀주세요 ▷ 마늘편을 충분히 익혀주셔야 매운 맛이 사라집니다.<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;꿀을 조금 넣어주세요 ▷ 꿀이 없는 경우, 설탕 1스푼으로 대체 가능합니다.
	  </span>
      <div id="divStepArea"></div>
      <!-- step template -->
      <div id="divStepTemplate" style="display:none">
          <div id="divStepItem_STEP" class="step">
            <p id="divStepNum_STEP" class="cont_tit2_1" style="cursor:pointer">Step 1</p>
            <div id="divStepText_STEP" style="display:inline-block">
                <textarea name="step_text[]" id="step_text_STEP" class="form-control step_cont" placeholder="" style="height:160px; width:430px; resize:none;"></textarea>
            </div>
            <div id="divStepUpload_STEP" style="display:inline-block">
                <input type="hidden" name="step_no[]" id="step_no_STEP" value="">
                <input type="hidden" name="step_photo[]" id="step_photo_STEP" value="">
                <input type="hidden" name="new_step_photo[]" id="new_step_photo_STEP" value="">
                <input type="hidden" name="del_step_photo[]" id="del_step_photo_STEP" value="">
                <div style="position:absolute;left:-3000px"><input type="file" name="q_step_file_STEP" id="q_step_file_STEP" file_gubun="step" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text=""></div>
                <div id="divStepPhotoBox_STEP" is_over="0">
                    <img id="stepPhotoHolder_STEP" onclick="browseStepFile(__STEP)" src="https://recipe1.ezmember.co.kr/img/pic_none2.gif" width="160" height="160" style="cursor:pointer">
                </div>
            </div>
            <div id="divStepBtn_STEP" class="step_btn" style="display:none">
                <a href="javascript:void(0)"><span class="glyphicon glyphicon-chevron-up moveUp"></span></a>
                <a href="javascript:void(0)"><span class="glyphicon glyphicon-chevron-down moveDown"></span></a>
                <a href="javascript:adjustStep(__STEP)"><b>맞춤</b></a>
                <a href="javascript:addStep(__STEP)"><span class="glyphicon glyphicon-plus"></span></a>
                <a href="javascript:delStep(__STEP)"><span class="glyphicon glyphicon-remove"></span></a>
            </div>
            <div style="width:580px;border:2px solid #74b243;margin:5px 200px 5px;">
          <div style="padding:5px;">
              <a href="javascript:void(0);" id="stepBtn_material_STEP" class="btn btn-xs btn-default" style="width:70px;height:26px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_material.png" style="width:16px;height:16px;"> 재료</a>
              <a href="javascript:void(0);" id="stepBtn_cooker_STEP" class="btn btn-xs btn-default" style="width:70px;height:26px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_tool.png?v.1" style="width:16px;height:16px;"> 도구</a>
              <a href="javascript:void(0);" id="stepBtn_fire_STEP" class="btn btn-xs btn-default" style="width:70px;height:26px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_fire.png?v.1" style="width:16px;height:16px;"> 불</a>
              <a href="javascript:void(0);" id="stepBtn_tip_STEP" class="btn btn-xs btn-default" style="width:70px;height:26px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_tip.png?v.1" style="width:16px;height:16px;"> 팁</a>
                            <a href="javascript:void(0);" id="stepBtn_all_STEP" class="btn btn-xs btn-default" style="width:70px;height:26px;"> 전 체 </a>
              <a href="javascript:openStepGuide();" id="stepBtn_guide_STEP" class="btn btn-xs btn-default" style="width:160px;height:26px; border:none; background:#4f9a13; color:#fff; padding:6px 7px 4px;">추가기능을 넣어보세요!!</a>

              <div id="stepForm_material_STEP" style="display:none;margin:5px 5px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_material.png" style="width:24px;height:24px;"> <input type="text" name="step_material[]" id="step_material_STEP" placeholder="밀가루 100g,소금 2큰술,물 100g" class="form-control step_cont" style="width:500px;height:24px;"></div>
              <div id="stepForm_cooker_STEP" style="display:none;margin:5px 5px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_tool.png?v.1" style="width:24px;height:24px;"> <input type="text" name="step_cooker[]" id="step_cooker_STEP" placeholder="국자,볼" class="form-control step_cont" style="width:500px;height:24px;"></div>
              <div id="stepForm_fire_STEP" style="display:none;margin:5px 5px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_fire.png?v.1" style="width:24px;height:24px;"> <input type="text" name="step_fire[]" id="step_fire_STEP" placeholder="약불" class="form-control step_cont" style="width:500px;height:24px;"></div>
              <div id="stepForm_tip_STEP" style="display:none;margin:5px 5px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_tip.png?v.1" style="width:24px;height:24px;vertical-align:top;"> <textarea name="step_tip[]" id="step_tip_STEP" class="form-control step_cont" style="width:500px;height:50px;resize:none;"></textarea></div>
              <div id="stepForm_video_STEP" style="display:none;margin:5px 5px;"><img src="https://recipe1.ezmember.co.kr/img/mobile/app_icon_step_video.png" style="width:24px;height:24px;"> <input type="text" name="step_video[]" id="step_video_STEP" placeholder="양파 다듬는 법" class="form-control step_cont" style="width:380px;height:24px;">
                        <input type="text" name="step_video_seq[]" id="step_video_seq_STEP" placeholder="6816284" class="form-control step_cont" style="width:100px;height:24px;"></div>
          </div>
            </div>

          </div>
      </div><!--/step template-->

      <div class="btn_add mag_b_25" style="padding:0 0 20px 180px; width:820px;"><button type="button" onclick="addStep()" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span>순서추가</button></div>


      <p class="cont_tit4">요리완성사진
    	  <input type="file" name="file" id="multifile_2" file_gubun="work" style="display:none;" multiple/>
		  <br><button type="button" onclick="document.getElementById('multifile_2').click();" class="btn-sm btn-default"><span class="glyphicon glyphicon-plus"></span> 사진 한번에 넣기</button>
	  </p>
      <div id="divWorkArea" style="display:inline-block">
                <div id="divWorkUpload_1" class="complete_pic">
            <input type="hidden" name="work_photo[]" id="work_photo_1" value="">
            <input type="hidden" name="new_work_photo[]" id="new_work_photo_1" value="">
            <input type="hidden" name="del_work_photo[]" id="del_work_photo_1" value="">
            <div style="position:absolute;left:-3000px"><input type="file" name="q_work_file_1" id="q_work_file_1" file_gubun="work" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text=""></div>
            <div id="divWorkPhotoBox_1" is_over="0">
                <a href="#" class="pic_del" style="display:none"></a>
                <img id="workPhotoHolder_1" onclick="browseWorkFile(1)" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="No Image" style="width: 140px; height: 140px; cursor:pointer">
            </div>
        </div>
                <div id="divWorkUpload_2" class="complete_pic">
            <input type="hidden" name="work_photo[]" id="work_photo_2" value="">
            <input type="hidden" name="new_work_photo[]" id="new_work_photo_2" value="">
            <input type="hidden" name="del_work_photo[]" id="del_work_photo_2" value="">
            <div style="position:absolute;left:-3000px"><input type="file" name="q_work_file_2" id="q_work_file_2" file_gubun="work" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text=""></div>
            <div id="divWorkPhotoBox_2" is_over="0">
                <a href="#" class="pic_del" style="display:none"></a>
                <img id="workPhotoHolder_2" onclick="browseWorkFile(2)" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="No Image" style="width: 140px; height: 140px; cursor:pointer">
            </div>
        </div>
                <div id="divWorkUpload_3" class="complete_pic">
            <input type="hidden" name="work_photo[]" id="work_photo_3" value="">
            <input type="hidden" name="new_work_photo[]" id="new_work_photo_3" value="">
            <input type="hidden" name="del_work_photo[]" id="del_work_photo_3" value="">
            <div style="position:absolute;left:-3000px"><input type="file" name="q_work_file_3" id="q_work_file_3" file_gubun="work" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text=""></div>
            <div id="divWorkPhotoBox_3" is_over="0">
                <a href="#" class="pic_del" style="display:none"></a>
                <img id="workPhotoHolder_3" onclick="browseWorkFile(3)" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="No Image" style="width: 140px; height: 140px; cursor:pointer">
            </div>
        </div>
                <div id="divWorkUpload_4" class="complete_pic">
            <input type="hidden" name="work_photo[]" id="work_photo_4" value="">
            <input type="hidden" name="new_work_photo[]" id="new_work_photo_4" value="">
            <input type="hidden" name="del_work_photo[]" id="del_work_photo_4" value="">
            <div style="position:absolute;left:-3000px"><input type="file" name="q_work_file_4" id="q_work_file_4" file_gubun="work" accept="jpeg,png,gif" style="display:;width:0px;height:0px;font-size:0px;" text=""></div>
            <div id="divWorkPhotoBox_4" is_over="0">
                <a href="#" class="pic_del" style="display:none"></a>
                <img id="workPhotoHolder_4" onclick="browseWorkFile(4)" src="https://recipe1.ezmember.co.kr/img/pic_none3.gif" alt="No Image" style="width: 140px; height: 140px; cursor:pointer">
            </div>
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