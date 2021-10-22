<%@page import="com.kooking.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<!-- Favicon -->
    <link rel="icon" href="img/core-img/kfavicon.ico">
    
    <!-- Title -->
    <title>receipeRead</title>    
    
    <style>

    .contact-form-area{
    	padding:30px;
    }
    </style>
</head>

<body>
	<!-- header -->
	<jsp:include page="${pageContext.request.contextPath}/../common/header.jsp"/>
	
    <!-- Preloader -->
    <div id="preloader">
        <i class="circle-preloader"></i>
        <img src="${pageContext.request.contextPath}/img/core-img/salad.png" alt="">
    </div>


    <!-- ##### 레시피 제목 ##### -->
    <div class="breadcumb-area bg-img bg-overlay mb-80" style="background-image: url(${pageContext.request.contextPath}/img/bg-img/breadcumb3.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="breadcumb-text text-center">
                        <h2>${wrapper.post.title}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### 레시피 제목 End ##### -->

    <div class="receipe-post-area">

        

        <!-- Receipe Slider -->
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="receipe-slider owl-carousel">
                        <img src="${path}/img/${wrapper.recipe.thumbnail}" alt="">
                        <img src="${path}/img/${wrapper.recipe.thumbnail}" alt="">
                        <img src="${path}/img/${wrapper.recipe.thumbnail}" alt="">
                    </div>
                </div>
            </div>
        </div>

        <!-- Receipe Content Area -->
        <div class="receipe-content-area">
            <div class="container">

                <div class="row">
                    <div class="col-12 col-md-8">
                        <div class="receipe-headline my-5">
                            <span>${wrapper.post.user.nickName }님의 레시피</span>
                            <h2>${wrapper.post.title } 
	<c:if test="${not empty userDTO and userDTO.no eq wrapper.post.userNo}">
                            <a href="#"> 수정</a><a href="#"> 삭제</a>
                            </c:if>
                            </h2>
                            <div class="receipe-duration">
                            	<h6>요리이름 : ${wrapper.recipe.name}</h6>
                                <h6>소요시간 : ${wrapper.recipe.cookingTime}</h6>
                                <h6>칼로리 : ${wrapper.recipe.calorie}</h6>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-4">
                        <div class="receipe-ratings text-right my-5">
                            <div class="ratings">
                            <script>
                            	$(function(){
                            		let l = ${score};
                            		if(l<=-1){
                            			$(".ratings").text("아직 평가가 없어요!");
                            		}else{
                            			for(let i=0; i<parseInt(l); i++){
                            				$(".ratings").append($('<i class="fa fa-star" aria-hidden="true"></i>'));
                            			}
                            			
                            		}
                            	})
                            
                            </script>
                            </div>
                            <a href="#" class="btn delicious-btn">즐겨찾기 추가</a>
                        </div>
                    </div>
                </div>

                <div class="row">
                <div class="col-8">
                <c:forEach items="${wrapper.process}" var="process" varStatus="status">
                <div class="col-12">
                        <!-- 요리순서 -->
                        <div class="single-preparation-step d-flex">
                            <h4>${status.count}</h4>
                            <img src="${path}/img/${process.imageUrl}" class="img-fluid" style="width:200px; height: 200px;"/>
                            <p>${process.desc}</p>
                            
                        </div>
                    </div>
                </c:forEach>
</div>

					
				
                    <!-- Ingredients -->
                    <div class="col-4">
                        <div class="ingredients float-right">
                            <h4>재료</h4>
							<c:forEach items="${wrapper.ingredient}" var="ing" varStatus="state">
	                                <p >${ing.seq}. ${ing.name } : ${ing.cacty}</p>
							</c:forEach>
                        </div>
                    </div>
                </div>
				<!-- 댓글 start -->
                <div class="row">
                    <div class="col-12">
                    <hr>
                        <div class="section-heading text-left">
                            <h3>댓글</h3>
                            <c:if test="${empty wrapper.comments}">
						등록된 댓글이 없습니다.
					</c:if>
                        </div>
                        <hr>
                    </div>

                </div>
                <!-- 댓글리스트 start -->
               

                        

                        <!-- 댓글 content -->
							 <c:forEach items="${wrapper.comments}" varStatus="status" var="comment">
							  <div class="col-12">
							                     <div class="single-small-comments-area d-flex">
                        <!-- 사용자 프로필 이미지 -->
                        <div class="receipe-thumb">
                             <img src="${pageContext.request.contextPath}/img/bg-img/sr1.jpg" alt="">
                        </div>
                        <div class="comments-content">
                        	<h4 class="comments-heading">
                        		<b class="user-id">사용자ID</b>
                        		&nbsp; 날짜 ${comment.date}
                        		<span>|</span>
                        		<a href="#">답글</a>
                        		<!-- 로그인시 보여야 하는 부분 -->
                        		<c:if test="${not empty userDTO and userDTO.no eq comment.userNo}">
                        		<span>|</span>
                        		<a href="#">수정</a>
                        		<span>|</span>
                        		<a href="#">삭제</a>
                        		</c:if>
                        	</h4>
                        	${comment.content }
                            
                          
                        </div>
                    </div>
                </div>
                    </c:forEach>
                <!-- 댓글리스트 end -->
				
				<!-- 댓글 등록 start -->
                <div class="row">
                    <div class="col-12">
                        <div class="contact-form-area">
                            <form action="#" method="post">
                                <div class="row">

                                    <div class="col-12">
                                        <textarea name="message" class="form-control" id="message" cols="30" rows="10" placeholder="댓글을 입력하세요..."></textarea>
                                    </div>
                                    <div class="col-12">
                                        <button class="btn delicious-btn mt-20" type="submit">등록</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 댓글 end -->
            </div>
        </div>
    </div>
    
    
    

    <!-- footer -->
    <jsp:include page="../common/footer.jsp"/>

</body>

</html>