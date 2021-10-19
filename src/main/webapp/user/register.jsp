<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>회원가입 | KOOKING</title>


<style type="text/css">
#registerBody {
	background: #fec107;
	padding: 0 10px;
}

.wrapper {
	max-width: 500px;
	width: 100%;
	background: #D6ACF2;
	margin: 50px auto;
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.125);
	padding: 30px;
	border: 5px solid;
	border-color: #592918;
}

.wrapper .title {
	font-size: 24px;
	font-weight: 700;
	margin-bottom: 25px;
	color: #592918;
	text-transform: uppercase;
	text-align: center;
}

.wrapper .form {
	width: 100%;
}

.wrapper .form .inputfield {
	margin-bottom: 15px;
	display: flex;
	align-items: center;
}

.wrapper .form .inputfield label {
	width: 200px;
	color: #592918;
	margin-right: 10px;
	font-size: 14px;
	font-weight: bold;
}

.wrapper .form .inputfield .input, .wrapper .form .inputfield .textarea
	{
	width: 100%;
	outline: none;
	border: 1px solid #d5dbd9;
	font-size: 15px;
	padding: 8px 10px;
	border-radius: 3px;
	transition: all 0.3s ease;
}

.wrapper .form .inputfield .textarea {
	width: 100%;
	height: 125px;
	resize: none;
}

.wrapper .form .inputfield #gender_select {
	position: relative;
	width: 100%;
	height: 37px;
}

.wrapper .form .inputfield #gender_select:before {
	content: "";
	position: absolute;
	top: 12px;
	right: 10px;
	border: 8px solid;
	border-color: #d5dbd9 transparent transparent transparent;
	pointer-events: none;
}

.wrapper .form .inputfield #gender_select .select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	outline: none;
	width: 297.97px;
	height: 40px;
	line-height: 25px;
	border: 0px;
	padding: 8px 10px;
	font-size: 15px;
	border: 1px solid #d5dbd9;
	border-radius: 3px;
	background-color: #ffffff;
}

.wrapper .form .inputfield .input:focus, .wrapper .form .inputfield .textarea:focus,
	.wrapper .form .inputfield #gender_select .select:focus {
	border: 1px solid #fec107;
}

.wrapper .form .inputfield p {
	font-size: 14px;
	color: #757575;
}

.wrapper .form .inputfield .check {
	width: 15px;
	height: 15px;
	position: relative;
	display: block;
	cursor: pointer;
}

.wrapper .form .inputfield .check input[type="checkbox"] {
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
}

.wrapper .form .inputfield .check .checkmark {
	width: 15px;
	height: 15px;
	border: 1px solid #fec107;
	display: block;
	position: relative;
}

