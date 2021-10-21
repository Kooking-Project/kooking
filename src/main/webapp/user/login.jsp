<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../common/header.jsp"/>    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>로그인 | KOOKING</title>    
    
<script type="text/javascript">


function checkValid() {
    var f = window.document.loginForm;
		
	if ( f.id.value == "") {
	    alert( "아이디를 입력해 주세요." );
	    f.id.focus();
		return false;
    }
	if ( f.pwd.value == "" ) {
		alert( "비밀번호를 입력해 주세요." );
		f.pwd.focus();
		return false;
	}
	
    return true;
}


</script>    
    
</head>

<body>
    
    <!-- ##### Breadcumb Area Start ##### -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(${pageContext.request.contextPath}/img/bg-img/breadcumb5.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-text text-center">
                        <h2>로그인</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcumb Area End ##### -->

<div class = "enterInfo">
     <div class="container">
         <div class="row">
             <div class="col-12">           
             <c:choose>
				 	<c:when test ="${empty userDTO.id}">
				 	<!-- 아이디 / 비밀번호 폼 시작 -->
				 	<form class="form-horizontal" name="loginForm" id="loginForm" method="post" action="../front">
				 		<input type="hidden" name="key" value = "user" /> 
						<input type="hidden" name="methodName" value = "login" />
				 	<fieldset>
								<P>
								<div class="form-group text-center d-flex justify-content-lg-center">
<!-- 									<label for="userId" class="col-lg-2 control-label"></label> -->
									<div class="col-lg-6">
										<input type="text" class="form-control col-lg-12" id="id" name="id"
											placeholder="아이디">
									</div>
								</div>
								<p>
								<div class="form-group text-center d-flex justify-content-lg-center">
<!-- 									<label for="pwd" class="col-lg-2 control-label"></label> -->
									<div class="col-lg-6">
										<input type="password" class="form-control col-lg-12" id="pwd" name="pwd"
											placeholder="비밀번호">
									</div>
								</div>
								<p>
								<div class="form-group text-center d-flex justify-content-lg-center">
									<div class="col-lg-6">
    	  								<input class="btn delicious-btn" type=submit value="등록" style=" border:0px transparent solid; font-weight: bold; color: #fff;">
										<a href="javascript:history.back()" class="btn delicious-btn" style=" border:0px transparent solid; font-weight: bold; color: #fff;">뒤로가기</a>
									</div>
								</div>								
							</fieldset>
						</form>
				 	<!-- 아이디 / 비밀번호 폼 끝 -->
				 	</c:when>
				 	<c:otherwise>
				 		<h1 style="text-align: center">${userDTO.nickName} 님 환영합니다!!</h1>
				 	</c:otherwise>
				 </c:choose>  	         
             </div>
         </div>
     </div>
</div>
    
   
</body>

</html>
<jsp:include page="../common/footer.jsp"/>   