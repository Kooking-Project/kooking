<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>레시피 리스트 | Kooking</title>

<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/img/core-img/kfavicon.ico">

<!-- Core Stylesheet -->

<style>
.lst_recipe {
	overflow: hidden;
	margin-bottom: 56px;
	width: 1040px;
	position: relative;
	left: -16px;
}

.inner {
	position: relative;
	width: 1024px;
	margin: auto;
}

.lst_recipe>li {
	width: 244px;
	height: 390px;
	margin: 0 0 16px 16px;
	position: relative;
	border: 1px solid #e1e1e1;
	box-sizing: border-box;
	float: left;
	background-color: #fff;
}

.lst_recipe li .thmb {
	display: block;
	margin: 4px;
	position: relative;
}

.lst_recipe li .thmb img {
	width: 234px;
	height: 234px;
	display: block;
}

.lst_recipe li .thmb:after {
	position: absolute;
	display: block;
	content: '';
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: url(/assets/_img/common/img_grad-dcde50e….png) center center
		no-repeat;
	background-size: 234px 234px;
	z-index: 1;
}

.lst_recipe li .judge {
	position: absolute;
	top: 187px;
	right: 10px;
	color: #eee;
	font-size: 13px;
	text-align: center;
	line-height: 1;
	z-index: 5;
}

.lst_recipe li .judge strong {
	font-size: 25px;
	color: #fff;
	display: block;
	font-family: Microsoft YaHei, 'NSB';
}

.lst_recipe li .author {
	text-align: center;
	width: 100%;
	z-index: 5;
	display: block;
	margin-top: -40px;
	position: relative;
}

button, a {
	outline: none;
	text-decoration: none;
	color: #444;
	padding: 0;
	margin: 0;
	cursor: pointer;
}

.lst_recipe li .author img {
	width: 61px;
	height: 61px;
	border-radius: 50%;
	overflow: hidden;
	display: block;
	margin: 0 auto 5px;
	vertical-align: middle;
}

.lst_recipe li .author strong {
	color: #808080;
	font-size: 14px;
	font-weight: normal;
}

.lst_recipe li .author strong a {
	color: #808080;
}

.lst_recipe li .author {
	text-align: center;
	width: 100%;
	z-index: 5;
	display: block;
	margin-top: -40px;
	position: relative;
}

.lst_recipe li p {
	text-align: center;
	font-size: 15px;
	font-family: Microsoft YaHei, 'NSB';
	line-height: 19px;
	letter-spacing: -0.025em;
	padding: 2px 10px 0;
	margin-bottom: 5px;
}

.lst_recipe li p a {
	color: #3b3b3b;
}

.lst_recipe li p strong {
	display: block;
	overflow: hidden;
	margin-top: 5px;
	word-break: keep-all;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: gray;
}

.lst_recipe .option {
	width: 244px;
	position: absolute;
	bottom: 0;
	height: 27px;
	border-top: 1px solid #e1e1e1;
	display: flex;
	justify-content: center;
	align-content: center;
	align-items: center;
}

.option-col {
	flex-grow: 1;
	text-align: center;
	display: flex;
	justify-content: space-evenly;
	align-items: center;
}

.option-vlaue, .option-svg {
	display: flex;
}

.option-value {
	padding-top: 5px;
}

.recipe-text{
	padding: 20px;
	font-size:20px;
	font-weight:bold;

}

.recipe-alert img{
	max-height: 40px;
	width:auto;
	padding:5px;
	margin-right:20px;
}

.recipe-alert{
	font-size:17px;
}

.pagination-link{
	font-size:25px;
	padding: 20px;
}

.pagination-link:hover, .pagination-link:focus{
	font-color : black !important;
}

.pagination-wrapper{
	text-align:center;

}

</style>
</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img
			src="${path}/img/core-img/salad.png" alt="">
	</div>



	<!-- header -->
	<jsp:include page="../common/header.jsp" />
	<div class="inner">
		<div class="alert alert-success recipe-alert">
		<img src="${path}/img/blog-img/KnifeAndFork.svg" />
		  맛있는 레시피가 <span class="text-danger">${page.total}</span>개 있어요!
		</div>
		<ul class="lst_recipe">
		<c:forEach items="${recipeList}" var="recipe" varStatus="state">
			<li><a class="call_recipe thmb" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> 
			<img src="${path}/img/${recipe.thumbnail}"
					alt="">
			</a> <span class="judge">평가점수
			<c:choose>
				<c:when test="${recipe.score}>=0">
				<strong>${recipe.score}</strong>
				</c:when>
				<c:otherwise>
				<strong>?</strong>
				</c:otherwise>
			</c:choose>
			</span> <span
				class="author"> <a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> <img
						alt="프로필 이미지"
						src="https://cloudfront.haemukja.com/vh.php?url=https://d1hk7gw6lgygff.cloudfront.net/uploads/user/image_file/1713889/thumb_profile1576666692409.jpg&amp;convert=jpgmin&amp;rt=600">
				</a> <strong><a href="${path}/front?key=search&methodName=view&no=${recipe.post.no}">${recipe.post.userNicname }</a></strong>
			</span>
				<p>
					<a class="call_recipe" href="${path}/front?key=search&methodName=view&no=${recipe.post.no}"> ${recipe.name } 
					<strong>${recipe.post.title }</strong>
					</a>
				</p>
				<div class="option">
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
		  <path
									d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
		  <path
									d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
		</svg>
						</div>
						<div class="option-value">${recipe.cookingTime}분</div>
					</div>
					<div class="option-col">
						<div class="option-svg">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
  <path
									d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z" />
</svg>
						</div>
						<div class="option-value">100명</div>
					</div>
				</div></li>
</c:forEach>

		</ul>
<div class="pagination-wrapper">
  	<c:forEach var="idx" begin="1" end="${page.pageCnt}" step="1">
		<a class="pagination-link" href="${path}/front?key=search&methodName=list&pageNum=${idx}">${idx }</a></span>
		</c:forEach>
</div>

		
</div>

	<!-- footer -->
	<jsp:include page="../common/footer.jsp" />

	<!-- ##### All Javascript Files ##### -->
	<!-- jQuery-2.2.4 js -->
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script
		src="${pageContext.request.contextPath}/js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script
		src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="${pageContext.request.contextPath}/js/plugins/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/js/active.js"></script>
</body>

</html>