.wrapper .form .inputfield .check .checkmark:before {
	content: "";
	position: absolute;
	top: 1px;
	left: 2px;
	width: 5px;
	height: 2px;
	border: 2px solid;
	border-color: transparent transparent #fff #fff;
	transform: rotate(-45deg);
	display: none;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~
	.checkmark {
	background: #fec107;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~
	.checkmark:before {
	display: block;
}

.wrapper .form .inputfield .btn {
	width: 100%;
	padding: 8px 10px;
	font-size: 15px;
	border: 0px;
	background: #F2DDD5;
	color: #592918;
	cursor: pointer;
	border-radius: 3px;
	outline: none;
	font-weight: bold;
}

.wrapper .form .inputfield .btn:hover {
	background: #ffd658;
}

.wrapper .form .inputfield:last-child {
	margin-bottom: 0;
}

@media ( max-width :420px) {
	.wrapper .form .inputfield {
		flex-direction: column;
		align-items: flex-start;
	}
	.wrapper .form .inputfield label {
		margin-bottom: 5px;
		font-weight: bold;
	}
	.wrapper .form .inputfield.terms {
		flex-direction: row;
	}
}

.explanation {
	text-align: right;
}

.explanation p {
	font-size: 12px;
	color: #F2594B;
}
</style>

<script type="text/javascript">

function checkValid() {
    var f = window.document.registerForm;
		
	if ( f.id.value == "") {
	    alert( "사용하실 아이디를 입력해 주세요!" );
	    f.id.focus();
		return false;
    }
	if ( f.nickName.value == "" ) {
		alert( "사용하실 닉네임을 입력해 주세요!" );
		f.nickName.focus();
		return false;
	}
	if ( f.pwd.value == "" ) {
		alert( "사용하실 비밀번호를 입력해 주세요!" );
		f.pwd.focus();
		return false;
	}
	if ( f.pwdConfirm.value == "" ) {
        alert( "사용하실 비밀번호를 한번 더 입력해 주세요!" );
        f.pwdConfirm.focus();
        return false;
    }
	if ( f.gender.value == "" ) {
        alert( "성별을 선택해 주세요!" );
        f.gender.focus();
        return false;
    }
	
    return true;
}



$(function(){
		
//////////////////////////////////////////////////
	// 아이디 중복체크하기
	$("#id").keyup(function(){
		  
		  if($(this).val == ""){
			  $("#idCheck").text("");
			  return; // 함수를 빠져나가라.
		  }
		  
			$.ajax({
				
				url : "../idCheck", //서버요청주소
				type : "post", //method방식(get, post, put, delete)
				dataType : "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
				data : {id: $(this).val()},	//서버에게 보낼 parameter정보
				success : function(result){
					console.log("result : " + result);
					
					$("#idCheck").text(result);
					
				},	// 성공했을때 callback 함수
				error :	function(err){ 					
					alert(err+"발생했어요");
					
				}//실패했을 때 함수
			}); //ajax끝
	});

	/////////////////////////////////////////////////
	
	//////////////////////////////////////////////////
	// 닉네임 중복체크하기
	$("#nickName").keyup(function(){
		  
		  if($(this).val == ""){
			  $("#nickNameCheck").text("");
			  return; // 함수를 빠져나가라.
		  }
		  
			$.ajax({
				
				url : "../nickNameCheck", //서버요청주소
				type : "post", //method방식(get, post, put, delete)
				dataType : "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
				data : {nickName: $(this).val()},	//서버에게 보낼 parameter정보
				success : function(result){
					
					$("#nickNameCheck").text(result);
					
				},	// 성공했을때 callback 함수
				error :	function(err){ 					
					alert(err+"발생했어요");
					
				}//실패했을 때 함수
			}); //ajax끝
	});

	/////////////////////////////////////////////////
	
		//////////////////////////////////////////////////
	// 패스워드 중복체크하기
	$("#pwdConfirm").keyup(function(){
		  
		  if($(this).val == ""){
			  $("#passwordCheck").text("");
			  return; // 함수를 빠져나가라.
		  }
		  
			$.ajax({
				
				url : "../passCheck", //서버요청주소
				type : "post", //method방식(get, post, put, delete)
				dataType : "text", //서버가 응답해주는 데이터의 type(text, html, xml, json)
				data : {pwdConfirm: $(this).val(), pwd: $("#pwd").val()},	//서버에게 보낼 parameter정보
				success : function(result){
					
					$("#passwordCheck").text(result);
					
				},	// 성공했을때 callback 함수
				error :	function(err){ 					
					alert(err+"발생했어요");
					
				}//실패했을 때 함수
			}); //ajax끝
	});

	/////////////////////////////////////////////////

});




</script>


</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img src="${pageContext.request.contextPath}/img/core-img/salad.png"
			alt="">
	</div>
	<!--  Preloader End -->


	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(${pageContext.request.contextPath}/img/bg-img/breadcumb5.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcumb-text text-center">
						<h2 style="font-style: italic">회원가입을 통해 더 많은 기능과 혜택을 누리세요~!</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- register form start -->
	<form class="form-horizontal" name="registerForm" method="post" action="${pageContext.request.contextPath}/front" onSubmit='return checkValid()'>
		<input type="hidden" name="key" value="user" /> 
		<input type="hidden" name="methodName" value="insert" />
		<div class="wrapper">
			<div class="title">회원가입</div>
			<div class="form">
				<div class="inputfield">
					<label>아이디</label> <input type="text" class="input" id="id" name="id">
				</div>
				<div class="explanation">
					<p class="idCheck" id="idCheck">아이디는 최대 10글자까지 입력 가능합니다.</p>
				</div>
				<div class="inputfield">
					<label>닉네임</label> <input type="text" class="input" id="nickName" name="nickName">
				</div>
				<div class="explanation">
					<p class="nickNameCheck" id="nickNameCheck">닉네임은 최대 10글자까지 입력 가능합니다.</p>
				</div>
				<div class="inputfield">
					<label>비밀번호</label> <input type="password" class="input" id="pwd" name="pwd">
				</div>
				<div class="inputfield">
					<label>비밀번호 확인</label> <input type="password" class="input" id="pwdConfirm" name="pwdConfirm">
				</div>
				<div class="explanation">
					<p class="passwordCheck" id="passwordCheck">정확하게 일치하도록 입력 해주십시오.</p>
				</div>
				<div class="inputfield">
					<label>성별</label>
					<div class="gender_select" id="gender_select">
						<select class="select" name="gender" id="gender">
							<option value="" disabled selected>선택</option>
							<option value="1">남자</option>
							<option value="2">여자</option>
							<option value="0">비공개</option>
						</select>
					</div>
				</div>
				<input type="hidden" name="profileImg" value="" />
				<div class="inputfield">
					<input type="submit" value="가입" class="btn">&nbsp;&nbsp; 
					<a href="javascript:history.back()" class="btn">돌아가기</a>
				</div>
			</div>
		</div>
	</form>

</body>

</html>
<jsp:include page="../common/footer.jsp" />
