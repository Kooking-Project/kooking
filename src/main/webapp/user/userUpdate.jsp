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
<title>유저 페이지 | KOOKING</title>


<style type="text/css">

.profile,.content{
  -webkit-transition: 0.5s ease;
  -moz-transition: 0.5s ease;
    transition: 0.5s ease;
}
.profile{
  position: relative;
  top: auto;
  bottom: auto;
  left: 0;
  right: 0;
  min-height: 100%;
  height: auto;
  width: 75%;
  margin: 20px auto;
  margin-bottom: 100px;
  background-color: #fff;
  border-top: 5px solid #39cb58;
  border-radius: 0 0 5px 5px;
  box-shadow: 0 2.5px 5px #ccc;
}
.content{
  /* position: absolute; */
  min-height: 100%;
  height: 100%;
  width: 95%;
  margin: 2.5% auto;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  /*border: 1px solid #eee;*/
  /*background-color: yellow;*/
  overflow: hidden;
}
.short-info{
  position: relative;
  min-height: 100px;
  height: auto;
  width: 97.5%;
  margin: 1.5% auto;
  /*background-color: #f5f5f5;*/
  background-color: #fff;
  background-color: #f2ecee;
  /*border-top: 2px solid #39cb58;*/
  border-radius: 2.5px;
  /*box-shadow: inset 0 -1.5px #ddd;*/
}
.details{
  width: 97.5%;
  /*background-color: red;*/
  margin: 2.5px auto;
}
.tab-heads{
  color: #777;
  margin: 0 2.5px;
}
.tabs{
  height: 200px;
  width: 97.5%;
  margin: 0 auto;
  /* border-top: 2.5px solid #39cb58; */
  background-color: #f2ecee;
  border-radius: 2.5px;
  /* background-color: #f3f3f3; */
}
span.fa-envelope{
  position: absolute;
  top: 22%;
  left: 56%;
  color: #39cb58;
}
span.photo{
  position: relative;
  height: 80px;
  width: 80px;
  border-radius: 5px;
  margin: 10px 0 2.5px;
  display: block;
  top: 10%;
  left: 10%;
  overflow: hidden;
  background: #ddd url("https://www.adtechnology.co.uk/images/UGM-default-user.png");
  background-size: 100%;
  border-radius: 100%;
  border: 2px solid #ddd;
}
span.photo:after{
  content: " Add Profile Pic ";
  text-align: center;
  position: absolute;
  left: 0;
  z-index: 2;
  padding: 35% 0 65%;
  height: 0;
  width: 100%;
  opacity: 0;
  color: #222;
  background-color: rgba(0,0,0,0.25);
  background-size: 100%;
  transition: 0.35s ease-in-out;
  overflow: hidden;
  border-radius: 100%;
}
span.photo:hover:after{
  bottom: 0;
  opacity: 1;
  color: #fff;
}
input[type="file"]{
  /* position: absolute; */
  color: #555;
  font-size: 15px;
  top: 25%;
  box-shadow: none !important;
  margin-left:  !important;
  background-color: #ededed;
  width: 250px;
  border: 0;
}

span.name,span.links > h3,h4{
  font-family: Lato;
  /*font-weight: 200;*/
}
span.name{
  position: absolute;
  top: 20%;
  left: 25%;
  color: #555;
  font-size: 18px;
}
label{
  color: #555;
  line-height: 2.1em;
  margin-left: 10px;
}
label[for="avatar"]{
  line-height: 120px;
}

span.btn:hover{
  opacity: 1;
  color: #fff;
  background-color: rgba(57,203,88,1);
  /* background-color: #39cb58; */
}
.profile:hover .btn{
    opacity: 1;
}
.short-info span h3,h4{
  display: inline-block;
  margin: 0;
}

div.circles{
  width: 100%;
  margin: 0 auto;
}
span.fa-users{
  color: #777;
  margin-left: 1px;
  margin: 7px 7px 2.5px;
}
span.fa-users:after{
  content: "Circles";
  font-family: Lato;
  margin-left: 3px;
  color: #777;
}
.myCircle{
  height: 200px;
  width: 97.5%;
  margin: 0 auto;
  background-color: #f2ecee;
  border-radius: 2.5px;
}

/*Circles Styles
=========================*/
.myCircle #tabs ul li:nth-child(1){
  margin: 0;
  padding: 0px 5px 10px;
  /*margin-top: 5px;*/
  background-color: white;
  border-radius: 0 0 0 30px;
}
.myCircle #tabs ul li:nth-child(2){
  margin-left: -3px;
  padding: 0 5px 10px;
  border-radius: 0 0 30px 0;
  background-color: white;
}
.myCircle #tabs .active{
  border-bottom: none;
  padding-left: 10px;
}
.myCircle #tabs{
  padding: 0;
  margin: 0;
}
.fa-twitter,.fa-facebook,.fa-github{
  height: 20px;
  width: 20px;
  text-align: center;
  line-height: 20px;
  padding: 2.5px;
  margin-left: -15px;
}

