<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/common/header.jsp" />
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
<title>Home | KOOKING</title>



<style type="text/css">
.main-body {
	padding: 15px;
}

.card {
	box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0
		rgba(0, 0, 0, .06);
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid rgba(0, 0, 0, .125);
	border-radius: .25rem;
}

.card-body {
	flex: 1 1 auto;
	min-height: 1px;
	padding: 1rem;
	height: 351.63px;
}

.gutters-sm {
	margin-right: -8px;
	margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
	padding-right: 8px;
	padding-left: 8px;
}

.mb-3, .my-3 {
	margin-bottom: 1rem !important;
}

.bg-gray-300 {
	background-color: #e2e8f0;
}

.h-100 {
	height: 100% !important;
}

.shadow-none {
	box-shadow: none !important;
}

span {
	font-weight: bold;
}

/* 게시판 */

/* 링크 색상 (중요하지 않음) */
a {
	text-decoration: none;
	color: #333;
}

a:hover {
	color: #F2594B;
}

/* 테이블 색상 (중요하지 않음) */
table {
	width: 100%;
	/* 	margin: 40px auto 10px; */
	border-collapse: collapse;
}

th {
	background: #77ACF2;
	color: #ffffff;
}

td, th {
	border: 1px solid #dbdbdb;
	padding: 5px 20px;
	font-size: 12px;
	text-align: center;
	color: #592918;
}

tr {
	background: #F2DDD5;
}
</style>


</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<i class="circle-preloader"></i> <img src="img/core-img/salad.png"
			alt="">
	</div>
	<!--  Preloader End -->

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb-area bg-img bg-overlay"
		style="background-image: url(img/bg-img/breadcumb5.jpg);">
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

	<!--  마이 페이지 / 유저 페이지를 나눌까? -->

	<!-- user Start -->

	<div class="container">
		<div class="main-body">

			<div class="row gutters-sm">
				<div class="col-md-4 mb-3">
					<!-- Breadcrumb -->
					<div aria-label="breadcrumb" class="main-breadcrumb">
						<div class="breadcrumb">
							<span style="text-align: left">유저 정보</span> <a
								href="userUpdate.jsp" class="btn delicious-Xsmall-btn btn-3">프로필
								수정</a>
						</div>
					</div>
					<!-- /Breadcrumb -->
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
									alt="Admin" class="rounded-circle" width="150">
								<div class="mt-3">
									<h4>닉네임</h4>
									<!-- 마이 페이지로 들어갔으면 내 닉네임 아니면 다른 사람 닉네임  -->
									<p class="text-secondary mb-1">성별</p>
									<p class="text-muted font-size-sm">성별이 들어갈 부분입니다.</p>
									<h5>어서오세요!</h5>
								</div>
							</div>
						</div>
					</div>
					<div class="card mt-3"></div>
				</div>

				<div class="col-md-8">
					<!-- Breadcrumb -->
					<div aria-label="breadcrumb" class="main-breadcrumb">
						<div class="breadcrumb">
							<span style="text-align: right">작성한 댓글 리스트</span>
						</div>
					</div>
					<!-- /Breadcrumb -->
					<div class="card mb-3">
						<div class="card-body">
							<!--  여기에 -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main-body">

			<!-- 어드민이면 정지 기능 보여라 -->

			<c:if test="${loginUser} == admin">

				<div aria-label="breadcrumb" class="main-breadcrumb">
					<div class="breadcrumb">
						<span style="text-align: left">유저 Status 메뉴</span>

						<form name=Form method=post action="/front">
							<input type="hidden" name="key" value="user"> 
							<input type="hidden" name="methodName" value="update"> 
							<input type='hidden' name='userNo' value="${elec.modelNum}">
							<input type='hidden' name='userStatus' value="${elec.modelNum}">

							<button type="submit" class="btn btn-info" style="background-color: red">정지</button>
						</form>

						<form name=Form method=post action="${path}/front"
							onSubmit="return checkValid()">
							<input type="hidden" name="key" value="user"> 
							<input type="hidden" name="methodName" value="update"> 
							<input type='hidden' name='userNo' value="${elec.modelNum}">
							<input type='hidden' name='userStatus' value="${elec.modelNum}">

							<div aria-label="breadcrumb" class="main-breadcrumb">
								<div class="breadcrumb">
									<span style="text-align: left">유저 Status 메뉴</span>&nbsp;&nbsp;&nbsp;
									<a class="btn btn-info " target="__blank"
										href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills">해제</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</c:if>
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">즐겨찾기 한 레시피 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">
				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<!--  여기에 -->

						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">작성한 레시피 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body">
							<!-- 여기에 -->

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="main-body">
			<!-- Breadcrumb -->
			<div aria-label="breadcrumb" class="main-breadcrumb">
				<div class="breadcrumb">
					<span style="text-align: left">작성한 커뮤니티 글 리스트</span>
				</div>
			</div>
			<!-- /Breadcrumb -->

			<div class="row gutters-sm">

				<div class="col-md-12">
					<div class="card mb-3">
						<div class="card-body"
							style="text-align: center; position: relative;">
							<table>
								<tr>
									<th>번호</th>
									<th>카테고리</th>
									<th>제목</th>
									<th>날짜</th>
									<th>조회수</th>
								</tr>
								<tr>
									<td>1</td>
									<td><a href="#">Q&A</a></td>
									<td><a href="#">고라니탕을 만들려고 직접 고라니를 잡으러가는대여...</a></td>
									<td>2019.10.14</td>
									<td>11</td>
								</tr>
								<tr>
									<td>2</td>
									<td><a href="#">TIP</a></td>
									<td><a href="#">선생님 잠자고 싶어요...ㅠㅠ</a></td>
									<td>2019.10.14</td>
									<td>152</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">후기</a></td>
									<td><a href="#">으악 살려줘!!!</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
								<tr>
									<td>33333</td>
									<td><a href="#">후기</a></td>
									<td><a href="#">점심 나가서 먹을것 가태!!!!!!!!!!</a></td>
									<td>2019.10.14</td>
									<td>7777</td>
								</tr>
							</table>
							<a class="btn" href="#">&lt;&lt;</a> <a class="btn" href="#">&lt;</a>
							<a class="btn number" href="#">1</a> <a class="btn number"
								href="#">2</a> <a class="btn number on" href="#">3</a> <a
								class="btn number" href="#">4</a> <a class="btn number" href="#">5</a>
							<a class="btn" href="#">&gt;</a> <a class="btn" href="#">&gt;&gt;</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
<jsp:include page="/common/footer.jsp" />
