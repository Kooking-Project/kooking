<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

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

<!-- Core Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">

<!-- JQuery 2.2.4 -->
<script
	src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>

<!-- BootStrap 5.1 -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>


<script src="${pageContext.request.contextPath}/js/plugins/plugins.js"></script>

<style type="text/css">
.loginUser{

	font-size: 13px;
	font-weight: bold;
}

</style>

</head>

<body>

	<!-- Search Wrapper -->
    <div class="search-wrapper">
        <!-- Close Btn -->
        <div class="close-btn"><i class="fa fa-times" aria-hidden="true"></i></div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="#" method="post">
                        <input type="search" name="search" placeholder="레시피를 검색하세요...">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
   
    

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">

        <!-- Top Header Area -->
        <div class="top-header-area">
            <div class="container h-100">
                <div class="row h-100 align-items-center justify-content-between">
                    <!-- Breaking News -->
                    <div class="col-12 col-sm-6">
                        <div class="breaking-news">
                            <div id="breakingNewsTicker" class="ticker">
                                <ul>
                                    <li><a href="#">쿠킹에 오신 것을 환영합니다!</a></li>
                                    <li><a href="#">다양한 레시피가 준비 되어 있습니다!</a></li>
                                    <li><a href="#">쿠킹과 함께 즐거운 식사 어떠실까요?</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!-- Top Social Info -->
                    <div class="col-12 col-sm-6">
                        <div class="top-social-info text-right">
		                    <c:choose>
						 		<c:when test ="${empty userDTO}"> 
		                            <a href="${pageContext.request.contextPath}/user/login.jsp">로그인</a>
		                            <a href="${pageContext.request.contextPath}/user/register.jsp">회원가입</a>
		                            <a href="${pageContext.request.contextPath}/receipe/receipeWrite.jsp">글쓰기</a>
		   				 		</c:when>
						 		<c:otherwise>
						 			<span>${userDTO.nickName}님 환영합니다!!</span>
						 			<a href="#">글쓰기</a>
						 			<a href="${pageContext.request.contextPath}/front?key=user&methodName=logout">로그아웃</a>
						 		</c:otherwise>
						 	</c:choose>  	 
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Navbar Area -->
        <div class="delicious-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="deliciousNav">

                        <!-- Logo -->
                        <a class="nav-brand" href="${pageContext.request.contextPath}/index2.jsp"><img src="${pageContext.request.contextPath}/img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- close btn -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li class="active"><a href="${pageContext.request.contextPath}/index2.jsp">Home</a></li>
                                    <li><a href="#">분류별</a>
                                        <div class="megamenu">
                                            <ul class="single-mega cn-col-4">
                                                <li class="title">Category</li>
                                                <li><a href="resu">Home</a></li>
                                                <li><a href="about.html">About Us</a></li>
                                                <li><a href="blog-post.html">Blog Post</a></li>
                                                <li><a href="receipe-post.html">Receipe Post</a></li>
                                                <li><a href="contact.html">Contact</a></li>
                                                <li><a href="elements.html">Elements</a></li>
                                            </ul>
                                            <ul class="single-mega cn-col-4">
                                                <li class="title">Catagory</li>
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="about.html">About Us</a></li>
                                                <li><a href="blog-post.html">Blog Post</a></li>
                                                <li><a href="receipe-post.html">Receipe Post</a></li>
                                                <li><a href="contact.html">Contact</a></li>
                                                <li><a href="elements.html">Elements</a></li>
                                            </ul>
                                            <ul class="single-mega cn-col-4">
                                                <li class="title">Catagory</li>
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="about.html">About Us</a></li>
                                                <li><a href="blog-post.html">Blog Post</a></li>
                                                <li><a href="receipe-post.html">Receipe Post</a></li>
                                                <li><a href="contact.html">Contact</a></li>
                                                <li><a href="elements.html">Elements</a></li>
                                            </ul>
                                            <div class="single-mega cn-col-4">
                                                <div class="receipe-slider owl-carousel">
                                                    <a href="#"><img src="img/bg-img/bg1.jpg" alt=""></a>
                                                    <a href="#"><img src="img/bg-img/bg6.jpg" alt=""></a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="#">국가별</a>
                                        <ul class="dropdown">
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">한식</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">양식</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">중식</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">일식</a></li>
                                            <li><a href="#">Dropdown</a>
                                                <ul class="dropdown">
                                                    <li><a href="index.html">Home</a></li>
                                                    <li><a href="about.html">About Us</a></li>
                                                    <li><a href="blog-post.html">Blog Post</a></li>
                                                    <li><a href="receipe-post.html">Receipe Post</a></li>
                                                    <li><a href="contact.html">Contact</a></li>
                                                    <li><a href="elements.html">Elements</a></li>
                                                    <li><a href="#">Dropdown</a>
                                                        <ul class="dropdown">
                                                            <li><a href="index.html">Home</a></li>
                                                            <li><a href="about.html">About Us</a></li>
                                                            <li><a href="blog-post.html">Blog Post</a></li>
                                                            <li><a href="receipe-post.html">Receipe Post</a></li>
                                                            <li><a href="contact.html">Contact</a></li>
                                                            <li><a href="elements.html">Elements</a></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="#">난이도별</a>
                                        <ul class="dropdown">
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">상</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">중</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">하</a></li>
                                        </ul>
                                    </li>
                                     <li><a href="#">평점별</a>
                                        <ul class="dropdown">
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">★★★★★</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">★★★★☆</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">★★★☆☆</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">★★☆☆☆</a></li>
                                            <li><a href="${pageContext.request.contextPath}/receipe/receipeList.jsp">★☆☆☆☆</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/front">커뮤니티</a>
                                    </li>
                                    	<c:choose>
                                   		<c:when test="${userDTO.status == 10}">
                                   			<li><a href="${pageContext.request.contextPath}/front?key=admin&methodName=adminInfoByNo&userNo=${userDTO.no}&adminNo=${userDTO.no}">마이 페이지</a></li>
                                   			
                                  		 </c:when>
                                   		<c:otherwise>
                                   			<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=userInfoByNo&userNo=${userDTO.no}">마이 페이지</a></li>
                                   		</c:otherwise> 
                                   		</c:choose>
                                </ul> 
                                <!-- Newsletter Form -->
                                <div class="search-btn">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </div>

                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

</body>

</html>