/*Input Fields Styles
=========================*/
fieldset textarea,input{
  font-family: Open Sans;
  font-size: 15px;
  color: #333;
  background-color: #f7f7f7;
  box-shadow: 0 0 0 1px #39cb58;
  padding: 5px;
  width: 75%;
  margin: 5px auto;
  border: 0;
  border-radius: 2.5px;
  outline: 0;
  transition: 0.3s ease;
}
fieldset textarea{
  min-height: 40px;
  max-height: 60px;
}
fieldset textarea:hover,input:hover{
  box-shadow: 0 0 0 1px #39cb58;
  background-color: #fff;
}
fieldset textarea:focus,input:focus{
  box-shadow: 0 0 0 1px #39cb58,
              inset 0 2px 5px -1px rgba(0,0,0,0.25);
}

.grid-35{
  width: 35%;
  float: left;
  font-weight: 500;
  color: #333;
  /* text-align: left; */
}
.grid-65{
  position: relative;
  width: 65%;
  float: right;
  font-weight: 300;
  font-size: 17px;
}
#tabs-1 div,#tabs-2 div,#tabs-3 div{
  border-bottom: 1px solid #ddd;
}

/*Tabs Styles
=========================*/
#tabs {
  width: 97.5%;
  margin: 0 auto;
  position: relative;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
    transition: all 0.5s ease;
}
#tabs-1,#tabs-2,#tabs-3{
  width: 95%;
  margin: 0 auto;
  /*margin-top: 5px;*/
  padding: 5px 10px;
  line-height: 1.3em;
  padding-bottom: 10px;
  font-family: Open Sans;
  background-color: #f2ecee;
  border-radius: 0 2.5px 2.5px 2.5px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  transition: all 0.5s ease;
} 
#tabs ul{
  margin: 0 auto;
  padding: 0;
}
#tabs ul li{
  display: inline-block;
  margin: 0;
  padding: 0 7px;
  width: 65px;
  text-align: center;
  padding-bottom: 5px;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
     transition: all 0.5s ease;  
}
#tabs ul li a{
  outline: 0;
  text-decoration: none;
  padding: 0 3px 0 0;
  /* background-color: #222; */
  font-family: Open Sans;
  margin: 0;
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
     transition: all 0.5s ease;
}

.ui-state-hover{
  border-bottom: 2.5px solid #aaa;
}
.ui-state-active{
  color: #38cc85;
  border-bottom: 2.5px solid #39cb58;
}

/* #CLEARFIX HACK
=========================*/
.clear:after{
  content: " ";
  display: table;
  clear: both;
}

/* Edit View
======================*/
.content h1{
  text-align: center;
  color: #555;
  font-size: 40px;
  font-weight: bold;
  margin: 5px auto 15px auto;
}
select{
  width: 80%;
  padding: 7px 10px;
  background-color: #f5f5f5;
  border: 1px solid #39cb58;
  border-radius: 2.5px;
  outline: 0;
}
select option{
  padding: 5px;
}
fieldset{
  text-align: center;
  /* background-color: rgba(0,0,0,0.01); */
  margin-bottom: 5px;
  padding: 5px;
  box-sizing: border-box;
  border-bottom: 1px solid rgba(0,0,0,0.07);
}
fieldset:last-child{
  border-bottom: none;
}
input.Btn{
  width: 48%;
  float: left;
  display: block;
  margin: 40px auto;
  margin-left: 1%;
  padding: 15px 0;
  font-size: 16px;
  color: #fff;
  cursor: pointer;
  background-color: rgba(57,203,88,0.65);
  box-shadow: inset 0 0 0 2px #39cb58,
              0 2px 0 0 rgba(57,203,88,0.5);
  transition: 0.5s ease;
}
input.Btn:hover{
  background-color: rgba(57,203,88,1);
}

/* Header Bar 
===========================*/
.navbar{
  padding: 10px;
  box-shadow: 0 2.5px 10px rgba(0,0,0,0.5);
}
div.logo{
/*    margin: 0 auto;*/
/*    text-align: center;*/
    font-size: 30px;
    font-family:"Source Sans Pro";
    color:#39cb58;
    width: 100%;
/*    display: inline-block;*/
    /*    position: absolute;*/
/*    top:0px;*/
/*    left:0;*/
    right: 0;
    z-index: 2;
}
span.logo-part{
    color:#fff;
    background-color: #39cb58;
    padding: 2px 5.5px 0px 10px;
    border-radius:100%;
    margin-bottom:15px;
}
.search{
/*    margin-top:5px;
/*    border:0;*/
    float: left;
    position: relative;
    top:4px;
    right: 100px;
    padding-bottom: 0;
}
.search-bar{
/*    border:0;*/
    width:220px;
    color:white;
    background-color:#eee;
    border-top: 2px solid black;
    padding: 5px;
    padding-left: 15px;
    display: inline;
    border-radius: 50px;
    -webkit-transition: 0.4s ease;
                transition: 0.4s ease;
}
.search-icon{
    color:gray;
    margin-left:-27.5px;
}
.search-bar:focus{
    width:255px;
    outline:none;
}
.navbar-nav li a{
  padding-left: 8.5px;
  padding-right: 8.5px;
  font-size: 12px;
  transition: 0.5s ease;
}
.navbar-nav li a > span.fa:before{
  margin-right: 5px;
  /* background-color: #ddd; */
}



