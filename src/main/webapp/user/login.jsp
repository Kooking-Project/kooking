<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>로그인 | KOOKING</title>    
    
<script type="text/javascript">



</script>    
    
</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="img/core-img/salad.png" alt="">
    </div>
    <!--  Preloader End -->
    
    <!-- ##### Breadcumb Area Start ##### -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/breadcumb5.jpg);">
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
				 	<c:when test ="${empty loginUser}">
				 	<!-- 아이디 / 비밀번호 폼 시작 -->
				 	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
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
										<button type="submit" class="btn delicious-small-btn m-1">확인</button>
										<a href="javascript:history.back()" class="btn delicious-small-btn btn-3">뒤로가기</a>
									</div>
								</div>								
							</fieldset>
						</form>
				 	<!-- 아이디 / 비밀번호 폼 끝 -->
				 	</c:when>
				 	<c:otherwise>
				 	
				 	</c:otherwise>
				 </c:choose>  	         
             </div>
         </div>
     </div>
</div>
    
   
</body>

</html>
<jsp:include page="../common/footer.jsp"/>   