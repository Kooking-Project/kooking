<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	
<body>
  <!-- \${search} =${search}<p> 레시피 게시글 가져오는 것 확인-->

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
    		onSubmit='return checkValid()' enctype="multipart/form-data">    
    <input type="hidden" name="key" value="recipe" >
    <input type="hidden" name="methodName" value="update" >
     <input type="hidden" name="postNo" value="${search.post.no}" >
      <input type="hidden" name="recipeNo" value="${search.recipe.no}" >
   	<div class="container recipe_regi">
    <div class="regi_center">
    <div class="regi_title">레시피 수정</div>
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
      		<input type="text" name="post_title" id="post_title" value="${search.post.title}" size="50" placeholder="예) 소고기 미역국 끓이기">
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
	  		<input type="text" name="recipes_name" id="recipes_name" value="${search.recipe.name}"size="50" placeholder="예) 미역국">
	  	</span>
	  </div>
	  <hr>
	  <!-- 요리제목 end -->
	
	  <!-- post_content 요리소개 start -->
      <div>
      	<p class="cont_tit4">요리소개</p>
      	<span>
      		<input type="text" name="post_content" id="post_content" value="${search.post.contents}" size="80" placeholder="이 레시피의 탄생배경을 적어주세요. 예) 남편의 생일을 맞아 소고기 미역국을 끓여봤어요." style="height:80px; resize:none;"/>
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
                            <select name="calorie" id="calorie">
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
                        <label for="calorie">칼로리</label>
             
                        
                        <div class="col-12 col-lg-3">
                            <select name="cookingTime" id="cookingTime" >
								<option value="">소요시간</option>
								<option value="5">5분이내</option>
								<option value="10">10분이내</option>
								<option value="15">15분이내</option>
								<option value="20">20분이내</option>
								<option value="30">30분이내</option>
								<option value="60">60분이내</option>
								<option value="90">90분이내</option>
								<option value="120">120분이내</option>
								<option value="150">150분이내</option>
								<option value="180">180분이내</option>
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
                            <select name="recipe_nation" id="recipe_nation" text="국가별" >
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
                            <select name="recipe_type" id="recipe_type" text="분류별" >
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
    <!-- ---------------------------------------  -->

<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<style>
.itemBox {
    width:600px;
    height:50px;
    
    margin:10px;
}
.itemBox input {
	background:#f5f5f5;
	border:1px solid #e1e1e1;
	border-radius: 4px;
	font-size:16px;
	height:50px;
	vertical-align:middle;
}
.itemBoxHighlight {
    width:400px;
    height:50px;
    padding:10px;
    margin-bottom:10px;
    
}
.deleteBox {
    float:right;
    display:none;
    cursor:pointer;
}
.buttons {
	margin: 10px;
}
</style>
<style>
#sortable { list-style-type: none; margin: 0; padding: 0; width: 400px; }
#sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
#sortable li span { position: absolute; margin-left: -1.3em; }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
<script type="text/javascript">
//<![CDATA[
/** 아이템을 등록한다. */
function submitItem() {
    if(!validateItem()) {
    	return;
    }
    alert("등록");
}
/** 아이템 체크 */
function validateItem() {
    var items = $("input[type='text'][name='item']");
    if(items.length == 0) {
        alert("작성된 아이템이 없습니다.");
        return false;
    }
    var flag = true;
    for(var i = 0; i < items.length; i++) {
        if($(items.get(i)).val().trim() == "") {
            flag = false;
            alert("내용을 입력하지 않은 항목이 있습니다.");
            break;
        }
    }
    return flag;
}
/** UI 설정 */
$(function() {
    $("#itemBoxWrap").sortable({
        placeholder:"itemBoxHighlight",
        start: function(event, ui) {
            ui.item.data('start_pos', ui.item.index());
        },
        stop: function(event, ui) {
            var spos = ui.item.data('start_pos');
            var epos = ui.item.index();
			      reorder();
        }
    });
    $("#itemBoxWrap").disableSelection();
    
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
});
/** 아이템 순서 조정 */
function reorder() {
    $(".itemBox").each(function(i, box) {
       $(box).find(".ingredient_seq").html(i + 1);
       $(box).find("[name=ingredient_seq]").val(i + 1);//eunsol - ingredient_seq 추가
       $(box).find(".itemNum");//eunsol - 실행시 드래그로 순서 가능한 부분이라 사용 가능할 것 같아요
    });
}
/** 아이템 추가 */
function createItem() {
    $(createBox())
    .appendTo("#itemBoxWrap")
    .hover(
        function() {
            $(this).css('backgroundColor', '#f9f9f5');
            $(this).find('.deleteBox').show();
        },
        function() {
            $(this).css('background', 'none');
            $(this).find('.deleteBox').hide();
        }
    )
		.append("<div class='deleteBox'>삭제</div>")
		.find(".deleteBox").click(function() {
        var valueCheck = false;
        $(this).parent().find('input').each(function() {
            if($(this).attr("name") != "type" && $(this).val() != '') {
                valueCheck = true;
            }
        });
        if(valueCheck) {
            var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
        }
        if(!valueCheck || delCheck == true) {
            $(this).parent().remove();
            reorder();
        }
    });
    // 숫자를 다시 붙인다.
    reorder();
}
/** 아이템 박스 작성 */
function createBox() {
    var contents = "<div class='itemBox'>"
                 + "<div style='float:left;'>"
                 + "<span class='ingredient_seq'></span><input type='hidden' name='ingredient_seq'>"//eunsol - <span>값을 넘길 수 없음. hidden으로 ingredient_seq 값 추가
                 + "<input type='text' name='ingredient_name' value='' style='width:200px; margin-left:15px;' placeholder='예) 돼지고기'/>"
                 + "<input type='text' name='ingredient_cacty' style='width:200px; margin-left:5px;' placeholder='예) 300g 또는 1/2개'/>"
                 + "</div>"
                 + "</div>";
    return contents;
}
//]]>
</script>

<!------------------------------------>    

    	<p class="cont_tit4">재료</p>
        <span class="guide">재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
        <br>
       <c:forEach items="${search.ingredient}" var="ingredient"> 
          <input type="hidden" value="${ingredient.no}" name="ingredient_no">
          <input type="hidden" value="${ingredient.seq}" name="ingredient_seq">
          <input type="text" value="${ingredient.name}" name="ingredient_name">
          <input type="text" value="${ingredient.cacty}" name="ingredient_cacty">
          <br>
       </c:forEach>
   	</div>
   	<hr>
   	<!-- 재료 end -->
   	
	<!-- process 요리순서 start -->
	   <p class="cont_tit4">요리순서</p>
			<span class="guide"> 요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.<br></span>
			<br>
			
	    <c:forEach items="${search.process}" var="process"> 
          <input type="hidden" value="${process.no}" name="process_no">
          <input type="text" value="${process.seq}" name="process_seq">
          <input type="text" value="${process.imageUrl}" name="processUrl">
          <input type="text" value="${process.desc}" name="process_desc">
          <input type="text" value="${process.tip}" name="process_tip">
          <br>
       </c:forEach>
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
<!-- 레시피 수정하기 End -->
    
    <!-- footer -->
    <jsp:include page="../common/footer.jsp"/>  
    
    <!-- ##### All Javascript Files ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
	
</body>
</html>