/*Media Queries
=========================*/
@media only screen and (min-width: 768px){ /*Desktop*/
  .profile{ 
    width: 450px;
  }
  .search{
    float: none;
    /* top: 0; */
    left: 0;
    right: 0;
    margin: 0 auto;
  }
}
@media only screen and (max-width: 768px){ /*Tablet*/
  .profile{ 
    width: 70%;
  }
  .search{
    top: 0;
    left: 0;
    right: 0;
    display: block;
    margin: 0 auto;
  }
}
@media only screen and (min-width: 320px) and (max-width: 520px){ /*Phone*/
  .profile{
    width: 90%;
  }
}
     
.wrapper .profile .content .grid-65 #gender_select{
  position: relative;
  width: 80%;
  height: 37px;
  padding-left: 35px;
}

.wrapper .profile .content .grid-65 #gender_select:before{
  content: "";
  position: absolute;
  top: 12px;
  right: 10px;
  border: 8px solid;
  border-color: #d5dbd9 transparent transparent transparent;
  pointer-events: none;
}

.wrapper .profile .content .grid-65 #gender_select .select{
  -webkit-appearance: none;
  -moz-appearance:   none;
  appearance:        none;
  outline: none;
  width: 203.52px;
  height: 40px;
  line-height: 25px;
  border: 0px;
  padding: 8px 10px;
  font-size: 15px;
  border: 1px solid #d5dbd9;
  border-radius: 3px;
  background-color: #ffffff;
}

h5{
	text-align: center;
	color: blue;
}

</style>
<script type="text/javascript">

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

$("#registerBtn").attr('disabled', false); 	

$("#idCheck").text(result);

if(result == "중복 되는 아이디입니다."){

$("#registerBtn").attr('disabled', true); 					
}
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

$("#registerBtn").attr('disabled', false); 	

$("#nickNameCheck").text(result);

if(result == "중복 되는 닉네임입니다."){

$("#registerBtn").attr('disabled', true); 					
}

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

$("#registerBtn").attr('disabled', false); 	

$("#passwordCheck").text(result);

if(result == "암호가 일치하지 않습니다."){

$("#registerBtn").attr('disabled', true); 					
}

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
						<h2 style="font-style: italic">프로필 업데이트</h2> <!-- 여기도 본인 페이지면 마이페이지 문구 아니면 다른 문구 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->




	<!-- UserPage Start -->


<div class="wrapper">
  <div class="profile">
    <div class="content">
      <h1>프로필 수정</h1>
      <h5>수정을 원하는 칸만 입력하신 후,</h5>
       <h5>변경 하시면 됩니다.</h5>
      <form action="">
        <!-- 프로필 사진 -->
        <fieldset>
          <div class="grid-35">
            <label for="avatar">프로필 사진</label>
          </div>
          <div class="grid-65">
            <span class="photo" title="프로필 사진 변경"></span>
            <input type="file" class="btn" />
          </div>
        </fieldset>
        <fieldset>
          <div class="grid-35">
            <label for="fname">아이디</label>
          </div>
          <div class="grid-65">
            <input type="text" id="id" tabindex="1" disabled/>
          </div>
        </fieldset>
        <fieldset>
          <div class="grid-35">
            <label for="lname">닉네임</label>
          </div>
          <div class="grid-65">
            <input type="text" id="nickName" tabindex="2" />
          </div>
        </fieldset>
        <!-- 비밀번호 -->
        <fieldset>
          <div class="grid-35">
            <label for="location">이전 비밀번호</label>
          </div>
          <div class="grid-65">
            <input type="password" id="currentPwd" tabindex="4" />
          </div>    
        <!-- 새 비밀번호 -->
          <div class="grid-35">
            <label for="location">새 비밀번호</label>
          </div>
          <div class="grid-65">
            <input type="password" id="newPwd" tabindex="4" />
          </div>
        <!-- 새 비밀번호 재입력 -->
          <div class="grid-35">
            <label for="country">새 비밀번호 재입력</label>
          </div>
          <div class="grid-65">
            <input type="password" id="newPwdConfirm" tabindex="5" />
          </div>
        </fieldset>
        <!-- 성별 -->
        <fieldset>
          <div class="grid-35">
            <label for="qualification">성별</label>
          </div>
          <div class="grid-65">
             <div class="gender_select" id="gender_select">
           	 <select class="select" name="gender" id="gender">
             	<option value="" disabled selected>선택</option>
           	   	<option value="1">남자</option>
          	    <option value="2">여자</option>
          	    <option value="0">비공개</option>
         	 </select>
          </div>
          </div>
        </fieldset>
        <fieldset>
          <input type="submit" class="btn delicious-small-btn m-1" value="변경" />
          <input type="button" class="btn delicious-small-btn btn-3" value="취소" />
        </fieldset>
      </form>
    </div>
  </div>
</div>
</body>

</html>
<jsp:include page="../common/footer.jsp" />
