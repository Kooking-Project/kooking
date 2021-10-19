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
</head>
<body>

<SCRIPT language=javascript>

	function checkValid() {
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
		return true;
	}
</SCRIPT>

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
		<table width="570" border="1" cellspacing="0" cellpadding="3"
			bordercolor="#000000">

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
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text name="post_title"
							size="30"></span></b></td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">*요리썸네일등록</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type="file" name="file"
							maxlength="60" size="40"></span></b></td>
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
					<option value="2">서양</option>
					<option value="3">일본</option>
					<option value="중국">중국</option>
					<option value="퓨전">퓨전</option>
					<option value="이탈리아">이탈리아</option>
					<option value="동남아시아">동남아시아</option>
			</select> <select name="recipe_type" id="recipe_type"
				onchange="SetSelectBox();">
					<option value="">음식분류</option>
					<option value="63">밑반찬</option>
					<option value="56">메인반찬</option>
					<option value="54">국/탕</option>
					<option value="55">찌개</option>
					<option value="60">디저트</option>
					<option value="53">면/만두</option>
					<option value="52">밥/죽/떡</option>
					<option value="61">퓨전</option>
					<option value="57">김치/젓갈/장류</option>
					<option value="58">양념/소스/잼</option>
					<option value="양식">양식</option>
					<option value="64">샐러드</option>
					<option value="68">스프</option>
					<option value="66">빵</option>
					<option value="69">과자</option>
					<option value="59">차/음료/술</option>
					<option value="62">기타</option>
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
				</select> <select name="cookingTime" id="cookingTime"
					onchange="SetSelectBox();">
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



			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">재료등록</span></b>
					</p>
				</td>
				<td width="450" height="20"><b> <span
						style="font-size: 9pt;"> <!-- <input type=password name="password" size="12">(글 수정, 삭제시 필요합니다.) -->
					</span></b></td>
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