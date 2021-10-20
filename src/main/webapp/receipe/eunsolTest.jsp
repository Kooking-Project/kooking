<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/img/core-img/kfavicon.ico">

<!-- Title -->
<title>레시피 등록하기 | Kooking</title>
<style type="text/css">
.image_container {
  width: 70%;
  height: 200px;
  overflow: hidden;
}
.image_container img {
  max-width: 100%;
  height: auto;
  display: block;
}
</style>

<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.min.js"></script>
</head>
<body>

<script language=javascript>

/*	function checkValid() {
		var f = window.document.writeForm;

		if (f.post_title.value == "") {
			alert("게시글 제목을 입력해 주세요.");
			f.post_title.focus();
			return false;
		}
		if (f.recipe_name.value == "") {
			alert("레시피이름을 입력해 주세요.");
			f.recipe_name.focus();
			return false;
		}
		if (f.post_content.value == "") {
			alert("요리에 대한 설명을 입력해 주세요.");
			f.post_content.focus();
			return false;
		}
		if (f.post_content.value == "") {
			alert("요리소개를 입력해 주세요.");
			f.model_name.focus();
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
			alert('재료순서를 맞춰 주세요.');
			$("#ingredient_seq").focus();
			return isSubmit = false;
		}
		if ($("#ingredient_name").val() == '') {
			alert('재료용량을 선택해 주세요.');
			$("#ingredient_name").focus();
			return isSubmit = false;
		}
		if ($("#ingredient_cacty").val() == '') {
			alert('요리시간을 선택해 주세요.');
			$("#ingredient_cacty").focus();
			return isSubmit = false;
		}
		return true;
	}*/
	
	function SetSelectBox(){
	    var schField = $("#SetSelectBox(); option:selected").text(); // 제목, 작성자
	}
	function SetSelectBox(){
	    var schField = $("#itemBox(); option:selected").text(); // 제목, 작성자
	}
    
	// 등록 이미지 등록 미리보기
	function readInputFile(input) {
	    if(input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            $('#preview').html("<img src="+ e.target.result +">");
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	 
	$(".inp-img").on('change', function(){
	    readInputFile(this);
	});
	// 등록 이미지 삭제 ( input file reset )
	function resetInputFile($input, $preview) {
	    var agent = navigator.userAgent.toLowerCase();
	    if((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1)) {
	        // ie 일때
	        $input.replaceWith($input.clone(true));
	        $preview.empty();
	    } else {
	        //other
	        $input.val("");
	        $preview.empty();
	    }       
	}
	 
	$(".btn-delete").click(function(event) {
	    var $input = $(".inp-img");
	    var $preview = $('#preview');
	    resetInputFile($input, $preview);
	});

	function setThumbnail(event) { for (var image of event.target.files) { var reader = new FileReader(); reader.onload = function(event) { var img = document.createElement("img"); img.setAttribute("src", event.target.result); document.querySelector("div#image_container").appendChild(img); }; console.log(image); reader.readAsDataURL(image); } }

</script>

</HEAD>
<BODY>

	<form name="writeForm" method="post"
		action="${path}/front?key=recipe&methodName=insert"
		onSubmit='return checkValid()' enctype="multipart/form-data">
		<!-- 
     아래 문장으로 전송하면 post방식으로 전송이되고 현재 파일업로드때문에 enctype="multipart/form-data" 설정되어 있기때문에 
     request로 값을 받을수가 없다. ( MulitpartRequest로 받아야한다.) 그런데 Controller로 가기전에 Controller를 찾기위해서 
     DispatherServlet에서 request로 두개의 값을 받고 있기때문에 key, methodName은 get방식으로 별도로 전송해야한다.
     
	<input type="hidden" name="key" value = "elec" />
	<input type="hidden" name="methodName" value = "insert" />  

 -->
		<table width="570" border="1" cellspacing="0" cellpadding="3" bordercolor="#000000">

			<tr>
				<td width="1220" height="20" colspan="2" bgcolor="#00cc00">
					<p align="center">
						<font color="white" size="3"><b>레시피를 등록하세요!</b></font>
					</p>
				</td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">게시글제목</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span style="font-size: 9pt;"> 
				<input type=text name="post_title" size="30"></span></b></td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">*요리썸네일등록</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span style="font-size: 9pt;"> 
			      		<input type="file" name="recipe_thumbnail" class="inp-img" accept="image/*" onchange="setThumbnail(event);" width=""/>
						<div id="image_container" ></div>
			      		<span class="btn-delete">삭제</span>
			      	</span>
				</td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">레시피이름</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text
							name="recipe_name" size="30"></span></b></td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">요리소개</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text
							name="post_content" size="30"></span></b></td>
			</tr>
			<td bgcolor="#FFCCCC" class="normalbold" width="179">
				<div align="center">카테고리</div>
			</td>
			<td colspan="3"><select name="recipe_nation" id="recipe_nation"
				onchange="SetSelectBox();">
					<option value="">국가별</option>
					<option value="한식">한식</option>
					<option value="서양">서양</option>
					<option value="일본">일본</option>
					<option value="중국">중국</option>
					<option value="퓨전">퓨전</option>
					<option value="이탈리아">이탈리아</option>
					<option value="동남아시아">동남아시아</option>
			</select> <select name="recipe_type" id="recipe_type"
				onchange="SetSelectBox();">
					<option value="">음식분류</option>
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
			</select> <select name="recipe_level" id="recipe_level"
				onchange="SetSelectBox();">
					<option value="">난이도</option>
					<option value="아무나">아무나</option>
					<option value="초보환영">초보환영</option>
					<option value="보통">보통</option>
					<option value="어려움">어려움</option>
					<option value="신의경지">신의경지</option>
			</select></td>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">요리정보</span></b>
					</p>
				</td>
				<td width="150" height="20"><select name="calorie" id="calorie"
					onchange="SetSelectBox();">
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
				</select> <select name="cookingTime" id="cookingTime"onchange="SetSelectBox();">
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
			</tr>
				<!-- 재료등록 start -->
			<tr>
				<td width="200" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">재료등록</span></b>
					</p>
				</td>
				<td width="450" height="20">
				<span class="guide mag_b_15" style="width: 100%;"> 재료가 남거나 부족하지 않도록 정확한 계량정보를 적어주세요.</span>
					<div class="mag_b_25" id="divMaterialGroupArea"></div> <jsp:include
						page="eunsolTest2.jsp" /></td>
			</tr>
				<!-- 재료등록 END -->
			<tr>
				<td width="200" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">조리과정등록</span></b>
					</p>
				</td>
				<td width="450" height="20">
				<span class="guide mag_b_15" style="width: 100%;"> 요리의 맛이 좌우될 수 있는 중요한 부분은 빠짐없이 적어주세요.<br></span>
					<div class="mag_b_25" id="divMaterialGroupArea"></div> 
					<script type="text/javascript">
					let index=0;
				const add_textbox = () => {
				    const box = document.getElementById("processAddbtn");
				    const newP = document.createElement('div');
				    newP.innerHTML ="<input type='file' name='process_url"+ index++ +"' maxlength='60' size='40' style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'>"
				    + "<span class='process_seq'></span><input type='hidden' name='process_seq' value='"+index +"'>"
				    + "<input type='text' name='process_desc' style='width:610px; margin:10px;' placeholder='예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.'>"
				    + "<input type='text' name='process_tip' style='width:610px; margin:10px;' placeholder='요리 tip! 예) 위가 살짝 노릇할정도만 구워야 속이 쫀득합니다.'>"
				    + "<input type='button' value='삭제' onclick='remove(this)'>";
				    box.appendChild(newP);
				}
				const remove = (obj) => {
				    document.getElementById('processAddbtn').removeChild(obj.parentNode);
				}
			</script>
			<!-- 요리순서 SCRIPT END -->
			<div id="processAddbtn">
	      	 <input type="button" id="addItem" value="추가하기" onclick="add_textbox();" />
					</td>
			</tr>
		
			<tr>
				<td width="450" height="20" colspan="2" align="center"><b><span
						style="font-size: 9pt;"><input type=submit value=글쓰기>
							<input type=reset value=다시쓰기></span></b></td>
			</tr>

		</table>

	</form>

	<hr>
	<div align=right>
		<span style="font-size: 9pt;">&lt;<a href="${path}/front">리스트로 돌아가기</a>&gt;
		</span>
	</div>


</body>
</html>