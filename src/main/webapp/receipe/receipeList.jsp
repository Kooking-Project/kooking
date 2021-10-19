<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Delicious - Food Blog Template | Blog Post</title>

<!-- Favicon -->
<link rel="icon" href="${pageContext.request.contextPath}/img/core-img/kfavicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet" href="../style.css">

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img src="${pageContext.request.contextPath}/img/core-img/salad.png"
			alt="">
	</div>

	<!-- header -->
	<jsp:include page="../common/header.jsp" />

	<!-- Receipe Post Search -->
        <div class="receipe-post-search section-padding-20">
            <div class="container">
                <form action="#" method="post">
                    <div class="row">
                        <div class="col-12 col-lg-3">
                            <select name="select1" id="select1">
                                <option value="1">All Receipies Categories</option>
                                <option value="1">All Receipies Categories 2</option>
                                <option value="1">All Receipies Categories 3</option>
                                <option value="1">All Receipies Categories 4</option>
                                <option value="1">All Receipies Categories 5</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <select name="select1" id="select2">
                                <option value="1">All Receipies Categories</option>
                                <option value="1">All Receipies Categories 2</option>
                                <option value="1">All Receipies Categories 3</option>
                                <option value="1">All Receipies Categories 4</option>
                                <option value="1">All Receipies Categories 5</option>
                            </select>
                        </div>
                        <div class="col-12 col-lg-3">
                            <input type="search" name="search" placeholder="찾고싶은 레시피를 입력하세요.">
                        </div>
                        <div class="col-12 col-lg-3 text-right">
                            <button type="submit" class="btn delicious-btn">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
	
	<!-- ##### 레시피 목록 start ##### -->
	<div class="blog-area section-padding-80">
		<div class="container">
			<div class="row">
				<div class="col-12 col-lg-8">
					<div class="blog-posts-area">

						<!-- Single Blog Area -->
						<div class="single-blog-area mb-80">
							<!-- Thumbnail -->
							<div class="blog-thumbnail">
								<a href="receipeRead.jsp"><img src="${pageContext.request.contextPath}/img/blog-img/1.jpg"
									alt=""></a>
								<!-- Post Date -->
								<div class="post-date">
									<a href="#"><span>05</span>April <br> 2018</a>
								</div>
							</div>
							<!-- Content -->
							<div class="blog-content">
								<a href="receipeRead.jsp" class="post-title">레시피 이름</a>
								<div class="meta-data">
									by <a href="#">작성자명(클릭시 작성자 프로필 이동)</a> | 한식/양식/중식/일식
								</div>
								<a href="receipeRead.jsp"><p>레시피 설명 : 버섯으로 관자 느낌 내는 방법!
										새송이버섯간장버터구이 만들기</p></a> <a href="receipeRead.jsp"
									class="btn delicious-btn">레시피 보러가기</a>
							</div>
						</div>

						<!-- Single Blog Area -->
						<div class="single-blog-area mb-80">
							<!-- Thumbnail -->
							<div class="blog-thumbnail">
								<a href="receipeRead.jsp"><img src="${pageContext.request.contextPath}/img/blog-img/1.jpg"
									alt=""></a>
								<!-- Post Date -->
								<div class="post-date">
									<a href="#"><span>05</span>April <br> 2018</a>
								</div>
							</div>
							<!-- Content -->
							<div class="blog-content">
								<a href="receipeRead.jsp" class="post-title">레시피 이름</a>
								<div class="meta-data">
									by <a href="#">작성자명(클릭시 작성자 프로필 이동)</a> | 한식/양식/중식/일식
								</div>
								<a href="receipeRead.jsp"><p>레시피 설명 : 버섯으로 관자 느낌 내는 방법!
										새송이버섯간장버터구이 만들기</p></a> <a href="receipeRead.jsp"
									class="btn delicious-btn">레시피 보러가기</a>
							</div>
						</div>

						<!-- Single Blog Area -->
						<div class="single-blog-area mb-80">
							<!-- Thumbnail -->
							<div class="blog-thumbnail">
								<a href="receipeRead.jsp"><img src="${pageContext.request.contextPath}/img/blog-img/1.jpg"
									alt=""></a>
								<!-- Post Date -->
								<div class="post-date">
									<a href="#"><span>05</span>April <br> 2018</a>
								</div>
							</div>
							<!-- Content -->
							<div class="blog-content">
								<a href="receipeRead.jsp" class="post-title">레시피 이름</a>
								<div class="meta-data">
									by <a href="#">작성자명(클릭시 작성자 프로필 이동)</a> | 한식/양식/중식/일식
								</div>
								<a href="receipeRead.jsp"><p>레시피 설명 : 버섯으로 관자 느낌 내는 방법!
										새송이버섯간장버터구이 만들기</p></a> 
								<a href="receipeRead.jsp" class="btn delicious-btn">레시피 보러가기</a>
							</div>
						</div>

					</div>

					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item active"><a class="page-link" href="#">01.</a></li>
							<li class="page-item"><a class="page-link" href="#">02.</a></li>
							<li class="page-item"><a class="page-link" href="#">03.</a></li>
						</ul>
					</nav>
				</div>

				<div class="col-12 col-lg-4">
					<div class="blog-sidebar-area">

						<!-- 정렬기능 버튼 -->
						<div class="single-widget mb-80">
							<h6>총 <span class="receipeCount">0000</span>개의 맛있는 레시피가 있습니다!</h6>
							<ul class="list">
								<li><a href="#">이름순</a></li>
								<li><a href="#">평점순</a></li>
								<li><a href="#">날짜순</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### 레시피 목록 End ##### -->

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